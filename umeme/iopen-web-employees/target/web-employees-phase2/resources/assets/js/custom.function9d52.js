function calloutButton(){"use strict";$(".callout").each(function(){var a=$(this).find(".button").prev(".content").outerHeight(),b=$(this).find(".button .btn").outerHeight(),c=a-b;$(this).find(".button").css({height:a,paddingTop:c/2})})}function callout1Button(){"use strict";$(".callout-1").each(function(){var a=$(this).find(".button").prev(".content").height(),b=$(this).find(".button .btn").outerHeight(),c=a-20-b;$(this).find(".button").css({height:a-20,paddingTop:c/2})})}function callout2Button(){"use strict";$(".callout-2").each(function(){var a=$(this).find(".button").prev(".content").height(),b=$(this).find(".button .btn").outerHeight(),c=a-b;$(this).find(".button").css({height:a,paddingTop:c/2})})}function calloutMailchimp(){"use strict";$(".callout").each(function(){var a=$(this).find(".newsletter").prev(".content").outerHeight(),b=$(this).find(".newsletter .pmc_mailchimp").outerHeight(),c=a-b;$(this).find(".newsletter").css({height:a,paddingTop:c/2+5})})}function callout1Mailchimp(){"use strict";$(".callout-1").each(function(){var a=$(this).find(".newsletter").prev(".content").height(),b=$(this).find(".newsletter .pmc_mailchimp").outerHeight(),c=a-20-b;$(this).find(".newsletter").css({height:a-20,paddingTop:c/2+5})})}function callout2Mailchimp(){"use strict";$(".callout-2").each(function(){var a=$(this).find(".newsletter").prev(".content").height(),b=$(this).find(".newsletter .pmc_mailchimp").outerHeight(),c=a-b;a<b?$(this).find(".newsletter").addClass("test").css({paddingTop:10}):$(this).find(".newsletter").css({height:a,paddingTop:c/2+5})})}function cart_list(){"use strict";$(".cart_list li").each(function(){$(this).find(".variation").next().andSelf().wrapAll('<div class="meta-wrap" />')})}function inputFocus(){"use strict";$(".wpcf7-text").focus(function(){$(this).val()===this.defaultValue&&$(this).val("")}),$(".wpcf7-text").blur(function(){""===$(this).val()&&$(this).val(this.defaultValue)}),$(".form-456 .form-search input").focus(function(){$(this).val()===this.defaultValue&&$(this).val("")}),$(".form-456 .form-search input").blur(function(){""===$(this).val()&&$(this).val(this.defaultValue)})}function shopThumbnail(){"use strict";$('<div class="clearfix"></div>').insertAfter(".thumbnails .zoom:nth-child(4n)")}function wp_gallery(){"use strict";$(".gallery-item .gallery-icon a").each(function(){$(this).addClass("thumbnail")})}function productCategoryWidget(){"use strict";$(".widget_product_categories ul ul").hide().click(function(a){a.stopPropagation()}),$(".widget_product_categories ul > li > ul.children").before('<span class="toggle">[+]</span>');var a=$(".widget_product_categories ul > li.current-cat, .widget_product_categories ul > li.current-cat-parent");a.children(".toggle").html("[-]"),a.children("ul").slideDown().addClass("opened"),$(".widget_product_categories ul > li > ul.children").each(function(){$(this).parent().children(".toggle").toggle(function(){$(this).parent().children("ul").hasClass("opened")?($(this).html("[+]"),$(this).parent().children("ul").slideUp(),$(this).parent().children("ul").removeClass("opened").addClass("closed")):($(this).html("[-]"),$(this).parent().children("ul").slideDown(),$(this).parent().children("ul").removeClass("closed").addClass("opened"))},function(){$(this).parent().children("ul").hasClass("closed")?($(this).html("[-]"),$(this).parent().children("ul").slideDown(),$(this).parent().children("ul").removeClass("closed").addClass("opened")):($(this).html("[+]"),$(this).parent().children("ul").slideUp(),$(this).parent().children("ul").removeClass("opened").addClass("closed"))})})}jQuery(document).ready(function(){"use strict";calloutButton(),callout1Button(),callout2Button(),calloutMailchimp(),callout1Mailchimp(),callout2Mailchimp(),cart_list(),inputFocus(),shopThumbnail(),wp_gallery(),productCategoryWidget()});