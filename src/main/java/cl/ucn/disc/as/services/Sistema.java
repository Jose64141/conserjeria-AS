package cl.ucn.disc.as.services;

import cl.ucn.disc.as.model.Edificio;

/**
 * System operations.
 */
public interface Sistema {

    /**
     * Agrega un edificio al sistema.
     *
     * @param edificio a agregar
     * @return
     */
    Edificio add(Edificio edificio);
}
