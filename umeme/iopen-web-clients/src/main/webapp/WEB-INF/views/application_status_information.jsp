<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%> 
		<div class="row-fluid">
			<div class="span12 post-page">
			<ul class="nav nav-tabs">
					<li ><a href="<c:url value="/client/application/"/>${applicationstatus.codApplication}?edit=${edit}"><s:message
								code="tab.clientapplication.applicationdata" /></a></li>
					<li class="active"><a href="<c:url value="/client/application/statusinformation/"/>${applicationstatus.codApplication}?edit=${edit}"><s:message
								code="tab.clientapplication.statusinfo" /></a></li>
					<li><a href="<c:url value="/client/application/pendinginvoice/"/>${applicationstatus.codApplication}?edit=${edit}"><s:message
								code="tab.clientapplication.pendinginvoices" /></a></li>
								</ul>
				<a class="btn btn-lg btn-primary"
					href="<c:url value="/client/applications"/>" role="button"><s:message
								code="btnbacktoapplications.label"/></a>
				<h3 class="module-title-short"> 
						<span class="selected"><s:message
								code="tab.clientapplication.statusinfo" /></span> 				
				</h3>
				<form:form method="POST" commandName="applicationstatus"
					cssClass="form-horizontal dropzone" id="frmapplicationstatus"
					enctype="multipart/form-data">
					
					<div class="row-fluid">
						<div class="span3">
							<a class="btn btn-lg btn-primary"
								href="<c:url value="/client/applications"/>" role="button"><s:message
								code="btnbacktoapplications.label"/></a>
						</div>
						<div class="span1"></div>
						<div class="span3">
						</div>
						<div class="span1"></div>
						<div class="span3">
							 
						</div>
						<div class="span1"></div>
					</div> 
					<fieldset>
						<legend><s:message
								code="tab.clientapplication.statusinfo" /></legend>
						<div class="row-fluid">
							<div class="span4">
								<div class="formGroup">
									<form:label path="codApplication">
										<s:message code="applicationlist.iopentackingno.label" />
									</form:label>
									<form:input path="codApplication"
										cssClass="form-control text-uppercase" id="applicationNumber"
										placeholder="Tracking Number.." readonly="true" />
									<form:errors path="codApplication" cssClass="has-errors"
										element="span" />
								</div>
							</div>
							<div class="span4">
								<div class="formGroup"> 
									<form:label path="applicationStage">
										<s:message code="applicationlist.currentstage.label" />
									</form:label>
									<form:input path="applicationStage"
										cssClass="form-control text-uppercase" id="applicationStage"
										placeholder="application Stage.." readonly="true" />
									<form:errors path="applicationStage" cssClass="has-errors"
										element="span" />
								</div>
							</div>
							<div class="span4">
								<div class="formGroup"> 
								</div>
							</div>
						</div>
						<div class="row-fluid">
							<div class="span8">
							<form:label path="applicationDescription">
										<s:message code="connection.connectionComment" />
									</form:label>
									<form:textarea path="applicationDescription" cssClass="form-control"
										id="applicationDescription" placeholder="Comment.."
										style="width: 80%;" readonly="true" />
										<form:errors path="applicationDescription" cssClass="has-errors"
										element="span" />
							</div>
							<div class="span4"></div>
						
						</div>
						
						</fieldset>
				</form:form>

				<div class="bottom-border">&nbsp;</div>
			</div>
		</div>
 

 
