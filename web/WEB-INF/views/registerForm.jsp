<%@ page session="false" %>


<h1><spring:message code="spitter.register.titile"/></h1>

<sf:form method="post" commandName="spitter">
    <sf:errors element="div" path="*" cssClass="errors"/>
    <sf:label path="firstName"
              cssErrorClass="error">First Name</sf:label>:
    <sf:input path="firstName" cssErrorClass="error"/><br/>
    <sf:label path="lastName"
              cssErrorClass="error">Last Name</sf:label>:
    <sf:input path="lastName" cssErrorClass="error"/><br/>
    <sf:label path="email"
              cssErrorClass="error"> Email</sf:label>:
    <sf:input path="email" type="email" cssErrorClass="error"/><br/>
    <sf:label path="username"
              cssErrorClass="error"> Username</sf:label>:
    <sf:input path="username" cssErrorClass="error"/><br/>
    <sf:label path="password"
              cssErrorClass="error">Password</sf:label>:
    <sf:password path="password" cssErrorClass="error"/><br/>
    <input type="submit" value="Register"/>
</sf:form>