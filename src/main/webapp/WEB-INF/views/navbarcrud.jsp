<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar">
  <a href="${pageContext.request.contextPath}/main" class="logo">Teleticket</a>
  <ul>
    <li><a href="${pageContext.request.contextPath}/gestion">Gestion Entradas</a></li>
    <li><a href="${pageContext.request.contextPath}/gestionusuarios">Gestion Usuarios</a></li>
    <li><a href="${pageContext.request.contextPath}/gestioneventos">Gestion Eventos</a></li>
    <li><a href="${pageContext.request.contextPath}/gestioncategorias">Gestion Categorias</a></li>
    <li><a href="${pageContext.request.contextPath}/gestionartistas">Gestion Artistas</a></li>
    <li><a href="${pageContext.request.contextPath}/metricas">Metricas</a></li>
    <li><a href="${pageContext.request.contextPath}/logout">Cerrar Sesion</a></li>
  </ul>
</nav>
