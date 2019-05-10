package org.lemanoman.javafx.structure;

import org.lemanoman.javafx.controller.factory.DefaultController;

public class App {
    private String name;
    private Class<? extends DefaultController> controlerClass;
    private String path;

    public App(String name, String path, Class<? extends DefaultController> controlerClass) {
        this.name = name;
        this.controlerClass = controlerClass;
        this.path = path;
    }

    public Class<? extends DefaultController> getControlerClass() {
        return controlerClass;
    }

    public void setControlerClass(Class<? extends DefaultController> controlerClass) {
        this.controlerClass = controlerClass;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
