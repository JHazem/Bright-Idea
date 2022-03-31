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
<title>Display User</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="col-10 mx-auto mt-5 ms-5">
		<div class="d-flex justify-content-end mt-4 border-bottom">
			<div>
				<nav class="navbar navbar-expand-lg navbar-light bg-light">
				  <div class="container-fluid">
				    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				      <span class="navbar-toggler-icon"></span>
				    </button>
				    <div class="collapse navbar-collapse" id="navbarSupportedContent">
				      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
				        <li class="nav-item">
				         	<a class="nav-link active" aria-current="page" href="/dashboard">Dashboard</a>
			        	</li>
			        	<li class="nav-item">
		         			<a class="nav-link active" aria-current="page" href="/ideas/new">Add an Idea!</a>
		       			</li>
			        	<li class="nav-item">
			          		<a class="nav-link active" aria-current="page" href="/logout">Logout</a>
				        </li>
				      </ul>
				    </div>
				  </div>
				</nav>
			</div>
		</div>
		<div>
			<h3 class="fs-1">Name:	${user.userName} </h3>
		</div>
		<div>
			<h4 class="fs-3">Alias:	${user.alias} </h4> 
		</div>
		<div>
			<h4 class="fs-3">Email: ${user.email} </h4>
		</div>
		
		<div class="d-flex col-6 justify-content-end">
			<h3 class="fs-3">Total Number of Posts:  </h3>
			<h3 class="fs-3">Total Number of Likes:  </h3>
		</div>
		
	</div>
</body>
</html>