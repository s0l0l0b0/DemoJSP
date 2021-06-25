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


      
      .hot-container p { margin-top: 10px; }
    a { text-decoration: none; margin: 0 10px; }

    .hot-container {
    min-height: 100px;
    margin-top: 100px;
    width: 100%;
    text-align: center;
    }

    a.btn {
    display: inline-block;
    color: #666;
    background-color: #eee;
    text-transform: uppercase;
    letter-spacing: 2px;
    font-size: 12px;
    padding: 10px 30px;
    border-radius: 5px;
    -moz-border-radius: 5px;
    -webkit-border-radius: 5px;
    border: 1px solid rgba(0,0,0,0.3);
    border-bottom-width: 3px;
    }

    a.btn:hover {
      background-color: #e3e3e3;
      border-color: rgba(0,0,0,0.5);
    }

    a.btn:active {
      background-color: #CCC;
      border-color: rgba(0,0,0,0.9);
    }

    /* blue button */

    a.btn.btn-blue {
    background-color: #699DB6;
    border-color: rgba(0,0,0,0.3);
    text-shadow: 0 1px 0 rgba(0,0,0,0.5);
    color: #FFF;
    }

    a.btn.btn-blue:hover {
      background-color: #4F87A2;
      border-color: rgba(0,0,0,0.5);
    }

    a.btn.btn-blue:active {
      background-color: #3C677B;
      border-color: rgba(0,0,0,0.9);
    }

    /* red button */

    a.btn.btn-red {
    background-color: #E48681;
    border-color: rgba(0,0,0,0.3);
    text-shadow: 0 1px 0 rgba(0,0,0,0.5);
    color: #FFF;
    }

    a.btn.btn-red:hover {
      background-color: #DA4F49;
      border-color: rgba(0,0,0,0.5);
    }
    </style>
</head>
<body>
  <div>
    <center>
      <h1>${operation} ${airport.airportName}</h1>
    </center>
  </div>
  <div>
    <center>
      <a href="/airport" class="btn btn-blue">AIRPORTS</a>
      <a href="/runway?airportId=${airport.airportId}" class="btn btn-blue">BACK</a>
      <a href="/logout" class="btn btn-red">LOG OUT</a>
    </center>

  </div>

  <div>
    <form action="/newRunway" method="POST">
      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
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
      <label for="surfaceCondition">Surface Condition</label>
      </fieldset>

      <input type="submit" value="Submit">
    </form>
  </div>
</body>
</html>
