package com.example.demo.Repositories;

import com.example.demo.DTO.EstudianteDTO.EstudianteDTO;
import com.example.demo.DTO.InscripcionDTO.InscripcionDTO;
import com.example.demo.DTO.InscripcionDTO.InscripcionesPorAnioDTO;
import com.example.demo.Model.InscripcionCarrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("InscripcionCarreraRepository")
public interface InscripcionCarreraRepository extends JpaRepository<InscripcionCarrera, Integer> {

    @Query(value = "SELECT NEW com.example.demo.DTO.InscripcionDTO.InscripcionDTO(ic.carrera.nombre ,ic.estudiante.estudianteId.dni, ic.estudiante.estudianteId.libretaUniversitaria , ic.anioInscripcion, ic.antiguedad) FROM InscripcionCarrera ic")
    List<InscripcionDTO> findAllInscripciones();

    @Query(value = "SELECT NEW com.example.demo.DTO.EstudianteDTO.EstudianteDTO(e.estudianteId.dni, e.estudianteId.libretaUniversitaria, e.edad, e.nombre, e.apellido, e.genero, e.ciudad) FROM InscripcionCarrera i INNER JOIN Estudiante e ON e = i.estudiante WHERE i.carrera.id = :idCarrera AND e.ciudad = :ciudad")
    List<EstudianteDTO> findAllEstudiantesCarreraCiudad(@Param("idCarrera") int idCarrera, @Param("ciudad") String ciudad);

    @Query("SELECT NEW com.example.demo.DTO.InscripcionDTO.InscripcionesPorAnioDTO(c.nombre, :y, " +
            "(SELECT COUNT(i) FROM InscripcionCarrera i WHERE i.carrera = c AND i.anioInscripcion = :y), " +
            "(SELECT COUNT(i) FROM InscripcionCarrera i WHERE i.carrera = c AND i.graduado = true AND (i.anioInscripcion + i.antiguedad) = :y)) " +
            "FROM Carrera c " +
            "WHERE (SELECT COUNT(i) FROM InscripcionCarrera i WHERE i.carrera = c AND i.anioInscripcion = :y) > 0 " +
            "   OR (SELECT COUNT(i) FROM InscripcionCarrera i WHERE i.carrera = c AND i.graduado = true AND (i.anioInscripcion + i.antiguedad) = :y) > 0")
    List<InscripcionesPorAnioDTO> obtenerReporteCarrera(@Param("y") int y);

    @Query("SELECT MIN(i.anioInscripcion) FROM InscripcionCarrera i")
    Integer obtenerPrimerInscripcion();

    @Query(value = "SELECT NEW com.example.demo.DTO.InscripcionDTO.InscripcionDTO(ic.carrera.nombre ,ic.estudiante.estudianteId.dni, ic.estudiante.estudianteId.libretaUniversitaria , ic.anioInscripcion, ic.antiguedad) FROM InscripcionCarrera ic WHERE ic.inscripcionId.estudianteId.dni = :dni AND ic.inscripcionId.estudianteId.libretaUniversitaria = :libretaUniversitaria AND ic.inscripcionId.idCarrera = :idCarrera")
    InscripcionDTO buscarPorId(@Param("dni") int dni,@Param("libretaUniversitaria") int libretaUniversitaria, @Param("idCarrera") int idCarrera);

}
