package com.jd.solutions.mireproductor;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;

public class BarraTiempo extends VBox {
    private static BarraTiempo objClase = new BarraTiempo();
    private static MediaPlayer cancion;
    private static Label etTiempo;
    private static Slider barra;

    private BarraTiempo() {
        etTiempo = new Label("00:00");
        VBox.setMargin(etTiempo, new Insets(0,15,0,0));
        etTiempo.setFont(new Font(15));
        barra = new Slider();
        barra.setMin(0);
        barra.setMax(100);
        barra.setValue(0);

        this.setAlignment(Pos.CENTER_RIGHT);
        getChildren().addAll(etTiempo, barra);
    }

    private static void establecerListeners() {
        cancion.currentTimeProperty().addListener((observable, oldValue, newValue) -> {
            double porcentaje = (newValue.toSeconds() / cancion.getTotalDuration().toSeconds()) * 100;
            barra.setValue(porcentaje);

            etTiempo.setText(formatoTiempo(newValue.toSeconds()));
        });

        barra.valueProperty().addListener((observable, oldValue, newValue) -> {
            if(barra.isValueChanging()) {
                cancion.seek(cancion.getTotalDuration().multiply(newValue.doubleValue() / 100));
            }
        });
    }

    private static String formatoTiempo(double segundos) {
        int minutos = (int) segundos/60;
        int seg = (int) segundos%60;
        return String.format("%02d:%02d", minutos,seg);
    }

    public static void setCancion(MediaPlayer cancion) {
        BarraTiempo.cancion = cancion;
        establecerListeners();
    }

    public static BarraTiempo getBarra() {
        return objClase;
    }
}
