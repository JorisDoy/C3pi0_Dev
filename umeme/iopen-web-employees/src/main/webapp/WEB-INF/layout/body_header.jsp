<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<div id="meta" class="wrap hidden-print">
	<!-- top header -->
	<div class="top-strip"> 
		<div class="row-fluid">
			<div class="span3">
				<a href="http://umeme.co.ug/"><img alt="UMEME"
					src='<s:url value="/resources/assets/img/logo.png"></s:url>'
					id="logo-img1"style="float:left;" /></a>
			</div>
			
			<!-- <div class="span7" style="background-color:#AEB400; height:40px;"></div> -->
			<div class="span9" style="background-color:#AEB400; height:60px;">
				<ul class="top-strip-nav">
					<security:authorize access="isAnonymous()">
						<%-- <li><a href='<s:url value="/application/new"></s:url>'><span><s:message code="login.application.new"/></span></a></li> --%>
						
						<li><a href='<s:url value="/user/login"></s:url>'><span><s:message
										code="login.text" /></span></a></li>
						
					</security:authorize>
					<security:authorize
						access="hasRole('CLIENT') or hasRole('EMPLOYEE')">
						<security:authentication property="principal.username"
							var="username" />
						<li><a href='#'><span><s:message
										code="loggedin.text" /> ${username}</span></a></li>

					</security:authorize>
					
					<security:authorize
						access="hasRole('EMPLOYEE')">
						<security:authentication property="principal.username"
							var="username" />
						<li><a href='<s:url value="/employee/applications"></s:url>'><span><s:message
										code="employee.applications.pending.text" /></span></a></li>

					</security:authorize>
					<security:authorize
						access="hasRole('CLIENT') or hasRole('EMPLOYEE')">
						<security:authentication property="principal.username"
							var="username" />
						<li><a href='<s:url value="/logout"></s:url>'><span><s:message
										code="logout.text" /></span></a></li>

					</security:authorize>
				</ul>
			</div>
		</div>
	</div>
	<!--End top header -->
