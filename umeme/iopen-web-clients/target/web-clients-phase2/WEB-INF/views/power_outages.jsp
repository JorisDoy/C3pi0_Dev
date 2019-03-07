<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<style>
.pagination {
	display: inline-block;
	padding-left: 0;
	margin: 20px 0;
	border-radius: 4px
}

.pagination>li {
	display: inline
}

.pagination>li>a, .pagination>li>span {
	position: relative;
	float: left;
	padding: 6px 12px;
	margin-left: -1px;
	line-height: 1.42857143;
	color: #337ab7;
	text-decoration: none;
	background-color: #fff;
	border: 1px solid #ddd
}

.pagination>li:first-child>a, .pagination>li:first-child>span {
	margin-left: 0;
	border-top-left-radius: 4px;
	border-bottom-left-radius: 4px
}

.pagination>li:last-child>a, .pagination>li:last-child>span {
	border-top-right-radius: 4px;
	border-bottom-right-radius: 4px
}

.pagination>li>a:focus, .pagination>li>a:hover, .pagination>li>span:focus,
	.pagination>li>span:hover {
	z-index: 3;
	color: #23527c;
	background-color: #eee;
	border-color: #ddd
}

.pagination>.active>a, .pagination>.active>a:focus, .pagination>.active>a:hover,
	.pagination>.active>span, .pagination>.active>span:focus, .pagination>.active>span:hover
	{
	z-index: 2;
	color: #fff;
	cursor: default;
	background-color: #337ab7;
	border-color: #337ab7
}

.pagination>.disabled>a, .pagination>.disabled>a:focus, .pagination>.disabled>a:hover,
	.pagination>.disabled>span, .pagination>.disabled>span:focus,
	.pagination>.disabled>span:hover {
	color: #777;
	cursor: not-allowed;
	background-color: #fff;
	border-color: #ddd
}

.pagination-lg>li>a, .pagination-lg>li>span {
	padding: 10px 16px;
	font-size: 18px;
	line-height: 1.3333333
}

.pagination-lg>li:first-child>a, .pagination-lg>li:first-child>span {
	border-top-left-radius: 6px;
	border-bottom-left-radius: 6px
}

.pagination-lg>li:last-child>a, .pagination-lg>li:last-child>span {
	border-top-right-radius: 6px;
	border-bottom-right-radius: 6px
}

.pagination-sm>li>a, .pagination-sm>li>span {
	padding: 5px 10px;
	font-size: 12px;
	line-height: 1.5
}

.pagination-sm>li:first-child>a, .pagination-sm>li:first-child>span {
	border-top-left-radius: 3px;
	border-bottom-left-radius: 3px
}

.pagination-sm>li:last-child>a, .pagination-sm>li:last-child>span {
	border-top-right-radius: 3px;
	border-bottom-right-radius: 3px
}

.pager {
	padding-left: 0;
	margin: 20px 0;
	text-align: center;
	list-style: none
}

.pager li {
	display: inline
}

.pager li>a, .pager li>span {
	display: inline-block;
	padding: 5px 14px;
	background-color: #fff;
	border: 1px solid #ddd;
	border-radius: 15px
}

.pager li>a:focus, .pager li>a:hover {
	text-decoration: none;
	background-color: #eee
}

.pager .next>a, .pager .next>span {
	float: right
}

.pager .previous>a, .pager .previous>span {
	float: left
}

.pager .disabled>a, .pager .disabled>a:focus, .pager .disabled>a:hover,
	.pager .disabled>span {
	color: #777;
	cursor: not-allowed;
	background-color: #fff
}
</style>

