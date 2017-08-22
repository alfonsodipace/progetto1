/**
 * 			VALIDAZIONE CAMPI PAGINA REGISTRAZIONE
 */
var email,nome,pass,cognome,indirizzo;
email=nome=pass=cognome=indirizzo=0;

function ValidareEmail(text) {
	var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	if(text.value.match(mailformat)) {
		email=1;
		$("#email").blur(function(){
	        var email = $(this).val();
	             $.ajax({
	                type: "GET",
	                url: "AjaxController",
	                data: "email="+ email,
	                success: function(msg){  
	                	var errpos = form["email"];
			var msgEl = document.getElementById("span").innerHTML=msg;


	                }
	            }); 
	    });
		EnableDisableButton();
	}
	else {
		email=0;
		document.getElementById("span").innerHTML = "formato email non corretto";
		EnableDisableButton();
	}
}


function ValidareNome(text) {
	var user = /^[a-z+A-z]+$/;
	if(text.value.match(user)) {
		nome=1;
		document.getElementById("name").innerHTML = ""; // per cancellare nel caso si corregga!!!
		EnableDisableButton();
	}
	else { 
		nome=0;
		document.getElementById("name").innerHTML = "Formato nome non corretto";
		EnableDisableButton();
	}
}


function ValidareCognome(text) {
	var user = /^[a-z+A-z]+$/;
	if(text.value.match(user)) {
		cognome=1;
		EnableDisableButton();
	}
	else { 
		cognome=0;
		document.getElementById("surname").innerHTML = "formato cognome non corretto";
		EnableDisableButton();
	}
}


function ValidarePassword(text) {
	if(text.value.length > 6) {
		pass=1;
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
