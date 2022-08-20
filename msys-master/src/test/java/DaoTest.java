import com.chaossnow.ms.dao.CustomerAssetDao;
import com.chaossnow.ms.dao.CustomerDao;
import com.chaossnow.ms.dto.CustomerVO;
import com.chaossnow.ms.pojo.Customer;
import com.chaossnow.ms.pojo.CustomerAsset;
import com.chaossnow.ms.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.sql.Timestamp;


/**
 * @program: bankcard-master
 * @description:
 * @author: chaos
 * @create: 2022-08-20 12:43
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations= {"classpath*:spring-beans.xml","classpath*:springmvc.xml","classpath*:spring-shiro.xml"})
public class DaoTest {

    @Autowired
    private CustomerAssetDao customerAssetDao;

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private CustomerService customerService;

    @Test
    public void DaoTest() {

        Timestamp time1 = new Timestamp(2012,12,2,2,2,2,2);
        System.out.println(time1);
        CustomerVO customerVO = new CustomerVO();
        customerVO.setAddress("成都市温江区柳台大道");
        customerVO.setName("chaos");
        customerVO.setPhone("15229162016");
        customerVO.setDateBirth(time1);
        customerVO.setSex(1);
        customerVO.setDeposit(1000000);
        customerVO.setIdCard("612321199703151111");
        customerVO.setAnnualIncome(1233443);
        customerVO.setSecurities(12345313);
        customerVO.setFixAsset(1000000);

        customerService.addCustomer(customerVO);




    }
}
