package com.example.demo.Controller;

import com.example.demo.DTO.EstudianteDTO.EstudianteDTO;
import com.example.demo.DTO.InscripcionDTO.InscripcionDTO;
import com.example.demo.DTO.InscripcionDTO.InscripcionesPorAnioDTO;
import com.example.demo.DTO.InscripcionDTO.MatriculacionDTO;
import com.example.demo.Exceptions.EstudianteInexistenteException;
import com.example.demo.Exceptions.EstudianteInscriptoException;
import com.example.demo.Services.Interfaces.InscripcionCarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inscripciones")
public class InscripcionCarreraController {

    @Autowired
    private InscripcionCarreraService icr;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public Iterable<InscripcionDTO> getCarreras(){return icr.findAllInscripciones();}

    @RequestMapping(value = "/filter/{ciudad}/{idCarrera}", method = RequestMethod.GET)
    public List<EstudianteDTO> getEstudiantesCarreraCiudad(@PathVariable int idCarrera, @PathVariable String ciudad) {
        return icr.obtenerEstudiantesPorCarreraYCiudad(idCarrera, ciudad);
    }

    @RequestMapping(value = "/reporte", method = RequestMethod.GET)
    public List<InscripcionesPorAnioDTO> getReporte(){
        return icr.obtenerReporte();
    }

    @PostMapping("/matricular")
    public ResponseEntity<String> matricularEstudiante(@RequestBody MatriculacionDTO matriculacionDTO){

        try{
            if(icr.existeInscripcion(matriculacionDTO)){
                throw new EstudianteInscriptoException("El estudiante ya se encuentra inscripto en la carrera");
            }else{
                icr.matricular(matriculacionDTO);

                return ResponseEntity.status(HttpStatus.CREATED).body("Estudiante matriculado exitosamente");
            }
        } catch (EstudianteInscriptoException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
        } catch (DataIntegrityViolationException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: El estudiante no existe en la base de datos o hay un problema de integridad de datos");
        }
    }






}
