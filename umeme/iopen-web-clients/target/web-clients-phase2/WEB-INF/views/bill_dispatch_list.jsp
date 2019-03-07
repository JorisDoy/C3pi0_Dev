<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<div class="row-fluid">
	<div class="span12 post-page">
		<h3 class="module-title-short">
			<span class="selected"><s:message code="billdispatch.title" /></span>
		</h3>
		<%--		<div class="row-fluid" style="display:none;"> 
						<form:form method="POST" commandName="billDispatchForm" cssClass=" register"
							acceptCharset="ISO-8859-1"  style="border:1px solid gray; padding:5px;">
							<form:errors path="*" element="div" cssClass="formGroup has-errors" />
							<p class="has-errors">
								<c:out value="${errorInfo.message}"></c:out>
							</p>
							<fieldset>
								<legend><s:message code="billdispatch.contract.text" /></legend>
								<div class="row-fluid">
									<div class="span4">
										<div class="formGroup">
											<form:label path="billDispatchForm.contractNumber"
												cssErrorClass="has-errors">
												<s:message code="billdispatch.servicecontractnumber.text" />
											</form:label> 
											<form:select path="billDispatchForm.contractNumber"
												cssClass="form-control text-uppercase"
												cssErrorClass="form-control has-errors" id="contractNumber"
												required="required" placeholder="contract.."> 
												<c:forEach items="${contracts}" var="contract">
													<form:option value="${contract}" label="${contract}" />
												</c:forEach>
											</form:select>
											<form:errors path="billDispatchForm.contractNumber"
												cssClass="has-errors" element="span" />
				
										</div>
									</div>
								</div>
							</fieldset>
							<fieldset>
								<legend><s:message code="billdispatch.methods.text" /></legend>
									<div class="row-fluid">
										<div class="span4">
										<form:label path="*">
											<s:message code="billdispatch.methodname.label" />
										</form:label>
										</div>
										<div class="span4">
										<form:label path="*">
											<s:message code="billdispatch.methoddetail.label" />
										</form:label>
										</div>
										<div class="span4"> 
										</div> 
									</div>
								<c:forEach items="${billDispatchList}" var="billDispatchItem">
									<div class="row-fluid">
										<div class="span4"><form:checkbox path="*" cssClass="form-control" value="${billDispatchItem.dispatchMethod}" checked="${billDispatchItem.selected}" />${billDispatchItem.dispatchMethod}</div>
										<div class="span4"><form:input path="*" cssClass="form-control" id="dispatchMethodcontact" readonly="true" type="text" value="${billDispatchItem.contact}" /></div>
										<div class="span4"></div> 
									</div>
								</c:forEach>								
								<c:if test="${empty(billDispatchList)}">
									 <div class="row-fluid">
									 	<div class="span12"><s:message code="empty.list.message" /></div>
									 </div>
								</c:if>
							</fieldset>
						</form:form>						
					</div> --%>


		<div class="row-fluid">
			<div class="span5">
			<c:set var="selectedContractNumber" value="${selectedContractNumber}" />
				<div class="formGroup" style="width: 100%">
					<label> <s:message
							code="billdispatch.servicecontractnumber.text" />
					</label> 
					<select style="width: 100%" id="MainContractNo">
						<c:forEach items="${contracts}" var="contract">
							<option value="${contract.contractNumber}">${contract.contractNumberWithDescription}</option>
						</c:forEach>
					</select>

				</div>
			</div>
		</div>
		<c:url var="findBillDispatchMethodsByContractNumberURL" value="/client/bill-dispatch/contract/list" />

		<div class="row-fluid" id="billdispatchlist">
			<div class="span12">
				<table class="table table-condensed table-hover">
					<thead>
						<tr>
							<th><s:message code="billdispatch.methodname.label" /></th>
							<th><s:message code="billdispatch.methoddetail.label" /></th>
							<th>&nbsp;</th>
						</tr>
					</thead>
					<tbody id="BillListBody">
						<c:forEach items="${billDispatchList}" var="billDispatchItem">
							<tr class="active">
								<td><c:if test="${billDispatchItem.selected == true}">
										<input type="checkbox" class="form-control"
											id="chbx${billDispatchItem.dispatchMethod}"
											value="${billDispatchItem.dispatchMethod}" checked="checked">&nbsp;  ${billDispatchItem.dispatchName}
													</c:if> <c:if test="${billDispatchItem.selected == false}">
										<input type="checkbox" class="form-control"
											id="chbx${billDispatchItem.dispatchMethod}"
											value="${billDispatchItem.dispatchMethod}">&nbsp;  ${billDispatchItem.dispatchName}
													</c:if></td>
								<td> 
								<c:if test="${billDispatchItem.dispatchMethod != 'BD03'}">
								<input class="form-control" id="txt${billDispatchItem.dispatchMethod}" type="text" value="${billDispatchItem.contact}" cssErrorClass="form-control has-errors" >
								</c:if>
								</td>
								<td></td>
							</tr>
						</c:forEach>
						<c:if test="${empty(billDispatchList)}">

							<tr class="active">
								<td colspan="3" rowspan="6"><s:message
										code="empty.list.message" /></td>
							</tr>
						</c:if>
					</tbody>
				</table>
			</div>
		</div>
		<div class="row-fluid">
			<div class="span4"></div>
			<div class="span4"></div>
			<div class="span4"></div>
			</div>
		<c:url var="UpdateBillDispatchMethodsByContractNumberURL" value="/client/bill-dispatch/contract/update" />
		<div class="row-fluid">
			<div class="span4">
				<button class="btn btn-lg btn-primary btn-block" type="submit" id="btnSubmit">
					<s:message code="submit.value" />
				</button>
			</div>
			<div class="span8" id="successMsg"></div> 
		</div>
		<%-- <div id="setEmailDiv" class="row-fluid" style="display: none;">
			<form:form method="POST" commandName="billDispatchForm"
				cssClass=" register" acceptCharset="ISO-8859-1"><fieldset>
								<legend><s:message code="billdispatch.emailset.text" /></legend>

			<div class="row-fluid" style="display: none;"> 
					<div class="span4">
						<div class="formGroup" >
							<form:label path="contractNumber"
								cssErrorClass="has-errors">
								<s:message code="complaint.servicecontractnumber.text" />
							</form:label>
							<form:input path="contractNumber"
								cssClass="form-control" cssErrorClass="form-control has-errors"
								id="billDispatchFormContractNumber" readonly="true" type="text"
								required="required" />
							<form:errors path="contractNumber"
								cssClass="has-errors" element="span" />

						</div>
					</div>
					<div class="span4">
						<div class="formGroup">
							<form:label path="dispatchMethod"
								cssErrorClass="has-errors">
								<s:message code="billDispatchForm.dispatchemailcode.text" />
							</form:label>
							<form:input path="dispatchMethod"
								cssClass="form-control" cssErrorClass="form-control has-errors"
								id="billDispatchFormDispatchMethod" readonly="true" type="text"
								required="required" />
							<form:errors path="dispatchMethod"
								cssClass="has-errors" element="span" />

						</div>
					</div>
				<div class="span4"></div>
			</div>
			<div class="row-fluid"> 
					<div class="span4">
						<div class="formGroup">
							<form:label path="contact"
								cssErrorClass="has-errors">
								<s:message code="billDispatchForm.emailcontact.text" />
							</form:label>
							<form:input path="contact"
								cssClass="form-control" cssErrorClass="form-control has-errors"
								id="billDispatchFormEmail" type="text"
								required="required" />
							<form:errors path="contact"
								cssClass="has-errors" element="span" />

						</div>
						</div>
				<div class="span4"></div>
				<div class="span4"></div>
			</div>

			<div class="row-fluid">

				<div class="span4">
					<button class="btn btn-lg btn-primary btn-block" type="submit">
						<s:message code="submit.value" />
					</button>
				</div>
				<div class="span4"></div>
				<div class="span4"></div>
			</div>
			</fieldset>
			</form:form>
		</div> --%>
		<textarea type="text" id="txtJson" style="display:none; width:100%"></textarea>
	</div>
