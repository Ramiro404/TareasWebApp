<%-- 
    Document   : agregarTarea
    Created on : 6 abr. 2021, 10:17:02
    Author     : ramir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style/formulario.css" rel="stylesheet">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>JSP Page</title>
    </head>
    <body>
        <header>
            <h1>Agregar Tarea</h1>
        </header>
        <main class="contenedor-formulario">
            <div class="formulario">
                <form action="${pageContext.request.contextPath}/ServletControlador?accion=insertar" method="post">
                    <div class="margen-1-y">
                        <label for="nombre">Nombre</label>
                        <input type="text" name="nombre">
                    </div>
                    
                    <div class="margen-1-y">
                        <label for="descripcion">Descripcion</label>
                        <input type="text" name="descripcion">
                    </div>
                    
                    <div class="margen-1-y">
                        <label for="fecha">Fecha</label>
                        <input type="date" name="fecha">
                    </div>
                    
                    <div class="margen-1-y">
                        <label for="hora">Hora</label>
                        <input type="time" name="hora">
                    </div>
                    
                    <input type="hidden" name="finalizada">
                    <button type="submit">Agregar</button>
                    <a href="index.jsp">Cancelar</a>
                </form>
            </div>
        </main>
        
    </body>
</html>
