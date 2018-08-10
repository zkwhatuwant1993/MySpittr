<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page session="false" %>
<html>
  <head>
    <title>Spitter</title>
    <link rel="stylesheet" 
          type="text/css" 
          href="<c:url value="/resources/style.css" />" >
  </head>
  <body>
    <h1><spring:message code="spitter.welcome" /> </h1>

    <a href="<c:url value="/spittles" />">Spittles</a>
    <a href="<c:url value="/spitter/register" />">Register</a>
  </body>
</html>
