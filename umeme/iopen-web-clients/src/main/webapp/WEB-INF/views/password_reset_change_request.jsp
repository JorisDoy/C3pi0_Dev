<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<div id="main" class="wrap post-template">
<div class="container">
	<div class="row-fluid">
		<div class="span12 post-page">
			<div class="bottom-border">&nbsp;</div>
			<form:form method="POST" commandName="passwordResetConfirm" cssClass="form-horizontal form-signin register" acceptCharset="ISO-8859-1">
				<form:hidden path="token" id="token"/>
				<form:hidden path="username" id="username"/>
				<form:errors path="*" element="div" cssClass="formGroup has-errors" />
				<h3 class="module-title-short"><span class="selected"><s:message code="reset.confirm.title"/></span></h3>
				<div class="formGroup">
					<form:label path="password" cssErrorClass="has-errors"><s:message code="password.label"/></form:label>
					<form:input path="password" cssClass="form-control" cssErrorClass="form-control has-errors" id="password"  type="password"  required="required" placeholder="password..."/>
					<form:errors path="password" cssClass="has-errors" element="span"/>
				</div>
				<div class="formGroup">
					<form:label path="repeatPassword" cssErrorClass="has-errors"><s:message code="repeat.password.label"/></form:label>
					<form:input path="repeatPassword" cssClass="form-control" cssErrorClass="form-control has-errors" id="repeatPassword" type="password" required="required" placeholder="repeat password ..."/>
					<form:errors path="repeatPassword" cssClass="has-errors" element="span"/>
				</div>
		        <div class="form-group">
		        	<button class="btn btn-lg btn-primary btn-block" type="submit"><s:message code="change.password.submit"/></button>
		        </div>
			</form:form>
			</div>
		</div>
	</div>
</div>