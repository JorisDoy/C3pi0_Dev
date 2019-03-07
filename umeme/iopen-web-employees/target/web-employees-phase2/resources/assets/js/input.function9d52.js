/*global $:false */

$(document).ready(function(){    
"use strict";
// contact form 7 plugin
// clear input on focus
$('.wpcf7-text').focus(function(){
if($(this).val()===this.defaultValue){
$(this).val('');
}
});

// if field is empty afterward, add text again
$('.wpcf7-text').blur(function(){
if($(this).val()===''){
$(this).val(this.defaultValue);
}
});

// comment form
// clear input on focus
$('#commentform input').focus(function(){
if($(this).val()===this.defaultValue){
$(this).val('');
}
});

// if field is empty afterward, add text again
$('#commentform input').blur(function(){
if($(this).val()===''){
$(this).val(this.defaultValue);
}
});

// clear input on focus
$('#commentform textarea').focus(function(){
if($(this).val()===this.defaultValue){
$(this).val('');
}
});

// if field is empty afterward, add text again
$('#commentform textarea').blur(function(){
if($(this).val()===''){
$(this).val(this.defaultValue);
}
});

// clear input on focus
$('.form-search input').focus(function(){
	if($(this).val()===this.defaultValue){
		$(this).val('');
	}
});

// if field is empty afterward, add text again
$('.form-search input').blur(function(){
	if($(this).val()===''){
		$(this).val(this.defaultValue);
	}
}); 

    
});