package org.lemanoman.javafx.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import org.lemanoman.javafx.Applications;
import org.lemanoman.javafx.controller.factory.DefaultController;


public class AnotherController extends DefaultController {

    @Override
    public void onInit() {
        System.out.println("Iniciou");
        getStage().setTitle(Applications.ANOTHER_APP.getName());
        System.out.println("FOi dnv");

        Button button = (Button) getScene().lookup("#btnVoltar");
        button.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                loadApp(Applications.SAMPLE_APP);
            }
        });
    }
}
