<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
	
<style type="text/css">
	.text-uppercase, H1, H2, TD,TH{
		font-family: "Lato","Helvetica Neue",Helvetica,Arial,sans-serif;  
	}
	TD, TH{ 
		font-size: 13px;
	}
	td{
		line-height:16px !important
	}
	
	@media print { 
     .no-print { display:none; } 
	}

</style>

<div id="main" class="wrap post-template">
<div style="min-height:380px; background-image: url(resources/assets/images/webbanner2.jpg);">
 
	<!-- <img alt="webbanner" src="resources/assets/images/webbanner2.jpg"> -->
</div>	
<br/>

<div style="background-color: #EDF0D3; padding:10px; border-radius: 15px;" >
	<div class="row-fluid">
		<div class="span12">
			<p style="font-weight: bolder;"><s:message code="info.welcomemessage" /></p>
		</div>
	</div>
</div>
	
<div id="umeme_connect" class="container" style="background-color: #EDF0D3; margin-top: 10px;">
		<%-- <div class="row-fluid" style="background-color: white;">
			<div class="span12">
				<a href="#" class="icon-print" style="float: right; color: black; padding-right: 15px;"
					onclick="javascript:window.print();"> <s:message
						code="common.print" /></a>

			</div>
		</div> --%>
		
		<div class="row-fluid" style="background-color: #B3BE34">
			<div class="span10" style="text-align: center;">
				<span>
					<h1 style="color: white;">
						<s:message code="info.getconnectedto" />
						<s:message code="info.umemethreesteps" />
					</h1>
				</span>
			</div>
			<div class = "span2">
				<a id="printBtn" type="button" href="#" style="float: right; color: black; padding-right: 15px;" onclick="PrintElem('#umeme_connect')">
					<!-- onclick="javascript:window.print();"> -->
				<i class="fa fa-print fa-lg"></i>
				<s:message 	code="common.print" /></a>
				<!-- <input type="button" value="Print Div" onclick="PrintElem('#umeme_connect')" /> -->
			</div>
		</div>
		<%-- <div class="row-fluid" style="padding-left: 18px;">
			<div class="span1"></div>
			<div class="span11">
				<h3>
					<s:message code="info.welcomemessage" />
				</h3>
			</div>
		</div> --%>
		<div class="row-fluid" style="padding-left: 10px;">
			<div class="span1"></div>
			<div class="span3">

				<h2 class="text-uppercase" style="color: #AEB400;">
					<s:message code="info.step1" />
				</h2>
				<span class="text-uppercase" style="font-weight: 600;"> <s:message
						code="info.step1title" />
				</span> <br /> <span> <s:message code="info.step1body" />
				</span>


			</div>
			<div class="span3">
				<h2 class="text-uppercase" style="color: #AEB400;">
					<s:message code="info.step2" />
				</h2>
				<span class="text-uppercase" style="font-weight: 600;"> <s:message
						code="info.step2title" />
				</span> <br /> <span> <s:message code="info.step2body" />
				</span>
			</div>
			<div class="span3">
				<h2 class="text-uppercase" style="color: #AEB400;">
					<s:message code="info.step3" />
				</h2>
				<span class="text-uppercase" style="font-weight: 600;"> <s:message
						code="info.step3title" />
				</span> <br /> <span> <s:message code="info.step3body" />
				</span>
			</div>
		</div>
		<div class="row-fluid" style="padding-left: 10px;">
			<div class="span12">
				<br />
			</div>
		</div>
		<div class="row-fluid" style="padding-left: 10px;">
			<div class="span1"></div>
			<div class="span10">
				<span class="text-uppercase" style="font-weight: 600;"> <s:message
						code="info.whatyouneedtitle" />
				</span>
				<ul>
					<li><s:message code="info.whatyouneed1" /></li>
					<li><s:message code="info.whatyouneed2" /></li>
					<li><s:message code="info.whatyouneed3" /></li>
					<li><s:message code="info.whatyouneed4" /></li>
					<li><s:message code="info.whatyouneed5" /></li>
					<%-- <li><s:message code="info.whatyouneed6" /></li>
					<li><s:message code="info.whatyouneed7" /></li> --%>
				</ul>
			</div>
		</div>
		<div class="row-fluid" style="padding-left: 10px;">
			<div class="span1"></div>
			<div class="span10">
				<div class="panel panel-default panel-size">

					<table class="table table-hover">
						<thead>
						</thead>
						<tbody>
							<tr class="active">
								<td colspan="3"><span style="font-weight: 600;"><s:message
											code="common.inspectionfeetext" /></span></td>
							</tr>
							<tr>
								<td><s:message code="common.decriptiontext" /></td>
								<td><s:message code="common.inspectionfeetext" /></td>
								<td></td>
							</tr>
							<tr class="active">
								<td><s:message code="info.inspectiontypea" /></td>
								<td><s:message code="info.inspectiontypeafee" /></td>
								<td></td>
							</tr>
							<tr class="active">
								<td><s:message code="info.inspectiontypeb" /></td>
								<td><s:message code="info.inspectiontypebfee" /></td>
								<td></td>
							</tr>
							<tr class="active">
								<td><s:message code="info.inspectiontypec" /></td>
								<td><s:message code="info.inspectiontypecfee" /></td>
								<td></td>
							</tr>
							<tr class="active">
								<td><s:message code="info.inspectiontyped" /></td>
								<td><s:message code="info.inspectiontypedfee" /></td>
								<td></td>
							</tr>
							<tr class="active">
								<td colspan="3"><span style="font-weight: 600;"><s:message
											code="info.stdnopoleservicetitle" /></span></td>
							</tr>
							<tr>
								<td><s:message code="common.decriptiontext" /></td>
								<td><s:message code="info.capitalcontributiontext" /></td>
								<td><s:message code="info.total" /></td>
							</tr>
							<tr class="active">
								<td><s:message code="info.domesticoutputbasedaid" /></td>
								<td><s:message code="info.domesticoutputbasedaidfee" /></td>
								<td><s:message code="info.domesticoutputbasedaidfee" /></td>
							</tr>
							<tr class="active">
								<td><s:message code="info.domesticnonoutputbasedaid" /></td>
								<td><s:message code="info.domesticnonoutputbasedaidfee" /></td>
								<td><s:message code="info.domesticnonoutputbasedaidfee" /></td>
							</tr>
							<tr class="active">
								<td><s:message code="info.commercialsinglephase" /></td>
								<td><s:message code="info.commercialsinglephasefee" /></td>
								<td><s:message code="info.commercialsinglephasefee" /></td>
							</tr>
							<tr class="active">
								<td colspan="3"><span class="img-rounded"
									style="color: #024930; background-color: #fff"><s:message
											code="info.aboutoba" /></span></td>
							</tr>
							<tr class="active">
								<td colspan="3"><span class="img-rounded"
									style="color: #024930; background-color: #fff"><s:message
											code="info.aboutoba2" /></span></td>
							</tr>
							<tr class="active">
								<td colspan="3"><span style="font-weight: 600;"><s:message
											code="info.stdpoleservicetitle" /></span></td>
							</tr>
							<tr class="active">
								<td><s:message code="info.domesticprepaid" /></td>
								<td><s:message code="info.domesticprepaidfee" /></td>
								<td><s:message code="info.domesticprepaidfee" /></td>
							</tr>
							<tr class="active">
								<td><s:message code="info.commercialsinglephaseprepaid" />
								</td>
								<td><s:message code="info.commercialsinglephaseprepaidfee" />
								</td>
								<td><s:message code="info.commercialsinglephaseprepaidfee" />
								</td>
							</tr>
							<tr class="active">
								<td colspan="3"><span style="font-weight: 600;"><s:message
											code="info.nonStdConnection" /></span></td>
							</tr>
							<tr>
								<td><s:message code="common.decriptiontext" /></td>
								<td><s:message code="info.capitalcontributiontext" /></td>
								<td><span><s:message code="info.securitydeposit" /></span></td>
							</tr>
							<tr class="active">
								<td><s:message code="info.residential2poletitle" /></td>
								<td><s:message code="info.residential2pole" /></td>
								<td><s:message code="info.residential2poledeposit" /></td>
							</tr>
							<tr class="active">
								<td><s:message code="info.smallcommercial1phasetitle" /></td>
								<td><s:message code="info.smallcommercial1phase" /></td>
								<td><s:message code="info.smallcommercial1phasedeposit" /></td>
							</tr>
							<tr class="active">
								<td><s:message code="info.commercial3phasetitle" /></td>
								<td><s:message code="info.commercial3phase" /></td>
								<td><s:message code="info.commercial3phasedeposit" /></td>
							</tr>
							<tr class="active">
								<td><s:message
										code="info.mediumcommercialorindustrialtitle" /></td>
								<td><s:message code="info.mediumcommercialorindustrial" /></td>
								<td><s:message
										code="info.mediumcommercialorindustrialdeposit" /></td>
							</tr>
							<tr class="active">
								<td><s:message code="info.industrialKVAtitle" /></td>
								<td><s:message code="info.industrialKVA" /></td>
								<td><s:message code="info.industrialKVAdeposit" /></td>
							</tr>
						</tbody>
					</table>

				</div>

			</div>
		</div>

		<div class="row-fluid"
			style="padding-left: 10px; margin-bottom: 20px;">
			<div class="span1"></div>
			<div class="span11">
				<span class="text-uppercase" style="font-weight: 600;"> <s:message
						code="info.notetitle" /></span> <br />
				<p>
					<s:message code="info.notebody" />
				</p>
				<p>
					<s:message code="info.notebody2" />
				</p>
				<p style="text-decoration: underline;">
					<i><s:message code="info.obafree" /></i>
				</p>
				<span class="text-uppercase" style="font-weight: 600;"> <s:message
						code="info.obaeligibility" />
				</span>
				<ol style="padding-left: 10px;">
					<li><s:message code="info.obaeligible1" /></li>
					<li><s:message code="info.obaeligible2" /></li>
					<li><s:message code="info.obaeligible3" /></li>
				</ol>
			</div>
		</div>
		<div class="row-fluid"
			style="padding-left: 10px; margin-bottom: 20px;">
			<div class="span1"></div>
			<div class="span11">
				<security:authorize access="isAnonymous()">
					<p>
						<s:message code="info.please" />
						<a href='<s:url value="/user/login"></s:url>'><span><s:message
									code="info.loginlinklink" /> </span></a><span><s:message
								code="info.or" /> </span><a
							href='<s:url value="/user/signup"></s:url>'><span><s:message
									code="info.signuplinktext" /> </span></a><span><s:message
								code="info.toapply" /> </span>
					</p>
				</security:authorize>
			</div>
		</div>
	</div>
	<%-- <div class="container" style="background-color: #EDF0D3;">
		<div class="row-fluid" style="background-color: white;"> 
		<span style="float: right; width:50px;"><a href="#" class="icon-print" style="float: left; background-color:black"
					onclick="javascript:window.print();"></a><span style="">&nbsp;<a href="#" class="icon-print" style="float: left;color:black"
					onclick="javascript:window.print();">&nbsp;<s:message code="common.print" /></a></span></span>	 
		</div>
		<div class="row-fluid" style="background-color: #AEB400">
			<div class="span12" style="text-align: center;">
				<span>
					<h1 style="color: #FFFEFF;">
						<s:message code="info.getconnectedto" />
						<s:message code="info.umemethreesteps" />
					</h1>
				</span>
			</div>
		</div>
		<div class="row-fluid" style="padding-left:10px;">
			<div class="span1"></div>
			<div class="span3">

				<h2 class="text-uppercase" style="color: #AEB400;">
					<s:message code="info.step1" />
				</h2>  <span class="text-uppercase" style="font-weight: 600;">
					<s:message code="info.step1title" />
				</span> <br /> <span> <s:message code="info.step1body" />
				</span>


			</div>
			<div class="span3">
				<h2 class="text-uppercase" style="color: #AEB400;">
					<s:message code="info.step2" />
				</h2>  <span class="text-uppercase" style="font-weight: 600;">
					<s:message code="info.step2title" />
				</span> <br /> <span> <s:message code="info.step2body" />
				</span>
			</div>
			<div class="span3">
				<h2 class="text-uppercase" style="color: #AEB400;">
					<s:message code="info.step3" />
				</h2>  <span class="text-uppercase" style="font-weight: 600;">
					<s:message code="info.step3title" />
				</span> <br /> <span> <s:message code="info.step3body" />
				</span>
			</div>
		</div>
						<div class="row-fluid" style="padding-left: 10px;">
							<div class="span12">
								<br />
							</div>
						</div>
		<div class="row-fluid" style="padding-left:10px;">
			<div class="span1"></div>
			<div class="span10">
				<span class="text-uppercase" style="font-weight: 600;"> <s:message
						code="info.whatyouneedtitle" />
				</span>
				<ul>
					<li><s:message code="info.whatyouneed1" /></li>
					<li><s:message code="info.whatyouneed2" /></li>
					<li><s:message code="info.whatyouneed3" /></li>
					<li><s:message code="info.whatyouneed4" /></li>
					<li><s:message code="info.whatyouneed5" /></li>
					<li><s:message code="info.whatyouneed6" /></li>
					<li><s:message code="info.whatyouneed7" /></li>
				</ul>
			</div>
		</div>
		<div class="row-fluid" style="padding-left:10px;">
			<div class="span1"></div>
			<div class="span10">
				<div class="panel panel-default panel-size">

					<table class="table table-hover">
						<thead>
						</thead>
						<tbody>
							<tr class="active">
								<td colspan="3"><span style="font-weight: 600;"><s:message
											code="common.inspectionfeetext" /></span></td>
							</tr>
							<tr>
								<td><s:message code="common.decriptiontext" /></td>
								<td><s:message code="common.inspectionfeetext" /></td>
								<td> </td>
							</tr>
							<tr class="active">
								<td><s:message code="info.inspectiontypea" /></td>
								<td><s:message code="info.inspectiontypeafee" /></td>
								<td></td>
							</tr>
							<tr class="active">
								<td><s:message code="info.inspectiontypeb" /></td>
								<td><s:message code="info.inspectiontypebfee" /></td>
								<td></td>
							</tr>
							<tr class="active">
								<td><s:message code="info.inspectiontypec" /></td>
								<td><s:message code="info.inspectiontypecfee" /></td>
								<td></td>
							</tr>
							<tr class="active">
								<td><s:message code="info.inspectiontyped" /></td>
								<td><s:message code="info.inspectiontypedfee" /></td>
								<td></td>
							</tr>
							<tr class="active">
								<td colspan="3"><span style="font-weight: 600;"><s:message
											code="info.stdnopoleservicetitle" /></span></td>
							</tr>
							<tr>
								<td><s:message code="common.decriptiontext" /></td>
								<td><s:message code="info.capitalcontributiontext" /></td>
								<td><s:message code="info.total" /></td>
							</tr>
							<tr class="active">
								<td><s:message code="info.domesticoutputbasedaid" /></td>
								<td><s:message code="info.domesticoutputbasedaidfee" /></td>
								<td><s:message code="info.domesticoutputbasedaidfee" /></td>
							</tr>
							<tr class="active">
								<td><s:message code="info.commercialsinglephase" /></td>
								<td><s:message code="info.commercialsinglephasefee" /></td>
								<td><s:message code="info.commercialsinglephasefee" /></td>
							</tr>
							<tr class="active">
								<td colspan="3"><span style="font-weight: 600;"><s:message
											code="info.stdpoleservicetitle" /></span></td>
							</tr>
							<tr class="active">
								<td><s:message code="info.domesticprepaid" /></td>
								<td><s:message code="info.domesticprepaidfee" /></td>
								<td><s:message code="info.domesticprepaidfee" /></td>
							</tr>
							<tr class="active">
								<td><s:message code="info.commercialsinglephaseprepaid" />
								</td>
								<td><s:message code="info.commercialsinglephaseprepaidfee" />
								</td>
								<td><s:message code="info.commercialsinglephaseprepaidfee" />
								</td>
							</tr>
							<tr class="active">
								<td colspan="3"><span style="font-weight: 600;"><s:message
											code="info.nonStdConnection" /></span></td>
							</tr>
							<tr>
								<td><s:message code="common.decriptiontext" /></td>
								<td><s:message code="info.capitalcontributiontext" /></td>
								<td><span><s:message code="info.securitydeposit" /></span></td>
							</tr>
							<tr class="active">
								<td><s:message code="info.commercial3phasetitle" /></td>
								<td><s:message code="info.commercial3phase" /></td>
								<td><s:message code="info.commercial3phasedeposit" /></td>
							</tr>
							<tr class="active">
								<td><s:message code="info.industrialKVAtitle" /></td>
								<td><s:message code="info.industrialKVA" /></td>
								<td><s:message code="info.industrialKVAdeposit" /></td>
							</tr>
						</tbody>
					</table>

				</div>

			</div>
		</div>

		<div class="row-fluid" style="padding-left:10px;">
			<div class="span1"></div>
			<div class="span11">
				<b><s:message code="info.notetitle" /></b>
				<s:message code="info.notebody" />
				
			</div>
		</div>
	</div> --%>

