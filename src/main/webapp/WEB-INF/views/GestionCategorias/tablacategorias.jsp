<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="tarjeta">
  <table width="100%">
    <thead>
      <tr>
        <th>#</th>
        <th>Nombre</th>
        <th>Descripción</th>
        <th>Estado</th>
        <th>Acciones</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="c" items="${categorias}">
        <tr>
          <td>${c.id}</td>
          <td>${c.nombre}</td>
          <td>${c.descripcion}</td>
          <td><span style="background-color: #d4edda; color: #155724; padding: 3px 10px; border-radius: 20px; font-size: 12px;">${c.estado}</span></td>
          <td>
            <a href="${pageContext.request.contextPath}/gestioncategorias/eliminar/${c.id}">
              <button class="btn-secundario" style="padding: 5px 12px; font-size: 12px;">Eliminar</button>
            </a>
          </td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</div>