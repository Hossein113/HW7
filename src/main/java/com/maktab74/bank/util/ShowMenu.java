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

    public static void logOff() {
        System.out.println("Log Off succesfully ...");
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

    public static void editeSuccesfully() {

        System.out.println("Edit succesfully");
    }

    public static void deletedSuccesfully() {

        System.out.println("Delet succesfully");
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
        System.out.print(" " + current.getLastName());
        System.out.println("");
    }

    public static void selectCartMenu() {
        System.out.println("select number");
        System.out.println("** 1 : Create defaulte **");
        System.out.println("2 :Edit cart ");
        System.out.println("3 : Deleted cart");
        // System.out.println("4 : Show all Cart");
        System.out.println("4 : back");

    }

    public static void enterNumberCart() {
        System.out.println("please enter number cart :");
    }

    public static void enterccv2Cart() {
        System.out.println("please enter ccv2 cart :");

    }

    public static void enterPasswordCart() {
        System.out.println("please enter Password cart :");

    }

    public static void selectAccounttMenu() {

        System.out.println("select number");
        System.out.println("1 : Create Account");
        System.out.println("2 :Edit Account ");
        System.out.println("3 : Deleted Account");
        System.out.println("4 : show all Account");
        System.out.println("5 : Back");

    }

    public static void enterTitleAccount() {
        System.out.println("please enter Title account :");

    }

    public static void codeNumberAccountCart() {

        System.out.println("please enter codeNumber account :");

    }

    public static void showAllAcount() {
        System.out.println("show All Account :");
    }

    public static void validMoneyInAccount() {
        System.out.println("enter neumber valid money :");

    }

    public static void selectIdCart() {
        System.out.println("select enter ID Cart :");

    }

    public static void selectIdAccount() {

        System.out.println("select enter ID Account :");

    }

    public static void selectTransactioontMenu() {

        System.out.println("select number");
        System.out.println("1 : Cart To Cart");
        System.out.println("2 :Show all Transaction ");
        System.out.println("3 : Back");
    }

    public static void selectCArtDestination() {

        System.out.println("select enter CArt Destination :");
    }

    public static void titleTransaction() {

        System.out.println("select enter Title Transaction :");

    }

    public static void enterValueMoney() {

        System.out.println("select enter value Money :");

    }
}