<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>


<link rel="stylesheet"
	href="//cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.css">
<!-- MorrisJs charts -->
<script
	src="//cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.min.js"></script>
<script type='text/javascript'
	src='<s:url value="/resources/assets/js/Chart.js"></s:url>'></script>
<script type='text/javascript'
	src='<s:url value="/resources/assets/js/graph-tools.js"></s:url>'></script>

<div class="row-fluid">
	<div class="span12 post-page">

		<h3 class="module-title-short">
			<span class="selected"><s:message
					code="page.title.mycontract.consumptiongraphical" /></span>
		</h3>
		<div class="panel panel-default panel-size">
			<div class="panel-body">
				<form>
					<div class="row-fluid">
						<div class="span5">
							<div class="formGroup">
								<div class="formGroup">
									<label for="contractNumber"> <s:message
											code="billing.graphical.combo.contract" /> <label> <select
											path="contractNumber" cssClass="form-control"
											cssErrorClass="form-control has-errors" id="contractNumber"
											required="true" placeholder="contract number..."
											style="width: 100%;">
												<select>
								</div>
							</div>
						</div>
						<div class="span4">
							<div class="formGroup">
								<label for="year"> <s:message
										code="billing.graphical.combo.year" /> <label> <select
										path="year" cssClass="form-control"
										cssErrorClass="form-control has-errors" id="year"
										required="true" placeholder="year">
											<select>
							</div>
						</div>
						<div class="span2"></div>
					</div>
					<div class="row-fluid">
						<ul class="nav nav-pills">
							<li role="presentation"><a id="usage-list" 
								href="<c:url value="/"/>"><s:message
										code="consumption.UsageList.nav_button.text" /></a></li>
							<li role="presentation" class="active"><a href="#"><s:message
										code="consumption.UsageGraph.nav_button.text" /></a></li>
						</ul>
					</div>
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

				</form>
				<hr />
				<div class="span12" style="overflow: auto">
					<div id="myfirstchart">
						<canvas id="canvas" width="400" height="400"></canvas>
					</div>
				</div>
			</div>
		</div>

		<div class="bottom-border">&nbsp;</div>
	</div>
</div>

<script>
      window.onload = function(){            
          window.billingData = <c:out value="${jsonGraphicalRepresentation}" escapeXml="false"></c:out>;
          
          if (billingData != null && billingData.contractBillingList!=null && billingData.contractBillingList.length >0 ) {
              
              //populate the contractNumber combo
              for (contract in billingData.contractBillingList) {
                  $('#contractNumber').append($('<option>', {
                      value: contract,
                      text:  billingData.contractBillingList[contract].contractNumber.contractNumberWithDescription
                  }));
              }
              
              //populate the year combo with years available on selected contractNumber
              loadContractNumberAvailableYears($("#contractNumber").val());
              
              //set the selected options
	          var contractNo = billingData.contractNumber;
	          
	          $("#contractNumber option").each(function() {
	        	  if($(this).text() == contractNo) {
	        	    $(this).attr('selected', 'selected');            
	        	  }                        
	        	});
	          
	          $("#year option").each(function() {
	        	  if($(this).text() == billingData.year) {
	        	    $(this).attr('selected', 'selected');            
	        	  }                        
	        	});
	          
              //load Graph with selected data
              loadGraphData($("#contractNumber").val(), 
                            $("#year").val(),
                            'canvas',
                            'units',
                            true);
              
              //To disable the year option if no years are available
              if($("#year").val() == null){
             	 $('#year').prop('disabled', true);
              }
          }
      }
        
     $(document).ready(function() {
    	 
 		$('#usage-list').click(function() {			 
			 var s = 'client/contract/specific/consumption?contractNumber=' + $('#contractNumber option:selected').text().split(" ")[0] + '&year=' + $('#year option:selected').text().split(" ")[0];
			 $(this).attr('href', $(this).attr('href') + s);
	     });
 
         $("#contractNumber").change(function() {
             console.log($(this).val());
             //reload Year combo
             $('#year').find('option').remove().end();
             loadContractNumberAvailableYears($(this).val());
             loadGraphData($(this).val(),
                           $("#year").val(),
                           'canvas',
                           'units',
                           true);
             
           //To disable the year option if no years are available
             if($("#year").val() == null){
            	 $('#year').prop('disabled', true);
             }else{
            	 $('#year').prop('disabled', false);
             }
         });
         $("#year").change(function() {
             console.log($(this).val());
             //reload Year combo
             loadGraphData($("#contractNumber").val(),
                           $(this).val(),
                           'canvas',
                           'units',
                           true);
         });
         
         
         
     });      
</script>