package com.example.demo.Model.ClavesCompuestas;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class EstudianteId implements Serializable {
    private int dni;
    private int libretaUniversitaria;

    public EstudianteId(int dni, int libretaUniversitaria) {
        this.dni = dni;
        this.libretaUniversitaria = libretaUniversitaria;
    }

    public EstudianteId() {

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
}