package cl.ucn.disc.as.model.exception;

/**
 * Domain Violation Exception
 *
 * @Author José Alcayaga
 */
public class IllegalDomainException extends RuntimeException {

    /**
     * The constructor.
     *
     * @param message to use.
     */
    public IllegalDomainException(String message) {
        super(message);
    }
}
