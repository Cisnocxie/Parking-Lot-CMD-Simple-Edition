package com.thoughtworks.tdd;

import java.util.Scanner;

public class View {
    Scanner scanner = new Scanner(System.in);

    public void showOutput(String output) {
        System.out.println(output);
    }

    public String getInput() {
        return scanner.next();
    }
}
