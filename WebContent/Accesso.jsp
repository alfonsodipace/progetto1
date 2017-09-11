<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<jsp:useBean id="user" class="bean.UtenteBean" scope="session"/>
	<jsp:useBean id="carrello" class="bean.CarrelloBean" scope="session"/>
	<jsp:useBean id="oggettiCar" class="java.util.ArrayList" scope="session"/>
	<meta  http-equiv="Content-Type" content="text/html" charset="UTF-8" >
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>I-PHAME</title>
	<link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="font-awesome-4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="CSS/registrationCSS.css"/>
	<link rel="icon" href="images/favicon.jpg" />
	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
<header class="container">
	<img class="img-responsive" style="border-radius: 10px 10px 10px 10px;margin-top:4%;" src="images/logo.jpeg">
</header>

<% if(session.getAttribute("goodReg").equals("ok")) { %>
	<script>
		alert("Registrazione effettuata!");
		<% session.setAttribute("goodReg","no");%>
	</script>
<% } %>

<% if(session.getAttribute("failedLog").equals("true")) { %>
	<script>
		alert("Email o Password non corretti");
	</script>
<% } %>

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
	<h2>Accedi:</h2><br>
	<form name="reg" id="form" action="UserAction" method="POST">
		<div class="form-group">
			<label style="color:#fff;" id="user">Email:</label>
			<input type="text"  style="width:180px;" id="email" class="form-control" name="email" >
		</div>
		<div class="form-group">
			<label style="color:#fff;" id="pass">Password:</label>
			<input type="password"  style="width:180px;" id="pass" class="form-control" name="pass">
		</div>
		<div class="form-group">
			<input type="submit" id="submit" class="btn btn-default" name="submit" value="Accedi" > 
			<input type="hidden" name="action" value="login">
		</div>
	</form>
</div>
	


<footer> 
	©2017 Authors Daniele Palmieri, Alfonso di Pace, Marco Amorosi 					
</footer>	
		
</body>

</html>