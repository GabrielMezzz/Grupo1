<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="contenedor">
  <section class="eventos-seccion">
    <h3 class="seccion-titulo">Próximos Eventos</h3>

    <div class="eventos-grid">
      <c:forEach var="evento" items="${eventos}">
        <article class="evento-card">
          <div class="evento-contenido">
            <h4 class="evento-nombre">${evento.nombre}</h4>

            <div class="evento-detalles">
              <p><i class="fa-solid fa-calendar-days"></i> FECHA: ${evento.fecha}</p>
              <p><i class="fa-solid fa-location-dot"></i> LUGAR: ${evento.sede}</p>
              <p><i class="fa-solid fa-microphone"></i> ARTISTA: ${evento.artista}</p>
            </div>

            <div class="evento-footer">
              <span class="evento-precio">S/. ${evento.precio}</span>
              <a href="${pageContext.request.contextPath}/entradas/comprar/${evento.id}" class="btn-comprar-link">
                <button class="btn-primario">Comprar</button>
              </a>
            </div>
          </div>
        </article>
      </c:forEach>
    </div>
  </section>
</div>