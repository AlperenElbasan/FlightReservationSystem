package miu;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import miu.cases.PassengerScreen;

import java.util.Scanner;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("ui.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    private static void initData() {
        //TODO: generate all data from storage here.
        System.out.println("initialize data");
        StorageHandler.initializeData();
    }

    public static void PassengerHandler(){
        PassengerScreen.makeReservation();
    }

    public static void AgentHandler(){
        //TODO: call to cases here
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        initData();

        PassengerHandler();

        AgentHandler();

        System.out.println("Who are you?");
        System.out.println("1. Admin");
        System.out.println("2. Passenger");
        System.out.println("3. Agent");
        int personRole = input.nextInt();

//        launch(args);
    }
}
