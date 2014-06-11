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
<%
	int id = Integer.valueOf((String) request.getParameter("id"));
	Article a = service.returnArticleById(id);
	String action = (String) request.getParameter("action");
	if (action.equals("delete")) {
		service.deleteArticleById(id);
		response.sendRedirect("myArticles.jsp");
	}
	if (action.equals("like")) {
		service.pushLike(id);
		String redirect = "showArticle.jsp?id=" + id;
		response.sendRedirect(redirect);
	}
	if (action.equals("dislike")) {
		service.pushDisLike(id);
		String redirect = "showArticle.jsp?id=" + id;
		response.sendRedirect(redirect);
	}
	if (action.equals("comment")) {
		String redirect = "createComment.jsp?articleId=" + id;
		response.sendRedirect(redirect);
	}
	if (action.equals("modify")) {
		String redirect = "modifyArticle.jsp?id=" + id;
		response.sendRedirect(redirect);
	}
	if (action.equals("deleteComment")) {
		int articleId = Integer.valueOf((String) request
				.getParameter("commentId"));
		service.deleteCommentById(id);
		String redirect = "showArticle.jsp?id=" + id;
		response.sendRedirect(redirect);
	}
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</body>
</html>