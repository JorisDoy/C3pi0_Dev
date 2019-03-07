<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
 
		<div class="row-fluid">
			<div class="span12 post-page">
				<h3 class="module-title-short">
					<span class="selected"><s:message code="poweroutage.unplanned.search.title" /></span>
				</h3>
					<div class="row-fluid" style="display:none;"> 
						
					</div>
					<div class="row-fluid">
						<form:form method="POST" commandName="powerOutageFilter" cssClass=" register"
							acceptCharset="ISO-8859-1"  style="padding:5px;">
							<form:errors path="*" element="div" cssClass="formGroup has-errors" />
							<p class="has-errors">
								<c:out value="${errorInfo.message}"></c:out>
								<!-- private Date startDate = null;
	private String startDateString = null;
	private Date endDate = null;
	private String endDateString = null;
	private BigDecimal district = null; -->
							</p>
							<fieldset>
								<legend><s:message code="poweroutage.formfilter.text" /></legend> 
								<div class="row-fluid"> 
									<div class="span4">
										<div class="formGroup">
											<form:label path="district"
												cssErrorClass="has-errors">
												<s:message code="complaint.district.label" />
											</form:label>
											<form:select path="district"
												cssClass="form-control text-uppercase"
												cssErrorClass="form-control has-errors" id="district"
												required="required" placeholder="district"> 
												<c:forEach items="${districts}" var="district">
													<form:option value="${district.codMunic}"
														label="${district.nomMunic}" />
												</c:forEach>
											</form:select>
											<form:errors path="district" cssClass="has-errors" element="span" />
										</div>
									
									</div>
									<div class="span4"></div>
						<div class="span4">
							
						</div>
								</div>
								<div class="row-fluid">
						<div class="span4">
									<div class="formGroup">
									<form:label path="startDateString">
										<s:message code="poweroutage.planned.startdate" />

									</form:label>
									<div class="input-append date" id="startDate" data-date=""
										data-date-format="dd/mm/yyyy">
										<form:input path="startDateString" type="text"
											id="startDateString" cssClass="form-control"
											cssErrorClass="form-control has-errors" role="aria"
											required="true" />

										<span class="add-on"><i class="icon-calendar"></i></span>
									</div>
									<form:errors path="startDateString"
										cssClass="has-errors" element="span" />
								</div>
									</div>
									<div class="span4">
									<div class="formGroup">
									<form:label path="endDateString">
										<s:message code="poweroutage.planned.enddate" />

									</form:label>
									<div class="input-append date" id="endDate" data-date=""
										data-date-format="dd/mm/yyyy">
										<form:input path="endDateString" type="text"
											id="endDateString" cssClass="form-control"
											cssErrorClass="form-control has-errors" role="aria"
											required="true" />

										<span class="add-on"><i class="icon-calendar"></i></span>
									</div>
									<form:errors path="endDateString"
										cssClass="has-errors" element="span" />
								</div>
									</div> 
									<div class="span4" style="vertical-align:bottom;">
									<div class="formGroup">
									<form:label path="endDateString"> 

									</form:label>
										<button class="btn btn-lg btn-primary btn-block" type="submit">
								<s:message code="filter.text" />
							</button></div>
									</div>
					</div>
							</fieldset>
						</form:form>						
					</div>
					<div class="row-fluid" id="unplannedlist"> 
						<div class="span12">
									<table class="table table-condensed table-hover">
										<thead>
											<tr> 
												<th><s:message code="poweroutage.region.label" /></th>
												<th><s:message code="complaint.district.label" /></th>
												 <th><s:message code="poweroutage.substation.label" /></th>
												 <th><s:message code="poweroutage.feeder.label" /></th> 
												 <th><s:message code="poweroutage.voltage.label" /></th>
												<th><s:message code="poweroutage.scope.label" /></th>
												 <th><s:message code="poweroutage.plannedDay.label" /></th>
												<th><s:message code="poweroutage.plannedDate.label" /></th>
												 <th><s:message code="poweroutage.durationHrs.label" /></th> 
												 <th><s:message code="poweroutage.comment.label" /></th>  
												<th>&nbsp;</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${outages}"
												var="outage">												
												<tr class="active"> 
												<td>${outage.region}</td>
												<td>${outage.powerOutageInstallationInfo.district}</td>
												 <td>${outage.powerOutageInstallationInfo.substation}</td>
												 <td>${outage.powerOutageInstallationInfo.feeder}</td> 
												 <td>${outage.Voltage}</td>
												<td>${outage.scope}</td>
												<td>${outage.powerOutageIncidentInfo.plannedDay}</td>
												 <td>${outage.powerOutageIncidentInfo.plannedDate}</td>
												 <td>${outage.durationHrs}</td> 
												 <td>${outage.powerOutageIncidentInfo.comment}</td>
												 <td><a href="<c:url value=""/>#">
													<s:message code="poweroutage.view.label" /></a></td>
													 
												</tr>
											</c:forEach>
											<c:if test="${empty(outages)}">
												
												<tr class="active">
													<td colspan="11" rowspan="6"><s:message
															code="empty.list.message" /></td>
												</tr>
											</c:if>
											<tr>
												<td colspan="11" rowspan="2"></td>
											</tr>
										</tbody>
									</table>
								</div>
					</div>
			</div>
		</div>
 
				<div class="bottom-border">&nbsp;</div> 
<script type="text/javascript"
	src='<s:url value="/resources/assets/js/bootstrap-datepicker.js"></s:url>'>
    </script>
<script type="text/javascript">
$(document).ready(function() {
   /*  var nowTemp = new Date();
    var now = new Date(nowTemp.getFullYear(), nowTemp.getMonth(), nowTemp.getDate(), 0, 0, 0, 0); */
     
    var checkin = $('#startDate').datepicker({
      onRender: function(date) {
        return '';//date.valueOf() < now.valueOf() ? 'disabled' : '';
      }
    }).on('changeDate', function(ev) {
      if (ev.date.valueOf() > checkout.date.valueOf()) {
        var newDate = new Date(ev.date)
        newDate.setDate(newDate.getDate() + 1);
        checkout.setValue(newDate);
      }else{
    	  var newDate = new Date(checkout.date) 
          checkout.setValue(newDate);
      }
      checkin.hide();
      $('#endDate')[0].focus();
    }).data('datepicker');
    var checkout = $('#endDate').datepicker({
      onRender: function(date) {
        return date.valueOf() <= checkin.date.valueOf() ? 'disabled' : '';
      }
    }).on('changeDate', function(ev) {
      checkout.hide();
    }).data('datepicker');
	  
}); 

</script>