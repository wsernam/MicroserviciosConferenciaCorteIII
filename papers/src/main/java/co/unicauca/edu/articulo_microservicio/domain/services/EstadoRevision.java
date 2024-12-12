package co.unicauca.edu.articulo_microservicio.domain.services;

/**
 *
 * @author wsern
 */
import co.unicauca.edu.articulo_microservicio.domain.models.Articulo;

public enum EstadoRevision {
    PENDIENTE {
        @Override
        public void iniciarRevision(Articulo articulo) {
            articulo.setEstadoActual(EN_REVISION);
            System.out.println("Revisión iniciada.");
        }

        @Override
        public void completarRevision(Articulo articulo) {
            System.out.println("No se puede completar. El artículo está pendiente.");
        }

        @Override
        public void revisarEstado(Articulo articulo) {
            System.out.println("El artículo está pendiente de revisión.");
        }

        @Override
        public void evaluar(Articulo articulo, boolean aprobado) {
            System.out.println("No se puede evaluar un artículo pendiente.");
        }
    },
    EN_REVISION {
        @Override
        public void iniciarRevision(Articulo articulo) {
            System.out.println("El artículo ya está en revisión.");
        }

        @Override
        public void completarRevision(Articulo articulo) {
            articulo.setEstadoActual(COMPLETADO);
            System.out.println("Revisión completada.");
        }

        @Override
        public void revisarEstado(Articulo articulo) {
            System.out.println("El artículo está en revisión.");
        }

        @Override
        public void evaluar(Articulo articulo, boolean aprobado) {
            if (aprobado) {
                articulo.setEstadoActual(APROBADO);
                System.out.println("El artículo ha sido aprobado.");
            } else {
                articulo.setEstadoActual(RECHAZADO);
                System.out.println("El artículo ha sido rechazado.");
            }
        }
    },
    COMPLETADO {
        @Override
        public void iniciarRevision(Articulo articulo) {
            articulo.setEstadoActual(EN_REVISION);
            System.out.println("Revisión reiniciada.");
        }

        @Override
        public void completarRevision(Articulo articulo) {
            System.out.println("El artículo ya fue revisado.");
        }

        @Override
        public void revisarEstado(Articulo articulo) {
            System.out.println("El artículo ya fue revisado.");
        }

        @Override
        public void evaluar(Articulo articulo, boolean aprobado) {
            System.out.println("No se puede evaluar un artículo ya completado.");
        }
    },
    APROBADO {
        @Override
        public void iniciarRevision(Articulo articulo) {
            System.out.println("No se puede iniciar revisión. El artículo ya está aprobado.");
        }

        @Override
        public void completarRevision(Articulo articulo) {
            System.out.println("El artículo ya está aprobado.");
        }

        @Override
        public void revisarEstado(Articulo articulo) {
            System.out.println("El artículo está aprobado.");
        }

        @Override
        public void evaluar(Articulo articulo, boolean aprobado) {
            System.out.println("El artículo ya está aprobado.");
        }
    },
    RECHAZADO {
        @Override
        public void iniciarRevision(Articulo articulo) {
            System.out.println("No se puede iniciar revisión. El artículo está rechazado.");
        }

        @Override
        public void completarRevision(Articulo articulo) {
            System.out.println("El artículo está rechazado.");
        }

        @Override
        public void revisarEstado(Articulo articulo) {
            System.out.println("El artículo está rechazado.");
        }

        @Override
        public void evaluar(Articulo articulo, boolean aprobado) {
            System.out.println("El artículo ya está rechazado.");
        }
    };

    public abstract void iniciarRevision(Articulo articulo);

    public abstract void completarRevision(Articulo articulo);

    public abstract void revisarEstado(Articulo articulo);

    public abstract void evaluar(Articulo articulo, boolean aprobado);
}
