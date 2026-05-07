<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <title>Gestión de Usuarios - Teleticket</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

  <%@ include file="../navbarcrud.jsp" %>

  <div class="contenedor">
    <div style="display: flex; justify-content: space-between; align-items: center; margin-bottom: 25px;">
      <h2>Gestión de Usuarios</h2>
      <button class="btn-primario" onclick="mostrarFormulario()">+ Nuevo Usuario</button>
    </div>

    <%@ include file="formularionuevousuario.jsp" %>
    <%@ include file="tablausuarios.jsp" %>
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