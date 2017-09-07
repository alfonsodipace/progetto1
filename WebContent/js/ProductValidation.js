/**
 * 				VALIDAZIONE CAMPI AGGIUNGI PRODOTTO
 */


var name,descr,price
name=descr=price=0;

$(document).ready(function() { EnableDisableButton();});


function ValidareNome(text) {
	var user = "^[a-zA-Z\\s]*$";
	if(text.value.match(user)) {
		name=1;
		document.getElementById("name").innerHTML = "";
		EnableDisableButton();
	}
	else { 
		name=0;
		document.getElementById("name").innerHTML = "Formato nome non corretto";
		EnableDisableButton();
	}
}


function ValidareDesc(text) {
	var user = "^[a-zA-Z,. ]*$";
	if(text.value.match(user)) {
		descr=1;
		document.getElementById("description").innerHTML = "";
		EnableDisableButton();
	}
	else { 
		descr=0;
		document.getElementById("description").innerHTML = "Formato descrizione non corretta";
		EnableDisableButton();
	}
}


function ValidarePrice(text) {
	var user = "^[0-9]([.][0-9])?$";
	if(text.value.match(user)) {
		price=1;
		document.getElementById("price").innerHTML = "";
		EnableDisableButton();
	}
	else { 
		price=0;
		document.getElementById("price").innerHTML = "Formato prezzo non corretto";
		EnableDisableButton();
	}
}


function EnableDisableButton() {
	if(name+descr+price>3)
		$('#submit').prop("disabled",false);
	else{
		$('#submit').prop("disabled",true);
	}
}
