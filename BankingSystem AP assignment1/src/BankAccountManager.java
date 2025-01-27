/**
 * Manages a single instance of a bank account for global access.
 * 
 * This class provides methods to set and retrieve a static `BankAccount` instance,
 * ensuring controlled access to the account.
 * 
 * @since 1.0.0
 */
public class BankAccountManager {
    private static BankAccount accountInstance; // The static instance of the bank account being managed

    /**
     * Sets the static `BankAccount` instance to the specified account.
     * 
     * @param account the `BankAccount` instance to be managed.
     *                Must not be null.
     */
    public static void setAccountInstance(BankAccount account) {
        accountInstance = account;
    }

    /**
     * Retrieves the static `BankAccount` instance.
     * 
     * @return the `BankAccount` instance currently managed.
     * @throws IllegalStateException if no account instance has been set prior to the call.
     */
    public static BankAccount getAccountInstance() {
        if (accountInstance == null) {
            throw new IllegalStateException("No account instance set!");
        }
        return accountInstance;
    }
}
