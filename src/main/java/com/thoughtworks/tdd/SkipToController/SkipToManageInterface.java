package com.thoughtworks.tdd.SkipToController;

import com.thoughtworks.tdd.Controller;

public class SkipToManageInterface implements SkipToController {
    private Controller controller = new Controller();
    private boolean isNeedParam;

    public SkipToManageInterface(boolean isNeedParam) {
        this.isNeedParam = isNeedParam;
    }

    public String skip(String parameter) {
        return controller.manageInterface();
    }

    public boolean isNeedParam() {
        return isNeedParam;
    }
}
