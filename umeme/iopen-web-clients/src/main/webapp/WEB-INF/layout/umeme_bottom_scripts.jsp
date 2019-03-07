<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<script>
	$(document).ready(function(){
	  $("#demo").on("hide.bs.collapse", function(){
	    $(".btn").html('<span class="glyphicon glyphicon-collapse-down"></span> Open');
	  });
	  $("#demo").on("show.bs.collapse", function(){
	    $(".btn").html('<span class="glyphicon glyphicon-collapse-up"></span> Close');
	  });
	  
	});
</script>	
		
<!-- Initializing scripts -->
<script> 			
	jQuery(window).load(function() {
		$('.feature').hover(
			function(){
				var wdt = $(this).width();
				var padd = $(this).parent().css('padding-left')
				$(this).find('.caption').width(wdt);
				$(this).find('.caption').css('margin-left',padd);
				$(this).find('.caption').slideDown(250);
			},
			function(){
				$(this).find('.caption').slideUp(250);
			}
		);
		
	});
	</script>

<script type='text/javascript' src='<s:url value="/resources/assets/js/jquery.form.min729b.js?ver=3.32.0-2013.04.034"></s:url>'></script>
<script type='text/javascript'>
/* <![CDATA[ */
var _wpcf7 = {"loaderUrl":"http:\/\/localhost\/UMEME\/assets\/img\/ajax-loader.gif","sending":"Sending ...","cached":"1"};
/* ]]> */
</script>
<script type='text/javascript' src='<s:url value="/resources/assets/js/scriptse735.js?ver=3.4"></s:url>'></script>
<script type='text/javascript' src='<s:url value="/resources/assets/js/bootstrap.min9d52.js?ver=3.5.1"></s:url>'></script>
<script type='text/javascript' src='<s:url value="/resources/assets/js/application9d52.js?ver=3.5.1"></s:url>'></script>
<script type='text/javascript' src='<s:url value="/resources/assets/js/bootstrap.function9d52.js?ver=3.5.1"></s:url>'></script>
<script type='text/javascript' src='<s:url value="/resources/assets/js/bootstrap-mega-dd9d52.js?ver=3.5.1"></s:url>'></script>
<script type='text/javascript' src='<s:url value="/resources/assets/js/jquery.blockUI.min59c7.js?ver=2.50"></s:url>'></script>
<script type='text/javascript' src='<s:url value="/resources/assets/js/home.js"></s:url>'></script>

<script>
	/*global $:false */	
	if ( $(window).width() > 960) {
		$('.navbar .nav .dropdown-toggle').addClass('disabled');
		$('.navbar .dropdown').hover(function() {
            "use strict";
			$(this).addClass('open').find('.dropdown-menu').first().stop(true, true).delay(250).slideDown();
		}, function() {
            "use strict";
            var na = $(this);
			na.find('.dropdown-menu').first().stop(true, true).delay(100).slideUp('fast', function(){ na.removeClass('open'); });
		});
	}
</script>
