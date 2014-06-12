<%@page
	import="org.hillel.it.joydi.connection.pool.ReUsableConnectionPool"%>
<%@page import="java.util.*"%>
<%@page import="org.hillel.it.joydi.model.entities.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:useBean id="service" scope="application"
	class="org.hillel.it.joydi.service.imp.DiaryServiceImpl">
</jsp:useBean>
<%
	String email = (String) session.getAttribute("email");
	Person user = service.returnUserByEmail(email);
	String theme = (String) request.getParameter("theme");
	String textArticle = (String) request.getParameter("textArticle");
	String tags = (String) request.getParameter("tags");
	String url = (String) request.getParameter("pics");
	if (url.equals("")) {
		url = "images/sample.png";
	}
	Picture pic = new Picture(url);
	service.savePicture(pic);
	Article article = new Article(user, theme, textArticle, tags, pic);
	service.saveArticle(article);
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:forward page="myArticles.jsp"></jsp:forward>
</body>
</html>