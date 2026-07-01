package com.jd.solutions.mireproductor;

import com.sun.tools.javac.Main;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;


public class BarraSuperior extends MenuBar {

    private Menu menuArchivo;
    private MenuItem iAbrir, iSalir;

    public BarraSuperior() {
        menuArchivo = new Menu("Archivo");
        iAbrir = new MenuItem("Abrir");
        iSalir = new MenuItem("Salir");
        
        prepararListener();
        prepararMenus();
    }

    private void prepararMenus() {
        menuArchivo.getItems().addAll(iAbrir, iSalir);
        getMenus().add(menuArchivo);
    }

    private void prepararListener() {
        iAbrir.setOnAction(e -> ExploradorArchivos.seleccionarArchivo());
        iSalir.setOnAction(e -> System.exit(0));
    }

}
