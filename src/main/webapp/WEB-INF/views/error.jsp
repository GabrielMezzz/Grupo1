<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
    <h1 style="color: red;">${mensajeError}</h1>
    <p style="color: red;">${pageContext.exception}</p>
    <a href="/main">Volver al inicio</a>
</body>
</html>