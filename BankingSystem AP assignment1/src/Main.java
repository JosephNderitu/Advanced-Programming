public class Main {
    public static void main(String[] args) throws InsufficientFundsException {  // Declare exception
        BankAccount account = new BankAccount(1000);

        // Test deposit
        TransactionInterface deposit = new DepositTransaction(500);
        deposit.apply(account);
        deposit.printTransactionDetails();

        // Test withdrawal
        WithdrawalTransaction withdrawal = new WithdrawalTransaction(300);
        withdrawal.apply(account);  // No try-catch needed because exception is declared in main
        withdrawal.printTransactionDetails();

        // Test partial withdrawal
        WithdrawalTransaction largeWithdrawal = new WithdrawalTransaction(2000);
        largeWithdrawal.apply(account, true);

        // Test type casting
        BaseTransaction baseTransaction = (BaseTransaction) withdrawal;
        baseTransaction.printTransactionDetails();
    }
}
