package co.unicauca.edu.conferencia.dominio.casosDeUso;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import co.unicauca.edu.conferencia.aplicación.puertos.input.PuertoGestionConferencia;
import co.unicauca.edu.conferencia.aplicación.puertos.output.PuertoComunicacionResultado;
import co.unicauca.edu.conferencia.aplicación.puertos.output.PuertoGestionConferenciaGateway;
import co.unicauca.edu.conferencia.dominio.StrictAssignment;
import co.unicauca.edu.conferencia.dominio.modelos.Articulo;
import co.unicauca.edu.conferencia.dominio.modelos.Conferencia;
import co.unicauca.edu.conferencia.dominio.modelos.Evaluador;

public class AdaptadorGestionConferencias implements PuertoGestionConferencia {

    PuertoGestionConferenciaGateway servicioRepositorio;
    PuertoComunicacionResultado mensaje;

    public AdaptadorGestionConferencias(PuertoGestionConferenciaGateway servicioRepositorio,
            PuertoComunicacionResultado mensaje) {
        this.servicioRepositorio = servicioRepositorio;
        this.mensaje = mensaje;
    }

    @Override
    public List<Conferencia> listarConferencia() {
        return this.servicioRepositorio.getConferencias();
    }

    @Override
    public Conferencia crearConferencia(Conferencia prmConferencia) {

        String resultado = prmConferencia.validarFechas();
        if (!resultado.equals("ok")) {
            return (Conferencia) this.mensaje.prepararRespuestaFallida(resultado);

        } else {
          
            return this.servicioRepositorio.setConferencia(prmConferencia);

        }
    }

    @Override
    public boolean existeConferencia(int prmId) {
        return this.servicioRepositorio.verifyById(prmId);
    }

    @Override
    public Conferencia AñadirArticulo(Articulo prmArticulo) {
        System.out.println("EL ARTICULO QUE LLEGA ES:" + prmArticulo);
        Integer idConferencia = prmArticulo.getConferencia();
        System.out.println("EL ID DE LA CONFERENCIA DEL ARTICULO ES:" + idConferencia);
        if(!servicioRepositorio.verifyById(idConferencia)){
            return (Conferencia) this.mensaje.prepararRespuestaFallida("la conferencia no existe");

        }
     
       
        Conferencia conferencia = servicioRepositorio.EncontrarPorId(idConferencia);
        System.out.println("LA CONFERENCIA ES:" + conferencia);
        String resultado = conferencia.maxArticulosRecibidos();
        if (!resultado.equals("ok")) {
            System.out.println("llEGO AL MAXIMO DE ARTICULOS");
            return (Conferencia) this.mensaje.prepararRespuestaFallida(resultado);
        }

        Conferencia respuesta = this.servicioRepositorio.addArticulo(prmArticulo);

        System.out.println("CONFERENCIA CON SUS ARTICULOS" + conferencia);

        return respuesta;
    }

    @Override
    public void postularEvaluador(Evaluador evaluador) {
        // Verificar si la conferencia existe
        if (!servicioRepositorio.verifyById(evaluador.getConferenciaId())) {
            System.out.println("Conferencia no encontrada para el evaluador.");
            mensaje.prepararRespuestaFallida("Conferencia no encontrada");
            return;
        }

        // Obtener la conferencia asociada
        Conferencia conferencia = servicioRepositorio.EncontrarPorId(evaluador.getConferenciaId());

        // Verificar si ya se ha alcanzado el límite de evaluadores
        String resultado = conferencia.postularEvaluador(evaluador);
        if (resultado.contains("No es posible")) {
            mensaje.prepararRespuestaFallida(resultado);
            return;
        }

        // Si se logra postular correctamente, almacenar en el repositorio
        servicioRepositorio.postularEvaluador(evaluador);
        System.out.println("Evaluador postulado correctamente.");
    }


    @Override
    public List<Articulo> asignarEvaluadores(Conferencia conferencia) {
        // Crear instancia de StrictAssignment
        StrictAssignment strictAssignment = new StrictAssignment(1);
    
        // Obtener el mapa de afinidad inicial
        Map<Articulo, List<Evaluador>> afinidadMap = strictAssignment.AffinityAssignment(
            conferencia.getArticulosRecibidos(),
            conferencia.getEvaluadores()
        );
    
        List<Articulo> articulosAsignados = new ArrayList<>();
    
        // Iterar sobre los artículos recibidos
        for (Articulo articulo : conferencia.getArticulosRecibidos()) {
            // Obtener evaluadores afines del mapa
            List<Evaluador> evaluadoresAfines = afinidadMap.getOrDefault(articulo, new ArrayList<>());
    
            // Filtrar evaluadores válidos (sin conflicto)
            List<Evaluador> evaluadoresFiltrados = evaluadoresAfines.stream()
                .filter(evaluador -> !evaluador.getEmail().equals(conferencia.getOrganizador())) // Excluir al organizador
                .filter(evaluador -> evaluador.getArticuloAsignado() == null) // Evaluador no debe tener un artículo asignado
                .toList();
    
            // Asignar evaluador si hay alguno disponible
            if (!evaluadoresFiltrados.isEmpty()) {
                Evaluador evaluadorAsignado = evaluadoresFiltrados.get(0); // Seleccionar el primero disponible
                articulo.setEvaluadorAsignado(evaluadorAsignado);
                evaluadorAsignado.setArticuloAsignado(articulo);
                articulosAsignados.add(articulo);
            }
        }
    
        return articulosAsignados;
    }
    

   
   
}
