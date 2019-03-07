<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<div id="main" class="post-template" style="padding-top: 0;">
	<div class="container">
		<div class="row-fluid">
			<div class="span12 post-page">
				<form:form method="POST" commandName="complaintForm"
					cssClass=" register" acceptCharset="ISO-8859-1"
					style="padding:5px;">
					<form:errors path="*" element="div" cssClass="formGroup has-errors" />
					<p class="has-errors">
						<c:out value="${errorInfo.message}"></c:out>
					</p>
					<h3 class="module-title-short">
						<span class="selected"><s:message
								code="emergencycomplaint.new.title" /></span>
					</h3>

					<fieldset>
						<legend>
							<s:message code="emergencycomplaint.complainer.text" />
						</legend>
						<div class="row-fluid">
							<div class="span3">
								<div class="formGroup">
									<form:label path="customerProfile.surname"
										cssErrorClass="has-errors">
										<s:message code="complaint.surname.label" />
									</form:label>
									<form:input path="customerProfile.surname"
										cssClass="form-control"
										cssErrorClass="form-control has-errors" id="surname"
										 type="text" required="required"
										placeholder="surname..." />
									<form:errors path="customerProfile.surname"
										cssClass="has-errors" element="span" />

								</div>
							</div>
							<div class="span3">
								<div class="formGroup">
									<form:label path="customerProfile.middleName"
										cssErrorClass="has-errors">
										<s:message code="complaint.middlename.label" />
									</form:label>
									<form:input path="customerProfile.middleName"
										cssClass="form-control"
										cssErrorClass="form-control has-errors" id="middleName"
										 type="text" required="required"
										placeholder="middleName..." />
									<form:errors path="customerProfile.middleName"
										cssClass="has-errors" element="span" />

								</div>
							</div>
							<div class="span3">
								<div class="formGroup">
									<form:label path="customerProfile.firstName"
										cssErrorClass="has-errors">
										<s:message code="complaint.firstname.label" />
									</form:label>
									<form:input path="customerProfile.firstName"
										cssClass="form-control"
										cssErrorClass="form-control has-errors" id="firstName"
										type="text" required="required"
										placeholder="firstName..." />
									<form:errors path="customerProfile.firstName"
										cssClass="has-errors" element="span" />

								</div>
							</div>

						</div>
						<div class="row-fluid">

							<div class="span3">
								<div class="formGroup">
									<form:label path="customerProfile.idType"
										cssErrorClass="has-errors">
										<s:message code="complaint.idtype.label" />
									</form:label>
									<form:select path="customerProfile.idType"
										cssClass="form-control text-uppercase" 
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
							<div class="span3">
								<div class="formGroup">
									<form:label path="customerProfile.idNumber"
										cssErrorClass="has-errors">
										<s:message code="complaint.idnumber.label" />
									</form:label>
									<form:input path="customerProfile.idNumber"
										cssClass="form-control"
										cssErrorClass="form-control has-errors" id="idNumber"
										 type="text" required="required"
										placeholder="id number..." />

									<form:errors path="customerProfile.idNumber"
										cssClass="has-errors" element="span" />
								</div>

							</div>
							<div class="span3">
								<div class="formGroup">
									<form:label path="customerProfile.mobileNumber"
										cssErrorClass="has-errors">
										<s:message code="complaint.phonenumber.label" />
									</form:label>
									<form:input path="customerProfile.mobileNumber"
										cssClass="form-control"
										cssErrorClass="form-control has-errors" id="phoneNumber"
										type="text" required="required"
										placeholder="phone number..." />
									<form:errors path="customerProfile.mobileNumber"
										cssClass="has-errors" element="span" />
								</div>
							</div>
							<div class="span3"></div>

						</div>
					</fieldset>
					<fieldset>
						<legend>
							<s:message code="complaint.locationdetails.text" />
						</legend>
						<div class="row-fluid">
							<div class="span3">
								<div class="formGroup">
									<form:label path="customerProfile.premiseInformation.district"
										cssErrorClass="has-errors">
										<s:message code="complaint.district.label" />
									</form:label>
									<form:select path="customerProfile.premiseInformation.district"
										cssClass="form-control text-uppercase"
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
							<c:url var="findDistrictVillagesURL"
								value="/rest/client/application/villages" />

							<div class="span3">
								<div class="formGroup">
									<form:label path="customerProfile.premiseInformation.village"
										cssErrorClass="has-errors">
										<s:message code="myprofile.village.label" />
									</form:label>
									<form:select path="customerProfile.premiseInformation.village"
										cssClass="form-control text-uppercase"
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
							<c:url var="findVillageLocalitiesURL"
								value="/rest/client/application/localities" />
							<div class="span3">
								<div class="formGroup">
									<form:label path="customerProfile.premiseInformation.locality"
										cssErrorClass="has-errors">
										<s:message code="myprofile.locality.label" />
										<%-- <span class="has-errors star">*</span> --%>
									</form:label>
									<form:select path="customerProfile.premiseInformation.locality"
										cssClass="form-control text-uppercase"
										cssErrorClass="form-control has-errors" id="locality"
										required="required">
										<form:option value="0" label="--- None ---" />
										<c:forEach items="${localities}" var="locality">
											<form:option value="${locality.codLocal}"
												label="${locality.nomLocal}" />
										</c:forEach>
									</form:select>

									<form:errors path="customerProfile.premiseInformation.locality"
										cssClass="has-errors" element="span" />
								</div>
							</div>
						</div>
						<div class="row-fluid">
							<c:url var="findLocalityStreetsURL"
								value="/rest/client/application/streets" />
							<div class="span3">
								<div class="formGroup">
									<form:label path="customerProfile.premiseInformation.street"
										cssErrorClass="has-errors">
										<s:message code="myprofile.street.label" />
									</form:label>
									<form:select path="customerProfile.premiseInformation.street"
										cssClass="form-control text-uppercase"
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

							<div class="span3">
								<div class="formGroup">
									<form:label
										path="customerProfile.premiseInformation.housePlotNumber"
										cssErrorClass="has-errors">
										<s:message code="myprofile.houseplotno.label" />
									</form:label>
									<form:input
										path="customerProfile.premiseInformation.housePlotNumber"
										cssClass="form-control"
										cssErrorClass="form-control has-errors" id="houseplotno"
										type="text" required="required" />
									<form:errors
										path="customerProfile.premiseInformation.housePlotNumber"
										cssClass="has-errors" element="span" />
								</div>
							</div>
							<div class="span3">
								<div class="formGroup">
									<form:label path="customerProfile.premiseInformation.landmark"
										cssErrorClass="has-errors">
										<s:message code="complaint.landmark.label" />
									</form:label>
									<form:input path="customerProfile.premiseInformation.landmark"
										cssClass="form-control"
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
							<s:message code="complaint.complaintdetails.text" />
						</legend>
						<div class="row-fluid">
							<div class="span3">
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
											<form:option value="${tipS.codigo}"
												label="${tipS.descripcion}" />
										</c:forEach>
									</form:select>
									<form:errors path="complaintDetail.complaintType"
										cssClass="has-errors" element="span" />
								</div>
							</div>
							<c:url var="findComplaintNatureByComplaintNumberURL"
								value="/rest/complaints/complaintNature" />
							<div class="span3">
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
							<div class="span3">
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
											<form:option value="${tipS.codigo}"
												label="${tipS.descripcion}" />
										</c:forEach>
									</form:select>
									<form:errors path="complaintDetail.scope" cssClass="has-errors"
										element="span" />
								</div>
							</div>


						</div>
						<div class="row-fluid">
							<div class="span3">
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
							<div class="span6">
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

					<div class="row-fluid">
						<div class="span3"></div>
						<div class="span3"></div>
						<div class="span3"></div>
						<div class="span3"></div>
					</div>

					<div class="row-fluid">
						<div class="span4"></div>
						<div class="span2">
							<button class="btn btn-lg btn-primary btn-block" type="submit">
								<s:message code="submit.value" />
							</button>
						</div>
						<div class="span3"></div>
						<div class="span3"></div>
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
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						//date control
						var nowTemp = new Date();
						var now = new Date(nowTemp.getFullYear(), nowTemp
								.getMonth(), nowTemp.getDate(), 0, 0, 0, 0);
						var checkin = $('#detectionDate')
								.datepicker(
										{
											onRender : function(date) {
												return date.valueOf() > now
														.valueOf() ? 'disabled'
														: '';
											}
										}).on('changeDate', function(ev) {
									checkin.hide();
								}).data('datepicker');
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
																var html = '<option value="">--- None ---</option>';
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
						$('#complaintType')
								.change(
										function() {
											$
													.getJSON(
															'${findComplaintNatureByComplaintNumberURL}',
															{
																complaintType : $(
																		this)
																		.val(),
																ajax : 'true'
															},
															function(data) {
																var html = '<option value="">--- Select ---</option>';
																var len = data.length;
																for (var i = 0; i < len; i++) {
																	html += '<option value="' + data[i].tipAviso + '">'
																			+ data[i].descripcion
																			+ '</option>';
																}
																html += '</option>';

																$(
																		'#complaintNature')
																		.html(
																				html);
															});
										});

					});
</script>
