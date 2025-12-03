package com.carlos.crudestudiantesws.ws;

import com.carlos.crudestudiantesws.dao.EstudianteDAO;
import com.carlos.crudestudiantesws.dao.MatriculaDAO;
import com.carlos.crudestudiantesws.model.Estudiante;
import com.carlos.crudestudiantesws.model.Materia;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.WebParam;
import java.util.List;

@WebService(serviceName = "ServicioMatriculas")
public class ServicioMatriculas {

    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    @WebMethod(operationName = "bye")
    public String bye(@WebParam(name = "name") String txt) {
        return "bye " + txt + " !";
    }

    private final MatriculaDAO matDao = new MatriculaDAO();
    private final EstudianteDAO estDao = new EstudianteDAO();
//

    @WebMethod(operationName = "getEstudiantePorMateria")
    public List<Estudiante> getEstudiantePorMateria(@WebParam(name = "idMateria") int idMateria) {
        System.out.println("Consultando estudiantes matriculados en la materia " + idMateria);

        List<Integer> ids = matDao.obtenerEstudiantesPorMateria(idMateria);
        System.out.println("IDs obtenidos: " + ids);

        List<Estudiante> estudiantes = estDao.obternerListaPorId(ids);
        System.out.println("Estudiantes obtenidos: " + estudiantes);

        return estudiantes;
    }

    @WebMethod(operationName = "getMateriasPorEstudiante")
    public List<Materia> getMateriasPorEstudiante(@WebParam(name = "idEstudiante") int idEstudiante) {
        System.out.println("Consultando materias matriculadas por el estudiante " + idEstudiante);

        List<Materia> materias = new MatriculaDAO().listarMatriculas(idEstudiante);
        System.out.println("Materias obtenidas: " + materias);

        return materias;
    }

    @WebMethod(operationName = "getEstudiante")
    public Estudiante getEstudiante(@WebParam(name = "idEstudiante") int idEstudiante) {
        System.out.println("Consultando estudiante con ID " + idEstudiante);
        return estDao.obtenerPorId(idEstudiante);
    }

    @WebMethod(operationName = "getMateria")
    public Materia getMateria(@WebParam(name = "idMateria") int idMateria) {
        System.out.println("Consultando materia " + idMateria);
        return new MatriculaDAO().obtenerMateriaPorId(idMateria);
    }

}
