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
              <p><i class="fa-solid fa-clock"></i> HORA: ${evento.hora}</p>
              <p><i class="fa-solid fa-location-dot"></i> LUGAR: ${evento.sede}</p>
              <p><i class="fa-solid fa-microphone"></i> ARTISTA: ${evento.artista}</p>
              <p>
                <i class="fa-solid fa-ticket"></i> DISPONIBLES:
                <c:choose>
                  <c:when test="${evento.capacidad == 0}">
                    <span style="color: #dc3545; font-weight: bold;">Agotado</span>
                  </c:when>
                  <c:otherwise>
                    <span style="color: #28a745; font-weight: bold;">${evento.capacidad}</span>
                  </c:otherwise>
                </c:choose>
              </p>
            </div>

            <div class="cantidad-wrapper">
              <span class="cantidad-label">Cantidad:</span>
              <button type="button" class="cantidad-btn" onclick="decrementar('cant_${evento.id}')">−</button>
              <input type="number" id="cant_${evento.id}" class="cantidad-input" value="1" min="1" max="10">
              <button type="button" class="cantidad-btn" onclick="incrementar('cant_${evento.id}')">+</button>
            </div>

            <div class="evento-footer">
              <span class="evento-precio">S/. ${evento.precio}</span>
              <c:choose>
                <c:when test="${evento.capacidad == 0}">
                  <button class="btn-primario" disabled
                          style="opacity: 0.5; cursor: not-allowed;">Agotado</button>
                </c:when>
                <c:otherwise>
                  <a href="${pageContext.request.contextPath}/entradas/comprar/${evento.id}?cantidad=1"
                     id="link_${evento.id}"
                     class="btn-comprar-link"
                     onclick="actualizarLink('${evento.id}', '${pageContext.request.contextPath}')">
                    <button class="btn-primario">Comprar</button>
                  </a>
                </c:otherwise>
              </c:choose>
            </div>
          </div>
        </article>
      </c:forEach>
    </div>
  </section>
</div>

<script>
  function decrementar(id) {
    var input = document.getElementById(id);
    if (parseInt(input.value) > 1) input.value = parseInt(input.value) - 1;
  }
  function incrementar(id) {
    var input = document.getElementById(id);
    if (parseInt(input.value) < 10) input.value = parseInt(input.value) + 1;
  }
  function actualizarLink(eventoId, contextPath) {
    var cantidad = document.getElementById('cant_' + eventoId).value;
    document.getElementById('link_' + eventoId).href =
      contextPath + '/entradas/comprar/' + eventoId + '?cantidad=' + cantidad;
  }
</script>