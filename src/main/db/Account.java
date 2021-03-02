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
}
