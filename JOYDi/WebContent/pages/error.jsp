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
			<h1>Incorrect email or password. Please try again</h1>
			<meta http-equiv="Refresh" content="2;url=login.jsp" />
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>