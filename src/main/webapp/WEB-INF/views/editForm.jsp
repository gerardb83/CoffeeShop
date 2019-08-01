<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Registration</title>
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
	
		<h1>${ title }</h1>
		<h2></h2>
		<input type="hidden" name="id" value="${product.id}" />
		<form method="post">
			<table class="table">
				<tr>
					<th scope="row">Product Name</th>
					<td><input type="text" name="name" value="${product.name}"
						autofocus /></td>
				</tr>
				<tr>
					<th scope="row">Description</th>
					<td><input type="text" name="description"
						value="${product.description}" /></td>
				</tr>
				<tr>
					<th scope="row">Price</th>
					<td><input type="number" name="price" value="${product.price}"
						step="0.01" autofocus /></td>
				</tr>
			</table>
			<button type="submit" class="btn btn-primary">Submit</button>
			<a class="btn link" href="/adminIndex">Cancel</a>
		</form>
	</div>
</body>
</html>