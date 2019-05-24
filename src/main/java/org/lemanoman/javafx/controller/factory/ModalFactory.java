package org.lemanoman.javafx.controller.factory;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.lemanoman.javafx.Constants;
import org.lemanoman.javafx.Parameters;
import org.lemanoman.javafx.structure.Component;

import java.io.IOException;

public class ModalFactory {

    public static <T extends  DefaultController> T buildModal(String path, Class<T> controller,Application application){
        try {
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);

            DefaultController defaultController = controller.newInstance();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(controller.getResource(path));
            loader.setController(defaultController);
            Pane root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            defaultController.inject(stage,scene,application);
            stage.sizeToScene();
            return (T)defaultController;
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
