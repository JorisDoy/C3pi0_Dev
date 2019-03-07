<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%-- <script type="text/javascript"
	src='<s:url value="/resources/assets/js/bootstrap-filestyle.min.js"></s:url>'>
	
</script> --%>
<c:set var="readonly" value="${true}" />
<c:if test="${newCustomer == true}">
	<c:set var="readonly" value="${false}" />
</c:if>
<c:if test="${param.edit == true}">
	<c:set var="readonly" value="${false}" />
</c:if>
<input id="readOnly" value="${readonly}" type="hidden" />

<c:set var="docNumber"
	value="${fn:length(application.iopenApplication.iopenApplicationDocs)}" />
<input id="docNumbers" value="${docNumber}" type="hidden" />
<div class="row-fluid">
	<div class="span12 post-page">
		<h3 class="module-title-short">
			<span class="selected">Register New Application *</span>
		</h3>

		<form:form method="POST" commandName="application"
			cssClass="form-horizontal dropzone" id="new-application"
			enctype="multipart/form-data">
			<div class="row-fluid">
				<div class="span12">
					<div class="form-group">
						<form:errors path="*" cssClass="has-errors" element="span" />
						<p class="has-errors">
							<c:out value="${errorInfo.message}"></c:out>
						</p>
					</div>
				</div>
			</div>
			<fieldset>
				<legend>
					<s:message code="application.applicantssection.text" />
				</legend>
				<div class="row-fluid">
					<div class="span4">
						<div class="form-group" style="text-align: center">
							<form:radiobutton path="applicationType" cssClass="form-control"
								checked="checked" cssErrorClass="form-control has-errors"
								id="domestic"
								value='${defaultValues.get("application_domestic_value")}' />
							<br />
							<s:message code="application.domestic.label" />
							<form:errors path="applicationType" cssClass="has-errors"
								element="span" />
						</div>
					</div>
					<div class="span4">
						<div class="form-group" style="text-align: center">
							<form:radiobutton path="applicationType" cssClass="form-control"
								cssErrorClass="form-control has-errors" id="mediumindustrial"
								value='${defaultValues.get("application_mediumindustrial_value")}' />
							<br />
							<s:message code="application.mediumindustrial.label" />
							<form:errors path="applicationType" cssClass="has-errors"
								element="span" />
						</div>
					</div>
					<div class="span4">
						<div class="form-group" style="text-align: center">
							<form:radiobutton path="applicationType" cssClass="form-control"
								cssErrorClass="form-control has-errors" id="tou"
								value='${defaultValues.get("application_tou_value")}' />
							<br />
							<s:message code="application.tou.label" />
							<form:errors path="applicationType" cssClass="has-errors"
								element="span" />
						</div>
					</div>
				</div>
				<hr />
				<div class="row-fluid">
					<div class="span4">
						<div class="form-group" style="text-align: center">
							<form:radiobutton path="applicationType" cssClass="form-control"
								cssErrorClass="form-control has-errors" id="commercial"
								value='${defaultValues.get("application_commercial_value")}' />
							<br />
							<s:message code="application.commercial.label" />
							<form:errors path="applicationType" cssClass="has-errors"
								element="span" />
						</div>
					</div>
					<div class="span4">
						<div class="form-group" style="text-align: center">
							<form:radiobutton path="applicationType" cssClass="form-control"
								cssErrorClass="form-control has-errors" id="largeindustrial"
								value='${defaultValues.get("application_largeindustrial_value") }' />
							<br />
							<s:message code="application.largeindustrial.label" />
							<form:errors path="applicationType" cssClass="has-errors"
								element="span" />
						</div>
					</div>
					<div class="span4">
						<div class="form-group" style="text-align: center">
							<form:radiobutton path="applicationType" cssClass="form-control"
								cssErrorClass="form-control has-errors" id="streetlight"
								value='${ defaultValues.get("application_streetlight_value")}' />
							<br />
							<s:message code="application.streetlight.label" />
							<form:errors path="applicationType" cssClass="has-errors"
								element="span" />
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
				<legend>
					<s:message code="application.applicantsdatasection.text" />
					:
				</legend>
				<div class="row-fluid">
					<div class="span4">
						<div class="form-group">
							<label class="control-label" for="date">Applicant Name</label>
						</div>
					</div>
					<div class="span4">
						<div class="form-group">
							<form:label path="surname" cssErrorClass="has-errors">
								<s:message code="application.surname.label" />
								<span class="has-errors star">*</span>
							</form:label>
							<form:input path="surname" cssClass="form-control text-uppercase"
								cssErrorClass="form-control has-errors" id="surname"
								required="required" placeholder="surname" readonly="${readonly}" />
							<form:errors path="surname" cssClass="has-errors" element="span" />
						</div>
					</div>
					<div class="span4">
						<div class="form-group">
							<form:label path="firstName" cssErrorClass="has-errors">
								<s:message code="application.firstname.label" />
								<span class="has-errors star">*</span>
							</form:label>
							<form:input path="firstName"
								cssClass="form-control text-uppercase"
								cssErrorClass="form-control has-errors" id="firstname"
								required="required" placeholder="firstName"
								readonly="${readonly}" />
							<form:errors path="firstName" cssClass="has-errors"
								element="span" />
						</div>
					</div>
				</div>
				<div class="row-fluid">
					<div class="span4"></div>
					<div class="span4">
						<div class="form-group">
							<form:label path="middleName" cssErrorClass="has-errors">
								<s:message code="application.middlename.label" />
							</form:label>
							<form:input path="middleName"
								cssClass="form-control text-uppercase"
								cssErrorClass="form-control has-errors" id="middlename"
								placeholder="middleName" readonly="${readonly}" />
							<form:errors path="middleName" cssClass="has-errors"
								element="span" />
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
							<label class="control-label" for="date">Identification
								Document</label>
						</div>
					</div>
					<div class="has-errors" hidden="true" id="docTypeMessage">
						<s:message code="application.id.document.value" />
					</div>
					<div class="span2">
						<div class="form-group">
							<form:radiobutton path="documentType" cssClass="form-control"
								cssErrorClass="form-control has-errors" id="documentType_id"
								disabled="${readonly}"
								value='${defaultValues.get("application_idnumber_value")}' style="max-width:30px; margin-left: 0px; padding:0px;"/>
							<s:message code="application.ididentity.label" />
							<form:errors path="documentType" cssClass="has-errors"
								element="span" />
						</div>
					</div>
					<div class="span2">
						<div class="form-group">
							<form:radiobutton path="documentType" cssClass="form-control"
								cssErrorClass="form-control has-errors"
								id="documentType_passport" disabled="${readonly}"
								value='${defaultValues.get("application_passport_value")}' style="max-width:30px; margin-left: 0px; padding:0px;"/>
							<s:message code="application.passportidentity.label" />
							<form:errors path="documentType" cssClass="has-errors"
								element="span" />
						</div>
					</div>


					<div class="span4">
						<div class="form-group">
							<form:label path="idNumber" cssErrorClass="has-errors">
								<s:message code="application.idnumber.label" />
								<span class="has-errors star">*</span>
							</form:label>
							<form:input path="idNumber"
								cssClass="form-control text-uppercase"
								cssErrorClass="form-control has-errors" id="idNumber"
								required="required" placeholder="idNumber"
								readonly="${readonly}" />
							<form:errors path="idNumber" cssClass="has-errors" element="span" />
						</div>
					</div>
				</div>
				<div class="row-fluid">
					<div class="span4">&nbsp;</div>
					<div class="span4">&nbsp;</div>
					<div class="span4">
						<div class="form-group">
							<form:label path="tinNumber" cssErrorClass="has-errors">
								<s:message code="application.tinnumber.label" />
							</form:label>
							<form:input path="tinNumber"
								cssClass="form-control text-uppercase"
								cssErrorClass="form-control has-errors" id="tinNumber"
								placeholder="tinNumber" readonly="${readonly}" />
							<form:errors path="tinNumber" cssClass="has-errors"
								element="span" />
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
							<form:label path="mobileNumber" cssErrorClass="has-errors">
								<s:message code="application.mobilenumber.label" />
								<span class="has-errors star">*</span>
							</form:label>
							<form:input path="mobileNumber"
								cssClass="form-control text-uppercase"
								cssErrorClass="form-control has-errors" id="mobileNumber"
								required="required" placeholder="mobileNumber"
								readonly="${readonly}" />
							<form:errors path="mobileNumber" cssClass="has-errors"
								element="span" />
						</div>
					</div>
					<div class="span4">
						<div class="form-group">
							<form:label path="officeNumber" cssErrorClass="has-errors">
								<s:message code="application.officenumber.label" />
							</form:label>
							<form:input path="officeNumber"
								cssClass="form-control text-uppercase"
								cssErrorClass="form-control has-errors" id="officeNumber"
								placeholder="officeNumber" readonly="${readonly}" />
							<form:errors path="officeNumber" cssClass="has-errors"
								element="span" />
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
							<form:label path="emailAddress" cssErrorClass="has-errors">
								<s:message code="application.emailaddress.label" />
								<span class="has-errors star">*</span>
							</form:label>
							<form:input path="emailAddress" cssClass="form-control "
								cssErrorClass="form-control has-errors" id="emailAddress"
								required="required" placeholder="emailAddress"
								readonly="${readonly}" />
							<form:errors path="emailAddress" cssClass="has-errors"
								element="span" />
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
							<form:radiobutton path="customerContactPerson"
								cssClass="form-control" checked="checked"
								cssErrorClass="form-control has-errors"
								id="customerContactPerson_self" style="max-width:30px; margin-left: 0px; padding:0px; "
								value='${defaultValues.get("application_customercontactperson_self_value")}' />
							<s:message code="application.customercontactperson.self.label" />
							<form:errors path="customerContactPerson" cssClass="has-errors"
								element="span" />
						</div>
					</div>
					<div class="span2">
						<div class="form-group">
							<form:radiobutton path="customerContactPerson" style="max-width:30px; margin-left: 0px; padding:0px; "
								cssClass="form-control" cssErrorClass="form-control has-errors"
								id="customerContactPerson_other"
								value='${defaultValues.get("application_customercontactperson_other_value")}' />
							<s:message code="application.customercontactperson.other.label" />
							<form:errors path="customerContactPerson" cssClass="has-errors"
								element="span" />
						</div>
					</div>
					<div class="span4">
						<div class="form-group">
							<form:label path="contactName" cssErrorClass="has-errors">
								<s:message code="application.contactname.label" />
							</form:label>
							<form:input path="contactName" disabled="true"
								cssClass="form-control text-uppercase"
								cssErrorClass="form-control has-errors" id="contactName"
								placeholder="contactName" />
							<form:errors path="contactName" cssClass="has-errors"
								element="span" />
						</div>
					</div>
				</div>

				<div class="row-fluid">
					<div class="span4">&nbsp;</div>
					<div class="span4">&nbsp;</div>
					<div class="span4">
						<div class="form-group">
							<form:label path="contactNumber" cssErrorClass="has-errors">
								<s:message code="application.contactnumber.label" />
							</form:label>
							<form:input path="contactNumber"
								cssClass="form-control text-uppercase" disabled="true"
								cssErrorClass="form-control has-errors" id="contactNumber"
								placeholder="contactNumber" />
							<form:errors path="contactNumber" cssClass="has-errors"
								element="span" />
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
				<legend>
					<s:message code="application.premisesection.text" />
					:
				</legend>


				<div class="row-fluid">
					<div class="span4">
						<div class="formGroup">
							<form:label path="districtDesc" cssErrorClass="has-errors">
								<s:message code="application.districtDesc.label" />
								<span class="has-errors star">*</span>
							</form:label>
							<form:input path="districtDesc"
								cssClass="form-control text-uppercase"
								cssErrorClass="form-control has-errors" id="districtDesc"
								required="required" placeholder="District" />
							<form:errors path="districtDesc" cssClass="has-errors"
								element="span" />
						</div>
					</div>
					<div class="span4">
						<div class="formGroup">
							<form:label path="townDesc" cssErrorClass="has-errors">
								<s:message code="application.townDesc.label" />
								<span class="has-errors star">*</span>
							</form:label>
							<form:input path="townDesc"
								cssClass="form-control text-uppercase"
								cssErrorClass="form-control has-errors" id="townDesc"
								required="required" placeholder="Town" />
							<form:errors path="townDesc" cssClass="has-errors" element="span" />
						</div>
					</div>
					<div class="span4">
						<div class="formGroup">
							<form:label path="countyDesc" cssErrorClass="has-errors">
								<s:message code="application.countyDesc.label" />
								<span class="has-errors star">*</span>
							</form:label>
							<form:input path="countyDesc"
								cssClass="form-control text-uppercase"
								cssErrorClass="form-control has-errors" id="countyDesc"
								required="required" placeholder="County" />
							<form:errors path="countyDesc" cssClass="has-errors"
								element="span" />
						</div>
					</div>
				</div>
				<div class="row-fluid">
					<div class="span4">
						<div class="formGroup">
							<form:label path="subCountyDesc" cssErrorClass="has-errors">
								<s:message code="application.subCountyDesc.label" />
								<span class="has-errors star">*</span>
							</form:label>
							<form:input path="subCountyDesc"
								cssClass="form-control text-uppercase"
								cssErrorClass="form-control has-errors" id="subCountyDesc"
								required="required" placeholder="Sub-County" />
							<form:errors path="subCountyDesc" cssClass="has-errors"
								element="span" />
						</div>
					</div>
					<div class="span4">
						<div class="formGroup">
							<form:label path="villageDesc" cssErrorClass="has-errors">
								<s:message code="application.village.label" />
								<span class="has-errors star">*</span>
							</form:label>
							<form:input path="villageDesc"
								cssClass="form-control text-uppercase"
								cssErrorClass="form-control has-errors" id="villageDesc"
								required="required" placeholder="Village" />
							<form:errors path="villageDesc" cssClass="has-errors"
								element="span" />
						</div>

					</div>
					<div class="span4">
						<div class="formGroup">
							<form:label path="streetDesc" cssErrorClass="has-errors">
								<s:message code="application.streetDesc.label" />
								<span class="has-errors star">*</span>
							</form:label>
							<form:input path="streetDesc"
								cssClass="form-control text-uppercase"
								cssErrorClass="form-control has-errors" id="streetDesc"
								placeholder="Street" />
							<form:errors path="streetDesc" cssClass="has-errors"
								element="span" />
						</div>
					</div>
				</div>
				<div class="row-fluid">
					<div class="span4">
						<div class="formGroup">
							<form:label path="housePlot" cssErrorClass="has-errors">
								<s:message code="application.house.label" />
								<span class="has-errors star">*</span>

							</form:label>
							<form:input path="housePlot"
								cssClass="form-control text-uppercase"
								cssErrorClass="form-control has-errors" id="housePlot"
								placeholder="House/plot" />
							<form:errors path="housePlot" cssClass="has-errors"
								element="span" />
						</div>

					</div>
					<div class="span8 ">
						<div class="formGroup">
							<form:label path="directionsDesc" cssErrorClass="has-errors">
								<s:message code="application.landmark.label" />
								<span class="has-errors star">*</span>
							</form:label>
							<form:textarea path="directionsDesc" rows="5" cols="70"
								cssClass="form-control text-uppercase"
								cssErrorClass="form-control has-errors" id="directionsDesc"
								required="required" placeholder="directions" style="width:90%;" />
							<form:errors path="directionsDesc" cssClass="has-errors"
								element="span" />
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
				<legend>Wayleaves Approval/ Consent:</legend>
				<div class="row-fluid">
					<div class="span12" style="height: 100px; overflow-y: scroll;">
						WAYLEAVES APPROVAL/ CONSENT <br /> I being the proprietor of
						parcel of land comprised hereby consent to UMEME Limited laying or
						erecting an electric supply line on my side of land and from time
						to time entering upon and having access to my said piece of land
						for the purposes of constructing, laying, maintaining, using,
						removing and replacing the electric supply line. I undertake not
						to interfere or permit any interference with the electric supply
						line nor to construct buildings, plant trees or dump waste
						materials beneath the electric supply line. I also undertake that
						this consent shall be irrevocable.
					</div>
				</div>
				<div class="row-fluid">
					<div class="span12">
						<div class="formGroup">
							<form:checkbox path="agreeWayleaves" cssClass="form-control"
								cssErrorClass="form-control has-errors" id="agreeWayleaves"
								required="required" value="Y" />
							<s:message code="application.agreeWayleaves.label" />
							<span class="has-errors star">*</span>
							<form:errors path="agreeWayleaves" cssClass="has-errors"
								element="span" />
						</div>
					</div>
				</div>
				<hr />
			</fieldset>
			<fieldset>
				<legend>
					Checklist <span class="has-errors star">*</span>
				</legend>
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
					<div id="uploadmsg" class="span12 has-errors" style="display: none">Please
						attach the required documents to complete the application.</div>
					<div id="exceededupload" class="span12 has-errors"
						style="display: none">Please attach a maximum of Five ( 5 )
						Documents, the surplus Documents will not be uploaded</div>

				</div>
				<div class="row-fluid">
					<div class="span12">
						<!--check http://www.dropzonejs.com/#usage for configuration info -->
						<!-- also refer to umeme_bottom_scripts.jsp line 17 for creation of this file-upload div -->
						<div id="dropzoneId"
							class="dz-default dz-message file-dropzone text-center well col-sm-12">
							<span class="glyphicon glyphicon-paperclip"></span> <span>
								To attach files, drag and drop here</span><br> <span>OR</span><br>
							<span>Just Click</span>
						</div>
						<form:errors path="files" cssClass="has-errors" element="span" />

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


			<c:if
				test="${empty(application.iopenApplication.iopenApplicationDocs) == false}">
				<div class="row-fluid">
					<div class="span12" style="overflow: auto">
						<table class="table table-condensed table-hover">
							<thead>
								<tr>
									<!-- <th>ID</th> -->
									<th>Uploaded Documents</th>
									<th>&nbsp;</th>
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
											target="_blank"> view</a></td>
										<td><a
											href="<c:url value="/client/application/new/doc?codApplication=${doc.id.codApplication}&tipDoc=${doc.id.tipDoc}&complete=false"/>">
												remove</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>

			</c:if>

			<fieldset>
				<legend>&nbsp;</legend>

				<div hidden="true">
					<form:input path="actionMethod" id="actionMethod" value="" />
				</div>

				<div hidden="true">
					<form:input path="codApplication" id="codApplication" />
					<%-- <form:input path="documentType" id="documentType"/> --%>
				</div>

				<div class="row-fluid">
					<div class="span1">
						<div class="form-group" hidden="true">
							<form:input path="page" cssClass="form-control text-uppercase"
								cssErrorClass="form-control has-errors" id="page"
								required="required" placeholder="page" readonly="true" />
							<form:errors path="page" cssClass="has-errors" element="span" />
						</div>
					</div>
					<div class="span3 ">
						<form:button type="submit" id="btnSave"
							class="btn btn-lg btn-primary" name="action" value="save"
							style="min-width:178px">
							<s:message code="save.value" />
						</form:button>
					</div>
					<div class="span3">
						<form:button type="submit" id="btnSubmit"
							class="btn btn-lg btn-primary " name="action" value="submit"
							style="min-width:178px">
							<s:message code="submit.value" />
						</form:button>
					</div>
					<div class="span3">
						<form:button type="submit" id="btnCancel"
							class="btn btn-lg btn-primary " name="action" value="cancel"
							style="min-width:178px">
							<s:message code="cancel.value" />
						</form:button>

					</div>
				</div>
			</fieldset>
		</form:form>

		<div class="bottom-border">&nbsp;</div>
	</div>
