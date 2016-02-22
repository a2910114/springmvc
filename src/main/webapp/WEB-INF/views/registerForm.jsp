<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<html lang="en" xmlns:c="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>Registration</title>
</head>
<body>
    <%@include file="blocks/header.jsp" %>
    <sf:form class="form-horizontal" action='' method="POST" style="position:fixed;top:10%;left:40%;width:250px;"
    commandName="user">
      <fieldset>
        <div id="legend">
          <legend class="">Register</legend>
        </div>
        <div class="control-group">
          <!-- Username -->
          <label class="control-label"  for="username">Username</label>
          <div class="controls">
            <sf:input type="text" id="username" name="username" placeholder="" class="input-xlarge" path = "username"/>
            <br>
            <sf:errors path="username" cssClass="label label-danger" />
            <p class="help-block">Username can contain any letters or numbers, without spaces</p>
          </div>
        </div>

        <div class="control-group">
          <!-- E-mail -->
          <label class="control-label" for="email">E-mail</label>
          <div class="controls">
            <sf:input type="text" id="email" name="email" placeholder="" class="input-xlarge" path = "email"/>
            <br>
            <sf:errors path="email" cssClass="label label-danger" />
            <p class="help-block">Please provide your E-mail</p>
          </div>
        </div>

        <div class="control-group">
          <!-- Password-->
          <label class="control-label" for="password">Password</label>
          <div class="controls">
            <sf:input type="password" id="password" name="password" placeholder="" class="input-xlarge" path="password"/>
            <br>
            <sf:errors path="password" cssClass="label label-danger" />
            <p class="help-block">Password should be at least 4 characters</p>
          </div>
        </div>

        <!--<div class="control-group">-->
          <!-- Password -->
          <!--<label class="control-label"  for="password_confirm">Password (Confirm)</label>
          <div class="controls">
            <input type="password" id="password_confirm" name="password_confirm" placeholder="" class="input-xlarge">
            <p class="help-block">Please confirm password</p>
          </div>
        </div>-->

        <div class="control-group">
          <!-- Button -->
          <div class="controls">
            <button class="btn btn-success">Register</button>
          </div>
        </div>
      </fieldset>
    </sf:form>
</body>
</html>