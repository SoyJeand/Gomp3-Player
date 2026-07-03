package com.jd.solutions.mireproductor;

import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
public class Cancion {

    private static Media archivo;
    private static MediaPlayer reproductor;
    private String titulo, album, artista;

    public Cancion(Media archivo, String archivoName) {
        this.archivo = archivo;
        reproductor = new MediaPlayer(archivo);

        BarraTiempo.setCancion(reproductor);

        reproductor.setOnReady(() ->{
            titulo = (String) archivo.getMetadata().get("title");
            album = (String) archivo.getMetadata().get("album");
            artista = (String) archivo.getMetadata().get("artist");

            Image caratula = (Image) archivo.getMetadata().get("image");

            InfoCancion.actualizarInformacion(titulo, artista, album, caratula, archivoName);

        });
        reproductor.setOnEndOfMedia(() -> reproductor.stop());
    }



    public static void play() {
        if(archivo != null) {
            reproductor.play();
        }
    }

    public static void pause() {
        if(archivo != null && (reproductor.getStatus() == Status.PLAYING)) {
            reproductor.seek(reproductor.getCurrentTime());
            reproductor.pause();
        }
    }

    public static void stop() {
        if(archivo != null && (reproductor.getStatus() == Status.PLAYING || reproductor.getStatus() == Status.PAUSED)) {
            reproductor.stop();
        }
    }

    public static void setVolumen(double volumen) {
        reproductor.setVolume(volumen);
    }
}
