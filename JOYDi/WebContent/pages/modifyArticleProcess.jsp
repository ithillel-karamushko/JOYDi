<%@page
	import="org.hillel.it.joydi.connection.pool.ReUsableConnectionPool"%>
<%@page import="org.hillel.it.joydi.model.entities.Article"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<jsp:useBean id="service" scope="application"
	class="org.hillel.it.joydi.service.imp.DiaryServiceImpl">
</jsp:useBean>
<c:set var="id" value="${param.id}"></c:set>
<c:set var="theme" value="${param.theme}"></c:set>
<c:set var="articleText" value="${param.textArticle}"></c:set>
<c:set var="tag" value="${param.tags}"></c:set>
${service.modifyArticle(id,theme,articleText,tag)}
<c:redirect url="showArticle.jsp?id=${id}"></c:redirect>
</head>
<body>

</body>
</html>