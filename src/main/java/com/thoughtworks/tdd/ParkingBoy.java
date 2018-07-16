package com.thoughtworks.tdd;

import java.util.Arrays;
import java.util.List;

public class ParkingBoy {
    private List<ParkingLot> parkingLots;

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

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
        return parkingLots.stream().allMatch(ParkingLot::isFull);
    }
}
