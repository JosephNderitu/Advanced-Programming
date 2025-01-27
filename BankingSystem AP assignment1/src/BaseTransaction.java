import java.util.Calendar;

/**
 * Represents a base implementation of a transaction.
 * Provides common properties and methods for all transactions, including the amount, date,
 * transaction ID, and functionality to print transaction details.
 * 
 * @since 1.0.0
 */
public class BaseTransaction implements TransactionInterface {
    protected double amount; // The amount involved in the transaction
    protected Calendar date; // The date when the transaction was created
    protected String transactionID; // A unique identifier for the transaction

    /**
     * Constructs a new BaseTransaction with the specified amount.
     * Automatically assigns the current date and a unique transaction ID.
     * 
     * @param amount the amount for the transaction. Must be a positive value.
     */
    public BaseTransaction(double amount) {
        this.amount = amount;
        this.date = Calendar.getInstance();
        this.transactionID = generateTransactionID();
    }

    /**
     * Retrieves the amount involved in the transaction.
     * 
     * @return the transaction amount as a double.
     */
    @Override
    public double getAmount() {
        return amount;
    }

    /**
     * Retrieves the date when the transaction was created.
     * 
     * @return a `Calendar` object representing the transaction date.
     */
    @Override
    public Calendar getDate() {
        return date;
    }

    /**
     * Retrieves the unique ID of the transaction.
     * 
     * @return a string representing the transaction ID.
     */
    @Override
    public String getTransactionID() {
        return transactionID;
    }

    /**
     * Prints the details of the transaction, including the ID, amount, and date.
     */
    @Override
    public void printTransactionDetails() {
        System.out.println("Transaction ID: " + transactionID);
        System.out.println("Amount: " + amount);
        System.out.println("Date: " + date.getTime());
    }

    /**
     * Applies the transaction to the specified bank account.
     * This method is a placeholder in the base class and should be overridden by subclasses.
     * 
     * @param ba the bank account to which the transaction will be applied.
     * @throws InsufficientFundsException if there are insufficient funds to process the transaction.
     */
    @Override
    public void apply(BankAccount ba) throws InsufficientFundsException {
        System.out.println("Processing base transaction");
    }

    /**
     * Generates a unique transaction ID based on the current system time.
     * 
     * @return a string representing the generated transaction ID.
     */
    private String generateTransactionID() {
        return "TXN" + System.currentTimeMillis();
    }
}
