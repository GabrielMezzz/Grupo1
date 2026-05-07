<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <title>Gestión de Entradas - Teleticket</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

  <%@ include file="../navbarcrud.jsp" %>

  <div class="contenedor">
    <h2 style="margin-bottom: 25px;">Gestión de Entradas</h2>
    <%@ include file="tablaentradas.jsp" %>
  </div>

  <%@ include file="../footer.jsp" %>

</body>
</html>