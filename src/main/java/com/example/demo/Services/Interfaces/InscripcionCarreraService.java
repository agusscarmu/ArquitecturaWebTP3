package com.example.demo.Services.Interfaces;

import com.example.demo.DTO.EstudianteDTO.EstudianteDTO;
import com.example.demo.DTO.InscripcionDTO.InscripcionDTO;
import com.example.demo.DTO.InscripcionDTO.InscripcionesPorAnioDTO;
import com.example.demo.DTO.InscripcionDTO.MatriculacionDTO;
import com.example.demo.Model.InscripcionCarrera;

import java.util.List;

public interface InscripcionCarreraService {

    List<EstudianteDTO> obtenerEstudiantesPorCarreraYCiudad(int idCarrera, String ciudad);

    List<InscripcionesPorAnioDTO> obtenerReporte();

    List<InscripcionDTO> findAllInscripciones();

    InscripcionCarrera matricular(MatriculacionDTO matriculacionDTO);
}
