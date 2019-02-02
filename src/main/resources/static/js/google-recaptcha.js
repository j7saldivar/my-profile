$(document).ready(function() {

		var obj = {
			"app" : "Google reCAPTCHA",
			"instructions" : {
				"one" : "click reCAPTCHA",
				"two" : "submit",
				"note" : "reCAPTCHA token can be used only once"
			}
		};
		
		var myJSON = JSON.stringify(obj, null, 4);

		document.getElementById("jsonTextFormat").innerHTML = myJSON;
		document.getElementById("jsonTextFormat").style.fontFamily = "Raleway";

		$('#postId').submit(function(event) {

			var recaptcha = {
				'g-recaptcha-response' : grecaptcha.getResponse()
			}

			$.ajax({
				type : 'POST', 
				url : '/apps/google-recaptcha',
				data : recaptcha, 
				dataType : 'json', 
				encode : true
			}).done(function(data) {

				var myJSON = JSON.stringify(data, null, 4);
				document.getElementById("jsonTextFormat").innerHTML = myJSON;
				document.getElementById("jsonTextFormat").style.fontFamily = "Raleway";

			});

			event.preventDefault();
		
		});

	});