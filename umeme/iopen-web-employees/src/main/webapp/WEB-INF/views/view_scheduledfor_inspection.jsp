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
				<form:form method="POST" commandName="scheduledApplication"
					cssClass="form-horizontal dropzone" id="scheduleapplication">
					<!-- 
			private String applicationNumber = null;
			private String applicationType = null;
			private String district = null;
			private String village = null;
			private String street = null;
			private String housePlot = null;
			private String phoneNumber = null;
			private Long codApplication = null;
			private String duration = null;
			private String inspectionScheduledBy = null;
			private Date inspectionScheduledDate = null;
			private Boolean inspectionScheduled = Boolean.FALSE; 
			-->
					<fieldset>
						<legend>
							<s:message code="schedule.inspection.fieldsetext" />
						</legend>
						<div class="row-fluid">
							<div class="span4">
								<div class="form-group">
									<form:label path="*" cssErrorClass="has-errors">
										<s:message code="application.surname.label" />
										<span class="has-errors star">*</span>
									</form:label>
									<form:input path="*" cssClass="form-control text-uppercase"
										cssErrorClass="form-control has-errors" id="surname"
										placeholder="surname" readonly="true"
										value="${application.iopenApplication.surname}" />
								</div>
							</div>
							<div class="span4">
								<div class="form-group">
									<form:label path="*" cssErrorClass="has-errors">
										<s:message code="application.firstname.label" />
										<span class="has-errors star">*</span>
									</form:label>
									<form:input path="*" cssClass="form-control text-uppercase"
										cssErrorClass="form-control has-errors" id="firstName"
										placeholder="firstName" readonly="true"
										value="${application.iopenApplication.firstName}" />
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
										value="${application.iopenApplication.middleName}" />
								</div>
							</div>
						</div>
						<div class="row-fluid">
							<div class="span4">
								<div class="form-group">
									<form:label path="*" cssErrorClass="has-errors">
										<s:message code="application.idnumber.label" />
										<span class="has-errors star">*</span>
									</form:label>
									<form:input path="*" cssClass="form-control text-uppercase"
										cssErrorClass="form-control has-errors" id="idNumber"
										placeholder="idNumber" readonly="true"
										value="${application.iopenApplication.idNumber}" />
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
										value="${application.iopenApplication.tinNumber}" />
									<form:errors path="*" cssClass="has-errors" element="span" />
								</div>
							</div>
						</div>
						<div class="row-fluid">
							<div class="span4">
								<div class="formGroup">
									<form:label path="applicationType">
										<s:message code="inspection.col.ApplicationType" />
									</form:label>
									<form:input path="applicationType"
										cssClass="form-control text-uppercase" id="applicationType"
										placeholder="application type.." readonly="true" />
								</div>
							</div>
							<div class="span4">
								<div class="formGroup">
									<form:label path="applicationNumber">
										<s:message code="inspection.col.ApplicationNumber" />
									</form:label>
									<form:input path="applicationNumber"
										cssClass="form-control text-uppercase" id="applicationNumber"
										placeholder="application no.." readonly="true" />

								</div>
							</div>
							<div class="span4">
								<div class="formGroup">
									<form:label path="district">
										<s:message code="inspection.col.ApplicationDistrict" />
									</form:label>
									<form:input path="district"
										cssClass="form-control text-uppercase"
										id="applicationDistrict" placeholder="district.."
										readonly="true" />
								</div>
							</div>
						</div>
						<div class="row-fluid">
							<div class="span4">
								<div class="formGroup">
									<form:label path="village">
										<s:message code="inspection.col.ApplicationVillage" />
									</form:label>
									<form:input path="village"
										cssClass="form-control text-uppercase" id="applicationvillage"
										placeholder="village.." readonly="true" />
								</div>
							</div>
							<div class="span4">
								<div class="formGroup">
									<form:label path="street">
										<s:message code="inspection.col.ApplicationStreet" />
									</form:label>
									<form:input path="street"
										cssClass="form-control text-uppercase" id="applicationStreet"
										placeholder="street.." readonly="true" />
								</div>
							</div>
							<div class="span4">
								<div class="formGroup">
									<form:label path="housePlot">
										<s:message code="inspection.col.ApplicationHousePlot" />
									</form:label>
									<form:input path="housePlot"
										cssClass="form-control text-uppercase"
										id="applicationhousePlot" placeholder="House/Plot.."
										readonly="true" />
								</div>
							</div>

						</div>
						<div class="row-fluid">
							<div class="span4">
								<div class="formGroup">
									<form:label path="housePlot">
										<s:message code="inspection.col.ApplicationHousePlot" />
									</form:label>
									<form:input path="housePlot"
										cssClass="form-control text-uppercase"
										id="applicationhousePlot" placeholder="House/Plot.."
										readonly="true" />
								</div>

							</div>
							<div class="span4">
								<div class="formGroup">
									<form:label path="phoneNumber">
										<s:message code="inspection.col.ApplicationPhoneNumber" />
									</form:label>
									<form:input path="phoneNumber"
										cssClass="form-control text-uppercase"
										id="applicationphoneNumber" placeholder="Phone Number.."
										readonly="true" />
								</div>
							</div>
							<div class="span4">
								<div class="formGroup">
									<form:label path="duration">
										<s:message code="inspection.col.ApplicationDurationInStatus" />
									</form:label>
									<form:input path="duration"
										cssClass="form-control text-uppercase"
										id="applicationduration" placeholder="Duration.."
										readonly="true" />
								</div>
							</div>
						</div>

					</fieldset>
					<fieldset>
						<legend>
							<s:message code="schedule.inspection.docs" />
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
											items="${application.iopenApplication.iopenApplicationDocs}"
											var="doc">
											<tr class="active">
												<%-- <td>${doc.fActual}</td> --%>
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

					</fieldset>

					<fieldset>
						<legend>
							<s:message code="schedule.inspection.actionapprove" />
						</legend>
						<div class="row-fluid">
							<div class="span2">
								<div class="form-group">
									<form:label path="*" cssErrorClass="has-errors">
									<s:message code="schedule.inspection.schedule" />
									</form:label>
									<form:radiobutton path="*" cssClass="form-control" disabled="true" 
										checked="checked" cssErrorClass="form-control has-errors"
										id="scheduleApprove" value='${defaultValues.get("application_inspection_approve_value")}' />
									<form:errors path="*" cssClass="has-errors" element="span" />
								</div>
							</div>
							<div class="span4">
								<div class="formGroup">
									<form:label path="inspectionScheduledDate">
										<s:message code="inspection.col.inspectionScheduledDate" />
									</form:label>
									<div id="scheduledDatepicker" class="input-append date">
										<form:input path="inspectionScheduledDate" data-format="dd/MM/yyyy" type="text" id="inspectionScheduledDate" cssClass="form-control"
										cssErrorClass="form-control has-errors" role="aria"  readonly="true" />
										<span class="add-on"> <i data-time-icon="icon-time"
											data-date-icon="icon-calendar"> </i>
										</span>
										
									</div>
									<form:errors path="inspectionScheduledDate" cssClass="has-errors" element="span" />
								</div>
							</div>
							<div class="span2">
								<div class="form-group">
									<form:label path="*" cssErrorClass="has-errors">
										<s:message code="schedule.inspection.reject" />
									</form:label>
									<form:radiobutton path="*" cssClass="form-control"  disabled="true"
										cssErrorClass="form-control has-errors" id="scheduleReject"
										value='${defaultValues.get("application_inspection_reject_value")}' />
									<form:errors path="*" cssClass="has-errors" element="span" />
								</div>
							</div>
							<div class="span4">
								<div class="formgroup">
									<form:label path="rejectionCode" cssErrorClass="has-errors">
										<s:message code="application.rejectReason.label" />
									</form:label>
									<form:select path="rejectionCode" cssClass="form-control text-uppercase"
										cssErrorClass="form-control has-errors"  readonly="true"
										id="applicationcoRejectReason" placeholder="status" role="aria">
										<form:option value="" label="--SELECT--" />
										<c:forEach items="${rejectReasons}" var="rejectReason">
											<form:option value="${rejectReason.cod}"
												label="${rejectReason.descCod}" />
										</c:forEach>
									</form:select>
								</div>
							</div>
						</div>
						<div class="row-fluid">
							<div class="span8"></div>
							<div class="span4">
								<div class="formGroup">
									<form:label path="rejectionComments">
										<s:message code="schedule.inspection.rejectcomment" />
									</form:label>
									<form:textarea path="rejectionComments" readonly="true"
										cssClass="form-control text-uppercase" id="rejectionComment"
										placeholder="feedback.." />
								</div>
							</div>
							</div>
					</fieldset> 
					<div class="row-fluid" style="margin-top:20px;">
						<div class="span3">
							<a class="btn btn-lg btn-primary"
								href="<c:url value="/employee/inspection/pendinginspection?schedule=true"/>"
								role="button"> <s:message code="schedule.inspection.back" /></a>
						</div>
						<div class="span1"></div>
						<div class="span3">
							<%-- <form:button class="btn btn-lg btn-primary " 
								style="min-width:178px" id="btnSubmit">
								<s:message code="submit.value" />
							</form:button> --%>
						</div>
						<div class="span5"></div>
					</div>

				</form:form>

				<div class="bottom-border">&nbsp;</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript" src='<s:url value="/resources/assets/js/bootstrap-datetimepicker.min.js"></s:url>'>
    </script>
