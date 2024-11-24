<%@ page import="beans.Form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="./css/bootstrap.min.css">
    <title>Result</title>
</head>
<body>
<%
    Form user = (Form) request.getAttribute("form");
    String message = (String) request.getAttribute("message");
%>

<% if (message != null) { %>
    <div class="container">
        <div class="alert alert-info">
            <%= message %>
        </div>
    </div>
<% } %>

<h1>Bonjour, <%= user.getInitiale() %>, <%= user.getNom() %></h1>
<p>Email: <%= user.getEmail() %></p>
<p>Domaine d'intérêt: <%= user.getDomaine() %></p>

</body>
</html>
