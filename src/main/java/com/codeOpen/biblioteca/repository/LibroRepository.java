
package com.codeOpen.biblioteca.repository;

import com.codeOpen.biblioteca.entity.Libro;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer>{
    
    //Buscar por nombre
    Optional<Libro> findByTitulo(String titulo);
    
    //Buscar por autor
    Optional<Libro> findByAutor(String autor);
    
    //Buscar por género
    Optional<Libro> findByGenero(String genero);
    
    boolean existsByTitulo(String titulo);
    
    boolean existsByAutor(String autor);
    
    boolean existsByGenero(String genero);
    
}
