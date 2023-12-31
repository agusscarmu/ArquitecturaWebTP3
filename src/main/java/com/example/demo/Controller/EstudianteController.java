package com.example.demo.Controller;

import com.example.demo.DTO.EstudianteDTO.EstudianteDTO;
import com.example.demo.Exceptions.EstudianteException;
import com.example.demo.Services.Interfaces.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/nuevo")
    public ResponseEntity<String> crearEstudiante(@RequestBody Estudiante estudiante) {
        try{
            if(es.existeEstudiante(estudiante)){
                throw new EstudianteException("El estudiante ya existe en la base de datos");
            } else if (!idValido(estudiante)) {
                throw new EstudianteException("El estudiante no tiene un id valido");
            }
            es.darAlta(estudiante);
            return ResponseEntity.status(HttpStatus.CREATED).body("Estudiante creado exitosamente");
        }catch (EstudianteException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
        }
    }

    private boolean idValido(Estudiante estudiante){
        return estudiante.getEstudianteId().getDni() > 0 && estudiante.getEstudianteId().getLibretaUniversitaria() > 0;
    }
}
