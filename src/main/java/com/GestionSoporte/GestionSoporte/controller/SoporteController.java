package com.GestionSoporte.GestionSoporte.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.GestionSoporte.GestionSoporte.model.Soporte;

import com.GestionSoporte.GestionSoporte.service.SoporteService;


@RestController
@RequestMapping("/api/soporte") //localhost:8081/api/soporte?estado=pendiente

public class SoporteController {

    

    
    @Autowired
    private SoporteService soporteService;

    /*//Endpointpara obtener los soportes
    @GetMapping("/tickets") 
    public List<Soporte> obtenerSoportesPorEstado(@RequestParam String estado) {
        return soporteService.obtenerSoportesPorEstado(estado);
    }      */

    @GetMapping
    public List<Soporte> getSoporte(){
        return soporteService.obtenerTickets();
    }
   
    @PostMapping
    public Soporte crearSoporte(@RequestBody Soporte soporte) {
        return soporteService.guardarSoporte(soporte);
    }

    @DeleteMapping("/{idSoporte}")
    public void eliminarSoporte(@PathVariable int idSoporte) {
        soporteService.eliminarIdSoporte(idSoporte);
    } 


    // Asignar usuario al ticket

    @PutMapping("/{idSoporte}/usuarioAsignado/{usuarioId}")
    public ResponseEntity <Soporte> asignarTicket(@PathVariable Integer idSoporte, @PathVariable String usuarioId ){
        Soporte soporteActualizado = soporteService.asignarUsuarioTicket(idSoporte, usuarioId);
        if(soporteActualizado != null){
            return new ResponseEntity<>(soporteActualizado, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //falta modificar el ticket

    @PutMapping("/{idSoporte}")
    public ResponseEntity<Soporte> putSoporte(@PathVariable Integer idSoporte, @RequestBody Soporte soporte) {
        Soporte actualizado = soporteService.editSoporte(idSoporte, soporte);
        if (actualizado != null) {
            return new ResponseEntity<>(actualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    


    
}


