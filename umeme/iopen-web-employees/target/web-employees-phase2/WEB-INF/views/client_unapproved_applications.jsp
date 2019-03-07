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
				<ul class="nav nav-tabs"> 
					<li><a href="<c:url value="/employee/applications"/>"><s:message code="application.search.title" /></a></li>	
					<%-- <li><a href="<c:url value="/employee/applications/currentStageApplicationNumberFilters"/>"><s:message code="employee.applicationstage.search" /></a></li> --%>
					<li class="active"><a href="<c:url value="/employee/inspection/rejectedinspections"/>"><s:message code="employee.rejectedinspection.stage" /></a></li>
					<li><a href="<c:url value="/employee/inspection/pendingscheduling?schedule=false"/>"><s:message code="inspection.schedule.tab" /></a></li>
					<li><a href="<c:url value="/employee/inspection/pendinginspection?schedule=true"/>"><s:message code="inspection.scheduleexpecting.tab" /></a></li>	
					<li><a href="<c:url value="/employee/connection/pendingscheduling?schedule=false"/>"><s:message code="connection.notscheduled.tab" /></a></li>
					<li><a href="<c:url value="/employee/connection/pendingconnection?schedule=true"/>"><s:message code="connection.scheduleexpecting.tab" /></a></li>
					<li><a href="<c:url value="/employee/batch/list"/>"><s:message code="iopen.batch.title" /></a></li>
												
				</ul> 
				<div class="row-fluid">
				<div class="span3">
				<h3 class="module-title-short">
					<span class="selected"><s:message code="employee.application.search" /></span>
				</h3>
				</div>
				 
				</div>
				<div class="panel panel-default panel-size">
					<div class="panel-body">
						<form:form method="POST" commandName="applicationListFilter"
							cssClass="form-horizontal">
							<div class="row-fluid">
							
								<div class="span4">
									<div class="formGroup">
										<form:label path="applicationStatus"
											cssErrorClass="has-errors">
											<s:message code="application.status.label" />
										</form:label>
										<form:select path="applicationStatus" cssClass="form-control text-uppercase"
											cssErrorClass="form-control has-errors"
											id="applicationStatus" placeholder="status">
											<form:option value="ALL" label="ALL" />
										<c:forEach items="${statuses}" var="status">
											<form:option value="${status.statusCode}"
												label="${status.statusDescription}" />
										</c:forEach>
										</form:select>

										<form:errors path="applicationStatus" cssClass="has-errors"
											element="span" />
									</div>
								</div>
								
								
								<div class="span4">
									<div class="form-group"> 
										<form:label path="applicationNumber">
											<s:message code="applicationlist.number.label" />
										</form:label>
										<form:input path="applicationNumber" cssClass="form-control text-uppercase"
											cssErrorClass="form-control has-errors" id="applicationNumber" placeholder="applicationNumber" />
										<form:errors path="applicationNumber" cssClass="has-errors"
											element="span" />
									</div>
								</div>
								<div class="span4">
									<div class="form-group"> 
										<form:label path="trackingNumber">
											<s:message code="applicationlist.iopentackingno.label" />
										</form:label>
										<form:input path="trackingNumber" cssClass="form-control text-uppercase"
											cssErrorClass="form-control has-errors" id="trackingNumber" placeholder="trackingNumber" />
										<form:errors path="trackingNumber" cssClass="has-errors"
											element="span" />
									</div>
								</div>
								
							</div>
							<hr />
							<div class="row-fluid">
								<div class="span2">
									<div class="form-group">
										<form:radiobutton path="documentType" cssClass="form-control text-uppercase"
											cssErrorClass="form-control has-errors" id="passport" value='${defaultValues.get("application_passport_value")}' />
										<s:message code="application.passportidentity.label" />
										<form:errors path="documentType" cssClass="has-errors"
											element="span" />
									</div>
								</div>
								<div class="span2">
									<div class="form-group">
										<form:radiobutton path="documentType" cssClass="form-control text-uppercase" checked="checked"
											cssErrorClass="form-control has-errors" id="idno" value='${defaultValues.get("application_idnumber_value")}' />
										<s:message code="application.ididentity.label" />
										<form:errors path="documentType" cssClass="has-errors"
											element="span" />
									</div>
								</div>
								<div class="span4">
									<div class="form-group">
										<%-- <form:label path="idNumber" cssErrorClass="has-errors">
											<s:message code="application.idnumber.label" />
										</form:label> --%>
										<form:input path="idNumber" cssClass="form-control text-uppercase"
											cssErrorClass="form-control has-errors" id="idNumber" placeholder="idNumber" />
										<form:errors path="idNumber" cssClass="has-errors"
											element="span" />
									</div>
								</div>

								<div class="span2">
									<button class="btn btn-lg btn-primary" type="submit" name="method" value="filter" style="min-width:178px" >
										Filter Applications</button> 
								</div>

								<div class="span2">
									<button class="btn btn-lg btn-primary" type="submit" name="method" value="export" style="min-width:178px" >
										Export List</button> 
								</div>

							</div>
						</form:form>
						<hr />
						<div class="span12" style="overflow: auto">
						<table class="table table-condensed table-hover">
							<thead>
								<tr>	
									<th>Tracking No.</th>	
									<th>Application No.</th>					
									<th>Application Date</th>
									<th>Application type</th>
									<th>Current Stage</th>
									<th>Application Status</th>
									<!-- <th>Application Comment</th> -->
									<!-- <th>&nbsp;</th>	 -->
									<th>&nbsp;</th>	
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${applications}" var="application">
									<tr class="active">
										<td>${application.iopenApplication.codApplication}</td>
										<td>${application.applicationNumber}</td>
										<td>${application.applicationDate}</td>
										<td>${application.applicationType}</td>
										<td>${application.applicationCurrentStage}</td>
										<td>${application.applicationStatus}</td>
										<c:if
											test="${applicationListFilter.district > 0}">
											 <td><a href="<c:url value="/employee/application/"/>${application.iopenApplication.codApplication}?complete=true" > Edit</a></td>
										</c:if>
										<c:if
											test="${applicationListFilter.district == 0}">
											 <td><a href="<c:url value="/employee/application/view/"/>${application.iopenApplication.codApplication}?complete=true" > view</a></td>
										</c:if>
										<%-- <td>${application.applicationComment}</td> --%>
										<%-- <td><a href="<c:url value="/employee/application/"/>${application.iopenApplication.codApplication}?complete=true" > View</a></td> --%>
										
									</tr>
								</c:forEach>
							</tbody>
						</table>
						</div>
					</div>
				</div>

				<div class="bottom-border">&nbsp;</div>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">

