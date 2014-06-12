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
<title>JOYDi registration</title>
<link rel="stylesheet" type="text/css" media="screen,projection"
	href="screen.css" />
<%
	String oldPassword = request.getParameter("oldPassword");
	String newPassword = request.getParameter("newPassword");
	String confirmPassword = request.getParameter("confirmPassword");
	String email = (String) session.getAttribute("email");
	service.changePassword(oldPassword, newPassword, confirmPassword, email);
	response.sendRedirect("logout.jsp");
%>
</head>
<body>

</body>
</html>