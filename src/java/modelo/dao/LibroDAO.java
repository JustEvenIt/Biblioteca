/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import conexiones.MySQL_BD;
import java.util.List;
import modelo.dto.LibroDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author soporte
 */
public class LibroDAO implements Contrato<LibroDTO> {

    private static final String SQL_INSERT = "INSERT INTO tb_libro "
            + "(isbn, nombre, autor, editorial, anio) VALUES(?, ?, ?, ?, ?) ";
    private static final String SQL_DELETE = "DELETE FROM tb_libro WHERE isbn = ? ";
    private static final String SQL_UPDATE = "UPDATE tb_libro SET nombre = ?, autor = ?, "
            + "editorial = ?, anio = ? WHERE isbn = ? ";
    private static final String SQL_READ = "SELECT * FROM tb_libro WHERE isbn = ? ";
    private static final String SQL_READALL = "SELECT * FROM tb_libro ";

    private static final MySQL_BD con = MySQL_BD.getInstance();

    @Override
    public boolean create(LibroDTO nuevo) {
        PreparedStatement psnt;
        try {
            psnt = con.cnn.prepareStatement(SQL_INSERT);
            psnt.setLong(1, nuevo.getIsbn());
            psnt.setString(2, nuevo.getNombre());
            psnt.setString(3, nuevo.getAutor());
            psnt.setString(4, nuevo.getEditorial());
            psnt.setInt(5, nuevo.getAnio());
            return 1==psnt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al consultar Libro " + ex.getMessage());
        }    
        return false;
    }
    

    @Override
    public boolean delete(Long id) {
            PreparedStatement psnt;
        try {
            psnt = con.cnn.prepareStatement(SQL_DELETE);
            psnt.setLong(1, id);
            int filasAfectadas=psnt.executeUpdate();
            if (filasAfectadas > 0) {
                return true;
            } else {
            System.out.println("Error al eliminar Libro ");
            return false;
            }
        } catch (SQLException ex) {
            System.out.println("Error al borrar Libro " + ex.getMessage());
        }    
        return false;

    }

    @Override
    public boolean update(LibroDTO filter) {
    PreparedStatement psnt;
        try {
            psnt = con.cnn.prepareStatement(SQL_UPDATE);
            psnt.setString(1, filter.getNombre());
            psnt.setString(2, filter.getAutor());
            psnt.setString(3, filter.getEditorial());
            psnt.setInt(4, filter.getAnio());
            psnt.setLong(5, filter.getIsbn());
            int filasAfectadas=psnt.executeUpdate();
            if (filasAfectadas > 0) {
                return true;
            } else {
            System.out.println("Error al consultar Libro ");
            return false;
            }
        } catch (SQLException ex) {
            System.out.println("Error al consultar Libro " + ex.getMessage());
        }    
        return false;
        
    }

    @Override
    public List<LibroDTO> read(LibroDTO filter) {
        List<LibroDTO> lista = null;
        PreparedStatement psnt;
        try {
            psnt = con.cnn.prepareStatement(SQL_READ);
            psnt.setLong(1, filter.getIsbn());
            ResultSet rs = psnt.executeQuery();
            lista = new ArrayList<LibroDTO>();
            while (rs.next()) {
                LibroDTO libro = new LibroDTO(
                        rs.getLong("isbn"),
                        rs.getString("nombre"),
                        rs.getString("autor"),
                        rs.getString("editorial"),
                        rs.getInt("anio"));
                lista.add(libro);
            }
        } catch (SQLException ex) {
            System.out.println("Error al consultar Libro " + ex.getMessage());
        }
        return lista;
    }

    @Override
    public List<LibroDTO> readAll() {
        List<LibroDTO> lista = null;
        PreparedStatement psnt;
        try {
            psnt = con.cnn.prepareStatement(SQL_READALL);
            ResultSet rs = psnt.executeQuery();
            lista = new ArrayList<LibroDTO>();
            while (rs.next()) {
                LibroDTO libro = new LibroDTO(
                        rs.getLong("isbn"),
                        rs.getString("nombre"),
                        rs.getString("autor"),
                        rs.getString("editorial"),
                        rs.getInt("anio"));
                lista.add(libro);
            }
        } catch (SQLException ex) {
            System.out.println("Error al consultar Libro " + ex.getMessage());
        }
        return lista;
    }

}
