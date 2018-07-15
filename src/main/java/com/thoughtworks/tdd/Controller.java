package com.thoughtworks.tdd;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Controller {
    private ParkingLot parkingLot;
    private Map<Receipt, String> receiptAndPlateNumber = new HashMap<>();
    private Map<String, Receipt> receiptNumberAndReceipt = new HashMap<>();
    private View view = new View();
    private Scanner scanner = new Scanner(System.in);

    public Controller(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public void ParkOrUnpark(String input) {
        if (input == null || (!input.equals("1") && !input.equals("2"))) {
            view.showOutput("非法指令，请查证后再输");
        } else if (input.equals("1")) {
            controlPark();
        } else {
            view.showOutput("请输入小票编号：");
            controlUnpark(scanner.next());
        }
    }

    public void controlPark() {
        if (parkingLot.isFull()) {
            view.showOutput("车已停满，请晚点再来");
        } else {
            view.showOutput("请输入车牌号:");
            genReceipt(scanner.next());
        }
    }

    public void genReceipt(String plateNumber) {
        Car car = new Car();
        Receipt receipt = parkingLot.park(car);
        receiptNumberAndReceipt.put(String.valueOf(receipt.hashCode()), receipt);
        receiptAndPlateNumber.put(receipt, plateNumber);
        view.showOutput("停车成功，您的小票是：\n" + String.valueOf(receipt.hashCode()));
    }

    public void controlUnpark(String receiptNumber) {
        if (receiptNumberAndReceipt.get(receiptNumber) != null) {
            Receipt receipt = receiptNumberAndReceipt.remove(receiptNumber);
            parkingLot.unpark(receipt);
            view.showOutput("车已取出，您的车牌号是: " + receiptAndPlateNumber.remove(receipt));
        } else {
            view.showOutput("非法小票，无法取出车，请查证后再输");
        }
    }

    public void userInterface() {
        view.showOutput("1. 停车\n" +
                "2. 取车 \n" +
                "请输入您要进行的操作：");
        ParkOrUnpark(scanner.next());
    }
}
