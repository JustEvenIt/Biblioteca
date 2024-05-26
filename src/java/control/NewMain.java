/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package control;

import conexiones.MySQL_BD;
import java.util.List;
import modelo.dao.LibroDAO;
import modelo.dto.LibroDTO;

/**
 *
 * @author soporte
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Inicio prueba");
        LibroDAO dao = new LibroDAO();
        List<LibroDTO> lista = dao.readAll();
        
        for(LibroDTO lb : lista){
            System.out.println(lb.toString());
        }
        MySQL_BD.getInstance().cerrarConexion();
    }

}
