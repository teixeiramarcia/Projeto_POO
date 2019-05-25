import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class KnowTripTimeService {

    @FXML
    private ChoiceBox<WeatherStatus> weatherState;
    @FXML
    private TextField drivingSkill;
    @FXML
    private Label estimateTime;

    @FXML
    public void initialize() {
        weatherState.getItems().addAll(UMCarroJa.getService().getWeather().getWeathers());
    }

    public void calculate() {
        WeatherStatus weatherStatus = weatherState.getValue();
        int drivingSkillText = Integer.parseInt(drivingSkill.getText());
        Client client = (Client) UMCarroJa.getService().getLoggedInUser(false);
        client.setDrivingSkill(drivingSkillText);
        Rental rental = UMCarroJa.getService().getOngoingRental();
        double tripTimeText = UMCarroJa.getService().tripTime(rental, weatherStatus);
        String time = Double.toString(tripTimeText);
        String[] t = time.split("\\.");

        int min = Integer.parseInt(t[1].substring(0, t[1].length() > 2 ? 2 : t[1].length())) * 60;
        String m = Integer.toString(min);
        String mins = m.substring(0, m.length() > 2 ? 2 : m.length());
        estimateTime.setText(t[0] + "h" + mins + "m");
    }

    public void ok() throws IOException {
        Redirect.redirectTo(estimateTime, "views/carRented.fxml");
    }
}