<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="formulario" style="display: none;">
  <div class="tarjeta" style="margin-bottom: 25px;">
    <h3 style="margin-bottom: 20px; color: var(--color-primario);">Registrar Nuevo Artista</h3>
    <form action="${pageContext.request.contextPath}/gestionartistas/guardar" method="post">
      <div style="display: flex; gap: 20px; flex-wrap: wrap;">

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Nombre Artístico / Banda</label>
          <input type="text" name="nombreArtistico" placeholder="Ej: Banda Rockera">
        </div>

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Género / Tipo</label>
          <select name="genero">
            <option>Rock</option>
            <option>Pop</option>
            <option>Teatro</option>
            <option>Comedia</option>
            <option>Clásica</option>
            <option>Urbano</option>
          </select>
        </div>

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Nacionalidad</label>
          <input type="text" name="nacionalidad" placeholder="Ej: Peruana">
        </div>

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Correo de Contacto</label>
          <input type="email" name="correo" placeholder="Ej: artista@gmail.com">
        </div>

        <div class="form-grupo" style="flex: 1; min-width: 200px;">
          <label>Teléfono / Manager</label>
          <input type="text" name="telefono" placeholder="Ej: 987654321">
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