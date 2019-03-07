<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
 
		<div class="row-fluid">
			<div class="span12 post-page">
					<h3 class="module-title-short">
						<span class="selected"><s:message code="contractview.title" /></span>
					</h3>
				<form:form method="POST" commandName="contract" cssClass=" register"
					acceptCharset="ISO-8859-1" style="padding:5px;">
					<form:errors path="*" element="div" cssClass="formGroup has-errors" />
					<p class="has-errors">
						<c:out value="${errorInfo.message}"></c:out>
					</p>
					<fieldset>
						<legend>
							<s:message code="contractview.fieldset.contractdetails" />
						</legend>
						<div class="row-fluid">
							<div class="span4">
								<div class="formGroup">
									<form:label path="contractNumber" cssErrorClass="has-errors">
										<s:message code="contractview.contactdetails.accountnumber" />
									</form:label>
									<form:input path="contractNumber" cssClass="form-control"
										cssErrorClass="form-control has-errors" id="contractNumber"
										type="text" required="required" readonly="true" />
									<form:errors path="contractNumber" cssClass="has-errors"
										element="span" />

								</div>
							</div>
							<div class="span4">
								<div class="formGroup">
									<form:label path="enrollmentDate" cssErrorClass="has-errors">
										<s:message code="contractview.contactdetails.enrollmentdate" />
									</form:label>
									<form:input path="enrollmentDate" cssClass="form-control"
										cssErrorClass="form-control has-errors" id="enrollmentDate"
										type="text" required="required" readonly="true" />
									<form:errors path="enrollmentDate" cssClass="has-errors"
										element="span" />

								</div>
							</div>
							<div class="span4">
								<div class="formGroup">
									<form:label path="tariff" cssErrorClass="has-errors">
										<s:message code="contractview.contactdetails.tariff" />
									</form:label>
									<%-- <form:input path="tariff" cssClass="form-control"
									cssErrorClass="form-control has-errors" id="tariff"
									type="text" required="required" placeholder="tariff..." /> --%>
									<form:select path="tariff" disabled="true"
										cssClass="form-control text-uppercase" required="true"
										cssErrorClass="form-control has-errors" id="tariff">
										<form:option value="" label="--- None ---" />
										<c:forEach items="${tariffs}" var="tipS">
											<form:option value="${tipS.codTar}" label="${tipS.descTar}" />
										</c:forEach>
									</form:select>
									<form:errors path="tariff" cssClass="has-errors" element="span" />

								</div>
							</div>
							
						</div> 
						<div class="row-fluid">
						<div class="span4">
								<div class="formGroup">
									<form:label path="status" cssErrorClass="has-errors">
										<s:message code="contractview.contactdetails.status" />
										<span class="has-errors star">*</span>
									</form:label>
									<form:input path="status" cssClass="form-control"
									cssErrorClass="form-control has-errors" id="status"
									type="text" required="required" readonly="true" placeholder="status..." />
									<%-- <form:select path="status" disabled="true"
										cssClass="form-control text-uppercase"
										cssErrorClass="form-control has-errors" id="status">
										<form:option value="" label="--- None ---" />
										<c:forEach items="${contractStatuses}" var="tipS">
											<form:option value="${tipS.estado}" label="${tipS.descEst}" />
										</c:forEach>
									</form:select> --%>

									<form:errors path="status" cssClass="has-errors" element="span" />
								</div>
							</div>
							<div class="span4">
								<div class="formGroup">
									<form:label path="billingPeriod" cssErrorClass="has-errors">
										<s:message code="contractview.contactdetails.billingfrequency" />
										<span class="has-errors star">*</span>
									</form:label>
									<%-- <form:input path="billingPeriod" cssClass="form-control"
									cssErrorClass="form-control has-errors" id="billingPeriod"
									type="text" required="required" placeholder="billing frequency..." /> --%>
									<form:select path="billingPeriod" disabled="true"
										cssClass="form-control text-uppercase" required="true"
										cssErrorClass="form-control has-errors" id="billingPeriod">
										<form:option value="" label="--- None ---" />
										<c:forEach items="${billingPeriods}" var="tipS">
											<form:option value="${tipS.tipo}" label="${tipS.descTipo}" />
										</c:forEach>
									</form:select>

									<form:errors path="billingPeriod" cssClass="has-errors"
										element="span" />
								</div>

							</div>
							<div class="span4">
								<div class="formGroup">
									<form:label path="servicePoint.readingFrequency"
										cssErrorClass="has-errors">
										<s:message code="contractview.contactdetails.readingFrequency" />
										<span class="has-errors star">*</span>
									</form:label>
									<%-- <form:input path="servicePoint.readingFrequency" cssClass="form-control"
									cssErrorClass="form-control has-errors" id="readingFrequency"
									type="text" required="required" placeholder="Reading Frequency..." /> --%>
									<form:select path="servicePoint.readingFrequency" disabled="true"
										cssClass="form-control text-uppercase" required="true"
										cssErrorClass="form-control has-errors" id="readingFrequency">
										<form:option value="" label="--- None ---" />
										<c:forEach items="${readingPeriods}" var="tipS">
											<form:option value="${tipS.tipo}" label="${tipS.descTipo}" />
										</c:forEach>
									</form:select>

									<form:errors path="servicePoint.readingFrequency"
										cssClass="has-errors" element="span" />
								</div>
							</div>
							<div class="span4">
								
							</div>
						</div>
						</fieldset>
						<fieldset>
							<legend>
								<s:message code="contractview.fieldset.billdispatchmethods" />
							</legend>
							<div class="row-fluid">
								<div class="span12">
									<table class="table table-condensed table-hover">
										<thead>
											<tr>
												<!-- <th>Supply Point</th> -->
												<th><s:message code="dispatchMethod.accountno.text" /></th>
												<th><s:message
														code="dispatchMethod.dispatchmethod.text" /></th>
												<th><s:message code="dispatchMethod.updatedate.text" /></th>
												<th>&nbsp;</th>
												<th>&nbsp;</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${contract.billDispatchForms}"
												var="billDispatchForm">
												<tr class="active">
													<td>${billDispatchForm.contractNumber}</td>
													<td>${billDispatchForm.dispatchMethod}</td>
													<td>${billDispatchForm.updatedDate}</td>
													<td>&nbsp;</td>
													<td>&nbsp;</td>
												</tr>
											</c:forEach>
											<tr>
												<td colspan="5" rowspan="2"></td>
											</tr>
										</tbody>
									</table>
								</div>

							</div>
						</fieldset>
						<fieldset>
							<legend>
								<s:message code="contractview.fieldset.servicepointdetails" />
							</legend>
							<div class="row-fluid">
								<div class="span4">
									<div class="formGroup">
										<form:label path="servicePoint.status"
											cssErrorClass="has-errors">
											<s:message code="contractview.servicepointdetails.status" />
										</form:label>
										<%-- <form:input path="servicePoint.status" cssClass="form-control"
									cssErrorClass="form-control has-errors" type="text"
									id="servicePointstatus" required="required"
									placeholder="Service Point Status ..." /> --%>
										<form:select path="servicePoint.status" disabled="true"
											cssClass="form-control text-uppercase" cssErrorClass="form-control has-errors"
											id="servicePointstatus">
											<form:option value="" label="--- None ---" />
											<c:forEach items="${servicePointStatuses}" var="tipS">
												<form:option value="${tipS.estado}" label="${tipS.descEst}" />
											</c:forEach>
										</form:select>
										<form:errors path="servicePoint.status" cssClass="has-errors"
											element="span" />
									</div>
								</div>
								<div class="span4">
									<div class="formGroup">
										<form:label path="servicePoint.connectionType"
											cssErrorClass="has-errors">
											<s:message
												code="contractview.servicepointdetails.connectiontype" />
										</form:label>
										<%-- <form:input path="servicePoint.connectionType"
									cssClass="form-control" cssErrorClass="form-control has-errors"
									id="servicePointconnectionType" type="text" required="required"
									placeholder="servicePoint connectionType ..." /> --%>
										<form:select path="servicePoint.status" disabled="true"
											cssClass="form-control text-uppercase" required="true"
											cssErrorClass="form-control has-errors"
											id="servicePointconnectionType">
											<form:option value="" label="--- None ---" />
											<c:forEach items="${servicePointStatuses}" var="tipS">
												<form:option value="${tipS.estado}" label="${tipS.descEst}" />
											</c:forEach>
										</form:select>
										<form:errors path="servicePoint.connectionType"
											cssClass="has-errors" element="span" />
									</div>
								</div>
								<div class="span4">
									<div class="formGroup">
										<form:label path="servicePoint.phaseType"
											cssErrorClass="has-errors">
											<s:message code="contractview.servicepointdetails.phasetype" />
										</form:label>
										<%-- <form:input path="servicePoint.phaseType"
									cssClass="form-control" cssErrorClass="form-control has-errors"
									id="servicePointphaseType" type="text" required="required"
									placeholder="servicePoint phaseType ..." /> --%>
										<form:select path="servicePoint.phaseType" disabled="true"
											cssClass="form-control text-uppercase" required="true"
											cssErrorClass="form-control has-errors"
											id="servicePointphaseType">
											<form:option value="" label="--- None ---" />
											<c:forEach items="${phaseTypes}" var="tipS">
												<form:option value="${tipS.tipo}" label="${tipS.descTipo}" />
											</c:forEach>
										</form:select>
										<form:errors path="servicePoint.phaseType"
											cssClass="has-errors" element="span" />
									</div>
								</div>

							</div> 
							<div class="row-fluid">
						<div class="span4">
									<div class="formGroup">
										<form:label path="servicePoint.voltageType"
											cssErrorClass="has-errors">
											<s:message
												code="contractview.servicepointdetails.voltagetype" />
										</form:label>
										<%-- <form:input path="servicePoint.voltageType"
									cssClass="form-control" cssErrorClass="form-control has-errors"
									id="servicePointvoltageType" type="text" required="required"
									placeholder="servicePoint voltageType ..." /> --%>
										<form:select path="servicePoint.voltageType" disabled="true"
											cssClass="form-control text-uppercase" required="true"
											cssErrorClass="form-control has-errors"
											id="servicePointvoltageType">
											<form:option value="" label="--- None ---" />
											<c:forEach items="${voltageTypes}" var="tipS">
												<form:option value="${tipS.tipo}" label="${tipS.descTipo}" />
											</c:forEach>
										</form:select>
										<form:errors path="servicePoint.voltageType"
											cssClass="has-errors" element="span" />
									</div>
								</div>
						</div>
						</fieldset>
						<fieldset>
							<legend>
								<s:message code="myprofile.fieldset.premisedetails" />
							</legend>
							<div class="row-fluid">
								<div class="span4">
									<div class="formGroup">
										<form:label path="premiseInformation.district"
											cssErrorClass="has-errors">
											<s:message code="myprofile.district.label" />
										</form:label>
										<%-- <form:input path="premiseInformation.district"
									cssClass="form-control" cssErrorClass="form-control has-errors"
									id="district" type="text" required="required"
									placeholder="district ..." />	 --%>
										<form:select path="premiseInformation.district"
											cssClass="form-control text-uppercase" disabled="true"
											cssErrorClass="form-control has-errors" id="district"
											required="required" placeholder="district">
											<form:option value="0" label="--- None ---" />
											<c:forEach items="${districts}" var="district">
												<form:option value="${district.codMunic}"
													label="${district.nomMunic}" />
											</c:forEach>
										</form:select>
										<form:errors path="premiseInformation.district"
											cssClass="has-errors" element="span" />
									</div>
								</div>
								<div class="span4">
									<div class="formGroup">
										<form:label path="premiseInformation.village"
											cssErrorClass="has-errors">
											<s:message code="myprofile.village.label" />
										</form:label>
										<%-- <form:input path="premiseInformation.village"
									cssClass="form-control" cssErrorClass="form-control has-errors"
									id="village" type="text" required="required"
									placeholder="village ..." /> --%>
										<form:select path="premiseInformation.village"
											cssClass="form-control text-uppercase" disabled="true"
											cssErrorClass="form-control has-errors" id="village"
											required="required">
											<form:option value="0" label="--- None ---" />
											<c:forEach items="${villages}" var="village">
												<form:option value="${village.codLocal}"
													label="${village.nomLocal}" />
											</c:forEach>
										</form:select>
										<form:errors path="premiseInformation.village"
											cssClass="has-errors" element="span" />
									</div>
								</div>
								<div class="span4">
									<div class="formGroup">
										<form:label path="premiseInformation.street"
											cssErrorClass="has-errors">
											<s:message code="myprofile.street.label" />
										</form:label>
										<%-- <form:input path="premiseInformation.street"
									cssClass="form-control" cssErrorClass="form-control has-errors"
									id="street" type="text" required="required"
									placeholder="street ..." /> --%>
										<form:select path="premiseInformation.street"
											cssClass="form-control text-uppercase" disabled="true"
											cssErrorClass="form-control has-errors" id="street"
											required="required" >
											<form:option value="0" label="--- None ---" />
											<c:forEach items="${streets}" var="street">
												<form:option value="${street.codCalle}"
													label="${street.nomCalle}" />
											</c:forEach>
										</form:select>
										<form:errors path="premiseInformation.street"
											cssClass="has-errors" element="span" />
									</div>
								</div>
							</div> 
							<div class="row-fluid">
							
								<div class="span4">
									<div class="formGroup">
										<form:label path="premiseInformation.housePlotNumber"
											cssErrorClass="has-errors">
											<s:message code="myprofile.houseplotno.label" />
										</form:label>
										<form:input path="premiseInformation.housePlotNumber"
											cssClass="form-control" readonly="true"
											cssErrorClass="form-control has-errors" id="houseplotno"
											type="text" required="required" />
										<form:errors path="premiseInformation.housePlotNumber"
											cssClass="has-errors" element="span" />
									</div>
								</div>
								<div class="span4">
									<div class="formGroup">
										<form:label path="premiseInformation.landmark"
											cssErrorClass="has-errors">
											<s:message code="myprofile.landmark.label" />
										</form:label>
										<form:input path="premiseInformation.landmark"
											cssClass="form-control" readonly="true"
											cssErrorClass="form-control has-errors" id="landmark"
											type="text" required="required" />
										<form:errors path="premiseInformation.landmark"
											cssClass="has-errors" element="span" />
									</div>
								</div>
							</div>
						</fieldset>
						<fieldset>
							<legend>
								<s:message code="contractview.fieldset.meterdetails" />
							</legend>
							<div class="row-fluid">
								<div class="span4">
									<div class="formGroup">
										<form:label path="meterData.meterNumber">
											<s:message code="contractview.meterdetails.meterno" />
											<span class="has-errors star">*</span>
										</form:label>
										<form:input path="meterData.meterNumber" required="true"
											cssClass="form-control text-uppercase" id="meterNumber"
											 readonly="true" />
										<form:errors path="meterData.meterNumber"
											cssClass="has-errors" element="span" />
									</div>
								</div>
								<div class="span4">
									<div class="formGroup">
										<form:label path="meterData.meterStatus">
											<s:message code="contractview.meterdetails.meterstatus" />
											<span class="has-errors star">*</span>
										</form:label>
										<%-- <form:input path="meterData.meterStatus" required="true"
										cssClass="form-control text-uppercase" id="meterStatus"
										placeholder="Meter Status.." /> --%>
										<form:select path="meterData.meterStatus" disabled="true"
											cssClass="form-control text-uppercase" required="true"
											cssErrorClass="form-control has-errors" id="meterStatus">
											<form:option value="" label="--- None ---" />
											<c:forEach items="${meterStatuses}" var="tipS">
												<form:option value="${tipS.estado}" label="${tipS.descEst}" />
											</c:forEach>
										</form:select>
										<form:errors path="meterData.meterStatus"
											cssClass="has-errors" element="span" />
									</div>
								</div>
								<div class="span4">
									<div class="formGroup">
										<form:label path="meterData.manufacturer">
											<s:message code="contractview.meterdetails.manufacturer" />
											<span class="has-errors star">*</span>
										</form:label>
										<%-- <form:input path="meterData.manufacturer" required="true"
										cssClass="form-control text-uppercase" id="metermanufacturer"
										placeholder="Manufacturer.." /> --%>
										<form:select path="meterData.manufacturer" disabled="true"
											cssClass="form-control text-uppercase" required="true"
											cssErrorClass="form-control has-errors"
											id="metermanufacturer">
											<form:option value="" label="--- None ---" />
											<c:forEach items="${manufacturers}" var="tipS">
												<form:option value="${tipS.cod}" label="${tipS.descCod}" />
											</c:forEach>
										</form:select>
										<form:errors path="meterData.manufacturer"
											cssClass="has-errors" element="span" />
									</div>
								</div>
							</div>
							<div class="row-fluid">
							
								<div class="span4">
									<div class="formGroup">
										<form:label path="meterData.meterModel">
											<s:message code="contractview.meterdetails.model" />
											<span class="has-errors star">*</span>
										</form:label>
										<%-- <form:input path="meterData.meterModel" required="true"
										cssClass="form-control text-uppercase" id="meterModel"
										placeholder="Meter Model.." /> --%>
										<form:select path="meterData.meterModel" disabled="true"
											cssClass="form-control text-uppercase" required="true"
											cssErrorClass="form-control has-errors" id="meterModel">
											<form:option value="" label="--- None ---" />
											<c:forEach items="${meterModels}" var="tipS">
												<form:option value="${tipS.cod}" label="${tipS.descCod}" />
											</c:forEach>
										</form:select>
										<form:errors path="meterData.meterModel" cssClass="has-errors"
											element="span" />
									</div>
								</div>
								<div class="span4">
									<div class="formGroup">
										<form:label path="meterData.meterNature">
											<s:message code="contractview.meterdetails.meternature" />
											<span class="has-errors star">*</span>
										</form:label>
										<%-- <form:input path="meterData.meterNature" required="true"
										cssClass="form-control text-uppercase" id="meterNature"
										placeholder="Meter Nature.." /> --%>
										<form:select path="meterData.meterNature" disabled="true"
											cssClass="form-control text-uppercase" required="true"
											cssErrorClass="form-control has-errors" id="meterNature">
											<form:option value="" label="--- None ---" />
											<c:forEach items="${meterNatures}" var="tipS">
												<form:option value="${tipS.tipo}" label="${tipS.descTipo}" />
											</c:forEach>
										</form:select>
										<form:errors path="meterData.meterNature"
											cssClass="has-errors" element="span" />
									</div>
								</div>
								<div class="span4">
									<div class="formGroup">
										<form:label path="meterData.voltage">
											<s:message code="contractview.meterdetails.voltage" />
											<span class="has-errors star">*</span>
										</form:label>
										<%-- <form:input path="meterData.voltage" required="true"
										cssClass="form-control text-uppercase" id="metervoltage"
										placeholder="Meter Number.." /> --%>
										<form:select path="meterData.voltage" disabled="true"
											cssClass="form-control text-uppercase" required="true"
											cssErrorClass="form-control has-errors" id="metervoltage">
											<form:option value="" label="--- None ---" />
											<c:forEach items="${meterVoltages}" var="tipS">
												<form:option value="${tipS.tipo}" label="${tipS.descTipo}" />
											</c:forEach>
										</form:select>
										<form:errors path="meterData.voltage" cssClass="has-errors"
											element="span" />
									</div>
								</div> 
							</div>
							<div class="row-fluid">
								
								<div class="span4">
									<div class="formGroup">
										<form:label path="meterData.materialType">
											<s:message code="contractview.meterdetails.materialtype" />
											<span class="has-errors star">*</span>
										</form:label>
										<%-- <form:input path="meterData.materialType" required="true"
										cssClass="form-control text-uppercase" id="materialType"
										placeholder="Material Type.." /> --%>
										<form:select path="meterData.materialType" disabled="true"
											cssClass="form-control text-uppercase" required="true"
											cssErrorClass="form-control has-errors" id="materialType">
											<form:option value="" label="--- None ---" />
											<c:forEach items="${meterMaterialTypes}" var="tipS">
												<form:option value="${tipS.tipo}" label="${tipS.descTipo}" />
											</c:forEach>
										</form:select>
										<form:errors path="meterData.materialType"
											cssClass="has-errors" element="span" />
									</div>
								</div>
							</div>
						</fieldset>
						<fieldset>
							<legend>
								<s:message code="contractview.fieldset.contractfinancialsummary" />
							</legend>
							<div class="row-fluid">
							<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" 
							value="${contract.contractFinancialSummary.depositAmount}" var="depositAmount" />
								<div class="span4">
									<div class="formGroup">
										<form:label path="contractFinancialSummary.depositAmount">
											<s:message
												code="contractview.contractfinancialsummary.deposit" />
											<span class="has-errors star">*</span>
										</form:label>
										<form:input path="*"
											required="true" cssClass="form-control text-uppercase"
											id="materialType" readonly="true" value="${depositAmount}" />
										<form:errors path="contractFinancialSummary.depositAmount"
											cssClass="has-errors" element="span" />
									</div>
								</div>
								<div class="span4">
							<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" 
							value="${contract.contractFinancialSummary.outstandingAmount}" var="outstandingAmount" />
									<div class="formGroup">
										<form:label path="contractFinancialSummary.outstandingAmount">
											<s:message
												code="contractview.contractfinancialsummary.outstandingamount" />
											<span class="has-errors star">*</span>
										</form:label>
										<form:input path="*"
											required="true" cssClass="form-control text-uppercase"
											id="materialType" readonly="true" value="${outstandingAmount}"  />
										<form:errors path="contractFinancialSummary.outstandingAmount"
											cssClass="has-errors" element="span" />
									</div>
								</div>
								<div class="span4">
									<div class="formGroup">
										<form:label path="contractFinancialSummary.nextPaymentDate">
											<s:message
												code="contractview.contractfinancialsummary.nextpaymentdate" />
											<span class="has-errors star">*</span>
										</form:label>
										<form:input path="contractFinancialSummary.nextPaymentDate"
											required="true" cssClass="form-control text-uppercase"
											id="materialType" readonly="true" />
										<form:errors path="contractFinancialSummary.nextPaymentDate"
											cssClass="has-errors" element="span" />
									</div>
								</div> 
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