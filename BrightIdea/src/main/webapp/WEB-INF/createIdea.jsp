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
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">


</head>
<body>
	<div class="col-10 mx-auto mt-5 ms-5">
		<div class="d-flex justify-content-between mt-4 border-bottom">
			<h2 class="ms-4">Add you Brightest Idea!</h2>
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
		  <div class="container-fluid">
		    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		      <span class="navbar-toggler-icon"></span>
		    </button>
		    <div class="collapse navbar-collapse" id="navbarSupportedContent">
		      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
		        <li >
		          <a   href="/logout" class="btn btn-outline-primary">Logout</a>
		        </li>
		      </ul>
		    </div>
		  </div>
		</nav>
		</div>
		<div class="col-6 ms-4 mt-4">
		<form:form action="/ideas/saveidea" method="post" modelAttribute="newIdea">
			<div class="mb-3">
				<form:label    path="idea" class="form-label">Whats your Bright Idea?</form:label>
				<form:textarea path="idea" class="form-control" />
				<form:errors   path="idea" class="text-danger" />
				
				<form:hidden   path="user"  value= "${userId}"/>
			</div>
			 <a href="/ideas" class="btn btn-primary">Cancel</a>
			<button type="submit" class="btn btn-outline-primary">Submit</button>
		</form:form>
			 
			<table> 
			  	 <!-- To see all ideas -->
              	 <c:forEach items="${idea.idea}" var="idea"> 
             	 	 <tr>
               		<td> <p>${idea.idea}</p></td> 
               		 
              	 </tr>
              	 </c:forEach>
           	</table>
           
		</div>
	</div>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>