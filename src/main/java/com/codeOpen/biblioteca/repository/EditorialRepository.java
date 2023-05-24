
package com.codeOpen.biblioteca.repository;

import com.codeOpen.biblioteca.entity.Editorial;
import com.codeOpen.biblioteca.entity.Genero;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditorialRepository extends JpaRepository<Editorial, Integer>{
    
    Optional<Genero> findByNombre(String nombre);
    
    boolean existsByNombre(String nombre);
    
}
