<%@ page session="false" %>
<h1><spring:message code="spitter.profile.title"/></h1>
<c:out value="${spitter.username}"/><br/>
<c:out value="${spitter.firstName}"/> <c:out value="${spitter.lastName}"/><br/>
<c:out value="${spitter.email}"/>
