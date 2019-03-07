<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
	

<form:form method="POST" commandName="changePassword" cssClass="form-horizontal form-signin register" acceptCharset="ISO-8859-1">
<%-- 	<form:errors path="*" element="div" cssClass="formGroup has-errors" /> --%>
	<h3 class="module-title-short"><span class="selected"><s:message code="changepassword.title"/></span></h3>
	<div class="formGroup">
		<form:label path="oldPassword" cssErrorClass="has-errors"><s:message code="old.password.label"/></form:label>
		<form:input path="oldPassword" cssClass="form-control" cssErrorClass="form-control has-errors" id="oldPassword"  type="password"   required="required" placeholder="old password..."/>
		<form:errors path="oldPassword" cssClass="has-errors" element="span"/>
	</div>
	<div class="formGroup">
		<form:label path="newPassword" cssErrorClass="has-errors"><s:message code="new.password.label"/></form:label>
		<form:input path="newPassword" cssClass="form-control" cssErrorClass="form-control has-errors" id="newPassword"  type="password" required="required" placeholder="new password ..."/>
		<form:errors path="newPassword" cssClass="has-errors" element="span"/>
	</div>
	<div class="formGroup">
		<form:label path="repeatNewPassword" cssErrorClass="has-errors"><s:message code="repeat.new.password.label"/></form:label>
		<form:input path="repeatNewPassword" cssClass="form-control" cssErrorClass="form-control has-errors" id="repeatNewPassword"   type="password" required="required" placeholder="repeat new password ..."/>
		<form:errors path="repeatNewPassword" cssClass="has-errors" element="span"/>
	</div>
	<div class="formGroup">
		<button class="btn btn-lg btn-primary btn-block" type="submit"><s:message code="password.change.submit"/></button>
	</div>
</form:form>
<div class="bottom-border">&nbsp;</div>