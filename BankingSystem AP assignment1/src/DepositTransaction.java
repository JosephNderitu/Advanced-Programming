/**
 * Represents a deposit transaction.
 * 
 * This class extends the `BaseTransaction` and implements the functionality
 * to deposit a specified amount into a bank account.
 * 
 * @since 1.0.0
 */
public class DepositTransaction extends BaseTransaction {
    /**
     * Constructs a new `DepositTransaction` with the specified amount.
     * 
     * @param amount the amount to be deposited. Must be a positive value.
     */
    public DepositTransaction(double amount) {
        super(amount);
    }

    /**
     * Applies the deposit transaction to the specified bank account.
     * 
     * This method adds the transaction amount to the bank account's balance.
     * 
     * @param ba the `BankAccount` instance to which the deposit will be applied.
     */
    @Override
    public void apply(BankAccount ba) {
        ba.setBalance(ba.getBalance() + amount);
        System.out.println("Deposit of " + amount + " processed successfully");
    }
}
