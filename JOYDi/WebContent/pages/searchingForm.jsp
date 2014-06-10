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
			<form action="searchingResult.jsp" method="post">
				<p>
					Author: <input type="text" name="author">
				</p>
				<p>
					Theme of the Article: <input type="text" name="theme">
				</p>
				<p>
					Tags: <input type="text" name="tags">
				</p>
				<input type="submit" value="Find"> <a
					href="registrationForm.jsp"></input>
			</form>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>