package com.thoughtworks.tdd;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Router router = new Router();
        while (true) {
            router.chooseNextPage("homepage");
        }
    }
}
