<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ page session="false"%>
<style>
.printsize {
	font-size: 10px;
}
</style>
<c:set var="activestatus" value="${true}" />
<c:if
	test="${application.iopenApplication.estStatus == 'IA001' && employeeUnicom == application.iopenApplication.expediente.codUnicomCompet}">
	<c:set var="activestatus" value="${false}" />
</c:if>
<div id="main" class="wrap post-template">
	<div class="container">
		<div class="row-fluid">
			<div class="span12 post-page">
				<a class="btn btn-lg btn-primary hidden-print"
					href="<c:url value="/employee/applications"/>" role="button">Back
					to Applications list</a>
				<h3 class="module-title-short hidden-print">
					<span class="selected">Application details</span>
				</h3>
				<form:form method="POST" commandName="application"
					id="applicationForm" cssClass="form-horizontal dropzone">


					<div class="row-fluid hidden-print">
						<div class="span12">
							<p class="has-errors">
								<c:out value="${errorInfo}"></c:out>
							</p>
						</div>
						<div class="span12">
							<div class="formGroup">
								<form:label path="iopenApplication.applicationType"
									cssClass="has-errors">
									<s:message code="" text="${iopenApplication.applicationType}" />
								</form:label>
							</div>
						</div>
						<div class="span12">
							<a id="printer_link" href="#" class="icon-print"
								style="float: right; color: black; margin-right: 10px;"> <s:message
									code="common.print" /></a>

						</div>
					</div>
					<div class="row-fluid visible-print">
						<div class="span3">
							<a href="http://umeme.co.ug/"><img alt="UMEME"
								src='<s:url value="/resources/assets/img/logo.png"></s:url>'
								id="logo-img1" style="float: left; width: 100%; height: 120px;" /></a>
						</div>
						<div class="span3"></div>
						<div class="span3"></div>
						<div class="span3"></div>
					</div>
					<fieldset>
						<legend>Application Information:</legend>
						<div class="row-fluid">
							<div class="span4">
								<div class="formgroup">
									<form:label path="applicationDate">
										<s:message code="applicationlist.date.label" />
									</form:label>
									<form:input path="applicationDate"
										cssClass="form-control text-uppercase" id="applicationDate"
										placeholder="application date.." readonly="true" />
								</div>
							</div>
							<div class="span4">
								<div class="formgroup">
									<form:label path="applicationNumber">
										<s:message code="applicationlist.number.label" />
									</form:label>
									<form:input path="applicationNumber"
										cssClass="form-control text-uppercase" id="applicationNumber"
										placeholder="application no.." readonly="true" />
								</div>
							</div>
							<div class="span4">
								<div class="formgroup">
									<form:label path="applicationType">
										<s:message code="applicationlist.type.label" />
									</form:label>
									<form:input path="applicationType"
										cssClass="form-control text-uppercase" id="applicationType"
										placeholder="application type.." readonly="true" />
								</div>
							</div>
						</div>

						<div class="row-fluid">
							<div class="span4">
								<div class="formgroup">
									<form:label path="applicationCurrentStage">
										<s:message code="applicationlist.currentstage.label" />
									</form:label>
									<form:input path="applicationCurrentStage"
										cssClass="form-control text-uppercase"
										id="applicationCurrentStage" placeholder="application stage.."
										readonly="true" />
								</div>
							</div>

							<div class="span4">
								<fmt:formatNumber type="number" maxFractionDigits="2"
									minFractionDigits="2"
									value="${application.iopenApplication.inspectionFee}"
									var="fmtInspectionFee" />
								<div class="formgroup">
									<form:label path="iopenApplication.inspectionFee">
										<s:message code="applicationlist.inspectionfee.label" />
									</form:label>
									<form:input path="*" cssClass="form-control text-uppercase"
										id="applicationinspectionFee" placeholder="inspection fee.."
										readonly="true" value="${fmtInspectionFee}" />
								</div>
							</div>
							<div class="span4"></div>
						</div>

					</fieldset>
					<fieldset>
						<legend>
							<s:message code="application.applicantssection.text" />
							:
						</legend>
						<div class="row-fluid">
							<div class="span4">
								<div class="formGroup">
									<form:radiobutton path="iopenApplication.applicationType"
										cssClass="form-control" disabled="true"
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
										cssClass="form-control" disabled="true"
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
										cssClass="form-control" disabled="true"
										cssErrorClass="form-control has-errors" id="tou"
										value='${defaultValues.get("application_tou_value")}' />
									<s:message code="application.tou.label" />
									<form:errors path="iopenApplication.applicationType"
										cssClass="has-errors" element="span" />
								</div>
							</div>
						</div>
						<hr class="hidden-print" />
						<div class="row-fluid">
							<div class="span4">
								<div class="formGroup">
									<form:radiobutton path="iopenApplication.applicationType"
										cssClass="form-control" disabled="true"
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
										cssClass="form-control" disabled="true"
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
										cssClass="form-control" disabled="true"
										cssErrorClass="form-control has-errors" id="streetlight"
										value='${ defaultValues.get("application_streetlight_value")}' />
									<s:message code="application.streetlight.label" />
									<form:errors path="iopenApplication.applicationType"
										cssClass="has-errors" element="span" />
								</div>
							</div>
						</div>
						<div class="row-fluid hidden-print">
							<div class="span12">
								<hr />
							</div>
						</div>
					</fieldset>
					<fieldset>
						<legend>
							<s:message code="application.applicantsdatasection.text" />
							:
						</legend>
						<div class="row-fluid">
							<div class="span3">
								<div class="form-group">
									<label class="control-label" for="date">Applicant Name</label>
								</div>
							</div>
							<div class="span3">
								<div class="form-group">
									<form:label path="iopenApplication.surname"
										cssErrorClass="has-errors">
										<s:message code="application.surname.label" />
									</form:label>
									<form:input path="iopenApplication.surname"
										cssClass="form-control text-uppercase"
										cssErrorClass="form-control has-errors" id="surname"
										required="required" placeholder="surname" readonly="true" />
									<form:errors path="iopenApplication.surname"
										cssClass="has-errors" element="span" />
								</div>
							</div>
							<div class="span3">
								<div class="form-group">
									<form:label path="iopenApplication.firstName"
										cssErrorClass="has-errors">
										<s:message code="application.firstname.label" />
									</form:label>
									<form:input path="iopenApplication.firstName"
										cssClass="form-control text-uppercase"
										cssErrorClass="form-control has-errors" id="firstname"
										required="required" placeholder="firstName" readonly="true" />
									<form:errors path="iopenApplication.firstName"
										cssClass="has-errors" element="span" />
								</div>
							</div>
							<div class="span3">
								<div class="form-group">
									<form:label path="iopenApplication.middleName"
										cssErrorClass="has-errors">
										<s:message code="application.middlename.label" />
									</form:label>
									<form:input path="iopenApplication.middleName"
										cssClass="form-control text-uppercase"
										cssErrorClass="form-control has-errors" id="middlename"
										placeholder="iopenApplication.middleName" readonly="true" />
									<form:errors path="iopenApplication.middleName"
										cssClass="has-errors" element="span" />
								</div>
							</div>
						</div>
						<div class="row-fluid hidden-print">
							<div class="span12">
								<hr />
							</div>
						</div>

						<div class="row-fluid">
							<div class="span3">
								<div class="form-group">
									<label class="control-label" for="date">Identification
										Document</label>
								</div>
							</div>
							<div class="span2">
								<div class="form-group">
									<form:radiobutton path="iopenApplication.idType"
										cssClass="form-control" disabled="true"
										cssErrorClass="form-control has-errors" id="self"
										value='${defaultValues.get("application_passport_value")}' />
									<s:message code="application.passportidentity.label" />
									<form:errors path="iopenApplication.idType"
										cssClass="has-errors" element="span" />
								</div>
							</div>
							<div class="span1">
								<div class="form-group">
									<form:radiobutton path="iopenApplication.idType"
										cssClass="form-control" disabled="true"
										cssErrorClass="form-control has-errors" id="self"
										value='${defaultValues.get("application_idnumber_value")}' />
									<s:message code="application.ididentity.label" />
									<form:errors path="iopenApplication.idType"
										cssClass="has-errors" element="span" />
								</div>
							</div>

							<div class="span3">
								<div class="form-group">
									<form:label path="iopenApplication.idNumber"
										cssErrorClass="has-errors">
										<s:message code="application.idnumber.label" />
									</form:label>
									<form:input path="iopenApplication.idNumber"
										cssClass="form-control text-uppercase"
										cssErrorClass="form-control has-errors" id="idNumber"
										required="required" placeholder="idNumber" readonly="true" />
									<form:errors path="iopenApplication.idNumber"
										cssClass="has-errors" element="span" />
								</div>
							</div>
							<div class="span2">
								<div class="form-group">
									<form:label path="iopenApplication.tinNumber"
										cssErrorClass="has-errors">
										<s:message code="application.tinnumber.label" />
									</form:label>
									<form:input path="iopenApplication.tinNumber"
										cssClass="form-control text-uppercase"
										cssErrorClass="form-control has-errors" id="tinNumber"
										placeholder="tinNumber" readonly="true" />
									<form:errors path="iopenApplication.tinNumber"
										cssClass="has-errors" element="span" />
								</div>
							</div>
						</div>

						<div class="row-fluid hidden-print">
							<div class="span12">
								<hr />
							</div>
						</div>

						<div class="row-fluid">
							<div class="span3">
								<div class="form-group">
									<label class="control-label" for="date">Customer
										Contact</label>
								</div>
							</div>
							<div class="span3">
								<div class="form-group">
									<form:label path="iopenApplication.mobileNumber"
										cssErrorClass="has-errors">
										<s:message code="application.mobilenumber.label" />
									</form:label>
									<form:input path="iopenApplication.mobileNumber"
										cssClass="form-control text-uppercase"
										cssErrorClass="form-control has-errors" id="mobileNumber"
										required="required" placeholder="mobileNumber" readonly="true" />
									<form:errors path="iopenApplication.mobileNumber"
										cssClass="has-errors" element="span" />
								</div>
							</div>
							<div class="span6">
								<div class="form-group">
									<form:label path="iopenApplication.officeNumber"
										cssErrorClass="has-errors">
										<s:message code="application.officenumber.label" />
									</form:label>
									<form:input path="iopenApplication.officeNumber"
										cssClass="form-control text-uppercase"
										cssErrorClass="form-control has-errors" id="officeNumber"
										placeholder="officeNumber" readonly="true" />
									<form:errors path="iopenApplication.officeNumber"
										cssClass="has-errors" element="span" />
								</div>
							</div>
						</div>

						<div class="row-fluid hidden-print">
							<div class="span12">
								<hr />
							</div>
						</div>

						<div class="row-fluid">
							<div class="span3">
								<div class="form-group">
									<label class="control-label" for="date">Customer's
										Email</label>
								</div>
							</div>
							<div class="span6">
								<div class="form-group">
									<form:label path="iopenApplication.emailAddress"
										cssErrorClass="has-errors">
										<s:message code="application.emailaddress.label" />
									</form:label>
									<form:input path="iopenApplication.emailAddress"
										style="width:100%" cssClass="form-control"
										cssErrorClass="form-control has-errors" id="emailAddress"
										required="required" placeholder="emailAddress" readonly="true" />
									<form:errors path="iopenApplication.emailAddress"
										cssClass="has-errors" element="span" />
								</div>
							</div>
						</div>

						<div class="row-fluid hidden-print">
							<div class="span12">
								<hr />
							</div>
						</div>

						<div class="row-fluid">
							<div class="span3">
								<div class="form-group">
									<label class="control-label" for="date">Customer
										Contact Person</label>
								</div>
							</div>
							<div class="span1">
								<div class="form-group">
									<form:radiobutton path="iopenApplication.customerContactPerson"
										cssClass="form-control" disabled="true"
										cssErrorClass="form-control has-errors" id="self"
										value='${defaultValues.get("application_customercontactperson_self_value")}' />
									<s:message code="application.customercontactperson.self.label" />
									<form:errors path="iopenApplication.customerContactPerson"
										cssClass="has-errors" element="span" />
								</div>
							</div>
							<div class="span1">
								<div class="form-group">
									<form:radiobutton path="iopenApplication.customerContactPerson"
										cssClass="form-control" disabled="true"
										cssErrorClass="form-control has-errors" id="self"
										value='${defaultValues.get("application_customercontactperson_other_value")}' />
									<s:message code="application.customercontactperson.other.label" />
									<form:errors path="iopenApplication.customerContactPerson"
										cssClass="has-errors" element="span" />
								</div>
							</div>

							<div class="span3">
								<div class="form-group">
									<form:label path="iopenApplication.contactName"
										cssErrorClass="has-errors">
										<s:message code="application.contactname.label" />
									</form:label>
									<form:input path="iopenApplication.contactName"
										cssClass="form-control text-uppercase"
										cssErrorClass="form-control has-errors" id="contactName"
										placeholder="contactName" readonly="true" />
									<form:errors path="iopenApplication.contactName"
										cssClass="has-errors" element="span" />
								</div>
							</div>
							<div class="span4">
								<div class="form-group">
									<form:label path="iopenApplication.contactNumber"
										cssErrorClass="has-errors">
										<s:message code="application.contactnumber.label" />
									</form:label>
									<form:input path="iopenApplication.contactNumber"
										cssClass="form-control text-uppercase" style="width:100%"
										cssErrorClass="form-control has-errors" id="contactNumber"
										placeholder="contactNumber" readonly="true" />
									<form:errors path="iopenApplication.contactNumber"
										cssClass="has-errors" element="span" />
								</div>
							</div>
						</div>

						<div class="row-fluid hidden-print">
							<div class="span12">
								<hr />
							</div>
						</div>

					</fieldset>
					<fieldset>
						<legend>
							<s:message code="application.premisesection.text" />
							:
						</legend>

						<div class="row-fluid">
							<div class="span4">
								<div class="formGroup">
									<form:label path="iopenApplication.districtDesc"
										cssErrorClass="has-errors">
										<s:message code="application.districtDesc.label" />
										<span class="has-errors star">*</span>
									</form:label>
									<form:input path="iopenApplication.districtDesc"
										cssClass="form-control text-uppercase"
										cssErrorClass="form-control has-errors" id="districtDesc"
										disabled="true" required="required" placeholder="districtDesc" />
									<form:errors path="iopenApplication.districtDesc"
										cssClass="has-errors" element="span" />
								</div>
							</div>
							<div class="span4">
								<div class="formGroup">
									<form:label path="iopenApplication.townDesc"
										cssErrorClass="has-errors">
										<s:message code="application.townDesc.label" />
										<span class="has-errors star">*</span>
									</form:label>
									<form:input path="iopenApplication.townDesc"
										cssClass="form-control text-uppercase"
										cssErrorClass="form-control has-errors" id="townDesc"
										disabled="true" required="required" placeholder="townDesc" />
									<form:errors path="iopenApplication.townDesc"
										cssClass="has-errors" element="span" />
								</div>
							</div>
							<div class="span4">
								<div class="formGroup">
									<form:label path="iopenApplication.countyDesc"
										cssErrorClass="has-errors">
										<s:message code="application.countyDesc.label" />
										<span class="has-errors star">*</span>
									</form:label>
									<form:input path="iopenApplication.countyDesc"
										cssClass="form-control text-uppercase"
										cssErrorClass="form-control has-errors" id="countyDesc"
										disabled="true" required="required" placeholder="countyDesc" />
									<form:errors path="iopenApplication.countyDesc"
										cssClass="has-errors" element="span" />
								</div>
							</div>
						</div>
						<div class="row-fluid">
							<div class="span4">
								<div class="formGroup">
									<form:label path="iopenApplication.subCountyDesc"
										cssErrorClass="has-errors">
										<s:message code="application.subCountyDesc.label" />
										<span class="has-errors star">*</span>
									</form:label>
									<form:input path="iopenApplication.subCountyDesc"
										cssClass="form-control text-uppercase"
										cssErrorClass="form-control has-errors" id="subCountyDesc"
										disabled="true" required="required" placeholder="SubCounty" />
									<form:errors path="iopenApplication.subCountyDesc"
										cssClass="has-errors" element="span" />
								</div>
							</div>
							<div class="span4">
								<div class="formGroup">
									<form:label path="iopenApplication.villageDesc"
										cssErrorClass="has-errors">
										<s:message code="application.village.label" />
										<span class="has-errors star">*</span>
									</form:label>
									<form:input path="iopenApplication.villageDesc"
										cssClass="form-control text-uppercase"
										cssErrorClass="form-control has-errors" id="villageDesc"
										disabled="true" required="required" placeholder="Village" />
									<form:errors path="iopenApplication.villageDesc"
										cssClass="has-errors" element="span" />
								</div>

							</div>
							<div class="span4">
								<div class="formGroup">
									<form:label path="iopenApplication.streetDesc"
										cssErrorClass="has-errors">
										<s:message code="application.streetDesc.label" />
										<span class="has-errors star">*</span>
									</form:label>
									<form:input path="iopenApplication.streetDesc"
										cssClass="form-control text-uppercase"
										cssErrorClass="form-control has-errors" id="streetDesc"
										disabled="true" placeholder="Street" />
									<form:errors path="iopenApplication.streetDesc"
										cssClass="has-errors" element="span" />
								</div>
							</div>
						</div>
						<div class="row-fluid">
							<div class="span4">
								<div class="formGroup">
									<form:label path="iopenApplication.housePlot"
										cssErrorClass="has-errors">
										<s:message code="application.house.label" />
										<span class="has-errors star">*</span>
									</form:label>
									<form:input path="iopenApplication.housePlot"
										cssClass="form-control text-uppercase"
										cssErrorClass="form-control has-errors" id="housePlot"
										disabled="true" required="required" placeholder="House/plot" />
									<form:errors path="iopenApplication.housePlot"
										cssClass="has-errors" element="span" />
								</div>

							</div>
							<div class="span8 ">
								<div class="formGroup">
									<form:label path="iopenApplication.directionsDesc"
										cssErrorClass="has-errors">
										<s:message code="application.landmark.label" />
										<span class="has-errors star">*</span>
									</form:label>
									<form:textarea path="iopenApplication.directionsDesc" rows="5"
										cols="70" cssClass="form-control text-uppercase"
										cssErrorClass="form-control has-errors" id="directionsDesc"
										disabled="true" required="required" placeholder="directions"
										style="width:90%;" />
									<form:errors path="iopenApplication.directionsDesc"
										cssClass="has-errors" element="span" />
								</div>

							</div>
						</div>
						<div class="row-fluid">
							<div class="span3">
								<div class="formGroup">
									<form:label path="iopenApplication.district"
										cssErrorClass="has-errors">
										<s:message code="application.district.label" />
										<span class="has-errors star">*</span>
									</form:label>
									<form:select path="iopenApplication.district"
										cssClass="form-control text-uppercase"
										cssErrorClass="form-control has-errors" id="district"
										required="required" placeholder="district" disabled="true">
										<%-- <form:option value="NONE" label="--- Select ---" /> --%>
										<c:forEach items="${districts}" var="district">
											<form:option value="${district.codMunic}"
												label="${district.nomMunic}" />
										</c:forEach>
									</form:select>

									<form:errors path="iopenApplication.district"
										cssClass="has-errors" element="span" />
								</div>
							</div>
							<div class="span3">
								<div class="formGroup">
									<form:label path="iopenApplication.village"
										cssErrorClass="has-errors">
										<s:message code="application.village.label" />
										<span class="has-errors star">*</span>
									</form:label>
									<form:select path="iopenApplication.village"
										cssClass="form-control text-uppercase"
										cssErrorClass="form-control has-errors" id="village"
										required="required" placeholder="village" disabled="true">
										<form:option value="" label="--- Select ---" />
										<c:forEach items="${villages}" var="village">
											<form:option value="${village.codLocal}"
												label="${village.nomLocal}" />
										</c:forEach>
									</form:select>
									<form:errors path="iopenApplication.village"
										cssClass="has-errors" element="span" />
								</div>

							</div>
							<div class="span3">
								<div class="formGroup">
									<form:label path="iopenApplication.locality"
										cssErrorClass="has-errors">
										<s:message code="application.locality.label" />
										<span class="has-errors star">*</span>
									</form:label>
									<form:select path="iopenApplication.locality"
										cssClass="form-control text-uppercase"
										cssErrorClass="form-control has-errors" id="locality"
										required="required" placeholder="locality" disabled="true">
										<form:option value="" label="--- Select ---" />
										<c:forEach items="${localities}" var="locality">
											<form:option value="${locality.codLocal}"
												label="${locality.nomLocal}" />
										</c:forEach>
									</form:select>

									<form:errors path="iopenApplication.locality"
										cssClass="has-errors" element="span" />
								</div>
							</div>
						</div>
						<div class="row-fluid">
							<div class="span3">
								<div class="formGroup">
									<form:label path="iopenApplication.street"
										cssErrorClass="has-errors">
										<s:message code="application.street.label" />
										<span class="has-errors star">*</span>
									</form:label>
									<form:select path="iopenApplication.street"
										cssClass="form-control text-uppercase"
										cssErrorClass="form-control has-errors" id="village"
										required="required" placeholder="village" disabled="true">
										<form:option value="" label="--- Select ---" />
										<c:forEach items="${streets}" var="street">
											<form:option value="${street.codCalle}"
												label="${street.nomCalle}" />
										</c:forEach>
									</form:select>
									<form:errors path="iopenApplication.street"
										cssClass="has-errors" element="span" />
								</div>

							</div>
							<div class="span6"></div>
						</div>
						<div class="row-fluid hidden-print">
							<div class="span12">
								<hr />
							</div>
						</div>
					</fieldset>
					<fieldset>
						<legend>Checklist:</legend>
						<div class="row-fluid" style="margin-left: 10px;">
							<div class="span12">
								<ol style="display: inline-block">
									<li><s:message code="application.validid.label" /></li>
									<li><s:message code="application.validcompanyseal.label" /></li>
									<%-- <li><s:message code="application.validpassport.label" /></li> --%>
									<li><s:message
											code="application.validwiringcertificate.label" /></li>
									<li><s:message code="application.sketchmap.label" /></li>
									<li><s:message code="application.toc.label" /></li>
								</ol>
							</div>

						</div>
						<!-- <div class="row-fluid">
							<div class="span12">
							check http://www.dropzonejs.com/#usage for configuration info
							also refer to umeme_bottom_scripts.jsp line 17 for creation of this file-upload div
								<div id="upload-target" class="dropzone"></div>
							</div>
						</div> -->
						<div class="row-fluid" style="margin-left: 5px;">
							<div class="span12" style="overflow: auto">
								<table class="table table-condensed table-hover">
									<thead>
										<tr>
											<!-- <th>ID</th> -->
											<th>Uploaded Documents</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach
											items="${application.iopenApplication.iopenApplicationDocs}"
											var="doc">
											<tr class="active">
												<%-- <td>${doc.fActual}</td> --%>
												<td>${doc.docDesc}</td>

												<td class="hidden-print"><a
													class="fancybox ${doc.contentClass}"
													data-fancybox-type="iframe"
													href="<c:url value="/employee/download?codApplication=${doc.id.codApplication}&tipDoc=${doc.id.tipDoc}"/>"
													target="_blank"> view</a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
						<div class="row-fluid hidden-print">
							<div class="span12">
								<hr />
							</div>
						</div>

					</fieldset>
					<%-- <fieldset>
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
									<form:checkbox path="agreeTermsConditions" cssClass="form-control"
										cssErrorClass="form-control has-errors" id="terms" required="required"
										value="terms" />
									<s:message code="application.terms.label" />
									<form:errors path="agreeTermsConditions" cssClass="has-errors"
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
					<fieldset>
						<legend>Application Invoices:</legend>

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
												<%-- <td>${invoice.invoiceNumber}</td> --%>
												<td>${invoice.invoiceType}</td>
												<td>${invoice.invoiceDate}</td>
												<td><fmt:formatNumber type="number"
														maxFractionDigits="2" minFractionDigits="2"
														value="${invoice.invoiceAmount}" /></td>
												<%-- <td>${invoice.paymentDate}</td> --%>
												<td>${invoice.invoiceStatus}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</fieldset>
					<fieldset>
						<legend>Approval Status:</legend>
						<div class="row-fluid">
							<div class="span4">
								<div class="formgroup">
									<%-- <form:label path="applicationStatus" >
										<s:message code="applicationlist.status.label" />
									</form:label>
									<form:input path="applicationStatus" cssClass="form-control text-uppercase"  id="applicationStatus"
										placeholder="application status.."/> --%>
									<form:label path="iopenApplication.estStatus"
										cssErrorClass="has-errors">
										<s:message code="application.status.label" />
										<span class="has-errors star">*</span>
									</form:label>
									<form:select path="iopenApplication.estStatus"
										cssClass="form-control text-uppercase"
										cssErrorClass="form-control has-errors"
										disabled="${activestatus}" id="applicationStatus"
										placeholder="status">
										<form:option value="NONE" label="--SELECT--" />
										<c:forEach items="${statuses}" var="status">
											<form:option value="${status.statusCode}"
												label="${status.statusDescription}" />
										</c:forEach>
									</form:select>
								</div>
							</div>

							<div class="span4">
								<div class="formgroup">
									<form:label path="iopenApplication.coRejectReason"
										cssErrorClass="has-errors">
										<s:message code="application.rejectReason.label" />
										<span class="has-errors star">*</span>
									</form:label>
									<form:select path="iopenApplication.coRejectReason"
										cssClass="form-control text-uppercase"
										cssErrorClass="form-control has-errors"
										disabled="${activestatus}" id="applicationcoRejectReason"
										placeholder="status">
										<form:option value="NONE" label="--SELECT--" />
										<c:forEach items="${rejectReasons}" var="rejectReason">
											<form:option value="${rejectReason.cod}"
												label="${rejectReason.descCod}" />
										</c:forEach>
									</form:select>
								</div>
							</div>

							<%-- <div class="span4">
								<div class="formgroup">
								<form:label path="applicationCurrentStage" >
										<s:message code="applicationlist.currentstage.label" />
									</form:label>
									<form:input path="applicationCurrentStage" cssClass="form-control text-uppercase"  id="applicationCurrentStage"
										placeholder="application stage.." readonly="true" />
								</div>
							</div> --%>
							<div class="span4">
								<div class="formgroup">
									<form:label path="iopenApplication.comments">
										<s:message code="applicationlist.comment.label" />
										<span class="has-errors star">*</span>
									</form:label>
									<form:textarea path="iopenApplication.comments"
										cssClass="form-control text-uppercase" id="applicationComment"
										placeholder="feedback.." readonly="${activestatus}" />
								</div>
							</div>
						</div>
					</fieldset>
					<div class="row-fluid hidden-print">
						<div class="span12">
							<hr />
						</div>
					</div>
					<div class="row-fluid visible-print">

						<div class="span4">
							<div class="formgroup">
								<form:label path="*">
										Printed By:
									</form:label>
								<security:authorize
									access="hasRole('CLIENT') or hasRole('EMPLOYEE')">
									<security:authentication property="principal.username"
										var="username" />
									<form:label path="*">
										 ${username} </form:label>

								</security:authorize>

							</div>
						</div>
						<div class="span4">
							<div class="formgroup">
								<form:label path="*">
										Printed On:
									</form:label>
								<c:set var="now" value="<%=new java.util.Date()%>" />
								<form:label path="*">
									<fmt:formatDate type="both" dateStyle="medium"
										timeStyle="medium" value="${now}" />
								</form:label>






							</div>
						</div>
						<div class="span4"></div>
					</div>

					<div class="row-fluid hidden-print">
						<div class="span5">
							<a class="btn btn-lg btn-primary"
								href="<c:url value="/employee/applications"/>" role="button">Back
								to Applications list</a>
						</div>
						<div class="span2">
							&nbsp;
							<%-- <form:button class="btn btn-lg btn-primary "
								disabled="${activestatus}" style="min-width:178px">
								<s:message code="submit.value" />
							</form:button> --%>
						</div>
						<div class="span5"></div>

						<div hidden="true" class="span4">
							<div hidden="true" class="formgroup">
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
	</div>
