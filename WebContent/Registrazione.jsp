<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrazione</title>
<script src="js/jquery.js"></script>  <!--  LIBRERIA JQUERY -->
<script src="js/Validation.js"></script>
</head>

<body>
 
 <script>
	$(document).ready(function(){
 		$('#submit').prop("disabled",true);
 	});
</script>

<form name="reg">
Nome: <input type="text" id="nome" name="nome" onkeyup ="ValidareNome(document.reg.nome)"> <a id="name"></a> </br>
Cognome: <input type="text" id="cognome" onkeyup ="ValidareCognome(document.reg.cognome)"> <a id="surname"></a> </br>
Indirizzo: <input type="text" id="indirizzo" onkeyup ="ValidareIndirizzo(document.reg.indirizzo)"> <a id="address"></a> </br>
Email: <input type="text" id="email" name="email" onkeyup ="ValidareEmail(document.reg.email)"> <a id="emo"></a><a id="emo2"></a> </br>
Password: <input type="password" id="pass" onkeyup ="ValidarePassword(document.reg.pass)"> <a id="pasw"> </a>  </br>


<input type="submit" id="submit" value="Invia" onclick=""> </br>

</form>
</body>
</html>