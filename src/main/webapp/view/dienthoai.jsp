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
				<td>madt</td>
				<td>tendt</td>
				<td>namsx</td>
				<td>cauhinh</td>
				<td>mancc</td>
				<td>Action</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="listDt" items="${listDt }">

				<tr>
					<td>${listDt.maDT }</td>
					<td>${listDt.tenDT }</td>
					<td>${listDt.namsx }</td>
					<td>${listDt.cauhinh }</td>
					<td>${listDt.nhacungcap.mancc }</td>
					<td>
					<a href="dienthoai?action=update&id=${listDt.maDT }">Cap Nhat</a>
					<a href="dienthoai?action=delete&id=${listDt.maDT }">Xoa</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="dienthoai?action=add">them san pham</a>
</body>
</html>