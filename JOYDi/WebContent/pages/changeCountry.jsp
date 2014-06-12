<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
<jsp:useBean id="service" scope="application"
	class="org.hillel.it.joydi.service.imp.DiaryServiceImpl">
	<jsp:setProperty property="personRepository" name="service"
		value="${person}" />
	<jsp:setProperty property="textRepository" name="service"
		value="${text}" />
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