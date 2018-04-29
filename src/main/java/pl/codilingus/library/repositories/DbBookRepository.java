package pl.codilingus.library.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.codilingus.library.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class DbBookRepository implements BookRepository {
    private EntityManager entityManager;

    @Autowired
    public DbBookRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void addBook(Book book) {
        entityManager.persist(book);
    }

    @Override
    @Transactional
    public void deleteBook(int id) {
        entityManager.remove(findBookById(id));
    }

    @Override
    @Transactional
    public Book editBook(Book book, int id) {
        book.setId(id);
        return entityManager.merge(book);
    }

    @Override
    @Transactional
    public Book findBookById(int id) {
        Book book = entityManager.find(Book.class, id);
        if (book == null) {
            throw new EntityNotFoundException("Can't find User for ID "
                    + id);
        }
        return book;
    }

    @Override
    @Transactional
    public List<Book> getAllBooks() {
        Query query = entityManager.createQuery("FROM Book");
        List resultList = query.getResultList();
        return (List<Book>)resultList;
    }

    @Override
    @Transactional
    public List<Book> getNotBorrowedBooks() {
        Query query = entityManager.createQuery("SELECT DISTINCT b FROM Book b LEFT JOIN Order o ON b.id = o.borrowedBook.id " +
                "WHERE o.borrowedBook.id IS NULL OR o.dateOfReturn IS NOT NULL" );
        return (List<Book>)query.getResultList();
    }
}
