<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t" %>

 <link rel="stylesheet" type="text/css" href='<s:url value="/resources/styles.css"></s:url>' />
 
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>UMEME</title>
        		              
    <meta name="keywords" content="UMEME, electricity, uganda">
    <meta name="description" content="Umeme, Uganda's number one electricity distributor."> 	
    <meta name="viewport" content="width=device-width, initial-scale=1.0">    
    <meta name="author" content="KAINGroup" />
    <base  />
	<link rel="Shortcut Icon" type="image/ico" href="http://www.umeme.co.ug/assets/img/favicon1.ico" />
  
    <link href='http://fonts.googleapis.com/css?family=Lato:300,400,700,400italic' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Dancing+Script' rel='stylesheet' type='text/css'>    
    <link rel="stylesheet" href='<s:url value="/resources/assets/css/style.css"></s:url>' type="text/css" media="screen" />
	<link rel="stylesheet" href='<s:url value="/resources/assets/css/font-awesome.min.css"></s:url>'>
	<link rel="stylesheet" href='<s:url value="/resources/assets/css/signin.css"></s:url>'>
	<link rel="stylesheet" href='<s:url value="/resources/assets/css/dropzone.css"></s:url>'>
	<link rel="stylesheet" href='<s:url value="/resources/assets/css/datepicker.css"></s:url>'>
	<link rel="stylesheet" href='<s:url value="/resources/assets/css/bootstrap-table.css"></s:url>'>
	
	<%-- <link rel="stylesheet" href='<s:url value="/resources/assets/css/bootstrap.css"></s:url>'> --%>

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    
	<!--[if gte IE 9]>
	  <style type="text/css">
	    .gradient {
	       filter: none;
	    }
	  </style>
	<![endif]-->

    <!-- Le fav and touch icons -->
      
                    
    <!-- CSS -->
	<link rel='stylesheet' id='grid-css-css'  href='<s:url value="/resources/assets/plugins/dynamic-grid-gallery/dynamic.grid5152.css?ver=1.0"></s:url>' type='text/css' media='' />
	<link rel='stylesheet' id='jnewsticker_css-css'  href='<s:url value="/resources/assets/plugins/jnews-ticker/123ecology9d52.css?ver=3.5.1"></s:url>' type='text/css' media='all' />
	<link rel='stylesheet' id='layerslider_css-css'  href='<s:url value="/resources/assets/plugins/layerslider/layerslider268f.css?ver=4.5.0"></s:url>' type='text/css' media='all' />
	<link rel='stylesheet' id='contact-form-7-css'  href='<s:url value="/resources/assets/plugins/contact-form/stylese735.css?ver=3.4"></s:url>' type='text/css' media='all' />
	<link rel='stylesheet' id='showbizpro-settings-css'  href='<s:url value="/resources/assets/plugins/showbiz/settings9d52.css?ver=3.5.1"></s:url>' type='text/css' media='all' />
	<link rel='stylesheet' id='responsive-css'  href='<s:url value="/resources/assets/themes/responsive9d52.css?ver=3.5.1' type='text/css"></s:url>' media='all' />
	<link rel='stylesheet' id='1200-responsive-css'  href='<s:url value="/resources/assets/themes/responsive_1170_layouts9d52.css?ver=3.5.1' type='text/css"></s:url>' type='text/css' media='all' />

	
	<!-- JS -->
	<script type='text/javascript' src='<s:url value="/resources/assets/js/jquery-1.8.1.minc245.js?ver=1.8.1"></s:url>'></script>
	<script type='text/javascript' src='<s:url value="/resources/assets/js/bootstrap-carousel9d52.js?ver=3.5.1"></s:url>'></script>
	<script type='text/javascript' src='<s:url value="/resources/assets/js/jquery.lavalamp-1.4.min9d52.js?ver=3.5.1"></s:url>'></script>
	<script type='text/javascript' src='<s:url value="/resources/assets/js/lavalamp.function9d52.js?ver=3.5.1"></s:url>'></script>
	<script type='text/javascript' src='<s:url value="/resources/assets/js/selector.function9d52.js?ver=3.5.1"></s:url>'></script>
	<%-- <script type='text/javascript' src='<s:url value="/resources/assets/plugins/prettyPhoto/prettyPhoto.function9d52.js?ver=3.5.1"></s:url>'></script> --%>
	<script type='text/javascript' src='<s:url value="/resources/assets/plugins/isotope/jquery.isotope.min9d52.js?ver=3.5.1"></s:url>'></script>
	<script type='text/javascript' src='<s:url value="/resources/assets/plugins/isotope/isotope.function9d52.js?ver=3.5.1"></s:url>'></script>
	<script type='text/javascript' src='<s:url value="/resources/assets/js/custom.function9d52.js?ver=3.5.1"></s:url>'></script>
	<script type='text/javascript' src='<s:url value="/resources/assets/js/newsticker-fix9d52.js?ver=3.5.1"></s:url>'></script>
	<script type='text/javascript' src='<s:url value="/resources/assets/js/input.function9d52.js?ver=3.5.1"></s:url>'></script>
	<script type='text/javascript' src='<s:url value="/resources/assets/plugins/showbiz/jquery.themepunch.plugins.min9d52.js?ver=3.5.1"></s:url>'></script>
	<script type='text/javascript' src='<s:url value="/resources/assets/plugins/showbiz/jquery.themepunch.showbizpro.min9d52.js?ver=3.5.1"></s:url>'></script>
	<script type='text/javascript' src='<s:url value="/resources/assets/themes/jquery.etalage.min9d52.js?ver=3.5.1"></s:url>'></script>
	<script type='text/javascript' src='<s:url value="/resources/assets/js/jquery.fancybox-1.3.4.pack9d52.js?ver=3.5.1"></s:url>'></script>
	<script type='text/javascript' src='<s:url value="/resources/assets/js/etalage.function9d52.js?ver=3.5.1"></s:url>'></script>
	<%-- <script type='text/javascript' src='<s:url value="/resources/assets/js/jquery4e44.js?ver=1.3"></s:url>'></script> --%>

	<!-- include Easing -->
	<script src='<s:url value="/resources/assets/js/jquery.cycle.all.js"></s:url>'></script> 
	<!-- include custom script -->
	<script src='<s:url value="/resources/assets/js/scripts1.js"></s:url>'></script>
	<!-- Custom stylesheets -->
	<link rel='stylesheet' id='1200-responsive-css'  href='<s:url value="/resources/assets/css/custom.css"></s:url>' type='text/css' media='all' />

    <style>
	.body-pattern{
	 background-image: url('<s:url value="/resources/assets/img/pattern55.png"></s:url>');
	}
	</style>

	<script>
	window.alert = function() {};
	</script>