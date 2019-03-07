<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>
<c:set var="activestatus" value="${true}" />
<c:set var="readonlystatusbtnSubmit" value="${true}" />
<c:set var="hiddenclass" value="${'hide'}" />
<c:set var="hiddenclasswhennotapproved" value="${''}" />
<c:set var="hiddenbtnclass" value="${''}" />

<!-- SMA 20160219 UMESC-444 start -->
<c:if test="${(newCustomer == true)&&(edit == true)}">
	<c:set var="customer" value="${false}" />
</c:if>
<c:if test="${(newCustomer != true)}">
	<c:set var="customer" value="${true}" />
</c:if>
<c:if test="${(edit == false)}">
	<c:set var="customer" value="${true}" />
</c:if>
<!-- SMA 20160219 UMESC-444 end -->
<c:if
	test="${(application.iopenApplication.estStatus == 'IA001' || application.iopenApplication.estStatus == 'IA003') && application.iopenApplication.complete == 1}">
	<c:set var="activestatus" value="${false}" />
	<c:set var="readonlystatusbtnSubmit" value="${false}" />
	<c:set var="hiddenclass" value="${''}" />
</c:if>
<c:if
	test="${(application.iopenApplication.estStatus == 'IA003' && application.iopenApplication.inspectionRejected == true)}">
	<c:set var="activestatus" value="${true}" />
	<c:set var="readonlystatusbtnSubmit" value="${false}" />
	<c:set var="hiddenclass" value="${''}" />
	<c:set var="hiddenbtnclass" value="${''}" />
</c:if>
<c:if test="${edit == false}">
	<c:set var="hiddenbtnclass" value="${'hide'}" />
	<c:set var="activestatus" value="${true}" />
	<c:set var="readonlystatusbtnSubmit" value="${true}" />