</div>

<script type="text/javascript">

	$(document).ready(function() {
		var a = document.getElementById("printBtn");

		//Set code to run when the link is clicked
		// by assigning a function to "onclick"
		a.onclick = function() {

			var elem = document.getElementById("umeme_connect");
			/* var element = document.getElementById("printBtn");
			printDiv.removeChild(element); */

			Popup($(elem).html());

			return false;
		}

		function PrintElem(elem) {
			var element = document.getElementById("printBtn");
			elem.removeChild(element);

			Popup($(elem).html());
		}

		function Popup(data) {
			var mywindow = window.open('', 'my div', 'height=400,width=600');
			mywindow.document.write('<html><head><title>my div</title>');
			/*optional stylesheet*///
			mywindow.document.write('<link rel="stylesheet" href="url(/resources/assets/css/style.css)" type="text/css" media="print" />');
			mywindow.document.write('<link  href="url(/resources/assets/css/bootstrap.css)" rel="stylesheet" id="bootstrap-css">');
			mywindow.document.write('</head><body >');
			mywindow.document.write(data);
			mywindow.document.write('</body></html>');

			mywindow.document.close(); // necessary for IE >= 10
			mywindow.focus(); // necessary for IE >= 10

			mywindow.print();
			mywindow.close();

			return true;
		}
	});
</script>
