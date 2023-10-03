package com.example.demo.Helper;

import com.example.demo.Controller.EstudianteController;
import com.example.demo.Model.Carrera;
import com.example.demo.Model.Estudiante;
import com.example.demo.Model.InscripcionCarrera;
import com.example.demo.Repositories.CarreraRepository;
import com.example.demo.Repositories.EstudianteRepository;
import com.example.demo.Repositories.InscripcionCarreraRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@Component
public class HelperCSV {
    private List<Estudiante> estudiantes = new LinkedList<>();
    private List<Carrera> carreras = new LinkedList<>();
    private List<InscripcionCarrera> inscripciones = new LinkedList<>();
    private final EstudianteRepository er;
    private final CarreraRepository cr;
    private final InscripcionCarreraRepository icr;

    @Autowired
    public HelperCSV(EstudianteRepository er, CarreraRepository cr, InscripcionCarreraRepository icr){
        this.er=er;
        this.cr=cr;
        this.icr=icr;
    }

    public void InsertarCSV(String csvEstudiante, String csvCarrera, String csvInscripcionCarrera) throws IOException {



        String csvFilePath = System.getProperty("user.dir") + "/" + csvEstudiante;
        CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(csvFilePath));

        for (CSVRecord row : parser) {
            Estudiante estudiante = new Estudiante(Integer.parseInt(row.get("dni")), Integer.parseInt(row.get("libreta")), row.get("nombre"), row.get("apellido"), Integer.parseInt(row.get("edad")), row.get("genero"), row.get("ciudad"));
            er.save(estudiante);
        }

        csvFilePath = System.getProperty("user.dir") + "/" + csvCarrera;
        parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(csvFilePath));

        for (CSVRecord row : parser) {
            Carrera carrera = new Carrera(Integer.parseInt(row.get("id")),row.get("nombre"), Integer.parseInt(row.get("duracion")));
            cr.save(carrera);
        }

        csvFilePath = System.getProperty("user.dir") + "/" + csvInscripcionCarrera;
        parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(csvFilePath));

        for (CSVRecord row : parser) {
            InscripcionCarrera ic = new InscripcionCarrera(Integer.parseInt(row.get("dni")),Integer.parseInt(row.get("libretaUniversitaria")),Integer.parseInt(row.get("carrera")),Integer.parseInt(row.get("antiguedad")),row.get("graduado").equals("true"),Integer.parseInt(row.get("anioIngreso")));
            icr.save(ic);
        }
    }


}
