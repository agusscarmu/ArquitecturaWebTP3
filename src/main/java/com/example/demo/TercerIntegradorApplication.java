package com.example.demo;

import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import com.example.demo.Helper.HelperCSV;
import jakarta.annotation.PostConstruct;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.Controller.EstudianteController;
import com.example.demo.Model.Carrera;
import com.example.demo.Model.Estudiante;
import com.example.demo.Model.InscripcionCarrera;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class TercerIntegradorApplication {

	@Autowired
	private HelperCSV cargaCSV;

	public static void main(String[] args) throws IOException{
		ConfigurableApplicationContext applicationContext = SpringApplication.run(TercerIntegradorApplication.class, args);
		
	}

	@PostConstruct
	public void init() throws Exception{
		cargaCSV.InsertarCSV("estudiante.csv", "carrera.csv", "InscripcionCarrera.csv");
	}
}