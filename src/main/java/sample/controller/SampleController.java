package sample.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sample.controller.factory.DefaultController;

public class SampleController extends DefaultController {
    @FXML
    Button btn;


    @Override
    public void onInit() {
        System.out.println("Iniciou");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                loadScene("/another.fxml",AnotherController.class);
            }
        });
    }
}
