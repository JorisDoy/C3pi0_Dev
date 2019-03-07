/*global $:false */

$(function() {
"use strict";
if ( $(window).width() > 960) {
    $( '.menu-item-language' ).addClass( 'noLava' );
    $( '.current-menu-item, .current_page_item, .current-page-ancestor, .current-menu-parent, .current_page_item, .current_page_parent, .current_page_ancestor' ).addClass( 'selectedLava' );
    //$('.navbar .nav').lavaLamp(); 
}
});