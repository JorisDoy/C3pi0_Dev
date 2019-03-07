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
				<li ><a href="<c:url value="/employee/applications"/>"><s:message code="application.search.title" /></a></li>	
					<%-- <li><a href="<c:url value="/employee/applications/currentStageApplicationNumberFilters"/>"><s:message code="employee.applicationstage.search" /></a></li> --%>
					<li><a href="<c:url value="/employee/inspection/rejectedinspections"/>"><s:message code="employee.rejectedinspection.stage" /></a></li>
					<li class="active"><a href="<c:url value="/employee/inspection/pendingscheduling?schedule=false"/>"><s:message code="inspection.schedule.tab" /></a></li>
					<li ><a href="<c:url value="/employee/inspection/pendinginspection?schedule=true"/>"><s:message code="inspection.scheduleexpecting.tab" /></a></li>	
					<li><a href="<c:url value="/employee/connection/pendingscheduling?schedule=false"/>"><s:message code="connection.notscheduled.tab" /></a></li>
					<li><a href="<c:url value="/employee/connection/pendingconnection?schedule=true"/>"><s:message code="connection.scheduleexpecting.tab" /></a></li>
					<li><a href="<c:url value="/employee/batch/list"/>"><s:message code="iopen.batch.title" /></a></li>
							
				</ul>
				<h3 class="module-title-short">
					<span class="selected"><s:message
							code="inspection.schedule.title" /></span>
				</h3>
				<div class="panel panel-default panel-size">
					<div class="panel-body">
						<%-- <form:form method="POST" commandName=""
							cssClass="form-horizontal">
							<div class="row-fluid">
								<div class="span4">
									 <div class="formGroup"></div>
								</div>
								<div class="span3">
									 <div class="formGroup"></div>
								</div>
								<div class="span6"></div>
							</div>
							<hr />
							<div class="row-fluid">
								<div class="span2">
									<div class="form-group">
										 
									</div>
								</div>
								<div class="span2">
									<div class="form-group">
										 
									</div>
								</div>
								<div class="span4">
									<div class="form-group">
										 
									</div>
								</div>

								<div class="span2">
									<button class="btn btn-lg btn-primary" type="submit" name="method" value="filter" style="min-width:178px" >
										<s:message code="inspection.filter.text" /></button> 
								</div>

								<div class="span2">
									<button class="btn btn-lg btn-primary" type="submit" name="method" value="export" style="min-width:178px" >
										<s:message code="inspection.export.text" /></button> 
								</div>

							</div>
						</form:form> --%>
						<hr />
						<div class="span12" style="overflow: auto">
							<!-- Application No, Application Type, District, Village, Street, House/Plot, 
						Phone Number, Duration in status “Inspection Paid” -->
							<table class="table table-condensed table-hover">
								<thead>
									<tr>
										<th><s:message code="inspection.col.ApplicationNumber" /></th>
										<th><s:message code="inspection.col.ApplicationType" /></th>
										<th><s:message code="inspection.col.ApplicationDistrict" /></th>
										<th><s:message code="inspection.col.ApplicationVillage" /></th>
										<th><s:message code="inspection.col.ApplicationStreet" /></th>
										<th><s:message code="inspection.col.ApplicationHousePlot" /></th>
										<th><s:message
												code="inspection.col.ApplicationPhoneNumber" /></th>
										<th><s:message
												code="inspection.col.ApplicationDurationInStatus" /></th>
										<th>&nbsp;</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${scheduledApplications}" var="application">
										<tr class="active">
											<td>${application.applicationNumber}</td>
											<td>${application.applicationType}</td>
											<td>${application.district}</td>
											<td>${application.village}</td>
											<td>${application.street}</td>
											<td>${application.housePlot}</td>
											<td>${application.phoneNumber}</td>
											<td>${application.duration}</td>
											<td><a
												href="<c:url value="/employee/inspection/pendingscheduling/"/>${application.codApplication}"><s:message
														code="schedule.inspection.link" /></a></td> 
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