package UMCarroJa.code;

public class ClientAlreadyHasOngoingRentalException extends Exception {
    public ClientAlreadyHasOngoingRentalException() {
        super();
    }

    public ClientAlreadyHasOngoingRentalException(String message) {
        super(message);
    }
}
