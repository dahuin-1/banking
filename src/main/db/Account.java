package main.db;

public class Account {

    private String pw;
    private String id;
    private String name;
    private int stock;

    public Account(){
    }

    public Account(String id, String pw, String name, int stock) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        //id = AccountController.map.get(id);
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

   @Override
    public boolean equals(Object obj){
        //아이디와 비번이 동일한 경우 true를 리턴
        if(obj instanceof Account){
            Account account = (Account)obj;
            return (id == account.id) && (pw.equals(account.pw));
        }else{
            return false;
        }
    }

    @Override
    public int hashCode() {
        //아이디와 이름이 같다면 동일한 값을 리턴
        return id.hashCode();
    }
}
