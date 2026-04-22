public class InvalidAmountException extends Exception {
    public InvalidAmountException(int m) {
        super("invalid amount" +m);
    }
}
