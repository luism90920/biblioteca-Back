package com.codeOpen.biblioteca.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;

@Entity
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String titulo;
    
    @ManyToOne
    private Genero genero;
    
    @ManyToOne
    private Editorial editorial;
    
    @ManyToOne
    private Autor autor;

    

    public Libro() {
    }

    public Libro(String titulo, Autor autor) {
        this.titulo = titulo;
        this.autor = autor;
    }
    
    

    public Libro(int id, String titulo, Genero genero, Editorial editorial, Autor autor) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.editorial = editorial;
        this.autor = autor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    
}
