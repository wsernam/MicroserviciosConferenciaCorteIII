package co.unicauca.edu.conferencia.infraestructura.input.controladores;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.unicauca.edu.conferencia.dominio.casosDeUso.AdaptadorGestionConferencias;
import co.unicauca.edu.conferencia.dominio.modelos.Conferencia;
import co.unicauca.edu.conferencia.infraestructura.input.DTOs.DTOPeticion;
import co.unicauca.edu.conferencia.infraestructura.input.DTOs.DTORespuesta;
import co.unicauca.edu.conferencia.infraestructura.input.mapper.ConferenciaMapperInfrastructuraDominio;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")

public class ControladorConferencia {
    ConferenciaMapperInfrastructuraDominio objMapeador;
    AdaptadorGestionConferencias objGestionConferenciaDom;
    
    
    public ControladorConferencia(ConferenciaMapperInfrastructuraDominio objMapeador,
            AdaptadorGestionConferencias objGestionConferenciaDom) {
        this.objMapeador = objMapeador;
        this.objGestionConferenciaDom = objGestionConferenciaDom;
    }

    @PostMapping("/CrearConferencia")
    public DTORespuesta create(@RequestBody DTOPeticion objConferencia) {
       Conferencia objConferenciaCrear = objMapeador.mappearDePeticionAConferencia(objConferencia);
        Conferencia objConferenciaCreado = objGestionConferenciaDom.crearConferencia(objConferenciaCrear);
        return objMapeador.mappearDeConferenciaARespuesta(objConferenciaCreado);

    }

    @GetMapping("/ListarConferencias")
    public List<DTORespuesta> listar() {
        return objMapeador.mappearDeConferenciasARespuesta(this.objGestionConferenciaDom.listarConferencia());
    }
    }

    
}
