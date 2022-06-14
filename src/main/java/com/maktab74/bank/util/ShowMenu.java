package com.maktab74.bank.util;

import com.maktab74.bank.domain.User;

public class ShowMenu {

    public static void selectAccountOrCartOrTransactin() {
        System.out.println("select number");
        System.out.println("1 : Account");
        System.out.println("2 :Cart ");
        System.out.println("3 : Transaction");
        System.out.println("4 : Exit");

    }

    public static void wrongNumber() {
        System.out.println("number is wrong ...");
    }

    public static void curentNumber() {

        System.out.println("please currnt number ...");
    }

    public static void loginAndCreateUser() {

        System.out.println("1 : login");
        System.out.println("2 : create");
        System.out.println("3 : exit");
    }

    public static void showfirstName() {
        System.out.println("please enter firstName");
    }

    public static void showLastName() {
        System.out.println("please enter lastName");
    }

    public static void showUserName() {

        System.out.println("please enter userName");
    }

    public static void showGender() {

        System.out.println("please enter gender");
        System.out.println("please type male Or female");
    }

    public static void showAge() {

        System.out.println("please enter age");
    }

    public static void showPhoneNumber() {

        System.out.println("please enter phoneNumber");
    }

    public static void showPassword() {
        System.out.println("please enter pasword");
    }

    public static void showCodeNumber() {

        System.out.println("please enter customerCodeNumber");
    }

    public static void createSuccesfully() {

        System.out.println("Create succesfully");
    }

    public static void loginFail() {

        System.out.println(" wrong username Or pasword !!!");
    }

    public static void loginSuccesfully(User current) {

        System.out.println(" Welcome To Pannel \t");
        System.out.print(current.getFirstName());
        System.out.print(" \t " + current.getLastName());
    }
}