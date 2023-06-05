package com.example.prooyectoprogramacion;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneView extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SceneView.class.getResource("TablaAsignacion.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 820, 600);
        stage.setTitle("Asignacion de aulas");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}