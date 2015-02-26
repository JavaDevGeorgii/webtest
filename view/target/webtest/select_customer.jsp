<%@ page import="java.util.List" %>
<%@ page import="com.levelup.service.CustomerService" %>
<%@ page import="com.levelup.service.impl.CustomerServiceimpl" %>
<%@ page import="com.levelup.model.Customer" %>

<%--
  Created by IntelliJ IDEA.
  User: GEO
  Date: 26.02.15
  Time: 02:39
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<%
  CustomerService customerService = new CustomerServiceimpl();
  List<Customer> customers;
  customers=(List<Customer>)customerService.getAllCustomer();
  request.setAttribute("customer",customers);

%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Select Customers</title>
</head>
<body>
<div class="content">
  <form action="select_customer" method="post">
    <div>URA
    <%--
      Customer: <select name="getAllCustomer">
      <c:forEach var="customer" items="${requestScope.customers}">
        <option value="${customer.}"
      </c:forEach>--%>
    </select>
    </div>
    <input type="submit">
  </form>

</div>

</body>
</html>
