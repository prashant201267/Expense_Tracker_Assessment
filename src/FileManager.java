import java.io.*;
import java.time.LocalDate;

public class FileManager {
    public static void loadFromFile(String fileName, TransactionManager manager) {
        File file = new File(fileName);
        System.out.println("Trying to read: " + file.getAbsolutePath());
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            br.readLine(); // skip header
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                TransactionType type = TransactionType.valueOf(parts[0].toUpperCase());
                String category = parts[1];
                double amount = Double.parseDouble(parts[2]);
                LocalDate date = LocalDate.parse(parts[3]);
                manager.addTransaction(new Transaction(type, category, amount, date));
            }
            System.out.println("File loaded successfully.");
        } catch (Exception e) {
            System.out.println("Failed to read file: " + e.getMessage());
        }
    }
}
