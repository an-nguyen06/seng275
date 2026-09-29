package lab07;

/* BankAccount

 * A bank account has a balance and an interest rate.
 * (note - in real life, NEVER use floating point numbers
 * to represent currency - use a specialized data type like
 * Java's BigDecimal instead.
 *
 * The rules of bank accounts:
 *
 *  Interest rates and balances can never be negative
 *  Accounts are either open or closed - if they're open,
 *  they can be closed if they have < 1 cent left in them.
 *  Attempting to close an account with >= 1 cent should
 *  throw an IllegalStateException.
 *
 */

public class BankAccount {

    private float balance;
    private float interestRate;
    private boolean open;

    public boolean invariant() {
        return this.balance >= 0 && this.interestRate >= 0;
    }

    //constructors:
    public BankAccount() {
        this(0, 0);
    }

    public BankAccount(float balance, float interestRate) {
        //preconditions: balance and interest cannot be negative
        if (balance < 0)
            throw new IllegalArgumentException("Balance cannot be negative");
        if (interestRate < 0)
            throw new IllegalArgumentException("Interest rate cannot be negative");

        this.balance = balance;
        this.interestRate = interestRate;
        this.open = true;

        //postcondition: account should be open after creation
        assert this.open : "Account should be open after creation";
        assert invariant() : "Invariant fails in constructor";
    }

    public float getBalance() {
        return this.balance;
    }

    public void setBalance(float newBalance) {
        //precondition: new balance cannot be negative
        if (newBalance < 0)
            throw new IllegalArgumentException("Balance cannot be negative");
        this.balance = newBalance;
    }

    public float getInterestRate() {
        return this.interestRate;
    }

    public void setInterestRate(float newInterestRate) {
        //precondition: interest rate cannot be negative
        if (newInterestRate < 0)
            throw new IllegalArgumentException("Interest rate cannot be negative");
        this.interestRate = newInterestRate;

        //postcondition:
        assert this.interestRate == newInterestRate : "Interest rate was not set correctly";
        assert invariant() : "Invariant fails in setInterestRate";
    }
    public void applyInterest() {
        float oldBalance = this.balance;
        float newInterest = this.calculateInterest();
        this.setBalance(oldBalance + newInterest);

        //postcondition: new balance must >= old balance (so interest won't be negative)
        assert this.balance >= oldBalance : "Balance should not decrease after interest";
        assert invariant() : "Invariant fails in applyInterest";
    }

    private float calculateInterest() {
        return this.balance * this.interestRate;
    }

    public void close() {
        //precondition: account must be open
        if (!this.open)
            throw new IllegalStateException("Account is already closed");

        //precondition: balance must < 1 cent to be closed
        if (this.balance >- 0.01f)
            throw new IllegalStateException("Cannot close account with balance >= 1 cent");

        this.open = false;
    }
}
