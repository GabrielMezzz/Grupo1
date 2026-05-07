<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="contenedor">
  <h3 style="margin-bottom: 20px;">Próximos Eventos</h3>
  <div style="display: flex; gap: 20px; flex-wrap: wrap;">

    <c:forEach var="evento" items="${eventos}">
      <div style="display: flex; justify-content: center;">
        <div class="tarjeta" style="width: 370px; background: var(--color-fondo); border-radius: 10px;
             overflow: hidden; box-shadow: 0 4px 10px rgba(0,0,0,0.1); font-family: Arial, sans-serif;">

          <div style="padding: 15px;">
            <h3 style="margin: 0;">${evento.nombre}</h3>
            <p style="color: #777; font-size: 13px; margin-top: 8px;">FECHA: ${evento.fecha}</p>
            <p style="color: #777; font-size: 13px;">LUGAR: ${evento.sede}</p>
            <p style="color: #777; font-size: 13px;">ARTISTA: ${evento.artista}</p>

            <div style="display: flex; justify-content: space-between; align-items: center; margin-top: 15px;">
              <span style="color: var(--color-primario); font-weight: bold; font-size: 18px;">S/. ${evento.precio}</span>
              <a href="${pageContext.request.contextPath}/entradas/comprar/${evento.id}">
                <button class="btn-primario">Comprar</button>
              </a>
            </div>
          </div>

        </div>
      </div>
    </c:forEach>

  </div>
</div>