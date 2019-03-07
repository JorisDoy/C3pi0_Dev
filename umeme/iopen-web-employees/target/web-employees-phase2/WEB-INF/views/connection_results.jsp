<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>

<div id="main" class="wrap post-template">
	<div class="container">
		<div class="row-fluid">
			<div class="span12 post-page">
				<a class="btn btn-lg btn-primary"
					href="<c:url value="/employee/connection/pendingconnection?schedule=true"/>"
					role="button"> <s:message code="connection.view.back" /></a>
				<h3 class="module-title-short">
					<span class="selected"><s:message
							code="connection.result.title" /></span>

				</h3>
				<form:form method="POST" commandName="connectionResult"
					cssClass="form-horizontal dropzone" id="connectionResult">
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
						<legend>
							<s:message code="schedule.inspection.fieldsetext" />
						</legend>
						<div class="row-fluid">
							<div class="span4">
								<div class="form-group">
									<form:label path="*" cssErrorClass="has-errors">
										<s:message code="application.surname.label" />

									</form:label>
									<form:input path="*" cssClass="form-control text-uppercase"
										cssErrorClass="form-control has-errors" id="surname"
										placeholder="surname" readonly="true"
										value="${connectionResult.iopenApplication.surname}" />
								</div>
							</div>
							<div class="span4">
								<div class="form-group">
									<form:label path="*" cssErrorClass="has-errors">
										<s:message code="application.firstname.label" />

									</form:label>
									<form:input path="*" cssClass="form-control text-uppercase"
										cssErrorClass="form-control has-errors" id="firstName"
										placeholder="firstName" readonly="true"
										value="${connectionResult.iopenApplication.firstName}" />
								</div>
							</div>
							<div class="span4">
								<div class="form-group">
									<form:label path="*" cssErrorClass="has-errors">
										<s:message code="application.middlename.label" />
									</form:label>
									<form:input path="*" cssClass="form-control text-uppercase"
										cssErrorClass="form-control has-errors" id="middlename"
										placeholder="middleName" readonly="true"
										value="${connectionResult.iopenApplication.middleName}" />
								</div>
							</div>
						</div>
						<div class="row-fluid">
							<div class="span4">
								<div class="form-group">
									<form:label path="*" cssErrorClass="has-errors">
										<s:message code="application.idnumber.label" />

									</form:label>
									<form:input path="*" cssClass="form-control text-uppercase"
										cssErrorClass="form-control has-errors" id="idNumber"
										placeholder="idNumber" readonly="true"
										value="${connectionResult.iopenApplication.idNumber}" />
									<form:errors path="*" cssClass="has-errors" element="span" />
								</div>
							</div>
							<div class="span4">
								<div class="form-group">
									<form:label path="*" cssErrorClass="has-errors">
										<s:message code="application.tinnumber.label" />
									</form:label>
									<form:input path="*" cssClass="form-control text-uppercase"
										cssErrorClass="form-control has-errors" id="tinNumber"
										placeholder="tinNumber" readonly="true"
										value="${connectionResult.iopenApplication.tinNumber}" />
									<form:errors path="*" cssClass="has-errors" element="span" />
								</div>
							</div>
						</div>
						<div class="row-fluid">
							<div class="span4">
								<div class="formGroup">
									<form:label path="*">
										<s:message code="inspection.col.ApplicationType" />
									</form:label>
									<form:input path="*" cssClass="form-control text-uppercase"
										id="applicationType" placeholder="application type.."
										readonly="true"
										value="${defaultValues.get(connectionResult.iopenApplication.applicationType)}" />
								</div>
							</div>
							<div class="span4">
								<div class="formGroup">
									<form:label path="*">
										<s:message code="inspection.col.ApplicationNumber" />
									</form:label>
									<form:input path="*" cssClass="form-control text-uppercase"
										id="applicationNumber" placeholder="application no.."
										readonly="true"
										value="${connectionResult.iopenApplication.expediente.numExp}" />

								</div>
							</div>
							<div class="span4">
								<div class="formGroup">
									<form:label path="*">
										<s:message code="inspection.col.ApplicationDistrict" />
									</form:label>
									<%-- <form:input path="*" cssClass="form-control text-uppercase"
										id="applicationDistrict" placeholder="district.."
										readonly="true"
										value="${connectionResult.iopenApplication.district}" /> --%>
									<form:select path="iopenApplication.district"
										cssClass="form-control text-uppercase"
										cssErrorClass="form-control has-errors" id="district"
										placeholder="district" readonly="true">
										<form:option value="0" label="--- Select ---" />
										<c:forEach items="${districts}" var="district">
											<form:option value="${district.codMunic}"
												label="${district.nomMunic}" />
										</c:forEach>
									</form:select>
								</div>
							</div>
						</div>
						<div class="row-fluid">
							<div class="span4">
								<div class="formGroup">
									<form:label path="*">
										<s:message code="inspection.col.ApplicationVillage" />
									</form:label>
									<%-- <form:input path="*" cssClass="form-control text-uppercase"
										id="applicationvillage" placeholder="village.."
										readonly="true"
										value="${connectionResult.iopenApplication.village}" /> --%>
									<form:select path="iopenApplication.village"
										cssClass="form-control text-uppercase"
										cssErrorClass="form-control has-errors" id="village"
										placeholder="village" readonly="true">
										<form:option value="" label="--- Select ---" />
										<c:forEach items="${villages}" var="village">
											<form:option value="${village.codLocal}"
												label="${village.nomLocal}" />
										</c:forEach>
									</form:select>
								</div>
							</div>
							<div class="span4">
								<div class="formGroup">
									<form:label path="*">
										<s:message code="inspection.col.ApplicationStreet" />
									</form:label>
									<%-- 	<form:input path="*" cssClass="form-control text-uppercase"
										id="applicationStreet" placeholder="street.." readonly="true"
										value="${connectionResult.iopenApplication.street}" /> --%>
									<form:select path="iopenApplication.street"
										cssClass="form-control text-uppercase"
										cssErrorClass="form-control has-errors" id="street"
										placeholder="street">
										<form:option value="" label="--- Select ---" />
										<c:forEach items="${streets}" var="street">
											<form:option value="${street.codCalle}"
												label="${street.nomCalle}" />
										</c:forEach>
									</form:select>
								</div>
							</div>
							<div class="span4">
								<div class="formGroup">
									<form:label path="*">
										<s:message code="inspection.col.ApplicationHousePlot" />
									</form:label>
									<form:input path="*" cssClass="form-control text-uppercase"
										id="applicationhousePlot" placeholder="House/Plot.."
										readonly="true"
										value="${connectionResult.iopenApplication.housePlot}" />
								</div>
							</div>

						</div>
						<div class="row-fluid">
							<div class="span4">
								<div class="formGroup">
									<form:label path="*">
										<s:message code="inspection.col.ApplicationPhoneNumber" />
									</form:label>
									<form:input path="*" cssClass="form-control text-uppercase"
										id="applicationphoneNumber" placeholder="Phone Number.."
										readonly="true"
										value="${connectionResult.iopenApplication.mobileNumber}" />
								</div>
							</div>
							<div class="span4"></div>
							<div class="span4"></div>
						</div>

					</fieldset>
					<%-- <fieldset>
						<legend>
							<s:message code="schedule.inspection.docs" />
						</legend>
						<div class="row-fluid">
							<div class="span12">
								<ol style="display: inline-block">
									<li><s:message code="application.validid.label" /></li>
									<li><s:message code="application.validcompanyseal.label" /></li>
									<li><s:message code="application.validpassport.label" /></li>
									<li><s:message
											code="application.validwiringcertificate.label" /></li>
								</ol>
							</div>

						</div>
						<div class="row-fluid">
							<div class="span12" style="overflow: auto">
								<table class="table table-condensed table-hover">
									<thead>
										<tr>
											<!-- <th>ID</th> -->
											<th><s:message code="schedule.inspection.docsupload" /></th>
										</tr>
									</thead>
									<tbody>
										<c:forEach
											items="${receivedInspectionResult.iopenApplication.iopenApplicationDocs}"
											var="doc">
											<tr class="active">
												<td>${doc.fActual}</td>
												<td>${doc.docDesc}</td>

												<td><a class="fancybox ${doc.contentClass}"
													data-fancybox-type="iframe"
													href="<c:url value="/employee/download?codApplication=${doc.id.codApplication}&tipDoc=${doc.id.tipDoc}"/>"
													target="_blank"> view</a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
						<div class="row-fluid">
							<div class="span12">
								<hr />
							</div>
						</div>

					</fieldset> --%>

					<fieldset>
						<legend>
							<s:message code="connection.results" />
						</legend>
						<div class="row-fluid">
							<div class="span12">
								<b><s:message code="connection.servicepoint.data" /></b>
							</div>
						</div>
						<div class="row-fluid">
							<div class="span4">
								<div class="formGroup">
									<form:label path="servicePointStatus">
										<s:message code="connection.servicePointStatus" />
										<span class="has-errors star">*</span>
									</form:label>
									<form:select path="servicePointStatus" required="true"
										cssClass="form-control text-uppercase"
										cssErrorClass="form-control has-errors"
										id="servicePointStatus">
										<form:option value="" label="--- Select ---" />
										<c:forEach items="${servicePointStatuses}" var="tipS">
											<form:option value="${tipS.estado}" label="${tipS.descEst}" />
										</c:forEach>
									</form:select>
									<form:errors path="servicePointStatus" cssClass="has-errors"
										element="span" />
								</div>
							</div>
							<div class="span4">
								<div class="formGroup">
									<form:label path="servicePointType">
										<s:message code="connection.servicePointType" />
										<span class="has-errors star">*</span>
									</form:label>
									<form:select path="servicePointType"
										cssClass="form-control text-uppercase" required="true"
										cssErrorClass="form-control has-errors" id="servicePointType">
										<form:option value="" label="--- Select ---" />
										<c:forEach items="${servicePointTypes}" var="tipS">
											<form:option value="${tipS.tipo}" label="${tipS.descTipo}" />
										</c:forEach>
									</form:select>
									<form:errors path="servicePointType" cssClass="has-errors"
										element="span" />
								</div>
							</div>
							<div class="span4"></div>

							<div class="span12">
								<hr />
							</div>
						</div>
						<div class="row-fluid">
							<div class="span12">
								<b><s:message code="connection.servicepointtechnical.data" /></b>
							</div>
						</div>

						<div class="row-fluid">
							<div class="span4">
								<div class="formGroup">
									<form:label path="*">
										<s:message code="connection.connectionType" />
										<span class="has-errors star">*</span>
									</form:label>
									<form:select path="connectionType"
										cssClass="form-control text-uppercase" required="true"
										cssErrorClass="form-control has-errors" id="connectionType">
										<form:option value="" label="--- Select ---" />
										<c:forEach items="${connectionTypes}" var="tipS">
											<form:option value="${tipS.tipo}" label="${tipS.descTipo}" />
										</c:forEach>
									</form:select>
									<form:errors path="connectionType" cssClass="has-errors"
										element="span" />
								</div>
							</div>
							<div class="span4">
								<div class="formGroup">
									<form:label path="voltageType">
										<s:message code="connection.voltageType" />
										<span class="has-errors star">*</span>
									</form:label>
									<form:select path="voltageType"
										cssClass="form-control text-uppercase" required="true"
										cssErrorClass="form-control has-errors" id="voltageType">
										<form:option value="" label="--- Select ---" />
										<c:forEach items="${voltageTypes}" var="tipS">
											<form:option value="${tipS.tipo}" label="${tipS.descTipo}" />
										</c:forEach>
									</form:select>
									<form:errors path="voltageType" cssClass="has-errors"
										element="span" />
								</div>
							</div>
							<div class="span4">
								<div class="formGroup">
									<form:label path="phaseType">
										<s:message code="connection.phaseType" />
										<span class="has-errors star">*</span>
									</form:label>
									<form:select path="phaseType"
										cssClass="form-control text-uppercase" required="true"
										cssErrorClass="form-control has-errors" id="phaseType">
										<form:option value="" label="--- Select ---" />
										<c:forEach items="${phaseTypes}" var="tipS">
											<form:option value="${tipS.tipo}" label="${tipS.descTipo}" />
										</c:forEach>
									</form:select>
									<form:errors path="phaseType" cssClass="has-errors"
										element="span" />
								</div>
							</div>
						</div>

						<div class="row-fluid">
							<div class="span4">
								<div class="formGroup">
									<form:label path="contPower">
										<s:message code="connection.contPower" />
										<span class="has-errors star">*</span>
									</form:label>
									<form:input path="contPower" required="true"
										cssClass="form-control text-uppercase" id="contPower"
										placeholder="contPower.." />
									<form:errors path="contPower" cssClass="has-errors"
										element="span" />
								</div>
							</div>
							<div class="span4"></div>
							<div class="span4"></div>
							<div class="span12">
								<hr />
							</div>
						</div>
						<div class="row-fluid">
							<div class="span12">
								<b><s:message code="connection.servicepointother.data" /></b>
							</div>
						</div>
						<div class="row-fluid">
							<div class="span4">
								<div class="formGroup">
									<form:label path="associationType">
										<s:message code="connection.associationType" />
										<span class="has-errors star">*</span>
									</form:label>
									<form:select path="associationType" required="true"
										cssClass="form-control text-uppercase"
										cssErrorClass="form-control has-errors" id="voltageType">
										<form:option value="" label="--- Select ---" />
										<c:forEach items="${associationTypes}" var="tipS">
											<form:option value="${tipS.tipo}" label="${tipS.descTipo}" />
										</c:forEach>
									</form:select>
									<form:errors path="associationType" cssClass="has-errors"
										element="span" />
								</div>
							</div>
							<%-- jagira 20170605 - Remove the field default to "Without Usage Estimate"
							<div class="span4">
								<div class="formGroup">
									<form:label path="estimationMethod">
										<s:message code="connection.estimationMethod" />
										<span class="has-errors star">*</span>
									</form:label>
									<form:select path="estimationMethod" required="true"
										cssClass="form-control text-uppercase"
										cssErrorClass="form-control has-errors" id="estimationMethod">
										<form:option value="" label="--- Select ---" />
										<c:forEach items="${estimationMethods}" var="tipS">
											<form:option value="${tipS.cod}" label="${tipS.descCod}" />
										</c:forEach>
									</form:select>
									<form:errors path="estimationMethod" cssClass="has-errors"
										element="span" />
								</div>
							</div>
							--%>
							<div class="span4">
								<div class="formGroup">
									<form:label path="readingPeriod">
										<s:message code="connection.readingPeriod" />
										<span class="has-errors star">*</span>
									</form:label>
									<form:select path="readingPeriod" required="true"
										cssClass="form-control text-uppercase"
										cssErrorClass="form-control has-errors" id="readingPeriod">
										<form:option value="" label="--- Select ---" />
										<c:forEach items="${readingPeriods}" var="tipS">
											<form:option value="${tipS.tipo}" label="${tipS.descTipo}" />
										</c:forEach>
									</form:select>
									<form:errors path="readingPeriod" cssClass="has-errors"
										element="span" />
								</div>
							</div>

						</div>
						<div class="row-fluid">
							<div class="span4">
								<div class="formGroup">
									<form:label path="recommendedTariff">
										<s:message code="connection.recommendedTariff" />
										<span class="has-errors star">*</span>
									</form:label>
									<form:select path="recommendedTariff" required="true"
										cssClass="form-control text-uppercase"
										cssErrorClass="form-control has-errors" id="recommendedTariff">
										<form:option value="" label="--- Select ---" />
										<c:forEach items="${recommendedTariffs}" var="tipS">
											<form:option value="${tipS.codTar}" label="${tipS.descTar}" />
										</c:forEach>
									</form:select>
									<form:errors path="recommendedTariff" cssClass="has-errors"
										element="span" />
								</div>
							</div>
							<div class="span4">
								<div class="formGroup">
									<form:label path="depositPaid">
										<s:message code="connection.depositPaid" />
										<span class="has-errors star">*</span>
									</form:label>
									<form:select path="depositPaid" required="true"
										cssClass="form-control text-uppercase"
										cssErrorClass="form-control has-errors" id="depositPaid">
										<form:option value="1">
											<s:message code="connection.paid.label" />
										</form:option>
										<form:option value="0">
											<s:message code="connection.unpaid.label" />
										</form:option>
									</form:select>
									<form:errors path="depositPaid" cssClass="has-errors"
										element="span" />
								</div>
							</div>
							<%-- jagira 20170605 Remove and default to FUSE
							<div class="span4">
								<div class="formGroup">
									<form:label path="fuseOrMcb">
										<s:message code="connection.fuseOrMcb" />
										<span class="has-errors star">*</span>
									</form:label>
									<form:select path="fuseOrMcb" required="true"
										cssClass="form-control text-uppercase"
										cssErrorClass="form-control has-errors" id="fuseOrMcb">
										<form:option value="1">
											<s:message code="connection.fuse.label" />
										</form:option>
										<form:option value="2">
											<s:message code="connection.mcb.label" />
										</form:option>
									</form:select>
									<form:errors path="fuseOrMcb" cssClass="has-errors"
										element="span" />
								</div>
							</div>
							--%>
						</div>
						<div class="row-fluid">

							<div class="span4"></div>
						</div>
						<div class="row-fluid">
							<div class="span4">
								<div class="formGroup">
									<form:label path="readingNature">
										<s:message code="connection.readingNature" />
										<span class="has-errors star">*</span>
									</form:label>
									<form:select path="readingNature" required="true"
										cssClass="form-control text-uppercase"
										cssErrorClass="form-control has-errors" id="readingNature">
										<form:option value="" label="--- Select ---" />
										<c:forEach items="${readingNatures}" var="tipS">
											<form:option value="${tipS.tipo}" label="${tipS.descTipo}" />
										</c:forEach>
									</form:select>
									<form:errors path="readingNature" cssClass="has-errors"
										element="span" />
								</div>
							</div>
							<div class="span4">
								<div class="formGroup">
									<form:label path="mrDiv">
										<s:message code="connection.mrDiv" />
										<span class="has-errors star">*</span>
									</form:label>
									<!--SMA 20160317  -->
									<form:select path="mrDiv" required="true"
										cssClass="form-control text-uppercase"
										cssErrorClass="form-control has-errors" id="mrDiv">
										<form:option value="0" label="--- Select ---" />
										<c:forEach items="${meterReadingDivisions}" var="mrDiv">
											<form:option value="${mrDiv.key}" label="${mrDiv.value}" />
										</c:forEach>
									</form:select>
									<%-- <form:input path="mrDiv" cssClass="form-control text-uppercase"
										id="mrDiv" placeholder="MRDiv.." required="true" /> --%>
									<form:errors path="mrDiv" cssClass="has-errors" element="span" />
								</div>
							</div>
							<%-- jagira 20170605 Remove and default to 00
							<div class="span4">
								<div class="formGroup">
									<form:label path="rso">
										<s:message code="connection.rso" />
										<span class="has-errors star">*</span>
									</form:label>
									<form:input path="rso" cssClass="form-control text-uppercase"
										id="rso" placeholder="RSO.." required="true" />
									<form:errors path="rso" cssClass="has-errors" element="span" />
								</div>
							</div>
							--%>
						</div>

						<div class="row-fluid">
							<div class="span4">
								<form:label path="meterConstant">
									<s:message code="connection.meterConstant" />
									<span class="has-errors star">*</span>
								</form:label>
								<form:input path="meterConstant" required="true"
									cssClass="form-control text-uppercase" id="meterConstant"
									placeholder="Meter Constant.." />
								<form:errors path="meterConstant" cssClass="has-errors"
									element="span" />
							</div>
							<div class="span4">
								<form:label path="lossCoefficient">
									<s:message code="connection.lossCoefficient" />
									<span class="has-errors star">*</span>
								</form:label>
								<form:input path="lossCoefficient" required="true"
									cssClass="form-control text-uppercase" id="lossCoefficient"
									placeholder="Loss Coefficient.." />
								<form:errors path="lossCoefficient" cssClass="has-errors"
									element="span" />

							</div>
							<div class="span4"></div>
							<div class="span12">
								<hr />
							</div>
						</div>

						<div class="row-fluid">
							<div class="span12">
								<b><s:message code="connection.meterinstallation.data" /></b>
							</div>
						</div>
						<div class="row-fluid">
							<div class="span4">
								<div class="formGroup">
									<form:label path="floorNumber">
										<s:message code="connection.floorNumber" />
										<span class="has-errors star">*</span>
									</form:label>
									<form:input path="floorNumber" required="true"
										cssClass="form-control text-uppercase" id="floorNumber"
										placeholder="floor Number.." />
									<form:errors path="floorNumber" cssClass="has-errors"
										element="span" />
								</div>
							</div>
							<div class="span4">
								<div class="formGroup">
									<form:label path="meterNumber">
										<s:message code="connection.meterNumber" />
										<span class="has-errors star">*</span>
									</form:label>
									<form:input path="meterNumber" required="true"
										cssClass="form-control text-uppercase" id="meterNumber"
										placeholder="Meter Number.." />
									<form:errors path="meterNumber" cssClass="has-errors"
										element="span" />
								</div>
							</div>
							<div class="span4">
								<div class="formGroup">
									<form:label path="meterInitialReading">
										<s:message code="connection.meterInitialReading" />
										<span class="has-errors star">*</span>
									</form:label>
									<form:input path="meterInitialReading" required="true"
										cssClass="form-control text-uppercase"
										id="meterInitialReading" placeholder="Meter Initial Reading.." />
									<form:errors path="meterInitialReading" cssClass="has-errors"
										element="span" />
								</div>
							</div>
						</div>
						<div class="row-fluid">
							<div class="span4">
								<div class="formGroup">
									<form:label path="meterMake">
										<s:message code="connection.meterMake" />
										<span class="has-errors star">*</span>
									</form:label>
									<form:select path="meterMake" required="true"
										cssClass="form-control text-uppercase"
										cssErrorClass="form-control has-errors" id="meterMake">
										<form:option value="" label="--- Select ---" />
										<c:forEach items="${meterMakes}" var="tipS">
											<form:option value="${tipS.cod}" label="${tipS.descCod}" />
										</c:forEach>
									</form:select>
									<form:errors path="meterMake" cssClass="has-errors"
										element="span" />
								</div>
							</div>
							<div class="span4">
								<div class="formGroup">
									<form:label path="noOfDials">
										<s:message code="connection.noOfDials" />
										<span class="has-errors star">*</span>
									</form:label>
									<form:input path="noOfDials" required="true"
										cssClass="form-control text-uppercase" id="noOfDials"
										placeholder="No Of Dials.." />
									<form:errors path="noOfDials" cssClass="has-errors"
										element="span" />
								</div>
							</div>
							<div class="span4"></div>

							<div class="span12">
								<hr />
							</div>
						</div>

						<!-- Start of network maping -->
						<div class="row-fluid">
							<div class="span12">
								<b><s:message code="connection.network.data" /></b>
							</div>
						</div>
						<div class="row-fluid">
							<div class="span3">
								<div class="formGroup">
									<form:label path="subStation">
										<s:message code="connection.subStation" />
										<span class="has-errors star">*</span>
									</form:label>

									<form:select path="subStation" required="true"
										cssClass="form-control text-uppercase"
										cssErrorClass="form-control has-errors" id="subStation">
										<form:option value="" label="--- Select ---" />
										<c:forEach items="${subStations}" var="subStation">
											<form:option value="${subStation.id.nroInstalacion}"
												label="${subStation.nomInstalacion}" />
										</c:forEach>
									</form:select>
									<form:errors path="subStation" cssClass="has-errors"
										element="span" />
								</div>

							</div>

							<c:url var="findSubstationFeedersURL"
								value="/rest/connection/result/feeders" />
							<div class="span3">
								<div class="formGroup">
									<form:label path="feeder">
										<s:message code="connection.feeder" />
										<span class="has-errors star">*</span>
									</form:label>

									<form:select path="feeder" required="true"
										cssClass="form-control text-uppercase"
										cssErrorClass="form-control has-errors" id="feeder">
										<form:option value="" label="--- Select ---" />
										<c:forEach items="${feeders}" var="feeder">
											<form:option value="${feeder.id.nroInstalacion}"
												label="${feeder.nomInstalacion}" />
										</c:forEach>
									</form:select>
									<form:errors path="feeder" cssClass="has-errors" element="span" />
								</div>

							</div>

							<c:url var="findFeederTransformersURL"
								value="/rest/connection/result/transformers" />
							<div class="span3">
								<div class="formGroup">
									<form:label path="transformer">
										<s:message code="connection.transformer" />
										<span class="has-errors star">*</span>
									</form:label>

									<form:select path="transformer" required="true"
										cssClass="form-control text-uppercase"
										cssErrorClass="form-control has-errors" id="transformer">
										<form:option value="" label="--- Select ---" />
										<c:forEach items="${transformers}" var="transformer">
											<form:option value="${transformer.id.nroInstalacion}"
												label="${transformer.nomInstalacion}" />
										</c:forEach>
									</form:select>
									<form:errors path="transformer" cssClass="has-errors"
										element="span" />
								</div>

							</div>

							<c:url var="findTransformerCircuitsURL"
								value="/rest/connection/result/circuits" />
							<div class="span3">
								<div class="formGroup">
									<form:label path="imsInstallationCode">
										<s:message code="connection.imsInstallationCode" />
										<span class="has-errors star">*</span>
									</form:label>

									<form:select path="imsInstallationCode" required="true"
										cssClass="form-control text-uppercase"
										cssErrorClass="form-control has-errors"
										id="imsInstallationCode">
										<form:option value="" label="--- Select ---" />
										<c:forEach items="${circuits}" var="circuit">
											<form:option value="${circuit.id.nroInstalacion}"
												label="${circuit.nomInstalacion}" />
										</c:forEach>
									</form:select>

									<%-- <form:input path="imsInstallationCode" required="true"
										cssClass="form-control text-uppercase"
										id="imsInstallationCode" placeholder="IMS Installation Code.." /> --%>


									<form:errors path="imsInstallationCode" cssClass="has-errors"
										element="span" />
								</div>

							</div>

							<div class="span12">
								<hr />
							</div>
						</div>
						<!-- End of network maping -->


						<div class="row-fluid">
							<div class="span12">
								<b><s:message code="connection.details" /></b>
							</div>
						</div>
						<div class="row-fluid">
							<div class="span4">
								<div class="formGroup">
									<form:label path="connectionDateString">
										<s:message code="connection.connectionDate" />
										<span class="has-errors star">*</span>
									</form:label>
									<%-- <div id="scheduledDatepicker" class="input-append date">
										<form:input path="connectionDateString" data-format="dd/MM/yyyy" required="true"
											type="text" id="connectionDate" cssClass="form-control"
											cssErrorClass="form-control has-errors" role="aria" />
										<span class="add-on"> <i data-time-icon="icon-time"
											data-date-icon="icon-calendar"> </i>
										</span>

									</div> --%>
									<div class="input-append date" id="connectionScheduledDate"
										data-date="" data-date-format="dd/mm/yyyy">
										<form:input path="connectionDateString" type="text"
											id="connectionScheduledDate2" cssClass="form-control"
											cssErrorClass="form-control has-errors" role="aria"
											required="true" />

										<span class="add-on"><i class="icon-calendar"></i></span>
									</div>
									<form:errors path="connectionDateString" cssClass="has-errors"
										element="span" />
								</div>
							</div>
							<div class="span4">
								<div class="formGroup">
									<form:label path="*">
										<s:message code="connection.connectionTime" />
										<span class="has-errors star">*</span>
									</form:label>
									<div id="connectionTime" class="input-append time">
										<form:input path="connectionTime" data-format="hh.mm"
											required="true" type="text" id="connectionTime"
											cssClass="form-control"
											cssErrorClass="form-control has-errors" role="aria" />
										<span class="add-on"> <i data-time-icon="icon-time"
											data-date-icon="icon-calendar"> </i>
										</span>

									</div>
									<form:errors path="connectionTime" cssClass="has-errors"
										element="span" />
								</div>
							</div>
							<div class="span4">
								<div class="formGroup">
									<form:label path="*">
										<s:message code="connection.connectionByEmployeeCode" />
										<span class="has-errors star">*</span>
									</form:label>
									<form:select path="connectionByEmployeeCode" required="true"
										cssClass="form-control text-uppercase"
										cssErrorClass="form-control has-errors"
										id="connectionByEmployeeCode">
										<form:option value="${0}" label="--- Select ---" />
										<c:forEach items="${connectionByEmployees}" var="tipS">
											<form:option value="${tipS.codEmp}"
												label="${tipS.ape1Emp} ${tipS.ape2Emp} ${tipS.nomEmp}" />
										</c:forEach>
									</form:select>
									<form:errors path="connectionByEmployeeCode"
										cssClass="has-errors" element="span" />
								</div>
							</div>
						</div>
						<div class="row-fluid" style="margin-top: 20px;">
							<div class="span8">
								<div class="formGroup">
									<form:label path="connectionComment">
										<s:message code="connection.connectionComment" />
										<span class="has-errors star">*</span>
									</form:label>
									<form:textarea path="connectionComment" cssClass="form-control"
										id="connectionComment" placeholder="feedback.."
										required="true" style="width: 80%;" />
								</div>
							</div>
							<div class="span4"></div>
							<div class="span12">
								<hr />
							</div>
						</div>
					</fieldset>
					<div class="row-fluid" style="margin-top: 20px;">
						<div class="span3">
							<a class="btn btn-lg btn-primary"
								href="<c:url value="/employee/connection/pendingconnection?schedule=true"/>"
								role="button"> <s:message code="schedule.inspection.back" /></a>
						</div>
						<div class="span1"></div>
						<div class="span3">
							<form:button class="btn btn-lg btn-primary "
								style="min-width:178px" id="btnSubmit">
								<s:message code="submit.value" />
							</form:button>
						</div>
						<div class="span5"></div>
					</div>

				</form:form>

				<div class="bottom-border">&nbsp;</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript"
	src='<s:url value="/resources/assets/js/bootstrap-datepicker.js"></s:url>'>
    </script>
