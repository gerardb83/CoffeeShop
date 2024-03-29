<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
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
				<c:forEach items="${products}" var="product">
				<tr>
					<%-- Access properties of the java bean using simple . notation.
					     This actually calls the getters behind the scenes. --%>
					<td>${product.name}</td><td>${product.description}</td><td>${product.price}</td>
					<td>
						<a href="/productEdit?id=${ product.id }" class="btn btn-light btn-sm">Edit</a>
						<a href="/productDelete?id=${ product.id }" class="btn btn-light btn-sm">Delete</a>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<a href="/productAdd" class="btn btn-secondary">Add Product</a>
		<div class="greeting">
	<c:if test="${not empty user }">
	
			<span>Hello ${ user.name }</span>
			<span><a href="/logout" class="btn btn-secondary">Logout</a></span>
		 </c:if>
		 	</div>
	</div>
	
</body>
</html>