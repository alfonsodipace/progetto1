<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="javax.*" %>
<!DOCTYPE html>
<html>
<head>
	<jsp:useBean id="user" class="bean.UtenteBean" scope="session"/>
	<jsp:useBean id="oggettiCar" class="java.util.ArrayList" scope="session"/> 
	<jsp:useBean id="carrello" class="bean.CarrelloBean" scope="session"/>  
	<meta  http-equiv="Content-Type" content="text/html" charset="UTF-8" >
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>I-PHAME</title>
	<link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="font-awesome-4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="CSS/homeCSS.css"/>
	<link rel="icon" href="images/favicon.jpg" />
	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	<%session.setAttribute("acquistato", "no"); %>
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
					<li><a href="Carrello.jsp">Carrello</a></li>
					<%  
						if (user.getState().equals("loggato")) { 
							if(user.getTipo().equals("utente")) { %>
								<li><a href="MyAccount.jsp">Il mio account</a></li>
       							<li><a href="MyOrders.jsp">I miei ordini</a></li>
       							<li><a href="${pageContext.request.contextPath}/UserAction?action=logout">Logout</a></li>	
						<% } else { %> 
								<li><a href="GestisciOrdini.jsp">Gestisci ordini</a></li>
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

	<!-- Carousel -->
	<div id="carousel" class="carousel slide" data-ride="carousel" data-interval="1500" data-pause="hover">
		<!-- Indicatori delle immagini -->
		<ol class="carousel-indicators">
			<li data-target="#carousel" data-slide="0" class="active"></li>
			<li data-target="#carousel" data-slide="1"></li>
		</ol>
		<!-- immagini -->
		<div class="carousel-inner" style="background-color: #333; border-radius:10px;">
			<div class="item active">
				<h2 style="text-align:center;">SCOPRI IL PIU' VENDUTO </h2>
				<a href="piuVenduto.jsp"><img class="img-responsive" src="images/panino.jpeg"  ></a>
			</div>
			<div class="item">
				<h2 style="text-align:center;"> LAVORA CON NOI </h2>
				<a href="Lavora.jsp"><img class="img-responsive" src="images/work.png"></a>
			</div>
		</div>
		<!-- controlli -->
		<a class="left carousel-control" href="#carousel" role="button" data-slide="prev">
			<span class="glyphicon glyphicon-chevron-left"></span>
		</a>
		<a class="right carousel-control" href="#carousel" role="button" data-slide="next">
			<span class="glyphicon glyphicon-chevron-right"></span>
		</a>
	</div>


	<div id="content" >
		<div class="row" id="services">
			<div class="col-md-3 text-center" >
				<div class="service">
					<a href="https://www.facebook.com/iPhameFisciano"><i class="fa fa-facebook-square fa-4x" aria-hidden="true"></i></a>
					<h3>Seguici su facebook</h3>
				</div>
			</div>
			<div class="col-md-3 text-center" >
				<div class="service">
					<i class="fa fa-shopping-cart fa-4x" aria-hidden="true"></i>
					<h3> Come acquistare:</h3>
					<span>	Il servizio di vendita Online di I-PHAME offre copertura soltanto nella provincia di Salerno,
				dopo aver effettuato un ordine, il pagamento va effettuato o alla consegna, o al ritiro diretto
				della merce presso il punto vendita.</span>
				</div>
			</div>
			<div class="col-md-3 text-center" >
				<div class="service">
					<i class="fa fa-spoon fa-4x" aria-hidden="true"></i>
					<h3>I nostri prodotti:</h3>
					<span>I-PHAME garantisce sempre prodotti freschi e rigorosamente italiani, tutte le nostre carni sono 
				di prima scelta e di origine controllata, e' possibile per i clienti
				con disturbi alimentari indicare al momento dell'ordine se si vogliono escludere determinati ingredienti dai prodotti.</span>
				</div>
			</div>
			<div class="col-md-3 text-center" >
				<div class="service">
					<i class="fa fa-info-circle fa-4x" aria-hidden="true"></i>
					<h3>Info e contatti:</h3>
					<span>Cellulare: 3494356721</span><br>
					<span>Orario apertura: 9-16  /  19-23</span><br>
					<span>Via Roma 23, Fisciano</span>
				</div>
			</div>
		</div>
    </div>						
</div>	
	

<footer> 				
	©2017 Authors Daniele Palmieri, Alfonso Di Pace, Marco Amorosi		
</footer>	

</body>

</html>
