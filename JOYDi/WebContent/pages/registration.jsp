<%@page import="java.security.Provider.Service"%>
<%@page import="org.hillel.it.joydi.model.entities.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:useBean id="service" scope="application"
	class="org.hillel.it.joydi.service.imp.DiaryServiceImpl" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JOYdi registration</title>
<%
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	String password = request.getParameter("password");
	int year = Integer.parseInt(request.getParameter("yearOfBirth"));
	int day = Integer.parseInt(request.getParameter("dayOfBirth"));
	Countries country = Countries.valueOf(request
			.getParameter("country"));
	Months month = Months.valueOf(request.getParameter("monthOfBirth"));
	Gender gender = Gender.valueOf(request.getParameter("gender"));
	User user = new User(name, email, country, gender, year, month,
			day, password);
	service.getClass();
%>



</head>
<body>
	<jsp:include page="header.jsp" />
	<%
		out.println(user.getName());
		out.println(user.geteMail());
		out.println(user.getCountry());
		out.println(user.getGender());
		out.println(user.getPassword());
		out.println(user.getAge());
	%>
	<jsp:include page="footer.jsp" />
</body>
</html>