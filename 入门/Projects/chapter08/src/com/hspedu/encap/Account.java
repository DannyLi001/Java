package com.hspedu.encap;

public class Account {
    private String name;
    private double balance;
    private String pass;

    public Account() {
    }

    public Account(String name, double balance, String pass) {
        setBalance(balance);
        setName(name);
        setPass(pass);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && name.length() < 5 && name.length() > 2) {
            this.name = name;
        } else {
            this.name = "N/A";
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance > 20) {
            this.balance = balance;
        } else {
            System.out.println("no balance");
            this.balance = 0;
        }
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        if (pass.length() == 6) {
            this.pass = pass;
        } else {
            System.out.println("invalid pass");
            this.pass = "default";
        }
    }

    public void print() {
        System.out.println(name + " " + balance + " " + pass);
    }
}
