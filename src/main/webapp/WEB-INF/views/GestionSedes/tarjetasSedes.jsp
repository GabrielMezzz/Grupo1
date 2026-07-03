<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div style="display: flex; gap: 20px; flex-wrap: wrap; margin-bottom: 30px;">
  <c:forEach var="s" items="${sedes}">
    <div class="tarjeta" style="width: 280px; min-width: 280px; max-width: 280px;
         border-top: 4px solid var(--color-primario); text-align: center; padding: 20px;">
      <h3 style="margin: 0 0 10px 0; font-size: 16px;">${s.nombreSede}</h3>
      <p style="font-size: 13px; color: #777;">Dirección: ${s.direccionSede}</p>
      <p style="font-size: 13px; color: #777;">Ciudad: ${s.ciudadSede}</p>
      <p style="font-size: 13px; color: #777;">Capacidad: ${s.capacidadSede}</p>
      <p style="font-size: 13px; color: #777;">Artista: ${s.nombreArtista}</p>
      <p style="font-size: 13px; color: #777;">Género: ${s.genero}</p>
      <p style="font-size: 13px; color: #777;">Correo: ${s.correo}</p>
      <p style="font-size: 13px; color: #777;">Teléfono: ${s.telefono}</p>
      <span style="background-color: #d4edda; color: #155724; padding: 3px 10px; border-radius: 20px; font-size: 12px; display: inline-block; margin-top: 8px;">${s.estado}</span>
      <div style="display: flex; gap: 8px; margin-top: 15px;">
        <a href="${pageContext.request.contextPath}/gestionsedes/editar/${s.id}" style="flex: 1;">
          <button class="btn-primario" style="width: 100%; padding: 8px; font-size: 12px;">Editar</button>
        </a>
        <a href="${pageContext.request.contextPath}/gestionsedes/eliminar/${s.id}" style="flex: 1;">
          <button class="btn-secundario" style="width: 100%; padding: 8px; font-size: 12px;">Eliminar</button>
        </a>
      </div>
    </div>
  </c:forEach>
</div>