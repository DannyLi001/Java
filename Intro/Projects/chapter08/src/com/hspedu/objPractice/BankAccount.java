package com.hspedu.objPractice;

public class BankAccount {
    private double balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static void main(String[] args) {
//        CheckingAccount checkingAccount = new CheckingAccount(200);
//        checkingAccount.deposit(100);
//        checkingAccount.withdraw(50);
//        System.out.println(checkingAccount.getBalance());

        SavingsAccount savingsAccount = new SavingsAccount(1000);
        savingsAccount.withdraw(100);
        savingsAccount.withdraw(100);
        savingsAccount.withdraw(100);
        savingsAccount.withdraw(100);
        savingsAccount.eranMonthlyInterest();
        System.out.println(savingsAccount.getBalance());
    }
}

class CheckingAccount extends BankAccount {
    private double fee = 1;

    public CheckingAccount(int balance) {
        super(balance);
        this.fee = fee;
    }

    public void deposit(double account) {
        super.deposit(account - fee);
    }

    public void withdraw(double account) {
        super.withdraw(account + fee);
    }
}

class SavingsAccount extends BankAccount {
    private int count = 3;
    private double rate = 0.01;

    public void eranMonthlyInterest() {
        count = 3;
        super.deposit(getBalance() * rate);
    }


    @Override
    public void deposit(double amount) {
        if (count > 0) {
            super.deposit(amount);
        } else {
            super.deposit(amount - 1);
        }
        count--;
    }

    @Override
    public void withdraw(double amount) {
        if (count > 0) {
            super.withdraw(amount);
        } else {
            super.withdraw(amount + 1);
        }
        count--;
    }

    public SavingsAccount(int balance) {
        super(balance);
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}