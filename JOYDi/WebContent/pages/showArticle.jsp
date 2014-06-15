<%@page import="org.hillel.it.joydi.model.entities.Person"%>
<%@page import="java.util.List"%>
<%@page import="org.hillel.it.joydi.model.entities.Comment"%>
<%@page import="org.hillel.it.joydi.model.entities.Article"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JOYDi</title>

<c:set var="id" value="${param.id}"></c:set>
<c:set var="article" value="${service.returnArticleById(id)}"></c:set>
<c:set var="url" value="${article.picture.fileUrl}"></c:set>
<c:set var="email" value="${sessionScope.email}"></c:set>
<c:set var="user" value="${service.returnUserByEmail(email)}"></c:set>
<c:set var="like" value="${article.whoLike}"></c:set>
<c:set var="dislike" value="${article.whoDoesntLike}"></c:set>


</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div id="container">
		<div id="wrapper">
			<div id="content-wrapper">
				<div id="content">
					<dl>
						<dt>${article.themeOfTheArticle}</dt>
						<dd>
							<p class="img">
								<img src="${url}" width="250px" height="171px"
									alt="Sample Picture Here" />

							</p>
							<p>${article.textOfTheArticle}</p>
							<p>
							<hr>
						<dd class="summary">
							Posted By: <a
								href="otherUserProfile.jsp?email=${article.author.eMail}">${article.author.name}</a>
							on ${article.date }<br>${article.like} Likes |
							${article.disLike } Dislikes <br> This article liked by:
							<c:forEach items="${like}" var="mail">
								<a href="otherUserProfile.jsp?email=${mail}">${service.returnUserByEmail(mail).name}
									| </a>
							</c:forEach>
							<br> This article disliked by:
							<c:forEach items="${dislike}" var="mail">
								<a href="otherUserProfile.jsp?email=${mail}">${service.returnUserByEmail(mail).name}
									| </a>
							</c:forEach>
							<br> <a
								href="actions.jsp?action=like&id=${id}&userEmail=${email}">I
								like this article</a> | <a
								href="actions.jsp?action=dislike&id=${id}&userEmail=${email}">I
								don`t like this article</a> | <a
								href="actions.jsp?action=comment&id=${id}">Post a comment</a>
						</dd>
						<dt>Comments:</dt>
						<c:choose>
							<c:when test="${text.comment==null}">
								<c:out value="No comments"></c:out>
							</c:when>
							<c:otherwise>
								<c:forEach items="${text.comment}" var="c">
									<c:if test="${c.articleId==id}">
										<br>
										<blockquote
											style="background-color: #f9f9f9; border: 2px #555555 solid; padding: 14px; margin: 0px 0px 0px 0px;">
											${c.commentText}</blockquote>
										<c:choose>
											<c:when
												test="${user.eMail==c.author.eMail||user.eMail==article.author.eMail}">
												<dd class="summary">
													Posted by <a
														href="otherUserProfile.jsp?email=${c.author.eMail}">${c.author.name}</a>
													| <a
														href="actions.jsp?action=deleteComment&commentId=
													${c.id}&id=${id}">Delete
														comment</a>
												</dd>
											</c:when>
											<c:otherwise>
												<dd class="summary">
													Posted by <a
														href="otherUserProfile.jsp?email=${c.author.eMail}">${c.author.name}</a>
												</dd>
											</c:otherwise>
										</c:choose>
									</c:if>
								</c:forEach>
							</c:otherwise>
						</c:choose>
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
				</div>
			</div>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>