</div>
<script type='text/javascript'>
	$(document).ready(function() {
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

		$('#applicationcoRejectReason').attr("disabled", "disabled");
		$('#applicationcoRejectReason').removeAttr('required');

		$("#applicationStatus").change(function() {
			if ($('#applicationStatus').val() == "IA003") {
				$('#applicationcoRejectReason').attr("required", "required");
				$('#applicationcoRejectReason').removeAttr('disabled');
			} else {
				$('#applicationcoRejectReason').attr("disabled", "disabled");
				$('#applicationcoRejectReason').removeAttr('required');
				$('#applicationcoRejectReason')[0][0].selected = true
			}
		});
		$("#printer_link").click(function(event) { //the print button has the class .print-now
			event.preventDefault(); // prevent normal button action 
			$('input').removeClass('text-uppercase');
			$('.form-control').addClass('printsize');
			$('.table').addClass('printsize');
			$('.form-control').removeClass('form-control'); // remove the form-control class
			$('#applicationForm').removeClass('dropzone'); // remove dropzone
			$('#applicationForm').addClass('printsize');
			window.print(); // print the page
			$('input').addClass('form-control'); // return the class after printing
			$('#applicationForm').addClass('dropzone');//return dropzone
			$('#applicationForm').removeClass('printsize');
			$('.form-control').removeClass('printsize');
			$('.table').removeClass('printsize');
			$('input').addClass('text-uppercase');
		});
	});
</script>