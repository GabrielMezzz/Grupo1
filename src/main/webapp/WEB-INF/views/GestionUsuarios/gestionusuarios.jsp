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

    // Deja solo letras y pone cada palabra con mayuscula inicial
    function capitalizarTexto(input) {
      let texto = input.value;
      let resultado = '';
      let nuevaPalabra = true;

      for (let i = 0; i < texto.length; i++) {
        let caracter = texto.charAt(i);

        if (caracter === ' ') {
          if (resultado.length > 0 && resultado.charAt(resultado.length - 1) !== ' ') {
            resultado += ' ';
          }
          nuevaPalabra = true;
        } else if (esLetra(caracter)) {
          if (nuevaPalabra) {
            resultado += caracter.toUpperCase();
            nuevaPalabra = false;
          } else {
            resultado += caracter.toLowerCase();
          }
        }
      }

      input.value = resultado;
    }

    // Revisa si un caracter es una letra
    function esLetra(caracter) {
      return caracter.toLowerCase() !== caracter.toUpperCase();
    }

    // Deja solo numeros y corta la cantidad maxima
    function soloNumeros(input, maximo) {
      let texto = input.value;
      let resultado = '';

      for (let i = 0; i < texto.length; i++) {
        let caracter = texto.charAt(i);

        if (caracter >= '0' && caracter <= '9') {
          resultado += caracter;
        }
      }

      if (resultado.length > maximo) {
        resultado = resultado.substring(0, maximo);
      }

      input.value = resultado;
    }

    // Formatea el telefono como 987 654 321 mientras se escribe
    function formatearTelefono(input) {
      let texto = input.value;
      let digitos = '';

      for (let i = 0; i < texto.length; i++) {
        let caracter = texto.charAt(i);

        if (caracter >= '0' && caracter <= '9') {
          digitos += caracter;
        }
      }

      if (digitos.length > 9) {
        digitos = digitos.substring(0, 9);
      }

      let formateado = '';

      for (let i = 0; i < digitos.length; i++) {
        if (i === 3 || i === 6) {
          formateado += ' ';
        }
        formateado += digitos.charAt(i);
      }

      input.value = formateado;
    }
  </script>

</body>
</html>
