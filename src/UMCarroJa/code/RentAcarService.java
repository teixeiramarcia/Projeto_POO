package UMCarroJa.code;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.awt.geom.Point2D;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RentAcarService {
    @FXML private CheckBox fuelCar;
    @FXML private CheckBox electricCar;
    @FXML private CheckBox hybridCar;
    @FXML private TextField destinationX;
    @FXML private TextField destinationY;
    @FXML private CheckBox closerCars;
    @FXML private CheckBox cheaperCars;
    @FXML private Button goBack;
    @FXML private TableView<Car> carsForChoice;

    public void goBack() throws IOException {
        Redirect.redirectTo(goBack, "UMCarroJa/code/homeClient.fxml");
    }

    public void ok() {
        boolean isFuelCar = fuelCar.isSelected();
        boolean isElectricCar = electricCar.isSelected();
        boolean isHybridCar = hybridCar.isSelected();
        Double destinyX = Double.parseDouble(destinationX.getText());
        Double destinyY = Double.parseDouble(destinationY.getText());
        Point2D.Double destination = new Point2D.Double(destinyX, destinyY);
        boolean isCloserCars = closerCars.isSelected();
        boolean isCheaperCars = cheaperCars.isSelected();
        List<Car> cars = new ArrayList<>();

        if(isFuelCar){
            cars.addAll(UMCarroJa.getService().getFuelCars(isCloserCars, isCheaperCars, destination));
        } else if(isElectricCar){
            cars.addAll(UMCarroJa.getService().getElectricCars(isCloserCars, isCheaperCars, destination));
        } else if(isHybridCar){
            cars.addAll(UMCarroJa.getService().getHybridCars(isCloserCars, isCheaperCars, destination));
        }

        TableColumn brand = new TableColumn("Brand");
        brand.setCellValueFactory(new PropertyValueFactory<Car, String>("brand"));
        TableColumn priceKm = new TableColumn("Price per Kilometer");
        priceKm.setCellValueFactory(new PropertyValueFactory<Car, String>("priceKmString"));
        TableColumn rating = new TableColumn("Rating");
        rating.setCellValueFactory(new PropertyValueFactory<Car, String>("rating"));
        TableColumn location = new TableColumn("Coordinates");
        location.setCellValueFactory(new PropertyValueFactory<Car, String>("locationString"));

        carsForChoice.getColumns().addAll(brand, priceKm, rating, location);
        ObservableList<Car> carss = FXCollections.observableArrayList(cars);

        carsForChoice.setItems(carss);
    }

    public void handleMouseClick() throws IOException {
        Car car = carsForChoice.getSelectionModel().getSelectedItem();
        try{
            UMCarroJa.getService().createRental(car, Double.parseDouble(destinationX.getText()),
                    Double.parseDouble(destinationY.getText()));
        } catch (ClientAlreadyHasOngoingRentalException e){
            Alert alert = new Alert(Alert.AlertType.ERROR, "You already have an ongoing rental.", ButtonType.CLOSE);
            alert.showAndWait();
        }
        Redirect.redirectTo(carsForChoice, "UMCarroJa/code/knowTripTime.fxml");
    }
}
