package org.lemanoman.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.lemanoman.javafx.controller.factory.Router;
import org.lemanoman.javafx.controller.factory.DefaultController;
import org.lemanoman.javafx.structure.App;

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
