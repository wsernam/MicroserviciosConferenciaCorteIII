package co.unicauca.edu.conferencia.infraestructura.input.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.unicauca.edu.conferencia.dominio.casosDeUso.AdaptadorGestionConferencias;
import co.unicauca.edu.conferencia.dominio.modelos.Conferencia;
import co.unicauca.edu.conferencia.infraestructura.input.DTOs.DTOPeticion;
import co.unicauca.edu.conferencia.infraestructura.input.DTOs.DTORespuesta;
import co.unicauca.edu.conferencia.infraestructura.input.mapper.ConferenciaMapperInfrastructuraDominio;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")


public class ControladorConferencia {
    
   @Autowired
    private ConferenciaMapperInfrastructuraDominio objMapeador;

    @Autowired
    private AdaptadorGestionConferencias objGestionConferenciaDom;

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

}

    

