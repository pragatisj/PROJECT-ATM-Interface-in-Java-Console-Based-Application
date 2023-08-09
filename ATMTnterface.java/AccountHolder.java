

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountHolder {
    private String userId;
    private String userPin;
    private Map<String, Account> accounts;

    public AccountHolder(String userId, String userPin) {
        this.userId = userId;
        this.userPin = userPin;
        this.accounts = new HashMap<>();
    }

    public String getUserId() {
        return userId;
    }

    public String getUserPin() {
        return userPin;
    }

    public Map<String, Account> getAccounts() {
        return accounts;
    }

    public void createAccount(String accountNumber) {
        Account account = new Account(accountNumber);
        accounts.put(accountNumber, account);
    }
}

class BankTransaction {
    public static void showTransactionHistory(Account account) {
        List<String> transactions = account.getTransactions();
        for (String transaction : transactions) {
            System.out.println(transaction);
        }
    }
    
}
