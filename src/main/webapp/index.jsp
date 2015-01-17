<html>
<body>
<%
    request.getParameter("test");
    response.getWriter();


    String myName = "My Name is Denis";
    myName+="!!!";

%>
<h2>Hello World!</h2>
<h3>
    <%= myName %>
</h3>
</body>
</html>
