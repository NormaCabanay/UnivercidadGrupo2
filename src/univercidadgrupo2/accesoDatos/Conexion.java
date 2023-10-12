/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package univercidadgrupo2.accesoDatos;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author norma
 */
public class Conexion {
    private static final String URL = "jdbc:mariadb://localhost:3308/";
    private static final String DB ="trabajo_practico13";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "";
    private static Connection connection;
    
    private Conexion(){}
    
    public static Connection getConexion(){
        if (connection== null) {
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                connection = DriverManager.getConnection(URL+DB,USUARIO,PASSWORD); 
                JOptionPane.showMessageDialog( null, "conectado ");
            } catch (ClassNotFoundException ex) {
               JOptionPane.showMessageDialog( null, "Error al cargar los drive ");
            } catch (SQLException ex) {
                  JOptionPane.showMessageDialog( null, "Error al CONECTAR base de datos ");
            }
           
        }
      return connection;  
    } 
}
