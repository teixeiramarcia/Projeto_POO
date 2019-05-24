package UMCarroJa.code;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.io.IOException;
import java.util.List;

public class RentalRequestsService {
    @FXML private Button goBack;
    @FXML private TableView rentalRequests;

    @FXML public void initialize() {
        Service service = UMCarroJa.getService();
        List<Rental> requestsList = service.getPendentRequests();

        TableColumn license = new TableColumn("License Plate");
        license.setCellValueFactory(new PropertyValueFactory<Car, String>("Car"));
        TableColumn rentalDate = new TableColumn("Rental Date");
        rentalDate.setCellValueFactory(new PropertyValueFactory<Car, String>("rentalDate"));
        TableColumn initialPos = new TableColumn("Start");
        initialPos.setCellValueFactory(new PropertyValueFactory<Car, String>("initialPosCar"));
        TableColumn finalPos = new TableColumn("Finish");
        finalPos.setCellValueFactory(new PropertyValueFactory<Car, String>("finalPos"));

        rentalRequests.getColumns().addAll(license, rentalDate, initialPos, finalPos);
        ObservableList<Rental> rentals = FXCollections.observableArrayList(requestsList);

        rentalRequests.setItems(rentals);

        addButtonToTable("Accept");
        addButtonToTable("Decline");
    }

    private void addButtonToTable(String type) {
        TableColumn<Rental, Void> colBtn = new TableColumn(type);

        Callback<TableColumn<Rental, Void>, TableCell<Rental, Void>> cellFactory = new Callback<TableColumn<Rental, Void>,
                TableCell<Rental, Void>>() {
            @Override
            public TableCell<Rental, Void> call(final TableColumn<Rental, Void> param) {
                final TableCell<Rental, Void> cell = new TableCell<Rental, Void>() {

                    private final Button btn = new Button(type);

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            Rental data = getTableView().getItems().get(getIndex());
                            UMCarroJa.getService().changeStatus(data, type);
                            try {
                                goBack();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };

        colBtn.setCellFactory(cellFactory);

        rentalRequests.getColumns().add(colBtn);

    }

    public void goBack() throws IOException {
        Redirect.redirectTo(goBack, "UMCarroJa/code/homeProprietary.fxml");
    }
}
