<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% HttpSession obj = request.getSession();
if(obj != null && obj.getAttribute("usuario")!=null){
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Principal</title>
    </head>
    <body>
        <h1>Mi Biblioteca</h1>
        <form action="ControlCTO" method="post">
            <input type="hidden" name="menu" value="Libros">
            <input type="submit" name="accion" value="Listar">
        </form>

        <form action="ControlCTO" method="post">
            <div id="actualizarDiv">
                <h2>Actualizar Registro</h2>
                <input type="hidden" name="menu" value="Libros">
                <input type="text" name="idAct" id="idActualizar" placeholder="ID del Libro">
                <input type="text" name="nombreAct" id="nombreActualizar" placeholder="Nuevo Nombre">
                <input type="text" name="autorAct" id="autorActualizar" placeholder="Nuevo Autor">
                <input type="text" name="editorialAct" id="editorialActualizar" placeholder="Nueva Editorial">
                <input type="text" name="anioAct" id="anioActualizar" placeholder="Nuevo Año">
                <input type="submit" name="btnActualizar" value="Actualizar">
            </div>
        </form>

        <form action="ControlCTO" method="post">
            <div id="eliminarDiv">
                <h2>Eliminar Registro</h2>
                <input type="hidden" name="menu" value="Libros">
                <input type="text" name="idDel" id="idEliminar" placeholder="ID del Libro">
                <input type="submit" name="btnEliminar" value="Eliminar">
            </div>
        </form>

        <form action="ControlCTO" method="post">
            <div id="insertarDiv">
                <h2>Insertar Nuevo Registro</h2>
                <input type="hidden" name="menu" value="Libros">
                <input type="text" name="idIns" id="idInsertar" placeholder="ID del Libro">
                <input type="text" name="nombreIns" id="nombreInsertar" placeholder="Nombre del Libro">
                <input type="text" name="autorIns" id="autorInsertar" placeholder="Autor">
                <input type="text" name="editorialIns" id="editorialInsertar" placeholder="Editorial">
                <input type="text" name="anioIns" id="anioInsertar" placeholder="Año">
                <input type="submit" name="btnInsertar" value="Insertar">
            </div>
        </form>

        <form action="ControlCTO" method="post">
            <div id="consultarDiv">
                <h2>Consultar Registro</h2>
                <input type="hidden" name="menu" value="Libros">
                <input type="text" name="idCon" id="idConsultar" placeholder="ID del Libro">
                <input type="submit" name="btnConsultar" value="Consultar">
            </div>
        </form>
    </body>
</html>
<% } else {
    request.getRequestDispatcher("error.html").forward(request, response);
} %>
