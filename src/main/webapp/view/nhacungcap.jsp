<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<table border="">
		<thead>
			<tr>
				<td>mancc</td>
				<td>tenncc</td>
				<td>diachi</td>
				<td>sodienthoai</td>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="listncc" items="${listncc }">

				<tr>
					<td>${listncc.mancc }</td>
					<td>${listncc.tennhacc }</td>
					<td>${listncc.diachi }</td>
					<td>${listncc.sodiachi }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>