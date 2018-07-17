package com.thoughtworks.tdd.skiptocontroller;

import com.thoughtworks.tdd.Controller;

public class SkipToControlUnpark implements SkipToController {
    private Controller controller = new Controller();
    private boolean isNeedParam;

    public SkipToControlUnpark(boolean isNeedParam) {
        this.isNeedParam = isNeedParam;
    }

    public String skip(String parameter) {
        return controller.controlUnpark(parameter);
    }

    public boolean isNeedParam() {
        return isNeedParam;
    }
}
