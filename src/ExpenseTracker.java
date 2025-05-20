import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Scanner;

public class ExpenseTracker {
    public static void main(String[] args) {
        TransactionManager manager = new TransactionManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== Expense Tracker ====");
            System.out.println("1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. Load from File");
            System.out.println("4. Show Monthly Summary");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                case 2:
                    TransactionType type = (choice == 1) ? TransactionType.INCOME : TransactionType.EXPENSE;
                    System.out.print("Enter category (e.g., salary/business or food/rent/travel): ");
                    String category = sc.nextLine();
                    System.out.print("Enter amount: ");
                    double amount = Double.parseDouble(sc.nextLine());
                    System.out.print("Enter date (YYYY-MM-DD): ");
                    LocalDate date = LocalDate.parse(sc.nextLine());
                    manager.addTransaction(new Transaction(type, category, amount, date));
                    break;

                case 3:
                    System.out.print("Enter file name (e.g., data.csv): ");
                    String fileName = sc.nextLine();
                    FileManager.loadFromFile(fileName, manager);
                    break;

                case 4:
                    System.out.print("Enter year and month (YYYY-MM): ");
                    YearMonth ym = YearMonth.parse(sc.nextLine());
                    manager.printMonthlySummary(ym);
                    break;

                case 5:
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}

