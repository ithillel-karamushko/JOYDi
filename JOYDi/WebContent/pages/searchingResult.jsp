<%@page import="org.hillel.it.joydi.model.entities.Article"%>
<%@page import="java.util.List"%>
<%@page
	import="org.hillel.it.joydi.persistance.repository.TextRepository"%>
<%@page import="org.hillel.it.joydi.model.search.ArticleCriteria"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
<jsp:useBean id="service" scope="application"
	class="org.hillel.it.joydi.service.imp.DiaryServiceImpl">
</jsp:useBean>
<%
	String author = (String) request.getParameter("author");
	if (author.equals("")) {
		author = null;
	}
	String theme = (String) request.getParameter("theme");
	if (theme.equals("")) {
		theme = null;
	}
	String tags = (String) request.getParameter("tags");
	if (tags.equals("")) {
		tags = null;
	}
	TextRepository tr = service.getTextRepository();

	ArticleCriteria ac = new ArticleCriteria(author, theme, tags, tr);
	List<Article> result = service.findArticles(ac);
%>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div id="container">
		<div id="wrapper">
			<div id="content-wrapper">
				<div id="content">
					<dl>
						<dt>Next articles was found:</dt>
						<hr>
						<dd>
							<%
								if (result.size() == 0) {
									out.print("Nothing was founded");
								} else {
									for (Article article : result) {
										int id = article.getId();
							%>
							<div id="sidebar">
								<li><a href="showArticle.jsp?id=<%=id%>"><%=article.getThemeOfTheArticle()%></a></li>
							</div>
							<%
								}
								}
							%>						
					</dl>
				</div>
			</div>
			<div id="sidebar-wrapper">
				<div id="sidebar">
					<ul>
						<li class="title">Actions</li>
						<li><a href="UserPage.jsp">Home</a></li>
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
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>