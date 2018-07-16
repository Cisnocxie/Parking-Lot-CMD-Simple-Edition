package com.thoughtworks.tdd.SkipToController;

import com.thoughtworks.tdd.Controller;

public class SkipToManageOrServe implements SkipToController {
    private Controller controller = new Controller();
    private boolean isNeedParam;

    public SkipToManageOrServe(boolean isNeedParam) {
        this.isNeedParam = isNeedParam;
    }

    public String skip(String parameter) {
        return controller.manageOrServe(parameter);
    }

    public boolean isNeedParam() {
        return isNeedParam;
    }
}
