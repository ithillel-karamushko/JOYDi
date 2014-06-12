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
<title>Changing name</title>
<link rel="stylesheet" type="text/css" media="screen,projection"
	href="screen.css" />
<%
	String country = request.getParameter("country");
	String email = (String) session.getAttribute("email");
	service.changeCountry(country, email); 
	response.sendRedirect("UserPage.jsp");
%>
</head>
<body>

</body>
</html>