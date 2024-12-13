package com.conference.gui.evaluator;

import com.conference.gui.entities.Evaluador;
import java.util.List;

/**
 * Interfaz para el cliente REST de Evaluadores.
 *
 * @author sonhuila
 */
public interface IEvaluatorRest {

    /**
     * Postula un evaluador a una conferencia.
     *
     * @param evaluador Objeto Evaluador a postular.
     * @return Evaluador postulado (respuesta del servidor).
     */
    public Evaluador postulateEvaluator(Evaluador evaluador);

    /**
     * Obtiene una lista de todos los evaluadores.
     *
     * @return Lista de evaluadores.
     */
    public List<Evaluador> getEvaluators();
}
