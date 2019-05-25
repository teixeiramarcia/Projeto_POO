/**
 * Exceção para o caso em que é introduzida uma matrícula inválida de uma viatura.
 *
 * @author A80943
 * @author A81283
 * @author A85762
 * @version 20190519
 */
public class LicensePlateDoesNotExistException extends Exception {
    public LicensePlateDoesNotExistException() {
        super();
    }

    public LicensePlateDoesNotExistException(String message) {
        super(message);
    }
}
