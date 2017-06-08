package br.com.aurum.astrea.exception;

/**
 * Created by diegom on 07/06/2017.
 */
public class ControllerException extends Exception {

    public ControllerException() {
        super();
    }

    public ControllerException(String message) {
        super(message);
    }

    public ControllerException(String message, Throwable cause) {
        super(message, cause);
    }

    public ControllerException(Throwable cause) {
        super(cause);
    }
}
