package main;

import main.db.AccountController;

import java.util.Scanner;

public class App {
    /*

     */
   private final Scanner sc;
   private final AccountController ac;
   private final Banking banking;

    public App(Scanner sc, AccountController ac, Banking banking) {
        this.sc = sc;
        this.ac = ac;
        this.banking = banking;
    }
    /*
    안바뀔라면 BANK도 넣어야했다
    메인
    앱                                   어카운트
    어카운트컨트롤러(어카운트) - 뱅킹
     */

    public void checkAccount() {
        while(true) {
            System.out.println("계좌를 새로 만드시겠습니까??");
            System.out.println("1. 아니오 - 로그인으로 이동 / 2. 예");
            int cnt = sc.nextInt();
            if (cnt == 1) {
                ac.logInAccount();
            } else if (cnt == 2) {
                ac.makeAccount();
            } else {
                System.out.println("다시입력해주세요");
                checkAccount();
            }
        }
    }


}
