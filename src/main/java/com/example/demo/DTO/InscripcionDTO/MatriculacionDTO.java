package com.example.demo.DTO.InscripcionDTO;

import java.io.Serializable;

public class MatriculacionDTO implements Serializable {

    // Datos del estudiante
    private int dni;
    private int libretaUniversitaria;

    // Datos de la inscripción en la carrera
    private int idCarrera;
    private int antiguedad;
    private int anioInscripcion;
    private boolean graduado;  // Atributo calculado

    // Constructor
    public MatriculacionDTO(int dni, int libretaUniversitaria, int idCarrera) {
        this.dni = dni;
        this.libretaUniversitaria = libretaUniversitaria;
        this.idCarrera = idCarrera;
        this.antiguedad = 0;
        this.anioInscripcion = java.time.LocalDate.now().getYear();
        this.graduado = false;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getLibretaUniversitaria() {
        return libretaUniversitaria;
    }

    public void setLibretaUniversitaria(int libretaUniversitaria) {
        this.libretaUniversitaria = libretaUniversitaria;
    }

    public int getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(int idCarrera) {
        this.idCarrera = idCarrera;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public int getAnioInscripcion() {
        return anioInscripcion;
    }

    public void setAnioInscripcion(int anioInscripcion) {
        this.anioInscripcion = anioInscripcion;
    }

    public boolean isGraduado() {
        return graduado;
    }
}
