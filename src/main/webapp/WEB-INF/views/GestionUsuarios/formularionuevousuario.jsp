<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="formulario" style="display: none;">
  <div class="tarjeta" style="margin-bottom: 25px;">
    <h3 style="margin-bottom: 20px; color: var(--color-primario);">Registrar Nuevo Usuario</h3>
    <form action="${pageContext.request.contextPath}/gestionusuarios/guardar" method="post">
      <div style="display: flex; gap: 20px; flex-wrap: wrap;">

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Nombre</label>
          <input type="text" name="nombre" placeholder="Ej: Juan">
        </div>

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Apellido</label>
          <input type="text" name="apellido" placeholder="Ej: Pérez">
        </div>

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>DNI</label>
          <input type="text" name="dni" placeholder="Ej: 12345678">
        </div>

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Correo electrónico</label>
          <input type="email" name="correo" placeholder="Ej: juan@gmail.com">
        </div>

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Teléfono</label>
          <input type="text" name="telefono" placeholder="Ej: 987654321">
        </div>

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Rol</label>
          <select name="rol">
            <option>Cliente</option>
            <option>Administrador</option>
          </select>
        </div>

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Contraseña</label>
          <input type="password" name="contrasena" placeholder="Ingresa contraseña">
        </div>

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Estado</label>
          <select name="estado">
            <option>Activo</option>
            <option>Inactivo</option>
          </select>
        </div>

      </div>
      <div style="display: flex; gap: 10px; margin-top: 10px;">
        <button type="submit" class="btn-primario">Guardar</button>
        <button type="button" class="btn-secundario" onclick="ocultarFormulario()">Cancelar</button>
      </div>
    </form>
  </div>
</div>