package main;

import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        URL fxml = getClass().getResource("/BMIView.fxml");
        if (fxml == null) {
            throw new IllegalStateException("BMIView.fxml tidak ketemu. Pastikan ada di src/main/resources/");
        }
        Parent root = FXMLLoader.load(fxml);
        Scene scene = new Scene(root);

        URL css = getClass().getResource("/styles.css");
        if (css == null) {
            System.err.println("styles.css tidak ketemu di src/main/resources/");
        } else {
            scene.getStylesheets().add(css.toExternalForm());
        }

        primaryStage.setTitle("Kalkulator BMI");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}