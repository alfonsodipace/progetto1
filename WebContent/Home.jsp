<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<jsp:useBean id="UtenteBean" class="bean.UtenteBean" scope="session"/>  
		<meta  http-equiv="Content-Type" content="text/html" charset="UTF-8" >
		<title>I-PHAME</title>
		<link type="text/css" rel="stylesheet" href="CSS/home.css"/>
		<link rel="icon" href="images/favicon.jpg" />
		<script src="js/jquery.js" ></script> 
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
<br>
<div id="section-home">

			
					<div style="display: inline-block">
					<h2> PIU' VENDUTO </h2>
					<img class="img-home" src="images/panino.jpeg" >
					</div>
	
				<div style="display: inline-block">
				<h2> MENU' DEL GIORNO</h2>
				<img class="img-home"  src="images/menu.jpeg">
					</div>			
			
		
		
		
		
		
					<div>
					<h3> SEGUICI SU FACEBOOK!</h3>
			 		 <a href="https://www.facebook.com/iPhameFisciano"><img class="img-home"  src="images/face.png"></a>
					</div>
	
					<div>
					<h3> COME ACQUISTARE</h3>
					<p class="desc">
					Il servizio di vendita Online di I-PHAME offre copertura soltanto nella provincia di salerno,
					dopo aver effettuato un ordine, il pagamento va effettuato o alla consegna, o al ritiro diretto
					della merce in sede, trovate l'indirizzo e i nostri contatti in fondo alla pagina
					</p>
					</div>
					<div>
					<h3> I NOSTRI PRODOTTI</h3>
					<p class="desc">
					I-PHAME garantisce sempre prodotti freschi, genuini e rigorosamente italiani, tutte le nostre carni sono 
					di prima scelta e di origine controllata, e' possibile per i clienti
					con disturbi alimentari indicare al momento dell'ordine se si vogliono escludere determinati ingredienti dai prodotti,
				 	inoltre sono disponibili anche panini senza glutine per
					celiaci  
					</p>
					</div>	
	</div>	
		

</div>
		
<footer> 
					<br>
					<br>
		
					
					©2017 Authors Daniele Palmieri, Alfonso di Pace, Marco Amorosi
					
</footer>	
</body>
</html>
