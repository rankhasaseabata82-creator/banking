package Banking;
import java.util.Scanner;


class CurrentAccount extends BankAccount implements Loanable {
    double amount;
    double amount_limit=5000;
    double overdraft;
    double charge=(amount/getBalance())*amount_limit;
    Scanner scanner=new Scanner(System.in);

//constructor
    CurrentAccount(String names,int PIN,String address,int acc_number,int ID_number,double balance){
       super(balance,acc_number,PIN,names,ID_number,address);
    }
//method overriding
    @Override
    void deposit(){
        System.out.println("enter amount you want to deposit");
         amount=scanner.nextDouble();
         if (amount<10){
             System.out.println("error amount less tha M10 cannot be deposited");
         }
         setBalance(getBalance()+amount);
         System.out.println("deposited"+amount+" "+"new balance"+getBalance());
    }
    @Override
    void withdraw(){
        System.out.println("enter amount you want to withdraw");
        amount=scanner.nextDouble();

        if(getBalance()-amount>amount_limit){
            System.out.println("limit exceeded withdraw failed");
        }
        setBalance(getBalance()-amount);
        System.out.println("withdrawn"+amount+" "+"new balance"+getBalance());
    }
    @Override
    void checkBalance(){
        System.out.println("your balance"+getBalance());
    }
    @Override
    void transfer() {
        System.out.println("enter amount to be transfered");
        double amount_transfer = scanner.nextDouble();
        if (getBalance() - amount_transfer >= 10) {
            setBalance(getBalance() - amount_transfer);
            System.out.println("amount transfer is" + amount_transfer + " " + "new balance" + getBalance());


        }

    }
    @Override
    void calculateInterest(){
       if(amount>10 && amount<100){
           System.out.println("no charges applied");
       }
       setBalance(getBalance()-amount-charge);
       System.out.println("charges"+charge+" "+" new balance"+getBalance());
    }
    @Override
    void displayDetails(){
        System.out.println("names"+getNames());
        System.out.println("address"+getAddress());
        System.out.println("ID number is"+getID_number());
        System.out.println("your account number is"+getAcc_number());
        System.out.println("balance"+getBalance());
    }
    @Override
    void requestBankStat(){
        System.out.println("your names"+getNames());
        System.out.println("your balance"+getNames());

    }
    @Override
    void RequestBankLoan(){
        System.out.println("enter amount to be borrowed");
        overdraft=scanner.nextDouble();

        if (overdraft>20000){
            System.out.println("error you have exceeded the limit");
        }
        setBalance(getBalance()+amount);
        System.out.println("amount borrowed"+amount+" "+"new balance"+getBalance());

    }
    @Override
    public boolean RequestLoan(double amount){
        if (amount<=20000 && amount>0){
            System.out.println("loan approved");
                return true;
        }
        else{
            System.out.println("loan rejected");
            return false;
        }

    }

}
