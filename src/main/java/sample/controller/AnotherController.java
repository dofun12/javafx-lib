package sample.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sample.controller.factory.DefaultController;


public class AnotherController extends DefaultController {

    @Override
    public void onInit() {
        System.out.println("Iniciou");
        getStage().setTitle("uhuuuuuu");
        System.out.println("FOi dnv");

        Button button = (Button) getScene().lookup("#btnVoltar");
        button.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                loadApp("sample");
            }
        });
    }
}