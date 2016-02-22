<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Messenger</title>
</head>
<body>
    <%@include file="blocks/header.jsp" %>
    <h3><s:message code="messenger.welcome"/></h3>
</body>
</html>