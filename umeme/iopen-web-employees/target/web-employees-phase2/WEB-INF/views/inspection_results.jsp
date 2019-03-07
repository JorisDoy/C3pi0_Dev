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
					href="<c:url value="/employee/inspection/pendinginspection?schedule=true"/>"
					role="button"> <s:message code="schedule.inspection.back" /></a>
				<h3 class="module-title-short">
					<span class="selected"><s:message
							code="schedule.inspection.title" /></span>

				</h3>
				<form:form method="POST" commandName="receivedInspectionResult"
					cssClass="form-horizontal dropzone" id="ReceivedInspectionResult">
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
										value="${receivedInspectionResult.iopenApplication.surname}" />
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
										value="${receivedInspectionResult.iopenApplication.firstName}" />
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
										value="${receivedInspectionResult.iopenApplication.middleName}" />
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
										value="${receivedInspectionResult.iopenApplication.idNumber}" />
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
										value="${receivedInspectionResult.iopenApplication.tinNumber}" />
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
										value="${defaultValues.get(receivedInspectionResult.iopenApplication.applicationType)}" />
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
										value="${receivedInspectionResult.iopenApplication.expediente.numExp}" />

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
										value="${receivedInspectionResult.iopenApplication.district}" /> --%>
									<form:select path="iopenApplication.district"
										cssClass="form-control text-uppercase"
										cssErrorClass="form-control has-errors" id="district"
										required="required" placeholder="district" readonly="true">
										<%-- <form:option value="NONE" label="--- Select ---" /> --%>
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
										value="${receivedInspectionResult.iopenApplication.village}" /> --%>
									<form:select path="iopenApplication.village"
										cssClass="form-control text-uppercase"
										cssErrorClass="form-control has-errors" id="village"
										required="required" placeholder="village" readonly="true">
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
									<%-- <form:input path="*" cssClass="form-control text-uppercase"
										id="applicationStreet" placeholder="street.." readonly="true"
										value="${receivedInspectionResult.iopenApplication.street}" /> --%>
									<form:select path="iopenApplication.street"
										cssClass="form-control text-uppercase"
										cssErrorClass="form-control has-errors" id="village"
										required="required" placeholder="village" readonly="true">
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
										value="${receivedInspectionResult.iopenApplication.housePlot}" />
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
										value="${receivedInspectionResult.iopenApplication.mobileNumber}" />
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
							<s:message code="schedule.inspection.results" />
						</legend>
						<div class="row-fluid">
							<div class="span4">
								<div class="formGroup">
									<form:label path="inspectionPassed" cssErrorClass="has-errors">
										<s:message code="schedule.inspection.results" />
										<span class="has-errors star">*</span>
									</form:label>
									<form:select path="inspectionPassed" required="true"
										cssClass="form-control text-uppercase"
										cssErrorClass="form-control has-errors" id="tipObra">

										<%-- <form:option value="1" label="Passed" />
										<form:option value="0" label="Failed" /> --%>

										<form:option value="1">
											<s:message code="inspection.passed.label" />
										</form:option>
										<form:option value="0">
											<s:message code="inspection.failed.label" />
										</form:option>
									</form:select>
									<form:errors path="inspectionPassed" cssClass="has-errors"
										element="span" />
								</div>
							</div>

						</div>
						<div class="row-fluid">
							<div class="span4">

								<div class="formGroup">
									<form:label path="tipObra" cssErrorClass="has-errors">
										<s:message code="scheduled.projectTypes.label" />
										<span class="has-errors star">*</span>
									</form:label>
									<form:select path="tipObra" required="true"
										cssClass="form-control text-uppercase"
										cssErrorClass="form-control has-errors" id="tipObra">
										<form:option value="" label="--- Select ---" />
										<c:forEach items="${projectTypes}" var="tipS">
											<form:option value="${tipS.tipo}" label="${tipS.descTipo}" />
										</c:forEach>
									</form:select>
									<form:errors path="tipObra" cssClass="has-errors"
										element="span" />
								</div>

							</div>
							<div class="span4">

								<div class="formGroup">
									<form:label path="tipConexion" cssErrorClass="has-errors">
										<s:message code="scheduled.connectionTypes.label" />
										<span class="has-errors star">*</span>
									</form:label>
									<form:select path="tipConexion" required="true"
										cssClass="form-control text-uppercase"
										cssErrorClass="form-control has-errors" id="tipConexion">
										<form:option value="" label="--- Select ---" />
										<c:forEach items="${connectionTypes}" var="tipS">
											<form:option value="${tipS.tipo}" label="${tipS.descTipo}" />
										</c:forEach>
									</form:select>
									<form:errors path="tipConexion" cssClass="has-errors"
										element="span" />
								</div>
							</div>
							<div class="span4">
								<div class="formGroup">
									<form:label path="tipSolic" cssErrorClass="has-errors">
										<s:message code="scheduled.workRequestTypes.label" />
										<span class="has-errors star">*</span>
									</form:label>
									<form:select path="tipSolic" required="true"
										cssClass="form-control text-uppercase"
										cssErrorClass="form-control has-errors" id="tipSolic">
										<form:option value="" label="--- Select ---" />
										<c:forEach items="${workRequestTypes}" var="tipS">
											<form:option value="${tipS.tipo}" label="${tipS.descTipo}" />
										</c:forEach>
									</form:select>
									<form:errors path="tipSolic" cssClass="has-errors"
										element="span" />
								</div>
							</div>
						</div>
						<div class="row-fluid" style="margin-top: 20px;">
							<div class="span4">
								<div class="formGroup">
									<form:label path="inspectionByEmployeeCode"
										cssErrorClass="has-errors">
										<s:message code="scheduled.inspectingemployee.label" />
										<span class="has-errors star">*</span>
									</form:label>
									<form:select path="inspectionByEmployeeCode" required="true"
										cssClass="form-control text-uppercase"
										cssErrorClass="form-control has-errors"
										id="inspectionByEmployeeCode">
										<form:option value="${0}" label="--- Select ---" />
										<c:forEach items="${inspectionEmployees}" var="tipS">
											<form:option value="${tipS.codEmp}"
												label="${tipS.ape1Emp} ${tipS.ape2Emp} ${tipS.nomEmp}" />
										</c:forEach>
									</form:select>
									<form:errors path="inspectionByEmployeeCode"
										cssClass="has-errors" element="span" />
								</div>
							</div>
							<div class="span4">
								<div class="formGroup">
									<form:label path="inspectionDateString">
										<s:message code="inspection.col.inspectionDate" />
										<span class="has-errors star">*</span>
									</form:label>
									<%-- <div id="scheduledDatepicker" class="input-append date">
										<form:input path="inspectionDateString" data-format="dd/MM/yyyy"
											type="text" id="inspectionScheduledDate"
											cssClass="form-control" required="true"
											cssErrorClass="form-control has-errors" role="aria" />
										<span class="add-on"> <i data-time-icon="icon-time"
											data-date-icon="icon-calendar"> </i>
										</span>

									</div> --%>
									<div class="input-append date" id="inspectionScheduledDate"
										data-date="" data-date-format="dd/mm/yyyy">
										<form:input path="inspectionDateString" type="text"
											id="inspectionScheduledDate2" cssClass="form-control"
											cssErrorClass="form-control has-errors" role="aria"
											required="true" />

										<span class="add-on"><i class="icon-calendar"></i></span>
									</div>
									<form:errors path="inspectionDateString" cssClass="has-errors"
										element="span" />
								</div>
							</div>
							<div class="span4">
								<div class="formGroup">
									<form:label path="inspectionTime">
										<s:message code="inspection.col.inspectionTime" />
										<span class="has-errors star">*</span>
									</form:label>
									<div id="inspectionTime" class="input-append time">
										<form:input path="inspectionTime" data-format="hh.mm"
											type="text" id="inspectionScheduledTime"
											cssClass="form-control" required="true"
											cssErrorClass="form-control has-errors" role="aria" />
										<span class="add-on"> <i data-time-icon="icon-time"
											data-date-icon="icon-calendar"> </i>
										</span>

									</div>
									<form:errors path="inspectionTime" cssClass="has-errors"
										element="span" />
								</div>
							</div>
						</div>
						<div class="row-fluid" style="margin-top: 20px;">
							<div class="span8">
								<div class="formGroup">
									<form:label path="inspectionComment">
										<s:message code="inspection.comment.label" />
									</form:label>
									<form:textarea path="inspectionComment" cssClass="form-control"
										id="inspectionComment" placeholder="feedback.."
										required="true" style="width: 80%;" />
								</div>
							</div>
							<div class="span4"></div>
						</div>
					</fieldset>
					<div class="row-fluid" style="margin-top: 20px;">
						<div class="span3">
							<a class="btn btn-lg btn-primary"
								href="<c:url value="/employee/inspection/pendinginspection?schedule=true"/>"
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
			pickTime: false
		}); */
		//date control
		var nowTemp = new Date();
		var now = new Date(nowTemp.getFullYear(), nowTemp.getMonth(), nowTemp
				.getDate(), 0, 0, 0, 0);
		var checkin = $('#inspectionScheduledDate').datepicker({
			onRender : function(date) {
				return date.valueOf() < now.valueOf() ? 'disabled' : '';
			}
		}).on('changeDate', function(ev) {
			checkin.hide();
		}).data('datepicker');
		$('#inspectionTime').datetimepicker({
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
