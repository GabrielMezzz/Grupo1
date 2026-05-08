<%@ page contentType="text/html;charset=UTF-8" language="java" %>

  <div class="tarjeta" style="flex: 1; min-width: 280px;">
    <h3 style="margin-bottom: 20px; color: var(--color-primario);">Envíanos un mensaje</h3>

    <div class="form-grupo">
      <label>Nombre completo</label>
      <input type="text" placeholder="Ej: Juan Pérez">
    </div>

    <div class="form-grupo">
      <label>Correo electrónico</label>
      <input type="email" placeholder="Ej: juan@gmail.com">
    </div>

    <div class="form-grupo">
      <label>Asunto</label>
      <input type="text" placeholder="¿En qué te podemos ayudar?">
    </div>

    <div class="form-grupo">
      <label>Mensaje</label>
      <textarea rows="5" placeholder="Escribe tu mensaje aquí..."></textarea>
    </div>

    <button class="btn-primario" style="width: 100%;">Enviar Mensaje</button>
  </div>