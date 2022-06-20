package com.maktab74.bank.util;

import java.util.Random;

public class CodeUinq {
    public static void main(String[] args) {
        int a = randomCcv2();

    }

    public static long randomCode() {
        Random random = new Random();
        int randomCode = random.nextInt(999999999);
        return randomCode;
    }

    public static int randomCcv2() {

        Random random = new Random();
        int randomCvv2 = random.nextInt(8999) + 1000;
        return randomCvv2;
    }

    public static long randomCard() {
        Random random = new Random();
        Long randomCode = random.nextLong();
        return randomCode;
    }
}