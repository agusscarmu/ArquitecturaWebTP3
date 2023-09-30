package com.example.demo.Repositories;

import com.example.demo.DTO.CarreraDTO.CarreraDTO;
import com.example.demo.Model.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("CarreraRepository")
public interface CarreraRepository  extends JpaRepository<Carrera, Integer> {
    @Query(value = "SELECT NEW com.example.demo.DTO.CarreraDTO.CarreraDTO(c.nombre, c.duracion, c.id) FROM Carrera c")
    Iterable<CarreraDTO> findAllCarreras();
}
