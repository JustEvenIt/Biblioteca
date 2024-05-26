/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author soporte
 */
public class MySQL_BD {

    private static MySQL_BD instance;
    public Connection cnn = null;
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String user = "root";
    private String pss = "123456";
    private String nom_bd = "bd_biblioteca";
    private String url = "jdbc:mysql://localhost:3306/";

    private MySQL_BD() {
        System.out.println("creando instacia");
        try {
            Class.forName(driver);
            cnn = DriverManager.getConnection(url + nom_bd, user, pss);
               System.out.println("Si hay conexion");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("error en driver mysql: " + ex.getMessage());
        }
    }

    public static synchronized MySQL_BD getInstance() {
        if (instance == null) {
            instance = new MySQL_BD();
        }
        return instance;
    }
    
  
    public void cerrarConexion() {
        if (cnn != null) {
            try {
                cnn.close();
                System.out.println("Conexion cerrada");
            } catch (SQLException ex) {
                System.out.println("error al cerra la conexion: " + ex.getMessage());
            }
        }
        instance = null;
    }
}
