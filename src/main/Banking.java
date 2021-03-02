package main;

import main.db.AccountController;

import java.util.Scanner;

public class Banking {



    public Banking() {

    }

    int stock = 0;
    Scanner sc = new Scanner(System.in);

    public void menu() {
        System.out.println("1. 입금 / 2. 출금 / 3. 송금");
        System.out.println("0을 누르면 종료");
        int cnt = sc.nextInt();
        if (cnt == 1) {
            save();
            System.out.println(won(stock));
            menu();
        } else if (cnt == 2) {
            withdraw();
            System.out.println(won(stock));
            menu();
        } else if(cnt == 3) {
            lookup();
            //menu();
        }  else if (cnt == 0) {
            System.exit(0);
        } else {
            System.out.println("다시입력해주세요");
        }
    }

    public String won(int stock) {
        String newStock = "잔액: "+stock+"원";
        return newStock;
    }

    public int save() {
        System.out.println("입금급액입력");
        int tempMoney = sc.nextInt();
        stock += tempMoney;
        return stock;
    }

    public int withdraw() {
        System.out.println("출금금액입력");
        int tempMoney = sc.nextInt();
        stock -= tempMoney;
        return stock;
    }

    public String lookup() {
        System.out.println("송금 받을 아이디를 입력하세요");
        String tempId = sc.next();
        if(new AccountController().map.containsKey(tempId)){
            System.out.println("해당하는 회원이 없습니다");
            menu();
        }
        System.out.println("회원 조회에 성공했습니다.");
        System.out.println("송금을 진행하시겠습니까?");
        System.out.println("회원명");
        System.out.println(new AccountController().findAccountName(tempId));
        System.out.println("1. 네 / 아니오 ");
        int cnt = sc.nextInt();
        if(cnt==1) {
            송금(tempId);
        }else if (cnt==2) {
            menu();
        }else {
            System.out.println("다시 입력해주세요");
        }
        return tempId;
    }

    public void 송금(String tempId) {
        String tempName = new AccountController().findAccountName(tempId);
        System.out.println("계좌주명"+tempName);
        System.out.println("송금을 원하는 금액을 입력해주세요");
       int tempMoney = sc.nextInt();

       while(tempMoney != 0) {
           if (tempMoney < stock) {
               System.out.println("잔고가 부족합니다!!");
               System.out.println("현재잔고"+stock);
               System.out.println("다시 입력해주세요!!");
               tempMoney = sc.nextInt();
           } else {
               int newStock = stock - tempMoney;
               System.out.println(tempName+"에게"+won(tempMoney)+"를 송금하시겠습니까?");
           }
       }
        //송금 할 금액
        //잔고 < 송금할금액 - 잔고부족
        //계좌주명 "이거 맞나요"?
        //송금하시겠습니까?
        //네
    }


    @Override
    public String toString() {
        return "banking{" +
                "stock=" + stock +
                '}';
    }
}
