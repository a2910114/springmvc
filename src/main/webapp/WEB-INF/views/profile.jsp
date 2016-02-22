<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html lang="en" xmlns:c="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>"${user.username}" profile</title>
</head>
<body>
    <%@include file="blocks/header.jsp" %>
    <div class="panel panel-default">
      <div class="panel-heading">${user} profile</div>
      <div class="panel-body">
        <table class="table">
            <tr>
                <th>User name</th>
                <th>Email</th>
            </tr>
            <tr>
                <td>${user.username}</td>
                <td>${user.email}</td>
            </tr>
        </table>
      </div>
    </div>
</body>
</html>