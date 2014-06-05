<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
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
<title>JOYDi registration</title>
<link rel="stylesheet" type="text/css" media="screen,projection"
	href="screen.css" />
</head>
<body>
	<jsp:include page="header.jsp" />

	<div id="container">
		<div id="log">
			<form action="registration.jsp">
				<p>
					<input type="text" name="name" size="25" /> <small>Name</small>
				</p>
				<p>
					<input type="text" name="email" size="25" /> <small>Email</small>
				</p>
				<p>
					<select name="country" size="1">
						<option value="Ukraine">Ukraine</option>
						<option value="Germany">Germany</option>
						<option value="Russia">Russia</option>
						<option value="England">England</option>
						<option value="China">China</option>
					</select> <small>Country</small>
				</p>
				<p>
					<input type="radio" name="gender" value="MALE" /> <small>MALE</small>
					<input type="radio" name="gender" value="FEMALE" /> <small>FEMALE</small>
				</p>
				<p>
					<input type="text" name="yearOfBirth" size="25" /> <small>Year
						Of Birth</small>
				</p>
				<p>
					<select name="monthOfBirth" size="1">
						<option value="January">January</option>
						<option value="February">February</option>
						<option value="March">March</option>
						<option value="April">April</option>
						<option value="May">May</option>
						<option value="June">June</option>
						<option value="July">July</option>
						<option value="August">August</option>
						<option value="September">September</option>
						<option value="October">October</option>
						<option value="November">November</option>
						<option value="December">December</option>
					</select><small>Month of Birth</small>
				</p>
				<p>
					<input type="text" name="dayOfBirth" size="25" /> <small>Day
						Of Birth</small>
				</p>
				<p>
					<input type="password" name="password" size="25" /> <small>Password</small>
				</p>

				<input type="submit" value="Register" />
			</form>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>