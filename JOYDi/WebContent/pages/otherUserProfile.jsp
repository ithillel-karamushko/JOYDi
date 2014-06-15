<%@page import="java.util.List"%>
<%@page import="org.hillel.it.joydi.model.entities.*"%>
<%@page
	import="org.hillel.it.joydi.connection.pool.ReUsableConnectionPool"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JOYDi</title>
<jsp:useBean id="service" scope="application"
	class="org.hillel.it.joydi.service.imp.DiaryServiceImpl">
</jsp:useBean>
<c:set var="emailSession" value="${sessionScope.email}"></c:set>
<c:set var="email" value="${param.email}"></c:set>
<c:set var="user" value="${service.returnUserByEmail(email)}"></c:set>
<c:set var="result" value="${service.findUserArticles(email)}"></c:set>
<c:if test="${email==emailSession}">
	<c:redirect url="myArticles.jsp"></c:redirect>
</c:if>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div id="container">
		<div id="wrapper">
			<div id="content-wrapper">
				<div id="content">
					<dl>
						<dt>${user.name} Personal information and Articles:
						<dd>
							<p class="img">
								<img src="images/avatar.png" width="250px" height="171px"
									alt="Sample Picture Here" />
							</p>
						</dd>
					</dl>
					Name: ${user.name}
					<hr>
					Ages: ${user.age}
					<hr>
					Country: ${user.country}
					<hr>
					Email: ${user.eMail}
					<hr>
					Gender: ${user.gender}
					<hr>
					<c:choose>
						<c:when test="${result.size()==0}">
							<c:out value="This user doesnt have any articles"></c:out>
						</c:when>
						<c:otherwise>
							<c:forEach items="${result}" var="art">
								<div id="sidebar">
									<li><a href="showArticle.jsp?id=${art.id}">${art.themeOfTheArticle}</a></li>
								</div>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
			<div id="sidebar-wrapper">
				<div id="sidebar">
					<ul>
						<li class="title">Actions</li>
						<li><a href="myArticles.jsp">My Articles</a></li>
						<li><a href="createArticle.jsp">Add new Article</a></li>
						<li><a href="searchingForm.jsp">Find Articles</a></li>
						<li><a href="modifyUser.jsp">Account settings</a></li>
						<li><a href="logout.jsp">Logout</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>