<div class="row-fluid">
	<div class="span12 post-page"  style="margin-bottom:0px;">
		<h3 class="module-title-short">
			<span class="selected"><s:message
					code="poweroutage.outagecombined.title" /></span>
		</h3>
		<div class="row-fluid" style="display: none;"></div>
		<div class="row-fluid">
			<form:form method="POST" commandName="powerOutageFilter" id="power-outage-filter-form" 
				cssClass=" register" acceptCharset="ISO-8859-1" style="padding:5px;">
				<form:errors path="*" element="div" cssClass="formGroup has-errors" />
				<p class="has-errors">
					<c:out value="${errorInfo.message}"></c:out>
					<!-- private Date startDate = null;
	private String startDateString = null;
	private Date endDate = null;
	private String endDateString = null;
	private BigDecimal district = null; 
	-->
				</p>
				<fieldset>
					<legend>
						<s:message code="poweroutage.formfilter.text" />
					</legend>
					<div class="row-fluid">
						<div class="span4">
							<div class="formGroup">
								<form:label path="outageType" cssErrorClass="has-errors">
									<s:message code="poweroutage.outagetype.label" />
								</form:label>
								<form:select path="outageType" cssClass="form-control text-uppercase"
									cssErrorClass="form-control has-errors" id="outagetype"
									required="required">
									<form:option value="0">
										<s:message code="poweroutage.alloutage.text" />
									</form:option>
									<form:option value="1">
										<s:message code="poweroutage.plannedoutage.text" />
									</form:option>
									<form:option value="2">
										<s:message code="poweroutage.unplannedoutage.text" />
									</form:option>
								</form:select>
								<form:errors path="outageType" cssClass="has-errors" element="span" />
							</div>
						</div>
						<div class="span4">
							<div class="formGroup">
								<form:label path="district" cssErrorClass="has-errors">
									<s:message code="complaint.district.label" />
								</form:label>
								<form:select path="district"
									cssClass="form-control text-uppercase"
									cssErrorClass="form-control has-errors" id="district"
									required="required" placeholder="district">
									<form:option value="0">
										ALL
									</form:option>
									<c:forEach items="${districts}" var="district">
										<form:option value="${district.id.nroCentro}"
											label="${district.nomCentro}" />
									</c:forEach>
								</form:select>
								<form:errors path="district" cssClass="has-errors"
									element="span" />
							</div>

						</div>
						<div class="span4">
							<div class="formGroup">
								<form:label path="status" cssErrorClass="has-errors">
									<s:message code="poweroutage.outagestatus.label" />
								</form:label>
								<form:select path="status" cssClass="form-control text-uppercase"
									cssErrorClass="form-control has-errors" id="outagestatus"
									required="required">
									<c:forEach items="${powerOutageStatuses}" var="status">
										<form:option value="${status.codigo}"
											label="${status.descripcion}" />
									</c:forEach>
									
									<%-- <form:option value="0">
										<s:message code="poweroutage.plannedoutage.text" />ALL
									</form:option>
									<form:option value="5">
										<s:message code="poweroutage.plannedoutage.text" />RESTORED
									</form:option>
									<form:option value="2">
										<s:message code="poweroutage.plannedoutage.text" />ACTIVE
									</form:option>
									<form:option value="1">
										<s:message code="poweroutage.plannedoutage.text" />NEW
									</form:option>
									<form:option value="0">
										<s:message code="poweroutage.unplannedoutage.text" />TEAM SENT
									</form:option> --%>
								</form:select>
								<form:errors path="status" cssClass="has-errors" element="span" />
							</div>
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
								<form:errors path="startDateString" cssClass="has-errors"
									element="span" />
							</div>
						</div>
						<div class="span4">
							<div class="formGroup">
								<form:label path="endDateString">
									<s:message code="poweroutage.planned.enddate" />

								</form:label>
								<div class="input-append date" id="endDate" data-date=""
									data-date-format="dd/mm/yyyy">
									<form:input path="endDateString" type="text" id="endDateString"
										cssClass="form-control"
										cssErrorClass="form-control has-errors" role="aria"
										required="true" />

									<span class="add-on"><i class="icon-calendar"></i></span>
								</div>
								<form:errors path="endDateString" cssClass="has-errors"
									element="span" />
							</div>
						</div>
						<div class="span4" style="vertical-align: bottom;">
							<div class="formGroup">
								<form:label path="endDateString">

								</form:label>
								<button class="btn btn-lg btn-primary btn-block" type="submit">
									<s:message code="filter.text" />
								</button>
							</div>
						</div>
					</div>
					
					<div class="formGroup" hidden="true">
						<form:input path="page" cssClass="form-control text-uppercase"
							cssErrorClass="form-control has-errors" id="page"
							placeholder="page" hidden="true" />
		
					</div>
				</fieldset>
			</form:form>
		</div>
		<div class="row-fluid" id="plannedlist">
			<div class="span12">
				<table class="table table-condensed table-hover" style="font-size: 12px;">
					<thead>
						<tr>
							<th><s:message code="poweroutage.region.label" /></th>
							<th><s:message code="complaint.district.label" /></th>
							<th><s:message code="poweroutage.substation.label" /></th>
							<th><s:message code="poweroutage.feeder.label" /></th>
							<th><s:message code="poweroutage.outagestatus.label" /></th>
							<th><s:message code="poweroutage.voltage.label" /></th>
							<th><s:message code="poweroutage.scope.label" /></th>
							<th><s:message code="poweroutage.plannedDay.label" /></th>
							<th><s:message code="poweroutage.plannedDate.label" /></th>
							<th><s:message code="poweroutage.comment.label" /></th>
							<th>&nbsp;</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${outages}" var="outage">
							<tr class="active">
								<td>${outage.region}</td>
								<td>${outage.powerOutageInstallationInfo.district}</td>
								<td>${outage.powerOutageInstallationInfo.substation}</td>
								<td>${outage.powerOutageInstallationInfo.feeder}</td>
								<td>${outage.powerOutageIncidentInfo.status}</td>
								<td>${outage.voltage}</td>
								<td>${outage.scope}</td>
								<td>${outage.powerOutageIncidentInfo.plannedDay}</td>
								<td>${outage.powerOutageIncidentInfo.plannedDate}</td>
								<td>${outage.powerOutageIncidentInfo.comment}</td>
								<td><a href="<c:url value="/client/outages/${outage.incidentId}"/>"> <s:message
											code="poweroutage.view.label" /></a></td>

							</tr>
						</c:forEach>
						<c:if test="${empty(outages)}">

							<tr class="active">
								<td colspan="11" rowspan="6"><s:message
										code="empty.list.message" /></td>
							</tr>
						</c:if>
						<tr>
							<td colspan="11" rowspan="4"></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>

