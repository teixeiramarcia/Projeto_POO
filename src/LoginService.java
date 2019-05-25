import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class LoginService {
    @FXML
    private CheckBox proprietary;
    @FXML
    private TextField email;
    @FXML
    private PasswordField password;

    public void login() throws IOException {
        Boolean isProprietary = proprietary.isSelected();
        String eMail = email.getText();
        String passWord = password.getText();

        try {
            UMCarroJa.getService().login(eMail, passWord, isProprietary);
            if (isProprietary) {
                Redirect.redirectTo(email, "views/homeProprietary.fxml");
            } else Redirect.redirectTo(email, "views/homeClient.fxml");
        } catch (EmailDoesNotExistException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Email" + e.getMessage() + " doesn't exist", ButtonType.CLOSE);
            alert.showAndWait();
        } catch (IncorrectPasswordException p) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Incorrect Password", ButtonType.CLOSE);
            alert.showAndWait();
        }
    }

    public void signIn() throws IOException {
        Redirect.redirectTo(email, "views/signInPage.fxml");
    }
}
