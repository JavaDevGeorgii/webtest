<%@ page import="com.levelup.service.AccountService" %>
<%@ page import="com.levelup.service.impl.AccountServiceImpl" %>
<%@ page import="com.levelup.model.Account" %>
<%@ page import="java.util.List" %>
<%@ page import="com.levelup.service.TransactionService" %>
<%@ page import="com.levelup.service.impl.TransactionServiceImpl" %>
<%@ page import="com.levelup.model.Transaction" %>
<%--
  Created by IntelliJ IDEA.
  User: denis_zavadsky
  Date: 2/24/15
  Time: 18:42
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>


<%
    AccountService accountService = new AccountServiceImpl();
    List<Account> accounts =  accountService.getAllAccounts();
    request.setAttribute("accounts",accounts);

    TransactionService transactionService = new TransactionServiceImpl();
    List<Transaction> transactions = transactionService.getTransactionsByAccountId(2L);
    request.setAttribute("transactions", transactions);

%>
<html>
<head>
    <title>Crete Transaction</title>
</head>
<body>
<div class="content">
    <form action="transaction" method="post">
        <div>
            Amount: <input type="text" name="amount">
        </div>
        <div>
            Source Account: <select name="sourceAccountId">
           <c:forEach var="account" items="${requestScope.accounts}">
               <option value="${account.id}">${account.accountNumber}</option>
           </c:forEach>
            </select>
        </div>
        <div>
            Destination Account: <select name="destAccountId">
            <c:forEach var="account" items="${requestScope.accounts}">
                <option value="${account.id}">${account.accountNumber}</option>
            </c:forEach>
        </select>
        </div>
        <input type="submit">

        <c:forEach var="transaction" items="${requestScope.transactions}">
            ${transaction.amount}
        </c:forEach>
    </form>
</div>
</body>
</html>
