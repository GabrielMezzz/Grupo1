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

    <%-- Métrica 1: Ventas de hoy con gráfico semanal --%>
    <div class="tarjeta" style="margin-top: 30px; padding: 25px;">
      <div style="display: flex; justify-content: space-between; align-items: center; margin-bottom: 15px;">
        <h3 style="color: var(--color-primario); margin: 0;">
          <i class="fa-solid fa-calendar-day" style="margin-right: 8px;"></i>
          Ventas de Hoy
        </h3>
        <span style="font-size: 28px; font-weight: bold; color: var(--color-primario);">S/. ${ventasHoy}</span>
      </div>
      <p style="color: #777; font-size: 13px; margin-bottom: 15px;">Evolución de ventas en S/. durante la semana actual</p>
      <canvas id="graficaVentasSemana" height="80"></canvas>
    </div>

    <%-- Métrica 2: Ventas semana actual --%>
    <div class="tarjeta" style="margin-top: 20px; padding: 25px;">
      <div style="display: flex; justify-content: space-between; align-items: center; margin-bottom: 15px;">
        <h3 style="color: var(--color-primario); margin: 0;">
          <i class="fa-solid fa-calendar-week" style="margin-right: 8px;"></i>
          Ventas Semana Actual
        </h3>
        <span style="font-size: 28px; font-weight: bold; color: var(--color-primario);">S/. ${ventasSemana}</span>
      </div>
      <p style="color: #777; font-size: 13px; margin-bottom: 15px;">Entradas vendidas por día durante la semana actual</p>
      <canvas id="graficaEntradasSemana" height="80"></canvas>
    </div>

    <%-- Métrica 3: Entradas vendidas hoy --%>
    <div class="tarjeta" style="margin-top: 20px; padding: 25px;">
      <div style="display: flex; justify-content: space-between; align-items: center; margin-bottom: 15px;">
        <h3 style="color: var(--color-primario); margin: 0;">
          <i class="fa-solid fa-ticket" style="margin-right: 8px;"></i>
          Entradas Vendidas Hoy
        </h3>
        <span style="font-size: 28px; font-weight: bold; color: var(--color-primario);">${entradasHoy}</span>
      </div>
      <p style="color: #777; font-size: 13px; margin-bottom: 15px;">Cantidad de entradas vendidas por día esta semana</p>
      <canvas id="graficaEntradasDia" height="80"></canvas>
    </div>

    <%-- Métrica 4: Entradas vendidas en la semana --%>
    <div class="tarjeta" style="margin-top: 20px; padding: 25px;">
      <div style="display: flex; justify-content: space-between; align-items: center; margin-bottom: 15px;">
        <h3 style="color: var(--color-primario); margin: 0;">
          <i class="fa-solid fa-chart-line" style="margin-right: 8px;"></i>
          Entradas Vendidas en la Semana
        </h3>
        <span style="font-size: 28px; font-weight: bold; color: var(--color-primario);">${entradasSemana}</span>
      </div>
      <p style="color: #777; font-size: 13px; margin-bottom: 15px;">Acumulado de entradas vendidas de lunes a hoy</p>
      <canvas id="graficaEntradasAcumuladas" height="80"></canvas>
    </div>

    <%-- Métrica 5: Ingresos del mes --%>
    <div class="tarjeta" style="margin-top: 20px; margin-bottom: 30px; padding: 25px;">
      <div style="display: flex; justify-content: space-between; align-items: center; margin-bottom: 15px;">
        <h3 style="color: var(--color-primario); margin: 0;">
          <i class="fa-solid fa-calendar-days" style="margin-right: 8px;"></i>
          Ingresos del Mes
        </h3>
        <span style="font-size: 28px; font-weight: bold; color: var(--color-primario);">S/. ${ingresosMes}</span>
      </div>
      <p style="color: #777; font-size: 13px; margin-bottom: 15px;">Ingresos en S/. por día durante el mes actual</p>
      <canvas id="graficaIngresosMes" height="80"></canvas>
    </div>

  </main>

  <%@ include file="footer.jsp" %>

  <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
  <script>
    const diasSemana = [<c:forEach var="e" items="${ventasPorDia}">'${e.key}',</c:forEach>];
    const ventasSemanaData = [<c:forEach var="e" items="${ventasPorDia}">${e.value},</c:forEach>];
    const entradasSemanaData = [<c:forEach var="e" items="${entradasPorDia}">${e.value},</c:forEach>];
    const diasMes = [<c:forEach var="e" items="${ingresosPorDiaMes}">'${e.key}',</c:forEach>];
    const ingresosMesData = [<c:forEach var="e" items="${ingresosPorDiaMes}">${e.value},</c:forEach>];

    // Función para crear gráfico de línea simple
    function crearGrafico(id, labels, data, color, prefix) {
      new Chart(document.getElementById(id), {
        type: 'line',
        data: {
          labels: labels,
          datasets: [{
            data: data,
            borderColor: color,
            backgroundColor: color.replace('1)', '0.1)'),
            fill: true,
            tension: 0.4,
            pointRadius: 4,
            pointBackgroundColor: color
          }]
        },
        options: {
          responsive: true,
          plugins: { legend: { display: false } },
          scales: {
            y: {
              beginAtZero: true,
              ticks: {
                callback: function(v) { return prefix + v; }
              }
            }
          }
        }
      });
    }

    // Métrica 1: Ventas en S/. por día esta semana
    crearGrafico('graficaVentasSemana', diasSemana, ventasSemanaData, 'rgba(220,53,69,1)', 'S/. ');

    // Métrica 2: Entradas por día esta semana
    crearGrafico('graficaEntradasSemana', diasSemana, entradasSemanaData, 'rgba(0,123,255,1)', '');

    // Métrica 3: Entradas vendidas hoy (misma data semanal, resaltando el día actual)
    crearGrafico('graficaEntradasDia', diasSemana, entradasSemanaData, 'rgba(40,167,69,1)', '');

    // Métrica 4: Acumulado de entradas en la semana
    const acumulado = entradasSemanaData.reduce((acc, val, i) => {
      acc.push((acc[i-1] || 0) + val);
      return acc;
    }, []);
    crearGrafico('graficaEntradasAcumuladas', diasSemana, acumulado, 'rgba(255,193,7,1)', '');

    // Métrica 5: Ingresos por día del mes
    crearGrafico('graficaIngresosMes', diasMes, ingresosMesData, 'rgba(111,66,193,1)', 'S/. ');
  </script>

</body>
</html>