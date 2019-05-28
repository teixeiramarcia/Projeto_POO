import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class RentalHistoryClientService {

    @FXML
    private DatePicker infLimit;
    @FXML
    private DatePicker supLimit;
    @FXML
    private Button close;
    @FXML
    private TableView<Rental> rentalsBetweenDates;

    public void close() throws IOException {
        Redirect.redirectTo(close, "views/homeClient.fxml");
    }

    public void searchButton() {
        LocalDate infLimitText = infLimit.getValue();
        LocalDate supLimitText = supLimit.getValue();
        List<Rental> rentalBetDates;
        Client client = (Client) UMCarroJa.getService().getLoggedInUser(false);

        rentalBetDates = client.rentalsBetweenDates(infLimitText, supLimitText);

        TableColumn brand = new TableColumn("Brand");
        brand.setCellValueFactory(new PropertyValueFactory<Rental, String>("carBrand"));
        TableColumn distance = new TableColumn("Distance (km)");
        distance.setCellValueFactory(new PropertyValueFactory<Rental, String>("distance"));
        TableColumn price = new TableColumn("Total price (€)");
        price.setCellValueFactory(new PropertyValueFactory<Rental, String>("price"));
        TableColumn rental_Date = new TableColumn("Rental Date");
        rental_Date.setCellValueFactory(new PropertyValueFactory<Rental, String>("rentalDate"));

        rentalsBetweenDates.getColumns().addAll(brand, distance, price, rental_Date);
        ObservableList<Rental> rentals = FXCollections.observableArrayList(rentalBetDates);

        rentalsBetweenDates.setItems(rentals);
    }
}
