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
      input{
          width: auto;
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
            <h1>
                ${operation} AIRPORT
            </h1>
        </center>
    </div>

    <dir>
        <center>
            <a href="airport" class="btn btn-blue">Back</a>
        </center>
    </dir>

    <div>
        <forms action="/newAirport" method="POST">
            <center>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <label for="name">NAME </label>
                <input type="hidden" name="airportId" value="${newAirport.airportId}">
                <input type="text" name="airportName" value="${newAirport.airportName}">
                <input type="submit" value="Submit">
            </center>
        </form>
    </div>
</body>
</html>
