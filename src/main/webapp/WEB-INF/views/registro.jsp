<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <title>Registro - Teleticket</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

    <%@ include file="navbar.jsp" %>

    <div class="contenedor" style="max-width: 500px; margin-top: 60px;">
        <div class="tarjeta">
            <h2 style="text-align: center; margin-bottom: 25px; color: var(--color-primario);">Crear Cuenta</h2>

            <c:if test="${not empty error}">
                <p style="color: red; text-align: center; margin-bottom: 15px;">${error}</p>
            </c:if>

            <form action="${pageContext.request.contextPath}/registro" method="post">

                <div class="form-grupo">
                    <label>Nombre</label>
                    <input type="text" name="nombre" placeholder="Ej: Juan" required>
                </div>

                <div class="form-grupo">
                    <label>Apellido</label>
                    <input type="text" name="apellido" placeholder="Ej: Pérez" required>
                </div>

                <div class="form-grupo">
                    <label>DNI</label>
                    <input type="text" name="dni" placeholder="Ej: 12345678" required>
                </div>

                <div class="form-grupo">
                    <label>Correo electrónico</label>
                    <input type="email" name="correo" placeholder="Ej: juan@gmail.com" required>
                </div>

                <div class="form-grupo">
                    <label>Teléfono</label>
                    <input type="text" name="telefono" placeholder="Ej: 987654321" required>
                </div>

                <div class="form-grupo">
                    <label>Contraseña</label>
                    <input type="password" name="contrasena" placeholder="Ingresa tu contraseña" required>
                </div>

                <div style="margin-top: 20px;">
                    <button type="submit" class="btn-primario" style="width: 100%;">Registrarse</button>
                </div>

                <p style="text-align: center; margin-top: 15px; font-size: 13px;">
                    ¿Ya tienes cuenta?
                    <a href="${pageContext.request.contextPath}/login" style="color: var(--color-primario);">Inicia sesión aquí</a>
                </p>

            </form>
        </div>
    </div>

    <%@ include file="footer.jsp" %>

</body>
</html>