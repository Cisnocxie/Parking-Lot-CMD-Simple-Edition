package com.thoughtworks.tdd.skiptocontroller;

import com.thoughtworks.tdd.Controller;

public class SkipToPrintAddOrDelete implements SkipToController {
    private Controller controller = new Controller();
    private boolean isNeedParam;

    public SkipToPrintAddOrDelete(boolean isNeedParam) {
        this.isNeedParam = isNeedParam;
    }

    public String skip(String parameter) {
        return controller.printAddOrDelete(parameter);
    }

    public boolean isNeedParam() {
        return isNeedParam;
    }
}
