package com.chaossnow.ms.dao;

import com.chaossnow.ms.pojo.Customer;

import java.util.List;

public interface CustomerDao {

    void add(Customer customer);

    Customer getCustomer();

    Customer getCustomerBylastId();

    void addCustomer(Customer customer);

    void deleteById(Long id);

    List<Customer> listCustomers();
}
