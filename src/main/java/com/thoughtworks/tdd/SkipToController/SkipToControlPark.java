package com.thoughtworks.tdd.SkipToController;

import com.thoughtworks.tdd.Controller;

public class SkipToControlPark implements SkipToController {
    private Controller controller = new Controller();
    private boolean isNeedParam;

    public SkipToControlPark(boolean isNeedParam) {
        this.isNeedParam = isNeedParam;
    }

    public String skip(String parameter) {
        return controller.controlPark();
    }

    public boolean isNeedParam() {
        return isNeedParam;
    }
}
