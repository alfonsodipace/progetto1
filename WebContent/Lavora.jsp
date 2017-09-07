<%@page import="bean.ProdottoBeanDao"%>
<%@page import="bean.ProdottoBean"%>
<%@ page import="java.util.*" %>
<%@ page import="javax.*" %>
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
	<link rel="stylesheet" type="text/css" href="CSS/lavoraCSS.css"/>
	<link rel="icon" href="images/favicon.jpg" />
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
					<%  
						if (user.getState().equals("loggato")) { 
							if(user.getTipo().equals("utente")) { %>
								<li><a href="MyAccount.jsp">Il mio account</a></li>
								<li><a href="Carrello.jsp">Carrello</a></li>
       							<li><a href="MyOrders">I miei ordini</a></li>
       							<li><a href="${pageContext.request.contextPath}/UserAction?action=logout">Logout</a></li>	
						<% } else { %> 
								<li><a href="#">Gestisci ordini</a></li>
								<li><a href="AddProdotto.jsp">Aggiungi Prodotto</a></li>
								<li><a href="${pageContext.request.contextPath}/UserAction?action=logout">Logout</a></li>
							<% } 
						} else { %>
							 <li><a href="Registrazione.jsp">Login</a></li>
				  	 <% } %>
				</ul>
			</div>
		</nav>
	</header>
</div>

<div class="container">
	<h2>I-phame cerca personale  per ampliare la gestione</h2><br>
	<p>Sono passati tanti anni dalla nostra apertura nella sede di Fisciano, siamo cresciuti tantissimo da allora
	adesso abbiamo bisogno di aumentare le forze per fare sempre di meglio! se credi di essere una persona intraprendente e ti va di crescere con noi
	sei esattamente la persona che cerchiamo, ma se hai una delle seguenti caratteristiche allora considerati assunto:</p>
	<br>
	<p>Cerchiamo personale con patente di tipo B, possibilmente disposta a turni serali e con qualche esperienza nel settore.</p>
	<p>Cerchiamo inoltre personale specializzato con un diploma alberghiero e con almeno 5 anni di esperienza in cucina.</p>
	<br>
	<p>Per qualsiasi contatto potete chiamare al numero presente nella home page!.</p>
</div>
	
<footer> 
	©2017 Authors Daniele Palmieri, Alfonso Di Pace, Marco Amorosi		
</footer>	

</body>

</html>