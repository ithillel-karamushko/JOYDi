<%@page import="org.hillel.it.joydi.model.entities.Article"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
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
<%
	int id = Integer.valueOf((String) request.getParameter("id"));
	Article article = service.returnArticleById(id);
	String theme = article.getThemeOfTheArticle();
	String articleText = article.getTextOfTheArticle();
	String tag = article.getTags();
	service.deleteArticleById(id);
%>
<title>JOYDi</title>
<link rel="stylesheet" type="text/css" media="screen,projection"
	href="screen.css" />
</head>
<body>
	<jsp:include page="header.jsp" />
	<div id="container">
		<div id="log">
			<form action="saveArticle.jsp" method="post">
				<p>
					Theme of the article: <br> <input type="article" name="theme" value="<%=theme%>">
				</p>
				<p>
					Tags: <br> <input type="tags" name="tags" value="<%=tag%>">
				</p>
				<p>
					Text of the article:<br>
					<textarea name="textArticle" rows="10" cols="50"><%=articleText %></textarea>
				</p>
				<input type="submit" value="Save article">
				</input>
			</form>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>