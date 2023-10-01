package com.example.demo.DTO.InscripcionDTO;

import java.io.Serializable;

public class InscripcionesPorAnioDTO implements Serializable {
    private String nombreCarrera;
    private int anio;
    private long inscriptos;
    private long egresados;

    public InscripcionesPorAnioDTO(String nombreCarrera, int anio, long inscriptos, long egresados) {
        this.nombreCarrera = nombreCarrera;
        this.anio = anio;
        this.inscriptos = inscriptos;
        this.egresados = egresados;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }


    public int getAnio() {
        return anio;
    }


    public long getInscriptos() {
        return inscriptos;
    }


    public long getEgresados() {
        return egresados;
    }


    @Override
    public String toString() {
        return nombreCarrera+"\t|\t"+anio+", cantidad inscriptos: "+inscriptos+", cantidad egresados: "+egresados+"\n";
    }
}
