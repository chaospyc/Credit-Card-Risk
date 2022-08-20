package com.chaossnow.ms.service;

import com.chaossnow.ms.dto.CustomerVO;
import com.chaossnow.ms.result.Result;
import org.springframework.transaction.annotation.Transactional;

public interface CustomerService {
    Result addCustomer(CustomerVO customerVO);

    void deleteCustomerById(Long id);
    
    void deleteCustomerAssetByCustomerId(Long id);

    void deleteCustomerCreditById(Long id);

    void deleteCustomerByCustomerId(Long id);

    CustomerVO listAllCustomer();


}
