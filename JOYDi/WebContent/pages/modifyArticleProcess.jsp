<%@page
	import="org.hillel.it.joydi.connection.pool.ReUsableConnectionPool"%>
<%@page import="org.hillel.it.joydi.model.entities.Article"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<jsp:useBean id="service" scope="application"
	class="org.hillel.it.joydi.service.imp.DiaryServiceImpl">
</jsp:useBean>
<%
	int id = Integer.valueOf((String) request.getParameter("id"));
	String theme = request.getParameter("theme");
	String articleText = request.getParameter("textArticle");
	String tag = request.getParameter("tags");
	service.modifyArticle(id, theme, articleText, tag);
	String redirect = "showArticle.jsp?id="+id;
	response.sendRedirect(redirect);
%>
</head>
<body>

</body>
</html>