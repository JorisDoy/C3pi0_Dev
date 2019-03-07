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

.nav{
	margin-bottom: 0px;
}
</style>

<div id="main" class="wrap post-template">
	<div class="container">
		<div class="row-fluid">
			<div class="span12 post-page">
				<ul class="nav nav-tabs"> 
					<li class="active"><a href="<c:url value="/employee/applications"/>"><s:message code="application.search.title" /></a></li>	
					<%-- <li><a href="<c:url value="/employee/applications/currentStageApplicationNumberFilters"/>"><s:message code="employee.applicationstage.search" /></a></li> --%>
					<li><a href="<c:url value="/employee/inspection/rejectedinspections"/>"><s:message code="employee.rejectedinspection.stage" /></a></li>
					<li><a href="<c:url value="/employee/inspection/pendingscheduling?schedule=false"/>"><s:message code="inspection.schedule.tab" /></a></li>
					<li><a href="<c:url value="/employee/inspection/pendinginspection?schedule=true"/>"><s:message code="inspection.scheduleexpecting.tab" /></a></li>	
					<li><a href="<c:url value="/employee/connection/pendingscheduling?schedule=false"/>"><s:message code="connection.notscheduled.tab" /></a></li>
					<li><a href="<c:url value="/employee/connection/pendingconnection?schedule=true"/>"><s:message code="connection.scheduleexpecting.tab" /></a></li>
					<li><a href="<c:url value="/employee/batch/list"/>"><s:message code="iopen.batch.title" /></a></li>
												
				</ul> 
				<div class="row-fluid">
				<div class="span3">
				<h3 class="module-title-short">
					<span class="selected"><s:message code="employee.application.search" /></span>
				</h3>
				</div>
				 
				</div>
				<!-- <div class="row-fluid"> 
				<div class="span2">
					<input type="radio" name="search_option" id="district_status_radio" value="1" checked="checked"> District & Status
				</div>
				<div class="span2">
					<input type="radio" name="search_option" id="application_no_radio" value="2"> Application No 
				</div>
				<div class="span2">
					<input type="radio" name="search_option" id="tracking_no_radio" value="3"> Tracking No 
				</div>
				<div class="span2">
					<input type="radio" name="search_option" id="id_no_passport_radio" value="4"> ID No/Passport
				</div>
				</div>
				<hr/> -->
				<div class="panel panel-default panel-size">
					<div class="panel-body">
						<form:form method="POST" commandName="applicationListFilter"
							cssClass="form-horizontal" id="applicationListFilterID">
							<div class="row-fluid">
							<div class="span3">
									<div class="formGroup">
										<form:label path="district" cssErrorClass="has-errors">
											<s:message code="application.district.label" />
										</form:label>									
										<form:select path="district" cssClass="form-control text-uppercase"
											cssErrorClass="form-control has-errors" id="district"
											required="required" placeholder="district">
											<form:option value="0" label="ALL" /> 
										<c:forEach items="${companyDistricts}" var="district">
											<form:option value="${district.codUnicom}"
												label="${district.nomUnicom}" />
										</c:forEach>										
										</form:select>

										<form:errors path="district" cssClass="has-errors"
											element="span" />
									</div>
								</div>
							<%-- 	<div class="span4">
									<div class="formGroup">
										<form:label path="*" cssErrorClass="has-errors">
											<s:message code="application.district.label" />
										</form:label>
										<form:select path="*" cssClass="form-control text-uppercase"
											cssErrorClass="form-control has-errors" id="district"
											required="required" placeholder="district">
											<form:option value="0" label="ALL" />
										<c:forEach items="${districts}" var="district">
											<form:option value="${district.codMunic}"
												label="${district.nomMunic}" />
										</c:forEach>										
										</form:select>

										<form:errors path="district" cssClass="has-errors"
											element="span" />
									</div>
								</div> --%>
								<div class="span3">
									<div class="formGroup">
										<form:label path="applicationStatus"
											cssErrorClass="has-errors">
											<s:message code="application.status.label" />
										</form:label>
										<form:select path="applicationStatus" cssClass="form-control text-uppercase"
											cssErrorClass="form-control has-errors"
											id="applicationStatus" placeholder="status">
											<form:option value="ALL" label="ALL" />
										<c:forEach items="${statuses}" var="status">
											<form:option value="${status.statusCode}"
												label="${status.statusDescription}" />
										</c:forEach>
										</form:select>

										<form:errors path="applicationStatus" cssClass="has-errors"
											element="span" />
									</div>
								</div>
								
								
								<div class="span3">
									<div class="form-group"> 
										<form:label path="applicationNumber">
											<s:message code="applicationlist.number.label" />
										</form:label>
										<form:input path="applicationNumber" cssClass="form-control text-uppercase"
											cssErrorClass="form-control has-errors" id="applicationNumber" placeholder="applicationNumber" />
										<form:errors path="applicationNumber" cssClass="has-errors"
											element="span" />
									</div>
								</div>
								<div class="span2">
									<div class="form-group"> 
										<form:label path="trackingNumber">
											<s:message code="applicationlist.iopentackingno.label" />
										</form:label>
										<form:input path="trackingNumber" cssClass="form-control text-uppercase"
											cssErrorClass="form-control has-errors" id="trackingNumber" placeholder="trackingNumber" />
										<form:errors path="trackingNumber" cssClass="has-errors"
											element="span" />
									</div>
								</div>
								
							</div>
							<hr />
							<div class="row-fluid">
								<div class="span2">
									<div class="form-group">
										<form:radiobutton path="documentType" cssClass="form-control text-uppercase"
											cssErrorClass="form-control has-errors" id="passport" value='${defaultValues.get("application_passport_value")}' />
										<s:message code="application.passportidentity.label" />
										<form:errors path="documentType" cssClass="has-errors"
											element="span" />
									</div>
								</div>
								<div class="span2">
									<div class="form-group">
										<form:radiobutton path="documentType" cssClass="form-control text-uppercase" checked="checked"
											cssErrorClass="form-control has-errors" id="idno" value='${defaultValues.get("application_idnumber_value")}' />
										<s:message code="application.ididentity.label" />
										<form:errors path="documentType" cssClass="has-errors"
											element="span" />
									</div>
								</div>
								<div class="span4">
									<div class="form-group">
										<%-- <form:label path="idNumber" cssErrorClass="has-errors">
											<s:message code="application.idnumber.label" />
										</form:label> --%>
										<form:input path="idNumber" cssClass="form-control text-uppercase"
											cssErrorClass="form-control has-errors" id="idNumber" placeholder="idNumber" />
										<form:errors path="idNumber" cssClass="has-errors"
											element="span" />
									</div>
								</div>

								<div class="span2">
									<button class="btn btn-lg btn-primary" id="applicationFilterBtnID" type="submit" name="method" value="filter" style="min-width:178px" >
										Filter Applications</button> 
								</div>

								<div class="span2">
									<button class="btn btn-lg btn-primary" type="submit" name="method" value="export" style="min-width:178px" >
										Export List</button> 
								</div>

							</div>
							<div class="formGroup" hidden="true">
								<form:input path="page" cssClass="form-control text-uppercase"
									cssErrorClass="form-control has-errors" id="page"
									placeholder="page" hidden="true" />
			
							</div>
						</form:form>
						<hr />
						<div class="span12" style="overflow: auto;padding-right:5px">
						<table class="table table-condensed table-hover">
							<thead>
								<tr>	
									<th>Tracking No.</th>	
									<th>Application No.</th>					
									<th>Application Date</th>
									<th>Application type</th>
									<th>Current Stage</th>
									<th>Application Status</th>
									<!-- <th>Application Comment</th> -->
									<!-- <th>&nbsp;</th>	 -->
									<th>&nbsp;</th>	
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${applications}" var="application">
									<tr class="active">
										<td>${application.iopenApplication.codApplication}</td>
										<td>${application.applicationNumber}</td>
										<td>${application.applicationDate}</td>
										<td>${application.applicationType}</td>
										<td>${application.applicationCurrentStage}</td>
										<td>${application.applicationStatus}</td>
										<c:if
											test="${(applicationListFilter.district > 0)||(application.applicationStatus =='PENDING REVIEW')}">
											 <td><a href="<c:url value="/employee/application/"/>${application.iopenApplication.codApplication}?complete=true" > Edit</a></td>
										</c:if>
										<c:if
											test="${(applicationListFilter.district == 0)&&(application.applicationStatus !='PENDING REVIEW')}">
											 <td><a href="<c:url value="/employee/application/view/"/>${application.iopenApplication.codApplication}?complete=true" > view</a></td>
										</c:if>
										<%-- <td>${application.applicationComment}</td> --%>
										<%-- <td><a href="<c:url value="/employee/application/"/>${application.iopenApplication.codApplication}?complete=true" > View</a></td> --%>
										
									</tr>
								</c:forEach>
							</tbody>
						</table>'
						
						</div>
					</div>
					<c:if test="${applicationListFilter.noOfPages>1}">
						<nav>
							<ul class="pagination">
	
								<c:set var="previousLinkDisable" value="" />
								<c:set var="nextLinkDisable" value="" />
								<c:if test="${applicationListFilter.page==1}">
									<c:set var="previousLinkDisable" value="disabled" />
								</c:if>
								<c:if test="${applicationListFilter.page==applicationListFilter.noOfPages}">
									<c:set var="nextLinkDisable" value="disabled" />
								</c:if>
	
								<li class="${previousLinkDisable}"><a id="pagePrevious"
									href="#" aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
								</a></li>
	
								<c:forEach begin="1" end="${applicationListFilter.noOfPages}" step="1" var="i">
									<c:set var="activeClass" value="" />
									<c:if test="${i==applicationListFilter.page}">
										<c:set var="activeClass" value="active" />
									</c:if>
									<li class="${activeClass}"><a id="page${i}"
										class="pageclass" href="#"><c:out value="${i}" /></a></li>
								</c:forEach>
	
								<li class="${nextLinkDisable}"><a id="pageNext" href="#"
									aria-label="Next"> <span aria-hidden="true">&raquo;</span>
								</a></li>
							</ul>
						</nav>
					</c:if>
				</div>

				<div class="bottom-border">&nbsp;</div>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">

