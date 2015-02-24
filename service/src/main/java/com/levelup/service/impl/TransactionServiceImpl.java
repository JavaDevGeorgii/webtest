package com.levelup.service.impl;

import com.levelup.dao.TransactionRepository;
import com.levelup.dao.impl.TransactionRepositoryImpl;
import com.levelup.model.Account;
import com.levelup.model.Transaction;
import com.levelup.service.TransactionService;

import java.util.Date;
import java.util.List;

/**
 * Created by denis_zavadsky on 2/24/15.
 */
public class TransactionServiceImpl implements TransactionService {

    private TransactionRepository transactionRepository = new TransactionRepositoryImpl();

    @Override
    public List<Transaction> getTransactionsByAccountId(Long id) {
        return transactionRepository.getTransactionsByAccountId(id);
    }

    @Override
    public void createTransaction(Float amount, Long sourceAccountId, Long destAccountId) {
        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setDate(new Date());
        Account sourceAccount = new Account();
        Account destAccount = new Account();
        sourceAccount.setId(sourceAccountId);
        destAccount.setId(destAccountId);
        transaction.setSourceAccount(sourceAccount);
        transaction.setDestinationAccount(destAccount);
        transactionRepository.createTransaction(transaction);
    }
}
