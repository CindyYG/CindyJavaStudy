package com.CYG.SmallChangeProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logic {
    /*
         2. write method to call each method in Logic level/class.
            (1). Account Detail.  - Display balance of account.
            (2). Deposit  - make deposit and update remaining balance.
            (3). Withdraw - make withdraw and update remaining balance.
            (4). Exit System.
         */

    private static Scanner myScanner = new Scanner(System.in);
    private static double balance; //Do want the balance be updated with action history.
                                    // So balance should be set in Logic Layer but not Data.
    //Use ArrayList to track account history.
    private static List<Data> accountHistory = new ArrayList<>();

    //(1). Account Detail.  - Display balance of account.
    public static void display() {
        if(accountHistory.isEmpty()) {
            System.out.println("Welcome new client, please make your first deposit to start your journey~");
            System.out.println("");
        }else {
            System.out.println("====  Account Detail ====");
            for (int i = 0; i < accountHistory.size(); i++) {
                Data d = accountHistory.get(i);
                //Format the output of the DateTime.
                LocalDateTime dateTime = d.getDateTime();
                DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
                System.out.println(d.getItem() + "\t" + d.getAmount() + "\t" + f.format(dateTime) + "\t Balance: " + d.getBalance());
            }
            System.out.println("");
        }
        //System.out.println(accountHistory);
    }
        
    //(2). Deposit  - make deposit and update remaining balance.
    public static void deposit(){
        boolean moreDeposit = false;
        do {
            System.out.println("Please Input The Deposit Item:");
            String item = myScanner.next();
            System.out.println("Please Input The Deposit Amount:");
            double amount = myScanner.nextDouble();
            Data depositItem = new Data(item, amount);
            //Update Account Balance.
            balance += depositItem.getAmount();
            depositItem.setBalance(balance);
            accountHistory.add(depositItem);

            //Prompt for more deposit.
            System.out.println("Do you have more to deposit?");
            System.out.println("Choose \"Y\" for more deposit, any other key to go back to main menu.");
            String moreDepSel = myScanner.next();
            if (("Y".equals(moreDepSel)) || ("y".equals(moreDepSel))) {
                moreDeposit = true;
            }else{
                moreDeposit = false; //Need to set back to false, otherwise, once "y" a infinite loop in created.
            }
        }while(moreDeposit);
    }

     //(3). Withdraw - make withdraw and update remaining balance.
     public static void withdraw(){
         boolean moreWithdraw = false;
         do {
             System.out.println("Please Input The Withdraw Item:");
             String item = myScanner.next();
             System.out.println("Please Input The Withdraw Amount:");
             double amount = -myScanner.nextDouble();// withdraw will be label as "-"
             Data withdrawItem = new Data(item, amount);
             //Update Account Balance.
             balance += withdrawItem.getAmount();
             withdrawItem.setBalance(balance);
             accountHistory.add(withdrawItem);
             //Prompt for more deposit.
             System.out.println("Do you have more to withdraw?");
             System.out.println("Choose \"Y\" for more withdraw, any other key to go back to main menu.");
             String moreWithdrawSel = myScanner.next();
             if (("Y".equals(moreWithdrawSel)) || ("y".equals(moreWithdrawSel))) {
                 moreWithdraw = true;
             }else{
                 moreWithdraw = false;
             }
         }while(moreWithdraw);
     }
       //(4). Exit System.
    public static boolean exit(){
        boolean exitSystem = true;
        boolean askAgain = true;
        do {
            System.out.println("Please confirm if you want to exit Small Change App? (Y/N)");
            String exitSel = myScanner.next();
            if (("Y".equals(exitSel)) || ("y".equals(exitSel))) {
                askAgain = false;
            } else if (("N".equals(exitSel)) || ("n".equals(exitSel))) {
                askAgain = false;
                exitSystem = false;
            }
        }while(askAgain);
        return exitSystem;
    }
}
