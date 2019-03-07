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
				<legend>Terms and Conditions:</legend>
				<div class="row-fluid">
					<div class="span12" style="height: 300px; overflow-y: scroll;">
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
					<div class="span9">
						<%-- <div class="formGroup">
							<form:checkbox path="agreeTermsConditions"
								cssClass="form-control" cssErrorClass="form-control has-errors"
								id="terms" required="required" value="Y" />
							<s:message code="application.terms.label" />
							<span class="has-errors star">*</span>
							<form:errors path="agreeTermsConditions" cssClass="has-errors"
								element="span" />
						</div> --%>
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
						<input type="button" style="min-width: 178px"
							class="btn btn-lg btn-primary "
							onclick="window.open('<c:url value="/client/application/print"/>');"
							value="download" />
						<%-- 	<a class="fancybox" data-fancybox-type="iframe"
							href="<c:url value="/client/application/print"/>" target="_blank">
							download</a> --%>
					</div>
					<div class="span4">
						<br />
						<form:button type="button" id="get_file"
							class="btn btn-lg btn-primary " value="Upload Signed Copy"
							style="min-width:178px">
							Upload Signed Copy
						</form:button>
						<!-- SMA 20160316 -->
						<div class="has-errors" hidden="true" id="ToCmessage">
							<s:message code="application.queue.TOC.message.value" />
						</div>
						<%-- <form:input path="files" style="min-width:178px" type="button" id="get_file"
							value="Upload Signed Copy" class="btn btn-lg btn-primary " /> --%>
						<%-- <div hidden="true">
							<form:input path="files" type="file" id="my_file" />
						</div> --%>
					</div>

					<div class="span4"></div>

				</div>
			</fieldset>


			<fieldset>
				<div class="row-fluid">
					<div hidden="true">
						<form:input path="codApplication" id="codApplication" />
						<%-- <form:input path="documentType" id="documentType"/> --%>
					</div>
					<div class="span12">
						<!--check http://www.dropzonejs.com/#usage for configuration info -->
						<!-- also refer to umeme_bottom_scripts.jsp line 17 for creation of this file-upload div -->
						<div id="dropzoneId" hidden="true"
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
			</fieldset>
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
					<%-- <div class="span3 ">
						<form:button type="submit" id="btnSave"
							class="btn btn-lg btn-primary" name="action" value="save"
							style="min-width:178px">
							<s:message code="save.value" />
						</form:button>
					</div> --%>
					<div class="span3">
						<form:button type="submit" id="btnSubmit"
							class="btn btn-lg btn-primary " name="action" value="submit"
							style="min-width:178px">
							<s:message code="submit.value" />
						</form:button>
					</div>
					<div class="span3">
						<%-- <form:button type="submit" id="btnCancel"
							class="btn btn-lg btn-primary " name="action" value="cancel"
							style="min-width:178px">
							<s:message code="cancel.value" />
						</form:button> --%>

					</div>
					<div class="span3">
						<a
							href='<s:url value="/client/applications/incomplete"></s:url>
						'><span><s:message
									code="application.finish.later.value" /></span></a>
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
							maxFiles : 1,
							parallelUploads : 1,
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
															//$("#uploadmsg").show();

															$("#new-application")[0]
																	.submit();

														}
													}
													//myDropzone.processQueue();
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
	document.getElementById('get_file').onclick = function() {
		//document.getElementById('my_file').click();
		document.getElementById('dropzoneId').click();
		uploadToC = true;
	};
</script>
