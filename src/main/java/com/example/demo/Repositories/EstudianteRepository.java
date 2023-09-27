package com.example.demo.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Model.Estudiante;
import org.springframework.stereotype.Repository;

@Repository("EstudianteRepository")
public interface EstudianteRepository extends JpaRepository<Estudiante, Integer>{

    @Query(value = "INSERT INTO Estudiante (nombre, apellido, dni, libreta_universitaria, genero, edad, ciudad) VALUES (:nombre, :apellido, :dni, :libretaUniversitaria, :genero, :edad, :ciudad)", nativeQuery = true)
    void insertarEstudiante(@Param("nombre") String nombre, @Param("apellido") String apellido, @Param("dni") int dni,@Param("libretaUniversitaria") int libretaUniversitaria, @Param("genero") String genero, @Param("edad") int edad, @Param("ciudad") String ciudad);

    @Query(value = "SELECT * FROM Estudiante WHERE libreta_universitaria = :libretaUniversitaria", nativeQuery = true)
    Estudiante buscarPorLibretaUniversitaria(@Param("libretaUniversitaria") String libretaUniversitaria);
    @Query(value = "SELECT * FROM Estudiante WHERE nombre = :nombre", nativeQuery=true)
    List<Estudiante> buscarPorNombre(@Param("nombre") String nombre);
    @Query(value = "SELECT * FROM Estudiante ORDER BY nombre ASC", nativeQuery = true)
    List<Estudiante> buscarTodosOrdenadosPorNombre();

    @Query(value = "SELECT * FROM Estudiante WHERE genero = :genero", nativeQuery = true)
    List<Estudiante> buscarPorGenero(@Param("genero") String genero);

    @Query(value = "SELECT * FROM Estudiante WHERE dni = :dni AND libreta_universitaria = :libretaUniversitaria", nativeQuery = true)
    Estudiante buscarPorId(@Param("dni") int dni,@Param("libretaUniversitaria") int libretaUniversitaria);
}

    
    

