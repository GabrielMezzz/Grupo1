<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<aside class="filtros-contenedor">
  <form class="filtros-form" action="${pageContext.request.contextPath}/eventos" method="get">

    <div class="campo-filtro">
      <label for="cat">Categoría</label>
      <select id="cat" name="categoria">
        <option value="">Todas las categorías</option>
        <c:forEach var="cat" items="${categorias}">
          <option value="${cat.nombre}" ${param.categoria == cat.nombre ? 'selected' : ''}>${cat.nombre}</option>
        </c:forEach>
      </select>
    </div>

    <button type="submit" class="btn-buscar">
      <i class="fa-solid fa-magnifying-glass"></i> Buscar
    </button>

  </form>
</aside>