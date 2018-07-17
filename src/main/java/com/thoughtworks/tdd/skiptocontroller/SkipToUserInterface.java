package com.thoughtworks.tdd.skiptocontroller;

import com.thoughtworks.tdd.Controller;

public class SkipToUserInterface implements SkipToController {
    private Controller controller = new Controller();
    private boolean isNeedParam;

    public SkipToUserInterface(boolean isNeedParam) {
        this.isNeedParam = isNeedParam;
    }

    public String skip(String parameter) {
        return controller.userInterface();
    }

    public boolean isNeedParam() {
        return isNeedParam;
    }
}
