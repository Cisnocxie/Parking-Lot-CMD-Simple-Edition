package com.thoughtworks.tdd;

public class Router {
    private Controller controller = new Controller();
    private View view = new View();

    public void forwardNextPage(String page, String parameter) {
        switch (page) {
            case "parkorunpark":
                chooseNextPage(controller.parkOrUnpark(parameter));
                break;
            case "park":
                chooseNextPage(controller.controlPark());
                break;
            case "canpark":
                chooseNextPage(controller.genReceipt(parameter));
                break;
            case "unpark":
                chooseNextPage(controller.controlUnpark(parameter));
                break;
            case "rootpage":
                chooseNextPage(controller.rootInterface());
                break;
            case "manageorserve":
                chooseNextPage(controller.manageOrServe(parameter));
                break;
            case "printaddordelete":
                chooseNextPage(controller.printAddOrDelete(parameter));
                break;
            case "addparkinglot":
                chooseNextPage(controller.addParkingLot(parameter));
                break;
            case "deleteparkinglot":
                chooseNextPage(controller.deleteParkingLot(parameter));
                break;
        }
    }

    public void chooseNextPage(String page) {
        switch (page) {
            case "rootpage":
            case "park":
                forwardNextPage(page, null);
                break;
            case "parkorunpark":
            case "canpark":
            case "unpark":
            case "manageorserve":
            case "printaddordelete":
            case "addparkinglot":
            case "deleteparkinglot":
                forwardNextPage(page, view.getInput());
                break;
        }
    }
}
