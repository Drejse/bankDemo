import sun.nio.ch.Util;

import java.util.Scanner;

public class Driver {
    boolean menu = false;

        public static void menu () {

        System.out.println("1) Login \n2) Empoyee login \n3) Create Account\n9) quit");
        Scanner input = new Scanner(System.in);


        int choice = input.nextInt();
        switch (choice) {
            case 1:
                Customer.login();
                if (Customer.succes == true) {
                    menuWhenLoggedIn();
                } else {
                    Customer.login();
                }
                break;
            case 2:
                //Employee Login
                break;
            case 3:
                Utilities.createUser();
                break;
            case 9:
                break;
        }
    }

        public static void menuWhenLoggedIn () {
        System.out.println("1) Withdraw \n2) Deposit \n3) Check Transactions\n4) Check Balance\n5) Transfer\n9) Logout");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Withdraw amount: ");
                int withdraw = input.nextInt();
                Utilities.updateBalance(-withdraw, Customer.email);
                menuWhenLoggedIn();
                break;
            case 2:
                System.out.println("Deposit amount: ");
                int deposit = input.nextInt();
                Utilities.updateBalance(deposit, Customer.email);
                menuWhenLoggedIn();
                break;
            case 3:
                // check Transactionzzz
                menuWhenLoggedIn();
                break;
            case 4:
                Account.printBalance();
                menuWhenLoggedIn();
                break;
            case 5:
               //transfer
                menuWhenLoggedIn();
                break;
            case 9:
                menu();
                break;
         }
        }
}
