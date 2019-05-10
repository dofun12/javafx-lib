package org.lemanoman.javafx.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.lemanoman.javafx.Applications;
import org.lemanoman.javafx.Parameters;
import org.lemanoman.javafx.controller.factory.DefaultController;

public class SampleController extends DefaultController {
    @FXML
    Button btn;


    @Override
    public void onInit(Parameters parameters) {
        System.out.println("Iniciou");
        getStage().setTitle(Applications.SAMPLE_APP.getName());
        btn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                loadScene("/another.fxml",AnotherController.class);
            }
        });
    }
}
