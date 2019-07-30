<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Java Java Coffee Shop</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
<link href="/temp.css" rel="stylesheet" /> 
<title>Insert title here</title>
</head>
<body>
<div class="container">
		<input type="text" style="float: right" placeholder="Search.."/>
		<h1>Java Java Coffee Shop</h1>
		<table class="table">
			<thead>
				<tr>
					<th>Products</th><th>Description</th><th>Price</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="products" items="${products}">
				<tr>
					<td>${products.id}</td>
					<td>${products.name}</td>
					<td>${products.description}</td>
					<td>${products.price}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<a style="float: right" href="/index/userForm" class="btn btn-secondary">Please Register</a>
</body>
</html>