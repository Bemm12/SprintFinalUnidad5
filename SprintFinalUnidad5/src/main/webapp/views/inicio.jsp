<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Bienvenido</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/styles.css"
	type="text/css">
</head>
<body>
	<%@ include file='navbar.jsp'%>

	<div class="container mt-5">
		<div class="text-center mb-4">
			<h1 class="display-4 fw-bold mb-3">Sistema de Información de
				Prevención de Riesgos</h1>
			<h2 class="lead fs-3 fw-semibold">Bienvenido al portal de
				administración de procesos</h2>
			<img
				src="https://media.istockphoto.com/id/1328114467/es/vector/personajes-masculinos-y-femeninos-cubiertos-por-la-seguridad-del-seguro.jpg?s=612x612&w=0&k=20&c=97hkUOXjZ9MS-XxDr9D3sEkm7o5A2grhIo7D3oKv8B0="
				alt="Bienvenida" class="img-fluid mb-4 rounded shadow">

		</div>

		<div class="text-center">
			<p class="mb-4">En este portal podrás gestionar todas las
				actividades relacionadas con la prevención de riesgos en tu empresa.</p>
		</div>
	</div>

	<!-- Footer -->
	<%@ include file='footer.jsp'%>

	<!-- Bootstrap JS -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
