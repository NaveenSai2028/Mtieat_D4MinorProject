import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

public class Library extends LibraryOperations {
    private ArrayList<Book> bookList = new ArrayList<>();
    private ArrayList<LibraryMember> memberList = new ArrayList<>();
    private HashMap<Integer, Book> bookMap = new HashMap<>();
    private LinkedHashMap<Integer, IssueRecord> issueRecords = new LinkedHashMap<>();
    private HashSet<Integer> issuedBookIds = new HashSet<>();
    private int recordCounter = 1;

    // Module 1: Add Book
    @Override
    public void addBook(Book book) {
        if (bookMap.containsKey(book.getBookId())) {
            System.out.println("Error: Book ID " + book.getBookId() + " already exists!");
            return;
        }
        bookList.add(book);
        bookMap.put(book.getBookId(), book);
        System.out.println("Book Added Successfully!");
    }

    // Module 2: Display All Books
    @Override
    public void displayBooks() {
        if (bookList.isEmpty()) {
            System.out.println("No books available in the library.");
            return;
        }
        System.out.println("\n--- ALL LIBRARY BOOKS ---");
        for (Book b : bookList) {
            b.displayBookDetails();
        }
        System.out.println("Total Number of Books: " + bookList.size());

        System.out.println("\n--- BOOKS WITH ZERO AVAILABLE COPIES ---");
        boolean anyZero = false;
        for (Book b : bookList) {
            if (b.getAvailableCopies() == 0) {
                b.displayBookDetails();
                anyZero = true;
            }
        }
        if (!anyZero) {
            System.out.println("None");
        }
    }

    // Module 4: Search Book using HashMap
    public void searchBook(int bookId) {
        Book b = bookMap.get(bookId);
        if (b != null) {
            System.out.println("Book Found:");
            b.displayBookDetails();
        } else {
            System.out.println("Book with ID " + bookId + " does not exist.");
        }
    }

    // Module 3: Register & Manage Members
    public boolean isMemberIdExists(int memberId) {
        for (LibraryMember m : memberList) {
            if (m.getMemberId() == memberId) {
                return true;
            }
        }
        return false;
    }

    public void registerMember(LibraryMember member) {
        if (isMemberIdExists(member.getMemberId())) {
            System.out.println("Error: Member ID " + member.getMemberId() + " already exists!");
            return;
        }
        memberList.add(member);
        System.out.println("Member Registered Successfully!");
    }

    public void displayAllMembers() {
        if (memberList.isEmpty()) {
            System.out.println("No registered members.");
            return;
        }
        System.out.println("\n--- REGISTERED LIBRARY MEMBERS ---");
        for (LibraryMember m : memberList) {
            m.displayMemberDetails(); // Runtime Polymorphism
        }
    }

    public LibraryMember findMember(int memberId) {
        for (LibraryMember m : memberList) {
            if (m.getMemberId() == memberId) {
                return m;
            }
        }
        return null;
    }

    public void searchMember(int memberId) {
        LibraryMember m = findMember(memberId);
        if (m != null) {
            System.out.println("Member Found:");
            m.displayMemberDetails();
        } else {
            System.out.println("Member with ID " + memberId + " not found.");
        }
    }

    // Module 5: Issue Book
    @Override
    public void issueBook(int bookId, int memberId) {
        LibraryMember member = findMember(memberId);
        if (member == null) {
            System.out.println("Error: Member ID " + memberId + " does not exist.");
            return;
        }
        Book book = bookMap.get(bookId);
        if (book == null) {
            System.out.println("Error: Book ID " + bookId + " does not exist.");
            return;
        }
        if (book.getAvailableCopies() <= 0) {
            System.out.println("Error: No available copies left for '" + book.getBookName() + "'.");
            return;
        }

        book.setAvailableCopies(book.getAvailableCopies() - 1);
        IssueRecord record = new IssueRecord(recordCounter++, memberId, bookId, book.getBookName(), "Issued");
        issueRecords.put(record.getRecordId(), record);
