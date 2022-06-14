package com.maktab74.bank;

import com.maktab74.bank.domain.Customer;
import com.maktab74.bank.util.ApplicationContext;
import com.maktab74.bank.util.HibernateUtil;
import com.maktab74.bank.util.ShowMenu;
import com.maktab74.bank.util.UserBrief;

import static com.maktab74.bank.util.ShowMenu.loginSuccesfully;

public class Application {

    public static void main(String[] args) {

        System.out.println("start");
        HibernateUtil.getEntitymanagerfactory().createEntityManager();
        System.out.println("END");


        loginOrCreate();

    }


    private static void loginOrCreate() {


        try {
            boolean flag = true;
            while (flag) {
                ShowMenu.loginAndCreateUser();
                int Number = ApplicationContext.intScanner.nextInt();
                if (Number == 1) {

                    loginUser();

                } else if (Number == 2) {

                    createUser();

                } else if (Number == 3) {
                    flag = false;
                    ApplicationContext.getSecurityUser().logOut();
                } else {

                    ShowMenu.wrongNumber();
                    ShowMenu.curentNumber();
                    loginOrCreate();
                }
            }
        } catch (Exception e) {
            ShowMenu.curentNumber();
            ApplicationContext.intScanner.next();
            loginOrCreate();
        }
    }

    private static void createUser() {
        ShowMenu.showfirstName();
        String firstName = ApplicationContext.stringScanner.next();
        ShowMenu.showLastName();
        String lastName = ApplicationContext.stringScanner.next();
        ShowMenu.showUserName();
        String userName = ApplicationContext.stringScanner.next();
        ShowMenu.showGender();
        String gender = ApplicationContext.stringScanner.next();
        ShowMenu.showAge();
        long age = ApplicationContext.stringScanner.nextInt();
        ShowMenu.showPhoneNumber();
        String phoneNumber = ApplicationContext.stringScanner.next();
        ShowMenu.showPassword();
        String pasword = ApplicationContext.stringScanner.next();
        ShowMenu.showCodeNumber();
        long customerCodeNumber = ApplicationContext.stringScanner.nextInt();

        Customer customer = new Customer(firstName, lastName, userName, gender, age, phoneNumber, pasword, customerCodeNumber);
        customer = ApplicationContext.getCustomerRepository().save(customer);

        System.out.println(customer);
        ShowMenu.createSuccesfully();
        loginOrCreate();
    }

    private static void loginUser() {

        ShowMenu.showUserName();
        String userName = ApplicationContext.stringScanner.next();

        ShowMenu.showPassword();
        String pasword = ApplicationContext.stringScanner.next();

        UserBrief userBrief = new UserBrief(userName, pasword);
        Customer customer = ApplicationContext.getCustomerRepository().checkPasword(userBrief);
        if (customer != null) {
            loginSuccesfully(customer);
            ApplicationContext.getSecurityUser().setCurrentUser(customer);
            menu();
        } else {
            ShowMenu.loginFail();
            loginOrCreate();
        }
    }

    private static void menu() {
        boolean flag = true;
        while (flag) {
            try {
                ShowMenu.selectAccountOrCartOrTransactin();

                int selectNumber = ApplicationContext.intScanner.nextInt();

                if (selectNumber == 1) {

                    accountOperation();

                } else if (selectNumber == 2) {
                    cartOperation();

                } else if (selectNumber == 3) {
                    transactionaOperation();

                } else if (selectNumber == 4) {
                    flag = false;

                } else {
                    ShowMenu.wrongNumber();
                    ShowMenu.curentNumber();
                    menu();

                }
            } catch (Exception e) {

                ShowMenu.curentNumber();
                ApplicationContext.intScanner.next();
                menu();

            }

        }
    }

    private static void transactionaOperation() {


    }

    private static void cartOperation() {

    }

    private static void accountOperation() {


    }
}