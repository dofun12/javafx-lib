package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.controller.factory.DefaultController;
import sample.controller.factory.Router;
import sample.structure.App;

public class Main extends Application {
    private Stage stage;
    private Scene scene;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.stage = primaryStage;
        this.stage.setTitle("Hello World");

        App app = Applications.getApplication(Constants.INITIAL_APPLICATION);
        loadScene(app.getPath(),app.getControlerClass());
    }

    public <T extends DefaultController> void loadScene(String path, Class<T> controller){
        Router.load(path,controller,stage,scene,this);
    }

    public void setTitle(String title){
        this.setTitle(title);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
