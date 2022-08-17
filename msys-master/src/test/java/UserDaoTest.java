import com.chaossnow.ms.dao.UserDao;
import com.chaossnow.ms.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * @author chaos
 * @ClassName UserDaoTest
 * @date 2022年08月07日 16:26
 * @Version 1.0
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations= {"classpath*:spring-beans.xml","classpath*:springmvc.xml","classpath*:spring-shiro.xml"})
public class UserDaoTest {

    @Autowired
    private UserDao userDao;


    @Test
    public void userTest() {
        User user = new User();
        user.setPassword("sss");
        user.setPhone("32323");
        user.setName("fdsfds");
        user.setEmail("chaos_xj@email.com");
        user.setUsername("chaos");
        user.setEnabled(true);

        userDao.save(user);

    }

    @Test
    public void dummy2() {

        List<User> list = userDao.listAllUsers();
        for(User user:list){
            System.out.println(user.getEmail());
        }
    }
}
