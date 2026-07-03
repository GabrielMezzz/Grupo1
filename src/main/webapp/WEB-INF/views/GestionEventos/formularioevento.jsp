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
          <label>Sede - Artista</label>
          <select name="sede" id="selectSede" onchange="autocompletar()">
            <option value="">Seleccionar...</option>
            <c:forEach var="s" items="${sedes}">
              <option value="${s.nombreSede}"
                      data-capacidad="${s.capacidadSede}"
                      data-artista="${s.nombreArtista}"
                ${eventoEditar != null && eventoEditar.sede == s.nombreSede ? 'selected' : ''}>
                ${s.nombreSede} — ${s.nombreArtista}
              </option>
            </c:forEach>
          </select>
        </div>

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Artista</label>
          <input type="text" name="artista" id="artista"
                 value="${eventoEditar != null ? eventoEditar.artista : ''}"
                 readonly style="background-color: #e9ecef; cursor: not-allowed; color: #495057;">
        </div>

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Fecha</label>
          <input type="date" name="fecha" id="fecha" required
                 value="${eventoEditar != null ? eventoEditar.fecha : ''}">
        </div>

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Hora</label>
          <input type="time" name="hora" id="hora" required
                 value="${eventoEditar != null ? eventoEditar.hora : ''}">
        </div>

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Precio (S/.)</label>
          <input type="number" name="precio" placeholder="Ej: 150" required min="1"
                 value="${eventoEditar != null ? eventoEditar.precio : ''}">
        </div>

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Capacidad</label>
          <input type="text" name="capacidad" id="capacidad"
                 value="${eventoEditar != null ? eventoEditar.capacidad : ''}"
                 readonly style="background-color: #e9ecef; cursor: not-allowed; color: #495057;">
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
function autocompletar() {
    const select = document.getElementById('selectSede');
    const opcion = select.options[select.selectedIndex];
    document.getElementById('artista').value = opcion.getAttribute('data-artista') || '';
    document.getElementById('capacidad').value = opcion.getAttribute('data-capacidad') || '';
}
</script>