import java.util.ArrayList;
import java.util.List;

public class Bank
{
    private final List<BankAccount> bankAccounts;

    Bank()
    {
        bankAccounts = new ArrayList<>();
    }

    public void addAccount(final BankAccount bankAccount)
    {
        bankAccounts.add(bankAccount);
    }

    public BankAccount retrieveAccount(final String accountNumber)
    {
        for(BankAccount bankAccount : bankAccounts)
        {
            if(bankAccount.getAccountNumber().equals(accountNumber))
            {
                return bankAccount;
            }
        }
        throw new IllegalArgumentException("Account not found");
    }

    public int totalBalanceUsd()
    {
        return bankAccounts.stream().mapToInt(BankAccount::getBalanceUsd).sum();
    }
}
