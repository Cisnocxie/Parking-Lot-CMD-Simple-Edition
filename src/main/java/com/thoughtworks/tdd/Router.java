package com.thoughtworks.tdd;

import com.thoughtworks.tdd.request.Request;
import com.thoughtworks.tdd.skiptocontroller.SkipToController;

import java.util.HashMap;
import java.util.Map;

public class Router {
    private Request request;
    private Map<String, SkipToController> URLMapping = new HashMap<>();

    public Router(Request request) {
        this.request = request;
    }

    public void forwardNextPage(String page, String parameter) {
        chooseNextPage(URLMapping.get(page).skip(parameter));
    }

    public void addURLmapping(String page, SkipToController skipToController) {
        URLMapping.put(page, skipToController);
    }

    public void chooseNextPage(String page) {
        if (URLMapping.get(page).isNeedParam()) {
            forwardNextPage(page, request.getInput());
        } else {
            forwardNextPage(page, null);
        }
    }
}
