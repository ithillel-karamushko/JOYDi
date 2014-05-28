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

	<div id="container">
		<div id="header">
			<hr />
			<img src="images/heather1.png" width="50%"> <img
				src="images/logogreen.png" width="15%">
			<hr />
		</div>

		<div id="log">
			Login (email): <br> <input type="text" id="login" size="25">
					<br> Password: <br> <input type="password" id="password"
							size="25"> <br> <input type="submit" value="Enter">
										<a href="registration.jsp">Click here if not registered</a>
		</div>
		<script>
			function validate() {
				login = document.getElementById("login");
				password = document.getElementById("password");
				if (login.valuetrim() == '') {
					alert('Please enter email');
					return false;
				}
			}
		</script>
		<div id="footer">
			<p>Copyright &copy; 2014 JOYDi Inc. All rights reserved.</p>
			<p>
				Designed by <a href="http://www.linkedin.com/pub/evgeniy-karamushko/94/78a/831" title="TeamLeader">Karamushko
					Evgeniy</a>, <a href="http://vk.com/id20669962" title="Developer">Yulia
					Brus</a> and <a href="" title="Developer and Tester">Olga Grygorian</a>
			</p>
			<p>
				Our partners <a href="http://itschool-hillel.org">Hillel IT
					School</a> | <a href="http://magellanportal.com/">MagellanPortal</a>
				<p>Contact us: joydi@gmail.com</p>
			</p>
		</div>
</body>
</html>