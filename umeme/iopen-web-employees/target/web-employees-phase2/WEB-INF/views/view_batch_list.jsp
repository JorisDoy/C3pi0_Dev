<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>

<div id="main" class="wrap post-template">
	<div class="container">
		<div class="row-fluid">
			<div class="span12 post-page"style=" margin-bottom:0">
			<ul class="nav nav-tabs"> 
		<li ><a href="<c:url value="/employee/applications"/>"><s:message code="application.search.title" /></a></li>	
					<%-- <li><a href="<c:url value="/employee/applications/currentStageApplicationNumberFilters"/>"><s:message code="employee.applicationstage.search" /></a></li> --%>
					<li><a href="<c:url value="/employee/inspection/rejectedinspections"/>"><s:message code="employee.rejectedinspection.stage" /></a></li>
					<li><a href="<c:url value="/employee/inspection/pendingscheduling?schedule=false"/>"><s:message code="inspection.schedule.tab" /></a></li>
					<li><a href="<c:url value="/employee/inspection/pendinginspection?schedule=true"/>"><s:message code="inspection.scheduleexpecting.tab" /></a></li>	
					<li><a href="<c:url value="/employee/connection/pendingscheduling?schedule=false"/>"><s:message code="connection.notscheduled.tab" /></a></li>
					<li><a href="<c:url value="/employee/connection/pendingconnection?schedule=true"/>"><s:message code="connection.scheduleexpecting.tab" /></a></li>
					<li class="active"><a href="<c:url value="/employee/batch/list"/>"><s:message code="iopen.batch.title" /></a></li>
												
				</ul>
				<h3 class="module-title-short">
					<span class="selected"><s:message code="iopen.batch.title" /></span>
				</h3>

			</div>

			<div class="row-fluid">

				<div class="span12" style="overflow: auto;">
					<table class="table table-condensed table-hover">
						<thead>
							<tr>
								<th><s:message code="batch.col.jobname" /></th>
								<!--  <th><s:message code="batch.col.nextfiretime" /></th> -->
								<th><s:message code="batch.col.jobgroup" /></th>
								<th><s:message code="batch.col.nextfiretime" /></th>
								<th><s:message code="batch.col.action" /></th>
							</tr>
						</thead>
						<tbody>

							<c:forEach items="${scheduler.quartzJobList}" var="quartzJob">
								<tr>
									<td>${quartzJob.jobName }</td>
									<td> ${quartzJob.jobGroup  }</td>
									 
								<td><fmt:formatDate value="${quartzJob.nextFireTime}" pattern="yyyy-MM-dd HH:mm:ss" />
								</td>
								
								<td>
								<a href="<c:url value="/employee/batch/fire"/>?jobName=${quartzJob.jobName}&jobGroup=${quartzJob.jobGroup}">
										<s:message code="batch.col.actionname" />
										</a>
								</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			
		</div>
	</div>

</div>
