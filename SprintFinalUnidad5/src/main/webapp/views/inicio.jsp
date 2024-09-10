<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Bienvenido</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" type="text/css">
</head>
<body>
    <%@ include file='navbar.jsp'%>
    
    <div class="container mt-5">
		<div class="text-center mb-4">
			<h1 class="display-4 fw-bold mb-5">Sistema de Información de
				Prevención de Riesgos</h1>
			<h2 class="lead fs-3 fw-semibold">Bienvenido al portal de administración de
				procesos</h2>
		</div>

		<div class="text-center">
			<p class="mb-4">En este portal podrás gestionar todas las
				actividades relacionadas con la prevención de riesgos en tu empresa.
			</p>
		</div>
	</div>
    
    <!-- Footer -->
	<%@ include file='footer.jsp'%>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>