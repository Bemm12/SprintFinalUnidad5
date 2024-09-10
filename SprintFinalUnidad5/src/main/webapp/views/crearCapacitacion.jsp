<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Crear Capacitación</title>
	<!-- Bootstrap CSS -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
	<!-- CSS Personalizado     -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" type="text/css">
</head>
<body>
	<%@ include file="navbar.jsp" %>

	<div class="container mt-5">
		<h1 class="text-center fw-bold">Crear Capacitación</h1>

		<form action="crearcapacitacion" method="post">
			<div class="mb-3">
				<label for="nombre" class="form-label">Nombre:</label> <input
					type="text" class="form-control" id="nombre"
					name="nombre" placeholder="Ingrese el nombre" required>
			</div>
			<div class="mb-3">
				<label for="detalle" class="form-label">Detalle:</label> <input
					type="text" class="form-control" id="detalle" name="detalle"
					placeholder="Ingrese el detalle" required>
			</div>
			<div class="text-center">
				<button type="submit" class="btn btn-primary">Crear
					Capacitación</button>
			</div>
		</form>
		
		<!-- Mensaje de confirmación -->
		<c:if test="${not empty successMessage}">
			<h3 class="text-success text-center mt-2">${successMessage}</h3>
		</c:if>
		
		<!-- Mensaje de error  -->
		<c:if test="${not empty errorMessage}">
			<h3 class="text-danger text-center mt-2">${errorMessage}</h3>
		</c:if>
		
 	</div>

	<!-- Footer -->
	<%@ include file="footer.jsp" %>

	<!-- Las validaciones del formulario son realizadas por el Javascript de Bootstrap -->
	<!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>