package com.CYG.SmallChangeProject;

import java.util.Scanner;

public class Interface {
    /*
    My Design:
    1. Display all the 4 options and prompt for input.
    2. write method to call each method in Logic level/class.
       (Do I need "import"? NO, since all in the same package, and methods are all public)
        Four options on interface: 1. Account Detail. 2. Deposit 3. Withdraw 4. Exit System.
        (1). Account Detail.  - Display balance of account.
        (2). Deposit  - make deposit and update remaining balance.
        (3). Withdraw - make withdraw and update remaining balance.
        (4). Exit System.
     3. Improvement:
        Done (1). When choose 4, prompt to confirm.
        Done (2). When finish deposit, ask if want to have one more deposit.If no, back to main menu.
        (3). Same of (2) for withdraw.
     */

    private static Scanner myScanner = new Scanner(System.in);

    // Set mainMenu as "static", so no instance is needed for method call.
    public static void mainMenu() {

        boolean repeatMainMenu = true;
        do { // repeatedly displaying the menu until 4 exit is input.
            System.out.println("==== Welcome to Small Change App ====");
            System.out.println("1. Account Details ");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.println("Please choose (1-4): ");

            String sel = myScanner.next();
            switch (sel) {
                case "1": {
                    Logic.display();
                    break;
                }
                case "2": {
                    Logic.deposit();
                    // Attn:Ask for more deposit should be in the Logic layer, but not display layer.
                    break;
                }
                case "3": {
                  Logic.withdraw();
                    break;
                }
                case "4": {
                    boolean exitApp = Logic.exit();
                    repeatMainMenu = !exitApp;
                    System.out.println("Thanks for choosing Small Change App. See you soon ~ ");
                    break;
                }
                default: {
                    System.out.println("Input Error.! Please choose (1-4): ");
                    break;
                }
            }
        } while (repeatMainMenu);
    }

}

