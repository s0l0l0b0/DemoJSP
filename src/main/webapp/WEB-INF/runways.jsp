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
</head>
<body>
  <div>
    This is the runway page
    <table>
      <tr>
        <th>Runway No</th>
        <th>Length</th>
        <th>Width</th>
      </tr>
      <c:forEach items="${runways}" var="item">
        <tr>
          <td>${item.runwayNo}</td>
          <td>${item.runwayLength}</td>
          <td>${item.runwayWidth}</td>
        </tr>
      </c:forEach>
    </table>
  </div>
</body>
</html>
