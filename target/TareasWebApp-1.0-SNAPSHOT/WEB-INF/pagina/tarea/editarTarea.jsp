<%-- 
    Document   : editarTarea
    Created on : 7 abr. 2021, 16:18:10
    Author     : ramir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="style/formulario.css" rel="stylesheet">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Editar tarea works!</h1>
        ${tarea.hora}
        <form action="${pageContext.request.contextPath}/ServletControlador?accion=modificar&idTarea=${tarea.idTarea}" method="post">
            <div class="margen-1-y">
                <label for="nombre">Nombre</label>
                <input type="text" name="nombre" value="${tarea.nombre}">
            </div>

            <div class="margen-1-y">
                <label for="descripcion">Descripcion</label>
                <input type="text" name="descripcion" value="${tarea.descripcion}">
            </div>

            <div class="margen-1-y">
                <label for="fecha">Fecha</label>
                <input type="date" name="fecha" value="${tarea.fecha}">
            </div>

            <div class="margen-1-y">
                <label for="hora">Hora</label>
                <input type="time" name="hora" value="${tarea.hora}">
            </div>

            <input type="hidden" name="finalizada" value="${tarea.finalizada}">
            <button type="submit">Agregar</button>
            <a href="index.jsp">Cancelar</a>
        </form>
    </body>
</html>
