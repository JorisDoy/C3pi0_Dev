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
					<li><a href="<c:url value="/employee/inspection/pendingscheduling?schedule=false"/>"><s:message code="inspection.schedule.tab" /></a></li>
					<li><a href="<c:url value="/employee/inspection/pendinginspection?schedule=true"/>"><s:message code="inspection.scheduleexpecting.tab" /></a></li>	
					<li class="active"><a href="<c:url value="/employee/connection/pendingscheduling?schedule=false"/>"><s:message code="connection.notscheduled.tab" /></a></li>
					<li ><a href="<c:url value="/employee/connection/pendingconnection?schedule=true"/>"><s:message code="connection.scheduleexpecting.tab" /></a></li>
					<li><a href="<c:url value="/employee/batch/list"/>"><s:message code="iopen.batch.title" /></a></li>
							
				</ul>
				<h3 class="module-title-short">
					<span class="selected"><s:message
							code="connection.notscheduled.tab" /></span>
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
						
						<!-- Filters -->
						<form:form method="POST" commandName="applicationListFilter"
							cssClass="form-horizontal">
							<div class="row-fluid">
							<div class="span3">
									<div class="formGroup">
										<form:label path="district" cssErrorClass="has-errors">
											<s:message code="application.district.label" />
										</form:label>									
										<form:select path="district" cssClass="form-control text-uppercase"
											cssErrorClass="form-control has-errors" id="district"
											required="required" placeholder="district">
											<form:option value="0" label="ALL" /> 
										<c:forEach items="${companyDistricts}" var="district">
											<form:option value="${district.codUnicom}"
												label="${district.nomUnicom}" />
										</c:forEach>										
										</form:select>

										<form:errors path="district" cssClass="has-errors"
											element="span" />
									</div>
								</div>
								
								<div class = "span3">
									<div class="formGroup">
										<form:label path="workType">
											<s:message code="connection.col.PoleService" />
										</form:label>
										<form:select path="workType"
											cssClass="form-control text-uppercase" 
											cssErrorClass="form-control has-errors" id="workType">
											<form:option value="" label="--- Select ---" />
											<c:forEach items="${workTypes}" var="tipS">
												<form:option value="${tipS.tipo}" label="${tipS.descTipo}" />
											</c:forEach>
										</form:select>
										<form:errors path="workType" cssClass="has-errors"
											element="span" />
									</div>
								</div>								
								
								<div class="span3">
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
								<div class="span3">
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
							<div class="row-fluid">
								<div class="span3">
										<p>&nbsp</p>
										<button class="btn btn-lg btn-primary" type="submit" name="method" value="filter" style="min-width:178px" >
										Filter</button>									 
								</div>	
							</div>
						</form:form>
						<!-- End Filter -->
						<hr />
						<div class="span12" style="overflow: auto; padding-right:5px">
							<!-- Application No, Application Type, District, Village, Street, House/Plot, 
						Phone Number, Duration in status “Inspection Paid” -->
							<table class="table table-condensed table-hover" data-toggle="table">
								<thead>
									<tr>
										<th><s:message code="connection.col.ApplicationNumber" /></th>
										<th><s:message code="connection.col.ApplicationType" /></th>
										<th><s:message code="connection.col.PoleService" /></th>
										<th><s:message code="connection.col.ApplicationDistrict" /></th>
										<th><s:message code="connection.col.ApplicationVillage" /></th>
										<th><s:message code="connection.col.ApplicationStreet" /></th>
										<th><s:message code="connection.col.ApplicationHousePlot" /></th>
										<th><s:message
												code="connection.col.ApplicationPhoneNumber" /></th>
										<th data-sortable="true"><s:message
												code="connection.col.ApplicationDurationInStatus" /></th>
										<th>&nbsp;</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${scheduledApplications}" var="application">
										<tr class="active">
											<td>${application.applicationNumber}</td>
											<td>${application.applicationType}</td>
											<td>${application.workTypeDesc}</td>
											<td>${application.district}</td>
											<td>${application.village}</td>
											<td>${application.street}</td>
											<td>${application.housePlot}</td>
											<td>${application.phoneNumber}</td>
											<td>${application.duration}</td>
											<td><a
												href="<c:url value="/employee/connection/pendingscheduling/"/>${application.codApplication}"><s:message
														code="schedule.connection.link" /></a></td> 
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<div class="span12" ><p>&nbsp</p></div>					
					</div>
				</div>

				<div class="bottom-border">&nbsp;</div>
			</div>
		</div>
	</div>
</div>