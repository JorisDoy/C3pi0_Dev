<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<div id="main" class="post-template" style="padding-top : 0;">
	<div class="container">
		<div class="row-fluid">
			<div class="span12 post-page"> 
					<h3 class="module-title-short">
						<span class="selected"><s:message code="myprofile.title" /></span>
					</h3>
				<form:form method="POST" commandName="profile" cssClass=" register"
					acceptCharset="ISO-8859-1"  style="padding:5px;">
					<form:errors path="*" element="div" cssClass="formGroup has-errors" />
					<p class="has-errors">
						<c:out value="${errorInfo.message}"></c:out>
					</p>
					<fieldset>
						<legend><s:message code="myprofile.fieldset.personaldetails" /></legend>
					<div class="row-fluid">
						<div class="span3">
							<div class="formGroup">
								<form:label path="surname" cssErrorClass="has-errors">
									<s:message code="myprofile.surname.label" />
								</form:label>
								<form:input path="surname" cssClass="form-control"
									cssErrorClass="form-control has-errors" id="surname"
									type="text" required="required" placeholder="surname..." />
								<form:errors path="surname" cssClass="has-errors" element="span" />

							</div>
						</div>
						<div class="span3">
							<div class="formGroup">
								<form:label path="firstName" cssErrorClass="has-errors">
									<s:message code="myprofile.firstname.label" />
								</form:label>
								<form:input path="firstName" cssClass="form-control"
									cssErrorClass="form-control has-errors" id="firstName"
									type="text" required="required" placeholder="firstName..." />
								<form:errors path="firstName" cssClass="has-errors"
									element="span" />

							</div>
						</div>
						<div class="span3">
							<div class="formGroup">
								<form:label path="middleName" cssErrorClass="has-errors">
									<s:message code="myprofile.middlename.label" />
								</form:label>
								<form:input path="middleName" cssClass="form-control"
									cssErrorClass="form-control has-errors" id="middleName"
									type="text" required="required" placeholder="middleName..." />
								<form:errors path="middleName" cssClass="has-errors"
									element="span" />

							</div>
						</div>
						 
					</div>
					<div class="row-fluid">
						<div class="span3">
							<div class="formGroup">
								<form:label path="idType" cssErrorClass="has-errors">
									<s:message code="myprofile.idtype.label" />
									<span class="has-errors star">*</span>
								</form:label>
								<form:select path="idType"
									cssClass="form-control text-uppercase"
									cssErrorClass="form-control has-errors" disabled="true" id="idType"
									required="required" placeholder="id Type..">
									<form:option value="" label="--- Select ---" />
									<c:forEach items="${idTypes}" var="idType">
										<form:option value="${idType.tipo}" label="${idType.descTipo}" />
									</c:forEach>
								</form:select>

								<form:errors path="idType" cssClass="has-errors" element="span" />
							</div>
						</div>
						<div class="span3">
							<div class="formGroup">
								<form:label path="idNumber" cssErrorClass="has-errors">
									<s:message code="myprofile.idnumber.label" />
									<span class="has-errors star">*</span>
								</form:label>
								<form:input path="idNumber" cssClass="form-control"
									readonly="true" cssErrorClass="form-control has-errors" id="idNumber"
									type="text" required="required" placeholder="id number..." />

								<form:errors path="idNumber" cssClass="has-errors"
									element="span" />
							</div>

						</div>
						<div class="span3"></div>
					</div>
					<div class="row-fluid">
						<div class="span3">
							<div class="formGroup">
								<form:label path="emailAddress" cssErrorClass="has-errors">
									<s:message code="myprofile.emailaddress.label" />
								</form:label>
								<form:input path="emailAddress" cssClass="form-control"
									cssErrorClass="form-control has-errors" id="emailAddress"
									type="text" required="required" placeholder="email..." />
								<form:errors path="emailAddress" cssClass="has-errors"
									element="span" />
							</div>
						</div>
						<div class="span3">
							<div class="formGroup">
								<form:label path="mobileNumber" cssErrorClass="has-errors">
									<s:message code="myprofile.mobiletelnumber.label" />
								</form:label>
								<form:input path="mobileNumber" cssClass="form-control"
									cssErrorClass="form-control has-errors" id="phoneNumber"
									type="text" required="required" placeholder="phone number..." />
								<form:errors path="mobileNumber" cssClass="has-errors"
									element="span" />
							</div>
						</div>
						<div class="span3">
							<div class="formGroup">
								<form:label path="officeNumber" cssErrorClass="has-errors">
									<s:message code="myprofile.officetelnumber.label" />
								</form:label>
								<form:input path="officeNumber" cssClass="form-control"
									cssErrorClass="form-control has-errors" id="officeNumber"
									type="text" required="required" placeholder="office Number..." />
								<form:errors path="officeNumber" cssClass="has-errors"
									element="span" />
							</div>
						</div>
					</div>
					</fieldset>
					<fieldset>
						<legend><s:message code="myprofile.fieldset.contactpersondetails" /></legend>
					<div class="row-fluid">
						<div class="span3">
							<div class="formGroup">
								<form:label path="contactPerson.name" cssErrorClass="has-errors">
									<s:message code="myprofile.contactpersonname.label" />
								</form:label>
								<form:input path="contactPerson.name" cssClass="form-control"
									cssErrorClass="form-control has-errors" type="text"
									id="contactpersonname" required="required"
									placeholder="contact person name ..." />
								<form:errors path="contactPerson.name" cssClass="has-errors"
									element="span" />
							</div>
						</div>
						<div class="span3">
							<div class="formGroup">
								<form:label path="contactPerson.phoneNumber"
									cssErrorClass="has-errors">
									<s:message code="myprofile.contactpersonphoneno.label" />
								</form:label>
								<form:input path="contactPerson.phoneNumber"
									cssClass="form-control" cssErrorClass="form-control has-errors"
									id="phoneNumber" type="text" required="required"
									placeholder="contact person phoneno ..." />
								<form:errors path="contactPerson.phoneNumber"
									cssClass="has-errors" element="span" />
							</div>
						</div>
					
					</div>
					</fieldset>
					<fieldset>
						<legend><s:message code="myprofile.fieldset.premisedetails" /></legend>
					<div class="row-fluid">
						<div class="span3">
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
										cssClass="form-control text-uppercase"
										cssErrorClass="form-control has-errors" id="district"
										required="required" placeholder="district">
										<form:option value="0" label="--- Select ---" />
										<c:forEach items="${districts}" var="district">
											<form:option value="${district.codMunic}"
												label="${district.nomMunic}" />
										</c:forEach>
									</form:select>
								<form:errors path="premiseInformation.district"
									cssClass="has-errors" element="span" />
							</div>
						</div>
						<div class="span3">
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
										cssClass="form-control text-uppercase"
										cssErrorClass="form-control has-errors" id="village"
										required="required" placeholder="village">
										<form:option value="0" label="--- Select ---" />
										<c:forEach items="${village}" var="village">
											<form:option value="${village.codLocal}"
												label="${village.nomLocal}" />
										</c:forEach>
									</form:select>
								<form:errors path="premiseInformation.village"
									cssClass="has-errors" element="span" />
							</div>
						</div>
						<div class="span3">
								<div class="formGroup">
									<form:label path="premiseInformation.locality"
										cssErrorClass="has-errors">
										<s:message code="myprofile.locality.label" />
										<%-- <span class="has-errors star">*</span> --%>
									</form:label>
									<form:select path="premiseInformation.locality"
										cssClass="form-control text-uppercase"
										cssErrorClass="form-control has-errors" id="locality"
										required="required">
										<form:option value="0" label="--- None ---" />
										<c:forEach items="${localities}" var="locality">
											<form:option value="${locality.codLocal}"
												label="${locality.nomLocal}" />
										</c:forEach>
									</form:select>

									<form:errors path="premiseInformation.locality"
										cssClass="has-errors" element="span" />
								</div>
							</div>
							
											</div>
					<div class="row-fluid">
					<div class="span3">
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
										cssClass="form-control text-uppercase"
										cssErrorClass="form-control has-errors" id="street"
										required="required" placeholder="street">
										<form:option value="0" label="--- Select ---" />
										<c:forEach items="${streets}" var="street">
											<form:option value="${street.codCalle}"
												label="${street.nomCalle}" />
										</c:forEach>
									</form:select>
								<form:errors path="premiseInformation.street"
									cssClass="has-errors" element="span" />
							</div>
						</div>
						<div class="span3">
							<div class="formGroup">
								<form:label path="premiseInformation.housePlotNumber"
									cssErrorClass="has-errors">
									<s:message code="myprofile.houseplotno.label" />
								</form:label>
								<form:input path="premiseInformation.housePlotNumber"
									cssClass="form-control" cssErrorClass="form-control has-errors"
									id="houseplotno" type="text" required="required"
									placeholder="houseplotno ..." />
								<form:errors path="premiseInformation.housePlotNumber"
									cssClass="has-errors" element="span" />
							</div>
						</div>
						<div class="span3">
							<div class="formGroup">
								<form:label path="premiseInformation.landmark"
									cssErrorClass="has-errors">
									<s:message code="myprofile.landmark.label" />
								</form:label>
								<form:input path="premiseInformation.landmark"
									cssClass="form-control" cssErrorClass="form-control has-errors"
									id="landmark" type="text" required="required"
									placeholder="landmark ..." />
								<form:errors path="premiseInformation.landmark"
									cssClass="has-errors" element="span" />
							</div>
						</div>
					</div>
					</fieldset>
					<div class="row-fluid">
						<div class="span3"></div>
						<div class="span3"></div>
						<div class="span3"></div>
					</div>

					<div class="row-fluid"> 
						<div class="span3"></div>
						<div class="span3">
							<button class="btn btn-lg btn-primary btn-block" type="submit">
								<s:message code="submit.value" />
							</button>
						</div>
						<div class="span3"></div>
					</div>



				</form:form>
				<div class="bottom-border">&nbsp;</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
$(document).ready(function() {
	
	  
});

</script>