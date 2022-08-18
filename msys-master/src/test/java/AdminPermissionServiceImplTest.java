import com.chaossnow.ms.service.AdminPermissionService;
import com.chaossnow.ms.service.AdminRoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Set;

/**
 * @author chaos
 * @ClassName AdminPermissionServiceImplTest
 * @date 2022年08月06日 21:16
 * @Version 1.0
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations= {"classpath*:spring-beans.xml","classpath*:springmvc.xml"})
public class AdminPermissionServiceImplTest {

    @Autowired
    private AdminRoleService adminRoleService;

    @Autowired
    private AdminPermissionService adminPermissionService;
    @Test
    public void listPermissionURL() {
        Set<String> permissionAPIs = adminPermissionService.listPermissionURLsByUser("admin");

        for(String api:permissionAPIs){
            System.out.println(api);
        }
    }
}
