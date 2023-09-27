package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Model.Estudiante;
import com.example.demo.Repositories.EstudianteRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EstudianteController {

    @Autowired
    private EstudianteRepository er;

    @GetMapping("/estudiantes")
    public Iterable<Estudiante> getEstudiantes(){return er.findAll();}

    @GetMapping("/estudiantePorNombre/{name}")
    public Iterable<Estudiante> getEstudianteByName(@PathVariable String name){
        return er.buscarPorNombre(name);
    }

    @PostMapping("/estudiante")
    public Estudiante newEstudiante(Estudiante estudiante){
        return er.save(estudiante);
    }

    @GetMapping("/saludo")
    public String saludo(){
        return "HOLA";
    }

}
