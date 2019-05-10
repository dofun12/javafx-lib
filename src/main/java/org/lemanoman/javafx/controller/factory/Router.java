package org.lemanoman.javafx.controller.factory;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.lemanoman.javafx.Constants;
import org.lemanoman.javafx.Parameters;
import org.lemanoman.javafx.structure.App;

import java.io.IOException;

public class Router {

    public static <T extends DefaultController> void load(App app, Stage stage, Scene scene, Application application){
        load(app.getPath(),app.getControlerClass(),stage,scene,application,null);
    }

    public static <T extends DefaultController> void load(App app, Stage stage, Scene scene, Application application,Parameters parameters){
        load(app.getPath(),app.getControlerClass(),stage,scene,application,parameters);
    }

    public static <T extends DefaultController> void load(String path, Class<T> controller, Stage stage, Scene scene, Application application){
        load(path,controller,stage,scene,application,null);
    }

    public static <T extends DefaultController> void load(String path, Class<T> controller, Stage stage, Scene scene, Application application, Parameters parameters){
        try {
            DefaultController defaultController = controller.newInstance();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(controller.getResource(path));
            loader.setController(defaultController);
            Pane root = loader.load();
            scene = new Scene(root,Constants.DEFAULT_WIDTH,Constants.DEFAULT_WIDTH);
            defaultController.setParameters(parameters);
            defaultController.inject(stage,scene,application);
            stage.setScene(scene);

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