</div>


<script type='text/javascript'
	src='<s:url value="/resources/assets/js/dropzone.js"></s:url>'></script>

<script
	src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/jquery.validate.js"></script>
<script
	src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/additional-methods.js"></script>
<script>
	//SMA 20160316
	var myDropzone;
	var uploadToC = false;
	var docSize = $("#docNumbers").val()
	console.log("gol1");
	console.log(docSize);
	$(document)
			.ready(
					function() {

						//populate drop down components
						$('#district')
								.change(
										function() {
											console.log("district change..");
											$
													.getJSON(
															'${findDistrictVillagesURL}',
															{
																codMunic : $(
																		this)
																		.val(),
																ajax : 'true'
															},
															function(data) {
																console
																		.log("district change: returned data: "
																				+ data);
																var html = '<option value="">--- Select ---</option>';
																var len = data.length;
																for (var i = 0; i < len; i++) {
																	html += '<option value="' + data[i].codLocal + '">'
																			+ data[i].nomLocal
																			+ '</option>';
																}
																html += '</option>';

																$('#village')
																		.html(
																				html);
															});
										});
						$('#village')
								.change(
										function() {
											$
													.getJSON(
															'${findVillageLocalitiesURL}',
															{
																codLocal : $(
																		this)
																		.val(),
																ajax : 'true'
															},
															function(data) {
																var html = '<option value="">--- Select ---</option>';
																var len = data.length;
																for (var i = 0; i < len; i++) {
																	html += '<option value="' + data[i].codLocal + '">'
																			+ data[i].nomLocal
																			+ '</option>';
																}
																html += '</option>';

																$('#locality')
																		.html(
																				html);
															});
										});
						$('#locality')
								.change(
										function() {
											$
													.getJSON(
															'${findLocalityStreetsURL}',
															{
																codLocal : $(
																		this)
																		.val(),
																ajax : 'true'
															},
															function(data) {
																var html = '<option value="">--- Select ---</option>';
																var len = data.length;
																for (var i = 0; i < len; i++) {
																	html += '<option value="' + data[i].codCalle + '">'
																			+ data[i].nomCalle
																			+ '</option>';
																}
																html += '</option>';

																$('#street')
																		.html(
																				html);
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
						//jquery validator plugin declarations 

						if (!$("#readOnly").val()) {
							$('#new-application').validate({
								errorClass : "has-errors",
								rules : {
									surname : {
										required : true,
										maxlength : 50
									},
									firstName : {
										required : true,
										maxlength : 50
									},
									idNumber : {
										required : true,
										minlength : 2
									},
									mobileNumber : {
										required : true,
										minlength : 10,
										maxlength : 12
									},
									emailAddress : {
										required : true,
										email : true
									}
								}
							});

						}
						$('#new-application').validate({
							errorClass : "has-errors",
							rules : {
								agreeTermsConditions : {
									required : true
								},
								agreeWayleaves : {
									required : true
								},
								townDesc : {
									required : true
								},
								countyDesc : {
									required : true
								},
								subCountyDesc : {
									required : true
								},
								directionsDesc : {
									required : true
								}
							}
						});

						if ($('#customerContactPerson_self').prop('checked')) {
							$('#contactName').prop('disabled', true);
							$('#contactNumber').prop('disabled', true);
						}
						$('#customerContactPerson_self').click(function() {
							if ($(this).prop('checked')) {
								removeRules('#contactName');
								removeRules('#contactNumber');
								$('#contactName').prop('disabled', true);
								$('#contactNumber').prop('disabled', true);
							} else {
								$('#contactName').prop('disabled', false);
								$('#contactNumber').prop('disabled', false);
								addRules('#contactName', {
									required : true
								});
								addRules('#contactNumber', {
									required : true,
									minlength : 10,
									maxlength : 12
								});
							}
						});
						$('#customerContactPerson_other').click(function() {
							if ($(this).prop('checked')) {

								$('#contactName').prop('disabled', false);
								$('#contactNumber').prop('disabled', false);
								addRules('#contactName', {
									required : true
								});
								addRules('#contactNumber', {
									required : true,
									minlength : 10,
									maxlength : 12
								});
							} else {
								$('#contactName').prop('disabled', true);
								$('#contactNumber').prop('disabled', true);
								removeRules('#contactName');
								removeRules('#contactNumber');
							}
						});

						function addRules(target, rules) {
							$(target).rules('add', rules);
						}

						function removeRules(target) {
							$(target).rules('remove');
						}

						Dropzone.options.newApplication = { // The camelized version of the ID of the form element

							// The configuration we've talked about above
							autoProcessQueue : false,
							uploadMultiple : true,
							addRemoveLinks : true,
							maxFiles : 5,
							parallelUploads : 5,
							previewsContainer : ".dropzone-previews",

							// The setting up of the dropzone
							init : function() {
								//SMA 20160316
								myDropzone = this;
								myDropzone.removeAllFiles();
								/* document.getElementById('ToCmessage')
								.setAttribute('hidden','true'); */
								// First change the button to actually tell Dropzone to process the queue.
								//this.element.querySelector("button[type=submit]").addEventListener("click", function(e) {
								this.element
										.querySelector("#btnSave")
										.addEventListener(
												"click",
												function(e) {
													// Make sure that the form isn't actually being sent.
													e.preventDefault();
													e.stopPropagation();
													$("#actionMethod").val(
															"save");
													/* if ($('#new-application').valid()) { */
													if (myDropzone
															.getQueuedFiles().length > 0) {
														$("#uploadmsg").hide();
														$("#exceededupload")
																.hide();
														myDropzone
																.processQueue();
													} else {
														/* $("#uploadmsg").show(); */
														$("#new-application")[0]
																.submit();
													}
													/* } */
													//myDropzone.processQueue();
												});

								this.element
										.querySelector("#btnSubmit")
										.addEventListener(
												"click",
												function(e) {
													// Make sure that the form isn't actually being sent.
													e.preventDefault();
													e.stopPropagation();
													$("#actionMethod").val(
															"submit");
													if ((document
															.getElementById('documentType_id').checked || document
															.getElementById('documentType_passport').checked)
															|| $("#readOnly")
																	.val()) {

														document
																.getElementById(
																		'docTypeMessage')
																.setAttribute(
																		"hidden",
																		"true");
														if ($(
																'#new-application')
																.valid()) {
															if (myDropzone
																	.getQueuedFiles().length > 0) {
																if ((myDropzone
																		.getQueuedFiles().length + docSize) > 4
																		&& (myDropzone
																				.getQueuedFiles().length + docSize) < 5) {
																	$(
																			"#uploadmsg")
																			.show();
																} else {
																	$(
																			"#uploadmsg")
																			.hide();
																	$(
																			"#exceededupload")
																			.hide();
																	myDropzone
																			.processQueue();
																}
															} else {
																//$("#uploadmsg").show();
																if ((myDropzone
																		.getQueuedFiles().length + docSize) > 4
																		&& (myDropzone
																				.getQueuedFiles().length + docSize) < 5) {
																	$(
																			"#uploadmsg")
																			.show();
																} else {
																	$("#new-application")[0]
																			.submit();
																}
															}
														}
													} else {
														document
																.getElementById(
																		'docTypeMessage')
																.removeAttribute(
																		"hidden");

													}
													//myDropzone.processQueue();
												});

								this.element.querySelector("#btnCancel")
										.addEventListener("click", function(e) {
											$("#actionMethod").val("cancel");
											$("#new-application")[0].submit();
										});

								//SMA 20160316 start
								this
										.on(
												"addedfile",
												function(file) {
													if (uploadToC) {
														document
																.getElementById(
																		'ToCmessage')
																.removeAttribute(
																		"hidden");
													}
													if (myDropzone
															.getQueuedFiles().length > 5) {
														$("#exceededupload")
																.show();
													}
												});
								this
										.on(
												"removedfile",
												function(file) {
													if (myDropzone
															.getQueuedFiles().length == 0) {
														uploadToC = false;
														document
																.getElementById(
																		'ToCmessage')
																.setAttribute(
																		"hidden",
																		"true");
													}
												});
								//SMA 20160316 end
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
									//myDropzone.removeAllFiles();
									var newDoc = document.open("text/html",
											"replace");
									newDoc.write(response);
									newDoc.close();
								});
								this.on("errormultiple", function(files,
										response) {
									// Gets triggered when there was an error sending the files.
									// Maybe show form again, and notify user of error
									//myDropzone.removeAllFiles();
									/*                 newDoc.write(response);
									 newDoc.close(); */
									$("#exceededupload").show();
								});

								this.on("maxfilesexceeded", function(file) {
									//this.removeAllFiles();
									//this.addFile(file);
								});
							}

						}

					});
	/* document.getElementById('get_file').onclick = function() {
		//document.getElementById('my_file').click();
		document.getElementById('dropzoneId').click();
		uploadToC = true;
	}; */
</script>
