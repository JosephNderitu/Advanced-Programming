/**
 * Represents a bank account with a balance that can be accessed and modified.
 * 
 * This class provides basic operations to retrieve and update the balance.
 * 
 * @since 1.0.0
 */
public class BankAccount {
    private double balance; // The current balance of the bank account

    /**
     * Constructs a new BankAccount with the specified initial balance.
     * 
     * @param initialBalance the starting balance of the account. 
     *                       Must be a non-negative value.
     */
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    /**
     * Retrieves the current balance of the bank account.
     * 
     * @return the current balance of the account as a double.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Updates the balance of the bank account to the specified value.
     * 
     * @param balance the new balance to set for the account. 
     *                Can be positive or zero.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
