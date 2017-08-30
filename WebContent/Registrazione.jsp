<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
		<meta  http-equiv="Content-Type" content="text/html" charset="UTF-8" >
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>I-PHAME</title>
		<link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="font-awesome-4.7.0/css/font-awesome.min.css">
		<link rel="icon" href="images/favicon.jpg" />
		<script src="js/jquery-3.2.1.min.js"></script>
		<script src="js/Validation.js"></script>
		<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
		<style>
		h2,a{color:#fff;
		}
		
			footer {
		color: #fff;
			font-size: 15px;
			text-align:center;
			background-color: #333;
			padding: 40px 0;
			margin-top: 40px;
		}
		body{background-color: #333;
			font-size: 18px;
		}
	</style>
</head>

<body>
<header class="container">
	<img class="img-responsive" style="border-radius: 10px 10px 10px 10px;margin-top:4%;" src="images/logo.jpeg">
</header>
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

<div id="headerWrap" class="wrap">
		<header class="container">
			<nav  id="mainNav" class="navbar" role="navigation">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#mainMenu">
						<span style="background-color: #fff;" class="icon-bar"></span>
						<span style="background-color: #fff;"  class="icon-bar"></span>
						<span style="background-color: #fff;"  class="icon-bar"></span>
					</button>
					<a href="Home.jsp" class="navbar-brand">I-PHAME</a>
				</div>
				<div class="collapse navbar-collapse" id="mainMenu">
						<ul id="menu" class="nav navbar-nav">
							 <li><a href="Home.jsp">Home</a></li>
 							<li><a href="#">Menù</a></li>
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
				<label style="color:#fff"  for="user">Email:</label><br>
				<input type="text"  id="email" name="email" onkeyup="ValidareEmail(document.reg.email)"><span style="color: white;" id=span></span>
			</div>
			<div class="form-group">
				<label style="color:#fff" for="user">Password:</label><br>
				<input type="password" id="pass" name="pass" onkeyup= "ValidarePassword(document.reg.pass)"><span style="color: white;" id=psw></span>
			</div>
			<div class="form-group">
				<input type="submit" id="submit" class="btn btn-default" name="submit" value="Registrati" > 
				<input type="hidden" name="action" value="registrazione">
				<input type="submit" id="login" name="login" class="btn btn-default" value="Ho già un account" onclick="document.reg.action='Accesso.jsp'"/>
			</div>
		</form>
	</div>
		

		
			

<footer> 

©2017 Authors Daniele Palmieri, Alfonso di Pace, Marco Amorosi 					
</footer>	
		
</body>


</html>
