package com.example.demo.Controller;

import com.example.demo.DTO.CarreraDTO.CarreraDTO;
import com.example.demo.DTO.CarreraDTO.CarreraInscriptosDTO;
import com.example.demo.DTO.EstudianteDTO.EstudianteDTO;
import com.example.demo.Model.Carrera;
import com.example.demo.Repositories.CarreraRepository;
import com.example.demo.Services.Interfaces.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/carreras")
public class CarreraController {

    @Autowired
    private CarreraService cs;


    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<CarreraDTO> getCarreras(){return cs.findAllCarreras();}

    @RequestMapping(value = "/inscriptos",method = RequestMethod.GET)
    public List<CarreraInscriptosDTO> getCarrerasInscriptos(){return cs.findAllCarrerasInscriptos();}




}
