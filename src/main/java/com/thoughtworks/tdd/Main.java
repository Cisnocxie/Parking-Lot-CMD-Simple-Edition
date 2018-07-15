package com.thoughtworks.tdd;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller(new ParkingLot(1));

        while (true) {
            controller.userInterface();
        }
    }
}
