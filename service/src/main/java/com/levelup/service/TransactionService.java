package com.levelup.service;

import com.levelup.model.Transaction;

import java.util.List;

/**
 * Created by denis_zavadsky on 2/24/15.
 */
public interface TransactionService {

    List<Transaction> getTransactionsByAccountId(Long id);
    void createTransaction(Float amount, Long sourceAccountId, Long destAccountId);
}
