<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="javax.*" %>
<%@page import="bean.*" %>
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
<% double tot=0; %>
<div class="container" >
	<h2>I miei ordini:</h2>
	<div class="row" >
		<%! OrdinaBeanDao  dao = new OrdinaBeanDao();
			ProdottoBeanDao daoP = new ProdottoBeanDao();
			ProdottoBean arrPr = new ProdottoBean();
			ArrayList<OrdinaBean> userList = new ArrayList<OrdinaBean>(); 
					%>
		
		<%	userList = dao.doRetrieveByKey(user.getEmail());
			for (OrdinaBean s : userList) { %>
				<% arrPr = daoP.doRetrieveById(s.getIdProdotto()); %>   
				<form  action="CarrelloAction" name="test" method="get">   
					<div  class="col-md-4 text-center" >
						<div class="service">											
							<span style="color: #fff; float:center;"class="span"><%= arrPr.getNome() %></span><br><br>
							<a href=""><img class="img-responsive" style="border-radius:10px; margin-left: 35%;width:100px; height: 100px;" src="<%=arrPr.getImmagine()%>"/></a><br>
							<span style="color: #fff;  "class="span">Acquistato il :<%= s.getDataOrdine() %>
							 <br>Prezzo: € &nbsp;<%=arrPr.getPrezzo() %></span>
				 			
						</div>
					</div>
				</form>
		<% } %>	
	</div>
</div>


		
<footer> 
©2017 Authors Daniele Palmieri, Alfonso di Pace, Marco Amorosi		
</footer>
	
</body>

</html>