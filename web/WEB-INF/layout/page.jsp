<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
	<head>
		<title><spring:message code="spitter.appname"/></title>
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css"/>"/>
	</head>
	<body>
		<div id="header">
			<tiles:insertAttribute value="header" />
		</div>
		<div id="body">
			<tiles:insertAttribute value="body" />
		</div>
		<div id="footer">
			<tiles:insertAttribute value="footer" />
		</div>
	</body>
</html>
