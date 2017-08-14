<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>         									      <!--  JUST A TESTING PAGE -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
 <jsp:useBean id="UtenteBean" class="bean.UtenteBean" scope="session"/>  

<script src="js/jquery.js" ></script>  <!--  LIBRERIA JQUERY -->
</head>

<script>



</script>   

 <jsp:getProperty property="pass" name="UtenteBean"/>      

<body>
<form action="MainTest" method="get">
<input type="text" id="email" name="email"> 
<input type="submit" value="test!" id="bttHello" > 


<p id="result1"> </p>



</form>

</body>
</html>
