<%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>
    <html lang="es">

    <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>Eventos - Teleticket</title>
      <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    </head>

    <body>

      <%@ include file="navbar.jsp" %>

        <c:if test="${compraExitosa}">
          <div class="alerta alerta-exito">
            <i class="fa-solid fa-circle-check"></i>
            <span>¡Compra exitosa! Tu entrada ha sido registrada.</span>
          </div>
        </c:if>

        <main>
          <%@ include file="bannereve.jsp" %>

            <div class="eventos-layout">
              <%@ include file="filtros.jsp" %>
                <%@ include file="listaeventos.jsp" %>
            </div>
        </main>

        <%@ include file="footer.jsp" %>

    </body>

    </html>