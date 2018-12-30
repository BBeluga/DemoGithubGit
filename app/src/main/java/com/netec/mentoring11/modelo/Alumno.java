package com.netec.mentoring11.modelo;

public class Alumno {
    private int id;
    private String nombre;
    private String correo;
    private float calificacion;
    private String profesor;

    public Alumno(int id, String nombre, String correo, float calificacion, String profesor) {
        setId(id);
        setNombre(nombre);
        setCorreo(correo);
        setCalificacion(calificacion);
        setProfesor(profesor);
    }

    public Alumno() {
        this(1, "SIn nombre", "sin correo", 6.0F, "Sin profesor");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("setID() argumento inválido");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre != null && nombre.trim().length() > 0) {
            this.nombre = nombre;
        } else {
            throw new IllegalArgumentException("setNombre() argumento inválido");
        }
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        if (correo != null && correo.trim().length() > 0) {
            this.correo = correo;
        } else {
            throw new IllegalArgumentException("setCorreo() argumento inválido");
        }

    }

    public float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(float calificacion) {
        if (calificacion > 5) {
            this.calificacion = calificacion;
        } else {
            throw new IllegalArgumentException("setCalificacion() argumento inválido");
        }
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        if (profesor != null && profesor.trim().length() > 0) {
            this.profesor = profesor;
        } else {
            throw new IllegalArgumentException("setProfesor() argumento inválido");
        }
    }

    @Override
    public String toString() {
        return id + " " + nombre + " " + correo + " " + calificacion + " " + profesor;
    }
}
