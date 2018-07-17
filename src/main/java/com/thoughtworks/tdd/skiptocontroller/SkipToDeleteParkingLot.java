package com.thoughtworks.tdd.skiptocontroller;

import com.thoughtworks.tdd.Controller;

public class SkipToDeleteParkingLot implements SkipToController {
    private Controller controller = new Controller();
    private boolean isNeedParam;

    public SkipToDeleteParkingLot(boolean isNeedParam) {
        this.isNeedParam = isNeedParam;
    }

    public String skip(String parameter) {
        return controller.deleteParkingLot(parameter);
    }

    public boolean isNeedParam() {
        return isNeedParam;
    }
}
