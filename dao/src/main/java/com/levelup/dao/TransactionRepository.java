package com.levelup.dao;

import com.levelup.model.Account;
import com.levelup.model.Transaction;

import java.util.List;

/**
 * Created by denis_zavadsky on 2/24/15.
 */
public interface TransactionRepository {

    List<Transaction> getTransactionsByAccountId(Long id);
    void createTransaction(Transaction transaction);


}
