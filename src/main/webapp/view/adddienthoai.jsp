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

	<form action="dienthoai" method="post">

		<div>
			<label>Ten</label> <input type="text" name="ten">
		</div>

		<div>
			<label>Namsx</label> <input type="text" name="nam">
		</div>

		<div>
			<label>cauHinh</label> <input type="text" name="cauhinh">
		</div>

		<div>
			<label>Ma ncc</label> <select name="mancc">

				<c:forEach var="listncc" items="${listncc }">
					<option value="${listncc.mancc }"  >${listncc.tennhacc }</option>
				</c:forEach>
			</select>
		</div>

		<input type="submit" values="them">
	</form>
</body>
</html>