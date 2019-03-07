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
					<li><a href="<c:url value="/client/application/"/>${codApplication}?edit=${edit}"><s:message
								code="tab.clientapplication.applicationdata" /></a></li>
					<li><a href="<c:url value="/client/application/statusinformation/"/>${codApplication}?edit=${edit}"><s:message
								code="tab.clientapplication.statusinfo" /></a></li>
					<li class="active"><a href="<c:url value="/client/application/pendinginvoice/"/>${codApplication}?edit=${edit}"><s:message
								code="tab.clientapplication.pendinginvoices" /></a></li>
								</ul>
				<a class="btn btn-lg btn-primary"
					href="<c:url value="/client/applications"/>" role="button"><s:message
								code="btnbacktoapplications.label"/></a>
				<h3 class="module-title-short"> 
						<span class="selected"><s:message
								code="tab.clientapplication.pendinginvoices" /></span> 				
				</h3>
				<form:form method="POST" commandName="pendingInvoiceList"
					cssClass="form-horizontal dropzone" id="frmpendingInvoiceList"
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
								code="tab.clientapplication.pendinginvoices" /></legend>
								<div class="row-fluid">
							<div class="span12" style="overflow: auto">
								<table class="table table-condensed table-hover">
									<thead>
										<tr>
											<!-- <th>Invoice No</th> -->
											<th>Invoice Type</th>
											<th>Invoice Date</th>
											<th>Invoice Amount</th>
											<!-- <th>Payment Date</th> -->
											<th>Invoice Status</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${pendingInvoiceList.invoices}" var="invoice">
											<tr class="active">
												<%-- <td>${invoice.invoiceNumber}</td> --%>
												<td>${invoice.invoiceType}</td>
												<td>${invoice.invoiceDate}</td>
												<td><fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${invoice.invoiceAmount}" /></td>
												<%-- <td>${invoice.paymentDate}</td> --%>
												<td>${invoice.invoiceStatus}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
						
						</fieldset>
				</form:form>

				<div class="bottom-border">&nbsp;</div>
			</div>
		</div>
 

 
