<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
 
<div class="row-fluid">
	<div class="span12 post-page">
		<h3 class="module-title-short">
			<span class="selected"><s:message code="complaint.view.title" /></span>
		</h3> 
		<form:form method="POST" commandName="complaintForm"
			cssClass="register" acceptCharset="ISO-8859-1" style="padding:5px;"
			id="frmBillComplaint">
			<form:errors path="*" element="div" cssClass="formGroup has-errors" />
			<p class="has-errors">
				<c:out value="${errorInfo.message}"></c:out>
			</p>
			<fieldset>
				<legend>
					<s:message code="complaint.complaintdetails.text" />
				</legend>
				<div class="row-fluid">
					<div class="span8">
						<div class="formGroup">
							<form:label path="complaintDetail.contractNumber"
								cssErrorClass="has-errors">
								<s:message code="complaint.servicecontractnumber.text" />
							</form:label> 
							<form:input path="complaintDetail.contractNumber"
								cssClass="form-control" readonly="true"
								cssErrorClass="form-control has-errors" id="billContractNumber"
								type="text" style="width:88%;" />
							<%-- <form:select path="complaintDetail.contractNumber"
								cssClass="form-control text-uppercase"
								cssErrorClass="form-control has-errors" id="billContractNumber"
								required="required" placeholder="contract.." style="width:90%;"> 
								<c:forEach items="${contracts}" var="contract">
									<form:option value="${contract.contractNumber}" label="${contract.contractNumberWithDescription}" />
								</c:forEach>
							</form:select> --%>
							<form:errors path="complaintDetail.contractNumber"
								cssClass="has-errors" element="span" />

						</div>
					</div> 
					</div>
					<div class="row-fluid" id="BillFields" > <!-- style="display:none;" -->
					<div class="span4">
						<div class="formGroup">
							<form:label path="complaintDetail.complaintType"
								cssErrorClass="has-errors">
								<s:message code="complaint.complainttype.label" />
							</form:label>
							<form:select path="complaintDetail.complaintType"
								cssClass="form-control text-uppercase" required="true" disabled="true"
								cssErrorClass="form-control has-errors" id="complaintType">
								<form:option value="" label="--- None ---" />
								<c:forEach items="${billComplaintTypes}" var="tipS">
									<form:option value="${tipS.tipo}" label="${tipS.descTipo}" />
								</c:forEach>
							</form:select>
							<form:errors path="complaintDetail.complaintType"
								cssClass="has-errors" element="span" />
						</div>
					</div>
					<div class="span4">
						<div class="formGroup">
							<form:label path="complaintDetail.billNumber"
								cssErrorClass="has-errors">
								<s:message code="complaint.billnumber.label" />
							</form:label>
							<form:input path="complaintDetail.billNumber"
								cssClass="form-control" cssErrorClass="form-control has-errors"
								id="billnumber" readonly="true" type="text"
								required="required" />
							<form:errors path="complaintDetail.billNumber"
								cssClass="has-errors" element="span" />

						</div>
					</div>
						
					</div>
					<div class="row-fluid" id="BillFields2">
					<div class="span8">
						<div class="formGroup">
							<form:label path="complaintDetail.comments"
								cssErrorClass="has-errors">
								<s:message code="complaint.description.label" />
							</form:label>
							<form:textarea path="complaintDetail.comments"
								cssClass="form-control" id="billComplaintComment" readonly="true"
								placeholder="comments.." required="true" style="width: 100%;" />
							<form:errors path="complaintDetail.comments"
								cssClass="has-errors" element="span" />

						</div>
					</div>

				</div>

			<div class="row-fluid">
				<div class="span4"></div>
				<div class="span4"></div>
				<div class="span4"></div>
			</div> 

			</fieldset> 

		</form:form>
					 
		<div class="bottom-border">&nbsp;</div>
	</div>
</div>  
<script type="text/javascript">
$(document).ready(function() {
	 
	  
});

</script>
