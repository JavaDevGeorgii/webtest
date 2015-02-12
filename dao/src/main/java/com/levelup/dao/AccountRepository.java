package com.levelup.dao;

import com.levelup.model.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * Created by denis_zavadsky on 2/12/15.
 */
public class AccountRepository {

    private Session session;

    public AccountRepository() {
        SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        session = sessionFactory.openSession();

    }

    public Account getAccountById(Long id){
        Account account = (Account) session.get(Account.class,1);
        return account;
    }

}
