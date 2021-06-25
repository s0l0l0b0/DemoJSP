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
  New ${airport.airportName}
  <div>
    <form action="/newRunway" method="POST">
      <fieldset>
        <legend>Airport Runw</legend>
      <input type="hidden" name="airport" value="${airport.airportId}">
      <input type="text" name="runwayLength" required>
      <label for="runwayLength">Runway Length</label>
      <input type="text" name="runwayWidth" required>
      <label for="runwayWidth">Runway Width</label>
      </fieldset>
      <fieldset>
      <legend>Runway Surface</legend>
      <select name="surfaceType">
        <option value="">None</option>
        <option value="PITCH">PITCH</option>
        <option value="DART">DART</option>
        <option value="PLAIN">PLAIN</option>
        <option value="MUDDY">MUDDY</option>
      </select>
      <label for="surfaceType">Surface Type</label>

      <select name="surfaceCondition">
        <option value="">None</option>
        <option value="GOOD">GOOD</option>
        <option value="MEDIUM">MEDIUM</option>
        <option value="BAD">BAD</option>
      </select>
      <label for="surfaceCondition">Surface Condition:</label>
      </fieldset>

      <input type="submit" value="Submit">
    </form>
  </div>
</body>
</html>
