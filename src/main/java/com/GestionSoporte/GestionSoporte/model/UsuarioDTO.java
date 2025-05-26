package com.GestionSoporte.GestionSoporte.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

@Data
public class UsuarioDTO {
    
    
    private int idUsuario;    
    
    private String nombre;

    private String apellido;

    private String email;
    
}
