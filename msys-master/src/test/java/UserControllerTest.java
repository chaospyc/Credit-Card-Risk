import com.chaossnow.ms.controller.UserController;
import com.chaossnow.ms.pojo.AdminUserRole;
import com.chaossnow.ms.service.AdminRoleService;
import com.chaossnow.ms.service.AdminUserRoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations= {"classpath*:spring-beans.xml","classpath*:springmvc.xml"})
public class UserControllerTest {


    @Autowired
    UserController userController;


    @Autowired
    AdminRoleService  adminRoleService;

    @Autowired
    AdminUserRoleService adminUserRoleService;


    @Test
    public void dummy() {
        adminRoleService.listRolesByUser("admin");
    }

    @Test
    public void dummy2(){
        List<AdminUserRole> adminUserRoles =  adminUserRoleService.findByUid(Long.parseLong("1"));
        for(AdminUserRole u:adminUserRoles){
            System.out.println(u.toString());
        }
    }



}
