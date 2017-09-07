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
	<link rel="stylesheet" type="text/css" href="CSS/productsPagesCSS.css"/>
	<link rel="icon" href="images/favicon.jpg" />
	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
<header class="container">
	<img class="img-responsive" style="border-radius: 10px 10px 10px 10px;margin-top:4%;" src="images/logo.jpeg">
</header>

<% if (user.getState().equals("loggato")) { %>
	<script>
		$('#submit').prop("disabled",true);
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
					<%  
						if (user.getState().equals("loggato")) { 
							if(user.getTipo().equals("utente")) { %>
								<li><a href="MyAccount.jsp">Il mio account</a></li>
								<li><a href="Carrello.jsp">Carrello</a></li>
       							<li><a href="MyOrders.jsp">I miei ordini</a></li>
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
	<div class="row" id="services">
	<%! ProdottoBeanDao  dao = new ProdottoBeanDao(); 
		ArrayList<ProdottoBean> userList = new ArrayList<ProdottoBean>();%>
	<%		
		userList = dao.doRetrieveAllByTipo("rosticceria");
		for (ProdottoBean s : userList) { %>    
		
		<% if (user.getState().equals("loggato")) {
		if(user.getTipo().equals("utente")) {%>
			<form  action="CarrelloAction" method="get">  
		<%} else if(user.getTipo().equals("admin")){ %>	
			<form  action="AdminAction" method="get">
		<%}} else { %>  
			<form action="CarrelloAction" method="get">
		<%} %>	       
			<div class="col-md-4 text-center" >
					<div class="service">
						<span style="color: white;" id="nome"class="span"><% out.print(s.getNome()); %></span>
   						<a href=""><img class="img-responsive" style="border-radius:10px;" src="<%out.print(s.getImmagine());%>"/></a><br> 
   						<input type="hidden" name="prezzo" value=<%out.print(s.getPrezzo());%>>
   						<input type="hidden" name="tipo" value="rosticceria">
   						<input type="hidden" name="email" value=<% out.print(user.getEmail());%>>
   						<input type="hidden" name="nome" value="<% out.print(s.getNome()); %>">
   						<input type="hidden" name="idprodotto" value=<% out.print(s.getIdProdotto()); %>>
   						<span style="color: white;" class="span"><% out.print(s.getDesc()); %></span><br>
   						<span style="color: white;" class="span">€ &nbsp;<% out.print(s.getPrezzo());%> &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;</span>
   						
   						 
   						<% if (user.getState().equals("loggato")) {
   						if(user.getTipo().equals("admin")){ %>
   						<input type="hidden" name="action" value="rimuoviProdotto"> 
   						<input type="submit" id="submit1" value="" class="button" name="submit1" onclick="alert('Prodotto rimosso dalla lista prodotti!')"> 
   						
   						<%}else { %>
   						<input type="hidden" name="action" value="aggiungi">
   						<input type="submit" id="submit" class="button" name="submit" onclick="alert('Prodotto aggiunto al carrello!')">
   						<%}
   						} else { %>
   						<input type="submit" id="submit" class="button" name="submit" onclick="alert('Prodotto aggiunto al carrello!')">
   						<%} %>
					</div>
				</div>
			</form>
	<% } %>
	</div>
</div>
	
<footer> 
	©2017 Authors Daniele Palmieri, Alfonso Di Pace, Marco Amorosi	
</footer>	

</body>

</html>