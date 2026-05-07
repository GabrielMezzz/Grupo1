<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <title>Gestión de Sedes - Teleticket</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

  <%@ include file="../navbarcrud.jsp" %>

  <div class="contenedor">
    <div style="display: flex; justify-content: space-between; align-items: center; margin-bottom: 25px;">
      <h2>Gestión de Sedes</h2>
      <button class="btn-primario" onclick="mostrarFormulario()">+ Nueva Sede</button>
    </div>

    <%@ include file="formularioSede.jsp" %>
    <%@ include file="tarjetasSedes.jsp" %>
  </div>

  <%@ include file="../footer.jsp" %>

  <script>
    function mostrarFormulario() {
      document.getElementById('formulario').style.display = 'block';
    }
    function ocultarFormulario() {
      document.getElementById('formulario').style.display = 'none';
    }
  </script>

</body>
</html>