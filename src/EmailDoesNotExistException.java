/**
 * Exceção para o caso de um email que esteja a ser utilizado para fazer loging não exista no sistema.
 *
 * @author A80943
 * @author A81283
 * @author A85762
 * @version 20190519
 */
public class EmailDoesNotExistException extends Exception {
    public EmailDoesNotExistException() {
        super();
    }

    public EmailDoesNotExistException(String message) {
        super(message);
    }
}
