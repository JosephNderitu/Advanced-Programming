/**
 * Exception thrown when a transaction cannot be completed due to insufficient funds.
 * 
 * This custom exception is used to handle scenarios where an account does not have
 * enough balance to process a withdrawal or other related transactions.
 * 
 * @since 1.0.0
 */
public class InsufficientFundsException extends Exception {
    /**
     * Constructs a new `InsufficientFundsException` with the specified detail message.
     * 
     * @param message a descriptive message providing details about the insufficient funds condition.
     */
    public InsufficientFundsException(String message) {
        super(message);
    }
}
