<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t" %>

<head>
	<t:insertAttribute name="header" />
</head>
<body id="top" class="page page-id-389 page-template page-template-template-front-php">
	<div class="body-pattern">
		<t:insertAttribute name="body_header" />
		<t:insertAttribute name="content" />
		<t:insertAttribute name="footer" />
	</div>
	<t:insertAttribute name="init_scripts" />
</body>
</html>