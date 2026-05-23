<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="formulario" style="display: ${eventoEditar != null ? 'block' : 'none'};">
  <div class="tarjeta" style="margin-bottom: 25px;">
    <h3 style="margin-bottom: 20px; color: var(--color-primario);">
      <c:choose>
        <c:when test="${eventoEditar != null}">Editar Evento</c:when>
        <c:otherwise>Registrar Nuevo Evento</c:otherwise>
      </c:choose>
    </h3>

    <form action="${pageContext.request.contextPath}/${eventoEditar != null ? 'gestioneventos/actualizar' : 'gestioneventos/guardar'}" method="post">

      <c:if test="${eventoEditar != null}">
        <input type="hidden" name="id" value="${eventoEditar.id}">
      </c:if>

      <div style="display: flex; gap: 20px; flex-wrap: wrap;">

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Nombre del Evento</label>
          <input type="text" name="nombre" placeholder="Ej: Gran Concierto Rock" required
                 value="${eventoEditar != null ? eventoEditar.nombre : ''}">
        </div>

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Categoría</label>
          <select name="categoria">
            <option>Seleccionar...</option>
            <c:forEach var="cat" items="${categorias}">
              <option ${eventoEditar != null && eventoEditar.categoria == cat.nombre ? 'selected' : ''}>${cat.nombre}</option>
            </c:forEach>
          </select>
        </div>

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Fecha</label>
          <input type="date" name="fecha" required
                 value="${eventoEditar != null ? eventoEditar.fecha : ''}">
        </div>

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Sede</label>
          <select name="sede" id="selectSede" onchange="cargarCapacidad(this)">
            <option value="">Seleccionar...</option>
            <c:forEach var="s" items="${sedes}">
              <option data-capacidad="${s.capacidad}"
                ${eventoEditar != null && eventoEditar.sede == s.nombre ? 'selected' : ''}>
                ${s.nombre}
              </option>
            </c:forEach>
          </select>
        </div>

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Precio (S/.)</label>
          <input type="number" name="precio" placeholder="Ej: 150" required
                 value="${eventoEditar != null ? eventoEditar.precio : ''}">
        </div>

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Capacidad</label>
          <input type="number" name="capacidad" id="inputCapacidad" placeholder="Se carga al elegir sede"
                 value="${eventoEditar != null ? eventoEditar.capacidad : ''}" readonly>
        </div>

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Artista / Compañía</label>
          <select name="artista">
            <option>Seleccionar...</option>
            <c:forEach var="a" items="${artistas}">
              <option ${eventoEditar != null && eventoEditar.artista == a.nombreArtistico ? 'selected' : ''}>${a.nombreArtistico}</option>
            </c:forEach>
          </select>
        </div>

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Estado</label>
          <select name="estado">
            <option ${eventoEditar != null && eventoEditar.estado == 'Activo' ? 'selected' : ''}>Activo</option>
            <option ${eventoEditar != null && eventoEditar.estado == 'Inactivo' ? 'selected' : ''}>Inactivo</option>
            <option ${eventoEditar != null && eventoEditar.estado == 'Cancelado' ? 'selected' : ''}>Cancelado</option>
          </select>
        </div>

      </div>

      <div style="display: flex; gap: 10px; margin-top: 10px;">
        <button type="submit" class="btn-primario">
          <c:choose>
            <c:when test="${eventoEditar != null}">Guardar Cambios</c:when>
            <c:otherwise>Guardar Evento</c:otherwise>
          </c:choose>
        </button>
        <a href="${pageContext.request.contextPath}/gestioneventos">
          <button type="button" class="btn-secundario">Cancelar</button>
        </a>
      </div>

    </form>
  </div>
</div>

<script>
function cargarCapacidad(select) {
    const opcion = select.options[select.selectedIndex];
    document.getElementById('inputCapacidad').value = opcion.getAttribute('data-capacidad') || '';
}
</script>