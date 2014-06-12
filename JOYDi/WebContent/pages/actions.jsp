<%@page import="org.hillel.it.joydi.model.entities.Person"%>
<%@page import="org.hillel.it.joydi.model.entities.Article"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:useBean id="service" scope="application"
	class="org.hillel.it.joydi.service.imp.DiaryServiceImpl">
</jsp:useBean>





<%
	int id = Integer.valueOf((String) request.getParameter("id"));
	String email = (String) session.getAttribute("email");
	Article a = service.returnArticleById(id);
	String action = (String) request.getParameter("action");
	if (action.equals("delete")) {
		service.deleteArticleById(id);
		int pictureId = a.getPicture().getId();
		service.deletePictureById(pictureId);
		response.sendRedirect("myArticles.jsp");
	}
	if (action.equals("like")) {
		service.pushLike(id, email);  
		String redirect = "showArticle.jsp?id=" + id;
		response.sendRedirect(redirect);
	}
	if (action.equals("dislike")) {
		service.pushDisLike(id, email);
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