package Banking;
import java.util.Scanner;

class SavingsAccount extends BankAccount implements Loanable {
    double amount;
    double interest_rate = 0.05;
    double loan_amount = 50000;
    private Scanner scanner = new Scanner(System.in);

    SavingsAccount(String names, int PIN, String address, double balance, int acc_number, int ID_number) {
        super(balance, acc_number, PIN, names, ID_number, address);
    }

    // using method overriding as part of polymorphism
    @Override
    void deposit() {
        System.out.println("enter amount to be deposited");
        amount = scanner.nextDouble();

        if (amount < 10) {
            System.out.println("error you cannot deposit amount less than M10");
        }
        setBalance(getBalance() + amount);
        System.out.println("amount deposited" + amount + " " + "new balance" + getBalance());

    }

    @Override
    void withdraw() {
        if (amount < 10) {
            System.out.println("amount must be over M10");
        }
        if (getBalance() - amount <= 10) {
            System.out.println("amount needs to be maintained in the account");
            return;
        }
        setBalance(getBalance() + amount);
        System.out.println("deposited :" + amount + " " + "new balance" + getBalance());
    }

    @Override
    void checkBalance() {
        setBalance(amount);
        System.out.println("your balance is :" + getBalance());
    }

    @Override
    void transfer() {
        System.out.println("enter amount to be transfered");
        double amount_transfer = scanner.nextDouble();
        if (getBalance() - amount_transfer >= 10) {
            setBalance(getBalance() - amount_transfer);
            System.out.println("amount transfer is" + amount_transfer + " " + "new balance" + getBalance());
        } else {
            System.out.println("transfer failed");
        }
    }

    @Override
    void calculateInterest() {
        double interest = getBalance() * interest_rate;
        setBalance(getBalance() + interest);
        System.out.println("interest added your new balance is" + getBalance());
    }

    @Override
    void displayDetails() {
        System.out.println("enter your names" + getNames());
        System.out.println("enter your address" + getAddress());
        System.out.println("your account number is" + getAcc_number());
        System.out.println("ID number is" + getID_number());
        System.out.println("your balance" + getBalance());
    }

    @Override
    void requestBankStat() {
        System.out.println("Bank statement for" + getNames());
        System.out.println("Balance is" + getBalance());

    }

    @Override
    void RequestBankLoan() {
        System.out.println("enter amount borrowing");
        loan_amount = scanner.nextDouble();

        if (loan_amount>50000) {
            System.out.println("you cannot borrow more than M50,000");
        }
        setBalance(getBalance() + amount);
        System.out.println("loan is" + amount + " " + "new balance" + getBalance());
    }

    @Override
    public boolean RequestLoan(double amount) {
        if(amount <=50000 && amount>0){
            System.out.println("loan approved");
            return true;
        }
        else {
            System.out.println("loan rejected");
            return false;
        }
    }
}

