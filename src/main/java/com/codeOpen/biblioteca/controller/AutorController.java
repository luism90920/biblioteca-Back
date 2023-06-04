
package com.codeOpen.biblioteca.controller;

import com.codeOpen.biblioteca.dto.AutorDto;
import com.codeOpen.biblioteca.dto.Mensaje;
import com.codeOpen.biblioteca.entity.Autor;
import com.codeOpen.biblioteca.entity.Libro;
import com.codeOpen.biblioteca.service.AutorService;
import io.micrometer.common.util.StringUtils;
import java.util.List;
import org.aspectj.weaver.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autor")
@CrossOrigin(origins = "http://localhost:4200")
public class AutorController {
    
    @Autowired
    AutorService autorService;
    
    
    @GetMapping("/lista")
    public ResponseEntity<List<Autor>> list() {
        List<Autor> autor = autorService.list();
        return new ResponseEntity(autor, HttpStatus.OK); 
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Autor> getById(@PathVariable int id){
        if(!autorService.existsById(id)){
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Autor autor = autorService.getOne(id).get();
        return new ResponseEntity(autor, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody AutorDto autorDto){
        if(StringUtils.isBlank(autorDto.getNombre())){
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(autorService.existsByNombre(autorDto.getNombre())){
            return new ResponseEntity(new Mensaje("el nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        Autor autor = new Autor(autorDto.getNombre());
        autorService.save(autor);
        return new ResponseEntity(new Mensaje("autor creado"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody AutorDto autorDto, @PathVariable int id){
        if(!autorService.existsById(id)){
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        if(autorService.existsByNombre(autorDto.getNombre()) && autorService.getByNombre(autorDto.getNombre()).get().getId() != id){
            return new ResponseEntity(new Mensaje("el nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(autorDto.getNombre())){
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Autor autor = autorService.getOne(id).get();
        autor.setNombre(autorDto.getNombre());
        autorService.save(autor);
        return new ResponseEntity(new Mensaje("autor modificado"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        if(!autorService.existsById(id)){
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        autorService.delete(id);
        return new ResponseEntity(new Mensaje("autor eliminado"), HttpStatus.OK);
    }
}
