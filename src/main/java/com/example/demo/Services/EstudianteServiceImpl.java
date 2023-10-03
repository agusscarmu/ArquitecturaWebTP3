package com.example.demo.Services;

import com.example.demo.DTO.EstudianteDTO.EstudianteDTO;
import com.example.demo.Model.Estudiante;
import com.example.demo.Repositories.EstudianteRepository;
import com.example.demo.Services.Interfaces.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    @Autowired
    private EstudianteRepository er;

    @Override
    public List<EstudianteDTO> findAllEstudiantes() {
        return er.findAllEstudiantes();
    }

    @Override
    public List<EstudianteDTO> findAllEstudiantes(String orden) {
        return switch (orden) {
            case "apellido" -> er.findAllOrderByApellido();
            case "edad" -> er.findAllOrderByEdad();
            case "libreta" -> er.findAllOrderByLibreta();
            case "ciudad" -> er.findAllOrderByCiudad();
            default -> er.findAllEstudiantes();
        };
    }

    @Override
    public List<EstudianteDTO> buscarPorGenero(String genero) {
        return er.buscarPorGenero(genero);
    }

    @Override
    public EstudianteDTO buscarPorLibreta(int libreta) {
        return er.buscarPorLibretaUniversitaria(libreta);
    }

    @Override
    public Estudiante darAlta(Estudiante estudiante) {
        er.save(estudiante);
        return estudiante;
    }

    @Override
    public boolean existeEstudiante(Estudiante estudiante) {
        return er.buscarPorId(estudiante.getEstudianteId().getDni(),estudiante.getEstudianteId().getLibretaUniversitaria())!=null;
    }
}
