package com.thoughtworks.tdd.request;

import java.util.Scanner;

public class CommandLineRequest implements Request {
    Scanner scanner = new Scanner(System.in);
    public String getInput() {
        return scanner.next();
    }
}
