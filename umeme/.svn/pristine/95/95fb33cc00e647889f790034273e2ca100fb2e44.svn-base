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
					code="client.application.incomplete.text" /></span>
		</h3>
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

				<%-- <div class="row-fluid">
							
							<div class="span3">
								<a class="btn btn-lg btn-primary"
									href="<c:url value="/client/application/new"/>" role="button">New
									Application</a>
							</div>

						</div>
						<hr /> --%>
				<div class="row-fluid">
					<div class="span12">
						<table class="table table-condensed table-hover">
							<thead>
								<tr>
									<th>Tracking No.</th>
									<th>Application Date</th>
									<th>Application type</th>
									<th>&nbsp;</th>
									<th>&nbsp;</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${applications}" var="application">
									<c:set var="application_type"
										value="${application.iopenApplication.applicationType}" />
									<tr class="active">
										<td>${application.iopenApplication.codApplication}</td>
										<td>${application.iopenApplication.fActual}</td>
										<td>${defaultValues.get(application.iopenApplication.applicationType)}</td>
										<td><a
											href="<c:url value="/client/application/new?codApplication="/>${application.iopenApplication.codApplication}&complete=false">Continue</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>

		<div class="bottom-border">&nbsp;</div>
	</div>
</div>