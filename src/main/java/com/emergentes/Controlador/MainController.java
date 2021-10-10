
package com.emergentes.Controlador;

import com.emergentes.Modelo.Almacen;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       HttpSession ses=request.getSession();
        
        if(ses.getAttribute("listaalm")==null){
                ArrayList<Almacen>listaux=new ArrayList<Almacen>();
                ses.setAttribute("listaalm", listaux);
            }
        
        ArrayList<Almacen>lista=(ArrayList<Almacen>)ses.getAttribute("listaalm");
        
        
        String op = request.getParameter("op");
       String opcion=(op!=null)?op:"view";
       
      Almacen obj1=new Almacen();
       
       int id,pos;
       
       switch(opcion){
           case"nuevo":
               request.setAttribute("miAlmacen", obj1);
               request.getRequestDispatcher("editar.jsp").forward(request, response);
               break;
           case "editar":
               id=Integer.parseInt(request.getParameter("id"));
               pos= buscarIndice(request,id);
               obj1=lista.get(pos);
               request.setAttribute("miAlmacen", obj1);
               request.getRequestDispatcher("editar.jsp").forward(request, response);
               break;
           case"eliminar":     
                id=Integer.parseInt(request.getParameter("id"));
               pos= buscarIndice(request,id);
               lista.remove(pos);
               ses.setAttribute("listaalm", lista);
               response.sendRedirect("index.jsp");
               break;
           case"view":
               response.sendRedirect("index.jsp");
       }
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses = request.getSession();
        ArrayList<Almacen>lista=(ArrayList<Almacen>)ses.getAttribute("listaalm");
        
        Almacen obj1=new Almacen();
        
        obj1.setId(Integer.parseInt(request.getParameter("id")));
        obj1.setDescripciones(request.getParameter("descripciones"));
        obj1.setCantidades(Integer.parseInt(request.getParameter("cantidades")));
        obj1.setPrecios(Integer.parseInt(request.getParameter("precios")));
        
        int idt=obj1.getId();
        
        if(idt==0){
            //nuevo
            //actualizar el ultimo id
            int ultID;
            ultID=ultimoId(request);
            obj1.setId(ultID);
            ultimoId(request);
            lista.add(obj1);
        }
        else{
            //edicion
            lista.set(buscarIndice(request,idt), obj1);
        }
        ses.setAttribute("listaalm", lista);
        response.sendRedirect("index.jsp");
    } 
    
    private int buscarIndice(HttpServletRequest request,int id){
        HttpSession ses=request.getSession();
        ArrayList<Almacen>lista=(ArrayList<Almacen>)ses.getAttribute("listaalm");
        
        int i=0;
        if(lista.size()>0){
            while(i<lista.size()){
                if(lista.get(i).getId()==id){
                    break;
                }
                else{
                    i++;
                }
            }
        }
        return i;
    }
    private int ultimoId(HttpServletRequest request){
       HttpSession ses=request.getSession();
        ArrayList<Almacen>lista=(ArrayList<Almacen>)ses.getAttribute("listaalm");
        
        int idaux=0;
        for(Almacen item:lista){
            idaux=item.getId();
            
        }
        return idaux+1;
    }
}
