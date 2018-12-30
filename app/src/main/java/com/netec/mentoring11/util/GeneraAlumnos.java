package com.netec.mentoring11.util;

import com.netec.mentoring11.modelo.Alumno;

import java.util.ArrayList;
import java.util.List;

// Singlenton
public class GeneraAlumnos {
    private static final GeneraAlumnos instancia = new GeneraAlumnos();
    private static List<Alumno> lista;

    private GeneraAlumnos() {
        lista = new ArrayList<Alumno>() {{
            add(new Alumno(1, "Axel", "axel@gmail.com", 10F, "Blanca Escamilla"));
            add(new Alumno(2, "Diana", "axel@gmail.com", 10F, "Blanca Escamilla"));
            add(new Alumno(3, "Erika", "axel@gmail.com", 10F, "Blanca Escamilla"));
            add(new Alumno(4, "Ivonne", "axel@gmail.com", 10F, "Blanca Escamilla"));
            add(new Alumno(5, "Jesús", "axel@gmail.com", 10F, "Blanca Escamilla"));
            add(new Alumno(6, "José Luis", "axel@gmail.com", 10F, "Blanca Escamilla"));
            add(new Alumno(7, "Alberto", "axel@gmail.com", 10F, "Blanca Escamilla"));
            add(new Alumno(8, "Irving", "axel@gmail.com", 10F, "Blanca Escamilla"));
        }};
    }

    public List<Alumno> getAlumnos() {
        return lista;
    }

    public static GeneraAlumnos getInstancia() {
        return instancia;
    }
}
