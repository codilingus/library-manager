package pl.codilingus.library;

import java.time.LocalDate;

public class Order {
    private int id;
    private User user;
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

    public boolean isAfterDeadline() {
        LocalDate now = LocalDate.now();
        return now.isAfter(this.dateOfBorrow);
    }
}

