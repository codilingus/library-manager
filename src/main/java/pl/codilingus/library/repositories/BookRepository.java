package pl.codilingus.library.repositories;

import pl.codilingus.library.Book;

import java.util.List;

public interface BookRepository {

    void addBook(Book book);

    void deleteBook(int id);

    Book editBook(Book book , int id);

    Book findBookById(int id);

    List<Book> getAllBooks();

    List<Book> getNotBorrowedBooks();
}
