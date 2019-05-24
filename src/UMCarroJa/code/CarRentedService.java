package UMCarroJa.code;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.io.IOException;
import java.time.LocalDate;

public class CarRentedService {

    @FXML private Button goBack;

    public void goBack() throws IOException {
        Rental rental = UMCarroJa.getService().getOngoingRental();
        rental.setUseFinishDate(LocalDate.now());
        rental.getRentedCar().setLocation(rental.getFinalPos());

        UMCarroJa.getService().setOngoingRental(null);
        Redirect.redirectTo(goBack, "UMCarroJa/code/homeClient.fxml");
    }
}
