<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="formulario" style="display: none;">
  <div class="tarjeta" style="margin-bottom: 25px;">
    <h3 style="margin-bottom: 20px; color: var(--color-primario);">Registrar Nueva Categoría</h3>
    <form action="${pageContext.request.contextPath}/gestioncategorias/guardar" method="post">
      <div style="display: flex; gap: 20px; flex-wrap: wrap;">

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Nombre de Categoría</label>
          <input type="text" name="nombre" placeholder="Ej: Concierto">
        </div>

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Descripción</label>
          <input type="text" name="descripcion" placeholder="Ej: Eventos musicales en vivo">
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