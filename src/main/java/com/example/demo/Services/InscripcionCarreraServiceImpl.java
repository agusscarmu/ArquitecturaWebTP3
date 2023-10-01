package com.example.demo.Services;

import com.example.demo.DTO.EstudianteDTO.EstudianteDTO;
import com.example.demo.DTO.InscripcionDTO.InscripcionDTO;
import com.example.demo.DTO.InscripcionDTO.InscripcionesPorAnioDTO;
import com.example.demo.DTO.InscripcionDTO.MatriculacionDTO;
import com.example.demo.Model.Carrera;
import com.example.demo.Model.Estudiante;
import com.example.demo.Model.InscripcionCarrera;
import com.example.demo.Repositories.CarreraRepository;
import com.example.demo.Repositories.EstudianteRepository;
import com.example.demo.Repositories.InscripcionCarreraRepository;
import com.example.demo.Services.Interfaces.InscripcionCarreraService;
import com.example.demo.Sort.OrderByNameYear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class InscripcionCarreraServiceImpl implements InscripcionCarreraService {

    @Autowired
    private InscripcionCarreraRepository icr;
    @Autowired
    private EstudianteRepository er;
    @Autowired
    private CarreraRepository cr;

    @Override
    public List<EstudianteDTO> obtenerEstudiantesPorCarreraYCiudad(int idCarrera, String ciudad) {
        return icr.findAllEstudiantesCarreraCiudad(idCarrera,ciudad);
    }

    @Override
    public List<InscripcionesPorAnioDTO> obtenerReporte() {
        List<InscripcionesPorAnioDTO> lista = new LinkedList<>();

        for(int y = 1990; y < java.time.LocalDate.now().getYear() + 1; y++){
            lista.addAll(icr.obtenerReporteCarrera(y));
        }

        lista.sort(new OrderByNameYear());
        return lista;
    }

    @Override
    public List<InscripcionDTO> findAllInscripciones() {
        return icr.findAllInscripciones();
    }

    @Override
    public InscripcionCarrera matricular(MatriculacionDTO matriculacionDTO) {
        InscripcionCarrera inscripcion = new InscripcionCarrera();

        // Configurar los datos de la inscripción
        inscripcion.setAntiguedad(matriculacionDTO.getAntiguedad());
        inscripcion.setGraduado(matriculacionDTO.isGraduado());
        inscripcion.setAnioInscripcion(matriculacionDTO.getAnioInscripcion());

        // Configurar la relación con el estudiante y la carrera
        Estudiante estudiante = obtenerEstudiantePorId(matriculacionDTO.getDni(),matriculacionDTO.getLibretaUniversitaria());
        Carrera carrera = obtenerCarreraPorId(matriculacionDTO.getIdCarrera()); // Supongamos que tienes un método para obtener la carrera por su ID.

        inscripcion.setEstudiante(estudiante);
        inscripcion.setCarrera(carrera);

        icr.save(inscripcion);
        return inscripcion;
    }

    private Estudiante obtenerEstudiantePorId(int dni, int libreta){
        return er.buscarPorId(dni,libreta);
    }

    private Carrera obtenerCarreraPorId(int idCarrera){
        return cr.buscarPorId(idCarrera);
    }


}
