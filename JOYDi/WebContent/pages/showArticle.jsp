<%@page import="org.hillel.it.joydi.model.entities.Article"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
<jsp:useBean id="text" scope="application"
	class="org.hillel.it.joydi.persistance.inmemory.InMemoryTextRepository">
	<jsp:setProperty property="article" name="text" value="${articlesList}" />
</jsp:useBean>
<jsp:useBean id="service" scope="application"
	class="org.hillel.it.joydi.service.imp.DiaryServiceImpl">
	<jsp:setProperty property="personRepository" name="service"
		value="${person}" />
	<jsp:setProperty property="textRepository" name="service"
		value="${text}" />
</jsp:useBean>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%
	int id = Integer.valueOf((String) request.getParameter("id"));
	Article article = service.returnArticleById(id);
%>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div id="container">
		<div id="wrapper">
			<div id="content-wrapper">
				<div id="content">
					<dl>
						<dt>
						<dd>
							<p class="img">
								<img src="images/sample.png" width="250px" height="171px"
									alt="Sample Picture Here" />

							</p>
							<p><%=article.getThemeOfTheArticle()%></p>
							<p><%=article.getTextOfTheArticle()%></p>
							<p>
						</dd>
					</dl>
				</div>
			</div>
			<div id="sidebar-wrapper">
				<div id="sidebar">
					<ul>
						<li class="title">Home Page</li>
						<li><a href="myArticles.jsp">My Articles</a></li>
						<li><a href="createArticle.jsp">Add new Article</a></li>
						<li><a href="logout.jsp">Logout</a></li>
					</ul>
				</div>
			</div>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>