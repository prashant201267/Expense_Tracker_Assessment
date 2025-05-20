import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class TransactionManager {
    private List<Transaction> transactions = new ArrayList<>();

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public void printMonthlySummary(YearMonth yearMonth) {
        double incomeTotal = 0, expenseTotal = 0;

        System.out.println("\n--- Monthly Summary for " + yearMonth + " ---");
        for (Transaction t : transactions) {
            if (YearMonth.from(t.getDate()).equals(yearMonth)) {
                System.out.printf("%s - %s - %.2f on %s%n",
                    t.getType(), t.getCategory(), t.getAmount(), t.getDate());
                if (t.getType() == TransactionType.INCOME) {
                    incomeTotal += t.getAmount();
                } else {
                    expenseTotal += t.getAmount();
                }
            }
        }

        System.out.printf("Total Income: %.2f%n", incomeTotal);
        System.out.printf("Total Expense: %.2f%n", expenseTotal);
        System.out.printf("Net Balance: %.2f%n", incomeTotal - expenseTotal);
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
