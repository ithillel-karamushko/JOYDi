<%@page import="org.hillel.it.joydi.model.entities.*"%>
<%@page import="java.util.List"%>
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
										if (user.geteMail().equals(email)) {
											String theme = article.getThemeOfTheArticle();
											int id = article.getId();
							%>
							<div id="sidebar">
								<li><a href="showArticle.jsp?id=<%=id%>"><%=theme%></a></li>
							</div>
						<dd class="summary">
							<a href="actions.jsp?action=delete&id=<%=id%>">Delete this
								article</a>
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
						<li class="title">My Diary</li>
						<li><a href="UserPage.jsp">Home</a></li>
					</ul>
					<ul>
						<li class="title">Top Articles in JOYDi</li>
						<li><a href="#4">Java is good</a></li>
						<li><a href="#5">HTML is not good</a></li>
					</ul>
					<ul>
						<li class="title">Latest Articles in JOYDi</li>
						<li><a href="#6">HTML makes me cry</a></li>
						<li><a href="#7">IT Hillel</a></li>
					</ul>

				</div>
			</div>
		</div>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>