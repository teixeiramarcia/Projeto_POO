import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class SignInService {
    @FXML
    private CheckBox client;
    @FXML
    private CheckBox proprietary;
    @FXML
    private TextField email;
    @FXML
    private PasswordField password;
    @FXML
    private TextField address;
    @FXML
    private TextField name;
    @FXML
    private TextField nif;
    @FXML
    private DatePicker birthDate;

    public void signIn() {
        boolean isClient = client.isSelected();
        boolean isProprietary = proprietary.isSelected();
        String emailText = email.getText();
        String passwordText = password.getText();
        String addressText = address.getText();
        String nameText = name.getText();
        String nifText = nif.getText();
        LocalDate birthDateValue = birthDate.getValue();

        if (isClient) {
            Client newClient = new Client(nameText, emailText, passwordText, addressText, birthDateValue, nifText, null,
                    new ArrayList<>(), 100, 100);
            try {
                UMCarroJa.getService().addNewClient(newClient);
                Redirect.redirectTo(name, "views/homeClient.fxml");
            } catch (EmailAlreadyExistsException | IOException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Email " + e.getMessage() + " already exists", ButtonType.CLOSE);
                alert.showAndWait();
            }
        } else if (isProprietary) {
            Proprietary newProp = new Proprietary(nameText, emailText, passwordText, addressText, birthDateValue,
                    nifText, new ArrayList<>(), 100, new ArrayList<>());
            try {
                UMCarroJa.getService().addNewProprietary(newProp);
                Redirect.redirectTo(email, "views/homeProprietary.fxml");
            } catch (EmailAlreadyExistsException | IOException e) {
                e.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.ERROR, "Email " + e.getMessage() + " already exists", ButtonType.CLOSE);
                alert.showAndWait();
            }
        }
    }

    public void goBack() throws IOException {
        Redirect.redirectTo(name, "views/logIn.fxml");
    }

}
