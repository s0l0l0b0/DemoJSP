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
      table, th, td {
        border: 1px solid black;
      }
      table {
        width: 100%;
      }
    </style>
</head>
<body>
  <div>
    <table>
      <tr>
        <th>AirportId</th>
        <th>Airport Name</th>
      </tr>
      <c:forEach items="${airports}" var="item">
        <tr>
          <td>${item.airportId}</td>
          <td><a href="/runway?airportId=${item.airportId}">${item.airportName}</a></td>
          <td><button>Edit</button></td>
        </tr>
      </c:forEach>
    </table>
  </div>
</body>
</html>
