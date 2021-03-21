package com.springboot.soap.example.endpoints;

import com.springboot.soap.example.repositories.BookRepository;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;

@Endpoint
public class BookEndpoint {
    private static final String NAMESPACE_URI = "https://www.java2blog.com/xml/book";

    private final BookRepository bookRepository;

    public BookEndpoint(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


}
