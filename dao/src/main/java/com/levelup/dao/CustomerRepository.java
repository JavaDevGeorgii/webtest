package com.levelup.dao;

import com.levelup.model.Customer;

import java.util.List;

/**
 * Created by denis_zavadsky on 2/21/15.
 */
public interface CustomerRepository {

    void createCustomer(Customer customer);

    List<Customer> getAllCustomer();

    Customer getCustomerById(Long id);
    Customer getCustomerByFirstName (String firstName);

}
