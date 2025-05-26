package com.GestionSoporte.GestionSoporte.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.GestionSoporte.GestionSoporte.model.Soporte;
import com.GestionSoporte.GestionSoporte.model.UsuarioDTO;
import com.GestionSoporte.GestionSoporte.repository.SoporteRepository;

@Service
public class SoporteService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private SoporteRepository soporteRepository;

    /*public List<Soporte> obtenerSoportesPorEstado(String estado) { 
        return soporteRepository.findByEstadoSoporte(estado);
    } */

    public Soporte guardarSoporte(Soporte soporte) {
        return soporteRepository.save(soporte);
    }

    public void eliminarSoporte(Long id) {
        soporteRepository.deleteAll();
    }

    public List<Soporte> obtenerTickets() {
        return soporteRepository.findAll();
    }

    public Soporte asignarUsuarioTicket(Integer idSoporte, String usuarioId) {
        
        /*EL USUARIO ESTA USANDO EL PUERTO 8081 */
        String url="http://localhost:8081/api/usuario/" + usuarioId;
        UsuarioDTO usuario = restTemplate.getForObject(url, UsuarioDTO.class);

        if(usuario != null){
            Soporte sup = findxIdSoporte(idSoporte);
            sup.setUsuarioAsignado(usuario.getNombre() + " " + usuario.getApellido());

            if(sup != null) {
                sup.setIdUsuario(usuario.getIdUsuario());
                return soporteRepository.save(sup);
            }

        }     
    
      
        return null;
    }

    public Soporte findxIdSoporte(int idSoporte) {
        // Si la repo declara Optional<Seccion> findById(...), hacer:
        Optional<Soporte> opt = soporteRepository.findById(idSoporte);
        return opt.orElse(null);
    }

    

 
    
}



