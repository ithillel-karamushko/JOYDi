<%@page import="java.util.List"%>
<%@page import="org.hillel.it.joydi.model.entities.Comment"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JOYDi</title>
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
						<dt>Article:</dt>
						<dd>
							<p class="img">
								<img src="images/sample.png" width="250px" height="171px"
									alt="Sample Picture Here" />

							</p>
							<p><%=article.getThemeOfTheArticle()%></p>
							<hr>
							<p><%=article.getTextOfTheArticle()%></p>
							<p>
							<hr>
						<dd class="summary">
							Posted By:
							<%=article.getAuthor().getName()%></a> on
							<%=article.getDate()%><br><%=article.getLike()%>
							Likes |
							<%=article.getDisLike()%>
							Dislikes <br> <a href="actions.jsp?action=like&id=<%=id%>">I
								like this article</a> | <a
								href="actions.jsp?action=dislike&id=<%=id%>">I don`t like
								this article</a> | <a href="actions.jsp?action=comment&id=<%=id%>">Post
								a comment</a>
						</dd>
						<dt>Comments:</dt>
						<%
							if (text.getComment() == null) {
								out.print("No comments");
							} else {
								for (Comment c : text.getComment()) {
									if (c.getArticleId() == id) {
						%><br>
						<blockquote
							style="background-color: #f9f9f9; border: 2px #555555 solid; padding: 14px; margin: 0px 0px 0px 0px;">
							<%
								out.print(c.getCommentText());
								int kill = c.getId();
							%>
							<dd class="summary">
								<a href="actions.jsp?action=deleteComment&commentId=<%=kill%>&id=<%=id%>">Delete
									comment</a>
							</dd>
						</blockquote>
						<%
							}
								}
							}
						%>
					</dl>
				</div>
			</div>
			<div id="sidebar-wrapper">
				<div id="sidebar">
					<ul>
						<li class="title">Home Page</li>
						<li><a href="UserPage.jsp">Home</a></li>
					</ul>
				</div>
			</div>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>