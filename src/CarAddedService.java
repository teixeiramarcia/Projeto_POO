import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class CarAddedService {

    @FXML
    private Button goBack;

    public void goBack() throws IOException {
        Redirect.redirectTo(goBack, "views/addNewCar.fxml");
    }
}
