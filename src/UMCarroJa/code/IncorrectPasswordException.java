package UMCarroJa.code;

/**
 * Exceção para o caso  em que é introduzida uma password incorrecta.
 *
 * @author A80943
 * @author A81283
 * @author A85762
 * @version 20190519
 */

public class IncorrectPasswordException extends Exception {
    public IncorrectPasswordException() {
        super();
    }

    public IncorrectPasswordException(String message) {
        super(message);
    }
}
