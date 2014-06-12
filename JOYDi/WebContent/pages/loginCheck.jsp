<%@page import="org.hillel.it.joydi.model.entities.Person"%>
<%@page
	import="org.hillel.it.joydi.connection.pool.ReUsableConnectionPool"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
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
</head>
<body>
	<c:set var="email" value="${param.email}"></c:set>
	<c:set var="password" value="${param.password}"></c:set>
	<c:choose>
		<c:when test="${service.enter(email,password)!=null}">
			<c:set var="email" value="${param.email}" scope="session"></c:set>
			<c:redirect url="UserPage.jsp"></c:redirect>
		</c:when>
		<c:otherwise>
			<c:redirect url="error.jsp"></c:redirect>
		</c:otherwise>
	</c:choose>
</body>
</html>