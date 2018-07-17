package com.thoughtworks.tdd.skiptocontroller;

import com.thoughtworks.tdd.Controller;

public class SkipToRootInterface implements SkipToController {
    private Controller controller = new Controller();
    private boolean isNeedParam;

    public SkipToRootInterface(boolean isNeedParam) {
        this.isNeedParam = isNeedParam;
    }

    public String skip(String parameter) {
        return controller.rootInterface();
    }

    public boolean isNeedParam() {
        return isNeedParam;
    }
}
