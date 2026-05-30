<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div style="display: flex; gap: 20px; flex-wrap: wrap;">
  <c:forEach var="a" items="${artistas}">
    <div class="tarjeta" style="width: 220px; text-align: center;">
      <div style="width: 80px; height: 80px; border-radius: 50%; background-color: var(--color-primario);
           margin: 0 auto; display: flex; align-items: center; justify-content: center;">
        <i class="fa-solid fa-music" style="font-size: 36px; color: white;"></i>
      </div>
      <h3 style="margin-top: 15px;">${a.nombreArtistico}</h3>
      <p style="font-size: 13px; color: #777; margin-top: 5px;">${a.genero}</p>
      <p style="font-size: 13px; color: #777;">${a.nacionalidad}</p>
      <p style="font-size: 13px; color: #777;">${a.correo}</p>
      <p style="font-size: 13px; color: #777;">Hora: ${a.hora}</p>
      <span style="background-color: #d4edda; color: #155724; padding: 3px 10px; border-radius: 20px; font-size: 12px; display: inline-block; margin-top: 8px;">${a.estado}</span>
      <div style="display: flex; gap: 8px; margin-top: 15px;">
        <a href="${pageContext.request.contextPath}/gestionartistas/editar/${a.id}" style="flex: 1;">
          <button class="btn-primario" style="width: 100%; padding: 6px; font-size: 12px;">Editar</button>
        </a>
        <a href="${pageContext.request.contextPath}/gestionartistas/eliminar/${a.id}" style="flex: 1;">
          <button class="btn-secundario" style="width: 100%; padding: 6px; font-size: 12px;">Eliminar</button>
        </a>
      </div>
    </div>
  </c:forEach>
</div>
