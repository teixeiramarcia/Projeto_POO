import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.awt.geom.Point2D;
import java.io.IOException;

public class HomeClientService {

    @FXML
    private Label clientName;
    @FXML
    private Button rentAcar;
    @FXML
    private Button rentalHistory;
    @FXML
    private Button logOut;
    @FXML
    private TextField locationX;
    @FXML
    private TextField locationY;

    @FXML
    public void initialize() {
        Service service = UMCarroJa.getService();
        Client user = (Client) service.getLoggedInUser(false);
        clientName.setText(user.getName());
    }

    public void rentCar() throws IOException {
        Redirect.redirectTo(rentAcar, "views/rentAcar.fxml");
    }

    public void rentalHistory() throws IOException {
        Redirect.redirectTo(rentalHistory, "views/rentalHistory.fxml");
    }

    public void updateLocation() {
        Double locX = Double.parseDouble(locationX.getText());
        Double locY = Double.parseDouble(locationY.getText());
        Point2D.Double location = new Point2D.Double(locX, locY);
        ((Client) UMCarroJa.getService().getLoggedInUser(false)).setLocation(location);
    }

    public void logOut() throws IOException {
        Redirect.redirectTo(logOut, "views/login.fxml");
    }

}
