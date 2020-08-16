<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
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
				<form action="adminArticulo?action=register" class="needs-validation" novalidate method="post">
					<div class="form-row">
						<div class="col-md-4 mb-3">
							<label for="validationCustomCode">Codigo</label>
							<input type="text" class="form-control" id="validationCustomCode" placeholder="Codigo" maxlength="45" required name="codigo">
							<div class="invalid-feedback">
								Ingrese un codigo valido.
							</div>
						</div>
						<div class="col-md-4 mb-3">
							<label for="validationCustomName">Nombre</label>
							<input type="text" class="form-control" id="validationCustomName" placeholder="Nombre" maxlength="45" required name="nombre">
							<div class="invalid-feedback">
								Ingrese un nombre valido.
							</div>
						</div>
						<div class="col-md-4 mb-3">
							<label for="validationCustomDescription">Descripcion</label>
							<input type="text" class="form-control" id="validationCustomDescription" placeholder="Descripcion" maxlength="45" required name="descripcion">
							<div class="invalid-feedback">
								Ingrese una descripcion.
							</div>
						</div>
					</div>

					<div class="form-row">
						<div class="col-md-4 mb-3">
							<label for="validationCustomExistence">Existencia</label>
							<input type="text" class="form-control" id="validationCustomExistence" placeholder="Existencia" maxlength="45" required name="cantidad">
							<div class="invalid-feedback">
								Ingrese la existencia.
							</div>
						</div>
						<div class="col-md-4 mb-3">
							<label for="validationCustomPrecio">Precio</label>
							<input type="text" class="form-control" id="validationCustomPrecio" placeholder="Precio" required name="precio">
							<div class="invalid-feedback">
								Ingrese el precio.
							</div>
						</div>
					</div>
					<button class="btn btn-success btn-lg btn-block" type="submit">Register</button>
				</form>
			</div>

		</div>
	</body>
</html> 