</c:if>
<div class="row-fluid">
	<div class="span12 post-page">
		<ul class="nav nav-tabs">
			<li class="active"><a
				href="<c:url value="/client/application/"/>${application.iopenApplication.codApplication}?edit=${edit}"><s:message
						code="tab.clientapplication.applicationdata" /></a></li>
			<li><a
				href="<c:url value="/client/application/statusinformation/"/>${application.iopenApplication.codApplication}?edit=${edit}"><s:message
						code="tab.clientapplication.statusinfo" /></a></li>
			<li><a
				href="<c:url value="/client/application/pendinginvoice/"/>${application.iopenApplication.codApplication}?edit=${edit}"><s:message
						code="tab.clientapplication.pendinginvoices" /></a></li>
		</ul>
		<a class="btn btn-lg btn-primary"
			href="<c:url value="/client/applications"/>" role="button">Back
			to Applications list</a>
		<h3 class="module-title-short">
			<c:if test="${edit == false}">
				<span class="selected">View Application</span>
			</c:if>
			<c:if test="${edit == true}">
				<span class="selected">Edit Application</span>
			</c:if>
		</h3>
		<form:form method="POST" commandName="application"
			cssClass="form-horizontal dropzone" id="new-application"
			enctype="multipart/form-data">
			<div class="row-fluid">
				<div class="span12">
					<div class="formGroup">
						<form:errors path="*" cssClass="has-errors" element="span" />
						<p class="has-errors">
							<c:out value="${errorInfo.message}"></c:out>
						</p>
					</div>
				</div>
			</div>
			<fieldset>
				<legend>Application Information</legend>
				<div class="row-fluid">
					<div class="span4">
						<div class="formGroup">
							<form:label path="applicationDate">
								<s:message code="applicationlist.date.label" />
							</form:label>
							<form:input path="applicationDate"
								cssClass="form-control text-uppercase" id="applicationDate"
								placeholder="application date.." readonly="true" />
						</div>
					</div>
					<div class="span4">
						<div class="formGroup">
							<form:label path="applicationNumber">
								<s:message code="applicationlist.number.label" />
							</form:label>
							<c:if test="${application.iopenApplication.estStatus == 'IA002'}">

								<form:input path="applicationNumber"
									cssClass="form-control text-uppercase" id="applicationNumber"
									placeholder="application no.." readonly="true"
									value="${application.applicationNumber}" />
							</c:if>
							<c:if test="${application.iopenApplication.estStatus != 'IA002'}">
								<c:set var="hiddenclasswhennotapproved" value="${'hide'}" />
								<form:input path="applicationNumber"
									cssClass="form-control text-uppercase ${hiddenclasswhennotapproved}"
									id="applicationNumber" placeholder="application no.."
									readonly="true" value=" " />
							</c:if>
						</div>
					</div>
					<div class="span4">
						<div class="formGroup">
							<form:label path="*">
								<s:message code="applicationlist.iopentackingno.label" />
							</form:label>
							<form:input path="*" cssClass="form-control text-uppercase"
								id="applicationType" placeholder="iopen tracking no.."
								readonly="true"
								value="${application.iopenApplication.codApplication}" />
						</div>
					</div>
				</div>
				<div class="row-fluid">
					<div class="span4">
						<div class="formGroup">
							<form:label path="applicationType">
								<s:message code="applicationlist.type.label" />
							</form:label>
							<form:input path="applicationType"
								cssClass="form-control text-uppercase" id="applicationType"
								placeholder="application type.." readonly="true" />
						</div>
					</div>
					<div class="span4">
						<div class="formGroup">
							<form:label path="applicationStatus">
								<s:message code="applicationlist.status.label" />
							</form:label>
							<form:input path="applicationStatus"
								cssClass="form-control text-uppercase" id="applicationStatus"
								placeholder="application status.." readonly="true" />
						</div>
					</div>
					<div class="span4">
						<div class="formGroup">
							<form:label path="applicationCurrentStage">
								<s:message code="applicationlist.currentstage.label" />
							</form:label>
							<form:input path="applicationCurrentStage"
								cssClass="form-control text-uppercase"
								id="applicationCurrentStage" placeholder="application stage.."
								readonly="true" />
						</div>
					</div>

				</div>
				<div class="row-fluid">
					<div class="span4">
						<fmt:formatNumber type="number" maxFractionDigits="2"
							minFractionDigits="2"
							value="${application.iopenApplication.inspectionFee}"
							var="fmtInspectionFee" />
						<div class="formGroup">
							<form:label path="iopenApplication.inspectionFee">
								<s:message code="applicationlist.inspectionfee.label" />
							</form:label>
							<form:input path="*" cssClass="form-control text-uppercase"
								id="applicationinspectionFee" placeholder="inspection fee.."
								readonly="true" value="${fmtInspectionFee}" />
						</div>

					</div>
					<div class="span4">
						<div class="formGroup">
							<form:label path="applicationComment">
								<s:message code="applicationlist.comment.label" />
							</form:label>
							<form:textarea path="applicationComment"
								cssClass="form-control text-uppercase" id="applicationComment"
								placeholder="feedback.." readonly="true" />
						</div>
					</div>
					<div class="span4"></div>
				</div>
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
								<c:forEach items="${application.invoices}" var="invoice">
									<tr class="active">
										<td>${invoice.invoiceType}</td>
										<td>${invoice.invoiceDate}</td>
										<td><fmt:formatNumber type="number" maxFractionDigits="2"
												minFractionDigits="2" value="${invoice.invoiceAmount}" /></td>
										<td>${invoice.invoiceStatus}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</fieldset>

			<fieldset>
				<legend>Applicants Section</legend>
				<div class="row-fluid">
					<div class="span4">
						<div class="formGroup">
							<form:radiobutton path="iopenApplication.applicationType"
								cssClass="form-control" required="required"
								cssErrorClass="form-control has-errors" id="domestic"
								value='${defaultValues.get("application_domestic_value")}' />
							<s:message code="application.domestic.label" />
							<form:errors path="iopenApplication.applicationType"
								cssClass="has-errors" element="span" />
						</div>
					</div>
					<div class="span4">
						<div class="formGroup">
							<form:radiobutton path="iopenApplication.applicationType"
								cssClass="form-control" required="required"
								cssErrorClass="form-control has-errors" id="mediumindustrial"
								value='${defaultValues.get("application_mediumindustrial_value")}' />
							<s:message code="application.mediumindustrial.label" />
							<form:errors path="iopenApplication.applicationType"
								cssClass="has-errors" element="span" />
						</div>
					</div>
					<div class="span4">
						<div class="formGroup">
							<form:radiobutton path="iopenApplication.applicationType"
								cssClass="form-control" required="required"
								cssErrorClass="form-control has-errors" id="tou"
								value='${defaultValues.get("application_tou_value")}' />
							<s:message code="application.tou.label" />
							<form:errors path="iopenApplication.applicationType"
								cssClass="has-errors" element="span" />
						</div>
					</div>
				</div>
				<hr />
				<div class="row-fluid">
					<div class="span4">
						<div class="formGroup">
							<form:radiobutton path="iopenApplication.applicationType"
								cssClass="form-control" required="required"
								cssErrorClass="form-control has-errors" id="commercial"
								value='${defaultValues.get("application_commercial_value")}' />
							<s:message code="application.commercial.label" />
							<form:errors path="iopenApplication.applicationType"
								cssClass="has-errors" element="span" />
						</div>
					</div>
					<div class="span4">
						<div class="formGroup">
							<form:radiobutton path="iopenApplication.applicationType"
								cssClass="form-control" required="required"
								cssErrorClass="form-control has-errors" id="largeindustrial"
								value='${defaultValues.get("application_largeindustrial_value") }' />
							<s:message code="application.largeindustrial.label" />
							<form:errors path="iopenApplication.applicationType"
								cssClass="has-errors" element="span" />
						</div>
					</div>
					<div class="span4">
						<div class="formGroup">
							<form:radiobutton path="iopenApplication.applicationType"
								cssClass="form-control" required="required"
								cssErrorClass="form-control has-errors" id="streetlight"
								value='${ defaultValues.get("application_streetlight_value")}' />
							<s:message code="application.streetlight.label" />
							<form:errors path="iopenApplication.applicationType"
								cssClass="has-errors" element="span" />
						</div>
					</div>
				</div>
				<div class="row-fluid">
					<div class="span12">
						<hr />
					</div>
				</div>
			</fieldset>
			<fieldset>
				<legend>Applicants data:</legend>
				<div class="row-fluid">
					<div class="span4">
						<div class="form-group">
							<label class="control-label" for="date">Applicant Name</label>
						</div>
					</div>
					<div class="span4">
						<div class="form-group">
							<form:label path="iopenApplication.surname"
								cssErrorClass="has-errors">
								<s:message code="application.surname.label" />
							</form:label>
							<form:input path="iopenApplication.surname"
								cssClass="form-control text-uppercase"
								cssErrorClass="form-control has-errors" id="surname"
								required="required" placeholder="surname"
								readonly="${customer}" />
							<form:errors path="iopenApplication.surname"
								cssClass="has-errors" element="span" />
						</div>
					</div>
					<div class="span4">
						<div class="form-group">
							<form:label path="iopenApplication.firstName"
								cssErrorClass="has-errors">
								<s:message code="application.firstname.label" />
							</form:label>
							<form:input path="iopenApplication.firstName"
								cssClass="form-control text-uppercase"
								cssErrorClass="form-control has-errors" id="firstname"
								required="required" placeholder="firstName"
								readonly="${customer}" />
							<form:errors path="iopenApplication.firstName"
								cssClass="has-errors" element="span" />
						</div>
					</div>
				</div>
				<div class="row-fluid">
					<div class="span4"></div>
					<div class="span4">
						<div class="form-group">
							<form:label path="iopenApplication.middleName"
								cssErrorClass="has-errors">
								<s:message code="application.middlename.label" />
							</form:label>
							<form:input path="iopenApplication.middleName"
								cssClass="form-control text-uppercase"
								cssErrorClass="form-control has-errors" id="middlename"
								placeholder="middleName" readonly="${customer}" />
							<form:errors path="iopenApplication.middleName"
								cssClass="has-errors" element="span" />
						</div>
					</div>
					<div class="span4"></div>
				</div>
				<div class="row-fluid">
					<div class="span12">
						<hr />
					</div>
				</div>

				<div class="row-fluid">
					<div class="span4">
						<div class="form-group">
							<label class="control-label" for="date">Identification
								Document</label>
						</div>
					</div>
					<div class="span2">
						<div class="form-group">
							<form:radiobutton path="iopenApplication.idType"
								cssClass="form-control" disabled="${customer}"
								cssErrorClass="form-control has-errors" id="self"
								value='${defaultValues.get("application_passport_value")}' />
							<s:message code="application.passportidentity.label" />
							<form:errors path="iopenApplication.idType" cssClass="has-errors"
								element="span" />
						</div>
					</div>
					<div class="span2">
						<div class="form-group">
							<form:radiobutton path="iopenApplication.idType"
								cssClass="form-control" disabled="${customer}"
								cssErrorClass="form-control has-errors" id="self2"
								value='${defaultValues.get("application_idnumber_value")}' />
							<s:message code="application.ididentity.label" />
							<form:errors path="iopenApplication.idType" cssClass="has-errors"
								element="span" />
						</div>
					</div>

					<div class="span4">
						<div class="form-group">
							<form:label path="iopenApplication.idNumber"
								cssErrorClass="has-errors">
								<s:message code="application.idnumber.label" />
							</form:label>
							<form:input path="iopenApplication.idNumber"
								cssClass="form-control text-uppercase"
								cssErrorClass="form-control has-errors" id="idNumber"
								required="required" placeholder="idNumber"
								readonly="${customer}" />
							<form:errors path="iopenApplication.idNumber"
								cssClass="has-errors" element="span" />
						</div>
					</div>
				</div>
				<div class="row-fluid">
					<div class="span4"></div>
					<div class="span4"></div>
					<div class="span4">
						<div class="form-group">
							<form:label path="iopenApplication.tinNumber"
								cssErrorClass="has-errors">
								<s:message code="application.tinnumber.label" />
							</form:label>
							<form:input path="iopenApplication.tinNumber"
								cssClass="form-control text-uppercase"
								cssErrorClass="form-control has-errors" id="tinNumber"
								placeholder="tinNumber" readonly="${customer}" />
							<form:errors path="iopenApplication.tinNumber"
								cssClass="has-errors" element="span" />
						</div>
					</div>
				</div>

				<div class="row-fluid">
					<div class="span12">
						<hr />
					</div>
				</div>

				<div class="row-fluid">
					<div class="span4">
						<div class="form-group">
							<label class="control-label" for="date">Customer Contact</label>
						</div>
					</div>
					<div class="span4">
						<div class="form-group">
							<form:label path="iopenApplication.mobileNumber"
								cssErrorClass="has-errors">
								<s:message code="application.mobilenumber.label" />
							</form:label>
							<form:input path="iopenApplication.mobileNumber"
								cssClass="form-control text-uppercase"
								cssErrorClass="form-control has-errors" id="mobileNumber"
								required="required" placeholder="mobileNumber"
								readonly="${customer}" />
							<form:errors path="iopenApplication.mobileNumber"
								cssClass="has-errors" element="span" />
						</div>
					</div>
					<div class="span4">
						<div class="form-group">
							<form:label path="iopenApplication.officeNumber"
								cssErrorClass="has-errors">
								<s:message code="application.officenumber.label" />
							</form:label>
							<form:input path="iopenApplication.officeNumber"
								cssClass="form-control text-uppercase"
								cssErrorClass="form-control has-errors" id="officeNumber"
								placeholder="officeNumber" readonly="${customer}" />
							<form:errors path="iopenApplication.officeNumber"
								cssClass="has-errors" element="span" />
						</div>
					</div>
				</div>

				<div class="row-fluid">
					<div class="span12">
						<hr />
					</div>
				</div>

				<div class="row-fluid">
					<div class="span4">
						<div class="form-group">
							<label class="control-label" for="date">Customer's Email</label>
						</div>
					</div>
					<div class="span8">
						<div class="form-group">
							<form:label path="iopenApplication.emailAddress"
								cssErrorClass="has-errors">
								<s:message code="application.emailaddress.label" />
							</form:label>
							<form:input path="iopenApplication.emailAddress"
								cssClass="form-control" cssErrorClass="form-control has-errors"
								id="emailAddress" required="required" placeholder="emailAddress"
								readonly="${customer}" />
							<form:errors path="iopenApplication.emailAddress"
								cssClass="has-errors" element="span" />
						</div>
					</div>
				</div>

				<div class="row-fluid">
					<div class="span12">
						<hr />
					</div>
				</div>

				<div class="row-fluid">
					<div class="span4">
						<div class="form-group">
							<label class="control-label" for="date">Customer Contact
								Person</label>
						</div>
					</div>
					<div class="span2">
						<div class="form-group">
							<form:radiobutton path="iopenApplication.customerContactPerson"
								cssClass="form-control" disabled="${activestatus}"
								cssErrorClass="form-control has-errors" id="self"
								value='${defaultValues.get("application_customercontactperson_self_value")}' />
							<s:message code="application.customercontactperson.self.label" />
							<form:errors path="iopenApplication.customerContactPerson"
								cssClass="has-errors" element="span" />
						</div>
					</div>
					<div class="span2">
						<div class="form-group">
							<form:radiobutton path="iopenApplication.customerContactPerson"
								cssClass="form-control" disabled="${activestatus}"
								cssErrorClass="form-control has-errors" id="self"
								value='${defaultValues.get("application_customercontactperson_other_value")}' />
							<s:message code="application.customercontactperson.other.label" />
							<form:errors path="iopenApplication.customerContactPerson"
								cssClass="has-errors" element="span" />
						</div>
					</div>

					<div class="span4">
						<div class="form-group">
							<form:label path="iopenApplication.contactName"
								cssErrorClass="has-errors">
								<s:message code="application.contactname.label" />
							</form:label>
							<form:input path="iopenApplication.contactName"
								cssClass="form-control text-uppercase"
								cssErrorClass="form-control has-errors" id="contactName"
								placeholder="contactName" readonly="${activestatus}" />
							<form:errors path="iopenApplication.contactName"
								cssClass="has-errors" element="span" />
						</div>
					</div>
				</div>
				<div class="row-fluid">
					<div class="span4"></div>
					<div class="span4"></div>
					<div class="span4">
						<div class="form-group">
							<form:label path="iopenApplication.contactNumber"
								cssErrorClass="has-errors">
								<s:message code="application.contactnumber.label" />
							</form:label>
							<form:input path="iopenApplication.contactNumber"
								cssClass="form-control text-uppercase"
								cssErrorClass="form-control has-errors" id="contactNumber"
								placeholder="contactNumber" readonly="${activestatus}" />
							<form:errors path="iopenApplication.contactNumber"
								cssClass="has-errors" element="span" />
						</div>
					</div>
				</div>

				<div class="row-fluid">
					<div class="span12">
						<hr />
					</div>
				</div>

			</fieldset>
			<fieldset>
			<!-- SMA 20160219 UMESC-444 start -->
					<legend>
					<s:message code="application.premisesection.text" />
					:
				</legend>


				<div class="row-fluid">
					<div class="span4">
						<div class="formGroup">
							<form:label path="iopenApplication.districtDesc" cssErrorClass="has-errors">
								<s:message code="application.districtDesc.label" />
								<span class="has-errors star">*</span>
							</form:label>
							<form:input path="iopenApplication.districtDesc"
								cssClass="form-control text-uppercase"
								cssErrorClass="form-control has-errors" id="districtDesc"
								required="required" placeholder="District" />
							<form:errors path="iopenApplication.districtDesc" cssClass="has-errors"
								element="span" />
						</div>
					</div>
					<div class="span4">
						<div class="formGroup">
							<form:label path="iopenApplication.townDesc" cssErrorClass="has-errors">
								<s:message code="application.townDesc.label" />
								<span class="has-errors star">*</span>
							</form:label>
							<form:input path="iopenApplication.townDesc"
								cssClass="form-control text-uppercase"
								cssErrorClass="form-control has-errors" id="townDesc"
								required="required" placeholder="Town" />
							<form:errors path="iopenApplication.townDesc" cssClass="has-errors" element="span" />
						</div>
					</div>
					<div class="span4">
						<div class="formGroup">
							<form:label path="iopenApplication.countyDesc" cssErrorClass="has-errors">
								<s:message code="application.countyDesc.label" />
								<span class="has-errors star">*</span>
							</form:label>
							<form:input path="iopenApplication.countyDesc"
								cssClass="form-control text-uppercase"
								cssErrorClass="form-control has-errors" id="countyDesc"
								required="required" placeholder="County" />
							<form:errors path="iopenApplication.countyDesc" cssClass="has-errors"
								element="span" />
						</div>
					</div>
				</div>
				<div class="row-fluid">
					<div class="span4">
						<div class="formGroup">
							<form:label path="iopenApplication.subCountyDesc" cssErrorClass="has-errors">
								<s:message code="application.subCountyDesc.label" />
								<span class="has-errors star">*</span>
							</form:label>
							<form:input path="iopenApplication.subCountyDesc"
								cssClass="form-control text-uppercase"
								cssErrorClass="form-control has-errors" id="subCountyDesc"
								required="required" placeholder="Sub-County" />
							<form:errors path="iopenApplication.subCountyDesc" cssClass="has-errors"
								element="span" />
						</div>
					</div>
					<div class="span4">
						<div class="formGroup">
							<form:label path="iopenApplication.villageDesc" cssErrorClass="has-errors">
								<s:message code="application.village.label" />
								<span class="has-errors star">*</span>
							</form:label>
							<form:input path="iopenApplication.villageDesc"
								cssClass="form-control text-uppercase"
								cssErrorClass="form-control has-errors" id="villageDesc"
								required="required" placeholder="Village" />
							<form:errors path="iopenApplication.villageDesc"
								cssClass="has-errors" element="span" />
						</div>

					</div>
					<div class="span4">
						<div class="formGroup">
							<form:label path="iopenApplication.streetDesc" cssErrorClass="has-errors">
								<s:message code="application.streetDesc.label" />
							</form:label>
							<form:input path="iopenApplication.streetDesc"
								cssClass="form-control text-uppercase"
								cssErrorClass="form-control has-errors" id="streetDesc"
								placeholder="Street" />
							<form:errors path="iopenApplication.streetDesc"
								cssClass="has-errors" element="span" />
						</div>
					</div>
				</div>
				<div class="row-fluid">
					<div class="span4">
						<div class="formGroup">
							<form:label path="iopenApplication.housePlot" cssErrorClass="has-errors">
								<s:message code="application.house.label" />

							</form:label>
							<form:input path="iopenApplication.housePlot"
								cssClass="form-control text-uppercase"
								cssErrorClass="form-control has-errors" id="housePlot"
								placeholder="House/plot" />
							<form:errors path="iopenApplication.housePlot"
								cssClass="has-errors" element="span" />
						</div>

					</div>
					<div class="span8 ">
						<div class="formGroup">
							<form:label path="iopenApplication.directionsDesc" cssErrorClass="has-errors">
								<s:message code="application.landmark.label" />
								<span class="has-errors star">*</span>
							</form:label>
							<form:textarea path="iopenApplication.directionsDesc" rows="5" cols="70"
								cssClass="form-control text-uppercase"
								cssErrorClass="form-control has-errors" id="directionsDesc"
								required="required" placeholder="directions" style="width:90%;" />
							<form:errors path="iopenApplication.directionsDesc"
								cssClass="has-errors" element="span" />
						
						</div>

					</div>
					<!-- SMA 20160219 UMESC-444 end -->
				</div>
				<div class="row-fluid">
					<div class="span12">
						<hr />
					</div>
				</div>
			</fieldset>
			<fieldset>
				<legend>Checklist</legend>
				<div class="row-fluid">
					<div class="span12">
						<ol style="display: inline-block">
							<li><s:message code="application.validid.label" /></li>
							<li><s:message code="application.validcompanyseal.label" /></li>
							<%-- <li><s:message code="application.validpassport.label" /></li> --%>
							<li><s:message
									code="application.validwiringcertificate.label" /></li>
							<li><s:message code="application.sketchmap.label" /></li>
						</ol>
					</div>
