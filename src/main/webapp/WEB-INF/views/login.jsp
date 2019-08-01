<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/spacelab/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
<link href="/styles.css" rel="stylesheet" /> 
</head>
<body>
<h2> ${notFound} </h2>
<c:if test="${not empty user.name}">
	<span class="greeting">
			Hello ${ user.name }
		</span>
		 </c:if>
<h2>Please Login</h2>
		<form action="/login" method="post">
		<table class="table">
			<tr>
				<th scope="row">User Id</th>
				<td><input type="text" name="userId" autofocus/></td>
			</tr>
			<tr>
				<th scope="row">Password</th>
				<td><input type="password" name="password" /></td>
			</tr>
		</table>
		<button type="submit" class="btn btn-primary">Login</button>
		<a class="btn link" href="/">Cancel</a>
		</form>
</body>
</html>