package com.thoughtworks.tdd.skiptocontroller;

import com.thoughtworks.tdd.Controller;

public class SkipToAddParkingLot implements SkipToController {
    private Controller controller = new Controller();
    private boolean isNeedParam;

    public SkipToAddParkingLot(boolean isNeedParam) {
        this.isNeedParam = isNeedParam;
    }

    public String skip(String parameter) {
        return controller.addParkingLot(parameter);
    }

    public boolean isNeedParam() {
        return isNeedParam;
    }
}
