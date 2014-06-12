<%@page import="java.util.List"%>
<%@page import="org.hillel.it.joydi.model.entities.*"%>
<%@page
	import="org.hillel.it.joydi.connection.pool.ReUsableConnectionPool"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JOYDi</title>
<jsp:useBean id="service" scope="application"
	class="org.hillel.it.joydi.service.imp.DiaryServiceImpl">
</jsp:useBean>
<%
	String email = (String) request.getParameter("email");
	String emailSession = (String) session.getAttribute("email");
	Person user = service.returnUserByEmail(email);
	List<Article> result = service.findUserArticles(email);
	if (email.equals(emailSession)) {
		response.sendRedirect("myArticles.jsp");
	}
%>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div id="container">
		<div id="wrapper">
			<div id="content-wrapper">
				<div id="content">
					<dl>
						<dt><%=user.getName()%>
							Personal information and Articles :
						<dd>
							<p class="img">
								<img src="images/avatar.png" width="250px" height="171px"
									alt="Sample Picture Here" />
							</p>
						</dd>
					</dl>
					Name:
					<%=user.getName()%>
					<hr>
					Ages:
					<%=user.getAge()%><hr>
					Country:
					<%=user.getCountry()%><hr>
					Email:
					<%=user.geteMail()%><hr>
					Gender:
					<%=user.getGender()%><hr>
					<dd>
						<%
							if (result.size() == 0) {
								out.print("This user doesnt have any articles");
							} else {
								for (Article a : result) {
						%>
						<div id="sidebar">
							<li><a href="showArticle.jsp?id=<%=a.getId()%>"><%=a.getThemeOfTheArticle()%></a></li>
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
						<li><a href="myArticles.jsp">My Articles</a></li>
						<li><a href="createArticle.jsp">Add new Article</a></li>
						<li><a href="searchingForm.jsp">Find Articles</a></li>
						<li><a href="modifyUser.jsp">Account settings</a></li>
						<li><a href="logout.jsp">Logout</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>