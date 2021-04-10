package web;

import datos.TareaDaoJDBC;
import dominio.Tarea;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {

    /*
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletControlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletControlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }*/

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "agregar":
                    String jspAgregar = "/WEB-INF/pagina/tarea/agregarTarea.jsp";
                    request.getRequestDispatcher(jspAgregar).forward(request, response);
                    break;
                case "editar":
                    this.editarTarea(request, response);
                    break;
                case "eliminar":
                    this.eliminar(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }

        } else {
            this.accionDefault(request, response);
        }
    }

    public void accionDefault(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //HttpSession sesion = request.getSession();
        List<Tarea> tareas = new TareaDaoJDBC().listar();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("tareas", tareas);
        response.sendRedirect("tareas.jsp");
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String accion = request.getParameter("accion");
        try{
            if(accion != null){
                switch(accion){
                    case "insertar":
                        this.insertarTarea(request, response);
                        break;
                    case "modificar":
                        this.modificarTarea(request, response);
                        break;
                    default:
                        this.accionDefault(request, response);
                        break;
                }
            } else {
                this.accionDefault(request, response);
            }
        } catch(ParseException e){
            System.out.println(e);
        }
    }
    
    public void insertarTarea(HttpServletRequest request, HttpServletResponse response) throws ParseException, IOException{
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        String fechaString = request.getParameter("fecha");
        Date fecha = Date.valueOf(fechaString);
        String horaString = request.getParameter("hora");
        Time hora = Time.valueOf(horaString + ":00");
        String finalizadaString = request.getParameter("finalizada");
        Boolean finalizada = Boolean.parseBoolean(finalizadaString);
        
        Tarea tarea = new Tarea(nombre, descripcion, fecha, hora, finalizada);
        int registrosModificados = new TareaDaoJDBC().insertar(tarea);
        System.out.println("Registros modificados " + registrosModificados);
        this.accionDefault(request, response);
    }
    
    public void editarTarea(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int idTarea = Integer.parseInt(request.getParameter("idTarea"));
        Tarea tarea = new TareaDaoJDBC().encontrar(new Tarea(idTarea));
        request.setAttribute("tarea", tarea);
        String jspEditar = "/WEB-INF/pagina/tarea/editarTarea.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
    }
    
    public void modificarTarea(HttpServletRequest request, HttpServletResponse response) throws IOException{
        int idTarea = Integer.parseInt(request.getParameter("idTarea"));
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        String fechaString = request.getParameter("fecha");
        Date fecha = Date.valueOf(fechaString);
        String horaString = request.getParameter("hora");
        Time hora = Time.valueOf(horaString+":00");
        String finalizadaString = request.getParameter("finalizada");
        Boolean finalizada = Boolean.parseBoolean(finalizadaString);
        
        Tarea tarea = new Tarea(idTarea,nombre, descripcion, fecha, hora, finalizada);
        int registrosModificados = new TareaDaoJDBC().actualizar(tarea);
        System.out.println("Registros modificados " + registrosModificados);
        this.accionDefault(request, response);
        
    }
    
    public void eliminar(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        int idTarea = Integer.parseInt(request.getParameter("idTarea"));
        Tarea tarea = new Tarea(idTarea);
        int registrosEliminados = new TareaDaoJDBC().eliminar(tarea);
        System.out.println("Registros modificados " + registrosEliminados);
        this.accionDefault(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
