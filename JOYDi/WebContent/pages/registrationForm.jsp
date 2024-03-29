<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
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
					<input type="text" name="name" required size="25" /> <small>Name</small>
				</p>
				<p>
					<input type="email" name="email" required size="25" /> <small>Email</small>
				</p>
				<p>
					<input type="text" name="country" required size="25" /> <small>Country</small>
				</p>
				<p>
					<input type="radio" name="gender" value="MALE" /> <small>MALE</small>
					<input type="radio" name="gender" value="FEMALE" /> <small>FEMALE</small>
				</p>
				<p>
					<input type="number" name="yearOfBirth" required size="25" /> <small>Year
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
					<input type="number" name="dayOfBirth" required size="25" /> <small>Day
						Of Birth</small>
				</p>
				<p>
					<input type="password" name="password" required size="25" /> <small>Password</small>
				</p>

				<input type="submit" value="Register" />
			</form>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>