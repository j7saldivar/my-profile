//TIMER
var timer = new Date(Date.parse(new Date()) + 5 * 1000);
var interval = window.setInterval(getCountDown, 1000, timer);

function getCountDown(remainingTime) {
	
	var time = Date.parse(remainingTime) - Date.parse(new Date());
	var seconds =  Math.floor((time / 1000) % 60);
	$("#timeRemaining").text(seconds);

	if(seconds <= 0) {
		clearInterval(interval);
		window.location = "/";
  	}
	
}


//AUTOTYPE
function typeMessage(message) {
	$("#errorMessage").text(message);
}


var i = 0;

var message = "Whoops! There was an error in the request.";
var messageLenght = message.length;


function autoTypeSubmit() {

	if (i <= messageLenght) {
		typeMessage(message.substring(0, i));
		setTimeout(autoTypeSubmit, 25);
		i++;
	}
}

$(document).ready(autoTypeSubmit);