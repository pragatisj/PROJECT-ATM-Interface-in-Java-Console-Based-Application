import java.util.List;

public class BankTransaction {
    public static void showTransactionHistory(Account account) {
        List<String> transactions = account.getTransactions();
        for (String transaction : transactions) {
            System.out.println(transaction);
        }
    }
    
}
