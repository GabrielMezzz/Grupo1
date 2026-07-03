<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="formulario" style="display: ${sede != null ? 'block' : 'none'};">
  <div class="tarjeta" style="margin-bottom: 25px;">
    <h3 style="margin-bottom: 20px; color: var(--color-primario);">
      <c:choose>
        <c:when test="${sede != null}">Editar Sede</c:when>
        <c:otherwise>Registrar Nueva Sede</c:otherwise>
      </c:choose>
    </h3>

    <form action="${pageContext.request.contextPath}/${sede != null ? 'gestionsedes/actualizar' : 'gestionsedes/guardar'}" method="post">

      <c:if test="${sede != null}">
        <input type="hidden" name="id" value="${sede.id}">
      </c:if>

      <div style="display: flex; gap: 20px; flex-wrap: wrap;">

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Nombre de la Sede</label>
          <input type="text" name="nombreSede" placeholder="Ej: Estadio Nacional" required
                 value="${sede != null ? sede.nombreSede : ''}">
        </div>

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Dirección</label>
          <input type="text" name="direccionSede" placeholder="Ej: Av. José Díaz s/n" required
                 value="${sede != null ? sede.direccionSede : ''}">
        </div>

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Ciudad</label>
          <input type="text" name="ciudadSede" placeholder="Ej: Lima" required
                 value="${sede != null ? sede.ciudadSede : ''}">
        </div>

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Capacidad</label>
          <input type="number" name="capacidadSede" placeholder="Ej: 5000" required
                 value="${sede != null ? sede.capacidadSede : ''}">
        </div>

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Nombre del Artista</label>
          <input type="text" name="nombreArtista" placeholder="Ej: Banda Rockera" required
                 value="${sede != null ? sede.nombreArtista : ''}">
        </div>

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Género / Tipo</label>
          <select name="genero">
            <c:forEach var="g" items="${['Rock','Pop','Teatro','Comedia','Clásica','Urbano','Espectaculo']}">
              <option ${sede != null && sede.genero == g ? 'selected' : ''}>${g}</option>
            </c:forEach>
          </select>
        </div>

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Correo de Contacto</label>
          <input type="email" name="correo" placeholder="Ej: artista@gmail.com" required
                 value="${sede != null ? sede.correo : ''}">
        </div>

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Teléfono</label>
          <input type="text" name="telefono" placeholder="Ej: 987654321" required
                 value="${sede != null ? sede.telefono : ''}">
        </div>

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Estado</label>
          <select name="estado">
            <option ${sede != null && sede.estado == 'Activo' ? 'selected' : ''}>Activo</option>
            <option ${sede != null && sede.estado == 'Inactivo' ? 'selected' : ''}>Inactivo</option>
          </select>
        </div>

      </div>

      <div style="display: flex; gap: 10px; margin-top: 10px;">
        <button type="submit" class="btn-primario">
          <c:choose>
            <c:when test="${sede != null}">Guardar Cambios</c:when>
            <c:otherwise>Guardar</c:otherwise>
          </c:choose>
        </button>
        <a href="${pageContext.request.contextPath}/gestionsedes">
          <button type="button" class="btn-secundario">Cancelar</button>
        </a>
      </div>

    </form>
  </div>
</div>