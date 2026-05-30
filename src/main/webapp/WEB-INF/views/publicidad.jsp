<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Cartelera Informativa | Teleticket</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
</head>
<body>

    <%@ include file="navbar.jsp" %>

    <header class="publi-header">
        <h1>Cartelera Informativa 2026</h1>
        <p>Cronograma detallado de eventos y presentaciones culturales</p>
    </header>

    <main class="publi-grid">
        <c:forEach items="${eventos}" var="evento">
            <article class="publi-card">
                <div class="publi-icono">
                    <c:choose>
                        <c:when test="${evento.categoria == 'Conciertos'}">
                            <i class="fa-solid fa-music"></i>
                        </c:when>
                        <c:when test="${evento.categoria == 'Teatro'}">
                            <i class="fa-solid fa-masks-theater"></i>
                        </c:when>
                        <c:when test="${evento.categoria == 'Stand up y Monologos'}">
                            <i class="fa-solid fa-microphone"></i>
                        </c:when>
                        <c:otherwise>
                            <i class="fa-solid fa-star"></i>
                        </c:otherwise>
                    </c:choose>
                </div>
                <span class="publi-tag">${evento.categoria}</span>
                <h2 class="publi-nombre">${evento.nombre}</h2>
                <p class="publi-desc">
                    Presentamos a <strong>${evento.artista.nombreArtistico}</strong>.
                    Hora: <strong>${evento.artista.hora}</strong>.
                    Este evento forma parte de nuestra agenda cultural anual.
                </p>
                <span class="publi-sede"><i class="fa-solid fa-location-dot"></i> ${evento.sede}</span>
                <span class="publi-fecha"><i class="fa-solid fa-calendar-days"></i> ${evento.fecha}</span>
            </article>
        </c:forEach>
    </main>

    <%@ include file="footer.jsp" %>

</body>
</html>
