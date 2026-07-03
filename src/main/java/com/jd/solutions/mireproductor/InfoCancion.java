package com.jd.solutions.mireproductor;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.net.URI;

public class InfoCancion extends VBox {

    private static Label etTitulo, etArtista, etAlbum, etNomArchivo;
    private static ImageView imagenCaratula;



    public InfoCancion() {

        etNomArchivo = new Label ("");
        etTitulo = new Label("Titulo: No disponible");
        etArtista  = new Label("Artista: No disponible");
        etAlbum = new Label("Album: No disponible");

        imagenCaratula = new ImageView();

        etNomArchivo.setFont(new Font(19));
        etTitulo.setFont(new Font(16));
        etArtista.setFont(new Font(16));
        etAlbum.setFont(new Font(16));

        imagenCaratula.setFitWidth(140);
        imagenCaratula.setFitHeight(140);
        imagenCaratula.setPreserveRatio(true);

        setAlignment(Pos.CENTER);
        setPadding(new Insets(20));
        this.setSpacing(5);

        getChildren().addAll(etNomArchivo, imagenCaratula, etTitulo, etArtista, etAlbum);



    }

    public static void actualizarInformacion(String titulo, String artista, String album, Image caratula, String archivoName) {

        etNomArchivo.setText(archivoName);
        etTitulo.setText("Titulo: " + (titulo != null ? titulo:"No disponible"));
        etArtista.setText("Artista: " + (artista != null ? artista:"No disponible"));
        etAlbum.setText("Album: " + (album != null ? album:"No disponible"));



        Image imagenDefault = new Image(InfoCancion.class.getResourceAsStream("/imagenes/music_default.png"));

        imagenCaratula.setImage(caratula != null ? caratula : imagenDefault);

    }



}
