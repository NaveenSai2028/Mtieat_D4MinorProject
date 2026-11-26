public class IssueRecord {
    private int recordId;
    private int memberId;
    private int bookId;
    private String bookName;
    private String status; // "Issued" or "Returned"

    public IssueRecord(int recordId, int memberId, int bookId, String bookName, String status) {
        this.recordId = recordId;
        this.memberId = memberId;
        this.bookId = bookId;
        this.bookName = bookName;
        this.status = status;
    }

    public int getRecordId() {
        return recordId;
    }

    public int getMemberId() {
        return memberId;
    }

    public int getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void displayRecord() {
        System.out.println("Record #" + recordId + " | Member ID: " + memberId +
                " | Book ID: " + bookId + " | Book: " + bookName + " | Status: " + status);
    }
}
