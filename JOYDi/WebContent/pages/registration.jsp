<%@page import="org.hillel.it.joydi.connection.pool.ReUsableConnectionPool"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page
	import="org.hillel.it.joydi.persistance.inmemory.InMemoryPersonRepository"%>
<%@page import="org.hillel.it.joydi.model.entities.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JOYdi registration</title>
<%
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	String password = request.getParameter("password");
	int year = Integer.parseInt(request.getParameter("yearOfBirth"));
	int day = Integer.parseInt(request.getParameter("dayOfBirth"));
	String country = request.getParameter("country");
	Months month = Months.valueOf(request.getParameter("monthOfBirth"));
	Gender gender = Gender.valueOf(request.getParameter("gender"));
	User user = new User(name, email, country, gender, year, month,
			day, password);

	boolean reg = service.saveUser(user);
%>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div id="container">
		<div id="log">
			<%
				if (!reg) {
					out.print("Such email already exists, please type other mail!");
				} else {
					out.print("Congratulations! You are registered on JOYdi! Welcome, "
							+ user.getName());
				}
			%>! Now you will be redirected to login page!
			<meta http-equiv="Refresh" content="3;url=login.jsp" />

		</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>