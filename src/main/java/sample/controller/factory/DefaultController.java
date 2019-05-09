package sample.controller.factory;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.structure.App;
import sample.structure.Applications;

public class DefaultController implements ControllerInterface {
    private Stage stage;
    private Scene scene;
    private Application application;
    public void inject(Stage stage, Scene scene, Application application){
        this.application = application;
        this.scene = scene;
        this.stage = stage;
        onInit();
    }

    public <T extends DefaultController> void loadScene(String path,Class<T> controller){
        Router.loadScene(path,controller,stage,scene,application);
    }

    public void loadApp(String name){
        App app = Applications.getApplication(name);
        if(app!=null){
            Router.loadScene(app.getPath(),app.getControlerClass(),stage,scene,application);
        }

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

    public void onInit() {}
}
