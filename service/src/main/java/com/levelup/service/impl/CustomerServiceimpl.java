package com.levelup.service.impl;

import com.levelup.dao.CustomerRepository;
import com.levelup.dao.impl.CustomerRepositoryImpl;
import com.levelup.model.Customer;
import com.levelup.service.CustomerService;

import java.util.List;

/**
 * Created by GEO on 26.02.15.
 */
public class CustomerServiceimpl implements CustomerService {

    private CustomerRepository customerRepository = new CustomerRepositoryImpl();


    @Override
    public void createCustomer(Customer customer) {

    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.getAllCustomer();
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.getCustomerById(id);
    }

    @Override
    public Customer getCustomerByFirstName(String firstName) {
        return null;
    }


}