$(document).ready(function(){
	
	$('.pageclass').click(function() {
		pageNo = $(this).text()
		$("#page").val(pageNo);
		$("#applicationFilterBtnID").click();
	});

	$('#pagePrevious').click(function() {
		pageNo = $("#page").val();

		if (pageNo > 1) {
			$("#page").val(pageNo - 1);
			$("#applicationFilterBtnID").click();
		}
	});

	$('#pageNext').click(function() {

		pages = '${noOfPages}';
		pageNo = $("#page").val();
		if (pageNo < pages) {
			$("#page").val(parseInt(pageNo) + 1);
			$("#applicationFilterBtnID").click();
		}
	});
	/* setSearchOptions();
	
	$("#district_status_radio").change(function() {
		setSearchOptions();
    });
	
	$("#application_no_radio").change(function() {
		setSearchOptions();
    });
	
	$("#tracking_no_radio").change(function() {
		setSearchOptions();
    });
	
	$("#id_no_passport_radio").change(function() {
		setSearchOptions();
    }); */
	
	/* function setSearchOptions(){
		
		if($('#district_status_radio')[0].checked==true){
			$('#district').removeAttr('disabled');
			$('#applicationStatus').removeAttr('disabled');
			$('#applicationNumber').attr('disabled','disabled');
			$('#trackingNumber').attr('disabled','disabled');
			$('#idno').attr('disabled','disabled');
			$('#passport').attr('disabled','disabled');
			$('#idNumber').attr('disabled','disabled');	
		} 
		
		if($('#application_no_radio')[0].checked==true){
			$('#district').attr('disabled','disabled');
			$('#applicationStatus').attr('disabled','disabled');
			$('#applicationNumber').removeAttr('disabled');
			$('#trackingNumber').attr('disabled','disabled');
			$('#idno').attr('disabled','disabled');
			$('#passport').attr('disabled','disabled');	
			$('#idNumber').attr('disabled','disabled');			 
		}
		
		if($('#tracking_no_radio')[0].checked==true){
			$('#district').attr('disabled','disabled');
			$('#applicationStatus').attr('disabled','disabled');
			$('#applicationNumber').attr('disabled','disabled');
			$('#trackingNumber').removeAttr('disabled');
			$('#idno').attr('disabled','disabled');
			$('#passport').attr('disabled','disabled');	
			$('#idNumber').attr('disabled','disabled');	
		}
		
		if($('#id_no_passport_radio')[0].checked==true){
			$('#district').attr('disabled','disabled');
			$('#applicationStatus').attr('disabled','disabled');
			$('#applicationNumber').attr('disabled','disabled');
			$('#trackingNumber').attr('disabled','disabled');
			$('#idno').removeAttr('disabled');
			$('#passport').removeAttr('disabled');
			$('#idNumber').removeAttr('disabled');
		} 
	} */
	
	
});
</script>