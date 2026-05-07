<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="formulario" style="display: none;">
  <div class="tarjeta" style="margin-bottom: 25px;">
    <h3 style="margin-bottom: 20px; color: var(--color-primario);">Registrar Nueva Sede</h3>
    <form action="${pageContext.request.contextPath}/gestionsedes/guardar" method="post">
      <div style="display: flex; gap: 20px; flex-wrap: wrap;">

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Nombre de la Sede</label>
          <input type="text" name="nombre" placeholder="Ej: Estadio Nacional">
        </div>

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Dirección</label>
          <input type="text" name="direccion" placeholder="Ej: Av. José Díaz s/n">
        </div>

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Ciudad</label>
          <input type="text" name="ciudad" placeholder="Ej: Lima">
        </div>

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Capacidad</label>
          <input type="number" name="capacidad" placeholder="Ej: 5000">
        </div>

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Teléfono</label>
          <input type="text" name="telefono" placeholder="Ej: (01) 123-4567">
        </div>

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Tipo</label>
          <select name="tipo">
            <option>Estadio</option>
            <option>Teatro</option>
            <option>Auditorio</option>
            <option>Centro de Convenciones</option>
            <option>Parque</option>
          </select>
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