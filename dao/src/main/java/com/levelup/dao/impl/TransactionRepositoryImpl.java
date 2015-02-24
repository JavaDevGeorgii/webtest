package com.levelup.dao.impl;

import com.levelup.dao.HibernateSessionProvider;
import com.levelup.dao.TransactionRepository;
import com.levelup.model.Account;
import com.levelup.model.Transaction;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.proxy.HibernateProxy;

import java.util.List;

/**
 * Created by denis_zavadsky on 2/24/15.
 */
public class TransactionRepositoryImpl implements TransactionRepository {

    @Override
    public List<Transaction> getTransactionsByAccountId(Long id) {
        Session session = HibernateSessionProvider.getSession();
        session.beginTransaction();
        Account account = (Account) session.get(Account.class, id);
        //1
        account.getTransactions().size();

        //2
        Hibernate.initialize(account.getTransactions());


        //3
//        Hibernate.initialize(account);
//        List<Transaction> transactions = account.getTransactions();
//        if (transactions instanceof HibernateProxy) {
//            transactions = (List<Transaction>) ((HibernateProxy) transactions).getHibernateLazyInitializer()
//                    .getImplementation();
//        }

        session.getTransaction().commit();
        session.close();
        return account.getTransactions();
    }

    @Override
    public void createTransaction(Transaction transaction) {
        Session session = HibernateSessionProvider.getSession();
        session.beginTransaction();
        Account sourceAccount = (Account) session.get(Account.class, transaction.getSourceAccount().getId());
        Account destinationAccount = (Account) session.get(Account.class, transaction.getDestinationAccount().getId());
        transaction.setDestinationAccount(destinationAccount);
        transaction.setSourceAccount(sourceAccount);
        session.persist(transaction);
        sourceAccount.setBalance(sourceAccount.getBalance()-transaction.getAmount());
        destinationAccount.setBalance(destinationAccount.getBalance()+transaction.getAmount());
        //sourceAccount.addTransaction(transaction);
        //destinationAccount.addTransaction(transaction);
        session.merge(sourceAccount);
        session.merge(destinationAccount);
        session.getTransaction().commit();
        session.close();
    }
}
