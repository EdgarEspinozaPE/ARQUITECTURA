<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
          <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Historial</title>
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
			<h1>Historial</h1>
		</div>
		<div class="container pt-5">
			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col">Código</th> 
						<th scope="col">Cantidad</th>
						<th scope="col">Total</th>
						<th scope="col">Fechas</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="venta" items="${lista}">
						<tr>
							<th scope="row"><c:out value="${venta.codigo}"/></th>
							<td><c:out value="${venta.cantidad}"/></td>
							<td><c:out value="${venta.total}"/></td>
							<td><c:out value="${venta.fecha}"/></td>
						</tr>
					</c:forEach>
				</tbody>
  			</table>
		</div>
	</div>
</body>
</html>