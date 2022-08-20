package com.chaossnow.ms.service.impl;

import com.chaossnow.ms.dao.CustomerAssetDao;
import com.chaossnow.ms.dao.CustomerCreditDao;
import com.chaossnow.ms.dao.CustomerDao;
import com.chaossnow.ms.dto.CustomerVO;
import com.chaossnow.ms.pojo.Customer;
import com.chaossnow.ms.pojo.CustomerAsset;
import com.chaossnow.ms.result.Result;
import com.chaossnow.ms.result.ResultFactory;
import com.chaossnow.ms.service.CustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

/**
 * @program: bankcard-master
 * @description: 客户信息接口
 * @author: chaos
 * @create: 2022-08-19 13:44
 **/
@Service
public class CustomerServiceImpl implements CustomerService {


    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private CustomerAssetDao customerAssetDao;

    @Autowired
    private CustomerCreditDao customerCreditDao;


    @Override
    @Transactional
    public void deleteCustomerById(Long id){
        customerDao.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteCustomerAssetByCustomerId(Long id){
        customerAssetDao.deleteByCustomerId(id);

    }

    @Override
    @Transactional
    public void deleteCustomerCreditById(Long id){
        customerCreditDao.deleteByCreditById(id);
    }

    /**
     * 增加消费者
     * @param customerVO
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result addCustomer(CustomerVO customerVO) {
        try{
            Customer customer = new Customer();
            CustomerAsset customerAsset = new CustomerAsset();
            BeanUtils.copyProperties(customerVO,customer);
            BeanUtils.copyProperties(customerVO,customerAsset);
            //SELECT LAST_INSERT_ID()：获得上一条新增记录的自增主键id
            customerDao.addCustomer(customer);
            customerAsset.setCustomerId(customerDao.getCustomerBylastId().getId());
            customerAssetDao.addCustomerAsset(customerAsset);
            return ResultFactory.buildSuccessResult("成功");
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ResultFactory.buildFailResult("用户添加失败");
        }
    }

    /**
     * 删除消费者
     * @param id
     */

    @Override
    @Transactional
    public void deleteCustomerByCustomerId(Long id) {
        deleteCustomerById(id);
        deleteCustomerCreditById(id);
        deleteCustomerAssetByCustomerId(id);
    }


    /**
     * 这里需要考虑到分页问题
     * @return
     */
    @Override
    public CustomerVO listAllCustomer() {
        CustomerVO customerVO = new CustomerVO();
        List<Customer> customers = customerDao.listCustomers();
        List<CustomerVO> customerVOList =
        return null;
    }
}
