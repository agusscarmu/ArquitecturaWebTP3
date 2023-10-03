package com.example.demo.Repositories;

import com.example.demo.DTO.EstudianteDTO.EstudianteDTO;
import com.example.demo.Model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("EstudianteRepository")
public interface EstudianteRepository extends JpaRepository<Estudiante, Integer>{

    @Query(value = "SELECT NEW com.example.demo.DTO.EstudianteDTO.EstudianteDTO(e.estudianteId.dni, e.estudianteId.libretaUniversitaria, e.edad, e.nombre, e.apellido, e.genero, e.ciudad) FROM Estudiante e WHERE e.estudianteId.libretaUniversitaria = :libretaUniversitaria")
    EstudianteDTO buscarPorLibretaUniversitaria(@Param("libretaUniversitaria") int libretaUniversitaria);

    @Query(value = "SELECT NEW com.example.demo.DTO.EstudianteDTO.EstudianteDTO(e.estudianteId.dni, e.estudianteId.libretaUniversitaria, e.edad, e.nombre, e.apellido, e.genero, e.ciudad) FROM Estudiante e WHERE e.genero = :genero")
    List<EstudianteDTO> buscarPorGenero(@Param("genero") String genero);

    @Query(value = "SELECT * FROM Estudiante WHERE dni = :dni AND libreta_universitaria = :libretaUniversitaria", nativeQuery = true)
    Estudiante buscarPorId(@Param("dni") int dni,@Param("libretaUniversitaria") int libretaUniversitaria);

    @Query(value = "SELECT NEW com.example.demo.DTO.EstudianteDTO.EstudianteDTO(e.estudianteId.dni, e.estudianteId.libretaUniversitaria, e.edad, e.nombre, e.apellido, e.genero, e.ciudad) FROM Estudiante e ORDER BY e.estudianteId.dni")
    List<EstudianteDTO> findAllEstudiantes();

    @Query(value = "SELECT NEW com.example.demo.DTO.EstudianteDTO.EstudianteDTO(e.estudianteId.dni, e.estudianteId.libretaUniversitaria, e.edad, e.nombre, e.apellido, e.genero, e.ciudad) FROM Estudiante e ORDER BY e.estudianteId.libretaUniversitaria")
    List<EstudianteDTO> findAllOrderByLibreta();

    @Query(value = "SELECT NEW com.example.demo.DTO.EstudianteDTO.EstudianteDTO(e.estudianteId.dni, e.estudianteId.libretaUniversitaria, e.edad, e.nombre, e.apellido, e.genero, e.ciudad) FROM Estudiante e ORDER BY e.apellido")
    List<EstudianteDTO> findAllOrderByApellido();

    @Query(value = "SELECT NEW com.example.demo.DTO.EstudianteDTO.EstudianteDTO(e.estudianteId.dni, e.estudianteId.libretaUniversitaria, e.edad, e.nombre, e.apellido, e.genero, e.ciudad) FROM Estudiante e ORDER BY e.edad")
    List<EstudianteDTO> findAllOrderByEdad();

    @Query(value = "SELECT NEW com.example.demo.DTO.EstudianteDTO.EstudianteDTO(e.estudianteId.dni, e.estudianteId.libretaUniversitaria, e.edad, e.nombre, e.apellido, e.genero, e.ciudad) FROM Estudiante e ORDER BY e.ciudad")
    List<EstudianteDTO> findAllOrderByCiudad();

}

    
    

