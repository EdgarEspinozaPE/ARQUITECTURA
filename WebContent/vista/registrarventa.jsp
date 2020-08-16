<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
	<head>
		<title>Registrar</title>
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
				<h1>Registrar</h1>
			</div>
			<div class="container p-3 mb-2 bg-info text-white">
				<form action="adminArticulo?action=registrarventa" class="needs-validation" method="post" novalidate>
					<div class="form-group row">
						<label for="staticGanancias" class="col-sm-2 col-form-label">Ganancias</label>
						<div class="col-sm-10">
							<input type="text" readonly class="form-control-plaintext" id="staticGanancias" value='S/. <c:out value="${ganancias}"></c:out>'>
						</div>
					</div>
					<div class="form-group row">
						<label for="inputCodigo" class="col-sm-2 col-form-label">Código</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="inputCodigo" placeholder="Código" name="codigo" required >
							<div class="invalid-feedback">
								Ingrese un código válido.
							</div>
						</div>
					</div>
					<div class="form-group row">
						<label for="inputCantidad" class="col-sm-2 col-form-label">Cantidad</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="inputCantidad" placeholder="Cantidad" name="cantidad" required >
							<div class="invalid-feedback">
								Ingrese una cantidad válida.
							</div>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-md-4">
							<a class="btn btn-success btn-lg btn-block" href="adminArticulo?action=index" role="button">Volver</a>
						</div>
						<div class="col-md-4">
							<a class="btn btn-success btn-lg btn-block" href="adminArticulo?action=historial" role="button">Historial</a>
						</div>
						<div class="col-md-4">
							<!--<a class="btn btn-success btn-lg btn-block" href="adminArticulo?action=registrarventa" role="button">Registrar Venta</a>-->
							<button class="btn btn-success btn-lg btn-block" type="submit">Registrar Venta</button>
							<!--  <button class="btn btn-success btn-lg btn-block" href="adminArticulo?action=index" type="submit">Registrar Venta</button>-->
						</div>
					</div>
				</form>
				<!--form action="AdminAlumno?action=register" class="needs-validation" novalidate method="post">
					<div class="form-row">
						<div class="col-md-4 mb-3">
							<label for="validationCustomCode">Codigo
							<input type="text" class="form-control" id="validationCustomCode" placeholder="Codigo" maxlength="45" required>
							<div class="invalid-feedback">
								Ingrese un codigo valido.
							</div>
							</label>
						</div>
						<div class="col-md-4 mb-3">
							<label for="validationCustomName">Nombre</label>
							<input type="text" class="form-control" id="validationCustomName" placeholder="Nombre" maxlength="45" required name="apellido_paterno">
							<div class="invalid-feedback">
								Ingrese un nombre valido.
							</div>
						</div>
						<div class="col-md-4 mb-3">
							<label for="validationCustomDescription">Descripcion</label>
							<input type="text" class="form-control" id="validationCustomDescription" placeholder="Descripcion" maxlength="45" required name="apellido_materno">
							<div class="invalid-feedback">
								Ingrese una descripcion.
							</div>
						</div>
					</div>

					<div class="form-row">
						<div class="col-md-4 mb-3">
							<label for="validationCustomExistence">Existencia</label>
							<input type="text" class="form-control" id="validationCustomExistence" placeholder="Existencia" maxlength="45" required name="apellido_materno">
							<div class="invalid-feedback">
								Ingrese la existencia.
							</div>
						</div>
						<div class="col-md-4 mb-3">
							<label for="validationCustomPrecio">Precio</label>
							<input type="text" class="form-control" id="validationCustomPrecio" placeholder="Precio" required name="fecha_nacimiento">
							<div class="invalid-feedback">
								Ingrese el precio.
							</div>
						</div>
					</div>
					<button class="btn btn-success btn-lg btn-block" type="submit">Register</button>
				</form-->
			</div>
		</div>
	</body>
</html>