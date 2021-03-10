package Entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "BookLoan")
public class BookLoan {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false)
    private int loadId;
    private LocalDateTime loanDate;
    private boolean returned;
    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "AppUser_appUser_id")
    private AppUser borrower;
    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "Book_book_id")
    private Book book;

    public BookLoan() {
    }

    public BookLoan(int loadId, LocalDateTime loanDate, boolean returned, AppUser borrower, Book book) {
        this.loadId = loadId;
        this.loanDate = loanDate;
        this.returned = returned;
        this.borrower = borrower;
        this.book = book;
    }

    public int getLoadId() {
        return loadId;
    }

    public void setLoadId(int loadId) {
        this.loadId = loadId;
    }

    public LocalDateTime getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDateTime loanDate) {
        this.loanDate = loanDate;
    }

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    public AppUser getBorrower() {
        return borrower;
    }

    public void setBorrower(AppUser borrower) {
        this.borrower = borrower;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookLoan bookLoan = (BookLoan) o;
        return loadId == bookLoan.loadId && returned == bookLoan.returned && loanDate.equals(bookLoan.loanDate) && borrower.equals(bookLoan.borrower) && book.equals(bookLoan.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loadId, loanDate, returned, borrower, book);
    }

    @Override
    public String toString() {
        return "BookLoan{" +
                "loadId=" + loadId +
                ", loanDate=" + loanDate +
                ", returned=" + returned +
                ", borrower=" + borrower +
                ", book=" + book +
                '}';
    }
}
