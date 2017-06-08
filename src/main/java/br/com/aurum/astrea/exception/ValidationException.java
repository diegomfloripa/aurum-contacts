package br.com.aurum.astrea.exception;

/**
 * Created by diegom on 07/06/2017.
 */
public class ValidationException extends ControllerException {

    public ValidationException() {
        super();
    }

    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidationException(Throwable cause) {
        super(cause);
    }
}
