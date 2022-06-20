package com.maktab74.bank.util;

import java.util.Random;

public class CodeUinq {
    public static void main(String[] args) {

        int[] randomArrayCardNumber = RandomCardNumber();

        System.out.println(arratToIntegerCode(randomArrayCardNumber));
    }


    public static int[] RandomCardNumber() {

        int[] arraysNumber = new int[16];

        for (int i = 0; i < arraysNumber.length; i++) {

            arraysNumber[i] = ApplicationContext.random.nextInt(10);

        }
        return arraysNumber;
    }

    public static int[] RandomAccountNumber() {

        int[] arraysNumber = new int[18];

        for (int i = 0; i < arraysNumber.length; i++) {

            arraysNumber[i] = ApplicationContext.random.nextInt(10);

        }
        return arraysNumber;
    }

    public static Long arratToIntegerCode(int[] number) {

        long code = 0;

        for (int i = 0; i < number.length; i++) {

            code = (code * 10) + number[i];
        }
        return code;
    }

    public static long randomCode() {
        Random random = new Random();
        int randomCode = random.nextInt(999999999);

        return randomCode;
    }

    public static int[] randomCcv2() {

        int[] arraysNumber = new int[4];

        for (int i = 0; i < arraysNumber.length; i++) {

            arraysNumber[i] = ApplicationContext.random.nextInt(10);
        }
        return arraysNumber;
    }

    public static int[] randomPersonalCode() {


        int[] arraysNumber = new int[10];

        for (int i = 0; i < arraysNumber.length; i++) {

            arraysNumber[i] = ApplicationContext.random.nextInt(10);
        }
        return arraysNumber;
    }
}