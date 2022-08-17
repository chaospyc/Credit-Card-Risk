import com.chaossnow.ms.dao.AdminRoleDao;
import com.chaossnow.ms.pojo.AdminRole;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chaos
 * @ClassName AdminRoleDaoTest
 * @date 2022年08月06日 20:31
 * @Version 1.0
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = "classpath:spring-beans.xml")
public class AdminRoleDaoTest {

    @Autowired
    private AdminRoleDao adminRoleDao;

    @Test
    public void getAdminRoleDao() {
        List<Integer> list = adminRoleDao.listRolesByUser("test");
        System.out.println(list.toString());
    }

    @Test
    public void dummy() {
        List<Integer> list = Arrays.asList(1, 2);
        List<Long> longList = list.stream().map(i -> Long.parseLong(i.toString())).collect(Collectors.toList());
        List<AdminRole> adminRoles = adminRoleDao.findAllById(longList);
        for(AdminRole adminRole:adminRoles){
            System.out.println(adminRole.toString());
        }


    }
}