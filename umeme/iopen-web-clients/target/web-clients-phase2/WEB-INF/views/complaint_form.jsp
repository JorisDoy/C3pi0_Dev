<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!-- <div id="main" class="post-template" style="padding-top : 0;">
	<div class="container"> -->
 
<style>
.pagination {
	display: inline-block;
	padding-left: 0;
	margin: 20px 0;
	border-radius: 4px
}

.pagination>li {
	display: inline
}

.pagination>li>a, .pagination>li>span {
	position: relative;
	float: left;
	padding: 6px 12px;
	margin-left: -1px;
	line-height: 1.42857143;
	color: #337ab7;
	text-decoration: none;
	background-color: #fff;
	border: 1px solid #ddd
}

.pagination>li:first-child>a, .pagination>li:first-child>span {
	margin-left: 0;
	border-top-left-radius: 4px;
	border-bottom-left-radius: 4px
}

.pagination>li:last-child>a, .pagination>li:last-child>span {
	border-top-right-radius: 4px;
	border-bottom-right-radius: 4px
}

.pagination>li>a:focus, .pagination>li>a:hover, .pagination>li>span:focus,
	.pagination>li>span:hover {
	z-index: 3;
	color: #23527c;
	background-color: #eee;
	border-color: #ddd
}

.pagination>.active>a, .pagination>.active>a:focus, .pagination>.active>a:hover,
	.pagination>.active>span, .pagination>.active>span:focus, .pagination>.active>span:hover
	{
	z-index: 2;
	color: #fff;
	cursor: default;
	background-color: #337ab7;
	border-color: #337ab7
}

.pagination>.disabled>a, .pagination>.disabled>a:focus, .pagination>.disabled>a:hover,
	.pagination>.disabled>span, .pagination>.disabled>span:focus,
	.pagination>.disabled>span:hover {
	color: #777;
	cursor: not-allowed;
	background-color: #fff;
	border-color: #ddd
}

.pagination-lg>li>a, .pagination-lg>li>span {
	padding: 10px 16px;
	font-size: 18px;
	line-height: 1.3333333
}

.pagination-lg>li:first-child>a, .pagination-lg>li:first-child>span {
	border-top-left-radius: 6px;
	border-bottom-left-radius: 6px
}

.pagination-lg>li:last-child>a, .pagination-lg>li:last-child>span {
	border-top-right-radius: 6px;
	border-bottom-right-radius: 6px
}

.pagination-sm>li>a, .pagination-sm>li>span {
	padding: 5px 10px;
	font-size: 12px;
	line-height: 1.5
}

.pagination-sm>li:first-child>a, .pagination-sm>li:first-child>span {
	border-top-left-radius: 3px;
	border-bottom-left-radius: 3px
}

.pagination-sm>li:last-child>a, .pagination-sm>li:last-child>span {
	border-top-right-radius: 3px;
	border-bottom-right-radius: 3px
}

.pager {
	padding-left: 0;
	margin: 20px 0;
	text-align: center;
	list-style: none
}

.pager li {
	display: inline
}

.pager li>a, .pager li>span {
	display: inline-block;
	padding: 5px 14px;
	background-color: #fff;
	border: 1px solid #ddd;
	border-radius: 15px
}

.pager li>a:focus, .pager li>a:hover {
	text-decoration: none;
	background-color: #eee
}

.pager .next>a, .pager .next>span {
	float: right
}

.pager .previous>a, .pager .previous>span {
	float: left
}

