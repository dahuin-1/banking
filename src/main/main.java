package main;

import main.db.AccountController;
import main.db.AccountService;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        //Account ac = new Account();
        banking b = new banking();
        App a = new App(new Scanner(System.in), new AccountController(), new AccountService(b));
        a.checkAccount();
    }
}
