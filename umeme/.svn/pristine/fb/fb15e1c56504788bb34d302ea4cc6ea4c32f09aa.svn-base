<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<div class="row-fluid">
	<div class="span12 post-page">
		<h3 class="module-title-short">
			<span class="selected"><s:message
					code="client.application.status.text" /></span>
		</h3>
		<c:choose>
    <c:when test="${empty applications}">
    <s:message code="application.zero.applications.label" />
    </c:when>
		<c:otherwise>
		<div class="panel panel-default panel-size">
			<div class="panel-body">
				<div class="row-fluid">
					<div class="span12">
						<%-- <form:form commandName="applicationListFilter"
									cssClass="form-horizontal">
									<div class="row-fluid">
										<div class="span5"></div>
										<div class="span4">
											<div class="formGroup">
												<form:label path="applicationStatus"
													cssErrorClass="has-errors">
													<s:message code="application.status.label" />
												</form:label>
												<form:select path="applicationStatus"
													cssClass="form-control text-uppercase"
													cssErrorClass="form-control has-errors"
													id="applicationStatus" placeholder="status">
													<form:option value="ALL" label="ALL" />
													<c:forEach items="${statuses}" var="status">
														<form:option value="${status.statusCode}"
															label="${status.statusDescription}" />
													</c:forEach>
												</form:select>
		
												<form:errors cssClass="has-errors" element="span" />
											</div>
										</div>
										<div class="span3">
											<button class="btn btn-lg btn-primary" type="submit">
												Filter Applications</button>
										</div>
									</div>
								</form:form> --%>

						<form:form method="POST" commandName="applicationListFilter"
							cssClass="form-horizontal">
							<div class="row-fluid">

								<div class="span4">
									<div class="formGroup">
										<form:label path="applicationStatus"
											cssErrorClass="has-errors">
											<s:message code="application.status.label" />
										</form:label>
										<form:select path="applicationStatus"
											cssClass="form-control text-uppercase"
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
									<div class="formGroup">
										<form:label path="currentStage"
											cssErrorClass="has-errors">
											<s:message code="applicationlist.currentstage.label" />
										</form:label>
										<form:select path="currentStage"
											cssClass="form-control text-uppercase"
											cssErrorClass="form-control has-errors"
											id="currentStage" placeholder="stage">
											<form:option value="ALL" label="ALL" />
											<c:forEach items="${stages}" var="stage">
												<form:option value="${stage.estado}"
													label="${stage.descEst}" />
											</c:forEach>
										</form:select>

										<form:errors path="currentStage" cssClass="has-errors"
											element="span" />
									</div>
								</div>
								<div class="span4"></div>
								</div>
								<div class="row-fluid">
								<div class="span4">
									<div class="form-group">
										<form:label path="applicationNumber">
											<s:message code="applicationlist.number.label" />
										</form:label>
										<form:input path="applicationNumber"
											cssClass="form-control text-uppercase"
											cssErrorClass="form-control has-errors"
											id="applicationNumber" placeholder="applicationNumber" />
										<form:errors path="applicationNumber" cssClass="has-errors"
											element="span" />
									</div>
								</div>
								<div class="span4">
									<div class="form-group">
										<form:label path="trackingNumber">
											<s:message code="applicationlist.iopentackingno.label" />
										</form:label>
										<form:input path="trackingNumber"
											cssClass="form-control text-uppercase"
											cssErrorClass="form-control has-errors" id="trackingNumber"
											placeholder="trackingNumber" />
										<form:errors path="trackingNumber" cssClass="has-errors"
											element="span" />
									</div>
								</div>
								<div class="span1"></div>
								<div class="span3">
								<form:label path="trackingNumber">
											&nbsp;
										</form:label>
								<button class="btn btn-lg btn-primary" type="submit"
									name="method" value="filter" style="min-width: 178px">
									Filter Applications</button>
							</div>

							</div>

							
						</form:form>
					</div>
				</div>
				<div class="row-fluid">
					<div class="span12">
						<table class="table table-condensed table-hover">
							<thead>
								<tr>
									<th>Tracking No.</th>
									<th>Application No.</th>
									<th>Application Date</th>
									<th>Application type</th>
									<th>Application Status</th>
									<th>Application Comment</th>
									<th>Current Stage</th>
									<th>&nbsp;</th>
									<th>&nbsp;</th>
									<th>&nbsp;</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${applications}" var="application">

									<tr class="active">
										<td>${application.iopenApplication.codApplication}</td>

										<td><c:if
												test="${application.iopenApplication.estStatus == 'IA002'}">
												${application.applicationNumber}
												</c:if></td>
										<td>${application.applicationDate}</td>
										<td>${application.applicationType}</td>
										<td>${application.applicationStatus}</td>
										<td>${application.applicationComment}</td>
										<td>${application.applicationCurrentStage}</td>
										<td><a
											href="<c:url value="/client/application/"/>${application.iopenApplication.codApplication}?edit=false">View</a></td>
										<td><c:if
												test="${((application.iopenApplication.estStatus == 'IA001' || application.iopenApplication.estStatus == 'IA003') && application.iopenApplication.complete == 1)||(application.iopenApplication.estStatus == 'IA003' && application.iopenApplication.inspectionRejected == true)}">
												<a
													href="<c:url value="/client/application/"/>${application.iopenApplication.codApplication}?edit=true">Edit</a>
											</c:if></td>
										<td><c:if
												test="${application.iopenApplication.estStatus == 'IA001' && application.iopenApplication.complete == 1}">
												<a
													href="<c:url value="/client/application/cancel/"/>${application.iopenApplication.codApplication}">
													Cancel</a>
											</c:if></td>

									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		</c:otherwise>
		</c:choose>

		<div class="bottom-border">&nbsp;</div>
	</div>
</div>