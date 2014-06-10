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
<%
	ReUsableConnectionPool rc = new ReUsableConnectionPool();
%>
<jsp:useBean id="personsList" scope="application"
	class="java.util.ArrayList">
</jsp:useBean>
<jsp:useBean id="person" scope="application"
	class="org.hillel.it.joydi.persistance.inmemory.InMemoryPersonRepository">
	<jsp:setProperty property="persons" name="person"
		value="${personsList}" />
</jsp:useBean>
<jsp:useBean id="articlesList" scope="application"
	class="java.util.ArrayList">
</jsp:useBean>
<jsp:useBean id="commentsList" scope="application"
	class="java.util.ArrayList">
</jsp:useBean>
<jsp:useBean id="text" scope="application"
	class="org.hillel.it.joydi.persistance.inmemory.InMemoryTextRepository">
	<jsp:setProperty property="article" name="text" value="${articlesList}" />
	<jsp:setProperty property="comment" name="text" value="${commentsList}" />
</jsp:useBean>
<jsp:useBean id="picture" scope="application"
	class="org.hillel.it.joydi.persistance.inmemory.InMemoryPictureRepository">
	<jsp:setProperty property="rc" name="picture" value="<%=rc%>" />
</jsp:useBean>
<jsp:useBean id="service" scope="application"
	class="org.hillel.it.joydi.service.imp.DiaryServiceImpl">
	<jsp:setProperty property="personRepository" name="service"
		value="${person}" />
	<jsp:setProperty property="textRepository" name="service"
		value="${text}" />
	<jsp:setProperty property="pictureRepository" name="service"
		value="${picture}" />
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