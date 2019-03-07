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
			<div class="span12 post-page">
				<h3 class="module-title-short">
					<span class="selected"><s:message code="mycomplaintlist.title" /></span>
				</h3>
					<div class="row-fluid" style="display:none;"> 
						
					</div>
					<div class="row-fluid"> 
						<form:form method="POST" commandName="complaintFilter" cssClass=" register" id="complaint-filter-form" 
							acceptCharset="ISO-8859-1"  style="padding:5px;">
							<form:errors path="*" element="div" cssClass="formGroup has-errors" />
							<p class="has-errors">
								<c:out value="${errorInfo.message}"></c:out>
							</p>
							<fieldset>
								<legend><s:message code="complaint.listcombined.text" /></legend>
								<div class="row-fluid">
									<div class="span4">
										<div class="formGroup">
											<form:label path="complaintSource" cssErrorClass="has-errors">
												<s:message code="complaint.source.text" />
											</form:label>
											<form:select path="complaintSource" cssClass="form-control text-uppercase"
												cssErrorClass="form-control has-errors" id="complaintsourcefilter"
												required="required">
												<form:option value="0">
													<s:message code="complaint.billsource.text" />
												</form:option>
												<form:option value="1">
													<s:message code="complaint.cmssource.text" />
												</form:option>
											</form:select>
											<form:errors path="complaintSource" cssClass="has-errors" element="span" />
										</div>
									</div> 
					<c:url var="findComplaintTypesByComplaintSourceURL" value="/rest/complaints/complaintTypes" />
									<div class="span4">
										<div class="formGroup">
											<form:label path="complaintType" cssErrorClass="has-errors">
												<s:message code="complaint.complainttype.label" />
											</form:label>
											<form:select path="complaintType" cssClass="form-control text-uppercase"
												cssErrorClass="form-control has-errors" id="complainttypefilter"
												>
												
											</form:select>
											<form:errors path="complaintType" cssClass="has-errors" element="span" />
										</div>
									</div> 
									<div class="span4">
										<div class="formGroup">
											<form:label path="*">
			
											</form:label>
											<button class="btn btn-lg btn-primary btn-block" type="submit">
												<s:message code="filter.text" />
											</button>
										</div>
									</div>
									<div class="formGroup" hidden="true">
										<form:input path="page" cssClass="form-control text-uppercase"
											cssErrorClass="form-control has-errors" id="page"
											placeholder="page" hidden="true" />
						
									</div> 
								</div>
							</fieldset>
						</form:form>						
					</div>
					<div class="row-fluid" id="mycomplainlist"> 
						<div class="span12">
									<table class="table table-condensed table-hover">
										<thead>
											<tr> 
												<th><s:message code="complaint.complaintnumber.label" /></th>
												<th><s:message
														code="complaint.description.label" /></th>
												 <th><s:message code="complaint.complainttype.label" /></th>
												 <th><s:message code="complaint.detectiondate.label" /></th> 
												 <th><s:message code="mycomplaintlist.status.label" /></th>
												<th>&nbsp;</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${complaintList}"
												var="complaint">
												<tr class="active">
													
												<td>${complaint.complaintDetail.complaintNumber}</td>
												<td>${complaint.complaintDetail.comments}</td>
												 <td>${complaint.complaintDetail.complaintTypeDescription}</td>
												 <td>${complaint.complaintDetail.detectionDate}</td> 
												 <td>${complaint.complaintDetail.status}</td>
													<td>
													<!-- Outage e.g /client/complaint/40078-->
													
													<c:if test="${complaint.complaintDetail.complaintSource == 1}">
													<a href="<c:url value="/client/complaint/"/>${complaint.complaintDetail.complaintNumber}">
													<s:message code="mycomplaintlist.view.label" /></a>
													</c:if>
													
													<!-- bills e.g http://localhost:8089/iopen-web-clients/client/complaint/bill/1004-->
													
													<c:if test="${complaint.complaintDetail.complaintSource == 0}">
													<a href="<c:url value="/client/complaint/bill/"/>${complaint.complaintDetail.complaintNumber}">
													<s:message code="mycomplaintlist.view.label" /></a>
													</c:if>
													</td>
													 
												</tr>
											</c:forEach>
											<c:if test="${empty(complaintList)}">
					
												<tr class="active">
													<td colspan="6" rowspan="6"><s:message
															code="empty.list.message" /></td>
												</tr>
											</c:if>
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
<script type="text/javascript">
$(document).ready(function() {
	if($('#complaintsourcefilter').val() !=""){
		console.log("complaint source change.." + $('#complaintsourcefilter').val());
		$.getJSON('${findComplaintTypesByComplaintSourceURL}', {
			source : $('#complaintsourcefilter').val(),
			ajax : 'true'
		}, function(data) { 			
			console.log("complaint source change: returned data: " + data);

			var html = '';
			
			if(data.length == 0){
				 
			}else if(data.length > 0 && $('#complaintsourcefilter').val() == '0'){	
				//bill
				var len = data.length;
				html += '<option value="">ALL</option>';
				for ( var i = 0; i < len; i++) {
					html += '<option value="' + data[i].tipo + '">'
							+ data[i].descTipo + '</option>';
				}
				html += '</option>';
 
				$('#complainttypefilter').html(html);
				 
			}else if(data.length > 0 && $('#complaintsourcefilter').val() == '1'){	
				//outages
				var len = data.length;
				html += '<option value="">ALL</option>';
				for ( var i = 0; i < len; i++) {
					html += '<option value="' + data[i].codigo + '">'
							+ data[i].descripcion + '</option>';
				}
				html += '</option>';
 
				$('#complainttypefilter').html(html);
				
				 
			}
			 
		});
		
	}
	
	$('#complaintsourcefilter').change(	   
			function() { 
				console.log("complaint change..");
				$.getJSON('${findComplaintTypesByComplaintSourceURL}', {
					source : $(this).val(),
					ajax : 'true'
				}, function(data) {
					console.log("complaint change: returned data: " + data);

					var html = '';
					
					if(data.length == 0){
						 
					}else if(data.length > 0 && $('#complaintsourcefilter').val() == '0'){
						//bill
						var len = data.length;
						html += '<option value="">ALL</option>';
						for ( var i = 0; i < len; i++) {
							html += '<option value="' + data[i].tipo + '">'
									+ data[i].descTipo + '</option>';
						}
						html += '</option>';
		 
						$('#complainttypefilter').html(html);
						
						 
					}else if(data.length > 0 && $('#complaintsourcefilter').val() == '1'){	
						//outages
						var len = data.length;
						html += '<option value="">ALL</option>';
						for ( var i = 0; i < len; i++) {
							html += '<option value="' + data[i].codigo + '">'
									+ data[i].descripcion + '</option>';
						}
						html += '</option>';
		 
						$('#complainttypefilter').html(html);
						
						 
					} 
					 
				});
		});
	
	$('.pageclass').click(function() {
		pageNo = $(this).text()
		$("#page").val(pageNo);
		$("#complaint-filter-form")[0].submit();
	});
	
	$('#pagePrevious').click(function() {
		pageNo = $("#page").val();
		
		if(pageNo > 1){
			$("#page").val(pageNo - 1);
			$("#complaint-filter-form")[0].submit();
		}			
	});
	
	$('#pageNext').click(function() {
		
		pages = '${noOfPages}';
		pageNo = $("#page").val();			
		if(pageNo < pages){
			$("#page").val(parseInt(pageNo) + 1);
			$("#complaint-filter-form")[0].submit();
		}
	});
	
	  
});

</script>