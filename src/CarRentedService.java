import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.time.LocalDate;

public class CarRentedService {

    @FXML
    private Button goBack;
    @FXML
    private TextField carRating;
    @FXML
    private TextField propRating;


    public void goBack() throws IOException {
        Rental rental = UMCarroJa.getService().getOngoingRental();
        rental.setUseFinishDate(LocalDate.now());
        rental.getRentedCar().setLocation(rental.getFinalPos());

        UMCarroJa.getService().setOngoingRental(null);
        Redirect.redirectTo(goBack, "views/homeClient.fxml");
    }

    public void rateCar(){
        int rating = Integer.parseInt(carRating.getText());
        UMCarroJa.getService().getOngoingRental().getRentedCar().setRating(rating);
    }

    public void rateProp() {
        int rating = Integer.parseInt(propRating.getText());
        UMCarroJa.getService().getOngoingRental().getRentedCar().getProprietary().setRating(rating);
    }



}
