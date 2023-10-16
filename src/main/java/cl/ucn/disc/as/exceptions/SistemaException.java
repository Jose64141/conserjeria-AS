package cl.ucn.disc.as.exceptions;

import javax.persistence.PersistenceException;

/**
 * The Sistema exception.
 */
public class SistemaException extends RuntimeException{

    /**
     * Creates an exception.
     * @param message Exception message.
     * @param ex Persistence exception.
     */
    public SistemaException(String message, PersistenceException ex) {
        super(message, ex);
    }
    /**
     * Creates an exception.
     * @param message Exception message.
     * @param ex Null pointer exception.
     */
    public SistemaException(String message, NullPointerException ex) {
        super(message, ex);
    }
}
