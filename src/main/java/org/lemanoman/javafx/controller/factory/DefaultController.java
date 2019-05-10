package org.lemanoman.javafx.controller.factory;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.lemanoman.javafx.Applications;
import org.lemanoman.javafx.Parameters;
import org.lemanoman.javafx.structure.App;

import java.util.ResourceBundle;

public class DefaultController implements ControllerInterface {
    private Stage stage;
    private Scene scene;
    private Application application;
    private Parameters parameters = new Parameters();


    public void setParameters(Parameters parameters){
        this.parameters = parameters;
    }

    public void inject(Stage stage, Scene scene, Application application) {
        this.application = application;
        this.scene = scene;
        this.stage = stage;
        onInit(parameters);
    }

    public <T extends DefaultController> void loadScene(String path, Class<T> controller) {
        Router.load(path, controller, stage, scene, application,null);
    }

    public <T extends DefaultController> void loadScene(String path, Class<T> controller,Parameters parameters) {
        Router.load(path, controller, stage, scene, application,parameters);
    }

    public void loadApp(String name) {
        App app = Applications.getApplication(name);
        if (app != null) {
            Router.load(app, stage, scene, application);
        }

    }

    public void loadApp(App app) {
        Router.load(app, stage, scene, application);

    }

    public void loadApp(App app,Parameters parameters) {
        Router.load(app, stage, scene, application,parameters);

    }

    public Stage getStage() {
        return stage;
    }

    public Scene getScene() {
        return scene;
    }

    public Application getApplication() {
        return application;
    }

    public void onInit(Parameters parameters) {
    }
}
