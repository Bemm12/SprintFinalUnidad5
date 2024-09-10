<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Contacto</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" type="text/css">
</head>
<body>
    <%@ include file="navbar.jsp" %>

    <div class="container mt-5">
        <h1 class="text-center fw-bold">Contacto</h1>

        <form action="contacto" method="post">
            <div class="mb-3">
                <label for="nombre" class="form-label">Nombre:</label>
                <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Ingrese su nombre" required>
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">Correo Electrónico:</label>
                <input type="email" class="form-control" id="email" name="email" placeholder="Ingrese su correo" required>
            </div>
            <div class="mb-3">
                <label for="mensaje" class="form-label">Mensaje:</label>
                <textarea class="form-control" id="mensaje" name="mensaje" rows="4" placeholder="Escriba su mensaje" required></textarea>
            </div>
            <div class="text-center">
                <button type="submit" class="btn btn-primary">Enviar</button>
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

    <%@ include file="footer.jsp" %>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
