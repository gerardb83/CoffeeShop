<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thank You!</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
</head>
<body>
	<div class="container">
	<%-- <input type="hidden" name="id" value="${user.id}" /> --%>
		<h1>Thank You for Registering!</h1>
		<table class="table">
			<tr>
				<th scope="row"></th>
				<td>Welcome, ${name}</td>
			</tr>
<%-- 			<tr>
				<th scope="row">Password (Tell no one!)</th>
				<td>${user.password}</td>
			</tr>
			<tr>
				<th scope="row">Name</th>
				<td>${user.name}</td>
			</tr> --%>
		</table>
		<a class="btn link" href="/index">Back to the Shop!</a>
	</div>
</body>
</html>