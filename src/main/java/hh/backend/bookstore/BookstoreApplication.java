package hh.backend.bookstore;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.backend.bookstore.domain.AppUser;
import hh.backend.bookstore.domain.AppUserRepository;
import hh.backend.bookstore.domain.Book;
import hh.backend.bookstore.domain.BookRepository;
import hh.backend.bookstore.domain.Category;
import hh.backend.bookstore.domain.CategoryRepository;
@SpringBootApplication
public class BookstoreApplication {
    private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(CategoryRepository categoryRepository, BookRepository bookRepository, AppUserRepository appUserRepository) {
        return (args) -> {
            // Add some categories to the database
            Category category1 = new Category("Science Fiction");
            categoryRepository.save(category1);
            Category category2 = new Category("Comic");
            categoryRepository.save(category2);
            Category category3 = new Category("Fantasy");
            categoryRepository.save(category3);
            Category category4 = new Category("Non-fiction");
            categoryRepository.save(category4);

            bookRepository.save(new Book("The Hobbit", "J.R.R. Tolkien", 1937, "978-0261102217", 10.99, category3));
            bookRepository.save(new Book("1984", "George Orwell", 1949, "978-0451524935", 8.99, category1));
            bookRepository.save(new Book("Pride and Prejudice", "Jane Austen", 1813, "978-1503290563", 12.50, category3));

            AppUser user1 = new AppUser("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			AppUser user2 = new AppUser("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			appUserRepository.save(user1);
			appUserRepository.save(user2);

            for (Book book : bookRepository.findAll()){
                log.info(book.toString());
            }
        };
    }
}