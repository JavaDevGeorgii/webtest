package com.levelup.webtest.servlets;

import com.levelup.service.TransactionService;
import com.levelup.service.impl.TransactionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by denis_zavadsky on 2/24/15.
 */
public class TransactionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String amount = request.getParameter("amount");
        String sourceAccountId = request.getParameter("sourceAccountId");
        String destAccountId = request.getParameter("destAccountId");

        TransactionService transactionService = new TransactionServiceImpl();
        transactionService.createTransaction(Float.parseFloat(amount),Long.parseLong(sourceAccountId), Long.parseLong(destAccountId));
        response.sendRedirect("success.jsp");
    }
}
