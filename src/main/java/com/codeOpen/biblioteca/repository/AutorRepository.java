
package com.codeOpen.biblioteca.repository;

import com.codeOpen.biblioteca.entity.Autor;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer> {
    
    //Buscar por nombre
    Optional<Autor> findByNombre(String nombre);
    
    boolean existsByNombre(String nombre);
}
