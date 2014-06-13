<%@page import="org.hillel.it.joydi.model.entities.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:useBean id="service" scope="application"
	class="org.hillel.it.joydi.service.imp.DiaryServiceImpl">
</jsp:useBean>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<%
	String email = (String) session.getAttribute("email");
	Person user = service.returnUserByEmail(email);
	List<Article> list = service.getTextRepository().getArticle();
%>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<div id="container">
		<div id="wrapper">
			<div id="content-wrapper">
				<div id="content">
					<dl>
						<dt>Your Articles:</dt>
						<hr>
						<dd>
							<%
								if (list.size() == 0) {
									out.print("You doesnt have any articles");
								} else {
									for (Article article : list) {
										if (article.getAuthor().geteMail().equals(email)) {
											String theme = article.getThemeOfTheArticle();
											int id = article.getId();
							%>
							<div id="sidebar">
								<li><a href="showArticle.jsp?id=<%=id%>"><%=theme%></a></li>
							</div>
						<dd class="summary">
							<a href="actions.jsp?action=delete&id=<%=id%>">Delete this
								article</a> | <a href="actions.jsp?action=modify&id=<%=id%>">Modify
								this article</a>
						</dd>
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
						<li class="title">Actions</li>
						<li><a href="UserPage.jsp">Home</a></li>
						<li><a href="myArticles.jsp">My Articles</a></li>
						<li><a href="createArticle.jsp">Add new Article</a></li>
						<li><a href="searchingForm.jsp">Find Articles</a></li>
						<li><a href="modifyUser.jsp">Account settings</a></li>
						<li><a href="logout.jsp">Logout</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>