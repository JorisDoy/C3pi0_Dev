<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>

<div class="row-fluid">
	<div class="span12 post-page">
		<h3 class="module-title-short">
			<span class="selected">Register New Application</span>
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
				<legend>
					<s:message code="application.applicantssection.text" />
				</legend>
				<div class="row-fluid">
					<div class="span4">
						<div class="form-group">
							<form:radiobutton path="applicationType" cssClass="form-control"
								checked="checked" cssErrorClass="form-control has-errors"
								id="applicationType_domestic"
								value='${defaultValues.get("application_domestic_value")}' />
							<s:message code="application.domestic.label" />
							<form:errors path="applicationType" cssClass="has-errors"
								element="span" />
						</div>
					</div>
					<div class="span4">
						<div class="formGroup">
							<form:radiobutton path="applicationType" cssClass="form-control"
								cssErrorClass="form-control has-errors"
								id="applicationType_mediumindustrial"
								value='${defaultValues.get("application_mediumindustrial_value")}' />
							<s:message code="application.mediumindustrial.label" />
							<form:errors path="applicationType" cssClass="has-errors"
								element="span" />
						</div>
					</div>
					<div class="span4">
						<div class="form-group">
							<form:radiobutton path="applicationType" cssClass="form-control"
								cssErrorClass="form-control has-errors" id="applicationType_tou"
								value='${defaultValues.get("application_tou_value")}' />
							<s:message code="application.tou.label" />
							<form:errors path="applicationType" cssClass="has-errors"
								element="span" />
						</div>
					</div>
				</div>
				<hr />
				<div class="row-fluid">
					<div class="span4">
						<div class="form-group">
							<form:radiobutton path="applicationType" cssClass="form-control"
								cssErrorClass="form-control has-errors"
								id="applicationType_commercial"
								value='${defaultValues.get("application_commercial_value")}' />
							<s:message code="application.commercial.label" />
							<form:errors path="applicationType" cssClass="has-errors"
								element="span" />
						</div>
					</div>
					<div class="span4">
						<div class="form-group">
							<form:radiobutton path="applicationType" cssClass="form-control"
								cssErrorClass="form-control has-errors"
								id="applicationType_largeindustrial"
								value='${defaultValues.get("application_largeindustrial_value") }' />
							<s:message code="application.largeindustrial.label" />
							<form:errors path="applicationType" cssClass="has-errors"
								element="span" />
						</div>
					</div>
					<div class="span4">
						<div class="form-group">
							<form:radiobutton path="applicationType" cssClass="form-control"
								cssErrorClass="form-control has-errors"
								id="applicationType_streetlight"
								value='${ defaultValues.get("application_streetlight_value")}' />
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
					<div class="span6">
						<div class="form-group">
							<h4>Applicant Name</h4>
						</div>
					</div>
				</div>
				<div class="row-fluid">
					<div class="span4">
						<div class="form-group">
							<form:label path="surname" cssErrorClass="has-errors">
								<s:message code="application.surname.label" />
								<span class="has-errors star">*</span>
							</form:label>
							<form:input path="surname" cssClass="form-control text-uppercase"
								cssErrorClass="form-control has-errors" id="surname"
								placeholder="surname" />
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
								cssErrorClass="form-control has-errors" id="firstName"
								placeholder="firstName" />
							<form:errors path="firstName" cssClass="has-errors"
								element="span" />
						</div>
					</div>
					<div class="span4">
						<div class="form-group">
							<form:label path="middleName" cssErrorClass="has-errors">
								<s:message code="application.middlename.label" />
							</form:label>
							<form:input path="middleName"
								cssClass="form-control text-uppercase"
								cssErrorClass="form-control has-errors" id="middlename"
								placeholder="middleName" />
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
					<div class="span12">
						<div class="form-group">
							<h4>Identification Document</h4>
						</div>
					</div>
				</div>
				<div class="row-fluid">
					<div class="span2">
						<div class="form-group">
							<form:radiobutton path="documentType" checked="checked"
								cssClass="form-control" cssErrorClass="form-control has-errors"
								id="documentType_id"
								value='${defaultValues.get("application_idnumber_value")}' />
							<s:message code="application.ididentity.label" />
							<form:errors path="documentType" cssClass="has-errors"
								element="span" />
						</div>
					</div>
					<div class="span2">
						<div class="form-group">
							<form:radiobutton path="documentType" cssClass="form-control"
								cssErrorClass="form-control has-errors"
								id="documentType_passport"
								value='${defaultValues.get("application_passport_value")}' />
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
								placeholder="idNumber" />
							<form:errors path="idNumber" cssClass="has-errors" element="span" />
						</div>
					</div>
					<div class="span4">
						<div class="form-group">
							<form:label path="tinNumber" cssErrorClass="has-errors">
								<s:message code="application.tinnumber.label" />
							</form:label>
							<form:input path="tinNumber"
								cssClass="form-control text-uppercase"
								cssErrorClass="form-control has-errors" id="tinNumber"
								placeholder="tinNumber" />
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
					<div class="span12">
						<div class="form-group">
							<h4>Customer Contact</h4>
						</div>
					</div>
				</div>
				<div class="row-fluid">
					<div class="span4">
						<div class="form-group">
							<form:label path="mobileNumber" cssErrorClass="has-errors">
								<s:message code="application.mobilenumber.label" />
								<span class="has-errors star">*</span>
							</form:label>
							<form:input path="mobileNumber"
								cssClass="form-control text-uppercase"
								cssErrorClass="form-control has-errors" id="mobileNumber"
								placeholder="mobileNumber" />
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
								placeholder="officeNumber" />
							<form:errors path="officeNumber" cssClass="has-errors"
								element="span" />
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
					<div class="span3">
						<div class="form-group">
							<h4>Customer's Email</h4>
						</div>
					</div>
				</div>
				<div class="row-fluid">
					<div class="span4">
						<div class="form-group">
							<form:label path="emailAddress" cssErrorClass="has-errors">
								<s:message code="application.emailaddress.label" />
								<span class="has-errors star">*</span>
							</form:label>
							<form:input path="emailAddress" cssClass="form-control"
								cssErrorClass="form-control has-errors" id="emailAddress"
								placeholder="emailAddress" />
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
					<div class="span12">
						<div class="form-group">
							<h4>Customer Contact Person</h4>
						</div>
					</div>
				</div>
				<div class="row-fluid">
					<div class="span2">
						<div class="form-group">
							<form:radiobutton path="customerContactPerson"
								cssClass="form-control" checked="checked"
								cssErrorClass="form-control has-errors"
								id="customerContactPerson_self"
								value='${defaultValues.get("application_customercontactperson_self_value")}' />
							<s:message code="application.customercontactperson.self.label" />
							<form:errors path="customerContactPerson" cssClass="has-errors"
								element="span" />
						</div>
					</div>
					<div class="span2">
						<div class="form-group">
							<form:radiobutton path="customerContactPerson"
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
							<form:input path="contactName"
								cssClass="form-control text-uppercase"
								cssErrorClass="form-control has-errors" id="contactName"
								placeholder="contactName" />
							<form:errors path="contactName" cssClass="has-errors"
								element="span" />
						</div>
					</div>
					<div class="span4">
						<div class="form-group">
							<form:label path="contactNumber" cssErrorClass="has-errors">
								<s:message code="application.contactnumber.label" />
							</form:label>
							<form:input path="contactNumber"
								cssClass="form-control text-uppercase"
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
				<legend>Wayleaves Approval/ Consent</legend>
				<div class="row-fluid">
					<div class="span12" style="height: 100px; overflow-y: scroll;">
						I being the proprietor of parcel of land comprised hereby consent
						to UMEME Limited laying or erecting an electric supply line on my
						side of land and from time to time entering upon and having access
						to my said piece of land for the purposes of constructing, laying,
						maintaining, using, removing and replacing the electric supply
						line. I undertake not to interfere or permit any interference with
						the electric supply line nor to construct buildings, plant trees
						or dump waste materials beneath the electric supply line. I also
						undertake that this consent shall be irrevocable.</div>
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
								required="required" placeholder="districtDesc" />
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
								required="required" placeholder="townDesc" />
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
								required="required" placeholder="countyDesc" />
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
								required="required" placeholder="SubCounty" />
							<form:errors path="subCountyDesc" cssClass="has-errors"
								element="span" />
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
								required="required" placeholder="Village" />
							<form:errors path="iopenApplication.villageDesc"
								cssClass="has-errors" element="span" />
						</div>

					</div>
					<div class="span4">
						<div class="formGroup">
							<form:label path="iopenApplication.streetDesc"
								cssErrorClass="has-errors">
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
								required="required" placeholder="directions" style="width:90%;" />
							<form:errors path="iopenApplication.directionsDesc"
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
					<div id="uploadmsg" class="span12 has-errors" style="display: none">Please
						attach the required documents to complete the application.</div>
					<!--SMA 20160315 -->
