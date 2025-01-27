/**
 * Main class to test the functionality of the banking system.
 * 
 * This class demonstrates the creation of a bank account, deposit and withdrawal
 * transactions, partial withdrawals, reversals, and type casting of transactions.
 * 
 * Author: Gikuru Joseph Nderitu  
 * Registration Number: SCT212-0574/2022  
 * 
 * @since 1.0.0
 */
public class Main {
    /**
     * Main method to execute and test banking system operations.
     * 
     * @param args command-line arguments (not used in this application).
     * @throws InsufficientFundsException if there are insufficient funds during a withdrawal transaction.
     */
    public static void main(String[] args) throws InsufficientFundsException {
        // Create a bank account and register it
        BankAccount account = new BankAccount(1000);
        BankAccountManager.setAccountInstance(account);

        // Test deposit
        TransactionInterface deposit = new DepositTransaction(500);
        deposit.apply(account);
        deposit.printTransactionDetails();
        System.out.println("Balance after deposit: " + account.getBalance());

        // Test withdrawal
        WithdrawalTransaction withdrawal = new WithdrawalTransaction(300);
        withdrawal.apply(account);  // Withdraw 300
        withdrawal.printTransactionDetails();
        System.out.println("Balance after withdrawal: " + account.getBalance());

        // Test partial withdrawal
        WithdrawalTransaction largeWithdrawal = new WithdrawalTransaction(2000);
        largeWithdrawal.apply(account, true);
        System.out.println("Balance after partial withdrawal: " + account.getBalance());

        // Test reversal
        boolean reversed = withdrawal.reverse(); // Reverse the withdrawal
        System.out.println("Reversal successful: " + reversed);
        System.out.println("Balance after reversal: " + account.getBalance());

        // Test type casting
        BaseTransaction baseTransaction = (BaseTransaction) withdrawal;
        baseTransaction.printTransactionDetails();
    }
}
