<%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <aside class="filtros-contenedor">
      <form class="filtros-form">

        <div class="campo-filtro">
          <label for="cat">Categoría</label>
          <select id="cat" name="categoria">
            <option>Todas las categorías</option>
            <c:forEach var="cat" items="${categorias}">
              <option value="${cat.id}">${cat.nombre}</option>
            </c:forEach>
          </select>
        </div>

        <div class="campo-filtro">
          <label for="fecha">Fecha</label>
          <input type="date" id="fecha" name="fecha">
        </div>

        <button type="submit" class="btn-buscar">
          <i class="fa-solid fa-magnifying-glass"></i> Buscar
        </button>

      </form>
    </aside>