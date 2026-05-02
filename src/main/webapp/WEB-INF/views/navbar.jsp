<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar">
  <a href="${pageContext.request.contextPath}/main" class="logo">Teleticket</a>
  <ul>
    <li><a href="${pageContext.request.contextPath}/main">Inicio</a></li>
    <li><a href="${pageContext.request.contextPath}/publicidad">Eventos</a></li>
    <li><a href="${pageContext.request.contextPath}/contacto">Contacto</a></li>
    <c:choose>
      <c:when test="${not empty sessionScope.usuario}">
        <li><a href="${pageContext.request.contextPath}/gestion">Gestión</a></li>
        <li><a href="${pageContext.request.contextPath}/logout">Cerrar Sesión</a></li>
      </c:when>
      <c:otherwise>
        <li><a href="${pageContext.request.contextPath}/login">Ingresar</a></li>
      </c:otherwise>
    </c:choose>
  </ul>
</nav>