package com.thoughtworks.tdd;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

public class Controller {
    private ParkingLot parkingLot = new ParkingLot(1);
    private Map<Receipt, String> receiptAndPlateNumber = new HashMap<>();
    private Map<String, Receipt> receiptNumberAndReceipt = new HashMap<>();
    private View view = new View();
    private Scanner scanner = new Scanner(System.in);

    public String parkOrUnpark(String input) {
        String nextPage = null;
        if (input == null || (!input.equals("1") && !input.equals("2"))) {
            view.showOutput("非法指令，请查证后再输");
            nextPage = "homepage";
        } else if (input.equals("1")) {
            nextPage = controlPark();
        } else {
            view.showOutput("请输入小票编号：");
            nextPage = "unpark";
        }
        return nextPage;
    }

    public String controlPark() {
        String nextPage = null;
        if (parkingLot.isFull()) {
            view.showOutput("车已停满，请晚点再来");
            nextPage = "homepage";
        } else {
            view.showOutput("请输入车牌号:");
            nextPage = "canpark";
        }
        return nextPage;
    }

    public String genReceipt(String plateNumber) {
        Car car = new Car();
        Receipt receipt = parkingLot.park(car);
        String receiptNumber = UUID.randomUUID().toString();
        receiptNumberAndReceipt.put(receiptNumber, receipt);
        receiptAndPlateNumber.put(receipt, plateNumber);
        view.showOutput("停车成功，您的小票是：\n" + receiptNumber);
        return "homepage";
    }

    public String controlUnpark(String receiptNumber) {
        if (receiptNumberAndReceipt.get(receiptNumber) != null) {
            Receipt receipt = receiptNumberAndReceipt.remove(receiptNumber);
            parkingLot.unpark(receipt);
            view.showOutput("车已取出，您的车牌号是: " + receiptAndPlateNumber.remove(receipt));
        } else {
            view.showOutput("非法小票，无法取出车，请查证后再输");
        }
        return "homepage";
    }

    public String userInterface() {
        view.showOutput("1. 停车\n" +
                "2. 取车 \n" +
                "请输入您要进行的操作：");
        return "parkorunpark";
    }
}
