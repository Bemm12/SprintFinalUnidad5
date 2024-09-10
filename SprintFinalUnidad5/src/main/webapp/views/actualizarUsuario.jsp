<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Actualizar Usuario</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- CSS Personalizado -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" type="text/css">
</head>
<body>
    <%@ include file="navbar.jsp" %>

    <div class="container mt-5">
        <h1 class="text-center fw-bold">Actualizar Usuario</h1>

        <form action="actualizarusuario" method="post">
            <input type="hidden" name="id" value="${usuario.id}" />
            <div class="mb-3">
                <label for="nombre" class="form-label">Nombre:</label>
                <input type="text" class="form-control" id="nombre" name="nombre" value="${usuario.nombre}" required>
            </div>
            <div class="mb-3">
                <label for="tipo" class="form-label">Tipo:</label>
                <select name="tipo" id="tipo" required>
                    <option value="CLIENTE" ${usuario.tipo == 'CLIENTE' ? 'selected' : ''}>Cliente</option>
                    <option value="PROFESIONAL" ${usuario.tipo == 'PROFESIONAL' ? 'selected' : ''}>Profesional</option>
                    <option value="ADMINISTRATIVO" ${usuario.tipo == 'ADMINISTRATIVO' ? 'selected' : ''}>Administrativo</option>
                </select>
            </div>
            <div class="text-center">
                <button type="submit" class="btn btn-primary">Actualizar Usuario</button>
            </div>
        </form>

        <!-- Mensaje de confirmación -->
        <c:if test="${not empty successMessage}">
            <h3 class="text-success text-center mt-2">${successMessage}</h3>
        </c:if>

        <!-- Mensaje de error -->
        <c:if test="${not empty errorMessage}">
            <h3 class="text-danger text-center mt-2">${errorMessage}</h3>
        </c:if>
    </div>

    <!-- Footer -->
    <%@ include file="footer.jsp" %>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