<!--SMA 20160315 -->
					<div id="exceededupload" class="span12 has-errors"
						style="display: none">Please attach a maximum of Five ( 5 )
						Documents</div>


				</div>

				<div class="row-fluid ${hiddenclass}">
					<div class="span12">
						<!--check http://www.dropzonejs.com/#usage for configuration info -->
						<!-- also refer to umeme_bottom_scripts.jsp line 17 for creation of this file-upload div -->
						<div
							class="dz-default dz-message file-dropzone text-center well col-sm-12">
							<span class="glyphicon glyphicon-paperclip"></span> <span>
								To attach files, drag and drop here</span><br> <span>OR</span><br>
							<span>Just Click</span>
						</div>

					</div>
				</div>

				<div class="row-fluid">
					<div class="span12">
						<!-- this is were the previews should be shown. -->
						<div class="dropzone-previews"></div>
					</div>
				</div>

				<div class="row-fluid">
					<div class="span12">
						<hr />
					</div>
				</div>

			</fieldset>
			<fieldset>
				<legend></legend>
				<div class="row-fluid">
					<div class="span12" style="overflow: auto">
						<table class="table table-condensed table-hover">
							<thead>
								<tr>
									<th>Uploaded Documents</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach
									items="${application.iopenApplication.iopenApplicationDocs}"
									var="doc">
									<tr class="active">
										<td>${doc.docDesc}</td>
										<td><a class="fancybox ${doc.contentClass}"
											data-fancybox-type="iframe"
											href="<c:url value="/client/download?codApplication=${doc.id.codApplication}&tipDoc=${doc.id.tipDoc}"/>"
											target="_blank"> view </a></td>
										<td><c:if
												test="${((application.iopenApplication.estStatus == 'IA001' || application.iopenApplication.estStatus == 'IA003') && application.iopenApplication.complete == 1)||(application.iopenApplication.estStatus == 'IA003' && application.iopenApplication.inspectionRejected == true)}">
												<a
													href="<c:url value="/client/application/doc?codApplication=${doc.id.codApplication}&tipDoc=${doc.id.tipDoc}"/>">
													remove</a>
											</c:if></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</fieldset>
			<%-- <fieldset hidden="true">
						<legend>iOpen credentials:</legend>
						<div class="row-fluid">
							<div class="span4">
								<div class="formGroup">
									<form:label path="iopenApplication.emailAddress" cssErrorClass="has-errors">
										<s:message code="application.email.label" />
									</form:label>
									<form:input path="iopenApplication.emailAddress" cssClass="form-control"
										cssErrorClass="form-control has-errors" id="email"
										type="email" required="required"
										placeholder="email address ..." />
									<form:errors path="iopenApplication.emailAddress" cssClass="has-errors" element="span" />
								</div>
							</div>
							<div class="span4">
								<div class="formGroup">
									<form:label path="password" cssErrorClass="has-errors">
										<s:message code="application.password.label" />
									</form:label>
									<form:input path="password" cssClass="form-control"
										cssErrorClass="form-control has-errors" id="password"
										type="password" required="required" placeholder="password ..." />
									<form:errors path="password" cssClass="has-errors"
										element="span" />
								</div>
							</div>
							<div class="span4">
								<div class="formGroup">
									<form:label path="confirmPassword" cssErrorClass="has-errors">
										<s:message code="application.confirmpassword.label" />
									</form:label>
									<form:input path="confirmPassword" cssClass="form-control"
										cssErrorClass="form-control has-errors" id="password"
										type="password" required="required" placeholder="password ..." />
									<form:errors path="confirmPassword" cssClass="has-errors"
										element="span" />
								</div>
							</div>
						</div>
						<div class="row-fluid">
							<div class="span12">
								<hr />
							</div>
						</div>
					</fieldset> --%>
			<%-- <fieldset>
						<legend>Terms and Conditions:</legend>
						<div class="row-fluid">
							<div class="span12">
								<div class="formGroup">
									<form:checkbox path="*" cssClass="form-control"
										cssErrorClass="form-control has-errors" id="terms" required="required"
										value="Y" />
									<s:message code="application.terms.label" />
									<form:errors path="*" cssClass="has-errors"
										element="span" />
								</div>
							</div>
						</div>
						<hr />
						<div class="row-fluid">
							<div class="span12" style="height: 260px; overflow-y: scroll;">
								GENERAL CONDITIONS OF SUPPLY <br /> 1. Determination of
								Disputes Disputes arising over the provision, installation or
								associated charges and terms for electricity supply shall be
								determined in accordance with the Electricity Act 1999, and the
								Electricity Regulations as issued by the Electricity Regulatory
								Authority and as may be amended from time to time. <br /> 2.
								Metering Equipment The register of a meter shall be conclusive
								evidence, in the absence of fraud, of the value of supply. Where
								a dispute arises as to the integrity of the meter, the dispute
								shall be determined in accordance with the Disputes resolution
								mechanism provided in the Electricity (Primary Grid Code)
								regulations 24/2003 and as may be amended from time to time. <br />3.
								Three Phase Supply Phases should be balanced as evenly as
								possible. Where three phase equipment is installed, the customer
								is obliged to install protection which will disconnect all
								phases in th e event of low voltage or loss of supply to one or
								more phase. <br />4. Service Lines/Connection charges The
								customer shall contribute towards the cost of providing supply.
								The lines and installations will remain the property of UMEME
								and may be used for supplying other customers. The customer
								shall provide access to lines and installations whenever
								required by UMEME. The customer shall at all times keep the
								internal installations/wiring neat and safe. <br />5. Access To
								The Customer’s Property Authorized Officers of UMEME are
								entitled at all reasonable times to enter the customer’s
								property for purposes connected with supply of electricity. If
								permission to enter is refused, UMEME may seek recourse under
								the relevant laws. <br />6. Interference With Supply To Other
								Customers The customer may not use the supply so as to interfere
								with the efficient supply to any other customer, and UMEME may
								disconnect the supply if it is so used. <br />7. Tampering With
								Equipment The customer shall not interfere or allow interference
								with UMEME equipment and installations on the property. Any such
								interference may attract criminal prosecution and / or fines.
								For the avoidance of doubt in the event that there is tampering
								with the meter it shall be presumed that the customer has
								tampered wi th it. <br />8. Temporary Interruption UMEME may
								temporarily disconnect supply for various purposes including:
								load shedding, planned or unplanned network maintenance,
								connection of customers to the network, emergency work or any
								other purposes whatsoever connected with the proper working of
								the electricity network. <br />9. Alternative Payment Methods
								To top up energy outside UMEME offices, the customer will be
								required to meet the cost of using alternative payment methods
								to the respective service provider. <br />10. Preloaded Units
								The prepayment meters will be installed with energy preloaded on
								the meter, which will be paid for by the customer. <br />11.
								Arrears The customer is required to clear any outstanding
								charges and / or bills prior to conversion/ or connecti on to
								Prepayment or enter into an agreed arrangement to clear any
								outstanding bills. <br />12. Security Deposit For customers
								converting to Prepayment, their existing security deposit will
								off-set against the Final bill and any remaining credit will be
								converted to units and loaded onto the Prepayment meter. <br />13.
								Termination of Contract The customer will advise UMEME if he /
								she intends to permanently leave the supply address or plans to
								demolish the premise which contains the metering equipment. The
								customer should advise UMEME by calling our Contact Centre on
								0800185185 or by calling to any UMEME office. <br /> I hereby
								state that all the information I have given in support of the
								application above is true to the best of my knowledge and I
								undertake to indemnify UMEME for any costs or liability it
								incurs as a result of any falsehood or omission on my part. I
								undertake to be bound by UMEME’s General Conditions of Supply
								and I will pay for all the electricity consumed in accordance
								with the applicable tariff in force at the time of usage.

							</div>
						</div>
					</fieldset> --%>


			<div class="row-fluid">
				<div class="span3">
					<a class="btn btn-lg btn-primary"
						href="<c:url value="/client/applications"/>" role="button">Back
						to Applications list</a>
				</div>
				<div class="span1"></div>
				<div class="span3">
					<form:button class="btn btn-lg btn-primary  ${hiddenbtnclass}"
						disabled="${readonlystatusbtnSubmit}" style="min-width:178px">
						<s:message code="submit.value" />
					</form:button>
				</div>
				<div class="span1"></div>
				<div class="span3">
					<c:if
						test="${application.iopenApplication.estStatus == 'IA001' && application.iopenApplication.expediente.estado == '17001'}">
						<a
							href="<c:url value="/client/application/cancel/"/>${application.iopenApplication.codApplication}"
							class="btn btn-lg btn-primary ${hiddenbtnclass} "
							style="min-width: 178px"> Cancel</a>
					</c:if>
				</div>
				<div class="span1"></div>
			</div>
			<div class="row-fluid">
				<div hidden="true" class="span3">
					<div hidden="true" class="formGroup">
						<form:input path="iopenApplication.codApplication"
							cssClass="form-control text-uppercase" id="codApplication"
							placeholder="application no.." readonly="true" />
					</div>
				</div>
			</div>
		</form:form>

		<div class="bottom-border">&nbsp;</div>
	</div>
