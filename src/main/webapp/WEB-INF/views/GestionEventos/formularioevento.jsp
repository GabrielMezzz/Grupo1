<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- FORMULARIO NUEVO EVENTO -->
<div id="formulario" style="display: none;">
  <div class="tarjeta" style="margin-bottom: 25px;">
    <h3 style="margin-bottom: 20px; color: var(--color-primario);">Registrar Nuevo Evento</h3>
    <div style="display: flex; gap: 20px; flex-wrap: wrap;">

      <div class="form-grupo" style="flex: 1; min-width: 200px;">
        <label>Nombre del Evento</label>
        <input type="text" placeholder="Ej: Gran Concierto Rock">
      </div>

      <div class="form-grupo" style="flex: 1; min-width: 200px;">
        <label>Categoría</label>
        <select>
          <option>Seleccionar...</option>
          <option>Concierto</option>
          <option>Teatro</option>
          <option>Unipersonal</option>
          <option>Espectáculo</option>
        </select>
      </div>

      <div class="form-grupo" style="flex: 1; min-width: 200px;">
        <label>Fecha</label>
        <input type="date">
      </div>

      <div class="form-grupo" style="flex: 1; min-width: 200px;">
        <label>Sede</label>
        <input type="text" placeholder="Ej: Estadio Nacional">
      </div>

      <div class="form-grupo" style="flex: 1; min-width: 200px;">
        <label>Precio (S/.)</label>
        <input type="number" placeholder="Ej: 150">
      </div>

      <div class="form-grupo" style="flex: 1; min-width: 200px;">
        <label>Capacidad</label>
        <input type="number" placeholder="Ej: 500">
      </div>

      <div class="form-grupo" style="flex: 1; min-width: 200px;">
        <label>Artista / Compañía</label>
        <input type="text" placeholder="Ej: Banda Rockera">
      </div>

      <div class="form-grupo" style="flex: 1; min-width: 200px;">
        <label>Estado</label>
        <select>
          <option>Activo</option>
          <option>Inactivo</option>
          <option>Cancelado</option>
        </select>
      </div>

    </div>

    <div style="display: flex; gap: 10px; margin-top: 10px;">
      <button class="btn-primario">Guardar Evento</button>
      <button class="btn-secundario" onclick="ocultarFormulario()">Cancelar</button>
    </div>
  </div>
</div>