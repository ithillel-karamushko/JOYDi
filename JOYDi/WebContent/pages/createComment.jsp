<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<%
	int articleId = Integer.valueOf((String) request
			.getParameter("articleId"));
%>
<title>JOYDi</title>
<link rel="stylesheet" type="text/css" media="screen,projection"
	href="screen.css" />
</head>
<body>
	<jsp:include page="header.jsp" />
	<div id="container">
		<div id="log">
			<form action="saveComment.jsp?articleId=<%=articleId%>" method="post">
				<p>
					Type your comment:<br> <textarea name="commentText" rows="10"
							cols="50"></textarea>
				</p>
				<input type="submit" value="Post comment"> </input>
			</form>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>