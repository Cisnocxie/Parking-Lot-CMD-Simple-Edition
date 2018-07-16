package com.thoughtworks.tdd;

import com.thoughtworks.tdd.SkipToController.SkipToController;

import java.util.HashMap;
import java.util.Map;

public class Router {
    private Controller controller = new Controller();
    private View view = new View();
    private Map<String, SkipToController> URLMapping = new HashMap<>();

    public void forwardNextPage(String page, String parameter) {
        chooseNextPage(URLMapping.get(page).skip(parameter));
    }

    public void addURLmapping(String page, SkipToController skipToController) {
        URLMapping.put(page, skipToController);
    }

    public void chooseNextPage(String page) {
        if (URLMapping.get(page).isNeedParam()) {
            forwardNextPage(page, view.getInput());
        } else {
            forwardNextPage(page, null);
        }
    }
}
