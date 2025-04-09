import java.util.*;
import java.io.*;

class Library {
    private List<Book> books;
    private List<User> users;
    private static final String BOOKS_FILE = "books.txt";
    private static final String USERS_FILE = "users.txt";

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
        loadBooks();
        loadUsers();
    }

    private void loadBooks() {
        try (BufferedReader br = new BufferedReader(new FileReader(BOOKS_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                books.add(Book.fromString(line));
            }
        } catch (IOException e) {
            System.out.println("No existing book records found.");
        }
    }

    private void loadUsers() {
        try (BufferedReader br = new BufferedReader(new FileReader(USERS_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                users.add(User.fromString(line));
            }
        } catch (IOException e) {
            System.out.println("No existing user records found.");
        }
    }

    private void saveBooks() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(BOOKS_FILE))) {
            for (Book book : books) {
                bw.write(book.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving books.");
        }
    }

    private void saveUsers() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(USERS_FILE))) {
            for (User user : users) {
                bw.write(user.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving users.");
        }
    }

    public void addBook(Book book) {
        books.add(book);
        saveBooks();
    }

    public void registerUser(User user) {
        users.add(user);
        saveUsers();
    }

    public void borrowBook(int userID, int bookID) {
        for (Book book : books) {
            if (book.getBookID() == bookID && book.isAvailable()) {
                book.borrowBook();
                saveBooks();
                System.out.println("Book borrowed successfully.");
                return;
            }
        }
        System.out.println("Book is not available.");
    }

    public void returnBook(int bookID) {
        for (Book book : books) {
            if (book.getBookID() == bookID && !book.isAvailable()) {
                book.returnBook();
                saveBooks();
                System.out.println("Book returned successfully.");
                return;
            }
        }
        System.out.println("Book ID not found.");
    }

    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book.getBookID() + " - " + book.getTitle() + " by " + book.getAuthor() + " (Available: " + book.isAvailable() + ")");
        }
    }
}