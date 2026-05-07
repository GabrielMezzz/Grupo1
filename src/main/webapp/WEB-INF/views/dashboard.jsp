<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <title>Dashboard - Teleticket</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
</head>
<body>

  <div class="contenedor">
    <h2 style="margin-bottom: 25px;">Accesos Rápidos</h2>

    <div style="display: flex; gap: 20px; flex-wrap: wrap; justify-content: center;">

      <a href="${pageContext.request.contextPath}/gestioneventos" style="text-decoration: none;">
        <div class="tarjeta" style="width: 200px; text-align: center; cursor: pointer;">
          <i class="fa-solid fa-music" style="font-size: 50px; color: var(--color-primario);"></i>
          <p style="margin-top: 15px; font-weight: bold; color: var(--color-primario);">Gestionar Eventos</p>
        </div>
      </a>

      <a href="${pageContext.request.contextPath}/gestioncategorias" style="text-decoration: none;">
        <div class="tarjeta" style="width: 200px; text-align: center; cursor: pointer;">
          <i class="fa-solid fa-folder" style="font-size: 50px; color: var(--color-primario);"></i>
          <p style="margin-top: 15px; font-weight: bold; color: var(--color-primario);">Categorías</p>
        </div>
      </a>

      <a href="${pageContext.request.contextPath}/gestionusuarios" style="text-decoration: none;">
        <div class="tarjeta" style="width: 200px; text-align: center; cursor: pointer;">
          <i class="fa-solid fa-users" style="font-size: 50px; color: var(--color-primario);"></i>
          <p style="margin-top: 15px; font-weight: bold; color: var(--color-primario);">Usuarios</p>
        </div>
      </a>

      <a href="${pageContext.request.contextPath}/gestion" style="text-decoration: none;">
        <div class="tarjeta" style="width: 200px; text-align: center; cursor: pointer;">
          <i class="fa-solid fa-ticket" style="font-size: 50px; color: var(--color-primario);"></i>
          <p style="margin-top: 15px; font-weight: bold; color: var(--color-primario);">Entradas</p>
        </div>
      </a>

      <a href="${pageContext.request.contextPath}/gestionsedes" style="text-decoration: none;">
        <div class="tarjeta" style="width: 200px; text-align: center; cursor: pointer;">
          <i class="fa-solid fa-location-dot" style="font-size: 50px; color: var(--color-primario);"></i>
          <p style="margin-top: 15px; font-weight: bold; color: var(--color-primario);">Sedes</p>
        </div>
      </a>

      <a href="${pageContext.request.contextPath}/gestionartistas" style="text-decoration: none;">
        <div class="tarjeta" style="width: 200px; text-align: center; cursor: pointer;">
          <i class="fa-solid fa-microphone" style="font-size: 50px; color: var(--color-primario);"></i>
          <p style="margin-top: 15px; font-weight: bold; color: var(--color-primario);">Artistas</p>
        </div>
      </a>

      <a href="${pageContext.request.contextPath}/metricas" style="text-decoration: none;">
        <div class="tarjeta" style="width: 200px; text-align: center; cursor: pointer;">
          <i class="fa-solid fa-chart-bar" style="font-size: 50px; color: var(--color-primario);"></i>
          <p style="margin-top: 15px; font-weight: bold; color: var(--color-primario);">Métricas</p>
        </div>
      </a>

    </div>
  </div>

  <%@ include file="footer.jsp" %>

</body>
</html>