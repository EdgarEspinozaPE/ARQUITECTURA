<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Agenda</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
		<script src="validator.js"></script>
	</head>
	<body>
		<div class="container pt-5">
			<div class="text-center">
				<h1>Agenda</h1>
			</div>
			<div class="row">
				<div class="col-md-3 mb-3">
					<img class="card-img-top" src="https://upload.wikimedia.org/wikipedia/commons/thumb/1/12/User_icon_2.svg/768px-User_icon_2.svg.png" alt="Card image" style="width:60%">
				</div>
				<div class="col-md-6 mb-15 pt-3">
					<form class="form-inline md-form mr-auto" action ="AdminContacts?action=buscar" method="post">
						<input class="form-control" type="text" placeholder="Buscar" aria-label="Buscar" name="nombre">
						<button class="btn btn-success" type="submit">Buscar</button>
					</form>
				</div>
				<div class="col-md-2 mb-1 pt-3">
					<a class="btn btn-link btn-lg btn-block" href="AdminContacts?action=nuevo" role="button">
						<img class="card-img-top" src="https://icon-library.com/images/add-image-icon-png/add-image-icon-png-1.jpg" alt="Card image" style="width:70%">
					</a>
				</div>
			</div>
			<div class="container">
				<table class="table table-striped table-dark">
					<thead>
						<tr>
							<th scope="col">Nombre</th> 
							<th scope="col">Telefono</th>
							<th scope="col">Correo</th>
							<th scope="col">Acciones</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="contacto" items="${lista}">
							<tr>
								<th scope="row"><c:out value="${contacto.nombre}"/></th>
								<td><c:out value="${contacto.telefono}"/></td>
								<td><c:out value="${contacto.correo}"/></td>
								<td><a href="AdminContacts?action=showedit&id=<c:out value="${contacto.id}"/>">Editar</a></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>
		</div>
	</body>
</html>