<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- CDN Bootstrap -->
<title>Sistema de Información de Prevención de Riesgos</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" type="text/css">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-lg navbar-dark">
			<div class="container-fluid">
				<a class="navbar-brand fw-semibold fs-4"
					href="${pageContext.request.contextPath}/index">Sistema
					de Prevención de Riesgos</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarNav"
					aria-controls="navbarNav" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNav">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link text-white"
							href="${pageContext.request.contextPath}/inicio">Inicio</a>
						</li>
						<li class="nav-item"><a class="nav-link text-white"
							href="${pageContext.request.contextPath}/crearcapacitacion">Crear
								Capacitación</a>
						</li>
						<li class="nav-item"><a class="nav-link text-white"
							href="${pageContext.request.contextPath}/listarcapacitaciones">Listar
								Capacitaciones</a>
						</li>
						<li class="nav-item"><a class="nav-link text-white"
							href="${pageContext.request.contextPath}/crearusuario">Crear
								Usuario</a>
						</li>
						<li class="nav-item"><a class="nav-link text-white"
							href="${pageContext.request.contextPath}/listarusuarios">Listar
								Usuarios</a>
						</li>
						<li class="nav-item"><a class="nav-link text-white"
							href="${pageContext.request.contextPath}/contacto">Contacto</a>
						</li>
					</ul>
				</div>
				<% if (session!=null || session.getAttribute("user") == null) %>
					<a href="${pageContext.request.contextPath}/logout"
					class="btn btn-danger my-2 fw-semibold">Cerrar sesión</a>
				<% %>
			</div>
		</nav>
	</header>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
