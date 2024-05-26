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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(Object item) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(LibroDTO filter) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public LibroDTO read(LibroDTO filter) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
    
    public boolean update() {
        
        List<LibroDTO> lista = null;
        PreparedStatement psnt;
        
        return true;
    }

}
