package com.example.demo.Repositories;

import com.example.demo.DTO.CarreraDTO.CarreraDTO;
import com.example.demo.DTO.CarreraDTO.CarreraInscriptosDTO;
import com.example.demo.Model.Carrera;
import com.example.demo.Model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("CarreraRepository")
public interface CarreraRepository  extends JpaRepository<Carrera, Integer> {
    @Query(value = "SELECT NEW com.example.demo.DTO.CarreraDTO.CarreraDTO(c.nombre, c.duracion, c.id) FROM Carrera c")
    List<CarreraDTO> findAllCarreras();

    @Query(value = "SELECT NEW com.example.demo.DTO.CarreraDTO.CarreraInscriptosDTO(c.nombre, COUNT(i), c.duracion) FROM Carrera c LEFT JOIN c.inscripciones i GROUP BY c.nombre ORDER BY COUNT(i) DESC")
    List<CarreraInscriptosDTO> findCarrerasInscriptos();

    @Query(value = "SELECT * FROM Carrera WHERE id = :idCarrera", nativeQuery = true)
    Carrera buscarPorId(@Param("idCarrera") int idCarrera);
}
