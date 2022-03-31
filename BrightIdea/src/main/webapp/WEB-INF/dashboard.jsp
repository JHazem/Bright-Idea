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
<title>Bright Ideas Dashboard</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body style="background-color:lightgrey">
	<body class="col-9 mx-auto mt-4">
				<div class="d-flex justify-content-between">
					<h4 class="ms-2 text-dark">
						Welcome
						<c:out value=" ${ user.name }!"></c:out>
					</h4>
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
				
				<table
					class="table table-striped border-top mb-5">
					<thead class="text-center">
						<tr>
							<th>Alias</th>
							<th>Post</th>
							<th>Actions</th>
							<th>Likes</th>
						</tr>
					</thead>
					<tbody class="bg-light text-center">
						<%-- <c:forEach var="" items="${ allIdeas }">
							<tr>
								<td><a href="/user/${ user.id }"><c:out value="${ user.alias }"></c:out></a></td>
								<td><c:out value="${ ideas.post }"></c:out></td>
								<td><button type="button" value="Like" class="btn btn-outline-primary">Like</button></td>
								
							</tr>
						</c:forEach> --%>
					</tbody>
				</table>
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	</body>
</body>
</html>