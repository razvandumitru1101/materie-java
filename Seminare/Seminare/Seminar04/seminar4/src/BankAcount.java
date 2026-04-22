public class BankAcount {

    private int balance;
    private String nume;
    private String prenume;
    private int iban;

    public BankAcount(){}

    public BankAcount(int balance,String nume,String prenume,int iban)
    {
        this.balance=balance;
        this.nume=nume;
        this.prenume=prenume;
        this.iban=iban;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public int getIban() {
        return iban;
    }

    public void setIban(int iban) {
        this.iban = iban;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void depositAcount(int value) throws InvalidAmountException {
        if(value<0)
            throw new InvalidAmountException(value);
        balance+=value;
    }
    public void withdraw(int value){
        if(value>balance)
        {
            throw new InsufficientFundsException("Fonduri insuficiente");
        }
        balance-=value;

    }


}
