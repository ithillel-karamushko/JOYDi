<%@page
	import="org.hillel.it.joydi.connection.pool.ReUsableConnectionPool"%>
<%@page import="org.hillel.it.joydi.model.entities.Picture"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<title>JOYDi</title>
<link rel="stylesheet" type="text/css" media="screen,projection"
	href="screen.css" />
</head>
<body>
	<jsp:include page="header.jsp" />
	<div id="container">
		<div id="log">
			<form action="loginCheck.jsp" method="post">
				<br />Email:
				<input type="text" name="email"> <br />Password:<input
					type="password" name="password"> <br /> <input
						type="submit" value="Enter"> <a
							href="registrationForm.jsp">Click here if not registered</a> </input>
			</form>
		</div>
	</div>

	<jsp:include page="footer.jsp" />
</body>
</html>