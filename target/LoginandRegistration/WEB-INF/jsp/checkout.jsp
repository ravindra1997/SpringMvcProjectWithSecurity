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
</head>

<div>
	<h1 style="text-align: center;">thanks for shopping</h1>
	<%-- <h3 style="text-align: center;">Your Product Details are here</h3>
	<table>
		<c:forEach var="emps" items="${command}">
			<tr>
				<td><img src="data:image/jpg;base64,${emps.base64Image}"
					width="120" height="200" style="padding-left: 20px;"
					class="bdetail" /></td>
			</tr>
		</c:forEach>

	</table>
	<table> --%>
	<%-- <c:forEach var="emps" items="${command}">
			<tr>
				<td><h4>${emps.bookName}</h4></td>
				<td style="padding-right: 20px;"><h4>${emps.bookAuthor}</h4></td>
				<td><h4>${emps.bookPrice}</h4></td>
			</tr>
		</c:forEach> --%>
	<!-- </table> -->
	<h3>
		<a href="${pageContext.request.contextPath}/reshop.html"
			style="padding-left: 620px;">Continue Shopping</a>
	</h3>
	</div>
	<div align="center">
	<form:form>
	<h4><input type="submit" value="Logout"></h4>
	</form:form>

</div>

</body>
</html>