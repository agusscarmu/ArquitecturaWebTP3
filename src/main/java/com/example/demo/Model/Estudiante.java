package com.example.demo.Model;

import java.util.LinkedList;
import java.util.List;

import com.example.demo.Model.ClavesCompuestas.EstudianteId;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Estudiante {
    @EmbeddedId
    private EstudianteId estudianteId;
    private String nombre;
    private String apellido;
    private int edad;
    private String genero;
    private String ciudad;

    @OneToMany(mappedBy = "inscripcionId.estudiante")
    private List<InscripcionCarrera> inscripciones;

    public Estudiante(int dni, int libretaUniversitaria, String nombre, String apellido, int edad, String genero, String ciudad){
        this.estudianteId = new EstudianteId(dni, libretaUniversitaria);
        this.apellido=apellido;
        this.nombre=nombre;
        this.edad=edad;
        this.genero=genero;
        this.ciudad=ciudad;
        this.inscripciones = new LinkedList<>();
    }

    public Estudiante() {
        this.inscripciones = new LinkedList<>();
    }


    public void addInscripcion(InscripcionCarrera inscripcion){
        if(!inscripciones.contains(inscripcion)){
            inscripciones.add(inscripcion);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public List<InscripcionCarrera> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(List<InscripcionCarrera> inscripciones) {
        this.inscripciones = inscripciones;
    }

    @Override
    public String toString() {
        return nombre+", "+apellido+"\n";
    }

    public EstudianteId getEstudianteId() {
        return estudianteId;
    }

    public void setEstudianteId(EstudianteId estudianteId) {
        this.estudianteId = estudianteId;
    }
}