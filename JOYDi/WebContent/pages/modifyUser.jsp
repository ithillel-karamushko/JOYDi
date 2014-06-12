<%@page import="org.hillel.it.joydi.model.entities.Person"%>
<%@page
	import="org.hillel.it.joydi.connection.pool.ReUsableConnectionPool"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<jsp:useBean id="service" scope="application"
	class="org.hillel.it.joydi.service.imp.DiaryServiceImpl">
</jsp:useBean>
<%
	String email = (String) session.getAttribute("email");
	Person user = service.returnUserByEmail(email);
%>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div id="container">
		<div id="log">
			<form action="changePassword.jsp">
				<p>
					<input type="password" name="oldPassword" required size="25" /> <small>Type
						old password</small>
				</p>
				<p>
					<input type="password" name="newPassword" required size="25" /> <small>Type
						new password</small>
				</p>
				<p>
					<input type="password" name="confirmPassword" required size="25" />
					<small>Confirm new password</small>
				</p>
				<input type="submit" value="Change password" />
			</form>

			<form action="changeName.jsp">
				<p>
					<input type="text" name="newName" required size="25" /> <small>Type
						new Name</small>
				</p>
				<input type="submit" value="Change name" />
			</form>

			<form action="changeCountry.jsp">
				<p>
					<input type="text" name="country" required size="25" /> <small>Type Country</small>
				</p>
				<input type="submit" value="Change country" />
			</form>

		</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>