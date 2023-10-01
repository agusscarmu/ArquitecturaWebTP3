package com.example.demo.Services.Interfaces;

import com.example.demo.DTO.EstudianteDTO.EstudianteDTO;
import com.example.demo.Model.Estudiante;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EstudianteService {

    List<EstudianteDTO> findAllEstudiantes();

    List<EstudianteDTO> findAllEstudiantes(String orden);

    List<EstudianteDTO> buscarPorGenero(String genero);

    EstudianteDTO buscarPorLibreta(int libreta);

    Estudiante darAlta(Estudiante estudiante);


}
