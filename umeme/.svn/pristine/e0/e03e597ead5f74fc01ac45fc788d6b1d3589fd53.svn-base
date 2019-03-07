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
				<h3 class="module-title-short">
					<span class="selected"><s:message code="viewpoweroutage.title" /></span>
				</h3>

				<form:form method="POST" commandName="powerOutage"
					cssClass=" register" acceptCharset="ISO-8859-1"
					style="padding:5px;">

					<div class="row-fluid">
						<div class="span4">
							<div class="formGroup">
								<form:label path="outageType" cssErrorClass="has-errors">
									<s:message code="viewpoweroutage.outagetype.label" />
								</form:label>
								<form:select path="outageType" disabled="true"
									cssClass="form-control text-uppercase"
									cssErrorClass="form-control has-errors" id="outagetype"
									required="required">
									<form:option value="1">
										<s:message code="poweroutage.plannedoutage.text" />
									</form:option>
									<form:option value="2">
										<s:message code="poweroutage.unplannedoutage.text" />
									</form:option>
								</form:select>
								<form:errors path="outageType" cssClass="has-errors"
									element="span" />
							</div>
						</div>
						<div class="span8" >
						</div>
						
					</div>
					<div class="span12">
								<hr />
							</div>
					<div class="row-fluid"> 
						<div class="span3">
							<div class="formGroup">
								<form:label path="scope" cssErrorClass="has-errors">
									<s:message code="viewpoweroutage.scope.label" />
								</form:label>
								<form:input path="scope" cssClass="form-control" readonly="true"
									cssErrorClass="form-control has-errors" id="scope" type="text"
									required="required" placeholder="scope..." />
								<form:errors path="scope" cssClass="has-errors" element="span" />

							</div>
						</div>

						<div class="span3">
							<div class="formGroup">
								<form:label path="voltage" cssErrorClass="has-errors">
									<s:message code="viewpoweroutage.voltage.label" />
								</form:label>
								<form:input path="voltage" cssClass="form-control"
									readonly="true" cssErrorClass="form-control has-errors"
									id="voltage" type="text" required="required"
									placeholder="voltage..." />
								<form:errors path="voltage" cssClass="has-errors" element="span" />

							</div>
						</div>

						<div class="span3">
							<div class="formGroup">
								<form:label path="region" cssErrorClass="has-errors">
									<s:message code="viewpoweroutage.region.label" />
								</form:label>
								<form:input path="region" cssClass="form-control"
									readonly="true" cssErrorClass="form-control has-errors"
									id="region" type="text" required="required"
									placeholder="region..." />
								<form:errors path="region" cssClass="has-errors" element="span" />

							</div>
						</div>
					</div>

					<div class="row-fluid">
						

						<div class="span3">
							<div class="formGroup">
								<form:label path="powerOutageInstallationInfo.district"
									cssErrorClass="has-errors">
									<s:message code="viewpoweroutage.district.label" />
								</form:label>
								<form:input path="powerOutageInstallationInfo.district"
									cssClass="form-control" readonly="true"
									cssErrorClass="form-control has-errors" id="district"
									type="text" required="required" placeholder="district..." />
								<form:errors path="powerOutageInstallationInfo.district"
									cssClass="has-errors" element="span" />

							</div>
						</div>

						<div class="span3">
							<div class="formGroup">
								<form:label path="powerOutageInstallationInfo.substation"
									cssErrorClass="has-errors">
									<s:message code="viewpoweroutage.substation.label" />
								</form:label>
								<form:input path="powerOutageInstallationInfo.substation"
									cssClass="form-control" readonly="true"
									cssErrorClass="form-control has-errors" id="substation"
									type="text" required="required" placeholder="substation..." />
								<form:errors path="powerOutageInstallationInfo.substation"
									cssClass="has-errors" element="span" />

							</div>
						</div>

						<div class="span3">
							<div class="formGroup">
								<form:label path="powerOutageInstallationInfo.feeder"
									cssErrorClass="has-errors">
									<s:message code="viewpoweroutage.feeder.label" />
								</form:label>
								<form:input path="powerOutageInstallationInfo.feeder"
									cssClass="form-control" readonly="true"
									cssErrorClass="form-control has-errors" id="feeder" type="text"
									required="required" placeholder="feeder..." />
								<form:errors path="powerOutageInstallationInfo.feeder"
									cssClass="has-errors" element="span" />

							</div>
						</div>
						
						<div class="span12">
								<hr />
							</div>

					</div>


					<!-- Incident information -->
					<div class="row-fluid">
						<div class="span3">
							<div class="formGroup">
								<form:label path="powerOutageIncidentInfo.plannedDate"
									cssErrorClass="has-errors">
									<s:message code="viewpoweroutage.plannedDate.label" />
								</form:label>
								<form:input path="powerOutageIncidentInfo.plannedDate"
									cssClass="form-control" readonly="true"
									cssErrorClass="form-control has-errors" id="plannedDate"
									type="text" required="required" placeholder="plannedDate..." />
								<form:errors path="powerOutageIncidentInfo.plannedDate"
									cssClass="has-errors" element="span" />

							</div>
						</div>

						<div class="span3">
							<div class="formGroup">
								<form:label path="powerOutageIncidentInfo.plannedDay"
									cssErrorClass="has-errors">
									<s:message code="viewpoweroutage.plannedDay.label" />
								</form:label>
								<form:input path="powerOutageIncidentInfo.plannedDay"
									cssClass="form-control" readonly="true"
									cssErrorClass="form-control has-errors" id="plannedDay"
									type="text" required="required" placeholder="plannedDay..." />
								<form:errors path="powerOutageIncidentInfo.plannedDay"
									cssClass="has-errors" element="span" />

							</div>
						</div>

						<div class="span3">
							<div class="formGroup">
								<form:label path="powerOutageIncidentInfo.status"
									cssErrorClass="has-errors">
									<s:message code="viewpoweroutage.status.label" />
								</form:label>
								<form:input path="powerOutageIncidentInfo.status"
									cssClass="form-control" readonly="true"
									cssErrorClass="form-control has-errors" id="status" type="text"
									required="required" placeholder="status..." />
								<form:errors path="powerOutageIncidentInfo.status"
									cssClass="has-errors" element="span" />

							</div>
						</div>

						<div class="span3"></div>

					</div>
					<div class="row-fluid">
						<div class="span6">
							<div class="formGroup">
								<form:label path="powerOutageIncidentInfo.comment"
									cssErrorClass="has-errors">
									<s:message code="viewpoweroutage.comment.label" />
								</form:label>
								<form:textarea path="powerOutageIncidentInfo.comment"
									cssClass="form-control" readonly="true"
									cssErrorClass="form-control has-errors" id="comment"
									type="text" required="required" placeholder="comment..." />
								<form:errors path="powerOutageIncidentInfo.comment"
									cssClass="has-errors" element="span" />

							</div>
						</div>
						<div class="span6"></div>
					</div>

					<div class="row-fluid">
						<div class="span3"></div>
						<div class="span3"></div>
						<div class="span3"></div>
					</div>


				</form:form>
				<div class="bottom-border">&nbsp;</div>
			</div>
		</div>
	</div>
</div>
<%-- <script type="text/javascript">
$(document).ready(function() {
	$("#btnEdit").click(function(){
		setEditMode();
	});
	$("#btnSubmit").click(function(){
		setReadonlyMode();
	});
	
	function setReadonlyMode(){
		$("#btnSubmit").hide();
		$("#btnEdit").show();
		$(".formGroup :input").attr('readonly','readonly');
		$(".formGroup select").attr('disabled','disabled');
	}	
	
	function setEditMode(){
		$("#btnSubmit").show();
		$("#btnEdit").hide();
		$(".formGroup :input").removeAttr('readonly');
		$(".formGroup select").removeAttr('disabled');		
	}
	  
});

</script> --%>