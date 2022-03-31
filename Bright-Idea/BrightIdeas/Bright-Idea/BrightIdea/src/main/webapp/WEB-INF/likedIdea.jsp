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
<title>Liked Ideas</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">

</head>
<body>
	<div class="col-10 mx-auto mt-5 ms-5">
		<div class="d-flex justify-content-end mt-4 border-bottom">
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
		<div class="col-6 ms-4 mt-4">
			<h4 class="ms-2 text-dark"><c:out value=" ${ ideas.user.alias }"></c:out> Says:</h4>
			
				<c:choose>
					<c:when test="${sessionScope.userID == ideas.user.id }">
					 	<form:form action="/update" method="post" modelAttribute="updateIdea">
							<div class="mb-3">
								<form:input type="hidden" path="id"/>
								<form:label path="idea" class="form-label">Whats your Bright Idea?</form:label>
								<form:hidden value="${currentUser.id}" path="user"/>
								<form:textarea path="idea" class="form-control" />
								<form:errors path="idea" class="text-danger" />
							</div>
								<button type="submit" class="btn btn-outline-primary">Update</button>
								<a href="/idea/delete/${ideas.id}" class="btn btn-outline-danger btn-sm">Delete</a>
						</form:form>
					</c:when>
					<c:otherwise>
						<h3 class="ms-2 text-dark"><c:out value=" ${ ideas.idea }"></c:out> </h3>
					</c:otherwise>
				</c:choose>
			
		</div>
		<div>
			<h4 class="col-6 ms-4 mt-4">People who liked this idea:</h4>
		</div>
		<table class="table table-striped border-top mb-5" style="width:60%">
			<thead class="text-center">
				<tr>
					<th>Alias</th>
					<th>Name</th>
				</tr>
			</thead>
			<tbody class="bg-light text-center">
				<c:forEach var="user" items="${allLikedUsers}">
					<tr>
						<td><a href="/user/${ user.id }"><c:out value="${ user.alias }"></c:out></a></td>
						<td><c:out value="${ user.name }"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
