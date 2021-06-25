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
        text-align: center;
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
      <h1>AIRPORT - ${airport.airportName}</h1>
    </center>
  </div>
  <div class="hot-container">
    <p>
      <a href="/newRunway?airportId=${airport.airportId}" class="btn btn-blue">NEW ENTRY</a>
      <a href="/airport" class="btn btn-red">BACK</a>
      <a href="/logout" class="btn btn-blue">LOG OUT</a>
    </p>
  </div>

    

  <div>
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
          <td><a href="/editRunway?runwayNo=${item.runwayNo}" class="btn btn-blue">EDIT</a></td>
          <td><a href="/deleteRunway?runwayNo=${item.runwayNo}" class="btn btn-red">DELETE</a></td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>
</body>
</html>
