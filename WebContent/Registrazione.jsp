<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<jsp:useBean id="user" class="bean.UtenteBean" scope="session"/>
	<meta  http-equiv="Content-Type" content="text/html" charset="UTF-8" >
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>I-PHAME</title>
	<link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="font-awesome-4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="CSS/registrationCSS.css"/>
	<link rel="icon" href="images/favicon.jpg" />
	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="js/Validation.js"></script>
	<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	<% session.setAttribute("goodReg","no");
	   session.setAttribute("failedLog","false"); %>
</head>

<body>
<header class="container">
	<img class="img-responsive" style="border-radius: 10px 10px 10px 10px;margin-top:4%;" src="images/logo.jpeg">
</header>

 
<div id="headerWrap" class="wrap">
	<header class="container">
		<nav  id="mainNav" class="navbar" role="navigation">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#mainMenu">
					<span style="background-color: #fff;" class="icon-bar"></span>
					<span style="background-color: #fff;"  class="icon-bar"></span>
					<span style="background-color: #fff;"  class="icon-bar"></span>
				</button>
				
			</div>
			<div class="collapse navbar-collapse" id="mainMenu">
				<ul id="menu" class="nav navbar-nav">
					<li><a href="Home.jsp">Home</a></li>
					<li><a href="Lavora.jsp">Lavora con noi</a></li>
					<li><a href="Panini.jsp">Panini</a></li>
					<li><a href="Rosticceria.jsp">Rosticceria</a></li>
					<li><a href="Bibite.jsp">Bibite</a></li>
					<li><a href="Dolci.jsp">Dolci</a></li>
					<li><a href="Registrazione.jsp">Registrati</a></li>
				</ul>
			</div>
		</nav>
	</header>
</div>

<div class="container">
	<h2>Registrati:</h2>
	<form name="reg" id="form" action="UserAction" method="POST">
		<div class="form-group">
			<label style="color:#fff" for="user">Nome:</label><br>
			<input type="text" id="firstname" name="firstname" onkeyup= "ValidareNome(document.reg.firstname)"><span style="color: white;" id=name></span>
		</div>
		<div class="form-group">
			<label style="color:#fff" for="user">Cognome:</label><br>
			<input type="text" id="lastname" name="lastname" onkeyup= "ValidareCognome(document.reg.lastname)"><span  style="color: white;" id=surname></span><br>
		</div>
		<div class="form-group">
			<label style="color:#fff" for="user">Indirizzo:</label><br>
			<input type="text" id="indirizzo" name="indirizzo">
		</div>
		<div class="form-group">
			<label style="color:#fff"  for="user">Telefono:</label><br>
			<input type="text"  id="telefono" name="telefono" onkeyup="ValidareTelefono(document.reg.telefono)"><span style="color: white;" id=cell></span>
		</div>
		<div class="form-group">
			<label style="color:#fff"  for="user">Email:</label><br>
			<input type="text"  id="email" name="email" onkeyup="ValidareEmail(document.reg.email)"><span style="color: white;" id=span></span>
		</div>
		<div class="form-group">
			<label style="color:#fff" for="user">Password:</label><br>
			<input type="password" id="pass" name="pass" onkeyup="ValidarePassword(document.reg.pass)"><span style="color: white;" id=psw></span>
		</div>
		<div class="form-group">
			<input type="submit" id="submit" class="btn btn-default" name="submit" value="Registrati" > 
			<input type="hidden" name="action" value="registrazione">
			<input type="submit" id="login" name="login" class="btn btn-default" value="Ho già un account" onclick="document.reg.action='Accesso.jsp'"/>
		</div>
	</form>
</div>
	

		
<footer> 
	©2017 Authors Daniele Palmieri, Alfonso Di Pace, Marco Amorosi 					
</footer>	
		
</body>

</html>