<script src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/jquery.validate.js"></script>
<script src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/additional-methods.js"></script>
<script type="text/javascript">
	$(function() {
		//inline preview
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
		$('#scheduleapplication').validate({
			errorClass: "has-errors",
	        rules: { 
	        	inspectionScheduledDate: {
	                required: true
	              }
	        }
	        });
		$('#scheduledDatepicker').datetimepicker({
			language : 'pt-BR',
			pickTime: false
		});
		//
		if ($('#scheduleApprove').prop('checked')) {
			$('#applicationcoRejectReason').prop('disabled', true);
			$('#rejectionComment').prop('disabled', true);
		}
		$('#scheduleApprove').click(function() {

			if ($(this).prop('checked')) {

				$('#applicationcoRejectReason').rules( "remove" ); 
				$('#applicationcoRejectReason').prop('disabled', true);
				$('#rejectionComment').prop('disabled', true);
				$('#inspectionScheduledDate').prop('disabled', false);
				$('#inspectionScheduledDate').rules("add", {
					required : true});  
			} else { 
				$('#inspectionScheduledDate').rules( "remove" );
				$('#applicationcoRejectReason').prop('disabled', false);
				$('#rejectionComment').prop('disabled', false);
				$('#inspectionScheduledDate').prop('disabled', true);
				$('#applicationcoRejectReason').rules("add", {
					required : true});
			}
		});

		$('#scheduleReject').click(function() {

			if ($(this).prop('checked')) {
				$('#inspectionScheduledDate').rules( "remove" );
				$('#applicationcoRejectReason').prop('disabled', false);
				$('#rejectionComment').prop('disabled', false);
				$('#inspectionScheduledDate').prop('disabled', true);
				$('#applicationcoRejectReason').rules("add", {
					required : true});
			} else { 
				$('#applicationcoRejectReason').rules( "remove" );
				$('#applicationcoRejectReason').prop('disabled', true);
				$('#rejectionComment').prop('disabled', true);
				$('#inspectionScheduledDate').prop('disabled', false);
				$('#inspectionScheduledDate').rules("add", {
					required : true});
			}
		});
		
		function addRules(target,rules) {
			$(target).rules('add' , rules);
		}
		
		function removeRules(target) {
			$(target).rules('remove');
		} 
		$("#scheduleapplication").validate()
	});
</script>
