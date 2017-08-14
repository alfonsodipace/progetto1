/**
 * 			VALIDAZIONE CAMPI PAGINA REGISTRAZIONE
 */


$(document).ready(function(){       // check e-mail availability with ajax 
    $("#email").blur(function(){
        var email = $(this).val();
             $.ajax({
                type: "GET",
                url: "AjaxController",
                data: "email="+ email,
                success: function(msg){  
                        $("#emo2").html(msg);
                }
            }); 
    });
});


var email,nome,pass,cognome,indirizzo;
email=nome=pass=cognome=indirizzo=0;

function ValidareEmail(text) {
	var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	if(text.value.match(mailformat)) {
		email=1;
		document.getElementById("emo").innerHTML = "";
		EnableDisableButton();
	}
	else {
		email=0;
		document.getElementById("emo").innerHTML = "*";
		EnableDisableButton();
	}
}


function ValidareNome(text) {
	var user = /^[a-z+A-z]+$/;
	if(text.value.match(user)) {
		nome=1;
		document.getElementById("name").innerHTML = "";
		EnableDisableButton();
	}
	else { 
		nome=0;
		document.getElementById("name").innerHTML = "*";
		EnableDisableButton();
	}
}


function ValidareCognome(text) {
	var user = /^[a-z+A-z]+$/;
	if(text.value.match(user)) {
		cognome=1;
		document.getElementById("surname").innerHTML = "";
		EnableDisableButton();
	}
	else { 
		cognome=0;
		document.getElementById("surname").innerHTML = "*";
		EnableDisableButton();
	}
}


function ValidarePassword(text) {
	if(text.value.length > 6) {
		pass=1;
		document.getElementById("pasw").innerHTML = "";
		EnableDisableButton();
	}
	else{
		pass=0;
		document.getElementById("pasw").innerHTML = "*";
		EnableDisableButton();
	}
}

function ValidareIndirizzo(text) {
	if(text.value.length > 5) {
		indirizzo=1;
		document.getElementById("address").innerHTML = "";
		EnableDisableButton();
	}
	else{
		indirizzo=0;
		document.getElementById("address").innerHTML = "*";
		EnableDisableButton();
	}
}

function EnableDisableButton() {
	if(email+nome+pass+cognome+indirizzo==5)
		$('#submit').prop("disabled",false);
	else
		$('#submit').prop("disabled",true);
}
