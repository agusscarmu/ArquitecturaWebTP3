package com.example.demo.Model;
import com.example.demo.Model.ClavesCompuestas.InscripcionCarreraId;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
public class InscripcionCarrera {
    @EmbeddedId
    private InscripcionCarreraId inscripcionId;

    @ManyToOne
    @JoinColumn(name = "idCarrera",insertable=false, updatable=false)
    private Carrera carrera;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "dni",insertable=false, updatable=false),
            @JoinColumn(name = "libretaUniversitaria",insertable=false, updatable=false)
    })
    private Estudiante estudiante;


    private int antiguedad;
    private boolean graduado;
    @Getter
    private int anioInscripcion;

    public InscripcionCarrera(int dni, int libretaUniversitaria, int idCarrera, int antiguedad, boolean graduado, int anioInscripcion) {
        this.antiguedad = antiguedad;
        this.graduado = graduado;
        this.anioInscripcion = anioInscripcion;
        this.inscripcionId = new InscripcionCarreraId(dni, libretaUniversitaria, idCarrera);
    }

    public InscripcionCarrera() {

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

    public InscripcionCarreraId getId(){
        return inscripcionId;
    }

    public void setAnioInscripcion(int anioInscripcion) {
        this.anioInscripcion = anioInscripcion;
    }

}