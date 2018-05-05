package pl.codilingus.library;

import java.time.LocalDate;

public class OrderDTO {

    private int user;
    private int borrowedBook;
    private LocalDate dateOfBorrow;
    private LocalDate dateToReturn;
    private LocalDate dateOfReturn;

    public OrderDTO(int user, int borrowedBook, LocalDate dateOfBorrow, LocalDate dateToReturn, LocalDate dateOfReturn) {
        this.user = user;
        this.borrowedBook = borrowedBook;
        this.dateOfBorrow = dateOfBorrow;
        this.dateToReturn = dateToReturn;
        this.dateOfReturn = dateOfReturn;
    }

    public OrderDTO() {
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getBorrowedBook() {
        return borrowedBook;
    }

    public void setBorrowedBook(int borrowedBook) {
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

    public void setDateOfReturn(LocalDate dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }
}