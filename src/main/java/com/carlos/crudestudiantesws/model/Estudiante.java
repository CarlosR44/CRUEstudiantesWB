
package com.carlos.crudestudiantesws.model;


public class Estudiante {
    
    private int id;
    private String nombre;
    private String apellido;
    private String pais_codigo;
    private String correo;
    
    public Estudiante(){
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPais_codigo() {
        return pais_codigo;
    }

    public void setPais_codigo(String pais_codigo) {
        this.pais_codigo = pais_codigo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", pais_codigo=" + pais_codigo + ", correo=" + correo + '}';
    }
    
    
    
}

