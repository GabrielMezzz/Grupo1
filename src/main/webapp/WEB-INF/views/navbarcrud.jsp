<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar">
  <a href="${pageContext.request.contextPath}/main" class="logo">Teleticket</a>
  <ul>
    <li><a href="${pageContext.request.contextPath}/gestion">Gestión Entradas</a></li>
    <li><a href="${pageContext.request.contextPath}/gestionusuarios">Gestión Usuarios</a></li>
    <li><a href="${pageContext.request.contextPath}/gestioneventos">Gestión Eventos</a></li>
    <li><a href="${pageContext.request.contextPath}/gestioncategorias">Gestión Categorías</a></li>
    <li><a href="${pageContext.request.contextPath}/gestionartistas">Gestión Artistas</a></li>
    <li><a href="${pageContext.request.contextPath}/entradas/metricas">Metricas</a></li>
    <li><a href="${pageContext.request.contextPath}/logout">Cerrar Sesión</a></li>
  </ul>
</nav>