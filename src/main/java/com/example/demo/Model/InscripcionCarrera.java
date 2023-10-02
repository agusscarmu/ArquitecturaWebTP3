package com.example.demo.Model;
import com.example.demo.Model.ClavesCompuestas.InscripcionCarreraId;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
public class InscripcionCarrera {
    @EmbeddedId
    private InscripcionCarreraId inscripcionId;

    //ACOMODAR CLAVES
    private int antiguedad;
    private boolean graduado;
    @Getter
    private int anioInscripcion;

    public InscripcionCarrera(int antiguedad, boolean graduado, int anioInscripcion) {
        this.antiguedad = antiguedad;
        this.graduado = graduado;
        this.anioInscripcion = anioInscripcion;
        this.inscripcionId = new InscripcionCarreraId();
    }

    public InscripcionCarrera() {
        this.inscripcionId = new InscripcionCarreraId();
    }


    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public boolean isGraduado() {
        return graduado;
    }

    public void setGraduado(boolean graduado) {
        this.graduado = graduado;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.inscripcionId.setEstudiante(estudiante);
    }

    public void setCarrera(Carrera carrera) {
        this.inscripcionId.setCarrera(carrera);
    }

    public InscripcionCarreraId getId(){
        return inscripcionId;
    }

    public void setAnioInscripcion(int anioInscripcion) {
        this.anioInscripcion = anioInscripcion;
    }
}