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
					<th>Name</th><th>Price</th><th>Quantity</th>
				</tr>
			</thead>
			<tbody>
			
				<tr>
		
					<td>${count1} Espressos @ $1.25 each: $${total1 }</td>
					<td>${count2} Americanos @ $1.50 each: $${total2 }</td>
					
				</tr>
				
			</tbody>
		</table>
	</div>
	
	
	<div class="greeting">
	<c:if test="${not empty user }">
	
			Hello, ${ user.name }
			<a href="/logout" class="btn btn-secondary">Logout</a>
		 </c:if>
		 	</div>
</body>
</html>