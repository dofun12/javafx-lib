package org.lemanoman.javafx.controller.factory;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.lemanoman.javafx.Constants;
import org.lemanoman.javafx.Parameters;
import org.lemanoman.javafx.structure.App;
import org.lemanoman.javafx.structure.Component;

import java.io.IOException;

public class Render {

    public static <T extends  DefaultController> Component load(String path, Class<T> controller, Stage stage, Scene scene, Application application, Parameters parameters){
        try {
            DefaultController defaultController = controller.newInstance();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(controller.getResource(path));
            loader.setController(defaultController);
            Pane root = loader.load();
            scene = new Scene(root,Constants.DEFAULT_WIDTH,Constants.DEFAULT_WIDTH);
            defaultController.setParameters(parameters);
            defaultController.inject(stage,scene,application);
            Component component = new Component();
            component.setController(defaultController);
            component.setRootPane(root);
            component.setScene(scene);
            return component;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
