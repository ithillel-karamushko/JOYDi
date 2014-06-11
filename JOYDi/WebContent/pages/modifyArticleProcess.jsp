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