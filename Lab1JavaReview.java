import java.util.Scanner;
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] bookTitles = new String[5];
        String[] bookStatus = new String[5];
        int bookCount = 0;
        int choice = 0;
        do {
            
            System.out.println("HELLO GOOD DAY");
            System.out.println("\n===== CAMPUS LIBRARY SYSTEM =====");
            System.out.println("1. ADD BOOK");
            System.out.println("2. UPDATE BOOK STATUS ");
            System.out.println("3. SHOW ALL BOOKS");
            System.out.println("4. GENERATE REPORT");
            System.out.println("5. EXIT");
            System.out.print("ENTER YOUR CHOICE: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    if (bookCount >= 5) {
                        System.out.println("Cannot add more books. Maximum limit reached.");
                    } else {
                        System.out.print("Enter book title: ");
                        String title = sc.nextLine();
                        bookTitles[bookCount] = title;
                        bookStatus[bookCount] = "Available";
                        bookCount++;
                        System.out.println("Book added successfully!");
                    }
                    break;
                case 2:
                    if (bookCount == 0) {
                        System.out.println("No books to update.");
                    } else {
                        System.out.println("\nList of Books:");
                        for (int i = 0; i < bookCount; i++) {
                            System.out.println((i + 1) + ". " + bookTitles[i] + " - " + bookStatus[i]);
                        }
                        System.out.print("Enter book number to update: ");
                        int bookNumber = sc.nextInt();
                        sc.nextLine();

                        if (bookNumber < 1 || bookNumber > bookCount) {
                            System.out.println("Invalid book number.");
                        } else {
                            int index = bookNumber - 1;
                            if (bookStatus[index].equals("Available")) {
                                bookStatus[index] = "Borrowed";
                            } else {
                                bookStatus[index] = "Available";
                            }
                            System.out.println("Book status updated!");
                        }
                    }
                    break;
                case 3:
                    if (bookCount == 0) {
                        System.out.println("No books available.");
                    } else {
                        System.out.println("\nList of Books:");
                        for (int i = 0; i < bookCount; i++) {
                            System.out.println((i + 1) + ". " + bookTitles[i] + " - " + bookStatus[i]);
                        }
                    }
                    break;
                case 4:
                    int availableCount = 0;
                    int borrowedCount = 0;
                    for (int i = 0; i < bookCount; i++) {
                        if (bookStatus[i].equals("Available")) {
                            availableCount++;
                        } else {
                            borrowedCount++;
                        }
                    }
                    System.out.println("\n=== BOOK REPORT ===");
                    System.out.println("Total books: " + bookCount);
                    System.out.println("Available books: " + availableCount);
                    System.out.println("Borrowed books: " + borrowedCount);
                    break;

                case 5:
                    System.out.println("Thank you for using the CAMPUS LIBRARY SYSTEM !");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}