<div id="exceededupload" class="span12 has-errors"
						style="display: none">Please attach a maximum of Five ( 5 )
						Documents</div>
				</div>
				<div class="row-fluid">
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
			<%-- <fieldset>
						<legend>iOpen credentials:</legend>
						<div class="row-fluid">
							<div class="span4">
								<div class="formGroup">
									<form:label path="email" cssErrorClass="has-errors">
										<s:message code="application.email.label" />
									</form:label>
									<form:input path="email" cssClass="form-control"
										cssErrorClass="form-control has-errors" id="email"
										type="email" 
										placeholder="email address ..." />
									<form:errors path="email" cssClass="has-errors" element="span" />
								</div>
							</div>
							<div class="span4">
								<div class="formGroup">
									<form:label path="password" cssErrorClass="has-errors">
										<s:message code="application.password.label" />
									</form:label>
									<form:input path="password" cssClass="form-control"
										cssErrorClass="form-control has-errors" id="password"
										type="password"  placeholder="password ..." />
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
										cssErrorClass="form-control has-errors" id="confirmPassword"
										type="password"  placeholder="password ..." />
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
			<c:if
				test="${empty(application.iopenApplication.iopenApplicationDocs) == false}">
				<div class="row-fluid">
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
			<%-- <div class="row-fluid">
							<div class="span12" style="overflow: auto">
								<table class="table table-condensed table-hover">
									<thead>
										<tr>
											<!-- <th>ID</th> -->
											<th>Uploaded Documents</th> 
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${application.iopenApplication.iopenApplicationDocs}" var="doc">
											<tr class="active">
												
												<td>${doc.docDesc}</td>
												
												<td><a class="fancybox ${doc.contentClass}" data-fancybox-type="iframe" href="<c:url value="/client/download?codApplication=${doc.id.codApplication}&tipDoc=${doc.id.tipDoc}"/>" target="_blank"> view</a></td>
											</tr>
										</c:forEach> 
									</tbody>
								</table>
							</div>
						</div> --%>
			<fieldset>
				<legend>Terms and Conditions:</legend>
				<div class="row-fluid">
					<div class="span12" style="height: 260px; overflow-y: scroll;">
						<!-- GENERAL CONDITIONS OF SUPPLY <br /> 1. Determination of
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
								with the applicable tariff in force at the time of usage. -->
						<s:message code="termsNConditions.title.value" />
						<br />
						<s:message code="termsNConditions.term1.value" />
						<br />
						<s:message code="termsNConditions.term2.value" />
						<br />
						<s:message code="termsNConditions.term3.value" />
						<br />
						<s:message code="termsNConditions.term4.value" />
						<br />
						<s:message code="termsNConditions.term5.value" />
						<br />
						<s:message code="termsNConditions.term6.value" />
						<br />
						<s:message code="termsNConditions.term7.value" />
						<br />
						<s:message code="termsNConditions.term8.value" />
						<br />
						<s:message code="termsNConditions.term9.value" />
						<br />
						<s:message code="termsNConditions.term10.value" />
						<br />
						<s:message code="termsNConditions.term11.value" />
						<br />
						<s:message code="termsNConditions.term12.value" />
						<br />
						<s:message code="termsNConditions.term13.value" />
						<br />
						<s:message code="termsNConditions.confirmation.value" />
						<br />

					</div>
				</div>
				<div class="row-fluid">
					<div class="span12">
						<div class="formGroup">
							<form:checkbox path="agreeTermsConditions"
								cssClass="form-control" cssErrorClass="form-control has-errors"
								id="agreeTermsConditions" value="Y" />
							<s:message code="application.terms.label" />
							<span class="has-errors star">*</span>
							<form:errors path="agreeTermsConditions" cssClass="has-errors"
								element="span" />
							<form:label path="agreeTermsConditions"
								cssErrorClass="has-errors">

							</form:label>
						</div>
					</div>
				</div>
				<div class="row-fluid">
					<div class="span12">
						<b><s:message code="termsNConditions.download.value" /></b>
					</div>
				</div>
				<div class="row-fluid">
					<div class="span4">
						<br />
						<%-- <form method="POST" 
							enctype="multipart/form-data">
							<strong>Upload Terms and Condition File:</strong> <input type="file" name="tac" />
						</form> --%>
						<input type="button" style="min-width:178px" class="btn btn-lg btn-primary "
							onclick="window.open('<c:url value="/client/application/print"/>');"
							value="download" />
						<%-- 	<a class="fancybox" data-fancybox-type="iframe"
							href="<c:url value="/client/application/print"/>" target="_blank">
							download</a> --%>
					</div>
					<div class="span5">
						<br />
						<form:input path="files" style="min-width:178px" type="button" id="get_file"
							value="Upload Signed Copy" class="btn btn-lg btn-primary " />
						<div hidden="true">
							<form:input path="files" type="file" id="my_file" />
						</div>
					</div>

				</div>
			</fieldset>
			<fieldset>
				<legend>&nbsp;</legend>


				<div hidden="true">
					<form:input path="actionMethod" id="actionMethod" value="" />
				</div>

				<div hidden="true">
					<form:input path="codApplication" id="codApplication" />
				</div>

				<div class="row-fluid">
					<div class="span1" hidden="true">
						<div class="form-group" hidden="true">
							<form:input path="page" cssClass="form-control text-uppercase"
								cssErrorClass="form-control has-errors" id="page"
								required="required" placeholder="page" readonly="true" />
							<form:errors path="page" cssClass="has-errors" element="span" />
						</div>
					</div>
					<div class="span3 ">
						<form:button type="submit" id="btnSave"
							class="btn btn-lg btn-primary" name="method" value="save"
							style="min-width:178px">
							<s:message code="save.value" />

						</form:button>
					</div>
					<div class="span3">
						<form:button type="submit" id="btnSubmit"
							class="btn btn-lg btn-primary " name="method" value="submit"
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
						<%-- <a href="<c:url value="/client/application/steps"/>" role="button" class="btn btn-lg btn-primary " style="min-width:178px">
						 <s:message code="cancel.value" />
					</a> --%>

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
									maxlength : 14
								},
								emailAddress : {
									required : true,
									email : true
								},
								password : {
									required : true,
									minlength : 8
								},
								confirmPassword : {
									required : true,
									minlength : 5,
									equalTo : "#password"
								},
								email : {
									required : true,
									email : true
								},
								agreeTermsConditions : {
									required : true
								},
								agreeWayleaves : {
									required : true
								},
								districtDesc : {
									required : true
								},
								villageDesc : {
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
									maxlength : 14
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
									maxlength : 14
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

						//dropzone declarations
						Dropzone.options.newApplication = { // The camelized version of the ID of the form element

							// The configuration we've talked about above
							autoProcessQueue : false,
							uploadMultiple : true,
							addRemoveLinks : true,
							maxFiles : 5,
							parallelUploads : 5,
							previewsContainer : ".dropzone-previews",
							acceptedFiles: ".jpeg,.jpg,.png,.gif,.pdf",

							// The setting up of the dropzone
							init : function() {
								var myDropzone = this;
								myDropzone.removeAllFiles();

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
													if ($('#new-application')
															.valid()) {
														if (myDropzone
																.getQueuedFiles().length > 0) {
															$("#uploadmsg")
																	.hide();
															$("#exceededupload")
																	.hide();
															myDropzone
																	.processQueue();
														} else {
															$("#new-application")[0]
																	.submit();
														}
													}
													//myDropzone.processQueue();
												});

								this.element.querySelector("#btnCancel")
										.addEventListener("click", function(e) {
											$("#actionMethod").val("cancel");
											$("#new-application")[0].submit();
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
									//myDropzone.removeAllFiles();
									/* var newDoc = document.open("text/html", "replace");
									newDoc.write(response);
									newDoc.close(); */
									$("#exceededupload").show();
								});
							}

						}
					});

	
</script>
