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
<%
	ReUsableConnectionPool rc = new ReUsableConnectionPool();
%>
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
<jsp:useBean id="picture" scope="application"
	class="org.hillel.it.joydi.persistance.inmemory.InMemoryPictureRepository">
	<jsp:setProperty property="rc" name="picture" value="<%=rc%>" />
</jsp:useBean>
<jsp:useBean id="service" scope="application"
	class="org.hillel.it.joydi.service.imp.DiaryServiceImpl">
	<jsp:setProperty property="personRepository" name="service"
		value="${person}" />
	<jsp:setProperty property="textRepository" name="service"
		value="${text}" />
	<jsp:setProperty property="pictureRepository" name="service"
		value="${picture}" />
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
						<li class="title">My Diary</li>
						<li><a href="UserPage.jsp">Home</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>