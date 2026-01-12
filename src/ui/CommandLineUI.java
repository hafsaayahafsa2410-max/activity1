package ui;

import app.AppFacade;
import model.Author;
import model.Paper;

import java.util.List;
import java.util.Scanner;

public class CommandLineUI {

    private AppFacade app;
    private Scanner scanner = new Scanner(System.in);

    public CommandLineUI(AppFacade app) {
        this.app = app;
    }

    public void start() {
        boolean running = true;

        while (running) {
            System.out.println("\n==== MAIN MENU ====");
            System.out.println("1. Add Author");
            System.out.println("2. List Authors");
            System.out.println("3. Add Paper");
            System.out.println("4. List Papers");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addAuthor();
                case 2 -> listAuthors();
                case 3 -> addPaper();
                case 4 -> listPapers();
                case 0 -> {
                    running = false;
                    System.out.println("Goodbye!");
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private void addAuthor() {
        System.out.print("Author ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Author name: ");
        String name = scanner.nextLine();

        System.out.print("Author email: ");
        String email = scanner.nextLine();

        Author author = new Author(id, name, email);
        app.saveAuthor(author);

        System.out.println("Author added.");
    }

    private void listAuthors() {
        List<Author> authors = app.listAuthors();
        System.out.println("\n--- AUTHORS ---");
        for (Author a : authors) {
            System.out.println(a);
        }
    }

    private void addPaper() {
        System.out.print("Paper ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Paper title: ");
        String title = scanner.nextLine();

        System.out.print("Publication year: ");
        int year = scanner.nextInt();

        System.out.print("Author ID: ");
        int authorId = scanner.nextInt();
        scanner.nextLine();

        Paper paper = new Paper(id, title, year, authorId);
        app.savePaper(paper);

        System.out.println("Paper added.");
    }

    private void listPapers() {
        List<Paper> papers = app.listPapers();
        System.out.println("\n--- PAPERS ---");
        for (Paper p : papers) {
            System.out.println(p);
        }
    }
}
