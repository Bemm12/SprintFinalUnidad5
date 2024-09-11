<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<!-- Bootstrap CSS -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
	<!-- CSS Personalizado     -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" type="text/css">
</head>
<body>
	<%@ include file="navbar.jsp" %>

	<div class="container mt-5">
		<h1 class="text-center fw-bold">Listado de Capacitaciones</h1>

	<table class="table">
 		<thead>
 			<tr>
 				<th scope="col">#</th>
 				<th scope="col">Nombre</th>
 				<th scope="col">Detalle</th>
 				<th scope="col">Acciones</th>
 			</tr>
 		</thead>
 		<tbody>
 			<c:forEach var="capacitacion" items="${caps}">
 				<tr>
 					<th scope="col">${capacitacion.id}</th>
	 				<th scope="col">${capacitacion.nombre}</th>
	 				<th scope="col">${capacitacion.detalle}</th>
	 				<td>
							<!-- Enlace al controlador de actualización con el ID del usuario -->
							<a
							href="#"
							class="btn btn-warning">Actualizar</a>
							<a
							href="#"
							class="btn btn-danger">Eliminar</a>
						</td>
 				</tr>
 			</c:forEach>
 		</tbody>
 	</table>
	</div>

	<!-- Footer -->
	<%@ include file="footer.jsp" %>

	<!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>