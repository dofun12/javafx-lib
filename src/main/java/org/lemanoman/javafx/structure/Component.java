package org.lemanoman.javafx.structure;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import org.lemanoman.javafx.controller.factory.DefaultController;

public class Component {
    private DefaultController controller;
    private Pane rootPane;
    private Scene scene;

    public DefaultController getController() {
        return controller;
    }

    public void setController(DefaultController controller) {
        this.controller = controller;
    }

    public Pane getRootPane() {
        return rootPane;
    }

    public void setRootPane(Pane rootPane) {
        this.rootPane = rootPane;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }
}
