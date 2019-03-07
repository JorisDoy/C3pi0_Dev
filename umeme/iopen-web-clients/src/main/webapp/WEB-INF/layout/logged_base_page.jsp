<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t" %>

<head>
    <t:insertAttribute name="header" />
</head>
<body id="top" class="page page-id-389 page-template page-template-template-front-php">
    <div class="body-pattern">
        <t:insertAttribute name="body_header" />
        <div id="main" class="wrap post-template">
	        <div class="container">
		        <div class="row-fluid" style="border-top:1px solid #B3BE34;">
	                <div class="nav-side-menu span3 w100">
			             <t:insertAttribute name="aside_left_menu" />
			        </div>
			        <div class="span9">
			             <t:insertAttribute name="content" />
			        </div>
		        </div>
	        </div>
        </div>
        <t:insertAttribute name="footer" />
    </div>
    <t:insertAttribute name="init_scripts" />
</body>
</html>