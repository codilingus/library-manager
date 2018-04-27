package pl.codilingus.library.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.codilingus.library.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import java.util.List;

@Component
public class DbBookRepository implements BookRepository {
    private EntityManager entityManager;

    @Autowired
    public DbBookRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void addBook(Book book) {
        entityManager.persist(book);
    }

    @Override
    public void deleteBook(int id) {
        entityManager.remove(id);
    }

    @Override
    public Book editBook(Book book, int id) {
        book.setId(id);
        return entityManager.merge(book);
    }

    @Override
    public Book findBookById(int id) {
        Book book = entityManager.find(Book.class, id);
        if (book == null) {
            throw new EntityNotFoundException("Can't find User for ID "
                    + id);
        }
        return book;
    }

    @Override
    public List<Book> getAllBooks() {
        Query query = entityManager.createQuery("SELECT * FROM book");
        return (List<Book>)query.getResultList();
    }

    @Override
    public List<Book> getNotBorrowedBooks() {
        return null;
    }
}
