package com.levelup.dao.impl;

import com.levelup.dao.CustomerRepository;
import com.levelup.dao.HibernateSessionProvider;
import com.levelup.model.Account;
import com.levelup.model.Customer;
import com.sun.tools.javac.util.List;
import org.hibernate.Session;
import org.hibernate.Query;

/**
 * Created by denis_zavadsky on 2/21/15.
 */
public class CustomerRepositoryImpl implements CustomerRepository {

    public CustomerRepositoryImpl(){};

    @Override
    public void createCustomer(Customer customer) {
        Session session = HibernateSessionProvider.getSession();
        session.beginTransaction();
        session.persist(customer);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Customer> getAllCustomer() {
        Session session = HibernateSessionProvider.getSession();
        session.beginTransaction();
        Query query=session.createQuery("from Customer c");
        List<Customer> customers= (List<Customer>)query.list();
        session.getTransaction().commit();
        session.close();
        return customers;

    }
    @Override
    public Customer getCustomerById(Long id) {
        Session session = HibernateSessionProvider.getSession();
        session.beginTransaction();
        Customer customer = (Customer) session.get(Customer.class,id);
        session.getTransaction().commit();
        session.close();
        return customer;
    }

    @Override
    public Customer getCustomerByFirstName(String firstName) {
        Session session=HibernateSessionProvider.getSession();
        session.beginTransaction();
        Customer customer= (Customer) session.get(Customer.class, firstName);
        session.beginTransaction().commit();
        session.close();
        return customer;
    }


}
