<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!-- <div id="main" class="post-template" style="padding-top : 0;">
	<div class="container"> -->
		<div class="row-fluid">
			<div class="span12 post-page">
					<h3 class="module-title-short">
						<span class="selected"><s:message
								code="complaint.view.title" /></span>
					</h3>
				<form:form method="POST" commandName="complaintForm"
					cssClass=" register" acceptCharset="ISO-8859-1"
					style="padding:5px;">
					<form:errors path="*" element="div" cssClass="formGroup has-errors" />
					<p class="has-errors">
						<c:out value="${errorInfo.message}"></c:out>
					</p>
					<fieldset>
						<legend>
							<s:message code="complaint.installationdetails.text" />
						</legend>
						<div class="row-fluid">
							<div class="span4">
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
										cssClass="form-control text-uppercase" disabled="true"
										cssErrorClass="form-control has-errors" id="contractNumber"
										required="required" placeholder="contract..">
										<form:option value="0" label="--- None ---" />
										<c:forEach items="${contracts}" var="contract">
											<form:option value="${contract}"
												label="${contract}" />
										</c:forEach>
									</form:select>
									<form:errors path="complaintDetail.contractNumber"
										cssClass="has-errors" element="span" />

								</div>
							</div>
							<c:url var="findComplaintDetailsByContractNumberURL" value="/rest/complaints" />
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
							<div class="span4"></div> 
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
										cssClass="form-control"
										cssErrorClass="form-control has-errors" id="complaintNumber"
										readonly="true" type="text" required="required"
										placeholder="Complaint Number..." />
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
										cssClass="form-control" 
										cssErrorClass="form-control has-errors" id="previouscalls"
										readonly="true" type="text" required="required"
										placeholder="Previous calls..." />
									<form:errors path="complaintDetail.previousCalls"
										cssClass="has-errors" element="span" />

								</div>
							</div>
							<div class="span4"></div>
						</div>
						<div class="row-fluid">
							<div class="span4">
								<div class="formGroup">
									<form:label path="complaintDetail.complaintType"
										cssErrorClass="has-errors">
										<s:message code="complaint.complainttype.label" />
									</form:label>
									<form:select path="complaintDetail.complaintType" disabled="true"
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
							<c:url var="findComplaintNatureByComplaintNumberURL" value="/rest/complaints/complaintNature" />
							<div class="span4">
								<div class="formGroup">
									<form:label path="complaintDetail.complaintNature"
										cssErrorClass="has-errors">
										<s:message code="complaint.complaintnature.label" />
									</form:label>
									<form:select path="complaintDetail.complaintNature"
										cssClass="form-control text-uppercase" required="true"
										cssErrorClass="form-control has-errors" disabled="true"
										id="complaintNature">
										<form:option value="" label="--- None ---" />
										<c:forEach items="${complaintNatures}" var="tipS">
											<form:option value="${tipS.tipAviso}" label="${tipS.descripcion}" />
										</c:forEach>
									</form:select>
									<form:errors path="complaintDetail.complaintNature"
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
										cssErrorClass="form-control has-errors" disabled="true"
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
											 readonly="true" required="true" />

										<span class="add-on"><i class="icon-calendar"></i></span>
									</div>
									<form:errors path="complaintDetail.detectionDate"
										cssClass="has-errors" element="span" />
								</div>
							</div>
							<div class="span8">
								<div class="formGroup">
									<form:label path="complaintDetail.comments"
										cssErrorClass="has-errors">
										<s:message code="complaint.description.label" />
									</form:label>
									<form:textarea path="complaintDetail.comments" readonly="true"
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
										cssClass="form-control text-uppercase" disabled="true"
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
										cssClass="form-control text-uppercase" disabled="true"
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
										cssClass="form-control text-uppercase" disabled="true"
										cssErrorClass="form-control has-errors" id="street"
										required="required">
										<form:option value="0" label="--- None ---" />
										<c:forEach items="${streets}" var="street">
											<form:option value="${street.codLocal}"
												label="${street.nomLocal}" />
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
										cssClass="form-control"
										cssErrorClass="form-control has-errors" id="surname"
										readonly="true" type="text" required="required"
										placeholder="surname..." />
									<form:errors path="customerProfile.surname"
										cssClass="has-errors" element="span" />

								</div>
							</div>
							<div class="span4">
								<div class="formGroup">
									<form:label path="customerProfile.middleName"
										cssErrorClass="has-errors">
										<s:message code="complaint.middlename.label" />
									</form:label>
									<form:input path="customerProfile.middleName"
										cssClass="form-control"
										cssErrorClass="form-control has-errors" id="middleName"
										readonly="true" type="text" required="required"
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
										cssClass="form-control"
										cssErrorClass="form-control has-errors" id="firstName"
										readonly="true" type="text" required="required"
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
										cssClass="form-control text-uppercase" disabled="true"
										cssErrorClass="form-control has-errors" id="idType"
										required="required" placeholder="id Type..">
										<form:option value="" label="--- Select ---" />
										<c:forEach items="${idTypes}" var="idType">
											<form:option value="${idType.tipo}"
												label="${idType.descTipo}" />
										</c:forEach>
									</form:select>

									<form:errors path="customerProfile.idType"
										cssClass="has-errors" element="span" />
								</div>
							</div>
							<div class="span4">
								<div class="formGroup">
									<form:label path="customerProfile.idNumber"
										cssErrorClass="has-errors">
										<s:message code="complaint.idnumber.label" /> 
									</form:label>
									<form:input path="customerProfile.idNumber"
										cssClass="form-control"
										cssErrorClass="form-control has-errors" id="idNumber"
										readonly="true" type="text" required="required"
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
										cssClass="form-control"
										cssErrorClass="form-control has-errors" id="phoneNumber"
										readonly="true" type="text" required="required"
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
				</form:form>
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
	  
});

</script>
