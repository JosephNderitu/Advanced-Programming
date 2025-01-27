/**
 * Represents a withdrawal transaction on a bank account.
 * This class supports both full and partial withdrawals and allows reversing a transaction.
 * 
 * @since 1.0.0
 */
public class WithdrawalTransaction extends BaseTransaction {
    private double unprocessedAmount = 0; // Amount that couldn't be processed during partial withdrawal
    private boolean reversed = false; // Prevents multiple reversals of the same transaction

    /**
     * Constructs a new WithdrawalTransaction with the specified amount.
     * 
     * @param amount the amount to withdraw; must be positive.
     */
    public WithdrawalTransaction(double amount) {
        super(amount);
    }

    /**
     * Applies the withdrawal to the given bank account.
     * 
     * @param ba the bank account from which the funds will be withdrawn.
     * @throws InsufficientFundsException if the account's balance is less than the withdrawal amount.
     */
    @Override
    public void apply(BankAccount ba) throws InsufficientFundsException {
        if (ba.getBalance() < amount) {
            throw new InsufficientFundsException("Insufficient funds for withdrawal");
        }
        ba.setBalance(ba.getBalance() - amount);
        System.out.println("Withdrawal of " + amount + " processed successfully");
    }

    /**
     * Applies the withdrawal with an option to withdraw only the available funds.
     * 
     * @param ba the bank account from which the funds will be withdrawn.
     * @param withdrawAvailable if true, withdraws only the available balance in the account.
     *                          If false, attempts to withdraw the full amount.
     */
    public void apply(BankAccount ba, boolean withdrawAvailable) {
        try {
            double balance = ba.getBalance();
            if (balance > 0 && balance < amount) {
                unprocessedAmount = amount - balance;
                ba.setBalance(0);
                System.out.println("Partial withdrawal of " + balance + " processed");
                System.out.println("Unprocessed amount: " + unprocessedAmount);
            } else {
                apply(ba);
            }
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Transaction processing completed");
        }
    }

    /**
     * Reverses the withdrawal transaction, adding the withdrawn amount back to the account.
     * 
     * @return true if the reversal was successful, false if the transaction was already reversed.
     */
    public boolean reverse() {
        if (reversed) {
            System.out.println("Transaction has already been reversed.");
            return false;
        }
        // Undo the withdrawal
        BankAccount account = BankAccountManager.getAccountInstance(); // Placeholder for retrieving account
        account.setBalance(account.getBalance() + amount); // Add amount back to the balance
        System.out.println("Reversal of withdrawal: " + amount + " has been completed.");
        reversed = true; // Mark as reversed
        return true;
    }
}
