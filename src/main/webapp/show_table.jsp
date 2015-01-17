<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.ResultSetMetaData" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.LinkedList" %>
<%--
  Created by IntelliJ IDEA.
  User: denis_zavadsky
  Date: 1/17/15
  Time: 18:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%

    String tableName = request.getParameter("table");
    if (tableName==null){
%>
<form action="show_table.jsp" method="get">


    Table Name: <input type="text" name="table">
    <input type="submit">
</form>
<%
    } else {

        Context initContext = new InitialContext();
        Context envContext = (Context) initContext.lookup("java:/comp/env");
        //DataSource ds = (DataSource) initContext.lookup("java:/comp/env/jdbc/TestDB");
        DataSource ds = (DataSource) envContext.lookup("jdbc/TestDB");
        Connection connection = ds.getConnection();

        String query = "SELECT * FROM "+tableName;

        Statement stmt = connection.createStatement();
        ResultSet rs =  stmt.executeQuery(query);

        List<String> columns = new LinkedList<String>();
%>
<table>
    <thead>

<%
        ResultSetMetaData metaData = rs.getMetaData();
        for (int i =1; i<=metaData.getColumnCount(); i++){
            String columnName = metaData.getColumnName(i);
            columns.add(columnName);
%>
<th><%= columnName%></th>
<%
        }

%>
    </thead>
    <tbody>
<%

        while (rs.next()){
%>
<tr>
<%
    for (int i=1; i<=columns.size(); i++){
        String value = rs.getString(i);
%>
    <td><%= value%></td>
<%
    }
%>
</tr>
<%
        }
    }
%>
    </tbody>
</table>
</body>
</html>
