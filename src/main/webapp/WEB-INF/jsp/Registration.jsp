<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page isErrorPage="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
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

</style>
<body>
	<div
		style="text-align: center; padding-bottom: 20px; background-color: #ffe6e6; padding-top: 15px;">
		<form:form action="register" method="post">
			<h2 style="color: navy; font-family:sans-serif;">Register Here</h2>
			<table align="center">
				<tr>

					<td><form:input path="firstName" placeholder="FirstName"  /></td>
				</tr>
				<tr>

					<td><form:input path="lastName" placeholder="LastName" /></td>
				</tr>
				<tr>

					<td><form:input path="phoneNumber" placeholder="PhoneNumber" /></td>
				</tr>
				<tr>

					<td><form:input path="emailId" placeholder="EmailId" /></td>
				</tr>
				<tr>

					<td><form:radiobutton path="gender" value="Male" />Male <form:radiobutton
							path="gender" value="Female" />Female</td>
				</tr>
				<%-- <tr>
			<td>LanguagesKnown</td>
			<td>:</td>
			<td><form:checkbox path="languagesKnown"/></td>
		</tr> --%>
				<tr>
					
					<td><form:select path="location">
							<form:option value="Hyderbad" label="Hyderabad"></form:option>
							<form:option value="London" label="London"></form:option>
							<form:option value="NewYork" label="NewYork"></form:option>
							<form:option value="LosAngels" label="LosAngels"></form:option>
							<form:option value="Bangalore" label="Bangalore"></form:option>
						</form:select></td>
				</tr>
				<tr>

					<td><form:input path="password" placeholder="Password" /></td>
				</tr>
				<tr>

					<td><form:input path="repassword" placeholder="Re-enterPassword" /></td>
				</tr>
				<tr>
				
					<td><input type="submit" value="Submit"
						style="color: maroon; background-color: silver;"></td>
				</tr>
			</table>

		</form:form>
	</div>
</body>
</html>