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
	int articleId = Integer.valueOf((String) request
			.getParameter("articleId"));
	String email = (String) session.getAttribute("email");
	Person user = service.returnUserByEmail(email);
	String commentText = (String) request.getParameter("commentText");
	Comment comment = new Comment(user, commentText, articleId);
	service.saveComment(comment);
	String send = "showArticle.jsp?id="+articleId;
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:forward page="<%=send%>"></jsp:forward>
</body>
</html>