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
							code="contractlisting.title" /></span>
				</h3>
				<div class="panel panel-default panel-size">
					<div class="panel-body"> 
						<table class="table table-condensed table-hover">
							<thead>
								<tr>
									<!-- <th>Supply Point</th> -->
									<th><s:message code="contractlisting.accountno.text" /></th>
									<th><s:message code="contractlisting.tariff.text" /></th>
									<th><s:message code="contractlisting.status.text" /></th> 
									<th>&nbsp;</th>
									<th>&nbsp;</th>
									<th>&nbsp;</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${contracts}" var="contract">
								 
									<tr class="active">
									
										<td>${contract.contractNumber}</td>
										
										<td>${contract.tariff}</td>
										
										<td>${contract.status}</td>
										
										<td><a href="<c:url value="/client/bill-dispatch/"/>${contract.contractNumber}">
										<s:message code="contractlisting.billdispatch.text" /></a></td>
								<!-- e.g http://localhost:8089/iopen-web-clients/client/contract/bills/205165491/1 -->								
										<td><a href="<c:url value="/client/contract/specific/bills?contractNumber=${contract.contractNumber}"/>"><s:message
								code="contractlisting.viewbill.text" /></a></td>
										<td><a href="<c:url value="/client/contract/"/>${contract.contractNumber}">
										<s:message code="contractlisting.viewcontract.text" /></a></td>
										
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>

				<div class="bottom-border">&nbsp;</div>
			</div>
		</div>
 