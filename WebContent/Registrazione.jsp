<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>I-PHAME</title>
		<link type="text/css" rel="stylesheet" href="CSS/registrationCSS.css"/>
		<link rel="icon" href="images/favicon.jpg" />
		<script src="js/jquery.js"></script> 
		<script src="js/Validation.js"></script>
</head>

<body>

<div id="all">

<img id= "logo" src="images/logo.jpeg" style="height: 190px; ">

<div id="menubar">
<ul id="menu">
 <li><a href="Home.jsp">Home</a></li>
 <li><a href="">Menù</a></li>
 <li><a href="">Panini</a></li>
 <li><a href="">Rosticceria</a></li>
 <li><a href="">Dolci</a></li>
 <li><a href="">Bibite</a></li>
 <li><a href="">Info</a></li>
 <li><a href="Registrazione.jsp">Login</a></li>
</ul>
</div>

	
	<form name="reg" id="form" method="POST">
<label for="user">Nome</label>
<input type="text" id="firstname" name="firstname" onkeyup= "ValidareNome(document.reg.firstname)"><span style="color: white;" id=name></span><br>
<label for="user">Cognome</label>
<input type="text" id="lastname" name="lastname" onkeyup= "ValidareCognome(document.reg.lastname)"><span  style="color: white;" id=surname></span><br>
<label for="user">Indirizzo</label>
<input type="text" id="indirizzo" name="indirizzo"><br>
<label for="user">Email</label>
<input type="text"  id="email" name="email" onkeyup= "ValidareEmail(document.reg.email)"><span style="color: white;" id=span></span><br>
<label for="user">Password</label>
<input type="password" id="pass" name="pass" onkeyup= "ValidarePassword(document.reg.pass)"><span style="color: white;" id=psw></span><br>


<input type="submit" id="submit" name="submit" value="Registrati">
</form>
		

</div>
		
			

<footer> 
<br>
					<br>
©2017 Authors Daniele Palmieri, Alfonso di Pace, Marco Amorosi Design by Daniele Palmieri, Alfonso di Pace, Marco Amorosi					
</footer>	
		
</body>


</html>