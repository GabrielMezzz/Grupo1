<%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="paginaTitulo" value="Gestión - Teleticket" />

    <!DOCTYPE html>
    <html lang="es">
    <%@ include file="head.jsp" %>

      <body>
        <%@ include file="navbar.jsp" %>

          <main class="main-content-wrapper">
            <section class="panel-gestion">
              <%@ include file="contenido-gestion-tabla.jsp" %>
            </section>
          </main>

          <%@ include file="footer.jsp" %>
      </body>

    </html>