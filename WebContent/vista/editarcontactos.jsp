<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Registrar Contacto</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
		<script src="validator.js"></script>
	</head>
	<body>
		<div class="container pt-5">
			<div class="text-center">
				<h1>Registrar Contacto</h1>
			</div>
			<div class="container p-3 mb-2 bg-info text-white">
				<form action="AdminContacts?action=register" class="needs-validation" novalidate method="post">
					<div class="form-row">
						<div class="col-md-4 mb-3">
							<label for="validationCustomCode">Nombre</label>
							<input type="text" class="form-control" id="validationCustomCode" placeholder="nombre" maxlength="45" value='<c:out value="${contacto.nombre}"></c:out>' required name="nombre">
							<div class="invalid-feedback">
								Ingrese un Nombre valido.
							</div>
						</div>
						<div class="col-md-4 mb-3">
							<label for="validationCustomName">Telefono</label>
							<input type="text" class="form-control" id="validationCustomName" placeholder="telefono" maxlength="45" value='<c:out value="${contacto.telefono}"></c:out>' required name="telefono">
							<div class="invalid-feedback">
								Ingrese un Telefono valido.
							</div>
						</div>
						<div class="col-md-4 mb-3">
							<label for="validationCustomDescription">Correo</label>
							<input type="text" class="form-control" id="validationCustomDescription" placeholder="correo" maxlength="45" value='<c:out value="${contacto.correo}"></c:out>' required name="correo">
							<div class="invalid-feedback">
								Ingrese un correo.
							</div>
						</div>
					</div>
					<button class="btn btn-success btn-lg btn-block" type="submit">Registrar</button>
				</form>
			</div>

		</div>
	</body>
</html> 