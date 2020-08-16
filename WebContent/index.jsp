<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
	<head>
		<title>Business Manager</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
	</head>
	<body>
		<div class="container pt-5">
			<div class="text-center">
				<h1>Welcome!</h1>
			</div>

			<div class="row d-flex justify-content-center pt-5">
				<div class="col-md-5 mb-3">
					<div class="container p-3 mb-2 bg-info text-white">
						<img src="https://blog.alegra.com/wp-content/uploads/2015/09/ico_21-1.png" class="mx-auto d-block" style="width:50%">
						<div class="container pt-3">
							<a class="btn btn-success btn-lg btn-block" href="adminArticulo?action=mostrar" role="button">Inventario</a>
						</div>
					</div>
				</div>
				<div class="col-md-5 mb-3">
					<div class="container p-3 my-3 bg-info">
						<img src="https://images.vexels.com/media/users/3/149885/isolated/preview/761ad1d4d7041862e3270a1fef5ef9fd---cono-de-contactos-isom--tricos-by-vexels.png" class="mx-auto d-block" style="width:50%">
						<div class="container pt-3">
							<a class="btn btn-success btn-lg btn-block" href="AdminContacts?action=mostrar" role="button">Contactos</a>
						</div>
					</div>
				</div>
				<div class="col-md-5 mb-3">
					<div class="container p-3 my-3 bg-info">
						<img src="https://msfacturaelectdian.azurewebsites.net/img/new/que-saber/validad-factura%20electronica-active.png" class="mx-auto d-block" style="width:50%">
						<div class="container pt-3">
							<a class="btn btn-success btn-lg btn-block" href="adminArticulo?action=venta" role="button">Hacer cuentas</a>
						</div>
					</div>
				</div>
				<div class="col-md-5 mb-3">
					<div class="container p-3 my-3 bg-info">
						<img src="https://i.pinimg.com/originals/a6/1e/48/a61e481ee91b33b02e5bfdc5638bb1df.png" class="mx-auto d-block" style="width:50%">
						<div class="container pt-3">
							<a class="btn btn-success btn-lg btn-block" href="adminArticulo?action=estadisticas" role="button">Estadisticas</a>
						</div>
					</div>
				</div>
			</div>

		</div>
	</body>
</html>