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
<c:if test="${not empty user.name}">
	<span class="greeting">
			Hello ${ user.name }
		</span>
		 </c:if>
		<h1>Java Java Coffee Shop</h1>
	<%-- <form class="form-inline" action="/index" autocomplete="off">
		  <label class="sr-only" for="keyword">Keyword</label>
		  <input type="text" value="${param.keyword}" class="form-control mb-2 mr-sm-2" id="keyword" name="keyword" placeholder="Keyword">
		    <label class="sr-only" for="category">Category</label>
		  <select class="form-control mb-2 mr-sm-2" id="category" name="category">
		  	<option value="">Category</option>
		  	<c:forEach items="${ categories }" var="cat">
		  		<option <c:if test="${ cat eq param.category }">selected</c:if>>${ cat }</option>
		  	</c:forEach>
		  </select>
		  <button type="submit" class="btn btn-primary mb-2 mr-2">Search</button>
		  <c:if test="${not empty param.keyword or not empty param.category}">
		  	<a href="/index" class="btn btn-secondary mb-2">Clear</a>
	  	  </c:if>
		</form> --%>
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
	</div>
	<a href="/productAdd" class="btn btn-secondary">Add Product</a>
</body>
</html>