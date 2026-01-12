package ui;

import app.AppFacade;
import model.Author;
import model.Paper;

import java.util.List;
import java.util.Scanner;

public class CommandLineUI {
    private final AppFacade app;
    private final Scanner scanner;

    public CommandLineUI(AppFacade app) {
        this.app = app;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        boolean running = true;

        while (running) {
            printMainMenu();
            int choice = readInt("Choose an option: ");

            switch (choice) {
                case 1 -> authorMenu();
                case 2 -> paperMenu();
                case 0 -> running = false;
                default -> System.out.println("Invalid choice. Try again.");
            }
        }

        System.out.println("Goodbye!");
    }

    // ---------------- MAIN MENU ----------------
    private void printMainMenu() {
        System.out.println("\n=== MAIN MENU ===");
        System.out.println("1) Manage Authors");
        System.out.println("2) Manage Papers");
        System.out.println("0) Exit");
    }

    // ---------------- AUTHOR MENU ----------------
    private void authorMenu() {
        boolean back = false;

        while (!back) {
            System.out.println("\n=== AUTHOR MENU ===");
            System.out.println("1) Save Author");
            System.out.println("2) Update Author");
            System.out.println("3) Delete Author");
            System.out.println("4) Find Author by ID");
            System.out.println("5) Count Authors");
            System.out.println("6) List Authors Sorted by Name");
            System.out.println("7) Search Authors by Name");
            System.out.println("0) Back");

            int choice = readInt("Choose an option: ");

            switch (choice) {
                case 1 -> saveAuthor();
                case 2 -> updateAuthor();
                case 3 -> deleteAuthor();
                case 4 -> findAuthorById();
                case 5 -> System.out.println("Author count: " + app.countAuthors());
                case 6 -> printList(app.listAuthorsSortedByName());
                case 7 -> searchAuthorsByName();
                case 0 -> back = true;
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void saveAuthor() {
        int id = readInt("Author id: ");
        String name = readLine("Author name: ");
        String email = readLine("Author email: ");

        Author saved = app.saveAuthor(new Author(id, name, email));
        System.out.println("Saved: " + saved);
    }

    private void updateAuthor() {
        int id = readInt("Author id to update: ");
        String name = readLine("New name: ");
        String email = readLine("New email: ");

        Author updated = app.updateAuthor(new Author(id, name, email));
        System.out.println("Updated: " + updated);
    }

    private void deleteAuthor() {
        int id = readInt("Author id to delete: ");
        boolean ok = app.deleteAuthor(id);
        System.out.println(ok ? "Deleted author " + id : "Author not found.");
    }

    private void findAuthorById() {
        int id = readInt("Author id: ");
        Author a = app.findAuthorById(id);
        System.out.println(a != null ? a : "Author not found.");
    }

    private void searchAuthorsByName() {
        String name = readLine("Name to search: ");
        List<Author> results = app.findAuthorsByName(name);
        printList(results);
    }

    // ---------------- PAPER MENU ----------------
    private void paperMenu() {
        boolean back = false;

        while (!back) {
            System.out.println("\n=== PAPER MENU ===");
            System.out.println("1) Save Paper");
            System.out.println("2) Update Paper");
            System.out.println("3) Delete Paper");
            System.out.println("4) Find Paper by ID");
            System.out.println("5) Count Papers");
            System.out.println("6) List Papers Sorted by Title");
            System.out.println("7) Search Papers by Title");
            System.out.println("0) Back");

            int choice = readInt("Choose an option: ");

            switch (choice) {
                case 1 -> savePaper();
                case 2 -> updatePaper();
                case 3 -> deletePaper();
                case 4 -> findPaperById();
                case 5 -> System.out.println("Paper count: " + app.countPapers());
                case 6 -> printList(app.listPapersSortedByTitle());
                case 7 -> searchPapersByTitle();
                case 0 -> back = true;
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void savePaper() {
        int id = readInt("Paper id: ");
        String title = readLine("Paper title: ");
        int year = readInt("Paper year: ");
        int authorId = readInt("Author id (who wrote it): ");

        Paper saved = app.savePaper(new Paper(id, title, year, authorId));
        System.out.println("Saved: " + saved);
    }

    private void updatePaper() {
        int id = readInt("Paper id to update: ");
        String title = readLine("New title: ");
        int year = readInt("New year: ");
        int authorId = readInt("Author id (who wrote it): ");

        Paper updated = app.updatePaper(new Paper(id, title, year, authorId));
        System.out.println("Updated: " + updated);
    }

    private void deletePaper() {
        int id = readInt("Paper id to delete: ");
        boolean ok = app.deletePaper(id);
        System.out.println(ok ? "Deleted paper " + id : "Paper not found.");
    }

    private void findPaperById() {
        int id = readInt("Paper id: ");
        Paper p = app.findPaperById(id);
        System.out.println(p != null ? p : "Paper not found.");
    }

    private void searchPapersByTitle() {
        String title = readLine("Title to search: ");
        List<Paper> results = app.findPapersByTitle(title);
        printList(results);
    }

    // ---------------- HELPERS ----------------
    private int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = scanner.nextLine().trim();
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }

    private String readLine(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private <T> void printList(List<T> list) {
        if (list == null || list.isEmpty()) {
            System.out.println("(no results)");
            return;
        }
        for (T item : list) {
            System.out.println(item);
        }
    }
}
