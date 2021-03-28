package main.db;

import main.banking;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AccountController {

    Account account;
    public static Map<String, Account> map = new HashMap<String, Account>();

    //private final Map<String, Account> map;
    // public AccountController(Map<String, Account> map) {
    //this.map = map;
    //}

    /*
    생성자 만들어서
    안에 넣기
     */

    /*
    k - 아이디
    v - 사람객체(이름,아이디,비번)
    셋터가지고 셋팅을 해서 사람 객체에 담는다
    */
    Scanner sc = new Scanner(System.in);
    AccountService as = new AccountService(new banking());

    public void makeAccount() {
        account = new Account();
        System.out.println("--계좌 만들기--");
        while (true) {
            System.out.println("아이디");
            String i = sc.next();
            System.out.println(isExisted(i));
            if (!isExisted(i)) {
                System.out.println("비밀번호");
                String p = sc.next();
                System.out.println("이름");
                String n = sc.next();
                System.out.println("입금 금액");
                int s = sc.nextInt();
                account.setId(i);
                account.setPw(p);
                account.setName(n);
                account.setCurrentStock(s);
                map.put(i, this.account);
                System.out.println("등록완료");
                //  System.out.println("@" + findAccount(i).getName());
                break;
            } else {
                System.out.println("이미 존재하는 아이디 입니다. 다시입력해주세요");
            }

        }
    }

    public boolean isExisted(String tempId) {
        return map.containsKey(tempId);
    }

    public Account findAccount(String tempId) {
        for (Map.Entry<String, Account> entry : map.entrySet()) {
            if (entry.getKey().equals(tempId)) {
                account = entry.getValue();
            }
        }
        return account;
    }

    //비밀번호 찾기 구현

    public void logInAccount() {
        // System.out.println("--로그인--");
        System.out.println("키" + map.keySet());
        System.out.println("값" + map.values());
        while (true) {
            System.out.println("----로그인----");
            System.out.println("아이디와 비밀번호를 입력해주세요");
            System.out.println("아이디 :");
            String id = sc.next();
            System.out.println("비밀번호 :");
            String p = sc.next();
            if (isExisted(id)) {
                System.out.println(map.get(id).getPw());
                System.out.println(findAccount(id));
                if (p.equals(findAccount(id).getPw())) {
                    System.out.println("로그인되었습니다");
                    as.menu(id);
                } else {
                    System.out.println("비밀번호가 일치하지 않습니다");
                    logInAccount();
                    break;
                }
            } else {
                System.out.println("입력하신 아이디가 존재하지 않습니다");
                System.out.println("회원가입을 새로 진행 하시겠습니까?");
                System.out.println("예 - y / 로그인 화면으로 돌아가고 싶다면 아무 키나 눌러주세요");
                String rst = sc.next();
                if (rst.equals("y")) {
                    makeAccount();
                    break;
                } else {
                    logInAccount();
                }
            }

        }
    }
}
