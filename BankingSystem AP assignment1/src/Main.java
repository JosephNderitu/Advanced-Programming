public class Main {
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
