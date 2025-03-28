/**
 *
 */
public class BankAccount
{
    private static final int MIN_TRANSACTION_AMOUNT_CAD = 0;

    private final String accountNumber;

    private int balanceCad;

    /**
     *
     * @param accountNumber
     * @param balanceCad
     */
    public BankAccount(final String accountNumber,
                       final int balanceCad)
    {
        if(accountNumber == null || accountNumber.isBlank())
        {
            throw new IllegalArgumentException("Invalid account number");
        }
        if(balanceCad < MIN_TRANSACTION_AMOUNT_CAD)
        {
            throw new IllegalArgumentException("Balance cannot be negative");
        }

        this.accountNumber = accountNumber;
        this.balanceCad    = balanceCad;
    }

    /**
     *
     * @param amountCad
     */
    public void deposit(final int amountCad)
    {
        if (amountCad < MIN_TRANSACTION_AMOUNT_CAD)
        {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }

        balanceCad += amountCad;
    }

    /**
     *
     * @param amountCad
     */
    public void withdraw(final int amountCad)
    {
        if(amountCad < MIN_TRANSACTION_AMOUNT_CAD)
        {
            throw new IllegalArgumentException("Cannot withdraw negative amount");
        }

        if(amountCad > balanceCad)
        {
            throw new IllegalArgumentException("Insufficient funds");
        }

        balanceCad -= amountCad;
    }

    /**
     *
     * @param destinationAccount
     * @param accountNumber
     * @param depositAmountCad
     */
    public void transferToBank(final BankAccount destinationAccount,
                               final String accountNumber,
                               final int depositAmountCad)
    {


        if(accountNumber.equals(this.accountNumber))
        {
            destinationAccount.deposit(depositAmountCad);
            withdraw(depositAmountCad);
        }
    }

    /**
     *
     * @return
     */
    public String getAccountNumber()
    {
        return accountNumber;
    }

    /**
     *
     * @return
     */
    public int getBalanceUsd()
    {
        return balanceCad;
    }
}