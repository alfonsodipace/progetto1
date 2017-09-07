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
	<script src="js/ProductValidation.js"></script>
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
					<li><a href="#">Gestisci ordini</a></li>
					<li><a href="AddProdotto.jsp">Aggiungi Prodotto</a></li>
					<li><a href="${pageContext.request.contextPath}/UserAction?action=logout">Logout</a></li>
				</ul>
			</div>
		</nav>
	</header>
</div>

<div class="container">
	<h2>Aggiungi un prodotto:</h2>
	<form name="reg" id="form" action="Fileupload" enctype= multipart/form-data method="post">
 		<input type="hidden" name="email" value=<% out.print(user.getEmail());%>>
		<div class="form-group">
		<select name="tipo">
			<option value="panino">Panino</option>
			<option value="rosticceria">Rosticceria</option>
			<option value="bibita">Bibita</option>
			<option value="dolce">Dolce</option>
		</select>
		</div>
		<div class="form-group">
			<label style="color:#fff" for="user">Nome:</label><br>
			<input type="text" id="nomeProdotto" name="nomeProdotto" onkeyup="ValidareNome(document.reg.nomeProdotto)"><span style="color: white;" id="name"></span>
		</div>
		<div class="form-group">
			<label style="color:#fff" for="user">Descrizione:</label><br>
			<input type="text" id="descrizione" name="descrizione" onkeyup="ValidareDesc(document.reg.descrizione)"><span  style="color: white;" id="description"></span>
		</div>
		<div class="form-group">
			<label style="color:#fff" for="user">Prezzo:</label><br>
			<input type="text" id="pezzo" name="prezzo" onkeyup="ValidarePrice(document.reg.prezzo)"><span  style="color: white;" id="price"></span>
		</div>
		<div class="form-group">
		<input type="file" class="btn btn-default" name="attach"> 
 		 <input type="reset" class="btn btn-default" value="reset" >
 		 </div>	
		<div class="form-group">
			<input type="submit" id="submit" class="btn btn-default" name="submit" value="INVIA" > 
			<input type="hidden" name="action" value="aggiungiProdotto">
		</div>
	</form>
</div>
	

		
<footer> 
	©2017 Authors Daniele Palmieri, Alfonso Di Pace, Marco Amorosi 					
</footer>	
		
</body>

</html>
