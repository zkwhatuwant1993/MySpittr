<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@page session="false" %>
<html>
	<head>
		<title><spring:message code="spitter.appname"/></title>
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css"/>"/>
	</head>
	<body>
		<div id="header">
			<tiles:insertAttribute name="header" />
		</div>
		<div id="body">
			<tiles:insertAttribute name="body" />
		</div>
		<div id="footer">
			<tiles:insertAttribute name="footer" />
		</div>
	</body>
</html>
