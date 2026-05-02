<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <title>Contacto - Teleticket</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

  <%@ include file="navbar.jsp" %>

  <div class="contenedor">
    <h2 style="text-align: center; margin-bottom: 30px;">Contáctanos</h2>
    <div style="display: flex; gap: 30px; flex-wrap: wrap;">
      <%@ include file="formulariocontacto.jsp" %>
      <%@ include file="infocontacto.jsp" %>
    </div>
  </div>

  <%@ include file="footer.jsp" %>

</body>
</html>