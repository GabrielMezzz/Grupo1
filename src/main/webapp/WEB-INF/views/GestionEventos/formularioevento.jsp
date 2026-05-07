<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="formulario" style="display: none;">
  <div class="tarjeta" style="margin-bottom: 25px;">
    <h3 style="margin-bottom: 20px; color: var(--color-primario);">Registrar Nuevo Evento</h3>
    <form action="${pageContext.request.contextPath}/gestioneventos/guardar" method="post">
      <div style="display: flex; gap: 20px; flex-wrap: wrap;">

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Nombre del Evento</label>
          <input type="text" name="nombre" placeholder="Ej: Gran Concierto Rock">
        </div>

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Categoría</label>
          <select name="categoria">
            <option>Seleccionar...</option>
            <c:forEach var="cat" items="${categorias}">
              <option>${cat.nombre}</option>
            </c:forEach>
          </select>
        </div>

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Fecha</label>
          <input type="date" name="fecha">
        </div>

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Sede</label>
          <select name="sede">
            <option>Seleccionar...</option>
            <c:forEach var="s" items="${sedes}">
              <option>${s.nombre}</option>
            </c:forEach>
          </select>
        </div>

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Precio (S/.)</label>
          <input type="number" name="precio" placeholder="Ej: 150">
        </div>

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Capacidad</label>
          <input type="number" name="capacidad" placeholder="Ej: 500">
        </div>

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Artista / Compañía</label>
          <select name="artista">
            <option>Seleccionar...</option>
            <c:forEach var="a" items="${artistas}">
              <option>${a.nombreArtistico}</option>
            </c:forEach>
          </select>
        </div>

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Estado</label>
          <select name="estado">
            <option>Activo</option>
            <option>Inactivo</option>
            <option>Cancelado</option>
          </select>
        </div>

      </div>
      <div style="display: flex; gap: 10px; margin-top: 10px;">
        <button type="submit" class="btn-primario">Guardar Evento</button>
        <button type="button" class="btn-secundario" onclick="ocultarFormulario()">Cancelar</button>
      </div>
    </form>
  </div>
</div>