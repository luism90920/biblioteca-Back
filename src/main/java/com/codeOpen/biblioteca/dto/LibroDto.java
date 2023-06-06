
package com.codeOpen.biblioteca.dto;

import com.codeOpen.biblioteca.entity.Autor;


public class LibroDto {
    
    private String titulo;
    
    private String nombreAutor;

    public LibroDto() {
    }

    public LibroDto(String titulo, String nombreAutor) {
        this.titulo = titulo;
        this.nombreAutor = nombreAutor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    
    
    
    
    
}
