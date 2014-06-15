<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<jsp:useBean id="service" scope="application"
	class="org.hillel.it.joydi.service.imp.DiaryServiceImpl">
</jsp:useBean>
<title>Changing name</title>
<link rel="stylesheet" type="text/css" media="screen,projection"
	href="screen.css" />
<c:set var="name" value="${param.newName}"></c:set>
<c:set var="email" value="${sessionScope.email}"></c:set>
${service.changeName(name,email)}
<c:redirect url="UserPage.jsp"></c:redirect>
</head>
<body>

</body>
</html>