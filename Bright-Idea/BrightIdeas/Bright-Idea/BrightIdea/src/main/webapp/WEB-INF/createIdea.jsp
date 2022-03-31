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
<title>Create a Bright Idea</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">

</head>
<body>
	<div class="col-10 mx-auto mt-5 ms-5">
		<div class="d-flex justify-content-between mt-4 border-bottom">
			<h2 class="ms-4">Add your Brightest Idea!</h2>
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
		  <div class="container-fluid">
		    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		      <span class="navbar-toggler-icon"></span>
		    </button>
		    <div class="collapse navbar-collapse" id="navbarSupportedContent">
		      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
		        <li class="nav-item">
		          <a class="nav-link active" aria-current="page" href="/logout">Logout</a>
		        </li>
		      </ul>
		    </div>
		  </div>
		</nav>
		</div>
		<div class="col-6 ms-4 mt-4">
		<form:form action="/add" method="post" modelAttribute="newIdea">
			<div class="mb-3">
				<form:label path="idea" class="form-label">Whats your Bright Idea?</form:label>
				<form:hidden value="${currentUser.id}" path="user"/>
				<form:textarea path="idea" class="form-control" />
				<form:errors path="idea" class="text-danger" />
			</div>
			<button type="submit" class="btn btn-outline-primary">Submit</button>
			<button class="btn btn-primary" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasExample" aria-controls="offcanvasExample">Cancel</button>
		</form:form>
			<div class="offcanvas offcanvas-start" tabindex="-1" id="offcanvasExample" aria-labelledby="offcanvasExampleLabel">
			  <div class="offcanvas-header">
			    <h5 class="offcanvas-title" id="offcanvasExampleLabel">Confirmation</h5>
			    <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
			  </div>
			  <div class="offcanvas-body">
			    <div>
			      Are you sure you want to cancel this bright idea? If so all data will be lost!
			    </div>
			    <div class="dropdown mt-3">
			      <a class="nav-link active" aria-current="page" href="/dashboard">I am sure!</a>
			    </div>
			  </div>
			</div>
		</div>
	</div>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>