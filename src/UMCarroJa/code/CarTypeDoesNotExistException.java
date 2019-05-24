package UMCarroJa.code;

/**
 * Exceção para o caso de um tipo de carro não existir.
 *
 * @author A80943
 * @author A81283
 * @author A85762
 * @version 20190519
 */
public class CarTypeDoesNotExistException extends Exception {
    public CarTypeDoesNotExistException() {
        super();
    }

    public CarTypeDoesNotExistException(String message) {
        super(message);
    }
}
