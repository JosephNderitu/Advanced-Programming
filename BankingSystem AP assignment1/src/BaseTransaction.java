import java.util.Calendar;
public class BaseTransaction implements TransactionInterface {
    protected double amount;
    protected Calendar date;
    protected String transactionID;

    public BaseTransaction(double amount) {
        this.amount = amount;
        this.date = Calendar.getInstance();
        this.transactionID = generateTransactionID();
    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public Calendar getDate() {
        return date;
    }

    @Override
    public String getTransactionID() {
        return transactionID;
    }

    @Override
    public void printTransactionDetails() {
        System.out.println("Transaction ID: " + transactionID);
        System.out.println("Amount: " + amount);
        System.out.println("Date: " + date.getTime());
    }

    @Override
    public void apply(BankAccount ba) throws InsufficientFundsException {
        // Base transaction implementation
        System.out.println("Processing base transaction");
    }

    private String generateTransactionID() {
        return "TXN" + System.currentTimeMillis();
    }
}
