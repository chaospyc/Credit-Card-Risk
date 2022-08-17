import com.chaossnow.ms.dao.URLDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

/**
 * @author chaos
 * @ClassName URLDaoTest
 * @date 2022年08月06日 23:05
 * @Version 1.0
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-beans.xml")
public class URLDaoTest {

    @Autowired
    private URLDao urlDao;

    @Test
    public void getUrlDao() {
        Set<String> stringSet = urlDao.listRolesByUser("admin");
        System.out.println(stringSet.toString());
    }
}
