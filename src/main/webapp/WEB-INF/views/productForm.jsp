<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Form</title>

<link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/spacelab/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
<link href="/styles.css" rel="stylesheet" /> 
</head>
<body>

<div class="container">
<c:if test="${not empty user.name}">
	<span class="greeting">
			Hello ${ user.name }
		</span>
		 </c:if>
		<h1>New Product Form</h1>
		<h2>Add Product</h2>
		<form action="/productAdd" method="post">
		<table class="table">
			<tr>
				<th scope="row">Name</th>
				<td><input type="text" name="name" autofocus/></td>
			</tr>
			<tr>
				<th scope="row">Description</th>
				<td><input type="text" name="description" /></td>
			</tr>
			<tr>
				<th scope="row">Price</th>
				<td><td><input type="number" name="price" step="0.01"/></td>
			</tr>
		</table>
		<button type="submit" class="btn btn-primary">Add</button>
		<a class="btn link" href="/adminIndex">Cancel</a>
		</form>
	</div>
</body>
</html>