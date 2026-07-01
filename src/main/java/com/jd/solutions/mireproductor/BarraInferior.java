package com.jd.solutions.mireproductor;

import javafx.scene.layout.VBox;

public class BarraInferior extends VBox {

    public BarraInferior(){
        getChildren().addAll(BarraTiempo.getBarra(), new Botones());
    }

}
