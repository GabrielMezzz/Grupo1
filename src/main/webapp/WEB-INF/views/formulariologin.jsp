<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <div class="login-card">
    <h3 class="login-titulo">Iniciar Sesión</h3>

    <c:if test="${not empty error}">
      <p style="color: red; text-align: center; margin-bottom: 15px;">
        <i class="fa-solid fa-circle-exclamation"></i> ${error}
      </p>
    </c:if>

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

    <p class="registro-link">
      ¿No tienes cuenta?
      <a href="${pageContext.request.contextPath}/registro">Regístrate aquí</a>
    </p>

  </div>