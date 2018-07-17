package com.thoughtworks.tdd.core;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private String id;
    private String name;
    private int size;
    private Map<Receipt, Car> carList;

    public ParkingLot(String id, String name, int size) {
        this.id = id;
        this.name = name;
        this.size = size;
        carList = new HashMap<Receipt, Car>();
    }

    public Receipt park(Car car) {
        if (carList.size() == size) {
            throw new ParkingFullException();
        }
        Receipt receipt = new Receipt();
        carList.put(receipt, car);
        return receipt;
    }

    public Car unpark(Receipt receipt) {
        return carList.remove(receipt);
    }

    public boolean isFull() {
        return carList.size() == size;
    }

    public String getId() { return id;}

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public Map<Receipt, Car> getCarList() { return carList; }
}
