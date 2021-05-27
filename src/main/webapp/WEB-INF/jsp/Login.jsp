<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
input {
	border-radius: 5px;
	height: 25px;
	border-bottom-color: black;
	border-left-style: hidden;
	border-right-style: hidden;
	border-top-style: hidden;
	background-color: pink;
}

body {
	background-color:;
}
</style>
</head>
<body>
	<div
		style="text-align: center; padding-bottom: 20px; background-color: #ffe6e6; padding-top: 15px;">
		<form:form action="log" method="post">
			<h2 style="color: navy; font-family: sans-serif;">Login To Shop</h2>
			<table align="center">
				<tr>
					<td><form:input path="phoneNumber" placeholder="PhoneNumber" /></td>
				</tr>
				<tr>
					<td><form:input path="password" placeholder="Password" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Login"></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>

</html>