
package com.codeOpen.biblioteca.service;

import com.codeOpen.biblioteca.entity.Autor;
import com.codeOpen.biblioteca.repository.AutorRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AutorService {
    
    @Autowired
    AutorRepository autorRepository;
    
    public List<Autor> list(){
        return autorRepository.findAll();
    }
    
    public Optional<Autor> getOne(int id){
        return autorRepository.findById(id);
    }
    
    public Optional<Autor> getByNombre(String nombre){
        return autorRepository.findByNombre(nombre);
    }
    
    public void save(Autor autor){
        autorRepository.save(autor);
    }
    
    public void delete(int id){
        autorRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return autorRepository.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return autorRepository.existsByNombre(nombre);
    }
}
