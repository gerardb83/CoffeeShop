<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Java Java Coffee Shop</title>
<link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/spacelab/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
<link href="/styles.css" rel="stylesheet" /> 
</head>
<body>
<div class="container">

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
	<c:if test="${ empty user }">
		<a style="float: right" href="/userForm" class="btn btn-secondary">Sign up</a>
		<a style="float: right" href="/login" class="btn btn-secondary">Login</a>
		</c:if>
	
	<div class="greeting">
	<c:if test="${not empty user }">
	
			Hello ${ user.name }
			<a href="/logout" class="btn btn-secondary">Logout</a>
		 </c:if>
		 	</div>
</body>
</html>