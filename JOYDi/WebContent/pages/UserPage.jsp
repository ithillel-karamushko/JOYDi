<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<title>JOYDi</title>
<link rel="stylesheet" type="text/css" media="screen,projection"
	href="screen.css" />
</head>
<body>
	<jsp:include page="header.jsp" />
	<div id="container">
		<div id="wrapper">
			<div id="content-wrapper">
				<div id="content">
					<dl>
						<dt>3D Printers</dt>
						<dd>
							<p class="img">
								<img src="images/sample.png" width="250px" height="171px"
									alt="Sample Picture Here" />
							</p>
							<p>You heard of 3D printing from newscasters and journalists,
								astonished at what they’ve witnessed. A machine reminiscent of
								the Star Trek Replicator, something magical that can create
								objects out of thin air. It can “print” in plastic, metal,
								nylon, and over a hundred other materials. It can be used for
						</dd>
						<dd class="summary">
							Posted By: <a href="">Karamushko Evgeniy</a> on Mar 20, 2014 | <a
								href="#02">Comments(182)</a>
						</dd>

					</dl>
				</div>
			</div>
			<div id="sidebar-wrapper">
				<div id="sidebar">
					<ul>
						<li class="title">My Diary</li>
						<li><a href="home.jsp">My Articles</a></li>
						<li><a href="#1">Add new Article</a></li>
						<li><a href="#2">Modify My Profile</a></li>
						<li><a href="#3">Delete my Profile</a></li>
					</ul>
					<ul>
						<li class="title">Top Articles in JOYDi</li>
						<li><a href="#4">Java is good</a></li>
						<li><a href="#5">HTML is not good</a></li>
					</ul>
					<ul>
						<li class="title">Latest Articles in JOYDi</li>
						<li><a href="#6">HTML makes me cry</a></li>
						<li><a href="#7">IT Hillel</a></li>
					</ul>

				</div>
			</div>
		</div>
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>