</div>


<script type='text/javascript'
	src='<s:url value="/resources/assets/js/dropzone.js"></s:url>'></script>
<script>
	console.log("gol1");
	$(document)
			.ready(
					function() {

						$('#district').change(	   
							function() {
								console.log("district change..");
								$.getJSON('${findDistrictVillagesURL}', {
									codMunic : $(this).val(),
									ajax : 'true'
								}, function(data) {
									console.log("district change: returned data: "+data);
									var html = '<option value="">--- Select ---</option>';
									var len = data.length;
									for ( var i = 0; i < len; i++) {
										html += '<option value="' + data[i].codLocal + '">'
												+ data[i].nomLocal + '</option>';
									}
									html += '</option>';
					 
									$('#village').html(html);
								});
						});
						$('#village').change(
								function() {
									$.getJSON('${findVillageLocalitiesURL}', {
										codLocal : $(this).val(),
										ajax : 'true'
									}, function(data) {
										var html = '<option value="">--- Select ---</option>';
										var len = data.length;
										for ( var i = 0; i < len; i++) {
											html += '<option value="' + data[i].codLocal + '">'
													+ data[i].nomLocal + '</option>';
										}
										html += '</option>';
						 
										$('#locality').html(html);
									});
						});
						$('#locality').change(
								function() {
									$.getJSON('${findLocalityStreetsURL}', {
										codLocal : $(this).val(),
										ajax : 'true'
									}, function(data) {
										var html = '<option value="">--- Select ---</option>';
										var len = data.length;
										for ( var i = 0; i < len; i++) {
											html += '<option value="' + data[i].codCalle + '">'
													+ data[i].nomCalle + '</option>';
										}
										html += '</option>';
						 
										$('#street').html(html);
									});
						});
						$(".application").fancybox({
							width : "80%",
							height : "90%",
							type : 'iframe'
						});
						$(".image").fancybox({
							width : "80%",
							height : "90%"
						});
						$(".default").fancybox({
							width : "80%",
							height : "90%",
							type : 'iframe'
						});
						
						Dropzone.options.newApplication = { // The camelized version of the ID of the form element

							// The configuration we've talked about above
							autoProcessQueue : false,
							uploadMultiple : true,
							addRemoveLinks : true,
							maxFiles : 5,
							parallelUploads : 5,
							acceptedFiles: ".jpeg,.jpg,.png,.gif,.pdf",
							previewsContainer : ".dropzone-previews",

							// The setting up of the dropzone
							init : function() {
								var myDropzone = this;
								myDropzone.removeAllFiles();

								// First change the button to actually tell Dropzone to process the queue.
								this.element
										.querySelector("button[type=submit]")
										.addEventListener(
												"click",
												function(e) {
													// Make sure that the form isn't actually being sent.
													e.preventDefault();
													e.stopPropagation();

													if (myDropzone
															.getQueuedFiles().length > 0) {
														$("#exceededupload")
																.hide();
														myDropzone
																.processQueue();
													} else {
														$("#new-application")
																.submit();
													}

													/* myDropzone.processQueue(); */
												});

								// Listen to the sendingmultiple event. In this case, it's the sendingmultiple event instead
								// of the sending event because uploadMultiple is set to true.
								this.on("sendingmultiple", function() {
									// Gets triggered when the form is actually being sent.
									// Hide the success button or the complete form.
									debugger;
								});
								this.on("successmultiple", function(files,
										response) {
									// Gets triggered when the files have successfully been sent.
									// Redirect user or notify of success.
									myDropzone.removeAllFiles();
									var newDoc = document.open("text/html",
											"replace");
									newDoc.write(response);
									newDoc.close();
								});
								this.on("errormultiple", function(files,
										response) {
									// Gets triggered when there was an error sending the files.
									// Maybe show form again, and notify user of error
									/*  myDropzone.removeAllFiles();
									 var newDoc = document.open("text/html", "replace");
									 newDoc.write(response);
									 newDoc.close(); */

									$("#exceededupload").show();
								});
							}

						}

					});
</script>
