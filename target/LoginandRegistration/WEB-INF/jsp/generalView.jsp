<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
img {
	
}

.bdetail {
	
}

th {
	padding-right: 50px;
}
</style>
</head>
<body style="background-color: #ffe6e6;">
	<h2 style="text-align: center; color: black;">Thriller</h2>
	<table border="2" bordercolor="black" width="80%"
		style="margin-left: 225px; margin-top: 50px;">
		<tr>
			<th><u>YourBook</u></th>
			<th style="padding-right: 10px;"><u>BookName</u></th>
			<th style="padding-right: 10px;"><u>Author</u></th>
			<th><u>Price</u></th>
			<th><u>Buy</u></th>
			<th><u>AddToCart</u></th>
		</tr>
		<c:forEach var="emps" items="${command}">
			<tr>
				<td><img src="data:image/jpg;base64,${emps.base64Image}"
					width="150" height="200" style="padding-left: 20px;" /></td>
				<td><h4>${emps.bookName}</h4></td>
				<td style="padding-right: 20px;"><h4>${emps.bookAuthor}</h4></td>
				<td><h4>${emps.bookPrice}</h4></td>
				<td><h4>
						<a href="GbuyBook/${emps.bookId}">Buy</a>

					</h4></td>

				<td><h4>
						<a href="GaddCart/${emps.bookId}">AddToCart</a>
					</h4></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>