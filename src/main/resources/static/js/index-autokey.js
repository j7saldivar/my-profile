function typeMessage(message) {
	$("#message").text(message);
}

function typeUsername(username) {
	$("#inputEmail").val(username);
}

function typePassword(password) {
	$("#inputPassword").val(password);
}

var i = 0, j = 0, k = 0;

var message = ((typeof welcomeMessage !== 'undefined') ? welcomeMessage : "Welcome to my website");
var username = "me@jorgesaldivar.com";
var password = "password";
var usernameLength = username.length;
var passwordLenght = password.length;
var messageLenght = message.length;

function autoTypeSubmit() {

	if (i <= messageLenght) {
		typeMessage(message.substring(0, i));
		setTimeout(autoTypeSubmit, 50);
		i++;
	}

	else if (j <= usernameLength) {
		typeUsername(username.substring(0, j));
		setTimeout(autoTypeSubmit, 50);
		j++;
	} else if (k <= passwordLenght) {
		typePassword(password.substring(0, k));
		setTimeout(autoTypeSubmit, 50);
		k++;
	} else {

		$("#remember").prop("checked", true);
		$('#form-sign').submit();
	}
}

$(document).ready(autoTypeSubmit);