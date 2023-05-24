
package com.codeOpen.biblioteca.entity;

import com.codeOpen.biblioteca.enumerated.Rol;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;

@Entity
public class Usuario {
    
    @Id
    private int dni;
    
    private String correo;
    private String nombre;
    private String password;
    
    @Enumerated(EnumType.STRING)
    private Rol rol;
    
    @Temporal(TemporalType.DATE)
    private Date alta;
}
