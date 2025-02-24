package hh.backend.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.backend.bookstore.domain.Book;
import hh.backend.bookstore.domain.BookRepository;
import hh.backend.bookstore.domain.Category;
import hh.backend.bookstore.domain.CategoryRepository;
@SpringBootApplication
public class BookstoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(CategoryRepository categoryRepository, BookRepository bookRepository) {
        return args -> {
            // Add some categories to the database
            categoryRepository.save(new Category("Science Fiction"));
            categoryRepository.save(new Category("Comic"));
            categoryRepository.save(new Category("Fantasy"));
            categoryRepository.save(new Category("Non-fiction"));

            bookRepository.save(new Book("The Hobbit", "J.R.R. Tolkien", 1937, "978-0261102217", 10.99));
            bookRepository.save(new Book("1984", "George Orwell", 1949, "978-0451524935", 8.99));
            bookRepository.save(new Book("Pride and Prejudice", "Jane Austen", 1813, "978-1503290563", 12.50));

            System.out.println("Categories added to the database!");
        };
    }
}