/**
 * 				VALIDAZIONE CAMPI AGGIUNGI PRODOTTO
 */


var rice=0;

$(document).ready(function() { EnableDisableButton();});



function ValidarePrice(text) {
	var user = /^\d+(?:[.,]\d+)*$/;
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
	if(price==1)
		$('#submit').prop("disabled",false);
	else{
		$('#submit').prop("disabled",true);
	}
}