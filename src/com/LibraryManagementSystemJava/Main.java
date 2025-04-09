import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Book\n2. Register User\n3. Display Books\n4. Borrow Book\n5. Return Book\n6. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Enter Book ID: ");
                int id = scanner.nextInt();
                scanner.nextLine(); 
                System.out.print("Enter Title: ");
                String title = scanner.nextLine();
                System.out.print("Enter Author: ");
                String author = scanner.nextLine();
                library.addBook(new Book(id, title, author, true));
            } else if (choice == 2) {
                System.out.print("Enter User ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter Name: ");
                String name = scanner.nextLine();
                library.registerUser(new User(id, name));
            } else if (choice == 3) {
                library.displayBooks();
            } else if (choice == 4) {
                System.out.print("Enter User ID: ");
                int userID = scanner.nextInt();
                System.out.print("Enter Book ID: ");
                int bookID = scanner.nextInt();
                library.borrowBook(userID, bookID);
            } else if (choice == 5) {
                System.out.print("Enter Book ID: ");
                int bookID = scanner.nextInt();
                library.returnBook(bookID);
            } else {
                break;
            }
        }
        scanner.close();
    }
}
