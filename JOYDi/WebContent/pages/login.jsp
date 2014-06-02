
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<title>JOYDi</title>
<link rel="stylesheet" type="text/css" media="screen,projection"
	href="screen.css" />
<jsp:useBean id="personsList" scope="page" class="java.util.ArrayList">
</jsp:useBean>
<jsp:useBean id="person" scope="page"
	class="org.hillel.it.joydi.persistance.inmemory.InMemoryPersonRepository">
	<jsp:setProperty property="persons" name="person"
		value="${personsList}" />
</jsp:useBean>
<jsp:useBean id="service" scope="page"
	class="org.hillel.it.joydi.service.imp.DiaryServiceImpl">
	<jsp:setProperty property="personRepository" name="service"
		value="${person}" />
</jsp:useBean>
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