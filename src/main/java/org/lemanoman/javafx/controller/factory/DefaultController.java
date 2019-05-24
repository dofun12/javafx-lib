package org.lemanoman.javafx.controller.factory;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import org.lemanoman.javafx.Applications;
import org.lemanoman.javafx.Parameters;
import org.lemanoman.javafx.structure.App;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class DefaultController implements ControllerInterface {
    private Stage stage;
    private Scene scene;
    private Application application;
    private Parameters parameters = new Parameters();


    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

    public void inject(Stage stage, Scene scene, Application application) {
        this.application = application;
        this.scene = scene;
        this.stage = stage;
        onInit(parameters);
    }

    public <T extends DefaultController> void loadScene(String path, Class<T> controller) {
        Router.load(path, controller, stage, scene, application, null);
    }

    public <T extends DefaultController> void loadScene(String path, Class<T> controller, Parameters parameters) {
        Router.load(path, controller, stage, scene, application, parameters);
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

    public void addCss(String path) {
        String css = this.getClass().getResource(path).toExternalForm();
        if (css != null) {
            scene.getStylesheets().add(css);
        }
    }

    public void loadApp(App app, Parameters parameters) {
        Router.load(app, stage, scene, application, parameters);

    }

    public Node getByStyleClass(String styleClass, Parent parent) {
        List<Node> founded = new ArrayList<Node>();
        List<Node> nodes = getAllDescendents(parent, new ArrayList<Node>());


        for (Node node : nodes) {
            node.getStyleClass().forEach(styleClassTmp -> {
                if (styleClassTmp.equals(styleClass)) {
                    founded.add(node);
                }
            });
        }
        if(founded!=null && !founded.isEmpty()){
            return founded.get(0);
        }
        return null;
    }

    public List<Node> findByStyleClass(String styleClass, Parent parent) {
        List<Node> founded = new ArrayList<Node>();
        List<Node> nodes = getAllDescendents(parent, new ArrayList<Node>());


        for (Node node : nodes) {
            node.getStyleClass().forEach(styleClassTmp -> {
                if (styleClassTmp.equals(styleClass)) {
                    founded.add(node);
                }
            });
        }
        return founded;
    }

    public List<Node> findByStyleClass(String styleClass) {
        List<Node> founded = new ArrayList<Node>();
        List<Node> nodes = getAllDescendents(getScene().getRoot(), new ArrayList<Node>());


        for (Node node : nodes) {
            node.getStyleClass().forEach(styleClassTmp -> {
                if (styleClassTmp.equals(styleClass)) {
                    founded.add(node);
                }
            });
        }
        return founded;
    }

    public List<Node> getAllDescendents(Parent parent, ArrayList<Node> nodes) {
        for (Node node : parent.getChildrenUnmodifiable()) {
            nodes.add(node);
            if (node instanceof Parent) {
                getAllDescendents((Parent) node, nodes);
            }
        }
        return nodes;
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
