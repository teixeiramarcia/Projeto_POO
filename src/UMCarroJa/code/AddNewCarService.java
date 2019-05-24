package UMCarroJa.code;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

import java.awt.geom.Point2D;
import java.io.IOException;
import java.util.ArrayList;

public class AddNewCarService {

    @FXML private TextField brand;
    @FXML private TextField carType;
    @FXML private TextField mediumSpeed;
    @FXML private TextField priceKm;
    @FXML private TextField consumeKm;
    @FXML private TextField locationX;
    @FXML private TextField locationY;
    @FXML private TextField licensePlate;
    @FXML private TextField carAutonomy;
    @FXML private Button ok;
    @FXML private Button goBack;

    public void addCar() throws IOException {
        String brandText = brand.getText();
        String carTypeText = carType.getText();
        int mediumSpeedText = Integer.parseInt(mediumSpeed.getText());
        Double priceKmText = Double.parseDouble(priceKm.getText());
        Double consumeKmText = Double.parseDouble(consumeKm.getText());
        Double locationXText = Double.parseDouble(locationX.getText());
        Double locationYText = Double.parseDouble(locationY.getText());
        Point2D.Double location = new Point2D.Double(locationXText, locationYText);
        String licensePlateText = licensePlate.getText();
        Double carAutonomyText = Double.parseDouble(carAutonomy.getText());
        Proprietary proprietary = (Proprietary) UMCarroJa.getService().getLoggedInUser(true);

        if(carTypeText.equals("Eléctrico")){
            Car newCar = new ElectricCar(brandText, mediumSpeedText, priceKmText, consumeKmText, new ArrayList<>(), 100,
                    location, proprietary, licensePlateText, 100, carAutonomyText, carAutonomyText);
            try {
                UMCarroJa.getService().addNewElectricCar(newCar);
            } catch (CarAlreadyExistsException e){
                Alert alert = new Alert(Alert.AlertType.ERROR, "Car with the license plate" + e.getMessage() + " already exists", ButtonType.CLOSE);
                alert.showAndWait();
            }
        } else if(carTypeText.equals("Híbrido")){
            Double batteryAutonomy = carAutonomyText/2;
            Double fuelAutonomy = carAutonomyText/2;
            Car newCar = new HybridCar(brandText, mediumSpeedText, priceKmText, consumeKmText, new ArrayList<>(), 100,
                    location, proprietary, licensePlateText, 100, fuelAutonomy, batteryAutonomy, fuelAutonomy,
                    batteryAutonomy);
            try {
                UMCarroJa.getService().addNewHybridCar(newCar);
            } catch (CarAlreadyExistsException e){
                Alert alert = new Alert(Alert.AlertType.ERROR, "Car with the license plate" + e.getMessage() + " already exists", ButtonType.CLOSE);
                alert.showAndWait();
            }
        } else {
            Car newCar = new ElectricCar(brandText, mediumSpeedText, priceKmText, consumeKmText, new ArrayList<>(), 100,
                    location, proprietary, licensePlateText, 100, carAutonomyText, carAutonomyText);
            try {
                UMCarroJa.getService().addNewFuelCar(newCar);
            } catch (CarAlreadyExistsException e){
                Alert alert = new Alert(Alert.AlertType.ERROR, "Car with the license plate" + e.getMessage() + " already exists", ButtonType.CLOSE);
                alert.showAndWait();
            }
        }
        Redirect.redirectTo(ok, "UMCarroJa/code/carAdded.fxml");
    }

    public void goBack() throws IOException{
        Redirect.redirectTo(goBack, "UMCarroJa/code/homeProprietary.fxml");
    }
}
