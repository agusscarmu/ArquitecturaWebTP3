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

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "dni", referencedColumnName = "dni"),
            @JoinColumn(name = "libretaUniversitaria", referencedColumnName = "libretaUniversitaria")
    })
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "carrera", referencedColumnName = "id")
    private Carrera carrera;

    // Constructores, getters y setters

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InscripcionCarreraId)) return false;
        InscripcionCarreraId that = (InscripcionCarreraId) o;
        return Objects.equals(estudiante, that.estudiante) &&
                Objects.equals(carrera, that.carrera);
    }

    @Override
    public int hashCode() {
        return Objects.hash(estudiante, carrera);
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }
}
