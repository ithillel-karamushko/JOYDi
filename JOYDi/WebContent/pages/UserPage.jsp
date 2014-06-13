<%@page import="java.util.List"%>
<%@page import="org.hillel.it.joydi.model.entities.Article"%>
<%@page import="org.hillel.it.joydi.model.entities.Person"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<jsp:useBean id="service" scope="application"
	class="org.hillel.it.joydi.service.imp.DiaryServiceImpl">
</jsp:useBean>
<title>JOYDi</title>
<link rel="stylesheet" type="text/css" media="screen,projection"
	href="screen.css" />
<c:set var="email" value="${sessionScope.email}"></c:set>
<c:set var="user" value="${service.returnUserByEmail(email)}"></c:set>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div id="container">
		<div id="wrapper">
			<div id="content-wrapper">
				<div id="content">
					<dl>
						<dt>Your personal information:</dt>
						<dd>
							<p class="img">
								<img src="images/avatar.png" width="250px" height="171px"
									alt="Sample Picture Here" />
							</p>

						</dd>
					</dl>
					Your name: ${user.name}
					<hr>Your ages: ${user.age}</hr>
					<hr>Your country: ${user.country}</hr>
					<hr>Your Email: ${user.eMail}</hr>
					<hr>Your Gender: ${user.gender}</hr>
					<hr>
				</div>
			</div>
			<div id="sidebar-wrapper">
				<div id="sidebar">
					<ul>
						<li class="title">Actions</li>
						<li><a href="myArticles.jsp">My Articles</a></li>
						<li><a href="createArticle.jsp">Add new Article</a></li>
						<li><a href="searchingForm.jsp">Find Articles</a></li>
						<li><a href="modifyUser.jsp">Account settings</a></li>
						<li><a href="logout.jsp">Logout</a></li>
					</ul>
					<ul>
						<li class="title">Latest Articles in JOYDi</li>
						<c:forEach items="${service.newArticles()}" var="article">
							<li><a href="showArticle.jsp?id=${article.id}">${article.themeOfTheArticle}</a></li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>
