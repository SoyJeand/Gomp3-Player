package com.jd.solutions.mireproductor;

import javafx.scene.media.Media;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

import java.io.File;


public class ExploradorArchivos {

    private static Stage escenario;
    private static FileChooser explorador;

    static {
        escenario = new Stage();
        explorador = new FileChooser();
        explorador.setTitle("Selecciona cancion");

        ExtensionFilter filtro = new ExtensionFilter("Audio Files", "*wav", "*.mp3", "*.acc");
        explorador.getExtensionFilters().add(filtro);

    }

    public static void seleccionarArchivo() {
        try {
            File archivo = explorador.showOpenDialog(escenario);
            Media archivoSonido = new Media(archivo.toURI().toString());
            new Cancion(archivoSonido);
        } catch(Exception e) {
            System.out.println("No has seleccionado nada");
        }
    }

}
