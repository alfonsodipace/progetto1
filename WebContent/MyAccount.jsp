<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="javax.*" %>
<!DOCTYPE html>
<html>
<head>
	<jsp:useBean id="user" class="bean.UtenteBean" scope="session"/>  
	<meta  http-equiv="Content-Type" content="text/html" charset="UTF-8" >
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>I-PHAME</title>
	<link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="font-awesome-4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="CSS/myAccountCSS.css"/>
	<link rel="icon" href="images/favicon.jpg" />
	<script src="js/ModificaDati.js"></script>
	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
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
					<li><a href="MyAccount.jsp">Il mio account</a></li>		
       				<li><a href="Carrello.jsp">Carrello</a></li>
       				<li><a href="MyOrders.jsp">I miei ordini</a></li>
       				<li><a href="${pageContext.request.contextPath}/UserAction?action=logout">Logout</a></li>			
				</ul>
			</div>
		</nav>
	</header>
</div>	
	
<div class="container">
	<form name="frm" action="UserAction" method="post">
		<label style="color:#fff;">Email: </label>&nbsp; &nbsp;<input type="text" name="emai" value="<%=user.getEmail()%>" disabled> 
		<br>
		<br>
		<label style="color:#fff;">Nome:</label>&nbsp; &nbsp; <input type="text" name="firstname" class="comment" value="<%=user.getNome()%>" disabled> 
	    <br>
	    <br>
	    <label style="color:#fff;">Cognome:</label>&nbsp; &nbsp;<input type="text" name="lastname" class="comment" value="<%=user.getCognome()%>"disabled>
	    <br>
	    <br>
	    <label style="color:#fff;">Indirizzo:</label> &nbsp; &nbsp;<input type="text" name="indirizzo" class="comment" value="<%=user.getIndirizzo()%>"disabled>
	    <br>
	    <br>
	    <label style="color:#fff;">Telefono: </label>&nbsp; &nbsp; <input type="text" name="telefono" class="comment" value="<%=user.getTelefono()%>"disabled>
	   	<br>
	    <br>
	    <div class="form-group">
	   
	    <input type="submit" id="aggiorna" class="btn btn-default"  value="Aggiorna" disabled>
	    <input type="hidden" name="action" value="aggiornamento">
			<input type="button" id="submit" class="btn btn-default" name="submit" value="Modifica" onclick="cambia()"> 
		
			
		</div>
	</form>
</div>
	
		
<footer> 
	©2017 Authors Daniele Palmieri, Alfonso di Pace, Marco Amorosi
</footer>
	
</body>

</html>