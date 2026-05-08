<%@ page contentType="text/html;charset=UTF-8" language="java" %>

  <div class="login-card">
    <h3 class="login-titulo">Iniciar Sesión</h3>

    <form action="${pageContext.request.contextPath}/login" method="POST">
      <div class="campo-grupo">
        <label for="email">Correo Electrónico</label>
        <input type="email" id="email" name="correo" placeholder="ejemplo@correo.com" required>
      </div>

      <div class="campo-grupo">
        <label for="password">Contraseña</label>
        <input type="password" id="password" name="contrasena" placeholder="••••••••" required>
      </div>

      <button type="submit" class="btn-login">
        <i class="fa-solid fa-right-to-bracket"></i> Ingresar
      </button>
    </form>

  </div>