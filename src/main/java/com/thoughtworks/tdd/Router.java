package com.thoughtworks.tdd;

public class Router {
    private Controller controller = new Controller();
    private View view = new View();

    public void forwardNextPage(String page, String Parameter) {
        switch (page) {
            case "homepage":
                chooseNextPage(controller.userInterface());
                break;
            case "parkorunpark":
                chooseNextPage(controller.parkOrUnpark(Parameter));
                break;
            case "park":
                chooseNextPage(controller.controlPark());
                break;
            case "canpark":
                chooseNextPage(controller.genReceipt(Parameter));
                break;
            case "unpark":
                chooseNextPage(controller.controlUnpark(Parameter));
                break;
        }
    }

    public void chooseNextPage(String page) {
        switch (page) {
            case "homepage":
                forwardNextPage(page, null);
                break;
            case "parkorunpark":
                forwardNextPage(page, view.getInput());
                break;
            case "park":
                forwardNextPage(page, null);
            case "canpark":
                forwardNextPage(page, view.getInput());
            case "unpark":
                forwardNextPage(page, view.getInput());
        }
    }
}
