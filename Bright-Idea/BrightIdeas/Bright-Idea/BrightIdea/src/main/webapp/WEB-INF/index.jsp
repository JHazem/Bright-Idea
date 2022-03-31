<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bright Ideas Login and Registration</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body class="bg-light">
	<div class="d-flex justify-content-around">
		<div class="col-4 mt-5">
		<h1 class="text-success">Welcome to Bright Ideas!</h1>
		<p>A place for friends to share Best and Brightest's Ideas</p>
		<h2>Register</h2>
			<!-- Registration Form -->
			<form:form action="/register" method="post" modelAttribute="newUser">
				<div class="form-group">
					<label>Name:</label>
					<form:input path="name" class="form-control" />
					<form:errors path="name" class="text-danger" />
				</div>
      			<div class="form-group">
					<label>Alias:</label>
					<form:input path="alias" class="form-control" />
					<form:errors path="alias" class="text-danger" />
				</div>
				<div class="form-group">
					<label>Email:</label>
					<form:input path="email" class="form-control" />
					<form:errors path="email" class="text-danger" />
				</div>
				<div class="form-group">
					<label>Password:</label>
					<form:password path="password" class="form-control" />
					<form:errors path="password" class="text-danger" />
				</div>
				<div class="form-group">
					<label>Confirm Password:</label>
					<form:password path="confirm" class="form-control" />
					<form:errors path="confirm" class="text-danger" />
				</div>
				<input type="submit" value="Register" class="btn btn-outline-success mt-3" />
			</form:form>
		</div>
		<div class="col-4 mt-5">
		<h1 class="text-light mt-5 mt-5">.</h1>
			<h2>Log in</h2>
			<!-- Login Form -->
			<form:form action="/login" method="post" modelAttribute="newLogin">
				<div class="form-group">
					<label>Email:</label>
					<form:input path="email" class="form-control" />
					<form:errors path="email" class="text-danger" />
				</div>
				<div class="form-group">
					<label>Password:</label>
					<form:password path="password" class="form-control" />
					<form:errors path="password" class="text-danger" />
				</div>
				<input type="submit" value="Login" class="btn btn-outline-warning mt-3" />
			</form:form>
		</div>
		<h3><c:out value="${message}" /></h3>
	</div>
</body>
</html>