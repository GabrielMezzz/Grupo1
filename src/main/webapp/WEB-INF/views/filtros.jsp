<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="tarjeta" style="margin-bottom: 30px;">
  <div style="display: flex; gap: 15px; flex-wrap: wrap; align-items: flex-end;">

    <div class="form-grupo" style="flex: 1; min-width: 180px; margin-bottom: 0;">
      <label>Categoría</label>
      <select>
        <option>Todas las categorías</option>
        <option>Conciertos</option>
        <option>Teatro</option>
        <option>Unipersonales</option>
        <option>Espectáculos</option>
      </select>
    </div>

    <div class="form-grupo" style="flex: 1; min-width: 180px; margin-bottom: 0;">
      <label>Ciudad</label>
      <select>
        <option>Todas las ciudades</option>
        <option>Lima</option>
        <option>Arequipa</option>
        <option>Trujillo</option>
        <option>Cusco</option>
      </select>
    </div>

    <div class="form-grupo" style="flex: 1; min-width: 180px; margin-bottom: 0;">
      <label>Fecha</label>
      <input type="date">
    </div>

    <button class="btn-primario">Buscar</button>

  </div>
</div>