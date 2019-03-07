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
			<form:form method="POST" commandName="passwordResetRequest" cssClass="form-horizontal form-signin register" acceptCharset="ISO-8859-1">
				<form:errors path="*" element="div" cssClass="formGroup has-errors" />
				<h3 class="module-title-short"><span class="selected"><s:message code="reset.request.title"/></span></h3>
				<div class="formGroup">
					<form:label path="email" cssErrorClass="has-errors"><s:message code="email.label"/></form:label>
					<form:input path="email" cssClass="form-control" cssErrorClass="form-control has-errors" id="email"  type="email"  required="required" placeholder="email..."/>
					<form:errors path="email" cssClass="has-errors" element="span"/>
				</div>
				<div class="formGroup">
					<form:label path="repeatEmail" cssErrorClass="has-errors"><s:message code="repeat.email.label"/></form:label>
					<form:input path="repeatEmail" cssClass="form-control" cssErrorClass="form-control has-errors" id="repeatEmail" type="email" required="required" placeholder="repeat email ..."/>
					<form:errors path="repeatEmail" cssClass="has-errors" element="span"/>
				</div>
		        <div class="form-group">
		        	<button class="btn btn-lg btn-primary btn-block" type="submit"><s:message code="reset.password.submit"/></button>
		        </div>
			</form:form>
			</div>
		</div>
	</div>
</div>