<script type="text/javascript"
	src='<s:url value="/resources/assets/js/bootstrap-datetimepicker.min.js"></s:url>'>
	
</script>
<script
	src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/jquery.validate.js"></script>
<script
	src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/additional-methods.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	//populate drop down components
	$('#subStation').change(	   
		function() {
			console.log("substation change..");
			$.getJSON('${findSubstationFeedersURL}', {
				subStationCode : $(this).val(),
				ajax : 'true'
			}, function(data) {
				console.log("substation change: returned data: "+data);
				var html = '<option value="">--- Select ---</option>';
				var len = data.length;
				for ( var i = 0; i < len; i++) {
					html += '<option value="' + data[i].id.nroInstalacion + '">'
							+ data[i].nomInstalacion + '</option>';
				}
				html += '</option>';
 
				$('#feeder').html(html);
			});
	});
	
	$('#feeder').change(	   
			function() {
				console.log("feeder change..");
				$.getJSON('${findFeederTransformersURL}', {
					feederCode : $(this).val(),
					ajax : 'true'
				}, function(data) {
					console.log("feeder change: returned data: "+data);
					var html = '<option value="">--- Select ---</option>';
					var len = data.length;
					for ( var i = 0; i < len; i++) {
						html += '<option value="' + data[i].id.nroInstalacion + '">'
								+ data[i].nomInstalacion + '</option>';
					}
					html += '</option>';
	 
					$('#transformer').html(html);
				});
		});
	
	$('#transformer').change(	   
			function() {
				console.log("circuit change..");
				$.getJSON('${findTransformerCircuitsURL}', {
					transformerCode : $(this).val(),
					ajax : 'true'
				}, function(data) {
					console.log("transformer change: returned data: "+data);
					var html = '<option value="">--- Select ---</option>';
					var len = data.length;
					for ( var i = 0; i < len; i++) {
						html += '<option value="' + data[i].id.nroInstalacion + '">'
								+ data[i].nomInstalacion + '</option>';
					}
					html += '</option>';
	 
					$('#imsInstallationCode').html(html);
				});
		});
	
});


	$(function() {
		$('#scheduleapplication').validate({
			errorClass : "has-errors",
			rules : {
				inspectionScheduledDate : {
					required : true
				}
			}
		});
		/* $('#scheduledDatepicker').datetimepicker({
			language : 'pt-BR',
			pickTime : false
		}); */
		
		//date control
		var nowTemp = new Date();
		var now = new Date(nowTemp.getFullYear(), nowTemp.getMonth(), nowTemp.getDate(), 0, 0, 0, 0);
		var checkin = $('#connectionScheduledDate').datepicker({
			  onRender: function(date) {
			    return date.valueOf() < now.valueOf() ? 'disabled' : '';
			  }
			}).on('changeDate', function(ev) {			   
			  checkin.hide(); 
			}).data('datepicker');
		
		$('#connectionTime').datetimepicker({
			pickDate : false,
			pickSeconds : false
		});
		//
		if ($('#scheduleApprove').prop('checked')) {
			$('#applicationcoRejectReason').prop('disabled', true);
			$('#rejectionComment').prop('disabled', true);
		}
		$('#scheduleApprove').click(function() {

			if ($(this).prop('checked')) {

				$('#applicationcoRejectReason').rules("remove");
				$('#applicationcoRejectReason').prop('disabled', true);
				$('#rejectionComment').prop('disabled', true);
				$('#inspectionScheduledDate').prop('disabled', false);
				$('#inspectionScheduledDate').rules("add", {
					required : true
				});
			} else {
				$('#inspectionScheduledDate').rules("remove");
				$('#applicationcoRejectReason').prop('disabled', false);
				$('#rejectionComment').prop('disabled', false);
				$('#inspectionScheduledDate').prop('disabled', true);
				$('#applicationcoRejectReason').rules("add", {
					required : true
				});
			}
		});

		$('#scheduleReject').click(function() {

			if ($(this).prop('checked')) {
				$('#inspectionScheduledDate').rules("remove");
				$('#applicationcoRejectReason').prop('disabled', false);
				$('#rejectionComment').prop('disabled', false);
				$('#inspectionScheduledDate').prop('disabled', true);
				$('#applicationcoRejectReason').rules("add", {
					required : true
				});
			} else {
				$('#applicationcoRejectReason').rules("remove");
				$('#applicationcoRejectReason').prop('disabled', true);
				$('#rejectionComment').prop('disabled', true);
				$('#inspectionScheduledDate').prop('disabled', false);
				$('#inspectionScheduledDate').rules("add", {
					required : true
				});
			}
		});

		function addRules(target, rules) {
			$(target).rules('add', rules);
		}

		function removeRules(target) {
			$(target).rules('remove');
		}
		$("#scheduleapplication").validate()
	});
</script>
