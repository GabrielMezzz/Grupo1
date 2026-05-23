<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="tarjeta">
  <table width="100%">
    <thead>
      <tr>
        <th>#</th>
        <th>Nombre</th>
        <th>DNI</th>
        <th>Correo</th>
        <th>Teléfono</th>
        <th>Rol</th>
        <th>Estado</th>
        <th>Acciones</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="u" items="${usuarios}">
        <tr>
          <td>${u.id}</td>
          <td>${u.nombre} ${u.apellido}</td>
          <td>${u.dni}</td>
          <td>${u.correo}</td>
          <td>${u.telefono}</td>
          <td><span style="background-color: #cce5ff; color: #004085; padding: 3px 10px; border-radius: 20px; font-size: 12px;">${u.rol}</span></td>
          <td><span style="background-color: #d4edda; color: #155724; padding: 3px 10px; border-radius: 20px; font-size: 12px;">${u.estado}</span></td>
          <td style="display: flex; gap: 6px;">
            <a href="${pageContext.request.contextPath}/gestionusuarios/editar/${u.id}">
              <button class="btn-primario" style="padding: 5px 12px; font-size: 12px;">Editar</button>
            </a>
            <a href="${pageContext.request.contextPath}/gestionusuarios/eliminar/${u.id}">
              <button class="btn-secundario" style="padding: 5px 12px; font-size: 12px;">Eliminar</button>
            </a>
          </td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</div>