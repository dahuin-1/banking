package main;

import java.util.Scanner;

public class banking {

    Scanner sc = new Scanner(System.in);
    int stock;

    public int save(int tempMoney) {
        System.out.println("입금급액입력");
        tempMoney = sc.nextInt();
        stock += tempMoney;
        return stock;
    }

    public int withdraw(int tempMoney) {
        System.out.println("출금금액입력");
        tempMoney = sc.nextInt();
        stock -= tempMoney;
        return stock;
    }

    public void 송금(String tempId) {
        System.out.println("개발중입니다");
       /* String tempName = new AccountController().findAccountName(tempId);
        System.out.println("계좌주명"+ tempName);
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
                System.out.println(tempName+"에게"+tempMoney+"를 송금하시겠습니까?");
                System.out.println("잔고 :"+newStock);
                System.out.println("송금완료");
            }
        }*/
        //송금 할 금액
        //잔고 < 송금할금액 - 잔고부족
        //계좌주명 "이거 맞나요"?
        //송금하시겠습니까?
        //네
    }
}
