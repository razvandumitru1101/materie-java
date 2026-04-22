public class SavingsAccount extends BankAcount{
    private int depozitLunar;
    private String data;

  public SavingsAccount()
  {
      super();
      depozitLunar=0;
      data="N/A";
  }

    public SavingsAccount(int balance, String nume, String prenume, int iban, int depozitLunar, String data) {
        super(balance, nume, prenume, iban);
        this.depozitLunar = depozitLunar;
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getDepozitLunar() {
        return depozitLunar;
    }

    public void setDepozitLunar(int depozitLunar) {
        this.depozitLunar = depozitLunar;
    }


    @Override
    public void withdraw(int value) {
        super.withdraw(value);
    }

    @Override
    public void depositAcount(int value) throws InvalidAmountException {
        super.depositAcount(value);
    }
}
