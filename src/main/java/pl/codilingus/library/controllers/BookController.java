package pl.codilingus.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.codilingus.library.Book;
import pl.codilingus.library.repositories.BookRepository;

import java.awt.image.RescaleOp;
import java.util.List;
@RestController
public class BookController {

    @Autowired
    public BookRepository bookRepository;

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    @GetMapping("/book/{id}")
    public Book getBookById(@PathVariable int id ){
        return bookRepository.findBookById(id);

    }

    @PostMapping("/books")
    public ResponseEntity addBook(@RequestBody Book book) {
        bookRepository.addBook(book);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/books/{id}")
    public ResponseEntity editBook(@RequestBody Book book, @PathVariable int id) {
        bookRepository.editBook(book, id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable int id){
        bookRepository.deleteBook(id);
    }
}
