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
  <div><center><h1>ALL AIRPORTS</h1></center></div>

  <div class="hot-container">
    <p>
      <a href="/" class="btn">HOME</a>
      <a href="/newAirport" class="btn btn-blue">NEW ENTRY</a>
      <a href="airport" class="btn btn-red">RELOAD</a>
    </p>
    <!-- <p>
      <a href="#" class="btn btn-red">This is a button</a>
      <a href="#" class="btn btn-green">This is a button</a>
    </p> -->
  </div>
  <div>
    <table>
      <tr>
        <th>AIRPORT ID</th>
        <th>AIRPORT NAME</th>
        <th colspan="2">OPERATIONS</th>
      </tr>
      <c:forEach items="${airports}" var="item">
        <tr>
          <td>${item.airportId}</td>
          <!-- <td><a href="/runway?airportId=${item.airportId}">${item.airportName}</a></td> -->
          <td><a href="/runway?airportId=${item.airportId}" class="btn btn-green">${item.airportName}</a></td>
          <td><a href="/editAirport?airportId=${item.airportId}" class="btn btn-green">EDIT</a></td>
          <td><a href="/deleteAirport?airportId=${item.airportId}" class="btn btn-red">DELETE</a></td>
        </tr>
      </c:forEach>
    </table>
  </div>
</body>
</html>