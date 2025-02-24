package hh.backend.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.backend.bookstore.domain.Category;
import hh.backend.bookstore.domain.CategoryRepository;
@SpringBootApplication
public class BookstoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(CategoryRepository categoryRepository) {
        return args -> {
            // Add some categories to the database
            categoryRepository.save(new Category("Science Fiction"));
            categoryRepository.save(new Category("Comic"));
            categoryRepository.save(new Category("Fantasy"));
            categoryRepository.save(new Category("Non-fiction"));
            
            // Print a message to confirm the categories have been added
            System.out.println("Categories added to the database!");
        };
    }
}