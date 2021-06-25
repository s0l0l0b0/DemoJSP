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
      .button {
        display: block;
        width: 45px;
        height:15px;
        background: #000000;
        padding: 10px;
        text-align: center;
        border-radius: 5px;
        color: white;
        font-weight: bold;
        line-height: 25px;
        cursor: pointer;
      }

      .top-panel{
        display: flex;
        width: 100vh;
        align-items: center;
        justify-content: center;
      }
    </style>
</head>
<body>
  <div>
    ${airport.airportName}
    <div class="top-panel">
    <a class="button" href="/newRunway?airportId=${airport.airportId}">New Entry</a>
    <a class="button">Home</a>
    <a class="button">Back</a>
    </div>


    <table>
      <thead>
        <th>Runway No</th>
        <th>Length</th>
        <th>Width</th>
        <th>Surface Type</th>
        <th>Surface Condition</th>
      </thead>
      <tbody>
      <c:forEach items="${runways}" var="item">
        <tr>
          <td>${item.runwayNo}</td>
          <td>${item.runwayLength}</td>
          <td>${item.runwayWidth}</td>
          <td>${item.runwaySurface.surfaceType}</td>
          <td>${item.runwaySurface.surfaceCondition}</td>
          <td><a class="button">Edit</a></td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>
</body>
</html>