</div>
<div class="bottom-border">&nbsp;</div>

<script type="text/javascript">

	$(document).ready(
			function() { 
				alert('${selectedContractNumber}');
				if('${selectedContractNumber}' != ''){
					$("#MainContractNo").val('${selectedContractNumber}');
				}
					
				setEmailRequired();
				
				$("#MainContractNo").change(function() {
					console.log("contract change..");
					$.getJSON('${findBillDispatchMethodsByContractNumberURL}', {
						contractNumber : $(this).val(),
						ajax : 'true'
					}, function(data) {
						console.log("contract change: returned data: " + data);
						var html=' '; 
						$("#BillListBody").empty();
						if(data.length == 0){
							console.log("empty empty");
							$("#BillListBody").append('<tr class="active" id="BillListEmpty" style="display:none;">	<td colspan="3" rowspan="6"><s:message code="empty.list.message" /></td></tr>');
							 
							
						}else{ 
							var len = data.length;
							for ( var i = 0; i < len; i++) {
								html += '<tr class="active">';
								html +='<td>';
								data[i].contact = data[i].contact != null ? data[i].contact : ' ';
								if(data[i].selected == true){

									html +='<input type="checkbox" class="form-control" id="chbx'+ data[i].dispatchMethod +'" value="'+ data[i].dispatchMethod +'" checked="checked">&nbsp; '+ data[i].dispatchName;
								}else{
									html +='<input type="checkbox" class="form-control" id="chbx'+ data[i].dispatchMethod +'" value="'+ data[i].dispatchMethod +'" >&nbsp; '+ data[i].dispatchName;
								}
								html +='</td>';
								
								html += '<td>'; 
								if(data[i].dispatchMethod != "BD03"){
									html += '<input class="form-control" id="txt'+ data[i].dispatchMethod +'" type="text" value="'+ data[i].contact +'" cssErrorClass="form-control has-errors" >';
								}
								html +='</td>'; 
								html +='<td></td>';
								html += '</tr>';
							}
							$("#BillListBody").append(html); 
						} 
						 
					});
			    });
				
				$("#btnSubmit").click(
						function()
						{
							console.log("btnSubmit click..");
							$('#successMsg').empty();
							if($('#chbxBD01')[0].checked !=true && $('#chbxBD02')[0].checked !=true && $('#chbxBD03')[0].checked !=true){
								 
								$('#successMsg').append('<span class="alert alert-warning"><s:message code="billdispatch.nothingselected.message" /></span>');
								 
							}else{
								
								if($('#chbxBD02')[0].checked){
									if(!isEmail($('#txtBD02').val())){
										$('#successMsg').append('<span class="alert alert-warning"><s:message code="billdispatch.emailwrong.message" /></span>');
										$('.alert').show().fadeOut(3000);
										return;
									}
								} 
								
								if($('#chbxBD01')[0].checked){
									if(!isPhoneNo($('#txtBD01').val())){
										$('#successMsg').append('<span class="alert alert-warning"><s:message code="billdispatch.phonewrong.message" /></span>');
										 
										return;
									}
								} 
							var jsonString='[';
							//PAPER BILL DISPATCH
							jsonString += '{';
							jsonString += '"dispatchMethod" : "' + $('#chbxBD03').val() +'"';
							jsonString += ',';
							jsonString += ' "contractNumber" : "'+ $('#MainContractNo').val() +'"';
							jsonString += ' ,';
							jsonString += ' "contact" : " "'; 
							jsonString += ' ,';
							jsonString += ' "selected" : ' + $('#chbxBD03')[0].checked;
							jsonString += ' }';
							
							//seperator
							jsonString += ' ,';
							
							//EMAIL BILL DISPATCH
							jsonString += ' {';
							jsonString += ' "dispatchMethod" : "' + $('#chbxBD02').val() +'"';
							jsonString += ' ,';
							jsonString += ' "contractNumber" : "'+ $('#MainContractNo').val() +'"';
							jsonString += ' ,';
							jsonString += ' "contact" : "' + $('#txtBD02').val() +'"';
							jsonString += ' ,';
							jsonString += ' "selected" : ' + $('#chbxBD02')[0].checked;
							jsonString += ' }';
							
							//seperator
							jsonString += ' ,';
							
							//SMS BILL DISPATCH
							jsonString += ' {';
							jsonString += ' "dispatchMethod" : "' + $('#chbxBD01').val() +'"';
							jsonString += ' ,';
							jsonString += ' "contractNumber" : "'+ $('#MainContractNo').val() +'"';
							jsonString += ' ,';
							jsonString += ' "contact" : "' + $('#txtBD01').val() +'"';
							jsonString += ' ,';
							jsonString += ' "selected" : ' + $('#chbxBD01')[0].checked;
							jsonString += ' }';
							
							//end Json
							jsonString += ' ]';
							$('#txtJson').val(jsonString);
							
							$.getJSON('${UpdateBillDispatchMethodsByContractNumberURL}', {
								contractNumber : $('#MainContractNo').val(),
								billDispatchString : $('#txtJson').val(),
								ajax : 'true'
							}, function(data) {
								console.log("contract change: returned data: " + data);
								var html;  
								$('#successMsg').append('<span class="alert alert-success"><s:message code="billdispatch.saved.message" /></span>');
								 
							});
							
							}
							
						}
				);
				
				$("#chbxBD02").change(function() {
					setEmailRequired();
			    });
				
				function setEmailRequired(){
					if($('#chbxBD02')[0].checked==true){
						$("#txtBD02").attr("required","required");
						$("#txtBD01").attr("required","required");
					}else{
						$("#txtBD02").removeAttr("required");
						$("#txtBD01").attr("required","required");
					}
					
				}
				function isEmail(email) {
					  var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
					  return regex.test(email);
					}
				function isPhoneNo(phone) {
					  var regex = /(^07\d{8})/g;//07 followed by 8 digits
					  return regex.test(phone);
					}
		});
</script>