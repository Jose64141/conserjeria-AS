package cl.ucn.disc.as.exceptions;

import javax.persistence.PersistenceException;

/**
 * The Sistema exception.
 */
public class SistemaException extends RuntimeException{

    /**
     * Creates an exception.
     * @param message a
     * @param ex a
     */
    public SistemaException(String message, PersistenceException ex) {
        super(message, ex);
    }
}
