<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html lang="en" xmlns:c="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>Last news</title>
</head>
<body>
    <%@include file="blocks/header.jsp" %>
    <div class="panel panel-default">
      <div class="panel-heading">Resent messages</div>
      <div class="panel-body">
        <ul class="list-group">
                <li class="list-group-item list-group-item-success">
                    <c:out value='${message.message}'/>
                    <c:out value='${message.creationDate}'/>
                </li>
            </ul>
      </div>
    </div>
</body>
</html>