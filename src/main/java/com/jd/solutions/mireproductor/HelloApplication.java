package com.jd.solutions.mireproductor;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        Scene escena = new Scene(new VentanaPrincipal(), 540, 470);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/imagenes/icono_princ.jpg")));
        stage.setTitle("GompThree Player");
        stage.setScene(escena);
        stage.setResizable(false);
        stage.show();
    }
}
