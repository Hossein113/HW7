package com.maktab74.bank;

import com.maktab74.bank.domain.Account;
import com.maktab74.bank.domain.Cart;
import com.maktab74.bank.domain.Customer;
import com.maktab74.bank.domain.Transaction;
import com.maktab74.bank.util.*;

import java.util.Date;
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


        while (true) {
            try {

                ShowMenu.loginAndCreateUser();
                int Number = ApplicationContext.intScanner.nextInt();
                if (Number == 1) {

                    loginUser();

                } else if (Number == 2) {

                    createUser();

                } else if (Number == 3) {

                    endApplication();


                } else {

                    ShowMenu.wrongNumber();
                    ShowMenu.curentNumber();
                    loginOrCreate();
                }

            } catch (Exception e) {

                ShowMenu.curentNumber();
                ApplicationContext.intScanner.nextLine();
                loginOrCreate();
            }
        }


    }

    private static void endApplication() {
        // ApplicationContext.intScanner.nextLine();
        ApplicationContext.getSecurityUser().logOut();
        ShowMenu.logOff();
        loginOrCreate();


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
        long customerCodeNumber = CodeUinq.randomCode();

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

        while (true) {
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

                    endApplication();

                } else {
                    ShowMenu.wrongNumber();
                    ShowMenu.curentNumber();
                    menu();

                }
            } catch (Exception e) {

                ShowMenu.curentNumber();
                ApplicationContext.intScanner.nextLine();
                menu();

            }
            break;
        }

    }

    private static void transactionaOperation() {


        while (true) {
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
                ApplicationContext.intScanner.nextLine();
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

        while (true) {
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
                ApplicationContext.intScanner.nextLine();
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


        Cart cart = new Cart();
        ShowMenu.enterNumberCart();
        ApplicationContext.getCartRepository().beginTransaction();

        while (true) {
            Long codeCart = CodeUinq.arrayToIntegerCode(CodeUinq.RandomCardNumber());
            Long codeNumber = ApplicationContext.getCartRepository().findCodeNumber(codeCart);

            if (codeNumber == 0) {
                cart.setNumberCart(codeCart);
                System.out.println("code Cart :" + codeCart);
                createCvv2(cart);

            } else {
                continue;
            }
        }

    }

    private static void createCvv2(Cart cart) {
        while (true) {
            Long codeCvv2 = CodeUinq.arrayToIntegerCode(CodeUinq.randomCcv2());
            Long codeNumber = ApplicationContext.getCartRepository().findCodeNumber(codeCvv2);

            if (codeNumber == 0) {
                cart.setCcv2(codeCvv2);
                System.out.println("code cvv2 :" + codeCvv2);
                createPassword(cart);
            } else {
                continue;
            }
        }

    }

    private static void createPassword(Cart cart) {
        ShowMenu.enterPasswordCart();
        long password = ApplicationContext.stringScanner.nextInt();
        cart.setPassword(password);
        saveCart(cart);
    }

    private static void saveCart(Cart cart) {
        ApplicationContext.getCartRepository().save(cart);
        ApplicationContext.getCartRepository().commitTransaction();
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


            Cart secondCart = new Cart(firstCart.getId(), password, account);

            ApplicationContext.getCartRepository().save(secondCart);
            ShowMenu.editeSuccesfully();
            menu();
        } catch (Exception e) {
            ShowMenu.wrongNumber();
            ApplicationContext.intScanner.nextLine();
            editCart();
        }
    }

    private static void accountOperation() {

        while (true) {
            try {
                ShowMenu.selectAccounttMenu();
                int selectNumber = ApplicationContext.intScanner.nextInt();

                if (selectNumber == 1) {

                    createAccountUsers();
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
                ApplicationContext.intScanner.nextLine();
                accountOperation();

            }
            ApplicationContext.intScanner.nextLine();
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


            ShowMenu.validMoneyInAccount();
            long validMoney = ApplicationContext.intScanner.nextInt();


            Account account = new Account(idAccount, titleAccount, idUserCurernt, validMoney);

            ApplicationContext.getAccountRepository().save(account);

        } catch (Exception e) {
            ShowMenu.wrongNumber();
            ApplicationContext.intScanner.nextLine();
            editAccountUser();
        }
    }

    private static void createAccountUsers() {

        Account account = new Account();
        ShowMenu.enterTitleAccount();
        String titleAccount = ApplicationContext.stringScanner.next();
        account.setTitle(titleAccount);
        setCodeAccount(account);

    }

    public static void setCodeAccount(Account account) {
        while (true) {
            int[] ints = CodeUinq.RandomAccountNumber();
            Long codeAccount = CodeUinq.arrayToIntegerCode(ints);
            Long codeNumber = ApplicationContext.getAccountRepository().findCodeNumber(codeAccount);

            if (codeNumber == 0) {
                account.setAcountCodeNumber(codeAccount);
                System.out.println("code Account :" + codeAccount);
                setCustomrIdAccount(account);

            } else {
                continue;
            }
        }

    }

    public static void setCustomrIdAccount(Account account) {
        account.setCustomer(ApplicationContext.getSecurityUser().getCurrentUser());
        setValueMoney(account);
    }

    public static void setValueMoney(Account account) {
        ShowMenu.validMoneyInAccount();
        long validMoney = ApplicationContext.intScanner.nextInt();
        account.setValidMoney(validMoney);
        saveAccount(account);
    }

    public static void saveAccount(Account account) {


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

            Date today = new Date();

            Transaction transaction = new Transaction(title, valueMoney, cartSource, outCart, CodeUinq.randomCode(), today);

            ApplicationContext.getTransactionRepository().save(transaction);

            System.out.println("save to table");

            inValueCart(cart1, outCart, valueMoney);

            ShowMenu.cartToCartSucesfully();

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