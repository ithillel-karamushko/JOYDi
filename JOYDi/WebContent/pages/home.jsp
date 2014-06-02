<%@page import="org.hillel.it.joydi.model.entities.Person"%>
<%@page import="org.hillel.it.joydi.model.entities.Article"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<title>JOYDi</title>
<link rel="stylesheet" type="text/css" media="screen,projection"
	href="screen.css" />
<jsp:useBean id="textList" scope="application"
	class="java.util.ArrayList">
</jsp:useBean>
<jsp:useBean id="text" scope="application"
	class="org.hillel.it.joydi.persistance.inmemory.InMemoryPersonRepository">
	<jsp:setProperty property="persons" name="person" value="${textList}" />
</jsp:useBean>
<jsp:useBean id="service" scope="application"
	class="org.hillel.it.joydi.service.imp.DiaryServiceImpl">
	<jsp:setProperty property="personRepository" name="service"
		value="${text}" />
</jsp:useBean>
<%
	String email = session.getAttribute("email");
	Person user = service.returnUserByEmail(email);
	Article article = new Article(user, "IT", "Java rules", "Java, IT");
%>
</head>
<body>
	<jsp:include page="header.jsp" />
	<table>
		<c:forEach var="num" items="${list}">
			<p>${num}</p>
		</c:forEach>
	</table>
	<jsp:include page="footer.jsp" />
</body>
</html>