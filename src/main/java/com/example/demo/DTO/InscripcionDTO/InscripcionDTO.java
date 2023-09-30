package com.example.demo.DTO.InscripcionDTO;

import com.example.demo.DTO.CarreraDTO.CarreraDTO;
import com.example.demo.DTO.EstudianteDTO.EstudianteDTO;
import com.example.demo.Model.Carrera;
import com.example.demo.Model.Estudiante;

public class InscripcionDTO {
    private String nombreCarrera;
    private int anioInscripcion,antiguedad,dni,libreta;

    public InscripcionDTO(String nombreCarrera, int dni, int libreta, int anioInscripcion, int antiguedad) {
        this.dni = dni;
        this.libreta = libreta;
        this.nombreCarrera = nombreCarrera;
        this.anioInscripcion = anioInscripcion;
        this.antiguedad = antiguedad;
    }

    public int getAnioInscripcion() {
        return anioInscripcion;
    }

    public void setAnioInscripcion(int anioInscripcion) {
        this.anioInscripcion = anioInscripcion;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }


    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getLibreta() {
        return libreta;
    }

    public void setLibreta(int libreta) {
        this.libreta = libreta;
    }
    @Override
    public String toString() {
        return "Estudiante: "+dni+" / "+libreta+". Carrera: "+nombreCarrera+", inscripcion: "+anioInscripcion+", antiguedad: "+antiguedad;
    }
}
