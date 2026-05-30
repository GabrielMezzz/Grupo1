<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- TABLA ENTRADAS -->
<div class="tarjeta">
  <table width="100%">
    <thead>
      <tr>
        <th>#</th>
        <th>Nombre</th>
        <th>DNI</th>
        <th>Evento</th>
        <th>Precio</th>
        <th>Fecha de Compra</th>
        <th>Estado</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="e" items="${entradas}">
        <tr>
          <td>${e.id}</td>
          <td>${e.nombre}</td>
          <td>${e.dni}</td>
          <td>${e.evento}</td>
          <td>S/. ${e.precio}</td>
          <td>${e.fechaCompra}</td>
          <td><span style="background-color: #d4edda; color: #155724; padding: 3px 10px; border-radius: 20px; font-size: 12px;">${e.estado}</span></td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</div>