.pager .disabled>a, .pager .disabled>a:focus, .pager .disabled>a:hover,
	.pager .disabled>span {
	color: #777;
	cursor: not-allowed;
	background-color: #fff
}
</style>
<div class="row-fluid">
	<div class="span12 post-page">
		<h3 class="module-title-short">
			<span class="selected"><s:message code="complaint.new.title" /></span>
		</h3>
		<%-- <div class="row-fluid">
		<div class="span2">
			 <s:message code="complaint.subject.text" />
		</div> 
		<div class="span2">
			<input type="radio" name="complaint_option" id="bill_radio" value="1"> <s:message code="complaint.subject1.text" />
		</div>
		<div class="span2">
			<input type="radio" name="complaint_option" id="outage_radio" value="2"> <s:message code="complaint.subject2.text" /> 
		</div>
		<div class="span2">
			 
		</div>
		</div> --%>
		<div class="row-fluid">
			<div class="span4">
				<div class="formGroup">
					<label>
						<s:message code="complaint.subject.text" />
					</label> 
					<select id="bill_regarding"> 
						<option value="1"><s:message code="complaint.subject1.text" /></option>
						<option value="2"><s:message code="complaint.subject2.text" /></option>
					</select>

				</div>
			</div>
		<div class="span4"> </div>
		<div class="span4"> </div>
		
		</div>
		<!-- <hr/> -->
		<form:form method="POST" commandName="complaintForm"
			cssClass="register" acceptCharset="ISO-8859-1" style="padding:5px; display:none;"
			id="frmOutageComplaint">
			<form:errors path="*" element="div" cssClass="formGroup has-errors" />
			<p class="has-errors">
				<c:out value="${errorInfo.message}"></c:out>
			</p>
			<fieldset>
				<legend>
					<s:message code="complaint.installationdetails.text" />
				</legend>
				<div class="row-fluid">
					<div class="span6">
						<div class="formGroup">
							<form:label path="complaintDetail.contractNumber"
								cssErrorClass="has-errors">
								<s:message code="complaint.servicecontractnumber.text" />
							</form:label>
							<%-- <form:input path="complaintDetail.contractNumber"
										cssClass="form-control"
										cssErrorClass="form-control has-errors" id="contractNumber"
										type="text" /> --%>
							<form:select path="complaintDetail.contractNumber"
								cssClass="form-control text-uppercase"
								cssErrorClass="form-control has-errors" id="contractNumber"
								required="required" placeholder="contract.." style="width:90%;"> 
								<c:forEach items="${contracts}" var="contract">
									<form:option value="${contract.contractNumber}" label="${contract.contractNumberWithDescription}" />
								</c:forEach>
							</form:select>
							<form:errors path="complaintDetail.contractNumber"
								cssClass="has-errors" element="span" />

						</div>
					</div>
					<c:url var="findComplaintDetailsByContractNumberURL"
						value="/rest/complaints" />
					<div class="span4">
						<%-- <div class="formGroup">
									<form:label path="complaintDetail.meterNumber"
										cssErrorClass="has-errors">
										<s:message code="complaint.meternumber.text" />
									</form:label>
									<form:input path="complaintDetail.meterNumber"
										cssClass="form-control"
										cssErrorClass="form-control has-errors" id="meterNumber"
										type="text" />
									<form:errors path="complaintDetail.meterNumber"
										cssClass="has-errors" element="span" />

								</div> --%>
					</div>
					<div class="span2"></div>
				</div>
			</fieldset>
			<fieldset>
				<legend>
					<s:message code="complaint.complaintdetails.text" />
				</legend>
				<div class="row-fluid">
					<div class="span4">
						<div class="formGroup">
							<form:label path="complaintDetail.complaintNumber"
								cssErrorClass="has-errors">
								<s:message code="complaint.complaintnumber.label" />
							</form:label>
							<form:input path="complaintDetail.complaintNumber"
								cssClass="form-control" cssErrorClass="form-control has-errors"
								id="complaintNumber" readonly="true" type="text"
								required="required" placeholder="Complaint Number..." />
							<form:errors path="complaintDetail.complaintNumber"
								cssClass="has-errors" element="span" />
						</div>
					</div>
					<div class="span4">
						<div class="formGroup">
							<form:label path="complaintDetail.previousCalls"
								cssErrorClass="has-errors">
								<s:message code="complaint.previouscalls.label" />
							</form:label>
							<form:input path="complaintDetail.previousCalls"
								cssClass="form-control" cssErrorClass="form-control has-errors"
								id="previouscalls" readonly="true" type="text"
								required="required" placeholder="Previous calls..." />
							<form:errors path="complaintDetail.previousCalls"
								cssClass="has-errors" element="span" />

						</div>
					</div>
					<div class="span4">
						<div class="formGroup">
							<form:label path="complaintDetail.complaintType"
								cssErrorClass="has-errors">
								<s:message code="complaint.complainttype.label" />
							</form:label>
							<form:select path="complaintDetail.complaintType"
								cssClass="form-control text-uppercase" required="true"
								cssErrorClass="form-control has-errors" id="complaintType">
								<form:option value="" label="--- None ---" />
								<c:forEach items="${complaintTypes}" var="tipS">
									<form:option value="${tipS.codigo}" label="${tipS.descripcion}" />
								</c:forEach>
							</form:select>
							<form:errors path="complaintDetail.complaintType"
								cssClass="has-errors" element="span" />
						</div>
					</div>
				</div>
				<div class="row-fluid">
					<c:url var="findComplaintNatureByComplaintNumberURL"
						value="/rest/complaints/complaintNature" />
					<div class="span4">
						<div class="formGroup">
							<form:label path="complaintDetail.complaintNature"
								cssErrorClass="has-errors">
								<s:message code="complaint.complaintnature.label" />
							</form:label>
							<form:select path="complaintDetail.complaintNature"
								cssClass="form-control text-uppercase" required="true"
								cssErrorClass="form-control has-errors" id="complaintNature">
								<form:option value="" label="--- None ---" />
								<c:forEach items="${complaintNatures}" var="tipS">
									<form:option value="${tipS.tipAviso}"
										label="${tipS.descripcion}" />
								</c:forEach>
							</form:select>
							<form:errors path="complaintDetail.complaintNature"
								cssClass="has-errors" element="span" />
						</div>
					</div>
					<div class="span4">
						<div class="formGroup">
							<form:label path="complaintDetail.detectionDate">
								<s:message code="complaint.detectiondate.label" />

							</form:label>
							<div class="input-append date" id="detectionDate" data-date=""
								data-date-format="dd/mm/yyyy">
								<form:input path="complaintDetail.detectionDate" type="text"
									id="complaintdetectionDate" cssClass="form-control"
									cssErrorClass="form-control has-errors" role="aria"
									required="true" />

								<span class="add-on"><i class="icon-calendar"></i></span>
							</div>
							<form:errors path="complaintDetail.detectionDate"
								cssClass="has-errors" element="span" />
						</div>
					</div>
					<div class="span4">
						<div class="formGroup">
							<form:label path="complaintDetail.scope"
								cssErrorClass="has-errors">
								<s:message code="complaint.complaintscope.label" />
							</form:label>

							<form:select path="complaintDetail.scope"
								cssClass="form-control text-uppercase" required="true"
								cssErrorClass="form-control has-errors"
								id="complaintDetailScope">
								<form:option value="" label="--- None ---" />
								<c:forEach items="${scopes}" var="tipS">
									<form:option value="${tipS.codigo}" label="${tipS.descripcion}" />
								</c:forEach>
							</form:select>
							<form:errors path="complaintDetail.scope" cssClass="has-errors"
								element="span" />
						</div>
					</div>


				</div>
				<div class="row-fluid">
					<div class="span12">
						<div class="formGroup">
							<form:label path="complaintDetail.comments"
								cssErrorClass="has-errors">
								<s:message code="complaint.description.label" />
							</form:label>
							<form:textarea path="complaintDetail.comments"
								cssClass="form-control" id="connectionComment"
								placeholder="comments.." required="true" style="width: 100%;" />
							<form:errors path="complaintDetail.comments"
								cssClass="has-errors" element="span" />

						</div>
					</div>

				</div>
			</fieldset>
			<fieldset>
				<legend>
					<s:message code="complaint.locationdetails.text" />
				</legend>
				<div class="row-fluid">
					<div class="span4">
						<div class="formGroup">
							<form:label path="customerProfile.premiseInformation.district"
								cssErrorClass="has-errors">
								<s:message code="complaint.district.label" />
							</form:label>
							<form:select path="customerProfile.premiseInformation.district"
								cssClass="form-control text-uppercase" readonly="true"
								cssErrorClass="form-control has-errors" id="district"
								required="required" placeholder="district">
								<form:option value="0" label="--- None ---" />
								<c:forEach items="${districts}" var="district">
									<form:option value="${district.codMunic}"
										label="${district.nomMunic}" />
								</c:forEach>
							</form:select>
							<form:errors path="customerProfile.premiseInformation.district"
								cssClass="has-errors" element="span" />
						</div>
					</div>
					<div class="span4">
						<div class="formGroup">
							<form:label path="customerProfile.premiseInformation.village"
								cssErrorClass="has-errors">
								<s:message code="myprofile.village.label" />
							</form:label>
							<form:select path="customerProfile.premiseInformation.village"
								cssClass="form-control text-uppercase" readonly="true"
								cssErrorClass="form-control has-errors" id="village"
								required="required">
								<form:option value="0" label="--- None ---" />
								<c:forEach items="${villages}" var="village">
									<form:option value="${village.codLocal}"
										label="${village.nomLocal}" />
								</c:forEach>
							</form:select>
							<form:errors path="customerProfile.premiseInformation.village"
								cssClass="has-errors" element="span" />
						</div>
					</div>
					<div class="span4">
						<div class="formGroup">
							<form:label path="customerProfile.premiseInformation.street"
								cssErrorClass="has-errors">
								<s:message code="myprofile.street.label" />
							</form:label>
							<form:select path="customerProfile.premiseInformation.street"
								cssClass="form-control text-uppercase" readonly="true"
								cssErrorClass="form-control has-errors" id="street"
								required="required">
								<form:option value="0" label="--- None ---" />
								<c:forEach items="${streets}" var="street">
									<form:option value="${street.codCalle}"
										label="${street.nomCalle}" />
								</c:forEach>
							</form:select>
							<form:errors path="customerProfile.premiseInformation.street"
								cssClass="has-errors" element="span" />
						</div>
					</div>
				</div>
				<div class="row-fluid">

					<div class="span4">
						<div class="formGroup">
							<form:label
								path="customerProfile.premiseInformation.housePlotNumber"
								cssErrorClass="has-errors">
								<s:message code="myprofile.houseplotno.label" />
							</form:label>
							<form:input
								path="customerProfile.premiseInformation.housePlotNumber"
								cssClass="form-control" readonly="true"
								cssErrorClass="form-control has-errors" id="houseplotno"
								type="text" required="required" />
							<form:errors
								path="customerProfile.premiseInformation.housePlotNumber"
								cssClass="has-errors" element="span" />
						</div>
					</div>
					<div class="span4">
						<div class="formGroup">
							<form:label path="customerProfile.premiseInformation.landmark"
								cssErrorClass="has-errors">
								<s:message code="complaint.landmark.label" />
							</form:label>
							<form:input path="customerProfile.premiseInformation.landmark"
								cssClass="form-control" readonly="true"
								cssErrorClass="form-control has-errors" id="landmark"
								type="text" required="required" />
							<form:errors path="customerProfile.premiseInformation.landmark"
								cssClass="has-errors" element="span" />
						</div>
					</div>
				</div>
			</fieldset>

			<fieldset>
				<legend>
					<s:message code="complaint.customerdetails.text" />
				</legend>
				<div class="row-fluid">
					<div class="span4">
						<div class="formGroup">
							<form:label path="customerProfile.surname"
								cssErrorClass="has-errors">
								<s:message code="complaint.surname.label" />
							</form:label>
							<form:input path="customerProfile.surname"
								cssClass="form-control" cssErrorClass="form-control has-errors"
								id="surname" readonly="true" type="text" required="required"
								placeholder="surname..." />
							<form:errors path="customerProfile.surname" cssClass="has-errors"
								element="span" />

						</div>
					</div>
					<div class="span4">
						<div class="formGroup">
							<form:label path="customerProfile.middleName"
								cssErrorClass="has-errors">
								<s:message code="complaint.middlename.label" />
							</form:label>
							<form:input path="customerProfile.middleName"
								cssClass="form-control" cssErrorClass="form-control has-errors"
								id="middleName" readonly="true" type="text" required="required"
								placeholder="middleName..." />
							<form:errors path="customerProfile.middleName"
								cssClass="has-errors" element="span" />

						</div>
					</div>
					<div class="span4">
						<div class="formGroup">
							<form:label path="customerProfile.firstName"
								cssErrorClass="has-errors">
								<s:message code="complaint.firstname.label" />
							</form:label>
							<form:input path="customerProfile.firstName"
								cssClass="form-control" cssErrorClass="form-control has-errors"
								id="firstName" readonly="true" type="text" required="required"
								placeholder="firstName..." />
							<form:errors path="customerProfile.firstName"
								cssClass="has-errors" element="span" />

						</div>
					</div>

				</div>
				<div class="row-fluid">

					<div class="span4">
						<div class="formGroup">
							<form:label path="customerProfile.idType"
								cssErrorClass="has-errors">
								<s:message code="complaint.idtype.label" />
							</form:label>
							<form:select path="customerProfile.idType"
								cssClass="form-control text-uppercase" readonly="true"
								cssErrorClass="form-control has-errors" id="idType"
								required="required" placeholder="id Type..">
								<form:option value="" label="--- Select ---" />
								<c:forEach items="${idTypes}" var="idType">
									<form:option value="${idType.tipo}" label="${idType.descTipo}" />
								</c:forEach>
							</form:select>

							<form:errors path="customerProfile.idType" cssClass="has-errors"
								element="span" />
						</div>
					</div>
					<div class="span4">
						<div class="formGroup">
							<form:label path="customerProfile.idNumber"
								cssErrorClass="has-errors">
								<s:message code="complaint.idnumber.label" />
							</form:label>
							<form:input path="customerProfile.idNumber"
								cssClass="form-control" cssErrorClass="form-control has-errors"
								id="idNumber" readonly="true" type="text" required="required"
								placeholder="id number..." />

							<form:errors path="customerProfile.idNumber"
								cssClass="has-errors" element="span" />
						</div>

					</div>
					<div class="span4">
						<div class="formGroup">
							<form:label path="customerProfile.mobileNumber"
								cssErrorClass="has-errors">
								<s:message code="complaint.phonenumber.label" />
							</form:label>
							<form:input path="customerProfile.mobileNumber"
								cssClass="form-control" cssErrorClass="form-control has-errors"
								id="phoneNumber" readonly="true" type="text" required="required"
								placeholder="phone number..." />
							<form:errors path="customerProfile.mobileNumber"
								cssClass="has-errors" element="span" />
						</div>
					</div>

				</div>
			</fieldset>

			<div class="row-fluid">
				<div class="span4"></div>
				<div class="span4"></div>
				<div class="span4"></div>
			</div>

			<div class="row-fluid">
				<div class="span4"></div>
				<div class="span4">
					<button class="btn btn-lg btn-primary btn-block" type="submit">
						<s:message code="submit.value" />
					</button>
				</div>
				<div class="span4"></div>
			</div>

		</form:form>
		<form:form method="POST" commandName="complaintForm"
			cssClass="register" acceptCharset="ISO-8859-1" style="padding:5px; display:none;"
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
					<div class="span6">
						<div class="formGroup">
							<form:label path="complaintDetail.contractNumber"
								cssErrorClass="has-errors">
								<s:message code="complaint.servicecontractnumber.text" />
							</form:label>
							<%-- <form:input path="complaintDetail.contractNumber"
										cssClass="form-control"
										cssErrorClass="form-control has-errors" id="contractNumber"
										type="text" /> --%>
							<form:select path="complaintDetail.contractNumber"
								cssClass="form-control text-uppercase"
								cssErrorClass="form-control has-errors" id="billContractNumber"
								required="required" placeholder="contract.." style="width:90%;"> 
								<c:forEach items="${contracts}" var="contract">
									<form:option value="${contract.contractNumber}" label="${contract.contractNumberWithDescription}" />
								</c:forEach>
							</form:select>
							<form:errors path="complaintDetail.contractNumber"
								cssClass="has-errors" element="span" />

						</div>
					</div>
					<c:url var="findContractBillsByContractNumberURL"
						value="/rest/complaints/bill" />
					</div>
					<div class="row-fluid" id="BillFields" style="display:none;" > <!-- style="display:none;" -->
					<div class="span4">
						<div class="formGroup">
							<form:label path="complaintDetail.complaintType"
								cssErrorClass="has-errors">
								<s:message code="complaint.complainttype.label" />
							</form:label>
							<form:select path="complaintDetail.complaintType"
								cssClass="form-control text-uppercase" required="true"
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
					<div class="row-fluid" id="BillFields2" style="display:none;">
					<div class="span8">
						<div class="formGroup">
							<form:label path="complaintDetail.comments"
								cssErrorClass="has-errors">
								<s:message code="complaint.description.label" />
							</form:label>
							<form:textarea path="complaintDetail.comments"
								cssClass="form-control" id="billComplaintComment"
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

			<div class="row-fluid" id="BillFields3" style="display:none;">
				
				<div class="span4">
					<button class="btn btn-lg btn-primary btn-block" type="submit">
						<s:message code="submit.value" />
					</button>
				</div>
				<div class="span4"></div>
				<div class="span4"></div>
			</div>

			</fieldset>
			
			<%-- <div class="formGroup" hidden="true">
				<form:input path="page" cssClass="form-control text-uppercase"
					cssErrorClass="form-control has-errors" id="page"
					placeholder="page" hidden="true" />

			</div>  --%>

		</form:form>
					<div class="row-fluid" id="BillList" style="display:none;">
			<fieldset>
				<legend>
					<s:message code="complaint.billlist.text" />
				</legend> 
					<div class="span12" style="overflow: auto">
						<table class="table table-condensed table-hover">
							<thead>
								<tr>
									<th><s:message code="bill.billingDate.label" /></th>
									<th><s:message code="bill.billNumber.label" /></th>
									<%-- <th><s:message code="bill.typeOfBill.label" /></th> --%>
									<th><s:message code="bill.billStatus.label" /></th>
									<th><s:message code="bill.billAmount.label" /></th>
									<th><s:message code="bill.paidAmount.label" /></th>
									<%-- <th><s:message code="bill.outstandingAmount.label" /></th> --%>
									<%-- <th><s:message code="bill.billStatementId.label" /></th> --%>
									<th>&nbsp;</th>
								</tr>
							</thead>
							<tbody id="BillListBody" > 
								<tr class="active" id="BillListEmpty" style="display:none;">
									<td colspan="7" rowspan="6"><s:message
											code="empty.list.message" /></td>
								</tr> 
							</tbody>
						</table>
						
					</div>
					</fieldset>
					<c:if test="${noOfPages>1}">
						<nav>
							<ul class="pagination">
			
								<c:set var="previousLinkDisable" value="" />
								<c:set var="nextLinkDisable" value="" />
								<c:if test="${page==1}">
									<c:set var="previousLinkDisable" value="disabled" />
								</c:if>
								<c:if test="${page==noOfPages}">
									<c:set var="nextLinkDisable" value="disabled" />
								</c:if>
			
								<li class="${previousLinkDisable}"><a id="pagePrevious" href="#"
									aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
								</a></li>
			
								<c:forEach begin="1" end="${noOfPages}" step="1" var="i">
									<c:set var="activeClass" value="" />
									<c:if test="${i==page}">
										<c:set var="activeClass" value="active" />
									</c:if>
									<li class="${activeClass}"><a id="page${i}" class="pageclass"
										href="#"><c:out value="${i}" /></a></li>
								</c:forEach>
			
								<li class="${nextLinkDisable}"><a id="pageNext"
									href="#"
									aria-label="Next"> <span aria-hidden="true">&raquo;</span>
								</a></li>
							</ul>
						</nav>
					</c:if>
					
					</div>
		<div class="bottom-border">&nbsp;</div>
	</div>
