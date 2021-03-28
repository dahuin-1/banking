package main.db;

import main.banking;

import java.util.Scanner;

public class AccountService {

    banking banking;

    public AccountService(banking banking) {
        this.banking = banking;
    }

    int stock;
    Scanner sc = new Scanner(System.in);


    public void menu(String id) {
        banking.check(id);
        System.out.println("1. 입금 / 2. 출금 / 3. 송금 / 4. 잔액조회 / 5. 로그아웃");
        System.out.println("0을 누르면 종료");
        int cnt = sc.nextInt();
        if (cnt == 1) {
            System.out.println(won(banking.save(stock)));
            저장(); //저장해야해
            menu(id);
        } else if (cnt == 2) {
            //b.withdraw();
            System.out.println(won(banking.withdraw(stock)));
            저장(); //저장해야해
            menu(id);
        } else if (cnt == 3) {
            banking.송금(stock);
            //System.out.println(won(b.송금(stock)));
            저장();
            menu(id);
        } else if (cnt == 4) {
            System.out.println(won(banking.total()));
            //menu();
        } else if (cnt == 5) {
            System.out.println("--로그아웃되었습니다--");
            new AccountController().logInAccount();
            //menu();
        } else if (cnt == 0) {
            System.exit(0);
        } else {
            System.out.println("다시입력해주세요");
        }
    }

    public String won(int stock) {
        String currentStock = "잔액: " + stock + "원";
        return currentStock;
    }

    public void 저장() {
        System.out.println("개발자에게저장해야한다고전하세요");
        /*
        stock을
        회원에게 저장하는...
        디비연결할 필요
         */
    }

}
