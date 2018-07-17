package com.thoughtworks.tdd.skiptocontroller;

import com.thoughtworks.tdd.Controller;

public class SkipToParkOrUnpark implements SkipToController {
    private Controller controller = new Controller();
    private boolean isNeedParam;

    public SkipToParkOrUnpark(boolean isNeedParam) {
        this.isNeedParam = isNeedParam;
    }

    public String skip(String parameter) {
        return controller.parkOrUnpark(parameter);
    }

    public boolean isNeedParam() {
        return isNeedParam;
    }
}
