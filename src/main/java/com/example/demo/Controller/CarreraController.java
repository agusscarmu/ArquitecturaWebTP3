package com.example.demo.Controller;

import com.example.demo.DTO.CarreraDTO.CarreraDTO;
import com.example.demo.Model.Carrera;
import com.example.demo.Repositories.CarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarreraController {

    @Autowired
    private CarreraRepository cr;


    @GetMapping("/carreras")
    public Iterable<CarreraDTO> getCarreras(){return cr.findAllCarreras();}

}
