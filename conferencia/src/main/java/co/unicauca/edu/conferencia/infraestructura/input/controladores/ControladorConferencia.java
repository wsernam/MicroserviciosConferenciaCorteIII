package co.unicauca.edu.conferencia.infraestructura.input.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.unicauca.edu.conferencia.aplicación.puertos.input.PuertoGestionConferencia;
import co.unicauca.edu.conferencia.dominio.modelos.Articulo;
import co.unicauca.edu.conferencia.dominio.modelos.Conferencia;
import co.unicauca.edu.conferencia.infraestructura.input.DTOs.DTOArticulo;
import co.unicauca.edu.conferencia.infraestructura.input.DTOs.DTOPeticion;
import co.unicauca.edu.conferencia.infraestructura.input.DTOs.DTORespuesta;
import co.unicauca.edu.conferencia.infraestructura.input.mapper.ConferenciaMapperInfrastructuraDominio;
import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api/Conferencia")


public class ControladorConferencia {
    
   @Autowired
    private ConferenciaMapperInfrastructuraDominio objMapeador;

    @Autowired
    private PuertoGestionConferencia objGestionConferenciaDom;

   


    @PostConstruct
    public void init() {
        System.out.println("Mapeador: " + objMapeador);
        System.out.println("Gestión Conferencia: " + objGestionConferenciaDom);
        
    }
 

    @PostMapping("/CrearConferencia")
    public DTORespuesta create(@RequestBody DTOPeticion objConferencia) {
       Conferencia objConferenciaCrear = objMapeador.mappearDePeticionAConferencia(objConferencia);
        Conferencia objConferenciaCreado = objGestionConferenciaDom.crearConferencia(objConferenciaCrear);
       DTORespuesta respuesta= objMapeador.mappearDeConferenciaARespuesta(objConferenciaCreado);

        return respuesta;

    }

    @GetMapping("/ListarConferencias")
    public List<DTORespuesta> listar() {
        return objMapeador.mappearDeConferenciasARespuesta(this.objGestionConferenciaDom.listarConferencia());
    }

   @GetMapping("/VerificarConferencia/{prmId}")
    public boolean VerificarConferencia(@PathVariable int prmId) {
        return this.objGestionConferenciaDom.existeConferencia(prmId);
    }

      // Endpoint para recibir los datos del artículo y guardarlos en conferencia
    @PostMapping("/AddArticulos")
    public ResponseEntity<Void> guardarArticulo(@RequestBody DTOArticulo articuloDTO) {
        Articulo objArticulo=this.objMapeador.mappearDeDTOArticuloAArticulo(articuloDTO);
        // Llamar al servicio para guardar el artículo en las listas de conferencia
        this.objGestionConferenciaDom.AñadirArticulo(objArticulo);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}

    

