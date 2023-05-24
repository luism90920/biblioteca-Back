package com.codeOpen.biblioteca.controller;

import com.codeOpen.biblioteca.dto.LibroDto;
import com.codeOpen.biblioteca.dto.Mensaje;
import com.codeOpen.biblioteca.entity.Libro;
import com.codeOpen.biblioteca.service.LibroService;
import io.micrometer.common.util.StringUtils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

@RestController
@RequestMapping("/libro")
@CrossOrigin(origins = "http://localhost:4200")
public class LibroController {

    @Autowired
    LibroService libroService;

    @GetMapping("/lista")
    public ResponseEntity<List<Libro>> list() {
        List<Libro> list = libroService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Libro> getById(@PathVariable int id) {
        if (!libroService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Libro libro = libroService.getOne(id).get();
        return new ResponseEntity(libro, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody LibroDto libroDto) {
        if (StringUtils.isBlank(libroDto.getTitulo())) {
            return new ResponseEntity(new Mensaje("el título es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (libroService.existsByNombre(libroDto.getTitulo())) {
            return new ResponseEntity(new Mensaje("ese título ya existe"), HttpStatus.BAD_REQUEST);
        }
        Libro libro = new Libro(libroDto.getTitulo());
        libroService.save(libro);
        return new ResponseEntity(new Mensaje("libro creado"), HttpStatus.OK);
    }
    
    @PutExchange("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody LibroDto libroDto){
        if (!libroService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        if (libroService.existsByNombre(libroDto.getTitulo()) && libroService.getByNombre(libroDto.getTitulo()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(libroDto.getTitulo())) {
            return new ResponseEntity(new Mensaje("el título es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        Libro libro = libroService.getOne(id).get();
        libro.setTitulo(libroDto.getTitulo());
        libroService.save(libro);
        return new ResponseEntity(new Mensaje("libro modificado"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!libroService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        libroService.delete(id);
        return new ResponseEntity(new Mensaje("libro eliminado"), HttpStatus.OK);
    }

}
