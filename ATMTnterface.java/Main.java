

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        ATM atm = new ATM(bank);
        
        // Create sample account holder and accounts
        bank.createAccountHolder("2121", "111");
        AccountHolder accountHolder = bank.authenticateUser("2121", "111");
        accountHolder.createAccount("123");
      
        atm.run();
    }
    
}
