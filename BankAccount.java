package Banking;
import java.util.Scanner;

public abstract  class BankAccount {
    private double balance;
    private int acc_number;
    protected int PIN;
    private String names;
    private int ID_number;
    private String address;


//abstract methods
    abstract void deposit();

    abstract  void withdraw();

    abstract void displayDetails();


    abstract void checkBalance();

    abstract void transfer();

    abstract void requestBankStat();

    abstract void calculateInterest();

    abstract void RequestBankLoan();

//constructor
    BankAccount(double balance, int acc_number, int PIN, String names, int ID_number, String address){
        this.balance = balance;
        this.acc_number = acc_number;
        this.PIN = PIN;
        this.names = names;
        this.ID_number = ID_number;
        this.address = address;
    }

    // getters and setters
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getAcc_number() {
        return acc_number;
    }

    public void setAcc_number(int acc_number) {
        this.acc_number = acc_number;
    }

    public int getPIN() {
        return PIN;
    }

    public void setPIN(int PIN) {
        this.PIN = PIN;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public int getID_number() {
        return ID_number;
    }

    public void setID_number(int ID_number) {
        this.ID_number = ID_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
