/**
 * 	\					VALIDA L'ORA DI CONSEGNA DELL'ORDINE
 */


var ora=0;

$(document).ready(function() { EnableDisableButton();});



function ValidareOra(text) {
	//var user = /^\d+:\d+*$/;+
	var str = text.value.toString();
	var index = str.indexOf(':'); 
	var hh = str.substr(0, index); // Gets the first part
	var mm = str.substr(index + 1);  // Gets the text part
	var d = new Date();
	var hours = d.getHours().toString();
	var minutes = d.getMinutes().toString();

	//if(text.value.match(user)) {
	if(hh>8) {
		if(hh>=hours) {
			if(mm>minutes) {
				ora=1;
				document.getElementById("hh").innerHTML = "";
				EnableDisableButton();
			}
		}	
	}
	//}
	else { 
		ora=0;
		document.getElementById("hh").innerHTML = "Orario non disponibile";
		EnableDisableButton();
	}
}


function EnableDisableButton() {
	if(ora==1)
		$('#submit2').prop("disabled",false);
	else{
		$('#submit2').prop("disabled",true);
	}
}