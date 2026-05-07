<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="contenedor" style="max-width: 450px; margin-top: 80px;">
  <div class="tarjeta">

    <h2 style="text-align:center; margin-bottom: 25px; color: var(--color-primario);">
      Iniciar Sesión
    </h2>

    <c:if test="${not empty error}">
      <p style="color: red; text-align: center; margin-bottom: 15px;">${error}</p>
    </c:if>

    <form action="${pageContext.request.contextPath}/login" method="post">
      <div class="form-grupo">
        <label for="correo">Correo</label>
        <input type="email" id="correo" name="correo" placeholder="admin@gmail.com">
      </div>

      <div class="form-grupo">
        <label for="contrasena">Contraseña</label>
        <input type="password" id="contrasena" name="contrasena" placeholder="Ingresa tu contraseña">
      </div>

      <div style="margin-top: 20px;">
        <button type="submit" class="btn-primario" style="width: 100%;">Ingresar</button>
      </div>
    </form>

  </div>
</div>