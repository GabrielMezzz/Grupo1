<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- TABLA USUARIOS -->
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
      <tr>
        <td>1</td>
        <td>Juan Pérez</td>
        <td>12345678</td>
        <td>juan@gmail.com</td>
        <td>987654321</td>
        <td><span style="background-color: #cce5ff; color: #004085; padding: 3px 10px; border-radius: 20px; font-size: 12px;">Cliente</span></td>
        <td><span style="background-color: #d4edda; color: #155724; padding: 3px 10px; border-radius: 20px; font-size: 12px;">Activo</span></td>
        <td>
          <button class="btn-primario" style="padding: 5px 12px; font-size: 12px;">Editar</button>
          <button class="btn-secundario" style="padding: 5px 12px; font-size: 12px; margin-left: 5px;">Eliminar</button>
        </td>
      </tr>
    </tbody>
  </table>
</div>