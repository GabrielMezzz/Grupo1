<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Eventos - Teleticket</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
</head>
<body>

  <%@ include file="navbar.jsp" %>

  <c:if test="${compraExitosa}">
    <div style="background-color: #d4edda; color: #155724; text-align: center;
         padding: 15px; font-size: 16px; font-weight: bold;">
      ✓ ¡Compra exitosa! Tu entrada ha sido registrada.
    </div>
  </c:if>

  <%@ include file="bannereve.jsp" %>
  <%@ include file="filtros.jsp" %>
  <%@ include file="listaeventos.jsp" %>
  <%@ include file="footer.jsp" %>

</body>
</html>