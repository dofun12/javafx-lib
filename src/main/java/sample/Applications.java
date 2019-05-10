package sample;

import sample.controller.AnotherController;
import sample.controller.SampleController;
import sample.controller.factory.DefaultController;
import sample.structure.App;

import java.util.ArrayList;
import java.util.List;

public class Applications {
    private static List<App> appList = new ArrayList<App>();

    public static final App SAMPLE_APP = new App("sample", "/sample.fxml", SampleController.class);
    public static final App ANOTHER_APP = new App("another", "/another.fxml", AnotherController.class);

    static {
        add(SAMPLE_APP);
        add(ANOTHER_APP);
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