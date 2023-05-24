
package com.codeOpen.biblioteca.repository;

import com.codeOpen.biblioteca.entity.Genero;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Integer>{
    
    
    Optional<Genero> findByNombre(String nombre);
    
    boolean existsByNombre(String nombre);
    
}
