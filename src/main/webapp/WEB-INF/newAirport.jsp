<%--
  Created by IntelliJ IDEA.
  User: tapusd
  Date: 2/9/21
  Time: 2:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Home Page</title>
    <style>
      form{
        display: flex;
      }
      fieldset{
        display:flex;
      }
    </style>
</head>
<body>

  <div>
    <a class="button" a href="airport">Back</a>
    ${operation}
    <form action="/newAirport" method="POST">
        <label for="name">New Airport </label>
        <input type="hidden" name="airportId" value="${newAirport.airportId}">
        <input type="text" name="airportName" value="${newAirport.airportName}">
      <input type="submit" value="Submit">
    </form>
  </div>
</body>
</html>