<c:if test="${noOfPages>1}">
			<nav>
				<ul class="pagination">

					<c:set var="previousLinkDisable" value="" />
					<c:set var="nextLinkDisable" value="" />
					<c:if test="${page==1}">
						<c:set var="previousLinkDisable" value="disabled" />
					</c:if>
					<c:if test="${page==noOfPages}">
						<c:set var="nextLinkDisable" value="disabled" />
					</c:if>

					<li class="${previousLinkDisable}"><a id="pagePrevious" href="#"
						aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
					</a></li>

					<c:forEach begin="1" end="${noOfPages}" step="1" var="i">
						<c:set var="activeClass" value="" />
						<c:if test="${i==page}">
							<c:set var="activeClass" value="active" />
						</c:if>
						<li class="${activeClass}"><a id="page${i}" class="pageclass"
							href="#"><c:out value="${i}" /></a></li>
					</c:forEach>

					<li class="${nextLinkDisable}"><a id="pageNext"
						href="#"
						aria-label="Next"> <span aria-hidden="true">&raquo;</span>
					</a></li>
				</ul>
			</nav>
		</c:if>
		
<div class="bottom-border">&nbsp;</div>
<script type="text/javascript"
	src='<s:url value="/resources/assets/js/bootstrap-datepicker.js"></s:url>'>
	
</script>
<script type="text/javascript">
	$(document).ready(
			function() {
				/*  var nowTemp = new Date();
				 var now = new Date(nowTemp.getFullYear(), nowTemp.getMonth(), nowTemp.getDate(), 0, 0, 0, 0); */

				var checkin = $('#startDate').datepicker({
					onRender : function(date) {
						return '';//date.valueOf() < now.valueOf() ? 'disabled' : '';
					}
				}).on('changeDate', function(ev) {
					if (ev.date.valueOf() > checkout.date.valueOf()) {
						var newDate = new Date(ev.date)
						newDate.setDate(newDate.getDate() + 1);
						checkout.setValue(newDate);
					} else {
						var newDate = new Date(checkout.date)
						checkout.setValue(newDate);
					}
					checkin.hide();
					$('#endDate')[0].focus();
				}).data('datepicker');
				var checkout = $('#endDate')
						.datepicker(
								{
									onRender : function(date) {
										return date.valueOf() <= checkin.date
												.valueOf() ? 'disabled' : '';
									}
								}).on('changeDate', function(ev) {
							checkout.hide();
						}).data('datepicker');
				
				
				/*Paginations*/				
				$('.pageclass').click(function() {
					pageNo = $(this).text()
					$("#page").val(pageNo);
					$("#power-outage-filter-form")[0].submit();
				});
				
				$('#pagePrevious').click(function() {
					pageNo = $("#page").val();
					
					if(pageNo > 1){
						$("#page").val(pageNo - 1);
						$("#power-outage-filter-form")[0].submit();
					}			
				});
				
				$('#pageNext').click(function() {
					
					pages = '${noOfPages}';
					pageNo = $("#page").val();			
					if(pageNo < pages){
						$("#page").val(parseInt(pageNo) + 1);
						$("#power-outage-filter-form")[0].submit();
					}
				});

			});

	
</script>