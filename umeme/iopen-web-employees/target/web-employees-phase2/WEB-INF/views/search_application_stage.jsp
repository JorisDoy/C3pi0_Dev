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
					<li class="active"><a href="<c:url value="/employee/applications"/>"><s:message code="application.search.title" /></a></li>	
					<%-- <li><a href="<c:url value="/employee/applications/currentStageApplicationNumberFilters"/>"><s:message code="employee.applicationstage.search" /></a></li> --%>
					<li><a href="<c:url value="/employee/inspection/rejectedinspections"/>"><s:message code="employee.rejectedinspection.stage" /></a></li>
					<li><a href="<c:url value="/employee/inspection/pendingscheduling?schedule=false"/>"><s:message code="inspection.schedule.tab" /></a></li>
					<li><a href="<c:url value="/employee/inspection/pendinginspection?schedule=true"/>"><s:message code="inspection.scheduleexpecting.tab" /></a></li>	
					<li><a href="<c:url value="/employee/connection/pendingscheduling?schedule=false"/>"><s:message code="connection.notscheduled.tab" /></a></li>
					<li><a href="<c:url value="/employee/connection/pendingconnection?schedule=true"/>"><s:message code="connection.scheduleexpecting.tab" /></a></li>
					<li><a href="<c:url value="/employee/batch/list"/>"><s:message code="iopen.batch.title" /></a></li>					
					
				</ul>
				<h3 class="module-title-short">
					<span class="selected"><s:message code="employee.applicationstage.search" /></span>
				</h3>
				<div class="panel panel-default panel-size">
					<div class="panel-body">
						<form:form method="POST" commandName="applicationListFilter"
							cssClass="form-horizontal">
							 
							<div class="row-fluid">							
								<div class="span4">
									 <div class="formGroup">
										<form:label path="currentStage"
											cssErrorClass="has-errors">
											<s:message code="applicationlist.currentstage.label" />
										</form:label>
										<form:select path="currentStage" cssClass="form-control text-uppercase"
											cssErrorClass="form-control has-errors"
											id="currentStage" placeholder="currentStage">
											<form:option value="ALL" label="ALL" />
										<c:forEach items="${currentStage}" var="tipS">
											<form:option value="${tipS.estado}" label="${tipS.descEst}" />
										</c:forEach>
										</form:select>

										<form:errors path="currentStage" cssClass="has-errors"
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
								
								<div class="span2">
								<div class="form-group"> 
									<button class="btn btn-lg btn-primary" type="submit" name="method" value="filter" style="min-width:178px" >
										Filter Applications</button> 
										</div>
								</div>

								<div class="span2">
								<div class="form-group"> 
									<button class="btn btn-lg btn-primary" type="submit" name="method" value="export" style="min-width:178px" >
										Export List</button> 
										</div>
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
										<td><a href="<c:url value="/employee/application/"/>${application.iopenApplication.codApplication}?complete=true" > Edit</a></td>
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