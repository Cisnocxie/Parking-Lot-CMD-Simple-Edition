package com.thoughtworks.tdd.response;

import com.thoughtworks.tdd.core.ParkingLot;

import java.util.List;
import java.util.Scanner;

public class Response {
    Scanner scanner = new Scanner(System.in);

    public void showOutput(String output) {
        System.out.println(output);
    }

    public void showParkingLots(List<ParkingLot> parkingLots) {
        StringBuffer stringBuffer = new StringBuffer("|停车场ID|名称|车位|已停车辆|剩余车位|\n" +
                "======================================\n");
        int totalSize = 0;
        int totalParkedSize = 0;
        int totalResidualSize = 0;
        if (parkingLots != null) {
            for (ParkingLot parkingLot : parkingLots) {
                int parkingLotSize = parkingLot.getSize();
                int parkedNum = parkingLot.getCarList().size();
                int residualNum = parkingLotSize - parkedNum;
                totalSize += parkingLotSize;
                totalParkedSize += parkedNum;
                totalResidualSize += residualNum;
                stringBuffer.append("|" + parkingLot.getId() + "|" + parkingLot.getName() + "|" + parkingLotSize + "(个)|" + parkedNum + "(辆)|" + residualNum + "(个)|\n");
            }
        }
        stringBuffer.append("\n总车位：" + totalSize + "(个)\n" +
                "停车总量：" + totalParkedSize + "（辆）\n" +
                "总剩余车位：" + totalResidualSize + "（个）");
        showOutput(stringBuffer.toString());
    }
}
