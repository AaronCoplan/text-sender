<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Sample Home Page</title>
    <link rel="icon" type="image/x-icon" href="<spring:url value="/static/images/favicon.ico" />">
  </head>
  <body>

    <h1>Text Bomb Application</h1>

    <h3>${message}</h3>

    <form action="/home" method="POST">
      <div>
        <p>Target Phone Number (no dashes or dots):</p>
        <input type="text" name="phone_number"/>
      </div>

      <br/>

      <div>
        <p>Carrier:</p>
        <select name="carrier">
          <c:forEach items="${carriers}" var="carrier">
            <option value="${carrier}">${carrier}</option>
          </c:forEach>
        </select>
      </div>

      <br/>

      <div>
        <p>Message Text:</p>
        <input type="text" name="message_text"/>
      </div>

      <br/>

      <div>
        <p>Number of Messages:</p>
        <input type="text" name="num_messages"/>
      </div>

      <br/>

      <div>
        <p>Delay in Seconds Between Messages:</p>
        <input type="text" name="delay"/>
      </div>

      <br/>

      <div>
        <p>GMail Username:</p>
        <input type="text" name="gmail_username"/>
      </div>

      <br/>

      <div>
        <p>GMail Password:</p>
        <input type="password" name="gmail_password"/>
      </div>

      <br/>

      <div>
        <input type="submit" value="Text Bomb"/>
      </div>
    </form>
  </body>
</html>
