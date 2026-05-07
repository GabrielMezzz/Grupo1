<%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <!DOCTYPE html>
  <html lang="es">

  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard - Teleticket</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
  </head>

  <body>

    <main class="dashboard-container">
      <h2 class="dashboard-titulo">Accesos Rápidos</h2>

      <div class="dashboard-grid">
        <a href="${pageContext.request.contextPath}/gestioneventos" class="dash-link">
          <div class="dash-card">
            <i class="fa-solid fa-music dash-icon"></i>
            <p class="dash-text">Gestionar Eventos</p>
          </div>
        </a>

        <a href="${pageContext.request.contextPath}/gestioncategorias" class="dash-link">
          <div class="dash-card">
            <i class="fa-solid fa-folder dash-icon"></i>
            <p class="dash-text">Categorías</p>
          </div>
        </a>

        <a href="${pageContext.request.contextPath}/gestionusuarios" class="dash-link">
          <div class="dash-card">
            <i class="fa-solid fa-users dash-icon"></i>
            <p class="dash-text">Usuarios</p>
          </div>
        </a>

        <a href="${pageContext.request.contextPath}/gestion" class="dash-link">
          <div class="dash-card">
            <i class="fa-solid fa-ticket dash-icon"></i>
            <p class="dash-text">Entradas</p>
          </div>
        </a>

        <a href="${pageContext.request.contextPath}/gestionsedes" class="dash-link">
          <div class="dash-card">
            <i class="fa-solid fa-location-dot dash-icon"></i>
            <p class="dash-text">Sedes</p>
          </div>
        </a>

        <a href="${pageContext.request.contextPath}/gestionartistas" class="dash-link">
          <div class="dash-card">
            <i class="fa-solid fa-microphone dash-icon"></i>
            <p class="dash-text">Artistas</p>
          </div>
        </a>

        <a href="${pageContext.request.contextPath}/entradas/metricas" class="dash-link">
          <div class="dash-card">
            <i class="fa-solid fa-chart-bar dash-icon"></i>
            <p class="dash-text">Métricas</p>
          </div>
        </a>
      </div>
    </main>

    <%@ include file="footer.jsp" %>

  </body>

  </html>