var $ = jQuery.noConflict();

$(document).ready(function() {	
	
	// accordion
	$('.accordion').find('div:not(:first)').hide();
	$('.accordion > .accordion-title:first-child > a').addClass('active');

	$('.accordion > .accordion-title > a').click(function(event) {
		event.preventDefault();

		// hide all panels
	   	$(this).closest('.accordion').find('div').slideUp();

		// remove active class from all
		$(this).closest('.accordion').find('.accordion-title a').removeClass('active');
		
		// if the panel is closed, open it
	   	if($(this).parent().next().is(':hidden'))
		{
			$(this).parent().next().slideDown();
			$(this).addClass('active');
		}

	   	return false;
	});
	
	
});

$(window).load(function() {	
	
});




