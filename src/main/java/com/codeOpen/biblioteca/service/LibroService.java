
package com.codeOpen.biblioteca.service;

import com.codeOpen.biblioteca.entity.Libro;
import com.codeOpen.biblioteca.repository.LibroRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class LibroService {
    
    @Autowired
    LibroRepository libroRepository;
    
    public List<Libro> list(){
        return libroRepository.findAll();
    }
    
    public Optional<Libro> getOne(int id){
        return libroRepository.findById(id);
    }
    
    public Optional<Libro> getByTitulo(String titulo){
        return libroRepository.findByTitulo(titulo);
    }
    
    public Optional<Libro> getByAutor(String autor){
        return libroRepository.findByAutor(autor);
    }
    
    public Optional<Libro> getByGenero(String genero){
        return libroRepository.findByGenero(genero);
    }
    
    public void save(Libro libro){
        libroRepository.save(libro);
    }
    
    public void delete(int id){
        libroRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return libroRepository.existsById(id);
    }
    
    public boolean existsByTitulo(String titulo){
        return libroRepository.existsByTitulo(titulo);
    }
    
    public boolean existsByAutor(String autor){
        return libroRepository.existsByAutor(autor);
    }
    
    public boolean existsByGenero(String genero){
        return libroRepository.existsByGenero(genero);
    }
    
}
