;(function(window) {

	'use strict';

	// Setting global class name
    document.documentElement.className = 'js';

	// Submit called on form submit
    jQuery('#search-form').submit(function (e) {
        e.preventDefault();
        if( $('#search-input').val() != '' ){
            var outerdom = "<p class='header'>Keyword:- "+$('#search-input').val()+"</p>"+"<div class='tweet-box' id="+$('#search-input').val()+"></div>";
            jQuery(".tweets-body").append(outerdom);
            var ws = new WebSocket('ws://localhost:9000/wsInterface');

            ws.onopen = function(msg) {
                ws.send($('#search-input').val());
            };

            ws.onmessage = function(msg) {
                var parsed = JSON.parse(msg.data);
                var dom = "";
                dom += "<p>" + " " + "*" + " ";
                dom += "<a target='_blank' href='http://localhost:9000/userProfile/"+parsed.screenName+"'>("+parsed.name+")</a>" + "Tweet - "+parsed.text;
                dom += "</p>";
                dom += "</div>";
                jQuery("#"+parsed.message).append(dom);
                jQuery("#"+parsed.message).animate({ scrollTop: $("#"+parsed.message).prop("scrollHeight")}, 1000);
            };

            ws.onclose = function(msg) {
                // Logic for closed connection
                console.log('Connection was closed.');
            };
            ws.error =function(err){
                // Write errors to console
                console.log(err);
            }
		}
    });

})(window);
