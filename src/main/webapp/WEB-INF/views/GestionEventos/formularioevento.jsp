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
          <label>Categoria</label>
          <select name="categoria" required>
            <option value="">Seleccionar...</option>
            <c:forEach var="cat" items="${categorias}">
              <option value="${cat.nombre}" ${eventoEditar != null && eventoEditar.categoria == cat.nombre ? 'selected' : ''}>${cat.nombre}</option>
            </c:forEach>
          </select>
        </div>

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Fecha</label>
          <input type="date" name="fecha" required
                 value="${eventoEditar != null ? eventoEditar.fecha : ''}">
        </div>

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Lugar</label>
          <input type="text" name="sede" placeholder="Ej: Estadio Nacional" required
                 value="${eventoEditar != null ? eventoEditar.sede : ''}">
        </div>

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Precio (S/.)</label>
          <input type="number" name="precio" placeholder="Ej: 150" required
                 value="${eventoEditar != null ? eventoEditar.precio : ''}">
        </div>

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Capacidad</label>
          <input type="number" name="capacidad" placeholder="Ej: 500" required
                 value="${eventoEditar != null ? eventoEditar.capacidad : ''}">
        </div>

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Artista</label>
          <select name="artistaId" required>
            <option value="">Seleccionar...</option>
            <c:forEach var="a" items="${artistas}">
              <option value="${a.id}"
                ${eventoEditar != null && eventoEditar.artista != null && eventoEditar.artista.id == a.id ? 'selected' : ''}>
                ${a.nombreArtistico} - ${a.hora}
              </option>
            </c:forEach>
          </select>
        </div>

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Estado</label>
          <select name="estado" required>
            <option value="Activo" ${eventoEditar != null && eventoEditar.estado == 'Activo' ? 'selected' : ''}>Activo</option>
            <option value="Inactivo" ${eventoEditar != null && eventoEditar.estado == 'Inactivo' ? 'selected' : ''}>Inactivo</option>
            <option value="Cancelado" ${eventoEditar != null && eventoEditar.estado == 'Cancelado' ? 'selected' : ''}>Cancelado</option>
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
