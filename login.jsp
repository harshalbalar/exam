<%  
response.setHeader("Cache-Control","no-store");   
response.setHeader("Pragma","no-cache");   
response.setHeader ("Expires", "0"); //prevents caching at the proxy server  
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="login" method="post">
	Username : <input type="text" name="user" placeholder="Username"><br>
	Password : <input type="password" name="pwd" placeholder="Password"><br>
	<input type="checkbox" name="rememberme"> Remember Me
	<input type="submit" value="submit">
</form>
</body>
</html>