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
                parsed.forEach(function (value) {
                    var dom = "";
                    dom += "<p>" + " " + "*" + " ";
                    dom += "<a target='_blank' href='http://localhost:9000/userProfile/"+value.screenName+"'>("+value.name+")</a>" + "Tweet - "+value.text;
                    dom += "</p>";
                    jQuery("#"+value.message).append(dom);
                    jQuery("#"+value.message).animate({ scrollTop: $("#"+value.message).prop("scrollHeight")}, 500);
                });
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