</div>
<!-- </div>
</div> -->
<script type="text/javascript"
	src='<s:url value="/resources/assets/js/bootstrap-datepicker.js"></s:url>'>
    </script>
<script type="text/javascript"
	src='<s:url value="/resources/assets/js/bootstrap-datetimepicker.min.js"></s:url>'>
	
</script>
<script type="text/javascript">
$(document).ready(function() {
	setComplaintForm();
	
	if($('#billContractNumber').val() !=""){
		console.log("bill contract change.." + $('#billContractNumber').val());
		$.getJSON('${findContractBillsByContractNumberURL}', {
			contractNumber : $('#billContractNumber').val(),
			ajax : 'true'
		}, function(data) {
			var html='';  			
			console.log("bill contract change: returned data: " + data);
			
			
			if(data.bills.length == 0){
				console.log("empty empty");
				$("#BillListEmpty").show();
				$("#BillListBody").append('<tr class="active" id="BillListEmpty" style="display:none;">	<td colspan="7" rowspan="6"><s:message code="empty.list.message" /></td></tr>')
				
			}else{

				$("#BillListEmpty").hide();
				var len = data.bills.length;
				for ( var i = 0; i < len; i++) {
					html += '<tr class="active">';
					html += '<td>' + data.bills[i].billingDate + '</td>';
					html += '<td>' + data.bills[i].billNumber + '</td>'; 
					html += '<td>' + data.bills[i].billStatus + '</td>';  
					html += '<td>' + data.bills[i].billAmount + '</td>';  
					html += '<td>' + data.bills[i].paidAmount + '</td>';  
					//html += '<td>' + data.bills[i].outstandingAmount + '</td>';  
					html += '<td><a href="#" id="'+ data.bills[i].billNumber +'"><i class="fa fa-file-text fa-lg"></i> <span class="arrow"></span></a> </td>'; 
					html += '</tr>';
				}
				$("#BillListBody").append(html);
				
				$("#BillListBody a").click(function(){
					complaintnr=$(this).attr('id'); 
					$("#billnumber").val(complaintnr);
					$("#BillFields").show();
					$("#BillFields2").show();
					$("#BillFields3").show();
					console.log('complaint no:'+ complaintnr);
				});
			}
			 
		});
		
	}


	/* $("#BillListBody a").click(function(){
		complaintnr=$(this).attr('id'); 
		$("#billnumber").val(complaintnr);
		$("#BillFields").show();
		console.log('complaint no:'+ complaintnr);
	}); */
	
	$('#contractNumber').change(	   
			function() {
				console.log("contract change..");
				$.getJSON('${findComplaintDetailsByContractNumberURL}', {
					contractNumber : $(this).val(),
					ajax : 'true'
				}, function(data) {
					console.log("contract change: returned data: " + data);
					var html;  
					 
				});
		});
	
	$('#complaintType').change(
			function() {
				$.getJSON('${findComplaintNatureByComplaintNumberURL}', {
					complaintType : $(this).val(),
					ajax : 'true'
				}, function(data) {
					var html = '<option value="">--- Select ---</option>';
					var len = data.length;
					for ( var i = 0; i < len; i++) {
						html += '<option value="' + data[i].tipAviso + '">'
								+ data[i].descripcion + '</option>';
					}
					html += '</option>';
	 
					$('#complaintNature').html(html);
				});
	});
	
	$('#billContractNumber').change(	   
			function() {
				$("#BillFields").hide();
				$("#BillFields2").hide();
				$("#BillFields3").hide();
				$("#billnumber").val("");
				console.log("contract change..");
				$.getJSON('${findContractBillsByContractNumberURL}', {
					contractNumber : $(this).val(),
					ajax : 'true'
				}, function(data) {
					console.log("contract change: returned data: " + data.bills);
					var html='';  			
					console.log("bill contract change: returned data: " + data.bills);
					$("#BillList").show();
					$("#BillListBody").empty();
					if(data.bills.length == 0){
						console.log("empty empty");
						$("#BillListBody").append('<tr class="active" id="BillListEmpty" style="display:none;">	<td colspan="7" rowspan="6"><s:message code="empty.list.message" /></td></tr>');
						$("#BillListEmpty").show();
						
					}else{

						$("#BillListEmpty").hide();
						var len = data.bills.length;
						for ( var i = 0; i < len; i++) {
							html += '<tr class="active">';
							html += '<td>' + data.bills[i].billingDate + '</td>';
							html += '<td>' + data.bills[i].billNumber + '</td>'; 
							html += '<td>' + data.bills[i].billStatus + '</td>';  
							html += '<td>' + data.bills[i].billAmount + '</td>';  
							html += '<td>' + data.bills[i].paidAmount + '</td>';  
							//html += '<td>' + data.bills[i].outstandingAmount + '</td>';  
							html += '<td><a href="#" id="'+ data.bills[i].billNumber +'"><i class="fa fa-file-text fa-lg"></i> <span class="arrow"></span></a> </td>'; 
							html += '</tr>';
						}
						$("#BillListBody").append(html);
						$("#BillListBody a").click(function(){
							complaintnr=$(this).attr('id'); 
							$("#billnumber").val(complaintnr);
							$("#BillFields").show();
							$("#BillFields2").show();
							$("#BillFields3").show();
							console.log('complaint no:'+ complaintnr);
						});
					} 
					 
				});
		});
	
	$("#bill_regarding").change(function() {
		setComplaintForm();
    });
	 
	
function setComplaintForm(){
		
		if($('#bill_regarding').val()=='1'){
			$("#BillList").show();
			$("#frmBillComplaint").show();
			$("#frmOutageComplaint").hide();
			/* $('#district').removeAttr('disabled');
			$('#applicationStatus').removeAttr('disabled');
			$('#applicationNumber').attr('disabled','disabled'); */ 
		}
		
		if($('#bill_regarding').val()=='2'){
			$("#BillList").hide();
			$("#frmBillComplaint").hide();
			$("#frmOutageComplaint").show();
			/* $('#district').attr('disabled','disabled');  */		 
		}
}
	//date control
	var nowTemp = new Date();
	var now = new Date(nowTemp.getFullYear(), nowTemp.getMonth(), nowTemp.getDate(), 0, 0, 0, 0);
	var checkin = $('#detectionDate').datepicker({
		  onRender: function(date) {
		    return date.valueOf() > now.valueOf() ? 'disabled' : '';
		  }
		}).on('changeDate', function(ev) {			   
		  checkin.hide(); 
		}).data('datepicker');
	
	$('.pageclass').click(function() {
		pageNo = $(this).text()
		$("#page").val(pageNo);
		$("#bill-filter")[0].submit();
	});
	
	$('#pagePrevious').click(function() {
		pageNo = $("#page").val();
		
		if(pageNo > 1){
			$("#page").val(pageNo - 1);
			$("#bill-filter")[0].submit();
		}			
	});
	
	$('#pageNext').click(function() {
		
		pages = '${noOfPages}';
		pageNo = $("#page").val();			
		if(pageNo < pages){
			$("#page").val(parseInt(pageNo) + 1);
			$("#bill-filter")[0].submit();
		}
	});
	  
});

</script>
