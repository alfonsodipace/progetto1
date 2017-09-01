

function cambia() {
	document.getElementById("aggiorna").removeAttribute("disabled");
	var x = document.getElementsByClassName("comment");
	for(i=0; x; i++ ) {
		document.getElementsByClassName("comment")[i].disabled=false;
	}
		
	//document.getElementById("aggiorna").setAttribute("disabled", false);
	//$('#aggiorna').prop("disabled",false);
}

