<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div id="container">
		<div id="log">
			<%
				session.removeAttribute("email");
				session.removeAttribute("password");
				session.invalidate();
			%>
			<h1>Logout was done successfully.</h1>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>