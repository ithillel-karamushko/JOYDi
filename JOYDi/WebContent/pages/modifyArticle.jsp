<%@page import="org.hillel.it.joydi.model.entities.Article"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<jsp:useBean id="service" scope="application"
	class="org.hillel.it.joydi.service.imp.DiaryServiceImpl">
</jsp:useBean>
<c:set var="id" value="${param.id}"></c:set>
<c:set var="article" value="${service.returnArticleById(id)}"></c:set>
<c:set var="theme" value="${article.themeOfTheArticle}"></c:set>
<c:set var="articleText" value="${article.textOfTheArticle}"></c:set>
<c:set var="tag" value="${article.tags}"></c:set>
<title>JOYDi</title>
<link rel="stylesheet" type="text/css" media="screen,projection"
	href="screen.css" />
</head>
<body>
	<jsp:include page="header.jsp" />
	<div id="container">
		<div id="log">
			<form action="modifyArticleProcess.jsp?id=${id}" method="post">
				<p>
					Theme of the article: <br> <input type="article" name="theme"
						value="${theme}">
				</p>
				<p>
					Tags: <br> <input type="tags" name="tags" value="${tag}">
				</p>
				<p>
					Text of the article:<br> <textarea name="textArticle"
							rows="10" cols="50">${articleText}</textarea>
				</p>
				<input type="submit" value="Save modified article"> </input>
			</form>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>