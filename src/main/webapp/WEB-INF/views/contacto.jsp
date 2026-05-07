<%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <!DOCTYPE html>
  <html lang="es">

  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Contacto - Teleticket</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
  </head>

  <body>

    <%@ include file="navbar.jsp" %>

      <main class="contacto-container">
        <h2 class="contacto-titulo">Contáctanos</h2>
        <div class="contacto-flex">
          <%@ include file="formulariocontacto.jsp" %>
            <%@ include file="infocontacto.jsp" %>
        </div>
      </main>

      <%@ include file="footer.jsp" %>

  </body>

  </html>