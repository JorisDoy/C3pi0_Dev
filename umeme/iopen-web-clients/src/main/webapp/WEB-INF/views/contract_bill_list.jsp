<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<!-- <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"> -->

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
<div class="row-fluid">
	<div class="span12 post-page">
		<h3 class="module-title-short">
			<span class="selected"><s:message code="billList.title" /></span>
		</h3>

		<form:form id="bill-filter" method="POST"
			commandName="contractNumberYearFilter" acceptCharset="ISO-8859-1"
			style="padding:5px;">

			<div class="row-fluid">
				
				
				<div class="span5" style="margin-left: 0px;">
					<div class="formGroup">
						<form:label path="billContractNumber" cssErrorClass="has-errors">
							<s:message code="billform.contractnumber.text" />
						</form:label>
						<form:select path="billContractNumber"
							cssClass="form-control text-uppercase"
							cssErrorClass="form-control has-errors" id="contractNumber"
							required="required" placeholder="contract.." style="width:90%;">
							<c:forEach items="${contracts}" var="contract">
								<form:option value="${contract.contractNumber}"
									label="${contract.contractNumberWithDescription}" />
							</c:forEach>
						</form:select>
						<form:errors path="billContractNumber" cssClass="has-errors"
							element="span" />
					</div>
				</div>
				<c:url var="findContractYearsURL" value="/client/contract/billyears" />
				<div class="span4" style="margin-left: 0px;">
					<div class="formGroup">
						<form:label path="billYear" cssErrorClass="has-errors">
							<s:message code="billform.year.text" />
						</form:label>
						<form:select path="billYear"
							cssClass="form-control text-uppercase"
							cssErrorClass="form-control has-errors" id="year"
							placeholder="year.."  style="width:80%;">
							<form:option value="ALL" label="ALL" />
							<c:forEach items="${years}" var="item">
								<form:option value="${item}" label="${item}" />
							</c:forEach>
						</form:select>
						<form:errors path="billYear" cssClass="has-errors" element="span" />

					</div>
				</div>
				<div class="span3" style="margin-left: 0px;">
					<div class="formGroup">
						<form:label path="billYear" cssErrorClass="has-errors">

						</form:label>
						<button class="btn btn-lg btn-primary" type="submit" name="method"
							style="min-width: 178px">Search</button>
					</div>
				</div>
				<div class="formGroup" hidden="true">
					<form:input path="page" cssClass="form-control text-uppercase"
						cssErrorClass="form-control has-errors" id="page"
						placeholder="page" hidden="true" />

				</div>

			</div>
			<div class="row-fluid">
				<div class="span4">
				<ul class="nav nav-pills">
					<li role="presentation" class="active"><a href="#"><s:message
								code="bill.billList.nav_button.text" /></a></li>
					<li role="presentation"><a id="bill-graph"
						href="<c:url value="/"/>"><s:message
								code="bill.billGraph.nav_button.text" /></a></li>
				</ul>
				</div>
				
				<div class="span8">
					<div class="formGroup">
						<form:errors path="*" cssClass="has-errors" element="span" />
						<p class="has-errors">
							<c:out value="${errorInfo.message}"></c:out>
						</p>
					</div>
				</div>
			</div>
		</form:form>

		<div class="row-fluid">
			<div class="span12 post-page">
				<div class="panel panel-default panel-size">
					<div class="panel-body">
						<table class="table table-condensed table-hover">
							<thead>
								<tr>
									<th><s:message code="bill.billingDate.label" /></th>
									<th><s:message code="bill.billNumber.label" /></th>
									<%-- <th><s:message code="bill.typeOfBill.label" /></th> --%>
									<th><s:message code="bill.billStatus.label" /></th>
									<th><s:message code="bill.billAmount.label" /></th>
									<th><s:message code="bill.paidAmount.label" /></th>
									<th><s:message code="bill.outstandingAmount.label" /></th>
									<%-- <th><s:message code="bill.billStatementId.label" /></th> --%>
									<th>&nbsp;</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${contractBills}" var="bill">

									<tr class="active">

										<td>${bill.billingDate}</td>
										<td>${bill.billNumber}</td>
										<%-- <td>${bill.typeOfBill}</td> --%>
										<td>${bill.billStatus}</td>

										<td style="text-align: right;"><fmt:formatNumber
												type="number" maxFractionDigits="2" minFractionDigits="2"
												value="${bill.billAmount}" /></td>
										<td style="text-align: right;"><fmt:formatNumber
												type="number" maxFractionDigits="2" minFractionDigits="2"
												value="${bill.paidAmount}" /></td>
										<td style="text-align: right;"><fmt:formatNumber
												type="number" maxFractionDigits="2" minFractionDigits="2"
												value="${bill.outstandingAmount}" /></td>

										<%-- <td>${bill.billStatementId}</td> --%>
										<td><a
											href="<c:url value="/client/bill/download/"/>${bill.billStatementId}">
												<s:message code="billList.view.text" />
										</a></td>
										<!-- <td><a
											href="<c:url value="/client/bill/download/view?billNumber="/>${bill.billNumber}">
												<s:message code="billList.view.text" />
										</a></td> -->

									</tr>
								</c:forEach>
								<c:if test="${empty(contractBills)}">

									<tr class="active">
										<td colspan="7" rowspan="6"><s:message
												code="empty.list.message" /></td>
									</tr>
								</c:if>
							</tbody>
						</table>
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

							<li class="${previousLinkDisable}"><a id="pagePrevious"
								href="#" aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							</a></li>

							<c:forEach begin="1" end="${noOfPages}" step="1" var="i">
								<c:set var="activeClass" value="" />
								<c:if test="${i==page}">
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
				<div class="bottom-border">&nbsp;</div>
			</div>
		</div>
	</div>
</div>


<script type="text/javascript">
	$(document)
			.ready(
					function() {

						$('#bill-graph')
								.click(
										function() {
											var s = 'client/specific/billinginfo/graphical?contractNumber='
													+ $('#contractNumber')
															.val()
													+ '&year='
													+ $('#year').val();
											$(this).attr('href',
													$(this).attr('href') + s);
										});

						$('#contractNumber')
								.change(
										function() {
											console
													.log("contractNumber change..");
											$
													.getJSON(
															'${findContractYearsURL}',
															{
																contractNumber : $(
																		this)
																		.val(),
																ajax : 'true'
															},
															function(data) {
																console
																		.log("contractNumber change: returned data: "
																				+ data);
																var html = '<option value="ALL">ALL</option>';
																var len = data.length;
																for (var i = 0; i < len; i++) {
																	html += '<option value="' + data[i] + '">'
																			+ data[i]
																			+ '</option>';
																}
																html += '</option>';

																$('#year')
																		.html(
																				html);
															});
										});

						$('.pageclass').click(function() {
							pageNo = $(this).text()
							$("#page").val(pageNo);
							$("#bill-filter")[0].submit();
						});

						$('#pagePrevious').click(function() {
							pageNo = $("#page").val();

							if (pageNo > 1) {
								$("#page").val(pageNo - 1);
								$("#bill-filter")[0].submit();
							}
						});

						$('#pageNext').click(function() {

							pages = '${noOfPages}';
							pageNo = $("#page").val();
							if (pageNo < pages) {
								$("#page").val(parseInt(pageNo) + 1);
								$("#bill-filter")[0].submit();
							}
						});

					});
</script>