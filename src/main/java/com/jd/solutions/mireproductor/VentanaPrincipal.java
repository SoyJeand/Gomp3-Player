package com.jd.solutions.mireproductor;

import javafx.scene.layout.BorderPane;

public class VentanaPrincipal extends BorderPane {
    public VentanaPrincipal() {
        setTop(new BarraSuperior());
        setCenter(new InfoCancion());
        setBottom( new BarraInferior());
    }

}
