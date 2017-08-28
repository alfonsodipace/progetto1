<%@page import="bean.ProdottoBeanDao"%>
<%@page import="bean.ProdottoBean"%>
<%@ page import="java.util.*" %>
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
		<link rel="icon" href="images/favicon.jpg" />
		<script src="js/jquery-3.2.1.min.js"></script>
		<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
		<style>
		.service {
			background-color: #333;
			color: #fff;
			padding: 15px;
			margin-top: 20px;
			border-radius: 5px;
		}
		
		h2,h3,a ,span{color:#fff;}
		.container{
		
		}
		a:hover{color:#9d9d9d;}
		body{background-color: #333;
			font-size: 18px;
		}
		
		#submit{width:42px;
height: 42px;
color:#333;
background-color:#333;
background-image: url('images/1600.png');
background-repeat: no-repeat;
background-position: center;}
		
		footer {
		color: #fff;
			font-size: 15px;
			text-align:center;
			background-color: #333;
			padding: 40px 0;
			margin-top: 40px;
		}
	</style>
</head>
<body>
<header class="container">
	<img class="img-responsive" style="border-radius: 10px 10px 10px 10px;" src="images/logo.jpeg">
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
					<a href="Home.jsp" class="navbar-brand">I-PHAME</a>
				</div>
				<div class="collapse navbar-collapse" id="mainMenu">
						<ul id="menu" class="nav navbar-nav">
							 <li><a href="Home.jsp">Home</a></li>
 							<li><a href="#">Menù</a></li>
 							<li><a href="Panini.jsp">Panini</a></li>
 							<li><a href="#">Rosticceria</a></li>
 							<li><a href="#">Bibite</a></li>
 							<li><a href="#">Dolci</a></li>
 								<% 
									if (user.getState().equals("loggato")) { %>
	 								<li><a>Il mio account</a></li>
	 								
            								<li><a href="#">Carrello</a></li>
            								<li><a href="#">I miei ordini</a></li>
            								<li><a href="logout.jsp">Logout</a></li>
        								
 									<% } else { %>
 								<li><a href="Registrazione.jsp">Login</a></li>
								<% } %>
						</ul>
				</div>
			</nav>
		</header>
	</div>
	
		<div class="container">
		<div class="row" id="services">
		<form action="">
					<%!ProdottoBeanDao  dao = new ProdottoBeanDao(); 
						ArrayList<ProdottoBean> userList = new ArrayList<ProdottoBean>();%>

						<%		
							userList = dao.doRetrieveAllByTipo("panino");
						for (ProdottoBean s : userList) { %>                 
  					<div class="col-md-4 text-center" >
					<div class="service">
					<span style="color: white;" class="span"><% out.println(s.getNome()); %></span>
        				<a href=""><img class="img-responsive" src="images/panino.jpeg" alt="icon" /></a> <br> <!-- serve-invece -->
        				<input type="submit" id="submit" class="button" name="submit" value=""> 
	    				<input type="hidden" name="action" value="aggiungiCarrello">
					</div>
				</div>
  							<% } %>
						</form>
			
				</div>
			</div>
<footer> 
					
					©2017 Authors Daniele Palmieri, Alfonso di Pace, Marco Amorosi
					
</footer>	
</body>
</html>