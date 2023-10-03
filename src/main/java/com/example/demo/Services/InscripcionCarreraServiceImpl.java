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

    @Override
    public List<EstudianteDTO> obtenerEstudiantesPorCarreraYCiudad(int idCarrera, String ciudad) {
        return icr.findAllEstudiantesCarreraCiudad(idCarrera,ciudad);
    }

    @Override
    public List<InscripcionesPorAnioDTO> obtenerReporte() {
        List<InscripcionesPorAnioDTO> lista = new LinkedList<>();

        for(int y = icr.obtenerPrimerInscripcion(); y < java.time.LocalDate.now().getYear() + 1; y++){
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
        InscripcionCarrera inscripcion = new InscripcionCarrera(matriculacionDTO.getDni(),matriculacionDTO.getLibretaUniversitaria(),matriculacionDTO.getIdCarrera(),matriculacionDTO.getAntiguedad(),matriculacionDTO.isGraduado(),matriculacionDTO.getAnioInscripcion());

        inscripcion.setAntiguedad(matriculacionDTO.getAntiguedad());
        inscripcion.setGraduado(matriculacionDTO.isGraduado());
        inscripcion.setAnioInscripcion(matriculacionDTO.getAnioInscripcion());

        icr.save(inscripcion);
        return inscripcion;
    }

    @Override
    public boolean existeInscripcion(MatriculacionDTO matriculacionDTO) {
        return icr.buscarPorId(matriculacionDTO.getDni(),matriculacionDTO.getLibretaUniversitaria(),matriculacionDTO.getIdCarrera())!=null;
    }


}
