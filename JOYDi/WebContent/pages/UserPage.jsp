<%@page import="java.util.List"%>
<%@page import="org.hillel.it.joydi.model.entities.Article"%>
<%@page import="org.hillel.it.joydi.model.entities.Person"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<title>JOYDi</title>
<link rel="stylesheet" type="text/css" media="screen,projection"
	href="screen.css" />
<%
	List<Article> newArticles = service.newArticles();
	String email = (String) session.getAttribute("email");
	Person user = service.returnUserByEmail(email);
%>
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
					Your name:
					<%=user.getName()%>
					<hr>
						Your ages: <%=user.getAge()%><hr>
							Your country: <%=user.getCountry()%><hr>
								Your Email: <%=user.geteMail()%><hr>
									Your Gender: <%=user.getGender()%><hr>
				</div>
			</div>
			<div id="sidebar-wrapper">
				<div id="sidebar">
					<ul>
						<li class="title">Home</li>
						<li><a href="myArticles.jsp">My Articles</a></li>
						<li><a href="createArticle.jsp">Add new Article</a></li>
						<li><a href="searchingForm.jsp">Find Articles</a></li>
						<li><a href="logout.jsp">Logout</a></li>
					</ul>
					<ul>
						<li class="title">Latest Articles in JOYDi</li>
						<%
							for (Article art : newArticles) {
								String theme = art.getThemeOfTheArticle();
								int id = art.getId();
						%>
						<li><a href="showArticle.jsp?id=<%=id%>"><%=theme%></a></li>
						<%
							}
						%>
					</ul>
				</div>
			</div>
		</div>
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>
