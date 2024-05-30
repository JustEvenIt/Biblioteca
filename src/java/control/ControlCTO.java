package control;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import modelo.dao.LibroDAO;
import modelo.dto.LibroDTO;

public class ControlCTO extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        String actualizar = request.getParameter("btnActualizar");
        String eliminar = request.getParameter("btnEliminar");
        String insertar = request.getParameter("btnInsertar");
        String consultar = request.getParameter("btnConsultar");

        LibroDAO dao = new LibroDAO();

        
            if (menu != null && menu.equals("Libros")) {

                if (accion != null && accion.equalsIgnoreCase("Listar")) {
                    List<LibroDTO> lista = dao.readAll();
                    request.setAttribute("lista", lista);
                    request.getRequestDispatcher("libro_vta.jsp").forward(request, response);
                    return;
                }

                if (actualizar != null && actualizar.equalsIgnoreCase("Actualizar")) {
                    try {
                        long isbnAct = Long.parseLong(request.getParameter("idAct"));
                        String nombreAct = request.getParameter("nombreAct");
                        String autorAct = request.getParameter("autorAct");
                        String editorialAct = request.getParameter("editorialAct");
                        int anioAct = Integer.parseInt(request.getParameter("anioAct"));

                        LibroDTO actualizarLibro = new LibroDTO(isbnAct, nombreAct, autorAct, editorialAct, anioAct);
                        if (dao.update(actualizarLibro)) {
                            
                        } else {
                            request.getRequestDispatcher("error.html").forward(request, response);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Error de formato numérico: " + e.getMessage());
                        request.getRequestDispatcher("error.html").forward(request, response);
                    }
                    return;
                }

                if (eliminar != null && eliminar.equalsIgnoreCase("Eliminar")) {
                    try {                          
                        long isbnDel = Long.parseLong(request.getParameter("idDel"));
                        if (dao.delete(isbnDel)) {
                        } else {
                            request.getRequestDispatcher("error.html").forward(request, response);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Error de formato numérico: " + e.getMessage());
                        request.getRequestDispatcher("error.html").forward(request, response);
                    }
                    return;
                }

                if (insertar != null && insertar.equalsIgnoreCase("Insertar")) {
                    try {
                        long idIns = Long.parseLong(request.getParameter("idIns"));
                        String nombreIns = request.getParameter("nombreIns");
                        String autorIns = request.getParameter("autorIns");
                        String editorialIns = request.getParameter("editorialIns");
                        int anioIns = Integer.parseInt(request.getParameter("anioIns"));

                        LibroDTO nuevoLibro = new LibroDTO(idIns, nombreIns, autorIns, editorialIns, anioIns);
                        if (dao.create(nuevoLibro)) {
                        } else {
                            request.getRequestDispatcher("error.html").forward(request, response);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Error de formato numérico: " + e.getMessage());
                        request.getRequestDispatcher("error.html").forward(request, response);
                    }
                    
                }

                if (consultar != null && consultar.equalsIgnoreCase("Consultar")) {
                    try {
                        long isbnCon = Long.parseLong(request.getParameter("idCon"));
                        
                        LibroDTO libro=new LibroDTO(isbnCon);
                        List<LibroDTO> lista;
                        lista= dao.read(libro);
                        request.setAttribute("lista", lista);
                        request.getRequestDispatcher("libro_vta.jsp").forward(request, response);
                    } catch (NumberFormatException e) {
                        System.out.println("Error de formato numérico: " + e.getMessage());
                        request.getRequestDispatcher("error.html").forward(request, response);
                    }                
            }
            }
    }
   
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}

