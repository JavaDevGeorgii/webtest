package com.levelup.service;

import com.levelup.model.Customer;

import java.util.List;

/**
 * Created by GEO on 26.02.15.
 */
public interface CustomerService {
    void createCustomer(Customer customer);

    Customer getCustomerById(Long id);
    Customer getCustomerByFirstName(String firstName);
    List<Customer> getAllCustomer();
}
