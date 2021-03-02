package main;

import main.db.AccountController;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {
       // Account ac = new Account();
        App a = new App(new Scanner(System.in), new AccountController(), new Banking());
        a.checkAccount();
    }
}