</div>
<div id="header" class="wrap hidden-print">
<div class="container hidden-print">
	<div class="row-fluid">

		<div class="span4">
			<div id="logo" class="img">
				<%-- <h1>
					<a href="<s:url value="/"></s:url>"><img alt="UMEME"
						src='<s:url value="/resources/assets/img/logo.png"></s:url>'
						id="logo-img1" /></a>
				</h1> --%>
				<div class="clearfix"></div>
			</div>
		</div>
		<div class="span8">
			<!-- Navbar ================================================== -->
			<div class="navbar">
				<div class="container">
					<button type="button" class="btn btn-navbar" data-toggle="collapse"
						data-target=".nav-collapse">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<div class="nav-collapse collapse">

						<!-- Wayfinder Menu -->
						<!-- <ul id="menu-main" class="nav"> 
								<li id="menu-item-618" class="pull-right menu-item menu-item-type-post_type menu-item-object-page menu-item-618 dropdown">
									<a href="#" data-toggle="dropdown" data-target="#" class="dropdown-toggle">For Home<span class="caret"></span></a>
									<div class="dropdown-menu mega-dd-3">



										<div style="margin:3px 10px; border: 1px solid #ebebeb; padding: 1px; clear:both;"><img src='<s:url value="/resources/assets/images/forHome.jpg"></s:url>' width="640"></div>





											<section  id="menu-item-720"  class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-720 dropdown-submenu">
												<h6 class="nav-header">Yaka!</h6>
												<ul>
													<li id="menu-item-729" class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-729"><a href="http://www.umeme.co.ug/about-umeme/yaka/your-yaka.html">Your Yaka!</a>

													</li>
													<li id="menu-item-729" class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-729"><a href="http://www.umeme.co.ug/about-umeme/yaka/new-connection.html">New Connection</a>

													</li>
													<li id="menu-item-729" class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-729"><a href="http://www.umeme.co.ug/about-umeme/yaka/buy-yaka.html">Buy Yaka!</a>

													</li>
													<li id="menu-item-729" class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-729"><a href="http://www.umeme.co.ug/about-umeme/yaka/easy-guide.html">Easy Guide</a>

													</li>
													<li id="menu-item-729" class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-729"><a href="http://www.umeme.co.ug/about-umeme/yaka/yaka-faqs.html">Yaka! FAQs</a>

													</li>


												</ul><div class='clearfix'></div>
											</section>
											<section  id="menu-item-720"  class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-720 dropdown-submenu">
												<h6 class="nav-header">Post Paid Meter</h6>
												<ul>
													<li id="menu-item-729" class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-729"><a href="http://www.umeme.co.ug/about-umeme/post-paid-meter/dis-reconnection.html">Disconnection/Reconnection</a>

													</li>
													<li id="menu-item-729" class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-729"><a href="http://www.umeme.co.ug/about-umeme/post-paid-meter/pay-your-bill.html">Pay your bill</a>

													</li>
													<li id="menu-item-729" class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-729"><a href="http://www.umeme.co.ug/about-umeme/post-paid-meter/about-your-bill.html">About your bill</a>

													</li>
													<li id="menu-item-729" class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-729"><a href="http://www.umeme.co.ug/about-umeme/post-paid-meter/e-bill.html">e-Bill</a>

													</li>


												</ul><div class='clearfix'></div>
											</section>
											<section  id="menu-item-720"  class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-720 dropdown-submenu">
												<h6 class="nav-header">Tips</h6>
												<ul>
													<li id="menu-item-729" class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-729"><a href="http://www.umeme.co.ug/about-umeme/tips/power-saving-tips.html">Power saving tips</a>

													</li>
													<li id="menu-item-729" class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-729"><a href="http://www.umeme.co.ug/about-umeme/tips/tariff.html">Tariff</a>

													</li>
													<section  id="menu-item-720"  class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-720 dropdown-submenu">
														<h6 class="nav-header">Outages</h6>
														<ul>
															<li id="menu-item-729" class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-729"><a href="http://www.umeme.co.ug/about-umeme/tips/outages/current-outages.html">Current outages</a>

															</li>
															<li id="menu-item-729" class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-729"><a href="http://www.umeme.co.ug/assets/resources/Planned Shutdown_Schedule_AUGUST 2015.xls">Planned Outages</a>

															</li>


														</ul><div class='clearfix'></div>
													</section>


												</ul><div class='clearfix'></div>
											</section>




										</div><div class='clearfix'></div>   
									</li>
									<li id="menu-item-618" class="pull-right menu-item menu-item-type-post_type menu-item-object-page menu-item-618 dropdown">
										<a href="#" data-toggle="dropdown" data-target="#" class="dropdown-toggle">For Business<span class="caret"></span></a>
										<div class="dropdown-menu mega-dd-3">





											<div style="margin:3px 10px; border: 1px solid #ebebeb; padding: 1px; clear:both;"><img src='<s:url value="/resources/assets/images/biz.jpg"></s:url>' width="640"></div>



												<section  id="menu-item-720"  class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-720 dropdown-submenu">
													<h6 class="nav-header">Business</h6>
													<ul>
														<li id="menu-item-729" class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-729"><a href="http://www.umeme.co.ug/customer-service/business/about-your-bill.html">About your bill</a>

														</li>
														<li id="menu-item-729" class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-729"><a href="http://www.umeme.co.ug/customer-service/business/power-saving-tips.html">Power saving tips</a>

														</li>
														<li id="menu-item-729" class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-729"><a href="http://www.umeme.co.ug/customer-service/business/locate-us.html">Locate us</a>

														</li>
														<li id="menu-item-729" class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-729"><a href="http://www.umeme.co.ug/customer-service/business/tariff.html">Tariff</a>

														</li>
														<li id="menu-item-729" class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-729"><a href="http://www.umeme.co.ug/customer-service/business/current-outages.html">Current outages</a>

														</li>
														<li id="menu-item-729" class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-729"><a href="http://www.umeme.co.ug/assets/resources/Planned Shutdown Schedule_SEPTEMBER 2015_Customer.xls">Planned Outages</a>

														</li>


													</ul><div class='clearfix'></div>
												</section>
												<section  id="menu-item-720"  class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-720 dropdown-submenu">
													<h6 class="nav-header">Your meter</h6>
													<ul>
														<li id="menu-item-729" class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-729"><a href="http://www.umeme.co.ug/customer-service/your-meter/amr.html">Automated Meter Reading</a>

														</li>
														<li id="menu-item-729" class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-729"><a href="http://www.umeme.co.ug/customer-service/your-meter/amr-faqs.html">Automated Meter Reading FAQs</a>

														</li>
														<li id="menu-item-729" class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-729"><a href="http://www.umeme.co.ug/customer-service/your-meter/e-bill.html">e-Bill</a>

														</li>
														<li id="menu-item-729" class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-729"><a href="http://www.umeme.co.ug/customer-service/your-meter/pay-your-bill.html">Pay your bill</a>

														</li>
														<li id="menu-item-729" class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-729"><a href="http://www.umeme.co.ug/customer-service/your-meter/reconnection.html">Disconnection/Reconnection</a>

														</li>


													</ul><div class='clearfix'></div>
												</section>
												<section  id="menu-item-720"  class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-720 dropdown-submenu">
													<h6 class="nav-header">Power efficiency</h6>
													<ul>
														<li id="menu-item-729" class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-729"><a href="http://www.umeme.co.ug/customer-service/power-efficiency/about-your-bill.html">Bulk meter</a>

														</li>
														<li id="menu-item-729" class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-729"><a href="http://www.umeme.co.ug/customer-service/power-efficiency/power-faqs.html">FAQs</a>

														</li>
														<li id="menu-item-729" class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-729"><a href="http://www.umeme.co.ug/customer-service/power-efficiency/power-factor.html">Power factor</a>

														</li>


													</ul><div class='clearfix'></div>
												</section>




											</div><div class='clearfix'></div>   
										</li>
										<li id="menu-item-618" class="pull-right menu-item menu-item-type-post_type menu-item-object-page menu-item-618 dropdown">
											<a href="#" data-toggle="dropdown" data-target="#" class="dropdown-toggle">Help Centre<span class="caret"></span></a>
											<div class="dropdown-menu mega-dd-3">







												<div style="margin:3px 10px; border: 1px solid #ebebeb; padding: 1px; clear:both;"><img src='<s:url value="/resources/assets/images/biz.jpg"></s:url>' width="640"></div>

													<section  id="menu-item-720"  class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-720 dropdown-submenu">
														<h6 class="nav-header">Customer Service</h6>
														<ul>
															<li id="menu-item-729" class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-729"><a href="query.html">Query/Complaints Handling</a>

															</li>
															<li id="menu-item-729" class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-729"><a href="complaint.html">Complaint form</a>

															</li>
															<li id="menu-item-729" class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-729"><a href="locate-us.html">Locate us</a>

															</li>


														</ul><div class='clearfix'></div>
													</section>
													<section  id="menu-item-720"  class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-720 dropdown-submenu">
														<h6 class="nav-header">Downloads</h6>
														<ul>
															<li id="menu-item-729" class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-729"><a href="http://www.umeme.co.ug/help-centre/downloads/forms.html">Forms</a>

															</li>
															<li id="menu-item-729" class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-729"><a href="http://www.umeme.co.ug/help-centre/downloads/t-cs.html">T&Cs</a>

															</li>
															<li id="menu-item-729" class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-729"><a href="http://www.umeme.co.ug/help-centre/downloads/tariff.html">Tariff</a>

															</li>
															<li id="menu-item-729" class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-729"><a href="http://www.umeme.co.ug/help-centre/downloads/ebill-registration.html">Information</a>

															</li>


														</ul><div class='clearfix'></div>
													</section>
													<section  id="menu-item-720"  class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-720 dropdown-submenu">
														<h6 class="nav-header">Connect with us</h6>
														<ul>
															<li id="menu-item-729" class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-729"><a href="../galleries/meter-reading.html">Social Media</a>

															</li>
															<li id="menu-item-729" class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-729"><a href="../galleries/contact.html">Contact us</a>

															</li>


														</ul><div class='clearfix'></div>
													</section>




												</div><div class='clearfix'></div>   
											</li>
											<li id="menu-item-618" class="pull-right menu-item menu-item-type-post_type menu-item-object-page menu-item-618 dropdown">
												<a href="#" data-toggle="dropdown" data-target="#" class="dropdown-toggle">About Us<span class="caret"></span></a>
												<div class="dropdown-menu mega-dd-3">

													<div style="margin:3px 10px; border: 1px solid #ebebeb; padding: 1px; clear:both;"><img src='<s:url value="/resources/assets/images/about.jpg"></s:url>' width="640"></div>







														<section  id="menu-item-720"  class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-720 dropdown-submenu">
															<h6 class="nav-header">Company Profile</h6>
															<ul>
																<li id="menu-item-729" class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-729"><a href="http://www.umeme.co.ug/news-and-events/company-profile/our-story.html">Our story</a>

																</li>
																<li id="menu-item-729" class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-729"><a href="http://www.umeme.co.ug/news-and-events/company-profile/mission.html">Mission and Values</a>

																</li>
																<li id="menu-item-729" class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-729"><a href="http://www.umeme.co.ug/news-and-events/company-profile/faqs.html">FAQs</a>

																</li>
																<section  id="menu-item-720"  class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-720 dropdown-submenu">
																	<h6 class="nav-header">Invest</h6>
																	<ul>
																		<li id="menu-item-729" class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-729"><a href="http://www.umeme.co.ug/news-and-events/company-profile/news/share-price.html">Shareholders</a>

																		</li>
																		<li id="menu-item-729" class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-729"><a href="http://www.umeme.co.ug/news-and-events/company-profile/news/annual-report.html">Annual Report</a>

																		</li>
																		<li id="menu-item-729" class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-729"><a href="http://www.umeme.co.ug/news-and-events/company-profile/news/notices.html">Legal notices</a>

																		</li>


																	</ul><div class='clearfix'></div>
																</section>


															</ul><div class='clearfix'></div>
														</section>
														<section  id="menu-item-720"  class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-720 dropdown-submenu">
															<h6 class="nav-header">Leadership Team</h6>
															<ul>
																<li id="menu-item-729" class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-729"><a href="http://www.umeme.co.ug/news-and-events/leadership-team/board-of-directors.html">Board of Directors</a>

																</li>
																<li id="menu-item-729" class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-729"><a href="http://www.umeme.co.ug/news-and-events/leadership-team/smt.html">Senior Management Team</a>

																</li>
																<section  id="menu-item-720"  class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-720 dropdown-submenu">
																	<h6 class="nav-header">Work with us</h6>
																	<ul>
																		<li id="menu-item-729" class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-729"><a href="http://www.umeme.co.ug/news-and-events/leadership-team/galleries/careers.html">Careers</a>

																		</li>
																		<li id="menu-item-729" class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-729"><a href="http://www.umeme.co.ug/news-and-events/leadership-team/galleries/safety.html">Safety</a>

																		</li>
																		<li id="menu-item-729" class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-729"><a href="http://www.umeme.co.ug/news-and-events/leadership-team/galleries/corporate-governance.html">Corporate Governance</a>

																		</li>
																		<li id="menu-item-729" class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-729"><a href="http://www.umeme.co.ug/news-and-events/leadership-team/galleries/umeme-in-the-community.html">Umeme in the community</a>

																		</li>


																	</ul><div class='clearfix'></div>
																</section>


															</ul><div class='clearfix'></div>
														</section>
														<section  id="menu-item-720"  class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-720 dropdown-submenu">
															<h6 class="nav-header">Suppliers/Contractors</h6>
															<ul>
																<li id="menu-item-729" class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-729"><a href="http://www.umeme.co.ug/news-and-events/leadership-team/leadership-team.html">Available Tenders</a>

																</li>
																<li id="menu-item-729" class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-729"><a href="http://www.umeme.co.ug/news-and-events/leadership-team/procurement-policy.html">Procurement Policy</a>

																</li>
																<li id="menu-item-729" class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-729"><a href="http://www.umeme.co.ug/news-and-events/leadership-team/press-presentations.html">Presentations</a>

																</li>
																<section  id="menu-item-720"  class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-720 dropdown-submenu">
																	<h6 class="nav-header">Press Room</h6>
																	<ul>
																		<li id="menu-item-729" class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-729"><a href="http://www.umeme.co.ug/news-and-events/leadership-team/press-room/news.html">News</a>

																		</li>
																		<li id="menu-item-729" class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-729"><a href="http://www.umeme.co.ug/news-and-events/leadership-team/press-room/press-release.html">Press Releases</a>

																		</li>
																		<li id="menu-item-729" class="noLava menu-item menu-item-type-custom menu-item-object-custom menu-item-729"><a href="http://www.umeme.co.ug/news-and-events/leadership-team/press-room/gallery.html">Gallery</a>

																		</li>


																	</ul><div class='clearfix'></div>
																</section>


															</ul><div class='clearfix'></div>
														</section>




													</div><div class='clearfix'></div>   
												</li>

											</ul>
											
											-->
						<!-- /Wayfinder Menu -->

					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</div>
<!-- Static navbar -->
<%-- <nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="btn btn-navbar" data-toggle="collapse"
				data-target=".nav-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#"> <span
				class="label label-brandtitle">&nbsp;</span>
			</a>

		</div>
		<div id="navbar" class="navbar-collapse collapse"></div>
		<!--/.nav-collapse -->
	</div>
	<!--/.container-fluid -->
</nav>

 --%>
<!-- /container -->


