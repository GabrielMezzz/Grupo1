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

            <form action="${pageContext.request.contextPath}/registro" method="post">

                <div class="form-grupo">
                    <label>Nombre</label>
                    <input type="text" name="nombre" placeholder="Ej: Juan"
                           value="${usuario.nombre}"
                           required
                           pattern="[A-Za-zÁÉÍÓÚáéíóúÑñÜü ]+"
                           oninput="capitalizarTexto(this)">
                    <c:if test="${not empty errorNombre}">
                        <small style="color: #b00020;">${errorNombre}</small>
                    </c:if>
                </div>

                <div class="form-grupo">
                    <label>Apellido</label>
                    <input type="text" name="apellido" placeholder="Ej: Pérez"
                           value="${usuario.apellido}"
                           required
                           pattern="[A-Za-zÁÉÍÓÚáéíóúÑñÜü ]+"
                           oninput="capitalizarTexto(this)">
                    <c:if test="${not empty errorApellido}">
                        <small style="color: #b00020;">${errorApellido}</small>
                    </c:if>
                </div>

                <div class="form-grupo">
                    <label>DNI</label>
                    <input type="text" name="dni" placeholder="Ej: 12345678"
                           value="${usuario.dni}"
                           required
                           maxlength="8"
                           inputmode="numeric"
                           pattern="[0-9]{8}"
                           oninput="soloNumeros(this, 8)">
                    <c:if test="${not empty errorDni}">
                        <small style="color: #b00020;">${errorDni}</small>
                    </c:if>
                </div>

                <div class="form-grupo">
                    <label>Correo electrónico</label>
                    <input type="email" name="correo" placeholder="Ej: juan@gmail.com"
                           value="${usuario.correo}"
                           required>
                    <c:if test="${not empty errorCorreo}">
                        <small style="color: #b00020;">${errorCorreo}</small>
                    </c:if>
                </div>

                <div class="form-grupo">
                    <label>Teléfono</label>
                    <input type="text" name="telefono" placeholder="Ej: 987654321"
                           value="${usuario.telefonoFormateado}"
                           required
                           maxlength="11"
                           inputmode="numeric"
                           pattern="[0-9]{3} [0-9]{3} [0-9]{3}"
                           oninput="formatearTelefono(this)">
                    <c:if test="${not empty errorTelefono}">
                        <small style="color: #b00020;">${errorTelefono}</small>
                    </c:if>
                </div>

                <div class="form-grupo">
                    <label>Contraseña</label>
                    <input type="password" name="contrasena" placeholder="Ingresa tu contraseña"
                           value="${usuario.contrasena}"
                           required
                           minlength="8">
                    <c:if test="${not empty errorContrasena}">
                        <small style="color: #b00020;">${errorContrasena}</small>
                    </c:if>
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

    <script>
        // Capitaliza cada palabra y deja solo letras
        function capitalizarTexto(input) {
            let texto = input.value;
            let resultado = '';
            let nuevaPalabra = true;

            for (let i = 0; i < texto.length; i++) {
                let caracter = texto.charAt(i);

                if (caracter === ' ') {
                    if (resultado.length > 0 && resultado.charAt(resultado.length - 1) !== ' ') {
                        resultado += ' ';
                    }
                    nuevaPalabra = true;
                } else if (esLetra(caracter)) {
                    if (nuevaPalabra) {
                        resultado += caracter.toUpperCase();
                        nuevaPalabra = false;
                    } else {
                        resultado += caracter.toLowerCase();
                    }
                }
            }

            input.value = resultado;
        }

        // Revisa si un caracter es una letra
        function esLetra(caracter) {
            return caracter.toLowerCase() !== caracter.toUpperCase();
        }

        // Deja solo numeros y corta la cantidad maxima
        function soloNumeros(input, maximo) {
            let texto = input.value;
            let resultado = '';

            for (let i = 0; i < texto.length; i++) {
                let caracter = texto.charAt(i);

                if (caracter >= '0' && caracter <= '9') {
                    resultado += caracter;
                }
            }

            if (resultado.length > maximo) {
                resultado = resultado.substring(0, maximo);
            }

            input.value = resultado;
        }

        // Formatea el telefono como 987 654 321
        function formatearTelefono(input) {
            let texto = input.value;
            let digitos = '';

            for (let i = 0; i < texto.length; i++) {
                let caracter = texto.charAt(i);

                if (caracter >= '0' && caracter <= '9') {
                    digitos += caracter;
                }
            }

            if (digitos.length > 9) {
                digitos = digitos.substring(0, 9);
            }

            let formateado = '';

            for (let i = 0; i < digitos.length; i++) {
                if (i === 3 || i === 6) {
                    formateado += ' ';
                }
                formateado += digitos.charAt(i);
            }

            input.value = formateado;
        }
    </script>

</body>
</html>
