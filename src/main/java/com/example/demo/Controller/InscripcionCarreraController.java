package com.example.demo.Controller;

import com.example.demo.DTO.InscripcionDTO.InscripcionDTO;
import com.example.demo.Repositories.InscripcionCarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InscripcionCarreraController {

    @Autowired
    private InscripcionCarreraRepository icr;

    @GetMapping("/inscripciones")
    public Iterable<InscripcionDTO> getCarreras(){return icr.findAllInscripciones();}




}
