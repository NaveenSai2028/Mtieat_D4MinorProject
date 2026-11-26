import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        int choice;

        do {
            System.out.println("\n====================================");
            System.out.println("LIBRARY MANAGEMENT SYSTEM");
            System.out.println("====================================");
            System.out.println("1. Add Book");
            System.out.println("2. Display All Books");
            System.out.println("3. Search Book");
            System.out.println("4. Register Student");
            System.out.println("5. Register Faculty");
            System.out.println("6. Display All Members");
            System.out.println("7. Search Member");
            System.out.println("8. Issue Book");
            System.out.println("9. Return Book");
            System.out.println("10. Display Issued Books");
            System.out.println("11. Generate Library Report");
            System.out.println("12. Exit");
            System.out.print("Enter Your Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int bookId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Book Name: ");
                    String bookName = sc.nextLine();
                    System.out.print("Enter Author Name: ");
                    String author = sc.nextLine();
                    System.out.print("Enter Category: ");
                    String category = sc.nextLine();
                    System.out.print("Enter Available Copies: ");
                    int copies = sc.nextInt();
                    if (copies < 0) {
                        System.out.println("Available copies cannot be negative!");
                    } else {
                        library.addBook(new Book(bookId, bookName, author, category, copies));
                    }
                    break;

                case 2:
                    library.displayBooks();
                    break;

                case 3:
                    System.out.print("Enter Book ID to Search: ");
                    int searchBookId = sc.nextInt();
                    library.searchBook(searchBookId);
                    break;

                case 4:
                    System.out.print("Enter Student Member ID: ");
                    int sId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Student Name: ");
                    String sName = sc.nextLine();
                    System.out.print("Enter Contact Number: ");
                    String sContact = sc.nextLine();
                    System.out.print("Enter Department: ");
                    String sDept = sc.nextLine();
                    System.out.print("Enter Year: ");
                    int year = sc.nextInt();
                    library.registerMember(new Student(sId, sName, sContact, sDept, year));
                    break;

                case 5:
                    System.out.print("Enter Faculty Member ID: ");
                    int fId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Faculty Name: ");
                    String fName = sc.nextLine();
                    System.out.print("Enter Contact Number: ");
                    String fContact = sc.nextLine();
                    System.out.print("Enter Department: ");
                    String fDept = sc.nextLine();
                    System.out.print("Enter Designation: ");
                    String designation = sc.nextLine();
                    library.registerMember(new Faculty(fId, fName, fContact, fDept, designation));
                    break;

                case 6:
                    library.displayAllMembers();
                    break;

                case 7:
                    System.out.print("Enter Member ID to Search: ");
                    int searchMemId = sc.nextInt();
                    library.searchMember(searchMemId);
                    break;

                case 8:
                    System.out.print("Enter Member ID: ");
                    int issueMemId = sc.nextInt();
                    System.out.print("Enter Book ID: ");
                    int issueBookId = sc.nextInt();
                    library.issueBook(issueBookId, issueMemId);
                    break;

                case 9:
                    System.out.print("Enter Member ID: ");
                    int retMemId = sc.nextInt();
                    System.out.print("Enter Book ID: ");
                    int retBookId = sc.nextInt();
                    library.returnBook(retBookId, retMemId);
                    break;

                case 10:
                    System.out.print("View (1) All Issue Records or (2) Active Issue Records Only? ");
                    int filter = sc.nextInt();
                    library.displayIssuedBooks(filter == 2);
                    break;

                case 11:
                    library.generateLibraryReport();
                    break;

                case 12:
                    System.out.println("Exiting Library Management System...");
                    break;

                default:
                    System.out.println("Invalid Choice! Please enter 1-12.");
            }
        } while (choice != 12);

        sc.close();
    }
}
