import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class HomeProprietaryService {
    @FXML
    private Label proprietaryName;
    @FXML
    private Button addNewCar;
    @FXML
    private Button rentalRequests;
    @FXML
    private Button rentalHistory;
    @FXML
    private Label rating;
    @FXML
    private Button logOut;

    @FXML
    public void initialize() {
        Service service = UMCarroJa.getService();
        Proprietary user = (Proprietary) service.getLoggedInUser(true);
        proprietaryName.setText(user.getName());
        rating.setText(Integer.toString(user.getRating()));
    }

    public void addCar() throws IOException {
        Redirect.redirectTo(addNewCar, "views/addNewCar.fxml");
    }

    public void rentalRequests() throws IOException {
        Redirect.redirectTo(rentalRequests, "views/rentalRequests.fxml");
    }

    public void rentalHistory() throws IOException {
        Redirect.redirectTo(rentalHistory, "views/rentalHistoryProp.fxml");
    }

    public void logOut() throws IOException {
        Redirect.redirectTo(logOut, "views/login.fxml");
    }
}
