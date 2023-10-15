
package univercidadgrupo2;

import java.time.LocalDate;
import univercidadgrupo2.accesoDatos.AlumnoData;
import univercidadgrupo2.entidades.Alumno;


public class UnivercidadGrupo2 {

   
    public static void main(String[] args) {
//        Alumno Angel = new Alumno(8,238745679,"Quiroga","Miguel", LocalDate.of(1990,1,18),true);
        AlumnoData alumn= new AlumnoData();
        //alumn.guardarAlumno(Miguel);
        //alumn.modificarAlumno(Angel);
//      alumn.eliminarAlumno(Angel);
         Alumno alumnoEncontrado = alumn.buscarAlumno(2);
         System.out.println("dni : " + alumnoEncontrado.getDni());
         System.out.println("apelido :" + alumnoEncontrado.getApellido());
         System.out.println("nombre  :" + alumnoEncontrado.getNombre());
         System.out.println("fecha de nacimiento : " + alumnoEncontrado.getFechaNac());
         
    }
    
}
