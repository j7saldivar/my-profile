$(document).ready(function() {
	
	$.ajax({
		type : 'GET', 
		url : 'https://www.jorgesaldivar.com:4455/docker-running-images', 
		data : {},
		dataType : 'json', 
		encode : true
	}).done(function(data) {
	
		var myJSON = JSON.stringify(data, null, 4);
		document.getElementById("jsonTextFormat").innerHTML = myJSON;
		document.getElementById("jsonTextFormat").style.fontFamily = "Raleway";
	
	});
		
});