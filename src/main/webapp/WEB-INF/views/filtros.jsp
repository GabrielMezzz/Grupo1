<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="tarjeta" style="margin-bottom: 30px;">
  <div style="display: flex; gap: 15px; flex-wrap: wrap; align-items: flex-end;">

    <div class="form-grupo" style="flex: 1; min-width: 180px; margin-bottom: 0;">
      <label>Categoría</label>
      <select>
        <option>Todas las categorías</option>
        <c:forEach var="cat" items="${categorias}">
          <option>${cat.nombre}</option>
        </c:forEach>
      </select>
    </div>

    <div class="form-grupo" style="flex: 1; min-width: 180px; margin-bottom: 0;">
      <label>Sede</label>
      <select>
        <option>Todas las sedes</option>
        <c:forEach var="s" items="${sedes}">
          <option>${s.nombre}</option>
        </c:forEach>
      </select>
    </div>

    <div class="form-grupo" style="flex: 1; min-width: 180px; margin-bottom: 0;">
      <label>Fecha</label>
      <input type="date">
    </div>

    <button class="btn-primario">Buscar</button>
  </div>
</div>