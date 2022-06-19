package com.maktab74.bank;

import com.maktab74.bank.domain.Account;
import com.maktab74.bank.domain.Cart;
import com.maktab74.bank.domain.Customer;
import com.maktab74.bank.domain.Transaction;
import com.maktab74.bank.util.*;

import java.util.List;

import static com.maktab74.bank.util.ShowMenu.loginSuccesfully;

public class Application {

    public static void main(String[] args) {

        System.out.println("start");
        HibernateUtil.getEntitymanagerfactory().createEntityManager();
        System.out.println("END");

        while (true) {
            loginOrCreate();

        }
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
                    ApplicationContext.getSecurityUser().logOut();
                    ShowMenu.logOff();
                    break;

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
        boolean menu = true;
        while (menu) {
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

                    ApplicationContext.getSecurityUser().logOut();
                    ShowMenu.logOff();
                    break;

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


        boolean flag = true;
        while (flag) {
            try {
                ShowMenu.selectTransactioontMenu();

                int selectNumber = ApplicationContext.intScanner.nextInt();

                if (selectNumber == 1) {

                    cartToCart();

                } else if (selectNumber == 2) {

                    showAllTransaction();

                } else if (selectNumber == 3) {
                    menu();

                } else {
                    ShowMenu.wrongNumber();
                    ShowMenu.curentNumber();
                    transactionaOperation();
                }
            } catch (Exception e) {
                ShowMenu.wrongNumber();
                ApplicationContext.intScanner.next();
                transactionaOperation();
            }
        }
    }

    private static void showAllTransaction() {

        ShowMenu.enterNumberCart();
        String myCart = ApplicationContext.stringScanner.next();
        Cart cart = ApplicationContext.getCartRepository().destination(myCart);
        List<Transaction> transactions = ApplicationContext.getTransactionRepository().searchTransaction(cart);


        transactions.forEach(System.out::println);

        menu();
    }


    private static void cartOperation() {

        boolean flag = true;
        while (flag) {
            try {
                ShowMenu.selectCartMenu();
                int selectNumber = ApplicationContext.intScanner.nextInt();

                if (selectNumber == 1) {
                    // createCaretUser();
                    System.out.println("Create defaulte");

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

        ApplicationContext.getCartRepository().getTransaction();
        ApplicationContext.getCartRepository().beginTransaction();
        showAllAccount();
        ShowMenu.selectIdAccount();


        long idAccoune = ApplicationContext.intScanner.nextInt();
        ApplicationContext.getAccountRepository().getTransaction();
        ApplicationContext.getAccountRepository().beginTransaction();
        Account account = ApplicationContext.getAccountRepository().findById(idAccoune);
        Cart cart = ApplicationContext.getCartRepository().findByAccuntId(account);
        ApplicationContext.em.remove(cart);

        ApplicationContext.getAccountRepository().commitTransaction();

        ShowMenu.deletedSuccesfully();
        menu();
    }

    private static void createCaretUser(Account account) {

        ShowMenu.enterNumberCart();
        String numberCart = ApplicationContext.stringScanner.next();

        ShowMenu.enterccv2Cart();
        long ccv2 = ApplicationContext.stringScanner.nextInt();

        ShowMenu.enterPasswordCart();

        long password = ApplicationContext.stringScanner.nextInt();

        Cart cart = new Cart(numberCart, ccv2, password, account);

        ApplicationContext.getCartRepository().save(cart);
        ShowMenu.createSuccesfully();
        cartOperation();

    }

    private static void editCart() {
        try {
            showAllAccount();
            ShowMenu.selectIdAccount();
            long number = ApplicationContext.intScanner.nextInt();
            Account account = ApplicationContext.getAccountRepository().findById(number);

            Cart firstCart = ApplicationContext.getCartRepository().findByAccuntId(account.getId());


            ShowMenu.enterNumberCart();
            String numberCart = ApplicationContext.stringScanner.next();

            ShowMenu.enterccv2Cart();
            long ccv2 = ApplicationContext.stringScanner.nextInt();

            ShowMenu.enterPasswordCart();

            long password = ApplicationContext.stringScanner.nextInt();


            Cart secondCart = new Cart(firstCart.getId(), numberCart, ccv2, password, account);

            ApplicationContext.getCartRepository().save(secondCart);
            ShowMenu.editeSuccesfully();
            menu();
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
        ApplicationContext.getCartRepository().getTransaction();
        ApplicationContext.getCartRepository().beginTransaction();
        Cart cart = ApplicationContext.getCartRepository().findByAccuntId(id);
        ApplicationContext.getCartRepository().commitTransaction();

        System.out.println(cart);


    }

    private static void deletedAccountUser() {

        showAllAccount();
        ShowMenu.selectIdAccount();
        long idAccoune = ApplicationContext.intScanner.nextInt();
        ApplicationContext.getAccountRepository().getTransaction();
        ApplicationContext.getAccountRepository().beginTransaction();
        Account account = ApplicationContext.getAccountRepository().findById(idAccoune);
        Cart cart = ApplicationContext.getCartRepository().findByAccuntId(account);
        ApplicationContext.em.remove(cart);
        ApplicationContext.em.remove(account);

        ApplicationContext.getAccountRepository().commitTransaction();
        ShowMenu.deletedSuccesfully();
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
        createCaretUser(account);

    }


    private static void cartToCart() {
        ApplicationContext.getCartRepository().beginTransaction();
        ShowMenu.enterNumberCart();
        String inBrifCart = ApplicationContext.stringScanner.next();

        Cart incart = ApplicationContext.getCartRepository().destination(inBrifCart);
        ShowMenu.enterccv2Cart();
        long ccv2 = ApplicationContext.stringScanner.nextInt();

        ShowMenu.enterPasswordCart();

        long password = ApplicationContext.stringScanner.nextInt();


        CartBrief cartBrief = new CartBrief(inBrifCart, ccv2, password);

        Cart cartSource = ApplicationContext.getCartRepository().chekCart(cartBrief);
        Cart cart1 = ApplicationContext.getCartRepository().destination(cartBrief.getNumberCart());

        if (cartSource != null) {
            ShowMenu.selectCArtDestination();

            String cart = ApplicationContext.stringScanner.next();

            Cart outCart = ApplicationContext.getCartRepository().destination(cart);


            ShowMenu.titleTransaction();
            String title = ApplicationContext.stringScanner.next();

            ShowMenu.enterValueMoney();

            long valueMoney = ApplicationContext.stringScanner.nextInt();

            Transaction transaction = new Transaction(title, valueMoney, cartSource, outCart);


            ApplicationContext.getTransactionRepository().save(transaction);

            System.out.println("save to table");

            inValueCart(cart1, outCart, valueMoney);

            ShowMenu.cartToCartSucesfully();
            System.out.println("value to account");
            menu();


        } else {

            ShowMenu.wrongNumber();
        }
        menu();
    }

    private static void inValueCart(Cart in, Cart out, Long valueMoney) {

        ApplicationContext.getCartRepository().beginTransaction();

        ApplicationContext.getAccountRepository().inTransaction(valueMoney, in.getAccount());
        ApplicationContext.getAccountRepository().outTransaction(valueMoney, out.getAccount());

        ApplicationContext.getCartRepository().commitTransaction();

    }

}