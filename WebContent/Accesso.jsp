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
</head>

<body>

<div id="all">

<img id= "logo" src="images/logo.jpeg" style="height: 190px; ">

<% if(session.getAttribute("goodReg").equals("ok")) {%>

<script>
alert("Registrazione effettuata!");
</script>
<%} %>

<% if(session.getAttribute("failedLog").equals("true")) {%>

<script>
alert("Email o Password non corretti");
</script>
<%} %>

<div id="menubar">
<ul id="menu">
 <li><a href="Home.jsp">Home</a></li>
 <li><a href="">Menù</a></li>
 <li><a href="Panini.jsp">Panini</a></li>
 <li><a href="">Rosticceria</a></li>
 <li><a href="">Bibite</a></li>
 <li><a href="">Dolci</a></li>
 <li><a href="Registrazione.jsp">Registrati</a></li>
 
</ul>
</div>

	
<form name="reg" id="form" action="UserAction" method="POST">
	<label for="user">Email</label>
	<input type="text"  id="email" name="email" ><span style="color: white;" id=span></span><br>
	<label for="user">Password</label>
	<input type="password" id="pass" name="pass"><span style="color: white;" id=psw></span><br>

	<input type="submit" id="submit" name="submit" value="Accedi" > 
	<input type="hidden" name="action" value="login">
</form>
		

</div>
		
			

<footer> 

©2017 Authors Daniele Palmieri, Alfonso di Pace, Marco Amorosi 					
</footer>	
		
</body>


</html>