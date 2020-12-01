package miu;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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

    public static void main(String[] args) {
        initData();
//        launch(args);
    }
}
