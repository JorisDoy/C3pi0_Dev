<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<div id="main" class="wrap post-template">
<div class="container">
	<div class="row-fluid">
		<div class="span3"></div>
		<div class="span9 post-page">
			<form:form method="POST" commandName="signup" cssClass=" register" acceptCharset="ISO-8859-1">
				<form:errors path="*" element="div" cssClass="formGroup has-errors" />
				<p class="has-errors"><c:out value="${errorInfo.message}"></c:out></p>
				<h3 class="module-title-short"><span class="selected"><s:message code="signup.title"/></span></h3>
				<s:message code="signup.existingcustomer.label" />
				<div class="row-fluid">
				<div class="span12">
				<div class="formGroup" id="exisitingCustomerNoformGroup">
				<form:radiobutton path="existingCustomer" cssClass="form-control"
								value="N" cssErrorClass="form-control has-errors"
								id="exisitingCustomerNo" checked="true" />
							<s:message code="signup.existingcustomer.no" />
							<form:errors path="existingCustomer" cssClass="has-errors"
								element="span" />
				</div>
				<div class="formGroup" id="exisitingCustomerYesformGroup">
				<form:radiobutton path="existingCustomer" cssClass="form-control"
								value="Y" cssErrorClass="form-control has-errors"
								id="exisitingCustomerYes" />
							<s:message code="signup.existingcustomer.yes" />
							<form:errors path="existingCustomer" cssClass="has-errors"
								element="span" />
				
				</div>
				</div>
				</div>
				
				<div class="row-fluid">
				<div class="span3">
				<div class="formGroup" id="exisitingcontractNumberformGroup">
				<form:label path="contractNumber" cssErrorClass="has-errors">
									<s:message code="signup.contractnumber.label" />
								</form:label>
								<form:input path="contractNumber" cssClass="form-control"
									cssErrorClass="form-control has-errors" id="contractNumber"
									type="text" required="required"
									placeholder="contract number..." />
								<form:errors path="contractNumber" cssClass="has-errors"
									element="span" />
				
				</div>
				</div>
				<div class="span3">
				<div class="formGroup" id="exisitingidTypeformGroup">
				<form:label path="idType" cssErrorClass="has-errors">
								<s:message code="signup.idtype.label" />
								<span class="has-errors star">*</span>
							</form:label>
							<form:select path="idType"
								cssClass="form-control text-uppercase"
								cssErrorClass="form-control has-errors" id="idType"
								required="required" placeholder="id Type..">
								<form:option value="" label="--- Select ---" />
								<c:forEach items="${idTypes}" var="idType">
									<form:option value="${idType.tipo}"
										label="${idType.descTipo}" />
								</c:forEach>
							</form:select>

							<form:errors path="idType" cssClass="has-errors" element="span" />
				</div>
				</div>	
				<div class="span3">
				<div class="formGroup" id="exisitingidNumberformGroup">
				<form:label path="idNumber" cssErrorClass="has-errors">
								<s:message code="signup.idnumber.label" />
								<span class="has-errors star">*</span>
							</form:label>
							<form:input path="idNumber" cssClass="form-control"
									cssErrorClass="form-control has-errors" id="idNumber"
									type="text" required="required"
									placeholder="id number..." />

							<form:errors path="idNumber" cssClass="has-errors" element="span" />
				</div>
				
				</div>	
				<div class="span3"></div>		
				</div>
				<div class="row-fluid">
					<div class="span3">
						<div class="formGroup">
							<form:label path="email" cssErrorClass="has-errors"><s:message code="email.label"/></form:label>
							<form:input path="email" cssClass="form-control" cssErrorClass="form-control has-errors" id="email"  type="text"  required="required" placeholder="email..."/>
							<form:errors path="email" cssClass="has-errors" element="span"/>
						</div>
				</div>
					<div class="span3">
						<div class="formGroup">
							<form:label path="fullName" cssErrorClass="has-errors"><s:message code="signup.fullname.label"/></form:label>
							<form:input path="fullName" cssClass="form-control" cssErrorClass="form-control has-errors" id="fullName"  type="text"  required="required" placeholder="full name..."/>
							<form:errors path="fullName" cssClass="has-errors" element="span"/>
						</div>					
					</div>
					<div class="span3">						
						<div class="formGroup">
							<form:label path="phoneNumber" cssErrorClass="has-errors"><s:message code="signup.phonenumber.label"/></form:label>
							<form:input path="phoneNumber" cssClass="form-control" cssErrorClass="form-control has-errors" id="phoneNumber"  type="text"  required="required" placeholder="phone number..."/>
							<form:errors path="phoneNumber" cssClass="has-errors" element="span"/>
						</div>
					</div>
					<div class="span3"></div>
				</div>
					<div class="row-fluid">
						<div class="span12">
							
								<div class="formGroup"><span class="img-rounded" style="color:#024930">
									<s:message code="login.password.text1"/></span>
								</div>
						</div>
					
					</div>
				<div class="row-fluid">
					<div class="span3">
						<div class="formGroup">
							<form:label path="password" cssErrorClass="has-errors"><s:message code="password.label"/></form:label>
							<form:input path="password" cssClass="form-control" cssErrorClass="form-control has-errors" id="password"  type="password" required="required" placeholder="password ..."/>
							<form:errors path="password" cssClass="has-errors" element="span"/>
						</div>
					</div>
					<div class="span3">
						<div class="formGroup">
							<form:label path="confirmPassword" cssErrorClass="has-errors"><s:message code="repeat.new.password.label"/></form:label>
							<form:input path="confirmPassword" cssClass="form-control" cssErrorClass="form-control has-errors" id="confirmPassword"  type="password" required="required" placeholder="repeat password ..."/>
							<form:errors path="confirmPassword" cssClass="has-errors" element="span"/>
						</div>					
					</div>					
					<div class="span3"></div>
					<div class="span3"></div>
					</div>
					
					<div class="row-fluid">
					<div class="span2">
					<button class="btn btn-lg btn-primary btn-block" type="submit"><s:message code="signup.submit.value"/></button>
					</div>
					<div class="span3"></div>
					<div class="span3"></div>
					<div class="span4"></div>
					</div>
					
				
		        
			</form:form>
			</div>
		</div>
		
			<div class="bottom-border">&nbsp;</div>
	</div>
</div>
<script type="text/javascript">
$(document).ready(function() {
	
	 if($('#exisitingCustomerNo')[0].checked==true){
		setFieldsForNewCustomer();
	}else{
		setFieldsForExistingCustomer();
	} 
	
	function setFieldsForNewCustomer(){
		$('#exisitingcontractNumberformGroup').hide();
		$('#exisitingidNumberformGroup').hide();
		$('#exisitingidTypeformGroup').hide();
		$('#contractNumber').removeAttr('required');
		$('#idType').removeAttr('required');
		$('#idNumber').removeAttr('required');
	}
	
	function setFieldsForExistingCustomer(){
		$('#exisitingcontractNumberformGroup').show();
		$('#exisitingidNumberformGroup').show();
		$('#exisitingidTypeformGroup').show();	
		$('#contractNumber').attr('required','required');
		$('#idType').attr('required','required');
		$('#idNumber').attr('required','required');	
	}
	
	$('#exisitingCustomerNo').change(function() {
		if($('#exisitingCustomerNo')[0].checked==true){
			setFieldsForNewCustomer();
		} 
    });
	
	$('#exisitingCustomerYes').change(function() {
		if($('#exisitingCustomerYes')[0].checked==true){
			setFieldsForExistingCustomer();
		} 
    }); 
});

</script>