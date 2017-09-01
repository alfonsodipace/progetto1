<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="javax.*" %>
<%@page import="bean.Riempie1Bean" %>
<%@page import="bean.Riempie1BeanDao" %>
<!DOCTYPE html>
<html>
<head>
	<jsp:useBean id="user" class="bean.UtenteBean" scope="session"/>  
	<meta  http-equiv="Content-Type" content="text/html" charset="UTF-8" >
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>I-PHAME</title>
	<link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="font-awesome-4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="CSS/carrelloCSS.css"/>
	<link rel="icon" href="images/favicon.jpg" />
	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>

	<% session.setAttribute("goodReg","no"); 
	   session.setAttribute("failedLog","false"); %>
	   
<body>

<header class="container">
	<img class="img-responsive" style="border-radius: 10px 10px 10px 10px; margin-top:4%;" src="images/logo.jpeg">
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
       							<li><a href="#">I miei ordini</a></li>
       							<li><a href="${pageContext.request.contextPath}/UserAction?action=logout">Logout</a></li>	
						<% } else { %> 
								<li><a href="#">Gestisci ordini</a></li>
								<li><a href="#">Aggiungi Prodotto</a></li>
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

<div class="container" >
	<h2>Il mio carrello:</h2>
	<div class="row" >
		<%! Riempie1BeanDao  dao = new Riempie1BeanDao(); 
			ArrayList<Riempie1Bean> userList = new ArrayList<Riempie1Bean>(); 
			double tot=0; 
			int idcarrello;%>
		
		<%	userList = dao.doRetrieveByKey(user.getEmail());
			for (Riempie1Bean s : userList) { %>   
				<form  action="CarrelloAction" name="test" method="get">   
					<div  class="col-md-4 text-center" >
						<div class="service">
							<% tot= tot + s.getPrezzo();				// passo tot e idCar al form sotto
							   idcarrello=s.getIdCarrello(); %>												
							<span style="color: #fff;"class="span"><% out.print(s.getNome()); %></span><br>
	     					<input type="hidden" name="prezzo" value=<% out.print(s.getPrezzo()); %>>
					  		<input type="hidden" name="email" value=<% out.print(user.getEmail()); %>>
	 						<input type="hidden" name="nome" value=<% out.print(s.getNome()); %>>
		     				<input type="hidden" name="tipo" value=<% out.print(s.getTipo()); %>>
	 						<input type="hidden" name="idprodotto" value=<% out.print(s.getIdProdotto()); %>>
	 						<input type="hidden" name="idcarrello" value=<% out.print(s.getIdCarrello()); %>>
							<input type="hidden" name="action" value="rimuovi">
			  				<span style="color: #fff;" class="span">€ &nbsp;<% out.print(s.getPrezzo()); %> &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;</span>
				 			<input type="submit" id="submit" class="button" name="submit" onclick="alert('Prodotto rimosso dal carrello!')" value=""> 
						</div>
					</div>
				</form>
		<% } %>	
	</div>
	
	</br>
	
	<form action="UserAction" method="get">

		<label style="color:#fff;">Totale: </label>&nbsp; &nbsp; <label style="color:#fff; "> <% out.print(tot); %> </label>&nbsp;&nbsp;&nbsp;
		<input type="hidden" name="email" value="<% out.print(user.getEmail()); %>">
		<input type="submit" id="submit2" class="btn btn-default" name="submit" value="Conferma Ordine" > 
		<input type="hidden" name="idcarrello" value="<% out.print(idcarrello); %>">	
		<input type="hidden" name="tot" value="<% out.print(tot); %>">
		<input type="hidden" name="action" value="buy">
	
	</form>
</div>


		
<footer> 
©2017 Authors Daniele Palmieri, Alfonso di Pace, Marco Amorosi		
</footer>
	
</body>

</html>