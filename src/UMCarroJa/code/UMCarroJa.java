package UMCarroJa.code;

import UMCarroJa.code.LoadState;
import UMCarroJa.code.Service;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Write a description of class UMcarroJa here.
 *
 * @author A80943
 * @author A81283
 * @author A85762
 * @version 20190403
 */

public class UMCarroJa extends Application {
    private static Service service;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("UMCarroJa/code/login.fxml"));
        primaryStage.setTitle("UMCarroJa");
        primaryStage.setScene(new Scene(root));

        primaryStage.show();
    }


    public static void main(String[] args) throws IOException {
        //INIT SERVICE
        service = new Service();
        if(args.length != 0){
            try{
                service = service.chargeState("/tmp/stateFile.txt");
            } catch (FileNotFoundException ex) {
                LoadState loadState = new LoadState(service.getAllProprietaries(), service.getAllClients(),
                        service.getFuelCars(), service.getElectricCars(), service.getHybridCars(),
                        service.getAllRentals());
                loadState.readFile(args[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        launch(args);
    }

    public static Service getService() {
        return service;
    }
}