<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>CSID - Articulos</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
	</head>
<body>
	<div class="container pt-5">
		<div class="text-center">
			<h1>Inventario</h1>
		</div>
		<div class="text pt-5">
			<h2>Lista de Items</h2>
		</div>
		<div class="row">
				
			<div class="col-md-4 mb-4 pt-4">
				
          			<form class="form-inline md-form mr-auto" action ="adminArticulo?action=buscar" method="post">
            			<input class="form-control" type="text" placeholder="Search" aria-label="Search" name="codigo">
            			
            			<button class="btn btn-success" type="submit">Buscar</button>
							<select class="form-control" id="exampleFormControlSelect1" name="categoria">
								<option value="Todos">Todos</option>
								<option value="Existencia Alta">Existencia Alta</option>
								<option value="Existencia Baja">Existencia Baja</option>
							</select>
          			</form>
        		</div>
        	<div class="col-md-3 mb-4 pt-3">
				<a class="btn btn-success btn-lg btn-block" href="adminArticulo?action=nuevo" role="button">Añadir Item</a>
			</div>
			<div class="col-md-2 mb-4 pt-3">
				<a class="btn btn-success btn-lg btn-block" href="adminArticulo?action=index" role="button">Volver</a>
			</div>
		</div>
		<div class="container">
			<table class="table table-striped table-dark">
				<thead>
					<tr>
						<th scope="col">Codigo</th> 
						<th scope="col">Nombre</th>
						<th scope="col">Existencias</th>
						<th scope="col">Precio</th>
						<th scope="col" colspan="2">Acciones</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${lista}">
						<tr>
							<th scope="row"><c:out value="${item.codigo}"/></th>
							<td><c:out value="${item.nombre}"/></td>
							<td><c:out value="${item.existencia}"/></td>
							<td><c:out value="${item.precio}"/></td>
							<td><a href="adminArticulo?action=showedit&id=<c:out value="${item.id}" />">Editar</a></td>
							<td><a href="adminArticulo?action=eliminar&id=<c:out value="${item.id}"/>">Eliminar</a></td>
						</tr>
					</c:forEach>
				</tbody>
  			</table>
		</div>
	</div>
</body>
</html>