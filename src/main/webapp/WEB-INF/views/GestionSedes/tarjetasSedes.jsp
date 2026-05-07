<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div style="display: flex; gap: 20px; flex-wrap: wrap; margin-bottom: 30px;">
  <c:forEach var="s" items="${sedes}">
    <div class="tarjeta" style="width: 280px; min-width: 280px; max-width: 280px;
         border-top: 4px solid var(--color-primario); text-align: center; padding: 20px;">
      <h3 style="margin: 0 0 10px 0; font-size: 16px;">${s.nombre}</h3>
      <p style="font-size: 13px; color: #777;">Dirección: ${s.direccion}</p>
      <p style="font-size: 13px; color: #777;">Ciudad: ${s.ciudad}</p>
      <p style="font-size: 13px; color: #777;">Tipo: ${s.tipo}</p>
      <p style="font-size: 13px; color: #777;">Capacidad: ${s.capacidad}</p>
      <p style="font-size: 13px; color: #777;">Teléfono: ${s.telefono}</p>
      <a href="${pageContext.request.contextPath}/gestionsedes/eliminar/${s.id}">
        <button class="btn-secundario" style="width: 100%; padding: 8px; font-size: 12px; margin-top: 15px;">Eliminar</button>
      </a>
    </div>
  </c:forEach>
</div>