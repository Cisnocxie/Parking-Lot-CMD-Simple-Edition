package com.thoughtworks.tdd.core;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ParkingBoy {
    private List<ParkingLot> parkingLots;

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }
    public ParkingBoy() {}

    public Receipt park(Car car) {
        for (int i = 0; i < parkingLots.size(); i++) {
            if (!parkingLots.get(i).isFull()) {
                return parkingLots.get(i).park(car);
            }
        }
        throw new ParkingFullException();
    }

    public Car unpark(Receipt receipt) {
        Car car = null;
        for (ParkingLot p : parkingLots) {
            car = p.unpark(receipt);
            if (car != null) break;
        }
        return car;
    }

    public boolean isFull() {
        boolean isFull = true;
        if (parkingLots != null) {
            isFull = parkingLots.stream().allMatch(ParkingLot::isFull);
        }
        return isFull;
    }

    public boolean addParkingLot(String name, int size) {
        if (parkingLots == null) {
            parkingLots = new ArrayList<ParkingLot>();
            return parkingLots.add(new ParkingLot("001", name, size));
        } else {
            int idNum = IntStream.range(1,1000).filter(i -> parkingLots.stream().allMatch(j -> !j.getId().equals("000".substring(0, String.valueOf(i).length() + 1) + i))).findFirst().getAsInt();
            String id = "000".substring(0, String.valueOf(idNum).length() + 1) + idNum;
            return parkingLots.add(new ParkingLot(id, name, size));
        }
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    public String deleteParkingLot(String id) {
        String result = "停车场删除失败，原因：此停车场不存在！";
        if (parkingLots != null) {
            for (ParkingLot parkingLot : parkingLots) {
                if (parkingLot.getId().equals(id)) {
                    if (parkingLot.getCarList().size() != 0) {
                        result = "停车场删除失败，原因：此停车场中，依然停有汽车，无法删除！";
                        break;
                    } else {
                        parkingLots.remove(parkingLot);
                        result = "停车场删除成功！";
                        break;
                    }
                }
            }
        }
        return result;
    }
}
