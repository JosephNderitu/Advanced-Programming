public class BankAccountManager {
    private static BankAccount accountInstance;

    public static void setAccountInstance(BankAccount account) {
        accountInstance = account;
    }

    public static BankAccount getAccountInstance() {
        if (accountInstance == null) {
            throw new IllegalStateException("No account instance set!");
        }
        return accountInstance;
    }
}
