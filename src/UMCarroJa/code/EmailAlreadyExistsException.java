package UMCarroJa.code;

/**
 * Exceção caso um email que esteja a ser utilizado para novo registo já exista.
 *
 * @author A80943
 * @author A81283
 * @author A85762
 * @version 20190519
 */

public class EmailAlreadyExistsException extends Exception {
    public EmailAlreadyExistsException() {
        super();
    }

    public EmailAlreadyExistsException(String message) {
        super(message);
    }
}
