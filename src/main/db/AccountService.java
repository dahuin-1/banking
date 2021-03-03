package main.db;

import main.db.AccountController;
import main.main;
import main.banking;

import java.util.Scanner;

public class AccountService {

    banking b;

    public AccountService(banking b) {
        this.b = b;
    }

    int stock;
    int tempMoney;
            //new AccountController().account.getStock();
    Scanner sc = new Scanner(System.in);

    public void menu() {
        System.out.println("1. 입금 / 2. 출금 / 3. 송금 / 4. 로그아웃");
        System.out.println("0을 누르면 종료");
        int cnt = sc.nextInt();
        if (cnt == 1) {
            //b.save(stock);
            System.out.println(won(b.save(stock)));
            저장(); //저장해야해
            menu();
        } else if (cnt == 2) {
            //b.withdraw();
            System.out.println(won(b.withdraw(stock)));
            저장(); //저장해야해
            menu();
        } else if(cnt == 3) {
            lookup();
            저장(); //저장해야해
            //menu();
        }  else if(cnt == 4) {
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
        String newStock = "잔액: "+stock+"원";
        return newStock;
    }


    public String lookup() {
        System.out.println("송금 받을 아이디를 입력하세요");
        String tempId = sc.next();
        if(!new AccountController().map.containsKey(tempId)){ //왜때문에
            System.out.println("해당하는 회원이 없습니다");
            menu();
        }
        System.out.println("회원 조회에 성공했습니다.");
        System.out.println(new AccountController().findAccountName(tempId)+"에게"+" 송금을 진행하시겠습니까?");
        //System.out.println("[회원명 : "+new AccountController().findAccountName(tempId));
        System.out.println("1. 네 / 아니오 ");
        int cnt = sc.nextInt();
        if(cnt==1) {
            b.송금(tempId);
        }else if (cnt==2) {
            menu();
        }else {
            System.out.println("다시 입력해주세요");
        }
        return tempId;
    }

    public void 저장() {
        System.out.println("개발자에게저장해야한다고전하세요");
        /*
        stock을
        회원에게 저장하는...
        디비연결할 필요
         */
    }




    @Override
    public String toString() {
        return "banking{" +
                "stock=" + stock +
                '}';
    }
}
