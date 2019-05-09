package sample.controller.factory;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.Constants;
import sample.controller.factory.DefaultController;

import java.io.IOException;

public class Router {

    public static <T extends DefaultController> void loadScene(String path, Class<T> controller, Stage stage, Scene scene, Application application){
        try {
            DefaultController defaultController = controller.newInstance();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(controller.getResource(path));
            loader.setController(defaultController);
            Pane root = loader.load();
            scene = new Scene(root,Constants.DEFAULT_WIDTH,Constants.DEFAULT_WIDTH);
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
