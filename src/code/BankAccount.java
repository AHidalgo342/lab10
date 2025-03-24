public class BankAccount
{
    private final String accountNumber;

    private int balanceCad;

    public BankAccount(final String accountNumber,
                       final int balanceCad)
    {
        this.accountNumber = accountNumber;
        this.balanceCad    = balanceCad;
    }

    public void deposit(final int amountCad)
    {
        balanceCad += amountCad;
    }

    public void withdraw(final int amountCad)
    {
        if(amountCad > balanceCad)
        {
            throw new IllegalArgumentException("Insufficient funds");
        }
        balanceCad -= amountCad;
    }

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

    public String getAccountNumber()
    {
        return accountNumber;
    }

    public int getBalanceUsd()
    {
        return balanceCad;
    }
}
