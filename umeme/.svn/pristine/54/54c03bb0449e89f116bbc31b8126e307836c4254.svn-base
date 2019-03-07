<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<div id="main" class="wrap post-template">
	<div class="container">
		<div class="row-fluid">
			<div class="span12 post-page">
				<div class="bottom-border">&nbsp;</div>
				<form:form method="POST" commandName="login"
					cssClass="form-horizontal form-signin register"
					acceptCharset="ISO-8859-1">
					<c:if test="${param.error != null}">
						<form:errors path="*" element="div"
							cssClass="formGroup has-errors" />
					</c:if>
					<h3 class="module-title-short">
						<span class="selected"><s:message code="login.title" /></span>
					</h3>
					<div class="formGroup">
						<form:label path="username" cssErrorClass="has-errors">
							<s:message code="email.label" />
						</form:label>
						<form:input path="username" cssClass="form-control"
							cssErrorClass="form-control has-errors" id="username" type="text"
							required="required" placeholder="username or email..." />
						<form:errors path="username" cssClass="has-errors" element="span" />
					</div>
					<div class="formGroup">
						<form:label path="password" cssErrorClass="has-errors">
							<s:message code="password.label" />
						</form:label>
						<form:input path="password" cssClass="form-control"
							cssErrorClass="form-control has-errors" id="password"
							type="password" required="required" placeholder="password ..." />
						<form:errors path="password" cssClass="has-errors" element="span" />
					</div>
					<button class="btn btn-lg btn-primary btn-block" type="submit" style="width=294px !important">
						<s:message code="login.signin" />
					</button>
				</form:form>
			</div>
		</div>
	</div>
</div>