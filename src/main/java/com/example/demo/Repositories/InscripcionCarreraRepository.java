package com.example.demo.Repositories;

import com.example.demo.DTO.InscripcionDTO.InscripcionDTO;
import com.example.demo.Model.InscripcionCarrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("InscripcionCarreraRepository")
public interface InscripcionCarreraRepository extends JpaRepository<InscripcionCarrera, Integer> {

    @Query(value = "SELECT NEW com.example.demo.DTO.InscripcionDTO.InscripcionDTO(ic.inscripcionId.carrera.nombre ,ic.inscripcionId.estudiante.estudianteId.dni, ic.inscripcionId.estudiante.estudianteId.libretaUniversitaria , ic.anioInscripcion, ic.antiguedad) FROM InscripcionCarrera ic")
    Iterable<InscripcionDTO> findAllInscripciones();
}
