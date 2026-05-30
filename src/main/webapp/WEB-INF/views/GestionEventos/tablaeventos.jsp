<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="tarjeta">
  <table width="100%">
    <thead>
      <tr>
        <th>#</th>
        <th>Nombre</th>
        <th>Categoria</th>
        <th>Fecha</th>
        <th>Artista</th>
        <th>Hora</th>
        <th>Lugar</th>
        <th>Precio</th>
        <th>Capacidad</th>
        <th>Estado</th>
        <th>Acciones</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="e" items="${eventos}">
        <tr>
          <td>${e.id}</td>
          <td>${e.nombre}</td>
          <td>${e.categoria}</td>
          <td>${e.fecha}</td>
          <td>${e.artista.nombreArtistico}</td>
          <td>${e.artista.hora}</td>
          <td>${e.sede}</td>
          <td>S/. ${e.precio}</td>
          <td>${e.capacidad}</td>
          <td><span style="background-color: #d4edda; color: #155724; padding: 3px 10px; border-radius: 20px; font-size: 12px;">${e.estado}</span></td>
          <td style="display: flex; gap: 6px;">
            <a href="${pageContext.request.contextPath}/gestioneventos/editar/${e.id}">
              <button class="btn-primario" style="padding: 5px 12px; font-size: 12px;">Editar</button>
            </a>
            <a href="${pageContext.request.contextPath}/gestioneventos/eliminar/${e.id}">
              <button class="btn-secundario" style="padding: 5px 12px; font-size: 12px;">Eliminar</button>
            </a>
          </td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</div>
