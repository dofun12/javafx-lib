package sample.structure;

import sample.controller.AnotherController;
import sample.controller.SampleController;
import sample.controller.factory.DefaultController;

import java.util.ArrayList;
import java.util.List;

public class Applications {
    private static List<App> appList = new ArrayList<App>();

    static {
        add(new App("sample", "/sample.fxml", SampleController.class));
        add(new App("another", "/another.fxml", AnotherController.class));
    }

    private static void add(App app) {
        appList.add(app);
    }

    public static App getApplication(String name) {
        for (App app : appList) {
            if (app.getName().equals(name)) {
                return app;
            }
        }
        return null;
    }


}