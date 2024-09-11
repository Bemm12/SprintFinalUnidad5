<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Login</title>
<!-- Bootstrap CSS -->

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/styles.css"
	type="text/css">

</head>
<body
	class="bg-light d-flex align-items-center justify-content-center vh-100">
	<div class="container">
		<div class="row">
			<!-- Columna de la imagen -->
			<div class="col-md-6 col-lg-6 d-none d-md-block">
				<div class="h-100 d-flex align-items-center justify-content-center">
					<img src="https://img.freepik.com/vector-premium/ilustracion-vectorial-seguridad-proteccion-civil-seguridad-trabajo-toma-medidas-seguridad_1229301-5585.jpg"
						alt="Imagen de bienvenida" class="img-fluid rounded h-100 w-100"
						style="object-fit: cover;">

				</div>
			</div>
			<!-- Columna del formulario -->
			<div class="col-md-6 col-lg-6">
				<div class="card shadow-lg rounded h-100">
					<div
						class="card-body p-4 d-flex align-items-center justify-content-center">
						<div>
						<h1 class="card-title text-center text-dark mb-4">Sistema de prevención de riesgos</h1>	
							<h2 class="card-title text-center text-primary mb-4">Iniciar
								sesión</h2>
							<form method="POST" action="login">
								<div class="form-floating mb-3">
									<input type="text" class="form-control" id="userName"
										name="userName" placeholder="Ingrese su usuario" required>
									<label for="userName">Usuario</label>
								</div>
								<div class="form-floating mb-3">
									<input type="password" class="form-control" id="password"
										name="password" placeholder="Ingrese su contraseña" required>
									<label for="password">Contraseña</label>
								</div>
								<div class="d-grid gap-2">
									<button type="submit" class="btn btn-primary btn-lg">Iniciar
										sesión</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Bootstrap JS -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>