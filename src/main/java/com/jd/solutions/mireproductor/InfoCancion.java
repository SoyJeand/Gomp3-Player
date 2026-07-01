package com.jd.solutions.mireproductor;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class InfoCancion extends VBox {

    private static Label etTitulo, etArtista, etAlbum;
    private static ImageView imagenCaratula;

    public InfoCancion() {
        etTitulo = new Label("Titulo: No disponible");
        etArtista  = new Label("Artista: No disponible");
        etAlbum = new Label("Album: No disponible");
        imagenCaratula = new ImageView();

        etTitulo.setFont(new Font(18));
        etArtista.setFont(new Font(18));
        etAlbum.setFont(new Font(18));

        imagenCaratula.setFitWidth(150);
        imagenCaratula.setFitWidth(150);
        imagenCaratula.setPreserveRatio(true);

        setAlignment(Pos.CENTER);
        setPadding(new Insets(20));
        this.setSpacing(10);

        getChildren().addAll(imagenCaratula, etTitulo, etArtista, etAlbum);



    }

    public static void actualizarInformacion(String titulo, String artista, String album, Image caratula) {
        etTitulo.setText("Titulo: " + (titulo != null ? titulo:"No disponible"));
        etArtista.setText("Artista: " + (artista != null ? artista:"No disponible"));
        etAlbum.setText("Cancion: " + (album != null ? album:"No disponible"));

        Image imagenDefault = new Image(InfoCancion.class.getResourceAsStream("/imagenes/music_default.png"));

        imagenCaratula.setImage(caratula != null ? caratula : imagenDefault);

    }



}
