package hh.backend.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.backend.bookstore.domain.Book;
import hh.backend.bookstore.domain.BookRepository;

@Controller

public class BookRestController {

    @Autowired
    private BookRepository bookRepository;

    //all books
    @GetMapping("/books")
    public @ResponseBody List<Book> getAllBooks() {
        return (List<Book>) bookRepository.findAll();
    }
    //1 book by id
    @GetMapping("/books/{id}")
    public @ResponseBody Optional<Book> getBookById(@PathVariable(name= "id") Long bookId){
        return bookRepository.findById(bookId);
    }

}
