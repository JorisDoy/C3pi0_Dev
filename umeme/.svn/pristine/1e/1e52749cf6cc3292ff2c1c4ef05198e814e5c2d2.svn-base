<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<div id="meta" class="wrap hidden-print">
	<!-- top header -->
	<div class="top-strip"> 
		<div class="row-fluid">
			<div class="span3">
				<a href="http://umeme.co.ug/"><img alt="UMEME"
					src='<s:url value="/resources/assets/img/logo.png"></s:url>'
					id="logo-img1"style="float:left;" /></a>
			</div>
			
			<!-- <div class="span7" style="background-color:#AEBE00; height:40px;"></div> -->
			<div class="span9" style="background-color:#AEB400; height:60px; margin-left: 2px; padding-left: 0px; margin-right: -7px;">
				<ul class="top-strip-nav">
					<security:authorize access="isAnonymous()">
						<li style=""><a href='<s:url value="/client/complaint/anonymous/hazard"></s:url>'><span><s:message code="emergencycomplaint.new.text"/></span></a></li>
						<li><a href='<s:url value="/user/signup"></s:url>'><span><s:message code="signup.text"/></span></a></li>
						<li><a href='<s:url value="/user/login"></s:url>'><span><s:message
										code="login.text" /></span></a></li>
						<li><a href='<s:url value="/password/reset/request"></s:url>'><span><s:message code="menu.forgot.password"/></span></a></li>
					</security:authorize>
					<security:authorize
						access="hasRole('CLIENT') or hasRole('EMPLOYEE')">
						<security:authentication property="principal.username"
							var="username" />
						<li><a href='#'><span><s:message
										code="loggedin.text" /> ${username}</span></a></li>

					</security:authorize>
					<%-- <security:authorize
						access="hasRole('CLIENT')">
						<security:authentication property="principal.username"
							var="username" />
						<li><a href='<s:url value="/client/application/new"></s:url>'><span><s:message code="client.application.new.text" /></span></a></li>
						<li><a href='<s:url value="/client/applications"></s:url>'><span><s:message code="client.application.status.text" /></span></a></li>
						<li><a href='<s:url value="/client/password/change"></s:url>'><span><s:message code="client.password.change" /></span></a></li>

					</security:authorize> --%>
					<security:authorize
						access="hasRole('EMPLOYEE')">
						<security:authentication property="principal.username"
							var="username" />
						<li><a href='<s:url value="/employee/applications"></s:url>'><span><s:message
										code="employee.applications.pending.text" /></span></a></li>

					</security:authorize>
					<security:authorize
						access="hasRole('CLIENT') or hasRole('EMPLOYEE')">
						<security:authentication property="principal.username"
							var="username" />
						<li><a href='<s:url value="/logout"></s:url>'><span><s:message
										code="logout.text" /></span></a></li>

					</security:authorize>
				</ul>
			</div>
		</div>
	</div>
	<!--End top header -->
</div>



