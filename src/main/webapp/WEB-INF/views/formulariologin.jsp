<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- FORMULARIO LOGIN -->
<div class="contenedor" style="max-width: 450px; margin-top: 80px;">
  <div class="tarjeta">

    <h2 style="text-align:center; margin-bottom: 25px; color: var(--color-primario);">
      Iniciar Sesión
    </h2>

    <div class="form-grupo">
      <label for="usuario">Usuario</label>
      <input type="text" id="usuario" placeholder="Ingresa tu usuario">
    </div>

    <div class="form-grupo">
      <label for="password">Contraseña</label>
      <input type="password" id="password" placeholder="Ingresa tu contraseña">
    </div>

    <div style="margin-top: 20px;">
      <button class="btn-primario" style="width: 100%;">Ingresar</button>
    </div>

    <p style="text-align:center; margin-top: 15px; font-size: 13px;">
      ¿No tienes cuenta? <a href="#" style="color: var(--color-primario);">Regístrate aquí</a>
    </p>

  </div>
</div>