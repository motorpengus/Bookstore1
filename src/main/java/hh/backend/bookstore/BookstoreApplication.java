package hh.backend.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.backend.bookstore.domain.Book;
import hh.backend.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(BookRepository bookRepository) {
        return args -> {
            bookRepository.save(new Book("The Hobbit", "J.R.R. Tolkien", 1937, "978-0261102217", 10.99));
            bookRepository.save(new Book("1984", "George Orwell", 1949, "978-0451524935", 8.99));
            bookRepository.save(new Book("Pride and Prejudice", "Jane Austen", 1813, "978-1503290563", 12.50));

            bookRepository.findAll().forEach(System.out::println);
        };
    }
}
