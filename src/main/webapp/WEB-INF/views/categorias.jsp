<%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <section class="categorias-seccion">
      <h2 class="categorias-titulo">Categorías de Eventos</h2>

      <div class="categorias-grid">
        <c:forEach var="cat" items="${categorias}">
          <article class="categoria-tarjeta">
            <div class="categoria-info">
              <h3 class="categoria-nombre">${cat.nombre}</h3>
              <p class="categoria-descripcion">
                ${cat.descripcion}
              </p>
            </div>
          </article>
        </c:forEach>
      </div>
    </section>