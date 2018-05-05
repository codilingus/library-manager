package pl.codilingus.library;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Entity
@Table(name = "orders")

public class Order {
    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "borrowed_by")
    private User user;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book borrowedBook;
    private LocalDate dateOfBorrow;
    private LocalDate dateToReturn;
    private LocalDate dateOfReturn;

    public Order(User user, Book borrowedBook, LocalDate dateOfBorrow, LocalDate dateToReturn) {
        this.user = user;
        this.borrowedBook = borrowedBook;
        this.dateOfBorrow = dateOfBorrow;
        this.dateToReturn = dateToReturn;
        this.dateOfReturn = null;
    }

    public Order() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBorrowedBook() {
        return borrowedBook;
    }

    public void setBorrowedBook(Book borrowedBook) {
        this.borrowedBook = borrowedBook;
    }

    public LocalDate getDateOfBorrow() {
        return dateOfBorrow;
    }

    public void setDateOfBorrow(LocalDate dateOfBorrow) {
        this.dateOfBorrow = dateOfBorrow;
    }

    public LocalDate getDateToReturn() {
        return dateToReturn;
    }

    public void setDateToReturn(LocalDate dateToReturn) {
        this.dateToReturn = dateToReturn;
    }

    public LocalDate getDateOfReturn() {
        return dateOfReturn;
    }

    public boolean isAfterDeadline() {
        LocalDate now = LocalDate.now();
        return now.isAfter(this.dateToReturn);
    }

    public int daysAfterDeadline() {
        if (dateOfReturn != null) {
            return (int) ChronoUnit.DAYS.between(dateToReturn, dateOfReturn);
        } else {
            return (int) ChronoUnit.DAYS.between(dateOfBorrow, LocalDate.now());
        }
    }
}

