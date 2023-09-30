package com.example.demo.Controller;

import com.example.demo.DTO.EstudianteDTO.EstudianteDTO;
import com.example.demo.Services.EstudianteServiceImpl;
import com.example.demo.Services.Interfaces.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Model.Estudiante;

import java.util.List;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService es;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<EstudianteDTO> getEstudiantes(){return es.findAllEstudiantes();}


    @RequestMapping(value="/orderBy/{orden}", method=RequestMethod.GET)
    public List<EstudianteDTO> getByOrder(@PathVariable String orden){
        return es.findAllEstudiantes(orden);
    }

    @RequestMapping(value="/genre/{genero}", method=RequestMethod.GET)
    public List<EstudianteDTO> getByGenero(@PathVariable String genero){
        return es.buscarPorGenero(genero);
    }

    @RequestMapping(value="/getByLibreta/{libreta}", method=RequestMethod.GET)
    public EstudianteDTO getByGenero(@PathVariable int libreta){
        return es.buscarPorLibreta(libreta);
    }

}
