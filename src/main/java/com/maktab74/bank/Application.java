package com.maktab74.bank;

import com.maktab74.bank.domain.Account;
import com.maktab74.bank.domain.Cart;
import com.maktab74.bank.domain.Customer;
import com.maktab74.bank.util.ApplicationContext;
import com.maktab74.bank.util.HibernateUtil;
import com.maktab74.bank.util.ShowMenu;
import com.maktab74.bank.util.UserBrief;

import java.util.List;

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
            loginUser();
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

        boolean flag = true;
        while (flag) {
            try {
                ShowMenu.selectCartMenu();
                int selectNumber = ApplicationContext.intScanner.nextInt();

                if (selectNumber == 1) {
                    createCaretUser();


                } else if (selectNumber == 2) {
                    editCart();


                } else if (selectNumber == 3) {
                    deletedCartUser();


                } else if (selectNumber == 4) {
                    menu();

                } else {
                    ShowMenu.wrongNumber();
                    ShowMenu.curentNumber();
                    cartOperation();

                }
            } catch (Exception e) {

                ShowMenu.curentNumber();
                ApplicationContext.intScanner.next();
                cartOperation();

            }

        }
    }

    private static void deletedCartUser() {


        long idNumber = ApplicationContext.intScanner.nextInt();

        ApplicationContext.getCartRepository().deletById(idNumber);
        ShowMenu.deletedSuccesfully();
        cartOperation();

    }

    private static void createCaretUser() {

        ShowMenu.enterNumberCart();
        String numberCart = ApplicationContext.stringScanner.next();

        ShowMenu.enterccv2Cart();
        long ccv2 = ApplicationContext.stringScanner.nextInt();

        ShowMenu.enterPasswordCart();

        long password = ApplicationContext.stringScanner.nextInt();

        Account acountUser = ApplicationContext.getAccountRepository().findAcountUser(
                ApplicationContext.getSecurityUser().getCurrentUser().getId());


        Cart cart = new Cart(numberCart, ccv2, password, acountUser);

        ApplicationContext.getCartRepository().save(cart);
        ShowMenu.createSuccesfully();
        cartOperation();

    }

    private static void editCart() {
        try {
            showAllAccount();
            ShowMenu.selectIdAccount();
            long accountId = ApplicationContext.intScanner.nextInt();
            showCart(accountId);
            ShowMenu.selectIdCart();
            long idCart = ApplicationContext.intScanner.nextInt();

            ShowMenu.enterNumberCart();
            String numberCart = ApplicationContext.stringScanner.next();

            ShowMenu.enterccv2Cart();
            long ccv2 = ApplicationContext.stringScanner.nextInt();

            ShowMenu.enterPasswordCart();

            long password = ApplicationContext.stringScanner.nextInt();

            Account acountUser = ApplicationContext.getAccountRepository().findAcountUser(
                    ApplicationContext.getSecurityUser().getCurrentUser().getId());


            Cart cart = new Cart(idCart, numberCart, ccv2, password, acountUser);

            ApplicationContext.getCartRepository().save(cart);
            ShowMenu.editeSuccesfully();
            cartOperation();
        } catch (Exception e) {
            ShowMenu.wrongNumber();
            ApplicationContext.intScanner.next();
            editCart();
        }
    }

    private static void accountOperation() {


        boolean flag = true;
        while (flag) {
            try {
                ShowMenu.selectAccounttMenu();
                int selectNumber = ApplicationContext.intScanner.nextInt();

                if (selectNumber == 1) {

                    createAccountUser();
                    ShowMenu.createSuccesfully();
                    accountOperation();

                } else if (selectNumber == 2) {
                    editAccountUser();
                    ShowMenu.editeSuccesfully();
                    accountOperation();

                } else if (selectNumber == 3) {
                    deletedAccountUser();
                    ShowMenu.deletedSuccesfully();
                    accountOperation();
                } else if (selectNumber == 4) {
                    ShowMenu.showAllAcount();
                    showAllAccount();
                    accountOperation();
                } else if (selectNumber == 5) {

                    menu();
                } else {
                    ShowMenu.wrongNumber();
                    ShowMenu.curentNumber();
                    accountOperation();

                }
            } catch (Exception e) {

                ShowMenu.curentNumber();
                ApplicationContext.intScanner.next();
                accountOperation();

            }

        }
    }

    private static void showAllAccount() {

        List<Account> accountList = ApplicationContext.getAccountRepository().findAllById(
                ApplicationContext.getSecurityUser().getCurrentUser().getId());

        for (Account account : accountList
        ) {
            System.out.println(account);

        }
        System.out.println();
    }

    private static void showCart(Long id) {
        Cart cart = ApplicationContext.getCartRepository().findByAccuntId(id);
        System.out.println(cart);


    }

    private static void deletedAccountUser() {

        showAllAccount();
        ShowMenu.selectIdAccount();
        long idAccoune = ApplicationContext.intScanner.nextInt();

        ApplicationContext.getAccountRepository().deletById(idAccoune);
    }

    private static void editAccountUser() {

        try {
            showAllAccount();

            ShowMenu.selectIdAccount();
            long idAccount = ApplicationContext.intScanner.nextInt();

            ShowMenu.enterTitleAccount();
            String titleAccount = ApplicationContext.stringScanner.next();

            Customer idUserCurernt = ApplicationContext.getSecurityUser().getCurrentUser();

            ShowMenu.codeNumberAccountCart();

            long codeAccount = ApplicationContext.stringScanner.nextInt();

            ShowMenu.validMoneyInAccount();
            long validMoney = ApplicationContext.intScanner.nextInt();


            Account account = new Account(idAccount, titleAccount, idUserCurernt, codeAccount, validMoney);

            ApplicationContext.getAccountRepository().save(account);

        } catch (Exception e) {
            ShowMenu.wrongNumber();
            ApplicationContext.intScanner.next();
            editAccountUser();
        }
    }

    private static void createAccountUser() {

        ShowMenu.enterTitleAccount();
        String titleAccount = ApplicationContext.stringScanner.next();

        Customer idAccount = ApplicationContext.getSecurityUser().getCurrentUser();

        ShowMenu.codeNumberAccountCart();

        long codeAccount = ApplicationContext.stringScanner.nextInt();

        ShowMenu.validMoneyInAccount();
        long validMoney = ApplicationContext.intScanner.nextInt();


        Account account = new Account(titleAccount, idAccount, codeAccount, validMoney);

        ApplicationContext.getAccountRepository().save(account);

    }


}
