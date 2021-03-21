package com.springboot.soap.example.loaders;

import com.springboot.soap.example.domain.BookEntity;
import com.springboot.soap.example.repositories.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BookLoader implements CommandLineRunner {

    private final BookRepository bookRepository;

    public BookLoader(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (bookRepository != null) {
            loadBooks();

        }
    }

    private void loadBooks() {
        if (bookRepository.count() == 0) {
            bookRepository.save(BookEntity.builder()
                    .title("Head first java")
                    .pages(200)
                    .build());

            bookRepository.save(BookEntity.builder()
                    .title("Spring in action")
                    .pages(300)
                    .build());

            bookRepository.save(BookEntity.builder()
                    .title("Learning Python")
                    .pages(150)
                    .build());

            bookRepository.save(BookEntity.builder()
                    .title("Hibernate in action")
                    .pages(400)
                    .build());

            log.info("Loaded books: " + bookRepository.count());
        }

    }
}
