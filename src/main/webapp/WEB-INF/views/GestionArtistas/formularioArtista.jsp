<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="formulario" style="display: ${artistaEditar != null ? 'block' : 'none'};">
  <div class="tarjeta" style="margin-bottom: 25px;">
    <h3 style="margin-bottom: 20px; color: var(--color-primario);">
      <c:choose>
        <c:when test="${artistaEditar != null}">Editar Artista</c:when>
        <c:otherwise>Registrar Nuevo Artista</c:otherwise>
      </c:choose>
    </h3>

    <form action="${pageContext.request.contextPath}/${artistaEditar != null ? 'gestionartistas/actualizar' : 'gestionartistas/guardar'}" method="post">

      <c:if test="${artistaEditar != null}">
        <input type="hidden" name="id" value="${artistaEditar.id}">
      </c:if>

      <div style="display: flex; gap: 20px; flex-wrap: wrap;">

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Nombre Artístico / Banda</label>
          <input type="text" name="nombreArtistico" placeholder="Ej: Banda Rockera" required
                 value="${artistaEditar != null ? artistaEditar.nombreArtistico : ''}">
        </div>

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Genero / Tipo</label>
          <select name="genero">
            <c:forEach var="g" items="${['Rock','Pop','Teatro','Comedia','Clasica','Urbano']}">
              <option ${artistaEditar != null && artistaEditar.genero == g ? 'selected' : ''}>${g}</option>
            </c:forEach>
          </select>
        </div>

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Nacionalidad</label>
          <input type="text" name="nacionalidad" placeholder="Ej: Peruana" required
                 value="${artistaEditar != null ? artistaEditar.nacionalidad : ''}">
        </div>

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Correo de Contacto</label>
          <input type="email" name="correo" placeholder="Ej: artista@gmail.com" required
                 value="${artistaEditar != null ? artistaEditar.correo : ''}">
        </div>

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Telefono / Manager</label>
          <input type="text" name="telefono" placeholder="Ej: 987654321" required
                 value="${artistaEditar != null ? artistaEditar.telefono : ''}">
        </div>

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Hora</label>
          <input type="time" name="hora" required
                 value="${artistaEditar != null ? artistaEditar.hora : ''}">
        </div>

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Estado</label>
          <select name="estado">
            <option ${artistaEditar != null && artistaEditar.estado == 'Activo' ? 'selected' : ''}>Activo</option>
            <option ${artistaEditar != null && artistaEditar.estado == 'Inactivo' ? 'selected' : ''}>Inactivo</option>
          </select>
        </div>

      </div>

      <div style="display: flex; gap: 10px; margin-top: 10px;">
        <button type="submit" class="btn-primario">
          <c:choose>
            <c:when test="${artistaEditar != null}">Guardar Cambios</c:when>
            <c:otherwise>Guardar</c:otherwise>
          </c:choose>
        </button>
        <a href="${pageContext.request.contextPath}/gestionartistas">
          <button type="button" class="btn-secundario">Cancelar</button>
        </a>
      </div>

    </form>
  </div>
</div>
