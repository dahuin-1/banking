package main.db;

import main.Banking;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AccountController {


    //private final Map<String, Account> map;
   // public AccountController(Map<String, Account> map) {
      //  this.map = map;
   // }


    /*
    생성자 만들어서
    안에 넣기
     */

    public static Map<String, Account> map = new HashMap<String, Account>();

    /*
    k - 아이디
    v - 사람객체(이름,아이디,비번)
    셋터가지고 셋팅을 해서 사람 객체에 담는다
    */

    Scanner sc = new Scanner(System.in);
    Banking b = new Banking();
    Account account;

    public void makeAccount() {
        account = new Account();
        System.out.println("--계좌 만들기--");
        System.out.println("아이디");
        String i = sc.next();
        //아이디 중복 확인 로직 넣어야해
        System.out.println("비밀번호");
        //account.setPw(sc.nextLine());
        String p = sc.next();
        System.out.println("이름");
        //account.setName(sc.nextLine());
        String n = sc.next();
        System.out.println("입금 금액");
        //account.setStock(sc.nextInt());
        int s = sc.nextInt();
        account.setId(i);
        account.setPw(p);
        account.setName(n);
        account.setStock(s);
        map.put(i,account);
        System.out.println("map size"+map.size());
        System.out.println("등록완료");
    }


    public void checkAccount(){

    }//아이디 중복 확인 로직 넣어야해

    public String findAccountName(String tempId) {
        String resultName = "";
        for(Map.Entry<String,Account> entry : map.entrySet()) {
            if (entry.getKey().equals(tempId)) {
                //System.out.println(entry.getKey()+" "+entry.getValue().getName());
                resultName = entry.getValue().getName();
                //System.out.println(result);
            }
        }
        return resultName;
    }
    public Account findAccount(String tempId) {
        for(Map.Entry<String,Account> entry : map.entrySet()) {
            if (entry.getKey().equals(tempId)) {
                account = entry.getValue();
            }
        }
        return account;
    }

    public void logInAccount() {
        System.out.println("--로그인--");
       System.out.println("키"+map.keySet());
       System.out.println("값"+map.values());
        while(true) {
            System.out.println("아이디와 비밀번호를 입력해주세요");
            System.out.println("아이디 :");
            String i = sc.next();
            System.out.println("비밀번호 :");
            String p = sc.next();
            if(map.containsKey(i)) {
                //if(map.get(id).equals(password)) {
                if(map.get(i).equals(map.values())) {
                    System.out.println("로그인되었습니다");
                    b.menu();
                } else {
                    System.out.println("비밀번호가 일치하지 않습니다");
                    logInAccount();
                    break;
                }
            } else {
                System.out.println("입력하신 아이디가 존재하지 않습니다");
                makeAccount();
                break;
            }
        }
    }
}
