
public class Main {
    static void main(String[] args) {
        BankAcount b1=new BankAcount(5000,"gigel","dorel",12345456);
        SavingsAccount s=new SavingsAccount(1000,"marcel","bobi",1234565555,500,"12.01.2025");
        try {
            b1.depositAcount(100);
            b1.withdraw(60000);
        }
        catch (InvalidAmountException e){
            System.out.println(e.getMessage());
        }
        catch (InsufficientFundsException e)
        {
            System.out.println(e.getMessage());
        }
    }
}