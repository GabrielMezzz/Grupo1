<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
    <!DOCTYPE html>
    <html lang="es">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Error - Teleticket</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
    </head>

    <body>

        <main class="error-container">
            <div class="error-card">
                <i class="fa-solid fa-circle-exclamation error-icon"></i>
                <h1 class="error-title">¡Ups! Algo salió mal</h1>

                <p class="error-msg-user">${mensajeError}</p>

                <div class="error-tecnico">
                    <p>Detalle para soporte: <code>${pageContext.exception}</code></p>
                </div>

                <a href="${pageContext.request.contextPath}/main" class="btn-error">
                    Volver al inicio
                </a>
            </div>
        </main>

    </body>

    </html>