package com.example.demo.Repositories;

import com.example.demo.Model.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("CarreraRepository")
public interface CarreraRepository  extends JpaRepository<Carrera, Integer> {



}
