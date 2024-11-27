public class DepositTransaction extends BaseTransaction {
    public DepositTransaction(double amount) {
        super(amount);
    }

    @Override
    public void apply(BankAccount ba) {
        ba.setBalance(ba.getBalance() + amount);
        System.out.println("Deposit of " + amount + " processed successfully");
    }
}
