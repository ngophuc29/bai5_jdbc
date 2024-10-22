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

	<form action="dienthoai?action=update" method="post">
		<label>id</label> <input type="text" name="id" value="${dtU.maDT }">
		<div>
			<label>Ten</label> <input type="text" name="ten"
				value="${dtU.tenDT }">
		</div>

		<div>
			<label>Namsx</label> <input type="text" name="nam"
				value="${dtU.namsx }">
		</div>

		<div>
			<label>cauHinh</label> <input type="text" name="cauhinh"
				value="${dtU.cauhinh }">

		</div>

		<div>
			<label>Ma ncc</label> <select name="mancc">

				<c:forEach var="listncc" items="${listncc }">
					<option value="${listncc.mancc }"
						${dtU.nhacungcap.mancc==listncc.mancc ? "selected" : "" }>${listncc.tennhacc  }</option>

				</c:forEach>
			</select>
		</div>

		<input type="submit" value="Update">
	</form>
</body>
</html>