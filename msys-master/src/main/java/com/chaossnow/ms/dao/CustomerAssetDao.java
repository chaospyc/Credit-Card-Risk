package com.chaossnow.ms.dao;

import com.chaossnow.ms.pojo.CustomerAsset;

public interface CustomerAssetDao {
    void addCustomerAsset(CustomerAsset customerAsset) throws Exception;

    void deleteByCustomerId(Long customerId);
}
