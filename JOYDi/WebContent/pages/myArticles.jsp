<%@page import="org.hillel.it.joydi.model.entities.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:useBean id="service" scope="application"
	class="org.hillel.it.joydi.service.imp.DiaryServiceImpl">
</jsp:useBean>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<c:set var="email" value="${sessionScope.email}"></c:set>
<c:set var="user" value="${service.returnUserByEmail(email)}"></c:set>
<c:set var="list" value="${service.getTextRepository().getArticle()}"></c:set>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<div id="container">
		<div id="wrapper">
			<div id="content-wrapper">
				<div id="content">
					<dl>
						<dt>Your Articles:</dt>
						<hr>
						<dd>
							<c:choose>
								<c:when test="${list.size()==0}">
									<c:out value="You doesnt have any articles"></c:out>
								</c:when>
								<c:otherwise>
									<c:forEach items="${list}" var="art">
										<c:if test="${art.author.eMail==email}">
											<div id="sidebar">
												<li><a href="showArticle.jsp?id=${art.id}">${art.themeOfTheArticle}</a></li>
											</div>
											<dd class="summary">
												<a href="actions.jsp?action=delete&id=${art.id}">Delete
													this article</a> | <a
													href="actions.jsp?action=modify&id=${art.id}">Modify
													this article</a>
											</dd>
										</c:if>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</dd>
					</dl>
				</div>
			</div>

			<div id="sidebar-wrapper">
				<div id="sidebar">
					<ul>
						<li class="title">Actions</li>
						<li><a href="UserPage.jsp">Home</a></li>
						<li><a href="myArticles.jsp">My Articles</a></li>
						<li><a href="createArticle.jsp">Add new Article</a></li>
						<li><a href="searchingForm.jsp">Find Articles</a></li>
						<li><a href="modifyUser.jsp">Account settings</a></li>
						<li><a href="logout.jsp">Logout</a></li>
					</ul>
					<ul>
						<li class="title">Latest Articles in JOYDi</li>
						<c:forEach items="${service.newArticles()}" var="article">
							<li><a href="showArticle.jsp?id=${article.id}">${article.themeOfTheArticle}</a></li>
						</c:forEach>
					</ul>
					<ul>
						<li class="title">Highest rated articles in JOYDi</li>
						<c:forEach items="${service.topArticles()}" var="art">
							<li><a href="showArticle.jsp?id=${art.id}">${art.themeOfTheArticle}</a></li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>