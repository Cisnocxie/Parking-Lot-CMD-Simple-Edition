package com.thoughtworks.tdd;

import com.thoughtworks.tdd.core.Car;
import com.thoughtworks.tdd.core.ParkingBoy;
import com.thoughtworks.tdd.core.Receipt;
import com.thoughtworks.tdd.response.Response;

import java.util.*;

public class Controller {
    private static ParkingBoy parkingBoy = new ParkingBoy();
    private Map<Receipt, String> receiptAndPlateNumber = new HashMap<>();
    private Map<String, Receipt> receiptNumberAndReceipt = new HashMap<>();
    private Response response = new Response();

    public String parkOrUnpark(String input) {
        String nextPage = null;
        if (input == null || (!input.equals("1") && !input.equals("2"))) {
            response.showOutput("非法指令，请查证后再输");
            nextPage = "rootpage";
        } else if (input.equals("1")) {
            nextPage = "park";
        } else {
            response.showOutput("请输入小票编号：");
            nextPage = "unpark";
        }
        return nextPage;
    }

    public String controlPark() {
        String nextPage = null;
        if (parkingBoy.isFull()) {
            response.showOutput("车已停满，请晚点再来");
            nextPage = "rootpage";
        } else {
            response.showOutput("请输入车牌号:");
            nextPage = "canpark";
        }
        return nextPage;
    }

    public String genReceipt(String plateNumber) {
        Car car = new Car();
        Receipt receipt = parkingBoy.park(car);
        String receiptNumber = UUID.randomUUID().toString();
        receiptNumberAndReceipt.put(receiptNumber, receipt);
        receiptAndPlateNumber.put(receipt, plateNumber);
        response.showOutput("停车成功，您的小票是：\n" + receiptNumber);
        return "rootpage";
    }

    public String controlUnpark(String receiptNumber) {
        if (receiptNumberAndReceipt.get(receiptNumber) != null) {
            Receipt receipt = receiptNumberAndReceipt.remove(receiptNumber);
            parkingBoy.unpark(receipt);
            response.showOutput("车已取出，您的车牌号是: " + receiptAndPlateNumber.remove(receipt));
        } else {
            response.showOutput("非法小票，无法取出车，请查证后再输");
        }
        return "rootpage";
    }

    public String userInterface() {
        response.showOutput("1. 停车\n" +
                "2. 取车 \n" +
                "请输入您要进行的操作：");
        return "parkorunpark";
    }

    public String rootInterface() {
        response.showOutput("1.停车服务\n" +
                "2.停车场管理\n" +
                "请输入您要进入的页面：");
        return "manageorserve";
    }

    public String manageInterface() {
        response.showOutput("1.查看停车场详情\n" +
                "2.添加停车场\n" +
                "3.删除停车场");
        return "printaddordelete";
    }

    public String manageOrServe(String input) {
        String nextPage = null;
        if (input == null || (!input.equals("1") && !input.equals("2"))) {
            response.showOutput("非法指令，请查证后再输");
            nextPage = "rootpage";
        } else if (input.equals("1")) {
            nextPage = "servepage";
        } else {
            nextPage = "managepage";
        }
        return nextPage;
    }

    public String printAddOrDelete(String input) {
        String nextPage = null;
        switch (input) {
            case "1":
                response.showParkingLots(parkingBoy.getParkingLots());
                nextPage = "rootpage";
                break;
            case "2":
                response.showOutput("请输入你套添加的停车场信息（格式为：名称，车位）：");
                nextPage = "addparkinglot";
                break;
            case "3":
                response.showOutput("请输入需要删除的被管理停车场ID:");
                nextPage = "deleteparkinglot";
                break;
            default:
                response.showOutput("非法指令，请查证后再输");
                nextPage = "rootpage";
        }
        return nextPage;
    }

    public String addParkingLot(String input) {
        if (input.matches(".*，\\d+")) {
            String[] nameAndSize = input.split("，");
            parkingBoy.addParkingLot(nameAndSize[0], Integer.parseInt(nameAndSize[1]));
            response.showOutput("停车场添加成功！");
        } else {
            response.showOutput("停车场添加失败，输入格式有误");
        }
        return "rootpage";
    }

    public String deleteParkingLot(String input) {
        response.showOutput(parkingBoy.deleteParkingLot(input));
        return "rootpage";
    }
}
