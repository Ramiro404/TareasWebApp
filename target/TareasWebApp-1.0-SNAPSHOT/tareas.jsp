<%-- 
    Document   : tareas
    Created on : 5 abr. 2021, 13:31:55
    Author     : ramir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style/todoList.css" rel="stylesheet">
        <script src="https://kit.fontawesome.com/edb1e4210d.js" crossorigin="anonymous"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <div class="contenedor">
            <a  class="btn btn-normal" href="${pageContext.request.contextPath}/ServletControlador?accion=agregar"><i class="fas fa-plus"></i> Nuevo</a>
            <div class="listado-tareas">
                <c:forEach var="tarea" items="${tareas}">
               
                <div class="tarea">
                    <div class="tarea__finalizada">
                        <label class="contenedor-check">0
                            <input type="checkbox" name="finalizada" checked="${tarea.finalizada}"/>
                            <span class="checkmark"></span>
                        </label>
                        
                    </div>
                    <div class="tarea__contenido">
                        <h3>${tarea.nombre}</h3>
                        <span><i class="far fa-calendar"></i> ${tarea.fecha}</span>
                        <span><i class="far fa-clock"></i> ${tarea.hora}</span>
                        <p>${tarea.descripcion}</p>
                    </div>
                    <div class="tarea__finalizada">
                        <a class="btn btn-editar" href="${pageContext.request.contextPath}/ServletControlador?accion=editar&idTarea=${tarea.idTarea}">Editar</a>
                        <a class="btn btn-eliminar" href="${pageContext.request.contextPath}/ServletControlador?accion=eliminar&idTarea=${tarea.idTarea}">Eliminar</a>
                    </div>
                </div>
                </c:forEach>
            </div>
        </div>
       
      
    </body>
</html>
