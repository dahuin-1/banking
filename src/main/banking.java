package main;

import main.db.Account;
import main.db.AccountController;

import java.util.Scanner;

public class banking {

    Scanner sc = new Scanner(System.in);
    int currentStock;
    Account account;
    Account tempAccount;

    public void check(String id) {
        Account account = new AccountController().findAccount(id);
        this.account = account;
        currentStock = account.getCurrentStock();
    }

    public int save(int stock) {
        System.out.println("입금급액입력");
        stock = sc.nextInt();
        currentStock += stock;
        account.setCurrentStock(currentStock);
        return currentStock;
    }

    public int withdraw(int stock) {
        System.out.println("출금금액입력");
        stock = sc.nextInt();
        currentStock -= stock;
        account.setCurrentStock(currentStock);
        return currentStock;
    }

    public boolean lookup(String tempId) {
        if (!new AccountController().isExisted(tempId)) { //왜때문에
            System.out.println("해당하는 회원이 없습니다");
            return false;
        }
        tempAccount = new AccountController().findAccount(tempId);
        System.out.println("회원명 " + tempAccount.getName());
        System.out.println("회원 조회에 성공했습니다. 회원 이름이 맞나요?");
        System.out.println("예 - y / 메인 화면으로 돌아가고 싶다면 아무 키나 눌러주세요");
        String rst = sc.next();
        if (!rst.equals("y")) {
            return false;
        }
        return true;

    }

    public int 송금(int stock) {
        System.out.println("송금 받을 아이디를 입력하세요");
        String tempId = sc.next();
        if (lookup(tempId)) { //만약에 못찾으면 어떻게 할지도 만들어야해
            System.out.println("송금을 원하는 금액을 입력해주세요");
            stock = sc.nextInt();
            if (stock > currentStock) {
                warning(currentStock);
                stock = sc.nextInt();
            }
            currentStock = currentStock - stock;
        }
        account.setCurrentStock(currentStock); //내계좌에넣기
        tempAccount.setCurrentStock(tempAccount.getCurrentStock() + stock);
        return currentStock;
        //송금 할 금액
        //잔고 < 송금할금액 - 잔고부족
        //계좌주명 "이거 맞나요"?
        //송금하시겠습니까?
        //네
    }

    public void warning(int currentStock) {
        System.out.println("잔고가 부족합니다!!");
        System.out.println("현재잔고 " + currentStock);
        System.out.println("다시 입력해주세요!!");
    }

    public int total() {
        return currentStock;
    }

}
