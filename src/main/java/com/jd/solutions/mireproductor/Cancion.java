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
        if (reproductor != null) {
            reproductor.stop();
            reproductor.dispose();
            System.out.println("Canción anterior detenida y liberada.");
        }
        try {
            this.archivo = archivo;
            reproductor = new MediaPlayer(archivo);
            reproductor.setVolume(0.5);

            BarraTiempo.setCancion(reproductor);

            reproductor.setOnReady(() ->{
                titulo = (String) archivo.getMetadata().get("title");
                album = (String) archivo.getMetadata().get("album");
                artista = (String) archivo.getMetadata().get("artist");

                Image caratula = (Image) archivo.getMetadata().get("image");

                InfoCancion.actualizarInformacion(titulo, artista, album, caratula, archivoName);

            });
            reproductor.setOnEndOfMedia(() -> reproductor.stop());

        } catch (Exception e) {
            System.err.println("Error al carhar el archivo de audio:" + e.getMessage());
        }


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
