import java.io.*;
import java.util.*;

public class passwordmanager {
    private static final String FILE_PATH = "passwords.txt"; // File to store encrypted passwords

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Password Manager!");

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Add a new password");
            System.out.println("2. Retrieve a password");
            System.out.println("3. Delete a password");
            System.out.println("4. Show all accounts");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addPassword(scanner);
                case 2 -> retrievePassword(scanner);
                case 3 -> deletePassword(scanner);
                case 4 -> showAllAccounts();
                case 5 -> {
                    System.out.println("Exiting Password Manager. Stay safe!");
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice! Try again.");
            }
        }
    }

    private static void addPassword(Scanner scanner) {
        System.out.print("Enter account name: ");
        String account = scanner.nextLine().trim();
        System.out.print("Enter password: ");
        String password = scanner.nextLine().trim();

        // Encrypt password using AES
        String encryptedPassword = AESUtil.encrypt(password);

        try (FileWriter writer = new FileWriter(FILE_PATH, true)) {
            writer.write(account + ":" + encryptedPassword + "\n");
            System.out.println("Password saved successfully!");
        } catch (IOException e) {
            System.err.println("Error saving password: " + e.getMessage());
        }
    }

    private static void retrievePassword(Scanner scanner) {
        System.out.print("Enter account name to retrieve password: ");
        String account = scanner.nextLine().trim();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":", 2);
                if (parts[0].equals(account)) {
                    // Decrypt the password using AES
                    String decryptedPassword = AESUtil.decrypt(parts[1]);
                    System.out.println("Password for " + account + ": " + decryptedPassword);
                    return;
                }
            }
            System.out.println("Account not found!");
        } catch (IOException e) {
            System.err.println("Error retrieving password: " + e.getMessage());
        }
    }

    private static void deletePassword(Scanner scanner) {
        System.out.print("Enter account name to delete: ");
        String account = scanner.nextLine().trim();

        File tempFile = new File("temp.txt");
        File originalFile = new File(FILE_PATH);

        try (BufferedReader reader = new BufferedReader(new FileReader(originalFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            boolean found = false;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":", 2);
                if (!parts[0].equals(account)) {
                    writer.write(line + "\n");
                } else {
                    found = true;
                }
            }

            if (found) {
                System.out.println("Account deleted successfully!");
            } else {
                System.out.println("Account not found!");
            }

        } catch (IOException e) {
            System.err.println("Error deleting password: " + e.getMessage());
        }

        if (originalFile.delete() && tempFile.renameTo(originalFile)) {
            // Files successfully updated
        } else {
            System.err.println("Error updating file!");
        }
    }

    private static void showAllAccounts() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            System.out.println("Stored Accounts:");
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":", 2);
                System.out.println("- " + parts[0]);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
