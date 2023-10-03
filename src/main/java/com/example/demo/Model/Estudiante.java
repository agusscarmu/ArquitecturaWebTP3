package com.example.demo.Model;

import java.util.LinkedList;
import java.util.List;

import com.example.demo.Model.ClavesCompuestas.EstudianteId;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;

@Getter
@Entity
public class Estudiante {
    @EmbeddedId
    private EstudianteId estudianteId;
    private String nombre;
    private String apellido;
    private int edad;
    private String genero;
    private String ciudad;

    @OneToMany(mappedBy = "estudiante")
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setInscripciones(List<InscripcionCarrera> inscripciones) {
        this.inscripciones = inscripciones;
    }

    @Override
    public String toString() {
        return nombre+", "+apellido+"\n";
    }

    public void setEstudianteId(EstudianteId estudianteId) {
        this.estudianteId = estudianteId;
    }
}