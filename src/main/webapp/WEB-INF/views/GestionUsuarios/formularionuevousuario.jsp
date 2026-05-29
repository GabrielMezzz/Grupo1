<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="formulario" style="display: ${usuarioEditar != null ? 'block' : 'none'};">
  <div class="tarjeta" style="margin-bottom: 25px;">
    <h3 style="margin-bottom: 20px; color: var(--color-primario);">
      <c:choose>
        <c:when test="${usuarioEditar != null && usuarioEditar.id != null}">Editar Usuario</c:when>
        <c:otherwise>Registrar Nuevo Usuario</c:otherwise>
      </c:choose>
    </h3>

    <form action="${pageContext.request.contextPath}/${usuarioEditar != null && usuarioEditar.id != null ? 'gestionusuarios/actualizar' : 'gestionusuarios/guardar'}" method="post">

      <c:if test="${usuarioEditar != null && usuarioEditar.id != null}">
        <input type="hidden" name="id" value="${usuarioEditar.id}">
      </c:if>

      <div style="display: flex; gap: 20px; flex-wrap: wrap;">

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Nombre</label>
          <input type="text" name="nombre" placeholder="Ej: Juan"
                 value="${usuarioEditar != null ? usuarioEditar.nombre : ''}"
                 required
                 pattern="[A-Za-zÁÉÍÓÚáéíóúÑñÜü ]+"
                 oninput="capitalizarTexto(this)">
          <c:if test="${not empty errorNombre}">
            <small style="color: #b00020;">${errorNombre}</small>
          </c:if>
        </div>

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Apellido</label>
          <input type="text" name="apellido" placeholder="Ej: Pérez"
                 value="${usuarioEditar != null ? usuarioEditar.apellido : ''}"
                 required
                 pattern="[A-Za-zÁÉÍÓÚáéíóúÑñÜü ]+"
                 oninput="capitalizarTexto(this)">
          <c:if test="${not empty errorApellido}">
            <small style="color: #b00020;">${errorApellido}</small>
          </c:if>
        </div>

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>DNI</label>
          <input type="text" name="dni" placeholder="Ej: 12345678"
                 value="${usuarioEditar != null ? usuarioEditar.dni : ''}"
                 required
                 maxlength="8"
                 inputmode="numeric"
                 pattern="[0-9]{8}"
                 oninput="soloNumeros(this, 8)">
          <c:if test="${not empty errorDni}">
            <small style="color: #b00020;">${errorDni}</small>
          </c:if>
        </div>

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Correo electrónico</label>
          <input type="email" name="correo" placeholder="Ej: juan@gmail.com"
                 value="${usuarioEditar != null ? usuarioEditar.correo : ''}"
                 required>
          <c:if test="${not empty errorCorreo}">
            <small style="color: #b00020;">${errorCorreo}</small>
          </c:if>
        </div>

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Teléfono</label>
          <input type="text" name="telefono" placeholder="Ej: 987654321"
                 value="${usuarioEditar != null ? usuarioEditar.telefonoFormateado : ''}"
                 required
                 maxlength="11"
                 inputmode="numeric"
                 pattern="[0-9]{3} [0-9]{3} [0-9]{3}"
                 oninput="formatearTelefono(this)">
          <c:if test="${not empty errorTelefono}">
            <small style="color: #b00020;">${errorTelefono}</small>
          </c:if>
        </div>

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Rol</label>
          <select name="rol" required>
            <option value="Cliente" ${usuarioEditar != null && usuarioEditar.rol == 'Cliente' ? 'selected' : ''}>Cliente</option>
            <option value="Administrador" ${usuarioEditar != null && usuarioEditar.rol == 'Administrador' ? 'selected' : ''}>Administrador</option>
          </select>
        </div>

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Contraseña</label>
          <input type="password" name="contrasena" placeholder="Ingresa contraseña"
                 value="${usuarioEditar != null ? usuarioEditar.contrasena : ''}"
                 required
                 minlength="8">
          <c:if test="${not empty errorContrasena}">
            <small style="color: #b00020;">${errorContrasena}</small>
          </c:if>
        </div>

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Estado</label>
          <select name="estado" required>
            <option value="Activo" ${usuarioEditar != null && usuarioEditar.estado == 'Activo' ? 'selected' : ''}>Activo</option>
            <option value="Inactivo" ${usuarioEditar != null && usuarioEditar.estado == 'Inactivo' ? 'selected' : ''}>Inactivo</option>
          </select>
        </div>

      </div>

      <div style="display: flex; gap: 10px; margin-top: 10px;">
        <button type="submit" class="btn-primario">
          <c:choose>
            <c:when test="${usuarioEditar != null && usuarioEditar.id != null}">Guardar Cambios</c:when>
            <c:otherwise>Guardar</c:otherwise>
          </c:choose>
        </button>
        <a href="${pageContext.request.contextPath}/gestionusuarios">
          <button type="button" class="btn-secundario">Cancelar</button>
        </a>
      </div>

    </form>
  </div>
</div>
