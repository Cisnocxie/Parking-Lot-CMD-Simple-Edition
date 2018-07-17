package com.thoughtworks.tdd;

import com.thoughtworks.tdd.skiptocontroller.*;

public class Main {
    public static void main(String[] args) {
        Router router = new Router();
        addURLMapping(router);
        while (true) {
            router.chooseNextPage("rootpage");
        }
    }

    public static void addURLMapping(Router router) {
        router.addURLmapping("rootpage", new SkipToRootInterface(false));
        router.addURLmapping("park", new SkipToControlPark(false));
        router.addURLmapping("servepage", new SkipToUserInterface(false));
        router.addURLmapping("managepage", new SkipToManageInterface(false));
        router.addURLmapping("parkorunpark", new SkipToParkOrUnpark(true));
        router.addURLmapping("canpark", new SkipToGenReceipt(true));
        router.addURLmapping("unpark", new SkipToControlUnpark(true));
        router.addURLmapping("manageorserve", new SkipToManageOrServe(true));
        router.addURLmapping("printaddordelete", new SkipToPrintAddOrDelete(true));
        router.addURLmapping("addparkinglot", new SkipToAddParkingLot(true));
        router.addURLmapping("deleteparkinglot", new SkipToDeleteParkingLot(true));
    }
}
