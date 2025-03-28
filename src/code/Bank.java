import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Bank
{
    private final List<BankAccount> bankAccounts;

    /**
     *
     */
    Bank()
    {
        bankAccounts = new ArrayList<>();
    }

    /**
     *
     * @param bankAccount
     */
    public void addAccount(final BankAccount bankAccount)
    {
        if(bankAccount == null)
        {
            throw new IllegalArgumentException("Cannot add null account");
        }

        for(BankAccount acc : bankAccounts)
        {
            if(acc.getAccountNumber().equals(bankAccount.getAccountNumber()))
            {
                throw new IllegalArgumentException("Duplicate account number");
            }
        }
        bankAccounts.add(bankAccount);
    }

    /**
     *
     * @param accountNumber
     * @return
     */
    public BankAccount retrieveAccount(final String accountNumber)
    {
        if(accountNumber == null)
        {
            throw new IllegalArgumentException("Cannot retrieve null account");
        }

        for(BankAccount bankAccount : bankAccounts)
        {
            if(bankAccount.getAccountNumber().equals(accountNumber))
            {
                return bankAccount;
            }
        }
        throw new IllegalArgumentException("Account not found");
    }

    /**
     *
     * @return
     */
    public int totalBalanceUsd()
    {
        return bankAccounts.stream().mapToInt(BankAccount::getBalanceUsd).sum();
    }
}