/**
 * 			VALIDAZIONE CAMPI PAGINA REGISTRAZIONE
 */
var email,nome,pass,cognome, message;
email=nome=pass=cognome=0;

$(document).ready(function() { EnableDisableButton();});


function ValidareEmail(text) {
	$("#email").keyup(function(){
		var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
		if(text.value.match(mailformat)) {
			email=1;
			document.getElementById("span").innerHTML = "";
			var email = $(this).val();
			$.ajax({
				type: "GET",
				url: "AjaxController",
				data: "email="+ email,
				success: function(msg){  
					message=msg;

					if(msg==" not avaiable") {
						$('#submit').prop("disabled",true);
					}
					document.getElementById("span").innerHTML=msg;

				}
			}); 
			EnableDisableButton();
		}
		else {
			email=0;
			document.getElementById("span").innerHTML = "formato email non corretto";
			EnableDisableButton();
		}
	});
}

function ValidareNome(text) {
	var user = "^[a-zA-Z\\s]*$";
	if(text.value.match(user)) {
		nome=1;
		document.getElementById("name").innerHTML = "";
		EnableDisableButton();
	}
	else { 
		nome=0;
		document.getElementById("name").innerHTML = "Formato nome non corretto";
		EnableDisableButton();
	}
}


function ValidareCognome(text) {
	var user = "^[a-zA-Z\\s]*$";
	if(text.value.match(user)) {
		cognome=1;
		document.getElementById("surname").innerHTML = "";
		EnableDisableButton();
	}
	else { 
		cognome=0;
		document.getElementById("surname").innerHTML = "formato cognome non corretto";
		EnableDisableButton();
	}
}


function ValidarePassword(text) {
	if(text.value.length >=6) {
		if(message==" avaiable")
			email=1;
		pass=1;
		document.getElementById("psw").innerHTML = "";
		EnableDisableButton();
	}
	else{
		pass=0;
		document.getElementById("psw").innerHTML = "formato password non corretto";
		EnableDisableButton();
	}
}


function EnableDisableButton() {
	if(email+nome+pass+cognome==4)
		$('#submit').prop("disabled",false);
	else{
		$('#submit').prop("disabled",true);
	}
}
