import java.util.Calendar;

/**
 * Interface for defining a transaction.
 */
public interface TransactionInterface {
    /**
     * Get the amount involved in the transaction.
     * @return the amount as a double.
     */
    double getAmount();

    /**
     * Get the date of the transaction.
     * @return the date as a Calendar object.
     */
    Calendar getDate();

    /**
     * Get the unique transaction ID.
     * @return the transaction ID as a String.
     */
    String getTransactionID();

    /**
     * Print the details of the transaction.
     */
    void printTransactionDetails();

    /**
     * Apply the transaction to the given bank account.
     * @param ba the bank account to apply the transaction to.
     * @throws InsufficientFundsException if there are insufficient funds for the transaction.
     */
    void apply(BankAccount ba) throws InsufficientFundsException;
}
