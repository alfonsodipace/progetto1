<%@page import="bean.ProdottoBeanDao"%>
<%@page import="bean.ProdottoBean"%>
<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>I-PHAME</title>
		<link type="text/css" rel="stylesheet" href="CSS/productsPagesCSS.css"/>
		<link rel="icon" href="images/favicon.jpg" />
		<script src="js/jquery.js"></script> 
</head>

<body>

<div id="all">

	<img id= "logo" src="images/logo.jpeg" style="height: 190px; ">

	<div id="menubar">
	<ul id="menu">
 		<li><a href="Home.jsp">Home</a></li>
 		<li><a href="">Menu</a></li>
 		<li><a href="">Panini</a></li>
 		<li><a href="">Rosticceria</a></li>
 		<li><a href="">Dolci</a></li>
 		<li><a href="">Bibite</a></li>
 		<li><a href="">Info</a></li>
 		<li><a href="Registrazione.jsp">Login</a></li>
	</ul>
	</div>
	



<form action="">
<ul class="body">

<%

ProdottoBeanDao dao = new ProdottoBeanDao(); 				//  istanzio oggetti a caso

ArrayList<ProdottoBean> array = new ArrayList<ProdottoBean>();		// INSTANZIO ARRAYLIST
Collection<ProdottoBean> lista = new HashSet<ProdottoBean>(array);	// INSTANZIO COLLECTION  --- mannaccia a me è che l'ho usato --- 
lista=dao.doRetrieveAllByTipo("panino");
List<ProdottoBean> userList = new ArrayList<ProdottoBean>(lista);		//  CONVERTO COLLECTION IN ARRAYLIST
for (int i = 0; i < userList.size(); i++) { %>                 
  <li class="service-list">
        <a href=""><img src="images/panino.jpeg" alt="icon" /></a> </br> <!-- serve-invece -->
        <input type="submit" id="submit" class="button" name="submit" value="+" > 
        <span style="color: white;" class="span"><% out.println(userList.get(i).getNome()); %></span>
	    <input type="hidden" name="action" value="aggiungiCarrello">
  </li>
  <% } %>
</ul>

</form>

</div>


<footer> 
©2017 Authors Daniele Palmieri, Alfonso di Pace, Marco Amorosi 					
</footer>	
	
</body>


</html>