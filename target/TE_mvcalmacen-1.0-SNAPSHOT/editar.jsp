<%@page import="com.emergentes.Modelo.Almacen"%>
<%
    Almacen item=(Almacen)request.getAttribute("miAlmacen");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><%=(item.getId()==0)?"Nuevo Registro":"Editar Registro" %></h1>
        <form action="MainController" method="post">
            <input type="hidden" name="id" value="<%= item.getId()%>"/>
            <table>
                <tr>
                    <td>Descripcion: </td>
                    <td><input type="text" name="descripciones" value="<%=item.getDescripciones()%>"></td>
                </tr>
                <tr>
                    <td>Cantidad:</td>
                    <td><input type="number" name="cantidades" value="<%=item.getCantidades()%>"></td>
                </tr>
                <tr>
                    <td>Precio:</td>
                    <td><input type="number" name="precios" value="<%=item.getPrecios()%>"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Enviar"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
