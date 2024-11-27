public class WithdrawalTransaction extends BaseTransaction {
    private double unprocessedAmount = 0;

    public WithdrawalTransaction(double amount) {
        super(amount);
    }

    @Override
    public void apply(BankAccount ba) throws InsufficientFundsException {
        if (ba.getBalance() < amount) {
            throw new InsufficientFundsException("Insufficient funds for withdrawal");
        }
        ba.setBalance(ba.getBalance() - amount);
        System.out.println("Withdrawal of " + amount + " processed successfully");
    }

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

    public boolean reverse() {
        // Implementation for reversing withdrawal
        return true;
    }
}
