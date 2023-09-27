package com.example.demo.Repositories;

import com.example.demo.Model.InscripcionCarrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("InscripcionCarreraRepository")
public interface InscripcionCarreraRepository extends JpaRepository<InscripcionCarrera, Integer> {
}
