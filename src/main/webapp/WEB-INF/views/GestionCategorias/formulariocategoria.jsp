<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="formulario" style="display: ${categoriaEditar != null ? 'block' : 'none'};">
  <div class="tarjeta" style="margin-bottom: 25px;">
    <h3 style="margin-bottom: 20px; color: var(--color-primario);">
      <c:choose>
        <c:when test="${categoriaEditar != null}">Editar Categoría</c:when>
        <c:otherwise>Registrar Nueva Categoría</c:otherwise>
      </c:choose>
    </h3>

    <form action="${pageContext.request.contextPath}/${categoriaEditar != null ? 'gestioncategorias/actualizar' : 'gestioncategorias/guardar'}" method="post">

      <c:if test="${categoriaEditar != null}">
        <input type="hidden" name="id" value="${categoriaEditar.id}">
      </c:if>

      <div style="display: flex; gap: 20px; flex-wrap: wrap;">

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Nombre de Categoría</label>
          <input type="text" name="nombre" placeholder="Ej: Concierto" required
                 value="${categoriaEditar != null ? categoriaEditar.nombre : ''}">
        </div>

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Descripción</label>
          <input type="text" name="descripcion" placeholder="Ej: Eventos musicales en vivo" required
                 value="${categoriaEditar != null ? categoriaEditar.descripcion : ''}">
        </div>

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Estado</label>
          <select name="estado">
            <option ${categoriaEditar != null && categoriaEditar.estado == 'Activo' ? 'selected' : ''}>Activo</option>
            <option ${categoriaEditar != null && categoriaEditar.estado == 'Inactivo' ? 'selected' : ''}>Inactivo</option>
          </select>
        </div>

      </div>

      <div style="display: flex; gap: 10px; margin-top: 10px;">
        <button type="submit" class="btn-primario">
          <c:choose>
            <c:when test="${categoriaEditar != null}">Guardar Cambios</c:when>
            <c:otherwise>Guardar</c:otherwise>
          </c:choose>
        </button>
        <a href="${pageContext.request.contextPath}/gestioncategorias">
          <button type="button" class="btn-secundario">Cancelar</button>
        </a>
      </div>

    </form>
  </div>
</div>