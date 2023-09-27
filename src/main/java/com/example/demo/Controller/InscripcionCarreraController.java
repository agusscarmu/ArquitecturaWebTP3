package com.example.demo.Controller;

import com.example.demo.Model.Carrera;
import com.example.demo.Model.InscripcionCarrera;
import com.example.demo.Repositories.InscripcionCarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InscripcionCarreraController {

    @Autowired
    private InscripcionCarreraRepository icr;

    @GetMapping("/inscripciones")
    public Iterable<InscripcionCarrera> getCarreras(){return icr.findAll();}




}
