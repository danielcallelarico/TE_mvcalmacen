
<%@page import="com.emergentes.Modelo.Almacen"%>
<%@page import="java.util.ArrayList"%>

<%
    ArrayList<Almacen> lista=(ArrayList<Almacen>)session.getAttribute("listaalm");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listado Almacen</h1>
        <a href="MainController?op=nuevo">Nuevo Registro</a>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Descripcion</th>
                <th>Cantidad</th>
                <th>Precio</th>
                <th></th>
                <th></th>
            </tr>
            <%
                if(lista!=null){
                    for(Almacen item : lista){
                
            %>
                
            <tr>
                <td><%=item.getId()%></td>
                <td><%=item.getDescripciones()%></td>
                <td><%=item.getCantidades()%></td>
                <td><%=item.getPrecios()%></td>
                <td><a href="MainController?op=editar&id=<%=item.getId()%>">Modificar</a></td>
                <td><a href="MainController?op=eliminar&id=<%=item.getId()%>"
                       onclick="return confirm('Esta seguro de eliminar el registro ?');">Eliminar</a></td>
       
            </tr>
            <%
                      } 

                    }
            %>
        </table>
    </body>
</html>
