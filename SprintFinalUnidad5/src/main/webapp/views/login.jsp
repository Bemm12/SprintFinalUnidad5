<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Login</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container h-100">
        <div class="row justify-content-center align-items-center h-100">
            <div class="col-md-6 col-lg-4 mt-5">
                <div class="card shadow">
                    <div class="card-body">
                        <h2 class="card-title text-center">Iniciar sesión</h2>
                        <form method="POST" action="login">
                            <div class="form-group mb-3">
                                <label for="userName">Usuario</label>
                                <input type="text" class="form-control" id="userName" name="userName" placeholder="Ingrese su usuario" required>
                            </div>
                            <div class="form-group mb-3">
                                <label for="password">Contraseña</label>
                                <input type="password" class="form-control" id="password" name="password" placeholder="Ingrese su contraseña" required>
                            </div>
                            <div class="row justify-content-center">
                                <div class="col-5">
                                    <button type="submit" class="btn btn-primary w-100">Iniciar sesión</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>