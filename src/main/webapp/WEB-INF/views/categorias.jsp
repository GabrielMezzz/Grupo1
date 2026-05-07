<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="contenedor">
  <h2 style="text-align: center; margin-bottom: 30px;">Categorías de Eventos</h2>
  <div style="display: flex; gap: 20px; flex-wrap: wrap; justify-content: center;">
    <c:forEach var="cat" items="${categorias}">
      <div class="tarjeta" style="width: 1400px; display: flex; align-items: center; gap: 20px; padding: 20px;">
        <div style="flex: 1; text-align: left;">
          <h2 style="margin: 0; font-size: 28px;">${cat.nombre}</h2>
          <p style="margin-top: 10px; color: #666; font-size: 16px; text-align: justify; line-height: 1.6;">
            ${cat.descripcion}
          </p>
        </div>
      </div>
    </c:forEach>
  </div>
</div>