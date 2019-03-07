<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<div id="footer" class="hidden-print">
	<div class="wrap footer-top-line"></div>

	<div class="wrap footer-bottom">
		<div class="container">
		  <div class="row-fluid">
				<div class="span6 footer-bottom-left">
					<div class="social-media clearfix ">
						<p>Social Media:</p>
						<div class="header-cart-navi" id="social-block">
							<ul>
								<li><a href="https://twitter.com/umemeltd" target="_blank" title="Twitter"><i class="fa fa-twitter"></i></a></li>
								<li><a href="https://www.facebook.com/umemeltd" target="_blank" title="Facebook"><i class="fa fa-facebook"></i></a></li>
								<li><a href="#" target="_blank" title="Linkedin"><i class="fa fa-linkedin"></i></a></li>
								<li><a href="#" target="_blank" title="Youtube"><i class="fa fa-youtube"></i></a></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="span6 footer-bottom-right link-style">
					<ul id="menu-footer" class="footer-nav">
						<li id="menu-item-402" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-402"><a href="http://www.umeme.co.ug/index.php?id=8">Sitemap</a></li>
						<li id="menu-item-400" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-400"><a href="http://www.umeme.co.ug/index.php">Home</a></li>
						<li id="menu-item-403" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-403"><a href="http://www.umeme.co.ug/index.php?id=11">About Us</a></li>
						<li id="menu-item-401" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-401"><a href="http://www.umeme.co.ug/index.php?id=6">Contact Us</a></li>
					</ul>													  
					<p>Copyright &copy; <%= new java.text.SimpleDateFormat("yyyy").format(new java.util.Date()) %>
<a href="#">UMEME</a></p>					 
				</div>
		  </div>
		</div>
	</div>
</div>