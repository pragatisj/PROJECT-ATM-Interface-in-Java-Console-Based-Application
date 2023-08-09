

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<String, AccountHolder> accountHolders;

    public Bank() {
        accountHolders = new HashMap<>();
    }

    public void createAccountHolder(String userId, String userPin) {
        AccountHolder accountHolder = new AccountHolder(userId, userPin);
        accountHolders.put(userId, accountHolder);
    }

    public AccountHolder authenticateUser(String userId, String userPin) {
        AccountHolder accountHolder = accountHolders.get(userId);
        if (accountHolder != null && accountHolder.getUserPin().equals(userPin)) {
            return accountHolder;
        }
        return null;
    }
    
}
