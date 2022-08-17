package com.chaossnow.ms.shiro;

import com.chaossnow.ms.service.AdminPermissionService;
import com.chaossnow.ms.util.SpringContextUtils;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Set;

/**
 * @author chaos
 * @ClassName UrlPathMatchingFilter
 * @date 2022年08月05日 16:10
 * @Version 1.0
 */

public class UrlPathMatchingFilter extends PathMatchingFilter {
    @Autowired
    AdminPermissionService adminPermissionService;

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        //响应方法是OPTIONS时，不做任何处理
        if(HttpMethod.OPTIONS.toString().equals(httpServletRequest.getMethod())){
            httpServletResponse.setStatus(HttpStatus.NO_CONTENT.value());
            return true;
        }

        if(adminPermissionService == null){
            //通过反射的方式来获得Bean
            adminPermissionService = SpringContextUtils.getContext().getBean(AdminPermissionService.class);
        }

        String requestAPI = getPathWithinApplication(request);

        Subject subject = SecurityUtils.getSubject();

        //通过subject.isAuthenticated()来验证是否已登录
        if (!subject.isAuthenticated()){
            return false;
        }

        //判断访问的接口是否需要过滤（数据库中是否有对应的信息）
        boolean needFilter = adminPermissionService.needFilter(requestAPI);
        if(!needFilter){
            //接口不在数据库中需要过滤的部分，则不需要进行过滤，直接放行
            return true;
        }else{
            boolean hasPermission = false;
            String username = subject.getPrincipal().toString();
            Set<String> permissionAPIs = adminPermissionService.listPermissionURLsByUser(username);

            for (String api :permissionAPIs){
                if(requestAPI.startsWith(api)){
                    hasPermission =true;
                    break;
                }

            }
            //hasPermission 表示是不是有权限 访问 该Api
            return hasPermission;
        }
    }
}
