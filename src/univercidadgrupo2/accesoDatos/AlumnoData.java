
package univercidadgrupo2.accesoDatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import univercidadgrupo2.entidades.Alumno;


public class AlumnoData {
    private Connection con = null;

    public AlumnoData() {
        con = Conexion.getConexion();
    }
   public void guardarAlumno(Alumno alumno){  //agrego alumno sentencia insert
       String sql= "INSERT INTO alumno(dni,apellido,nombre,fechaNac, estado)" 
               + "VALUES(?,?,?,?,?)";
        try {
            PreparedStatement ps= con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3,alumno.getNombre());
            ps.setDate (4, Date.valueOf( alumno.getFechaNac()));
            ps.setBoolean(5, alumno.isEstado());
            ps.executeUpdate();
            ResultSet rs= ps.getGeneratedKeys();
            if (rs.next()) {
                alumno.setIdAlumno(rs.getInt(1));
                JOptionPane.showMessageDialog(null,"Alumno Agregado exitosamente");
                
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla alumno");
        }
   }
    
    
    
    public void modificarAlumno(Alumno alumno){ //mofifico alumno sencia update
       String sql= "UPDATE alumno SET dni=?,apellido =?,nombre =?, fechaNac =?"
               + "WHERE idAlumno=?";
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3,alumno.getNombre());
            ps.setDate (4, Date.valueOf( alumno.getFechaNac()));
            ps.setInt(5, alumno.getIdAlumno());
            int modificado=ps.executeUpdate();
           
            if (modificado == 1) {
                JOptionPane.showMessageDialog(null,"Alumno mofificado");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla alumno");
        }
   }
    
    public void eliminarAlumno(Alumno alumno){ // elimino alumno sentencia update
       String sql= "UPDATE alumno SET estado = 0 WHERE idAlumno=?";
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setInt(1, alumno.getIdAlumno());
            int modificado=ps.executeUpdate();
           
            if (modificado == 1) {
                JOptionPane.showMessageDialog(null,"Alumno eliminado");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla alumno");
        }
   }
    
    public Alumno buscarAlumno(int id){  //lista alumnos con id = 2 sentencia select
        String sql= "SELECT dni, apellido, nombre,fechaNac FROM alumno WHERE idAlumno= ? AND estado = 1";
        Alumno alumno = null;
         try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                alumno = new Alumno();
                alumno.setIdAlumno(id);
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNac(rs.getDate("fechaNac").toLocalDate());
                alumno.setEstado(true);
            }else{
                JOptionPane.showMessageDialog(null,"Alumno No encontrado");
                ps.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla alumno");
        }
        
        return alumno;
    }
    
}
    
   
   
   

