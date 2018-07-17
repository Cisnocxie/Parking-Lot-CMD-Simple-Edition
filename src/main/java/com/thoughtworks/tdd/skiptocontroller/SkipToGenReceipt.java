package com.thoughtworks.tdd.skiptocontroller;

import com.thoughtworks.tdd.Controller;

public class SkipToGenReceipt implements SkipToController {
    private Controller controller = new Controller();
    private boolean isNeedParam;

    public SkipToGenReceipt(boolean isNeedParam) {
        this.isNeedParam = isNeedParam;
    }

    public String skip(String parameter) {
        return controller.genReceipt(parameter);
    }

    public boolean isNeedParam() {
        return isNeedParam;
    }
}
