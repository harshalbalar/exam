<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%  
response.setHeader("Cache-Control","no-store");   
response.setHeader("Pragma","no-cache");   
response.setHeader ("Expires", "0"); //prevents caching at the proxy server  
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="register" method="post">
	Username : <input type="text" name="user" placeholder="Username"><br>
	Phone number : <input type="text" name="tel" placeholder="Phone Number"><br>
	Password : <input type="password" name="pwd" placeholder="Password"><br>
	Confirm Password : <input type="password" name="cpwd" placeholder="Confirm Password"><br>
	<input type="submit" value="submit">
</form>
</body>
</html>