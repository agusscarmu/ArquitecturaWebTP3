package com.example.demo.Model.ClavesCompuestas;

import com.example.demo.Model.Carrera;
import com.example.demo.Model.Estudiante;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class InscripcionCarreraId implements Serializable {
    private int idCarrera;


    private EstudianteId estudianteId;



    public InscripcionCarreraId(int dni, int libretaUniversitaria, int idCarrera) {
        this.estudianteId=new EstudianteId(dni,libretaUniversitaria);
        this.idCarrera = idCarrera;
    }

    public InscripcionCarreraId() {

    }

    ;
}
