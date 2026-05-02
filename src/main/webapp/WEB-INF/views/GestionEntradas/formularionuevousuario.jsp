<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- FORMULARIO NUEVO USUARIO -->
<div id="formulario" style="display: none;">
  <div class="tarjeta" style="margin-bottom: 25px;">
    <h3 style="margin-bottom: 20px; color: var(--color-primario);">Registrar Nuevo Usuario</h3>
    <div style="display: flex; gap: 20px; flex-wrap: wrap;">

      <div class="form-grupo" style="flex: 1; min-width: 200px;">
        <label>Nombre</label>
        <input type="text" placeholder="Ej: Juan">
      </div>

      <div class="form-grupo" style="flex: 1; min-width: 200px;">
        <label>Apellido</label>
        <input type="text" placeholder="Ej: Pérez">
      </div>

      <div class="form-grupo" style="flex: 1; min-width: 200px;">
        <label>DNI</label>
        <input type="text" placeholder="Ej: 12345678">
      </div>

      <div class="form-grupo" style="flex: 1; min-width: 200px;">
        <label>Correo electrónico</label>
        <input type="email" placeholder="Ej: juan@gmail.com">
      </div>

      <div class="form-grupo" style="flex: 1; min-width: 200px;">
        <label>Teléfono</label>
        <input type="text" placeholder="Ej: 987654321">
      </div>

      <div class="form-grupo" style="flex: 1; min-width: 200px;">
        <label>Rol</label>
        <select>
          <option>Cliente</option>
          <option>Administrador</option>
        </select>
      </div>

      <div class="form-grupo" style="flex: 1; min-width: 200px;">
        <label>Contraseña</label>
        <input type="password" placeholder="Ingresa contraseña">
      </div>

      <div class="form-grupo" style="flex: 1; min-width: 200px;">
        <label>Estado</label>
        <select>
          <option>Activo</option>
          <option>Inactivo</option>
        </select>
      </div>

    </div>

    <div style="display: flex; gap: 10px; margin-top: 10px;">
      <button class="btn-primario">Guardar</button>
      <button class="btn-secundario" onclick="ocultarFormulario()">Cancelar</button>
    </div>
  </div>
</div>