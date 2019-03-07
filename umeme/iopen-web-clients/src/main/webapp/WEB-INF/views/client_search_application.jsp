<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>


		<div class="row-fluid">
			<div class="span12 post-page">			
				
				
				<h3 class="module-title-short">
					<span class="selected"><s:message code="client.application.search.text" /></span>
				</h3>
				<div class="panel panel-default panel-size">
					<div class="panel-body">
						<form:form commandName="application" cssClass="form-horizontal">
							<div class="row-fluid">						
								<div class="span5"> 
								<div class="formGroup">
									<form:label path="applicationNumber">
										<s:message code="applicationlist.number.label" />
									</form:label>
									</div>
								</div>
								<div class="span4">
									<div class="formGroup">
									<form:input path="applicationNumber"
										cssClass="form-control" id="applicationNumber"
										placeholder="application no.." required="true"/>
								</div>
								</div>
								<div class="span3"><button class="btn btn-lg btn-primary" type="submit">
										Search Application</button></div>
							</div> 
							<div class="row-fluid">	
							<div class="span12">
								<div class="formGroup">
									<form:errors path="*" cssClass="has-errors" element="span"/>
									<p class="has-errors"><c:out value="${errorInfo.message}"></c:out></p>
								</div>
							</div>
							</div>
							
						</form:form> 
						<hr />
						<div class="span12" style="overflow: auto">
						<table class="table table-condensed table-hover">
							<thead>
								<tr>
									<th>Application Date</th>
									<th>Application No.</th>
									<th>Application type</th>
									<th>Application Status</th> 
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${applicationList}" var="application">
									<tr class="active">
										<td>${application.applicationDate}</td>
										<td>  ${application.applicationNumber}
										</td>
										<td>${application.applicationType}</td>  
										<td>${application.applicationCurrentStage}</td> 

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