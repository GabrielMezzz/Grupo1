<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <title>Mis Entradas - Teleticket</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
</head>
<body>

  <%@ include file="navbar.jsp" %>

  <div class="contenedor">

    <div style="margin-bottom: 30px;">
      <h2>Mis Entradas</h2>
      <p style="color: #777; margin-top: 5px;">Bienvenido, <strong>${usuario.nombre} ${usuario.apellido}</strong></p>
    </div>

    <c:choose>
      <c:when test="${empty agrupadas}">
        <div class="tarjeta" style="text-align: center; padding: 60px 20px;">
          <i class="fa-solid fa-ticket" style="font-size: 48px; color: #ccc; margin-bottom: 15px;"></i>
          <h3 style="color: #aaa;">No tienes entradas compradas aún</h3>
          <a href="${pageContext.request.contextPath}/eventos">
            <button class="btn-primario" style="margin-top: 20px;">Ver Eventos Disponibles</button>
          </a>
        </div>
      </c:when>
      <c:otherwise>
        <div class="tarjeta">
          <table width="100%">
            <thead>
              <tr>
                <th>#</th>
                <th>Evento</th>
                <th>Cantidad</th>
                <th>Precio unitario</th>
                <th>Total</th>
                <th>Fecha de Compra</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach var="e" items="${agrupadas}" varStatus="loop">
                <tr>
                  <td>${loop.index + 1}</td>
                  <td><strong>${e.evento}</strong></td>
                  <td>${e.cantidad}</td>
                  <td>S/. ${e.precio}</td>
                  <td>S/. ${e.total}</td>
                  <td>${e.fechaCompra}</td>
                </tr>
              </c:forEach>
            </tbody>
          </table>
        </div>
      </c:otherwise>
    </c:choose>

  </div>

  <%@ include file="footer.jsp" %>

</body>
</html>