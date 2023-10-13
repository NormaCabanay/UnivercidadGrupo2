
package univercidadgrupo2;

import java.time.LocalDate;
import univercidadgrupo2.accesoDatos.AlumnoData;
import univercidadgrupo2.entidades.Alumno;


public class UnivercidadGrupo2 {

   
    public static void main(String[] args) {
        Alumno Miguel = new Alumno(238745679,"Sanchez","Angel", LocalDate.of(1990,2,12),true);
        AlumnoData alumn= new AlumnoData();
        alumn.guardarAlumno(Miguel);
    }
    
}
