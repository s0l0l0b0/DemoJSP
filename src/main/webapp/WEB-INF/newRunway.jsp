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
  ${operation} ${airport.airportName}
  <div>
    <form action="/newRunway" method="POST">
      <fieldset>
        <legend>Airport Runway</legend>
      <input type="hidden" name="airport" value="${airport.airportId}">
      
      <c:if test="${not empty runway}">
        <input type="hidden" name="airportRunway" value="${runway.runwayNo}">
      </c:if>

      <input type="text" value="${runway.runwayLength}" name="runwayLength" required>
      <label for="runwayLength">Runway Length</label>
      <input type="text" value="${runway.runwayWidth}" name="runwayWidth" required>
      <label for="runwayWidth">Runway Width</label>
      </fieldset>
      <fieldset>
      <legend>Runway Surface</legend>
      <c:if test="${not empty runwaySurface}">
        <input type="hidden" name="runwaySurface" value="${runwaySurface.runwayNo}">
      </c:if>
      <select name="surfaceType">
        <option value="">None</option>
        <option value="SOLID" <c:if test="${runwaySurface.surfaceType eq 'SOLID'}">selected</c:if>>SOLID</option>
        <option value="PITCH" <c:if test="${runwaySurface.surfaceType eq 'PITCH'}">selected</c:if>>PITCH</option>
        <option value="DART"<c:if test="${runwaySurface.surfaceType eq 'DART'}">selected</c:if>>DART</option>
        <option value="PLAIN"<c:if test="${runwaySurface.surfaceType eq 'PLAIN'}">selected</c:if>>PLAIN</option>
        <option value="MUDDY"<c:if test="${runwaySurface.surfaceType eq 'MUDDY'}">selected</c:if>>MUDDY</option>
      </select>
      <label for="surfaceType">Surface Type</label>

      <select name="surfaceCondition">
        <option value="">None</option>
        <option value="GOOD"<c:if test="${runwaySurface.surfaceCondition eq 'GOOD'}">selected</c:if>>GOOD</option>
        <option value="MEDIUM"<c:if test="${runwaySurface.surfaceCondition eq 'MEDIUM'}">selected</c:if>>MEDIUM</option>
        <option value="BAD"<c:if test="${runwaySurface.surfaceCondition eq 'BAD'}">selected</c:if>>BAD</option>
      </select>
      <label for="surfaceCondition">Surface Condition:</label>
      </fieldset>

      <input type="submit" value="Submit">
    </form>
  </div>
</body>
</html>
