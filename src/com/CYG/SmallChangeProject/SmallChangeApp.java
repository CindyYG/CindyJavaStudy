package com.CYG.SmallChangeProject;

public class SmallChangeApp {
    /*
    模拟微信的零钱通App。
    Four options on interface: 1. Account Detail. 2. Deposit 3. Withdraw 4. Exit System.
        1. Account Detail.  - Display balance of account.
        2. Deposit  - make deposit and update remaining balance.
        3. Withdraw - make withdraw and update remaining balance.
        4. Exit System.
     */
    /*
    My Design - Use 3 layer system design: Interface, Logic, Data
     */

    public static void main(String[] args) {
        Interface.mainMenu();
    }
}
