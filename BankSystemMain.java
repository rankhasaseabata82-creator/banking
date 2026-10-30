package Banking;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class BankSystemMain {
    public static void logTransaction(String msg){
        try {
            FileWriter writer=new FileWriter("transaction.txt",true);
            writer.write(msg +"\n");
        }
        catch (IOException e){
            System.out.println("file has error"+e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        BankAccount bankAccount;
        SavingsAccount acc=new SavingsAccount("Pitso",1234,"Maseru",2000,80941,040145);
        CurrentAccount acc2=new CurrentAccount("Linda",2344,"Botha_Buthe",809943,4000,040153);

        BankAccount current_acc=acc;

        int choice;
        int Attempts=0;

        System.out.println("Welcome To Lesotho Bank");

        for (Attempts =0; Attempts <= 3; Attempts++) {
            System.out.println("your pin is required");
            int enter_pin=scanner.nextInt();

            if (enter_pin == acc.getPIN() || enter_pin==acc2.getPIN()) {
                System.out.println("Welcome");
                break;
            }
            else {
                System.out.println((3-enter_pin)+"welcome to your savings account");
                if (Attempts==3){
                    System.out.println("account blocked");
                    return;
                }
            }
        }
        do {
            System.out.println("MENU");
            System.out.println("1.Deposit");
            System.out.println("2.Withdraw");
            System.out.println("3.Check Balance");
            System.out.println("4.Transfer Money");
            System.out.println("5.Calculate Interest");
            System.out.println("6.Display Details");
            System.out.println("7.Request Bank Statement");
            System.out.println("8.Request loan");
            System.out.println("9.Swich to Savings Account");
            System.out.println("10.Exit");
            System.out.println("enter your choice");
            choice=scanner.nextInt();

            try{
                switch (choice){
                    case 1:
                        current_acc.deposit();
                        logTransaction("Deposit to "+current_acc.getAcc_number()+" "+"balance"+current_acc.getBalance());
                        break;

                    case 2:
                        current_acc.withdraw();
                        logTransaction("withdraw from"+current_acc.getAcc_number()+" "+"balance"+current_acc.getBalance());
                        break;

                    case 3:
                        current_acc.checkBalance();
                        logTransaction("your balance is"+current_acc.getBalance());
                        break;

                    case 4:
                        current_acc.transfer();
                        logTransaction("transfer from account number"+current_acc.getAcc_number()+" "+"balance"+current_acc.getBalance());
                        break;

                    case 5:
                        current_acc.calculateInterest();
                        break;

                    case 6:
                        current_acc.displayDetails();
                        break;

                    case 7:
                        current_acc.requestBankStat();
                        break;

                    case 8:
                        System.out.println("enter loan amount");
                        double payable_amount=scanner.nextDouble();

                        if(current_acc instanceof Loanable){
                            Loanable loan_acc=(Loanable) current_acc;
                            loan_acc.RequestLoan(payable_amount);
                            logTransaction("Loan request"+payable_amount+" "+"for"+current_acc.getAcc_number());
                        }
                        break;

                    case 9:
                        current_acc =acc2;
                        System.out.println("you have switched to your current account");
                        break;

                    case 10:
                        System.out.println("thank you");
                        break;
                }
            }
            catch (Exception e){
                System.out.println("error"+e.getMessage());
                scanner.nextLine();
            }

        }while (choice !=10);

        scanner.close();
    }


}