$(document).ready(function(){
	
	/* setSearchOptions();
	
	$("#district_status_radio").change(function() {
		setSearchOptions();
    });
	
	$("#application_no_radio").change(function() {
		setSearchOptions();
    });
	
	$("#tracking_no_radio").change(function() {
		setSearchOptions();
    });
	
	$("#id_no_passport_radio").change(function() {
		setSearchOptions();
    }); */
	
	/* function setSearchOptions(){
		
		if($('#district_status_radio')[0].checked==true){
			$('#district').removeAttr('disabled');
			$('#applicationStatus').removeAttr('disabled');
			$('#applicationNumber').attr('disabled','disabled');
			$('#trackingNumber').attr('disabled','disabled');
			$('#idno').attr('disabled','disabled');
			$('#passport').attr('disabled','disabled');
			$('#idNumber').attr('disabled','disabled');	
		} 
		
		if($('#application_no_radio')[0].checked==true){
			$('#district').attr('disabled','disabled');
			$('#applicationStatus').attr('disabled','disabled');
			$('#applicationNumber').removeAttr('disabled');
			$('#trackingNumber').attr('disabled','disabled');
			$('#idno').attr('disabled','disabled');
			$('#passport').attr('disabled','disabled');	
			$('#idNumber').attr('disabled','disabled');			 
		}
		
		if($('#tracking_no_radio')[0].checked==true){
			$('#district').attr('disabled','disabled');
			$('#applicationStatus').attr('disabled','disabled');
			$('#applicationNumber').attr('disabled','disabled');
			$('#trackingNumber').removeAttr('disabled');
			$('#idno').attr('disabled','disabled');
			$('#passport').attr('disabled','disabled');	
			$('#idNumber').attr('disabled','disabled');	
		}
		
		if($('#id_no_passport_radio')[0].checked==true){
			$('#district').attr('disabled','disabled');
			$('#applicationStatus').attr('disabled','disabled');
			$('#applicationNumber').attr('disabled','disabled');
			$('#trackingNumber').attr('disabled','disabled');
			$('#idno').removeAttr('disabled');
			$('#passport').removeAttr('disabled');
			$('#idNumber').removeAttr('disabled');
		} 
	} */
	
	
});
</script>