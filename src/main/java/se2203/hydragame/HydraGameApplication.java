package se2203.hydragame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HydraGameApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HydraGameApplication.class.getResource("hydraGame-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 850);
        Image icon = new Image("file:src/main/resources/se2203/hydragame/HydraIcon.png");
        stage.getIcons().add(icon);
        stage.setTitle("Hydra Game");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}