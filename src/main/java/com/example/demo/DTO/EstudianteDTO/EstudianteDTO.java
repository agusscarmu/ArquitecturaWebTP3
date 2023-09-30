package com.example.demo.DTO.EstudianteDTO;

public class EstudianteDTO {
    private int dni,libreta,edad;
    private String nombre,apellido,genero,ciudad;

    public EstudianteDTO(int dni, int libreta, int edad, String nombre, String apellido, String genero, String ciudad) {
        this.dni = dni;
        this.libreta = libreta;
        this.edad = edad;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.ciudad = ciudad;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
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

    @Override
    public String toString() {
        return "dni: "+dni+", libreta: "+libreta+", nombre y apellido: "+nombre+", "+apellido+", edad: "+edad+", genero: "+genero+", ciudad:"+ciudad;
    }
}
