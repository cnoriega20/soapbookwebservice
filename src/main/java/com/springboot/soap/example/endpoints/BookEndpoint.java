package com.springboot.soap.example.endpoints;

import com.springboot.soap.example.jaxb.generated.pojos.GetBookRequest;
import com.springboot.soap.example.jaxb.generated.pojos.GetBookResponse;
import com.springboot.soap.example.repositories.BookRepository;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class BookEndpoint {
    private static final String NAMESPACE_URI = "https://www.java2blog.com/xml/book";

    private final BookRepository bookRepository;

    public BookEndpoint(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getBookRequest")
    @ResponsePayload
    public GetBookResponse getCountry(@RequestPayload GetBookRequest request){
        GetBookResponse response = new GetBookResponse();
        response.setBook(bookRepository.findById(request.getId()));
        return response;
    }

}
