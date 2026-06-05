<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="paginaTitulo" value="Métricas - Teleticket" />
<!DOCTYPE html>
<html lang="es">
<%@ include file="head.jsp" %>
<body>
  <%@ include file="navbarcrud.jsp" %>

  <main class="contenedor-metricas">
    <header class="metricas-header">
      <h2>Panel de Estadísticas</h2>
      <p>Resumen general del rendimiento de ventas</p>
    </header>

    <%-- KPIs generales --%>
    <div class="grid-kpis">
      <div class="tarjeta-kpi">
        <div class="kpi-icono"><i class="fa-solid fa-ticket"></i></div>
        <div class="kpi-datos">
          <span class="kpi-valor">${totalEntradasVendidas}</span>
          <span class="kpi-etiqueta">Entradas Vendidas</span>
        </div>
      </div>

      <div class="tarjeta-kpi">
        <div class="kpi-icono money"><i class="fa-solid fa-money-bill-trend-up"></i></div>
        <div class="kpi-datos">
          <span class="kpi-valor">S/. ${totalIngresos}</span>
          <span class="kpi-etiqueta">Ingresos Totales</span>
        </div>
      </div>

      <div class="tarjeta-kpi">
        <div class="kpi-icono users"><i class="fa-solid fa-users"></i></div>
        <div class="kpi-datos">
          <span class="kpi-valor">${clientesActivos}</span>
          <span class="kpi-etiqueta">Clientes Activos</span>
        </div>
      </div>
    </div>

    <div class="tarjeta-kpi">
        <div class="kpi-icono money">
            <i class="fa-solid fa-calendar-day"></i>
        </div>
        <div class="kpi-datos">
            <span class="kpi-valor">S/. ${ventasHoy}</span>
            <span class="kpi-etiqueta">Ventas de Hoy</span>
        </div>
    </div>

    <div class="tarjeta-kpi">
        <div class="kpi-icono money">
            <i class="fa-solid fa-calendar-week"></i>
        </div>
        <div class="kpi-datos">
            <span class="kpi-valor">S/. ${ventasSemana}</span>
            <span class="kpi-etiqueta">Ventas Semana Actual</span>
        </div>
    </div>

    <div class="tarjeta-kpi">
        <div class="kpi-icono">
            <i class="fa-solid fa-ticket"></i>
        </div>
        <div class="kpi-datos">
            <span class="kpi-valor">${entradasHoy}</span>
            <span class="kpi-etiqueta">Entradas Vendidas Hoy</span>
        </div>
    </div>

    <div class="tarjeta-kpi">
        <div class="kpi-icono">
            <i class="fa-solid fa-chart-line"></i>
        </div>
        <div class="kpi-datos">
            <span class="kpi-valor">${entradasSemana}</span>
            <span class="kpi-etiqueta">Entradas Vendidas Semana</span>
        </div>
    </div>

    <div class="tarjeta-kpi">
        <div class="kpi-icono money">
            <i class="fa-solid fa-calendar-days"></i>
        </div>
        <div class="kpi-datos">
            <span class="kpi-valor">S/. ${ingresosMes}</span>
            <span class="kpi-etiqueta">Ingresos del Mes</span>
        </div>
    </div>

  </main>

  <%@ include file="footer.jsp" %>

</body>
</html>