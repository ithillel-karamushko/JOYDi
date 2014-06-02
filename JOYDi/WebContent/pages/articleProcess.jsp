<%@page import="java.util.List"%>
<%@page import="org.hillel.it.joydi.model.entities.Article"%>
<%@page import="org.hillel.it.joydi.model.entities.Person"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:useBean id="personsList" scope="application"
	class="java.util.ArrayList">
</jsp:useBean>
<jsp:useBean id="textList" scope="application"
	class="java.util.ArrayList">
</jsp:useBean>
<jsp:useBean id="articles" scope="application"
	class="org.hillel.it.joydi.persistance.inmemory.InMemoryTextRepository">
	<jsp:setProperty property="article" name="articles" value="${textList}" />
</jsp:useBean>
<jsp:useBean id="person" scope="application"
	class="org.hillel.it.joydi.persistance.inmemory.InMemoryPersonRepository">
	<jsp:setProperty property="persons" name="person"
		value="${personsList}" />
</jsp:useBean>
<jsp:useBean id="service" scope="application"
	class="org.hillel.it.joydi.service.imp.DiaryServiceImpl">
	<jsp:setProperty property="personRepository" name="service"
		value="${person}" />
	<jsp:setProperty property="textRepository" name="service"
		value="${articles}" />
</jsp:useBean>
<%
	String email = (String) session.getAttribute("email");
	Person user = service.returnUserByEmail(email);
	String theme = (String) request.getParameter("theme");
	String textArticle = (String) request.getParameter("textArticle");
	String tags = (String) request.getParameter("tags");
	Article article = new Article(user, theme, textArticle, tags);
	service.saveArticle(article);
	List<Article> list = service.getTextRepository().getArticle();
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%=service.getTextRepository().getArticle()%>
	<%=list.get(0).getTextOfTheArticle()%>

</body>
</html>