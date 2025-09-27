import java.io.*;
import java.util.Scanner;

public class NotesApp {
    static final String FILE_NAME = "notes.txt";

    // Write notes to file
    static void writeNote() {
        Scanner sc = new Scanner(System.in);
        try (FileWriter fw = new FileWriter(FILE_NAME, true)) { // append mode
            System.out.print("Enter your note: ");
            String note = sc.nextLine();
            fw.write(note + "\n");
            System.out.println("✅ Note saved successfully!");
        } catch (IOException e) {
            System.out.println("❌ Error writing to file: " + e.getMessage());
        }
    }

    // Read notes from file
    static void readNotes() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("\n--- Saved Notes ---");
            while ((line = br.readLine()) != null) {
                System.out.println("- " + line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("❌ No notes found. File not created yet.");
        } catch (IOException e) {
            System.out.println("❌ Error reading file: " + e.getMessage());
        }
    }

    // Main menu
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Notes App ---");
            System.out.println("1. Add Note");
            System.out.println("2. View Notes");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> writeNote();
                case 2 -> readNotes();
                case 3 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 3);

        sc.close();
    }
}
